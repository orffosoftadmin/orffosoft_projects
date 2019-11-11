package co.orffosoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppPreference;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerBillingDTO;
import co.orffosoft.entity.Bill_D;
import co.orffosoft.entity.Bill_H;
import co.orffosoft.entity.CustomerMaster;
import co.orffosoft.entity.ProductVarietyMaster;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("customerBillingBean")
@Scope("session")
public class CustomerBillingBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3927409251841374148L;

	private final String BILLING_CB_PAGE = "/pages/billing/createCustomerBilling.xhtml?faces-redirect=true;";

	private final String BILLING_WCB_PAGE = "/pages/billing/createCustomerBilling.xhtml?faces-redirect=true;";

	@Getter
	@Setter
	List<CustomerMaster> customerMasterlist = new ArrayList<>();

	@Getter
	@Setter
	String customerBillingType;

	@Getter
	@Setter
	boolean customer = false;

	@Getter
	@Setter
	CustomerMaster customerMaster = new CustomerMaster();

	@Getter
	@Setter
	List<CustomerBillingDTO> customerBillingDTOList;

	@Getter
	@Setter
	List<CustomerBillingDTO> customerBillingDTOItemList;

	@Getter
	@Setter
	Bill_H bill_H = new Bill_H();

	@Getter
	@Setter
	Bill_D bill_D = new Bill_D();

	@Getter
	@Setter
	CustomerMaster selectedcustomerMaster = new CustomerMaster();

	@Getter
	@Setter
	CustomerBillingDTO customerBillingDTO = new CustomerBillingDTO();

	@Autowired
	HttpService httpService;

	@Autowired
	AppPreference appPreference;

	@Getter
	@Setter
	Date billDate;

	public static final String SERVER_URL = AppUtil.getPortalServerURL();

	@Getter
	@Setter
	ProductVarietyMaster productVarietyMaster;

	@Getter
	@Setter
	List<ProductVarietyMaster> productVarietyMasterList;

	@Getter
	@Setter
	String pageAction;
	
	@Getter
	@Setter
	Boolean disabledCustomer = true;

	/**
	 * 
	 */
	private void loadvalues() {
		// currentDate = new Date();
	}

	/**
	 * This Method Calls When 1st Request Getting On Customer Billing Page
	 * 
	 * @return
	 */
	public String showBillingPage() {
		customerMasterlist = new ArrayList<>();
		customerBillingDTOList = new ArrayList<>();
		customerBillingDTOItemList = new ArrayList<>();
		customerMaster = new CustomerMaster();
		selectedcustomerMaster = new CustomerMaster();
		productVarietyMaster = new ProductVarietyMaster();
		customerBillingDTO = new CustomerBillingDTO();
		customerBillingDTOList.add(customerBillingDTO);
		billDate = new Date();
		bill_H = new Bill_H();
		bill_D = new Bill_D();
		customerBillingType = "WITH_CUSTOMER";
		return BILLING_CB_PAGE;

	}

	/**
	 * This Method Used To Clear Talbe Values
	 */
	private void clear() {
		customerMasterlist = new ArrayList<>();
		customerMaster = new CustomerMaster();
		selectedcustomerMaster = new CustomerMaster();
	}

	/**
	 * This Method Used To Load Customer Information Based On Mobile Search
	 * 
	 * @param mobileNo
	 * @return
	 */
	public List<CustomerMaster> mobileAutocomplete(String mobileNo) {

		log.info(":::<- Load mobileAutocomplete TypeStart ->::: ");
		BaseDTO baseDTO = null;
		try {
			if (mobileNo.trim() != null && !mobileNo.isEmpty()) {
				String url = SERVER_URL + "/customerbillingcontroller/autocompletemobile/" + mobileNo;
				baseDTO = httpService.get(url);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					customerMasterlist = new ArrayList<CustomerMaster>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					customerMasterlist = mapper.readValue(jsonResponse, new TypeReference<List<CustomerMaster>>() {
					});
				} else {
					log.warn("mobileAutocomplete Error ");
				}
			}
		} catch (Exception ee) {
			log.error("Exception Occured in supplierAutocomplete load ", ee);
		}

		return customerMasterlist;

	}

	/**
	 * This Method Used To Save Billing Information And used for Print Bill Receipt
	 */
	public void billPrint() {

		log.info(":::<- Load billPrint Start ->::: ");
		BaseDTO baseDTO = null;
		try {
			if (customerBillingDTOList != null && customerBillingDTOList.size() > 0) {
				String url = SERVER_URL + "/customerbillingcontroller/billadd";
				log.info("::: billPrint Controller calling  :::");
				baseDTO = httpService.post(url, customerBillingDTOList);
				log.info("::: get itemAutocomplete Response :");
				if (baseDTO.getStatusCode() == 0) {
					AppUtil.addInfo("Bill Printed Successfully");
					showBillingPage();
				} else {
					log.warn("billPrint Error ");
				}
			} else {
				AppUtil.addInfo("Please Add Item");
			}
		} catch (Exception ee) {
			log.error("Exception Occured in billPrint load ", ee);
		}

	}

	/**
	 * This Method Used To Remove Added Item In Table For Billing
	 * 
	 * @param customerBillingDto
	 */
	public void removeItem(CustomerBillingDTO customerBillingDto) {

		if (customerBillingDto != null) {
			customerBillingDTOList.remove(customerBillingDto);
		}

	}

	public List<ProductVarietyMaster> itemAutoSearch(String itemName) {

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

	/**
	 * This Method Used To Load Item Information Based On Input
	 * 
	 * @param Item
	 *            Information
	 * @return
	 */
	public CustomerBillingDTO findPriceDetailsByItemId(Long itemId, CustomerBillingDTO dto) {

		log.info(":::<- Load itemAutoSearch TypeStart ->::: ");
		BaseDTO baseDTO = null;
		try {
			if (itemId != null) {
				String url = SERVER_URL + "/customerbillingcontroller/itempricedetails/" + itemId;
				log.info("::: itemAutoSearch Controller calling  1 :::");
				baseDTO = httpService.get(url);
				log.info("::: get mobileAutocomplete Response :");
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
					CustomerBillingDTO customerDTO = mapper.readValue(jsonResponse, CustomerBillingDTO.class);
					if (customerDTO != null && customerDTO.getStockQnty() > 0) {
						dto.setStockQnty(customerDTO.getStockQnty());
						dto.setSellingPrices(customerDTO.getSellingPrices());
					} else {
						AppUtil.addWarn("No Stock Available");
					}
					log.info("itemAutoSearch load Successfully " + baseDTO.getTotalRecords());
					log.info("itemAutoSearch Page Convert Succes -->");
				} else {
					log.warn("itemAutoSearch Error ");
				}
			}
		} catch (Exception ee) {
			log.error("Exception Occured in supplierAutocomplete load ", ee);
		}

		return dto;

	}

	Long itemPk;

	/**
	 * This Method Used For Select Item Select
	 * 
	 * @param customerbillingDto
	 */
	public void ajaxItemSelect(CustomerBillingDTO customerbillingDto) {

		// if (productVarietyMaster != null) {
		// Long id = customerbillingDto.getTableId();
		// customerbillingDto = new CustomerBillingDTO();
		// customerbillingDto.setTableId(id);
		// customerbillingDto.setItemId(productVarietyMaster.getId());
		// customerbillingDto.setItemCodeName(productVarietyMaster.getName());
		// customerbillingDto.setCgstPercent(productVarietyMaster.getCgst_percentage());
		// customerbillingDto.setSgstPercent(productVarietyMaster.getSgst_percentage());
		// customerbillingDto.setHsnCode(productVarietyMaster.getHsnCode());
		// findPriceDetailsByItemId(productVarietyMaster.getId(), customerbillingDto);
		// if (!id.equals(tableId)) {
		// CustomerBillingDTO dto = new CustomerBillingDTO();
		// dto.setTableId(customerbillingDto.getTableId() +1);
		// customerBillingDTOList.add(dto);
		//
		// }
		// tableId = customerbillingDto.getTableId();
		// }

		if (productVarietyMaster != null) {
			customerbillingDto.setItemId(productVarietyMaster.getId());
			customerbillingDto.setItemCodeName(productVarietyMaster.getName());
			customerbillingDto.setCgstPercent(productVarietyMaster.getCgst_percentage());
			customerbillingDto.setSgstPercent(productVarietyMaster.getSgst_percentage());
			customerbillingDto.setHsnCode(productVarietyMaster.getHsnCode());
			findPriceDetailsByItemId(productVarietyMaster.getId(), customerbillingDto);
			if (!productVarietyMaster.getId().equals(itemPk)) {
				customerBillingDTOList.add(new CustomerBillingDTO());
			}
			itemPk = customerbillingDto.getItemId();
		}

	}

	public void updateUnitRateWithGST(CustomerBillingDTO customerdto) {

		if (customerdto != null) {

			if (customerdto.getBilledQnty() != null && customerdto.getBilledQnty() > 0
					&& customerdto.getUnitRate() != null && customerdto.getUnitRate() > 0) {
				if (customerdto.getStockQnty() < customerdto.getBilledQnty()) {
					AppUtil.addWarn(" Billed Qnty Is More Than Stock Qnty ");
					customerdto.setBilledQnty(0L);
					return;
				}

				customerdto.setTotalRate(customerdto.getUnitRate() * customerdto.getBilledQnty());
			}

			if (customerdto.getTotalRate() != null && customerdto.getTotalRate() > 0) {

				if (customerdto.getCgstPercent() != null && customerdto.getCgstPercent() > 0) {
					customerdto.setCgstAmount(customerdto.getTotalRate() * customerdto.getCgstPercent() / 100);
					customerdto.setTotalNetPrice(customerdto.getTotalRate() + customerdto.getCgstAmount());
				}
				if (customerdto.getSgstPercent() != null && customerdto.getSgstPercent() > 0) {
					customerdto.setSgstAmount(customerdto.getTotalRate() * customerdto.getSgstPercent() / 100);
					customerdto.setTotalNetPrice(customerdto.getTotalNetPrice() + customerdto.getSgstAmount());
				}

				if (customerdto.getDiscountPercent() != null && customerdto.getDiscountPercent() > 0) {
					Double discountAmount = customerdto.getTotalRate() * customerdto.getDiscountPercent() / 100;
					customerdto.setTotalNetPrice(customerdto.getTotalRate() - discountAmount);
				}

			}

		}
	}
	
	public void updateMobileNumber() {
		if (selectedcustomerMaster == null) {
			disabledCustomer = false;
		} else if (selectedcustomerMaster.getId() == null) {
			disabledCustomer = false;
		} else {
			disabledCustomer = true;
		}
	}
	
}
