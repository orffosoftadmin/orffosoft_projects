package co.orffosoft.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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
import co.orffosoft.dto.StockItemInwardPNSDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.GoodsReceiptNote_D;
import co.orffosoft.entity.GoodsReceiptNote_H;
import co.orffosoft.entity.ProductVarietyMaster;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("stockItemUploadBean")
@Scope("session")
public class StockItemUploadBean implements Serializable {

	private static final long serialVersionUID = 4578136862113789205L;
	public static final String SERVER_URL = AppUtil.getPortalServerURL();
	private final String INPUT_FORM_LIST_URL = "/pages/printingAndStationary/listStockItemInwardPNS.xhtml?faces-redirect=true;";
	private final String INPUT_FORM_ADD_URL = "/pages/printingAndStationary/createStockItemInwardPNS.xhtml?faces-redirect=true;";
	private final String INPUT_FORM_Edit_URL = "/pages/printingAndStationary/editStockItemInwardPNS.xhtml?faces-redirect=true;";

	@Getter
	@Setter
	EntityMaster entityMaster;

	@Getter
	@Setter
	List<SupplierMaster> supplierMasterList;

	@Getter
	@Setter
	SupplierMaster selectedSupplierMaster;

	@Getter
	@Setter
	List<ProductVarietyMaster> productVarietyList;

	@Autowired
	HttpService httpService;

	@Autowired
	AppPreference appPreference;

	@Getter
	@Setter
	SupplierMaster selectedSupplierMasterTest;

	@Getter
	@Setter
	LazyDataModel<StockItemInwardPNSDTO> stockTransferLazyList;

	@Getter
	@Setter
	StockItemInwardPNSDTO stockTransferLazy;

	@Getter
	@Setter
	StockItemInwardPNSDTO selectedStockItemInwardPNSDTO;

	@Getter
	@Setter
	String supplierCodeName;

	@Getter
	@Setter
	String uom;

	@Autowired
	ErrorMap errorMap;

	@Getter
	@Setter
	int size;

	@Getter
	@Setter
	String description;

	@Getter
	@Setter
	String interestApplicablePayment;

	@Autowired
	LoginBean loginBean;

	@Getter
	@Setter
	ProductVarietyMaster productVarietyMaster;

	@Getter
	@Setter
	List<ProductVarietyMaster> productVarietyMasterList;

	@Getter
	@Setter
	ProductVarietyMaster selectedProductVarietyMaster = new ProductVarietyMaster();

	@Getter
	@Setter
	GoodsReceiptNote_H goodsReceiptNote_H = new GoodsReceiptNote_H();

	@Getter
	@Setter
	GoodsReceiptNote_D goodsReceiptNote_D = new GoodsReceiptNote_D();

	@Getter
	@Setter
	List<GoodsReceiptNote_D> goodsReceiptNote_DList = new ArrayList<>();

	@Getter
	@Setter
	StockItemInwardPNSDTO stockItemInwardPNSDTO = new StockItemInwardPNSDTO();

	@PostConstruct
	public void init() {
		entityMaster = new EntityMaster();
		productVarietyMaster = new ProductVarietyMaster();
		goodsReceiptNote_D = new GoodsReceiptNote_D();
		goodsReceiptNote_DList = new ArrayList<>();
		goodsReceiptNote_H = new GoodsReceiptNote_H();
		selectedStockItemInwardPNSDTO = new StockItemInwardPNSDTO();

	}

	public String showListPage() {
		loadLazyIntRequirementList();
		return INPUT_FORM_LIST_URL;
	}

	public List<SupplierMaster> supplierAutocomplete(String supplierCode) {

		log.info(":::<- Load loadProductVarietyDetails TypeStart ->::: ");
		BaseDTO baseDTO = null;
		try {
			if (supplierCode.trim() != null && !supplierCode.isEmpty()) {
				String url = SERVER_URL + appPreference.getOperationApiUrl()
						+ "/stockItemInwardPNS/autocompletesupplierCode/" + supplierCode;
				log.info("::: loadProductVarietyDetails Controller calling  1 :::");
				baseDTO = httpService.get(url);
				log.info("::: get loadProductVarietyDetails Response :");
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					supplierMasterList = new ArrayList<SupplierMaster>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					supplierMasterList = mapper.readValue(jsonResponse, new TypeReference<List<SupplierMaster>>() {
					});
					log.info("supplierAutocomplete load Successfully " + baseDTO.getTotalRecords());
					log.info("supplierAutocomplete Page Convert Succes -->");
				} else {
					log.warn("supplierAutocomplete Error ");
				}
			}
		} catch (Exception ee) {
			log.error("Exception Occured in supplierAutocomplete load ", ee);
		}

		return supplierMasterList;

	}

	public List<ProductVarietyMaster> itemAutocomplete(String itemName) {

		log.info(":::<- Load itemAutocomplete TypeStart ->::: ");
		BaseDTO baseDTO = null;
		try {
			if (itemName.trim() != null && !itemName.isEmpty()) {
				String url = SERVER_URL + appPreference.getOperationApiUrl()
						+ "/stockItemInwardPNS/autocompleteitemName/" + itemName;
				log.info("::: loadProductVarietyDetails Controller calling  1 :::");
				baseDTO = httpService.get(url);
				log.info("::: get itemAutocomplete Response :");
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					productVarietyMasterList = new ArrayList<ProductVarietyMaster>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					productVarietyMasterList = mapper.readValue(jsonResponse,
							new TypeReference<List<ProductVarietyMaster>>() {
							});
					log.info("itemAutocomplete load Successfully " + baseDTO.getTotalRecords());
					log.info("itemAutocomplete Page Convert Succes -->");
				} else {
					log.warn("itemAutocomplete Error ");
				}
			}
		} catch (Exception ee) {
			log.error("Exception Occured in itemAutocomplete load ", ee);
		}

		return productVarietyMasterList;

	}

	// add Item Edit Details
	public String addItemToTable() {
		log.info("itemCollectiorAddNew Inward received :");

		try {

			if (selectedSupplierMaster == null) {
				log.info(" ==== >>   Invalid selectedSupplierMaster: === >>> ");
				AppUtil.addError(" Please Select Supplier ");
				return null;
			} else if (goodsReceiptNote_D.getProductVarietyMaster() == null) {
				log.info("Invalid Item Datails quantity:");
				AppUtil.addError(" Select Item ");
				return null;
			} else if (goodsReceiptNote_D.getGrn_D_Item_Qnty() == null
					|| goodsReceiptNote_D.getGrn_D_Item_Qnty() <= 0) {
				log.info("Invalid Item Datails quantity:");
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_INVALID_ITEM_QUANTITY.getErrorCode());
				return null;
			} else if (goodsReceiptNote_D.getGrn_D_Selling_Amount() == null
					|| goodsReceiptNote_D.getGrn_D_Selling_Amount() <= 0) {
				log.info("Invalid Item Datails unitRate:");
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_NEW_INVALID_UNIT.getErrorCode());
				return null;
			}

			calculate_Discount_Cgst_Sgst_Formula();

			log.info("Item Collection add Success :");
			goodsReceiptNote_D = new GoodsReceiptNote_D();

			// }
		} catch (Exception e) {
			log.error("StockItemInward Collection Add Error :" + e);
			errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_NEW_ADDED_FAILED.getErrorCode());
		}
		return null;
	}

	private void calculate_Discount_Cgst_Sgst_Formula() {

		// For Purchase Amount Calculation

		if (goodsReceiptNote_D.getGrn_D_Purchase_Amount() != null) {
			goodsReceiptNote_D.setGrn_D_Total_Purchase_Amt(
					goodsReceiptNote_D.getGrn_D_Purchase_Amount() * goodsReceiptNote_D.getGrn_D_Accepted_Qnty());
			if (goodsReceiptNote_D.getGrn_D_Discount_Percentage() != null) {
				if (goodsReceiptNote_D.getGrn_D_Discount_Percentage() > 0) {
					double discountValue = (goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt()
							* goodsReceiptNote_D.getGrn_D_Discount_Percentage()) / 100;
					goodsReceiptNote_D.setGrn_D_Discount_Amount(discountValue);
				}
			} else if (goodsReceiptNote_D.getGrn_D_Discount_Amount() != null) {
				if (goodsReceiptNote_D.getGrn_D_Discount_Amount() > 0) {
					Double discountPercentage = (goodsReceiptNote_D.getGrn_D_Discount_Amount() * 100)
							/ goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt();
					goodsReceiptNote_D
							.setGrn_D_Discount_Percentage((double) Math.round(discountPercentage.doubleValue()));
				}
			}

			// For CGST And SGST CALCULATION

			if (goodsReceiptNote_D.getProductVarietyMaster().getCgst_percentage() != null) {
				Long cGstPercentage = goodsReceiptNote_D.getProductVarietyMaster().getCgst_percentage();
				if (cGstPercentage > 0) {
					double cgstValue = (goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt() * cGstPercentage) / 100;
					goodsReceiptNote_D.setGrn_D_Cgst_Amount(cgstValue);
					goodsReceiptNote_D.setGrn_D_Cgst_Percentage(cGstPercentage);
				}
			}
			// Removed because of cgst and sgst percentage getting from master table
			/*
			 * else if (goodsReceiptNote_D.getGrn_D_Cgst_Amount() != null) { if
			 * (goodsReceiptNote_D.getGrn_D_Cgst_Amount() > 0) { Double cgstPercentage =
			 * (goodsReceiptNote_D.getGrn_D_Cgst_Amount() * 100) /
			 * goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt();
			 * goodsReceiptNote_D.setGrn_D_Cgst_Percentage((double)
			 * Math.round(cgstPercentage.doubleValue())); } }
			 */

			if (goodsReceiptNote_D.getProductVarietyMaster().getSgst_percentage() != null) {
				Long sGstPercentage = goodsReceiptNote_D.getProductVarietyMaster().getSgst_percentage();
				if (sGstPercentage > 0) {
					double sgstValue = (goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt() * sGstPercentage) / 100;
					goodsReceiptNote_D.setGrn_D_Sgst_Amount(sgstValue);
					goodsReceiptNote_D.setGrn_D_Sgst_Percentage(sGstPercentage);
				}
			}
			// Removed because of cgst and sgst percentage getting from master table
			/*
			 * else if (goodsReceiptNote_D.getGrn_D_Sgst_Amount() != null) { if
			 * (goodsReceiptNote_D.getGrn_D_Sgst_Amount() > 0) { Double sgstPercentage =
			 * (goodsReceiptNote_D.getGrn_D_Sgst_Amount() * 100) /
			 * goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt();
			 * goodsReceiptNote_D.setGrn_D_Sgst_Percentage((double)
			 * Math.round(sgstPercentage.doubleValue())); } }
			 */

		}
		if (goodsReceiptNote_D.getGrn_D_Discount_Amount() == null) {
			goodsReceiptNote_D.setGrn_D_Discount_Amount(0D);
		}
		if (goodsReceiptNote_D.getGrn_D_Cgst_Amount() == null) {
			goodsReceiptNote_D.setGrn_D_Cgst_Amount(0D);
		}
		if (goodsReceiptNote_D.getGrn_D_Sgst_Amount() == null) {
			goodsReceiptNote_D.setGrn_D_Sgst_Amount(0D);
		}
		goodsReceiptNote_D.setGrn_D_Net_Amount(
				goodsReceiptNote_D.getGrn_D_Total_Purchase_Amt() - goodsReceiptNote_D.getGrn_D_Discount_Amount()
						+ (goodsReceiptNote_D.getGrn_D_Cgst_Amount() + goodsReceiptNote_D.getGrn_D_Sgst_Amount()));
		goodsReceiptNote_D.setGrn_D_Total_Selling_Amt(
				(goodsReceiptNote_D.getGrn_D_Selling_Amount() * goodsReceiptNote_D.getGrn_D_Accepted_Qnty())
						- goodsReceiptNote_D.getGrn_D_Discount_Amount());

		goodsReceiptNote_DList.add(goodsReceiptNote_D);

	}

	public void loadProductVarietyDetails() {

		log.info(":::<- Load loadProductVarietyDetails TypeStart ->::: ");
		BaseDTO baseDTO = null;
		try {
			String url = SERVER_URL + appPreference.getOperationApiUrl() + "/stockItemInwardPNS/getAllProductVariety/1";
			log.info("::: loadProductVarietyDetails Controller calling  1 :::");
			baseDTO = httpService.get(url);
			log.info("::: get loadProductVarietyDetails Response :");
			if (baseDTO.getStatusCode() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				productVarietyList = new ArrayList<ProductVarietyMaster>();
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				productVarietyList = mapper.readValue(jsonResponse, new TypeReference<List<ProductVarietyMaster>>() {
				});
				log.info("loadProductVarietyDetails load Successfully " + baseDTO.getTotalRecords());
				log.info("loadProductVarietyDetails Page Convert Succes -->");
			} else {
				log.warn("loadPurchaseOrderNumber Error ");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in loadPurchaseOrderNumber load ", ee);
		}
	}

	public String submitData() {

		stockItemInwardPNSDTO.setGoodsReceiptNote_DList(goodsReceiptNote_DList);

		// goodsReceiptNote_H.setGrn_H_Gross_Amount(
		// goodsReceiptNote_DList.stream().mapToDouble(x ->
		// x.getGrn_D_Accepted_Qnty()).sum()
		// * goodsReceiptNote_DList.stream().mapToDouble(x ->
		// x.getGrn_D_Purchase_Amount()).sum());

		goodsReceiptNote_H.setGrn_H_Gross_Amount(
				goodsReceiptNote_DList.stream().mapToDouble(x -> x.getGrn_D_Total_Purchase_Amt()).sum()
						+ goodsReceiptNote_DList.stream()
								.mapToDouble(x -> x.getGrn_D_Cgst_Amount() == null ? 0 : x.getGrn_D_Cgst_Amount()).sum()
						+ goodsReceiptNote_DList.stream()
								.mapToDouble(x -> x.getGrn_D_Sgst_Amount() == null ? 0 : x.getGrn_D_Sgst_Amount())
								.sum());
		goodsReceiptNote_H.setGrn_H_Total_Number(goodsReceiptNote_DList.stream()
				.mapToDouble(x -> x.getGrn_D_Accepted_Qnty() == null ? 0L : x.getGrn_D_Accepted_Qnty()).sum());
		goodsReceiptNote_H.setGrn_H_Discount_Percentage(goodsReceiptNote_DList.stream()
				.mapToDouble(x -> x.getGrn_D_Discount_Percentage() == null ? 0L : x.getGrn_D_Discount_Percentage())
				.sum());
		goodsReceiptNote_H.setGrn_H_Discount_Amount(
				goodsReceiptNote_DList.stream().mapToDouble(x -> x.getGrn_D_Discount_Amount()).sum());
		// goodsReceiptNote_H.setGrn_H_Net_Amount((goodsReceiptNote_H.getGrn_H_Gross_Amount()
		// - goodsReceiptNote_DList.stream().mapToDouble(x ->
		// x.getGrn_D_Discount_Amount()).sum())
		// + (goodsReceiptNote_DList.stream().mapToDouble(x ->
		// x.getGrn_D_Cgst_Amount()).sum()
		// + goodsReceiptNote_DList.stream().mapToDouble(x ->
		// x.getGrn_D_Sgst_Amount()).sum()));
		goodsReceiptNote_H
				.setGrn_H_Net_Amount(goodsReceiptNote_DList.stream().mapToDouble(x -> x.getGrn_D_Net_Amount()).sum());

		goodsReceiptNote_H.setGrn_H_Status("Active");
		goodsReceiptNote_H.setSupplierMaster(selectedSupplierMaster);
		stockItemInwardPNSDTO.setGoodsReceiptNote_H(goodsReceiptNote_H);
		if (selectedStockItemInwardPNSDTO != null) {
			stockItemInwardPNSDTO.setPaymentDueDate(selectedStockItemInwardPNSDTO.getPaymentDueDate());
		}

		log.info(":::<- Start to save Data->:::");

		BaseDTO baseDTO = null;
		try {
			String url = SERVER_URL + appPreference.getOperationApiUrl() + "/stockItemInwardPNS/save";
			log.info("::: saveStockInwardAll Controller calling  1 :::");

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(stockItemInwardPNSDTO);
			System.out.println(json);
			baseDTO = httpService.post(url, stockItemInwardPNSDTO);
			log.info("::: get saveStockInwardAll Response :");
			if (baseDTO.getStatusCode() == 0) {
				log.info("saveStockInwardAll Page Convert Succes -->");
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_SUCCESS.getErrorCode());
				return INPUT_FORM_LIST_URL;
			} else {
				log.warn("saveStockInwardAll Error *** :");
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_ERROR.getErrorCode());
			}
		} catch (Exception ee) {
			errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_EXCEPTION.getErrorCode());
			log.error("Exception Occured in saveStockInwardAll load ", ee);
		}

		return null;
	}

	// lazy search
	public void loadLazyIntRequirementList() {
		log.info("<--- loadLazyStockTransfer RequirementList ---> ");
		stockTransferLazyList = new LazyDataModel<StockItemInwardPNSDTO>() {
			private static final long serialVersionUID = -1540942419672760421L;

			@Override
			public List<StockItemInwardPNSDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				List<StockItemInwardPNSDTO> data = new ArrayList<StockItemInwardPNSDTO>();
				try {
					BaseDTO baseDTO = getSearchData(first / pageSize, pageSize, sortField, sortOrder, filters);

					ObjectMapper mapper = new ObjectMapper();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());

					data = mapper.readValue(jsonResponse, new TypeReference<List<StockItemInwardPNSDTO>>() {
					});

					if (data != null) {
						this.setRowCount(baseDTO.getTotalRecords());
						log.info("<--- List Count --->  " + baseDTO.getTotalRecords());
						size = baseDTO.getTotalRecords();
					}
				} catch (Exception e) {
					log.error("Error in loadLazyStockTransfer RequirementList()  ", e);
				}
				return data;
			}

			@Override
			public Object getRowKey(StockItemInwardPNSDTO res) {
				return res != null ? res.getGrnHID() : null;
			}

			@Override
			public StockItemInwardPNSDTO getRowData(String rowKey) {
				List<StockItemInwardPNSDTO> responseList = (List<StockItemInwardPNSDTO>) getWrappedData();
				Long value = Long.valueOf(rowKey);
				for (StockItemInwardPNSDTO res : responseList) {
					if (res.getGrnHID().longValue() == value.longValue()) {
						return res;
					}
				}
				return null;
			}

		};
	}

	public BaseDTO getSearchData(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) throws ParseException {

		stockTransferLazy = new StockItemInwardPNSDTO();

		BaseDTO baseDTO = new BaseDTO();
		log.info("page:[" + first + "] " + "pageSize:[" + pageSize + "] " + "sortOrder:[" + sortOrder + "] "
				+ "sortField:[" + sortField + "]");

		StockItemInwardPNSDTO yarnRequirement = new StockItemInwardPNSDTO();

		PaginationDTO paginationDTO = new PaginationDTO(first, pageSize, sortField, sortOrder.toString());
		// yarnRequirement.setPaginationDTO(paginationDTO);

		// yarnRequirement.setFilters(filters);

		try {
			String URL = SERVER_URL + appPreference.getOperationApiUrl() + "/stockItemInwardPNS/searchData";
			baseDTO = httpService.post(URL, yarnRequirement);
		} catch (Exception e) {
			errorMap.notify(ErrorDescription.INTERNAL_ERROR.getCode());
			log.error("Exception in getSearchData() ", e);
		}

		return baseDTO;
	}

	public String clearButton() {
		log.info("Clear Action Called");
		selectedStockItemInwardPNSDTO = new StockItemInwardPNSDTO();
		// FacesContext.getCurrentInstance().getExternalContext().redirect(INPUT_FORM_LIST_URL);
		return INPUT_FORM_LIST_URL;
	}

	public void getStockTransferByID() {
		try {
			BaseDTO baseDTO = null;
			StockItemInwardPNSDTO stockItemInwardPNSDTO = new StockItemInwardPNSDTO();
			// log.info("Retrieved tockTransferByID :" +
			// selectedStockItemInwardPNSDTO.getSupplierCodeName());
			String url = SERVER_URL + appPreference.getOperationApiUrl()
					+ "/stockItemInwardPNS/getSelectedStockTransferRetrieved";
			log.info("::: Item tockTransferByID Controller calling :::");
			baseDTO = httpService.post(url, selectedStockItemInwardPNSDTO);
			log.info("::: get Item Retrieved Details Response :");
			if (baseDTO.getStatusCode() == 0) {
				log.info("Item tockTransferByID Successfully Processed ******");
				ObjectMapper mapper = new ObjectMapper();
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				stockItemInwardPNSDTO = mapper.readValue(jsonResponse, new TypeReference<StockItemInwardPNSDTO>() {
				});

				// selectedStockTransferPNS = stockItemInwardPNSDTO.getSelectedStockTransfer();

				log.info("Item tockTransferByID Successfully Completed ******");

				// selectedStockItemInwardPNSDTO.setGstNumber(selectedStockTransferPNS.getSupplierMaster().getGstNumber());

			} else {
				log.error("tockTransferByID Details Error *** :");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in tockTransferByID load ", ee);
		}
		log.info("Done Item tockTransferByID ");
	}

	public String delete() {
		log.info("Delete StockTransfer Received " + selectedStockItemInwardPNSDTO.getId());
		try {

			BaseDTO baseDTO = null;

			String url = SERVER_URL + appPreference.getOperationApiUrl() + "/stockItemInwardPNS/deleteStockTransfer";
			log.info("::: Item Delete Controller calling :::");
			baseDTO = httpService.post(url, selectedStockItemInwardPNSDTO);
			log.info("::: Retrieved Delete :");
			if (baseDTO.getStatusCode() == 0) {
				log.warn("Delete StockTransfer Successfully Completed ******");
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_DELETE_SUCCESS.getErrorCode());
				selectedStockItemInwardPNSDTO = new StockItemInwardPNSDTO();
				return INPUT_FORM_LIST_URL;
			} else {
				errorMap.notify(ErrorDescription.STOCK_ITEM_INWARD_PNS_DELETE_ERROR.getErrorCode());
				log.warn("Delete StockTransfer Error *** :");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in Delete StockTransfer", ee);
		}
		return null;
	}

	public String createNewStockItemInward() {
		try {
			log.info("Received Create ItemInward ");
			init();
			// FacesContext.getCurrentInstance().getExternalContext().redirect(INPUT_FORM_ADD_URL);
			return INPUT_FORM_ADD_URL;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// product category -> 4
	public void productVarietyMasterList() {
		log.info("Received productVarietyMasterList ");
		productVarietyMasterList = new ArrayList<ProductVarietyMaster>();
		try {
			BaseDTO baseDTO = null;
			String url = SERVER_URL + appPreference.getOperationApiUrl()
					+ "/stockItemInwardPNS/getAllProductVarietyMasterList";
			baseDTO = httpService.get(url);
			log.info("::: Retrieved productVarietyMasterList :");
			if (baseDTO.getStatusCode() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				productVarietyMasterList = mapper.readValue(jsonResponse,
						new TypeReference<List<ProductVarietyMaster>>() {
						});
			} else {
				log.warn("productVarietyMasterList Error *** :");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in productVarietyMasterList load ", ee);
		}
	}

	public void removeListFromTable(GoodsReceiptNote_D d) {

		if (goodsReceiptNote_DList.contains(d)) {
			goodsReceiptNote_DList.remove(d);
		}

	}

	public void checkSelleingPrice() {
		if (goodsReceiptNote_D.getGrn_D_Purchase_Amount() >= goodsReceiptNote_D.getGrn_D_Selling_Amount()) {
			AppUtil.addError(" Selling Price Should Not be Lesser Than Purchase Price");
			goodsReceiptNote_D.setGrn_D_Selling_Amount(null);
		}
	}

	// Edit selected ItemInward PNS
	public String itemReceiveRetrieveDetailsEdit() {
		log.info("Received Item Retrieved Details ");
		try {
			// reset();
			// stockTransferItemsInwardDeleteList = new ArrayList<StockTransferItems>();
			// selectedStockTransferItemsList = new ArrayList<StockTransferItems>();
			BaseDTO baseDTO = null;
			// log.info("Retrieved SupplierCode :" +
			// selectedStockItemInwardPNSDTO.getSupplierCodeName());
			String url = SERVER_URL + appPreference.getOperationApiUrl()
					+ "/stockItemInwardPNS/getSelectedStockItemRetrieved";
			log.info("::: Item Retrieved Details Controller calling :::");
			baseDTO = httpService.post(url, selectedStockItemInwardPNSDTO);
			log.info("::: get Item Retrieved Details Response :");
			if (baseDTO.getStatusCode() == 0) {
				log.info("Item Retrieved Details Successfully Completed ******");
				ObjectMapper mapper = new ObjectMapper();

				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				// selectedStockTransferItemsList = mapper.readValue(jsonResponse,
				// new TypeReference<List<StockTransferItems>>() {
				// });
				getStockTransferByID();
				return INPUT_FORM_Edit_URL;
			} else {
				log.error("Item Retrieved Details Error *** :");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in Item Retrieved Details load ", ee);
		}
		log.info("Done Item Retrieved Details ");
		return null;
	}

	public void updategst() {

		if (goodsReceiptNote_D != null) {

		}
	}

}
