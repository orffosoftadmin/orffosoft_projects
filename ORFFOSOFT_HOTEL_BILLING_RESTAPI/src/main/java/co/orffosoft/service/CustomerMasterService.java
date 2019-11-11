package co.orffosoft.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerMasterDTO;
import co.orffosoft.entity.CustomerMaster;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.enums.SequenceName;
import co.orffosoft.repository.CustomerMasterRepository;
import co.orffosoft.repository.SequenceConfigRepository;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerMasterService {

	@Autowired
	CustomerMasterRepository customerMasterRepository;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	SequenceConfigRepository sequenceConfigRepository;

	@Autowired
	LoginService loginService;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ResponseWrapper responseWrapper;

	public BaseDTO create(CustomerMasterDTO customerMaster) {
		log.info("<<====== CustomerMasterService---- create   ====# STARTS");
		BaseDTO baseDTO = new BaseDTO();
		try {
			validateFieldsNotNull(customerMaster);
			SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.CUSTOMER_CODE);

			log.info("sequenceConfig saving...");
			sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);
			sequenceConfigRepository.save(sequenceConfig);
			log.info("<<===========   going to save ======>>");
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (RestException restExp) {
			log.error("Exception occered ");
			baseDTO.setStatusCode(restExp.getErrorCodeDescription().getErrorCode());
		} catch (DataIntegrityViolationException diExp) {
			log.error("Data Integrity Violation Exception while Add Customer master " + diExp);
			String exceptionCause = ExceptionUtils.getRootCauseMessage(diExp);
			log.error("Exception Cause  : " + exceptionCause);

			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());

			if (exceptionCause.contains("uq_customer_master_code")) {
				baseDTO.setStatusCode(ErrorDescription.CUST_CODE_EXISTS.getErrorCode());
			}

		} catch (Exception e) {
			log.error("<<=======    ERROR DURING CREATE CUSTOMER MASTER ==###" + e);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		log.info("<<====== CustomerMasterService---- create   ====# ENDS");
		return baseDTO;

	}

	public BaseDTO nextSequenceConfigValueForCustomerCode() {
		log.info("nextSequenceConfigValueForCustomerCode service called");
		SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.CUSTOMER_CODE);
		String customerCode = generateReferenceNo(sequenceConfig);
		log.info("nextSequenceConfigValueForCustomerCode value is" + customerCode);
		BaseDTO baseDTO = new BaseDTO();
		baseDTO.setResponseContent(customerCode);
		baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		return baseDTO;
	}

	private String generateReferenceNo(SequenceConfig sequenceConfig) {
		String referenceNumber = "";
		String type = "";
		String prefix = "";
		try {
			Long currentValue = sequenceConfig.getCurrentValue();
			if (String.valueOf(currentValue).length() == 1) {
				prefix = "00";
			} else if (String.valueOf(currentValue).length() == 2) {
				prefix = "0";
			} else if (String.valueOf(currentValue).length() == 3) {
				prefix = "";
			}
			type = sequenceConfig.getPrefix();
			referenceNumber = type + prefix + (currentValue + 1);
			log.info("referenceNumber------" + referenceNumber);
		} catch (Exception e) {
			log.info("exception in generateReferenceNo method", e);
		}
		return referenceNumber;
	}
	
	public BaseDTO getCustomerMaster(Long id) {
		log.info("<<====== CustomerMasterService---- getCustomerMaster   ====# STARTS");
		BaseDTO baseDTO = new BaseDTO();
		CustomerMasterDTO customerMaster = new CustomerMasterDTO();
		try {
			CustomerMaster entity = customerMasterRepository.findOne(id);
			if (entity != null)
				baseDTO.setResponseContent(customerMaster);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
		} catch (Exception e) {
			log.error("<<=======    ERROR DURING GET MASTER ==###" + e);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
		}
		log.info("<<====== CustomerMasterService---- getCustomerMaster   ====# ENDS");
		return baseDTO;
	}

	public BaseDTO deleteCustomer(Long id) {
		BaseDTO baseDTO = new BaseDTO();
		log.info("<<==== CustomerMasterService ---  deleteCustomer ====### STARTS");
		try {
			customerMasterRepository.delete(id);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (Exception e) {
			log.error("<<====   ERROR IN DELETE CUSTOMER MASTER" + e);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		log.info("<<==== CustomerMasterService ---  deleteCustomer ====### ENDS");
		return baseDTO;
	}

	private void validateFieldsNotNull(CustomerMasterDTO customerMaster) {
		Validate.notNull(customerMaster);
		Validate.notEmpty(customerMaster.getName());
		Validate.notNull(customerMaster.getActiveStatus());
		Validate.notNull(customerMaster.getPrimaryContactNumber());
	}

}
