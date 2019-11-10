package co.orffosoft.bean;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppPreference;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerMasterDTO;
import co.orffosoft.entity.AddressMaster;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service("customerMasterBean")
@Log4j2
@Scope("session")
public class CustomerMasterBean {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 654646L;
	private static final String LIST_PAGE = "/pages/masters/listCustomerMaster.xhtml?faces-redirect=true";
	private static final String ADD_PAGE = "/pages/masters/createCustomerMaster.xhtml?faces-redirect=true";
	private static final String VIEW_PAGE = "/pages/masters/viewCustomerMaster.xhtml?faces-redirect=true";

	@Getter
	@Setter
	private CustomerMasterDTO customerMaster;

	@Autowired
	AppPreference appPreference;

	@Getter
	@Setter
	private Long talukMasterId;

	@Getter
	@Setter
	private AddressMaster customerAddress;

	@Getter
	@Setter
	private AddressMaster billingAddress;

	@Getter
	@Setter
	private AddressMaster shippingAddress;

	@Getter
	@Setter
	private String addressType, action, ifsc;

	@Getter
	@Setter
	List<CustomerMasterDTO> parentCustomerList = new ArrayList<CustomerMasterDTO>();

	@Getter
	@Setter
	Integer totalRecords;

	@Getter
	@Setter
	private String officeAddressTextArea, billingAddressTextArea, shippingAddressTextArea;

	@Getter
	@Setter
	private Boolean addButtonFlag = true;

	@Autowired
	ErrorMap errorMap;

	@Autowired
	HttpService httpService;

	ObjectMapper mapper = new ObjectMapper();

	String jsonResponse;

	String serverURL;

	BaseDTO baseDTO;

	@Autowired
	CommonDataBean commonDateBean;

	@Getter
	@Setter
	Boolean countryflag = false;
	@Getter
	@Setter
	String customerCode;

	public CustomerMasterBean() {
		customerMaster = new CustomerMasterDTO();
		baseDTO = new BaseDTO();
		loadValues();
	}

	public String showList() {
		addButtonFlag = true;
		return LIST_PAGE;
	}

	public String showAddPage() {
		action = "ADD";
		customerMaster = new CustomerMasterDTO();
		customerAddress = new AddressMaster();
		billingAddress = new AddressMaster();
		shippingAddress = new AddressMaster();
		loadValues();
		getNextSequenceConfigValueForCustomerCode();
		return ADD_PAGE;
	}

	public String showEditPage() {
		action = "EDIT";
		customerMaster = new CustomerMasterDTO();
		try {
			// String url = serverURL+ appPreference.getOperationApiUrl() +
			// "/customerMaster/get/" + customerSearchResponse.getId();
			// baseDTO = httpService.get(url);
			// log.info("BaseDTO Dto :" + baseDTO.getResponseContent());
			// ObjectMapper mapper = new ObjectMapper();
			// String jsonResponse =
			// mapper.writeValueAsString(baseDTO.getResponseContent());
			// customerMaster = mapper.readValue(jsonResponse, CustomerMasterDTO.class);
			// log.info("<<======= INFORMATIONS:: " + customerMaster);
			// prepareAddressText(customerMaster);

		} catch (Exception e) {
			log.error("<<<=======   ERROR IN EDIT CUSTOMER MASTER =========>>");
		}
		return ADD_PAGE;
	}

	public String showViewPage() {
		action = "VIEW";
		try {
			// String url = serverURL + appPreference.getOperationApiUrl()+
			// "/customerMaster/get/" + customerSearchResponse.getId();
			// baseDTO = httpService.get(url);
			// log.info("BaseDTO Dto :" + baseDTO.getResponseContent());
			// ObjectMapper mapper = new ObjectMapper();
			// String jsonResponse =
			// mapper.writeValueAsString(baseDTO.getResponseContent());
			// customerMaster = mapper.readValue(jsonResponse, CustomerMasterDTO.class);
			//
			// prepareAddressText(customerMaster);
			//
			// log.info("<<======= INFORMATIONS:: " + customerMaster);
		} catch (Exception e) {
			log.error("<<<=======  Error in view customer master =====>>");
		}
		return VIEW_PAGE;
	}

	public String getNextSequenceConfigValueForCustomerCode() {
		log.info("getNextSequenceConfigValueForCustomerCode called......");
		try {
			String url = serverURL + appPreference.getOperationApiUrl() + "/customerMaster/nextsequenceconfigvalue";
			baseDTO = httpService.get(url);
			log.info("BaseDTO Dto :" + baseDTO.getResponseContent());
			ObjectMapper mapper = new ObjectMapper();
			String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
			customerCode = mapper.readValue(jsonResponse, String.class);

			log.info("<<=======  INFORMATIONS::  " + customerMaster);
		} catch (Exception e) {
			log.error("<<<=======  Error in view customer master =====>>");
		}

		return customerCode;

	}

	private void loadValues() {
		log.info("---loadValues----");
		try {
			serverURL = AppUtil.getPortalServerURL();
			log.info("<<====== serverURL:: " + serverURL);
		} catch (Exception e) {
			log.fatal("Exception at loadValues() >>>> " + e.toString());

		}
	}

	public String submitCustomerMaster() {
		log.info("<<=======  customerMasterBean --- submitCustomerMaster === STARTS");

		// if (checkValidation()) {

		log.info("<<==========   ADD SUCCESS ##############");
		// log.info("<<==:::: "+customerMaster);

		if (action.equalsIgnoreCase("ADD")) {
			String url = serverURL + appPreference.getOperationApiUrl() + "/customerMaster/create";
			baseDTO = httpService.post(url, customerMaster);
		} else if (action.equalsIgnoreCase("EDIT")) {
			String url = serverURL + appPreference.getOperationApiUrl() + "/customerMaster/update";
			baseDTO = httpService.post(url, customerMaster);
		}
		log.info("BaseDTO Status Code " + baseDTO.getStatusCode());
		if (baseDTO != null) {
			if (baseDTO.getStatusCode() == 0) {
				if (action.equalsIgnoreCase("ADD")) {
					errorMap.notify(ErrorDescription.CUST_CREATE_SUCCESS.getErrorCode());
				} else {
					errorMap.notify(ErrorDescription.CUST_EDIT_SUCCESS.getErrorCode());
				}
				log.info("Customer Master has been Added");
			} else {
				log.error("Status code:" + baseDTO.getStatusCode());
				errorMap.notify(baseDTO.getStatusCode());
				return null;
			}
		}

		// }
		return LIST_PAGE;
	}

	public void addAddress(String addressType) {
		countryflag = false;
		log.info("<<== addAddress() - action " + action);

		if (action.equalsIgnoreCase("EDIT") && customerMaster != null && customerMaster.getId() != null) {
			if (addressType.equalsIgnoreCase("office")) {
			} else if (addressType.equalsIgnoreCase("billing")) {
			} else if (addressType.equalsIgnoreCase("shipping")) {
			}
		}

	}

	public void resetinterestPercentage() {
		log.info("<<<<<<<<:::::::::resetinterestPercentage:::::::::::>>>>>>>>");
		customerMaster.setInterestPercentage(null);
		RequestContext.getCurrentInstance().update("interestpercentage");
	}

}
