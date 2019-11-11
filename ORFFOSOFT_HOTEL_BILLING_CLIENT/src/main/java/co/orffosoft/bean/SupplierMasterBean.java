package co.orffosoft.bean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppPreference;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.PaginationDTO;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Scope("session")
@Service("supplierMasterBean")
public class SupplierMasterBean {

	private final String CREATE_SUPPLIER_MASTER = "/pages/masters/createSupplierMaster.xhtml?faces-redirect=true;";

	private final String LIST_SUPPLIER_MASTER = "/pages/masters/listSupplierMaster.xhtml?faces-redirect=true;";

	private final String VIEW_SUPPLIER_MASTER = "/pages/masters/viewSupplierMaster.xhtml?faces-redirect=true;";

	@Autowired
	ErrorMap errorMap;

	@Autowired
	HttpService httpService;
	ObjectMapper mapper;

	String jsonResponse;

	@Getter
	@Setter
	private String action;

	@Autowired
	AppPreference appPreference;

	@Getter
	@Setter
	SupplierMaster supplierMaster, selectedSupplierMaster;

	@Getter
	@Setter
	private int supplierMasterListSize;

	@Getter
	@Setter
	LazyDataModel<SupplierMaster> supplierMasterList;

	@Getter
	@Setter
	int size;

	@Getter
	@Setter
	boolean addButtonFlag = false;

	@Autowired
	LanguageBean languageBean;

	public String addPage() {
		log.info("<---- Inside gotoCreateSupplierForm ---->");
		supplierMaster = new SupplierMaster();
		return CREATE_SUPPLIER_MASTER;
	}

	public String cancel() {
		log.info("<----cancel---->");
		supplierMaster = new SupplierMaster();
		loadLazySupplierList();

		return LIST_SUPPLIER_MASTER;

	}

	public String showList() {
		log.info("<--- Loading supplierMasterBean showList list page --->");
		loadLazySupplierList();

		return LIST_SUPPLIER_MASTER;
	}

	public void loadLazySupplierList() {
		log.info("<--- loadLazySupplierList ---> ");

		supplierMasterList = new LazyDataModel<SupplierMaster>() {

			private static final long serialVersionUID = -1540942419672760421L;

			@Override
			public List<SupplierMaster> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				List<SupplierMaster> data = new ArrayList<SupplierMaster>();
				try {
					BaseDTO baseDTO = getSearchData(first / pageSize, pageSize, sortField, sortOrder, filters);

					ObjectMapper mapper = new ObjectMapper();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());

					data = mapper.readValue(jsonResponse, new TypeReference<List<SupplierMaster>>() {
					});

					if (data != null) {
						this.setRowCount(baseDTO.getTotalRecords());
						log.info("<--- List Count --->  " + baseDTO.getTotalRecords());
						size = baseDTO.getTotalRecords();
					}
				} catch (Exception e) {
					log.error("Error in loadLazySupplierList()  ", e);
				}
				return data;
			}

			@Override
			public Object getRowKey(SupplierMaster res) {
				return res != null ? res.getId() : null;
			}

			@Override
			public SupplierMaster getRowData(String rowKey) {
				List<SupplierMaster> responseList = (List<SupplierMaster>) getWrappedData();
				Long value = Long.valueOf(rowKey);
				for (SupplierMaster res : responseList) {
					if (res.getId().longValue() == value.longValue()) {
						supplierMaster = res;
						return res;
					}
				}
				return null;
			}

		};
	}

	public BaseDTO getSearchData(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) throws ParseException {

		supplierMaster = new SupplierMaster();

		BaseDTO baseDTO = new BaseDTO();
		log.info("page:[" + first + "] " + "pageSize:[" + pageSize + "] " + "sortOrder:[" + sortOrder + "] "
				+ "sortField:[" + sortField + "]");

		SupplierMaster supplierMaster = new SupplierMaster();

		PaginationDTO paginationDTO = new PaginationDTO(first, pageSize, sortField, sortOrder.toString());
		supplierMaster.setPaginationDTO(paginationDTO);

		log.info("supplierMaster  " + supplierMaster);
		supplierMaster.setFilters(filters);

		try {
			String supplierMasterSearchUrl = appPreference.getPortalServerURL() + "/supplier/master/search";
			log.info("Supplier Master Search Url " + supplierMasterSearchUrl);
			baseDTO = httpService.post(supplierMasterSearchUrl, supplierMaster);
		} catch (Exception e) {
			errorMap.notify(ErrorDescription.INTERNAL_ERROR.getCode());
			log.error("Exception in getSearchData() ", e);
		}

		return baseDTO;
	}

	public void onRowSelect(SelectEvent event) {
		log.info("FDS Plan onRowSelect method started");
		supplierMaster = ((SupplierMaster) event.getObject());
		addButtonFlag = true;
	}

	public void onPageLoad() {
		log.info("FDS Plan onPageLoad method started");
		addButtonFlag = false;
	}

	public String submitSupplierMaster() {
		log.info("...... supplierMasterBean submit begin ....");
		BaseDTO baseDTO = null;
		try {
			baseDTO = httpService.post(appPreference.getPortalServerURL() + "/supplier/master/create", supplierMaster);

			if (baseDTO != null) {
				if (baseDTO.getStatusCode() == 0) {
					log.info("supplierMasterBean saved successfully");
					AppUtil.addInfo("Supplier Master saved successfully");
					showList();
				} else {
					log.error("Status code:" + baseDTO.getStatusCode() + " Error Message: "
							+ baseDTO.getErrorDescription());
					errorMap.notify(baseDTO.getStatusCode());
					return CREATE_SUPPLIER_MASTER;
				}
			}

		} catch (Exception e) {
			log.error("Error while creating supplierMaster" + e);
		}
		return LIST_SUPPLIER_MASTER;
	}

	/*
	 * public boolean checkValidation(boolean valid) {
	 * 
	 * try { if (supplierMaster.getGstNumber().length() >= 15) { String subString =
	 * supplierMaster.getGstNumber().substring(0,
	 * supplierMaster.getAddressMaster().getStateMaster().getGstStateCode().length()
	 * ); String gstinNumber = supplierMaster.getGstNumber();
	 * 
	 * String alphabets = gstinNumber.substring(2, 7); String numeric =
	 * gstinNumber.substring(7, 11); String oneAlphabets =
	 * String.valueOf(gstinNumber.charAt(11)); String oneAlphanum =
	 * String.valueOf(gstinNumber.charAt(12)); String oneAlphabets1 =
	 * String.valueOf(gstinNumber.charAt(13)); String oneAlphanum1 =
	 * String.valueOf(gstinNumber.charAt(14));
	 * System.out.println(">>>>>>>>   lenght " + subString.length() +
	 * "=============>>> ");
	 * 
	 * if (!Pattern.matches("[0-9]{1,2}", subString)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[a-zA-Z]{1,5}", alphabets)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[0-9]{1,4}", numeric)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[a-zA-Z]{1}", oneAlphabets)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[a-zA-Z0-9]{1}", oneAlphanum)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[a-zA-Z]{1}", oneAlphabets1)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } if
	 * (!Pattern.matches("[a-zA-Z0-9]{1}", oneAlphanum1)) {
	 * AppUtil.addWarn("Enter Valid GST"); return false; } }
	 * 
	 * } catch (Exception e) { log.info("Exception Occured In checkValidation" + e);
	 * } return valid;
	 * 
	 * }
	 */

	public String updateSupplierMaster() {
		log.info("...... supplierMasterBean update begin ....");
		BaseDTO baseDTO = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(supplierMaster);
			System.out.println(" "+json);
			String URL = appPreference.getPortalServerURL() + "/supplier/master/update";
			baseDTO = httpService.post(URL , supplierMaster);

			if (baseDTO != null) {
				if (baseDTO.getStatusCode() == 0) {
					log.info("supplierMasterBean updated successfully");
					AppUtil.addInfo("Supplier Master Updated successfully");
					showList();
				} else {
					log.error("Status code:" + baseDTO.getStatusCode() + " Error Message: "
							+ baseDTO.getErrorDescription());
					errorMap.notify(baseDTO.getStatusCode());
					return CREATE_SUPPLIER_MASTER;
				}
			}
		} catch (Exception e) {
			log.error("Error while update supplierMaster" + e);
		}
		return LIST_SUPPLIER_MASTER;
	}

	public String delete() {
		log.info("...... supplierMasterBean delete begin ....");

		if (supplierMaster == null) {
			log.info("Please Any One");
			AppUtil.addWarn("Please Any One");
			return null;
		}

		if (supplierMaster != null && supplierMaster.getActiveStatus()) {
			log.info("Activated Supplier Cannot be Deleted");
			AppUtil.addWarn("Activated Supplier Cannot be Deleted , Please Change to InActive Status");
			return null;
		}

		BaseDTO baseDTO = null;
		try {

			String deletePath = appPreference.getPortalServerURL() + "/supplier/master/delete/"
					+ supplierMaster.getId();
			log.info(" deletePath " + deletePath);

			baseDTO = httpService.get(deletePath);

			if (baseDTO != null) {
				log.info("supplierMasterBean Deleted successfully");
				AppUtil.addInfo("Supplier Master Deleted successfully");
				showList();
			}

		} catch (Exception e) {
			log.error("Error while Deleting supplierMaster" + e);
		}
		return LIST_SUPPLIER_MASTER;
	}

	public String editPage() {
		log.info(" Inside gotoView()");

		BaseDTO baseDTO = null;
		if (supplierMaster == null) {
			log.info("Please Any One");
			AppUtil.addWarn("Please Any One");
			return null;
		}

		try {

			String getByIdPath = appPreference.getPortalServerURL() + "/supplier/master/get/" + supplierMaster.getId();
			log.info(" getByIdPath " + getByIdPath);

			baseDTO = httpService.get(getByIdPath);

			ObjectMapper mapper = new ObjectMapper();

			String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
			supplierMaster = mapper.readValue(jsonResponse, new TypeReference<SupplierMaster>() {
			});

		}

		catch (Exception e) {
			log.error("Error while gotoView supplierMaster" + e);
		}

		if ("EDIT".equalsIgnoreCase(action)) {
			return CREATE_SUPPLIER_MASTER;
		}
		return VIEW_SUPPLIER_MASTER;
	}

}
