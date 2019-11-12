package co.orffosoft.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.Validate;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.SupplierDetailsResponseDTO;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.repository.ApplicationQueryRepository;
import co.orffosoft.repository.SupplierMasterRepository;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SupplierMasterService {
	@Autowired
	SupplierMasterRepository supplierMasterRepository;

	@Autowired
	ApplicationQueryRepository applicationQueryRepository;

	@Autowired
	EntityManager em;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	ResponseWrapper responseWrapper;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	LoginService loginService;

	@Transactional
	public BaseDTO create(SupplierMaster supplierMaster) {
		log.info("<< SupplierMasterService create start >>" + supplierMaster);
		BaseDTO response = new BaseDTO();
		try {
			Validate.notNull(supplierMaster, ErrorDescription.SUPPLIER_MASTER_SHOULD_NOT_BE_EMPTY);
			Validate.notNullOrEmpty(supplierMaster.getCode(), ErrorDescription.SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_EMPTY);
			Validate.notNullOrEmpty(supplierMaster.getName(), ErrorDescription.SUPPLIER_MASTER_NAME_SHOULD_NOT_BE_EMPTY);

			supplierMaster.setActiveStatus(true);
			supplierMaster.setRegistrationDate(new Date());
			supplierMaster.setUserMaster(userMasterRepository.findOne(loginService.getCurrentUser().getId()));
			supplierMaster.setCreatedBy(loginService.getCurrentUser());
			supplierMaster.setCreatedDate(new Date());
			supplierMasterRepository.save(supplierMaster);
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("Successfully saved" + supplierMaster);

		} catch (RestException exception) {

			response.setStatusCode(exception.getStatusCode());

			log.error("supplierMaster RestException ", exception);

		} catch (DataIntegrityViolationException exception) {

			log.error("Data Integrity Violation Exception while Creating supplierMaster ", exception.getMessage());
			String exceptionCause = ExceptionUtils.getRootCauseMessage(exception);
			log.error("Exception Cause 1 : " + exceptionCause);
			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			if (exceptionCause.contains("uq_supplier_master_code")) {
				response.setStatusCode(ErrorDescription.SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_DUPLICATE.getErrorCode());
			}

		} catch (Exception exception) {

			log.error("Error while Creating supplierMaster ", exception);

			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}

		return response;

	}

	public BaseDTO get(Long id) {
		log.info("<< supplierMaster get started >>" + id);

		BaseDTO baseDTO = new BaseDTO();
		SupplierMaster supplierMasterResponse = new SupplierMaster();
		try {
			Validate.notNull(id, ErrorDescription.SUPPLIER_MASTER_SHOULD_NOT_BE_EMPTY);

			SupplierMaster supplierMaster = supplierMasterRepository.findOne(id);
			if (supplierMaster != null) {
				supplierMasterResponse.setId(supplierMaster.getId());
				supplierMasterResponse.setCode(supplierMaster.getCode());
				supplierMasterResponse.setName(supplierMaster.getName());
				supplierMasterResponse.setAddress(supplierMaster.getAddress());
				supplierMasterResponse.setLocalName(supplierMaster.getLocalName());
				supplierMasterResponse.setGstNumber(supplierMaster.getGstNumber());
				supplierMasterResponse.setPrimaryEmail(supplierMaster.getPrimaryEmail());
				supplierMasterResponse.setPrimaryContactName(supplierMaster.getPrimaryContactName());
				supplierMasterResponse.setPrimaryContactNumber(supplierMaster.getPrimaryContactNumber());
				supplierMasterResponse.setPrimaryEmail(supplierMaster.getPrimaryEmail());
				supplierMasterResponse.setRegistrationDate(supplierMaster.getRegistrationDate());
			}

			baseDTO.setResponseContent(supplierMasterResponse);

			log.info(" supplierMasterService get successfully....!!! ");
		} catch (RestException exception) {
			baseDTO.setStatusCode(exception.getStatusCode());
			log.error("supplierMasterService get method RestException ", exception);
		} catch (Exception exception) {

			log.error("Exception occurred in SupplierMaster get method -:", exception);

			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return responseWrapper.send(baseDTO);

	}

	@Transactional
	public BaseDTO update(SupplierMaster supplierMaster) {
		log.info("<< SupplierMasterService update start >>" + supplierMaster);
		BaseDTO response = new BaseDTO();
		try {

			Validate.notNull(supplierMaster, ErrorDescription.SUPPLIER_MASTER_SHOULD_NOT_BE_EMPTY);
			Validate.notNullOrEmpty(supplierMaster.getCode(), ErrorDescription.SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_EMPTY);
			Validate.notNullOrEmpty(supplierMaster.getName(), ErrorDescription.SUPPLIER_MASTER_NAME_SHOULD_NOT_BE_EMPTY);
			
			
			if (supplierMaster.getCode() != null && !supplierMaster.getCode().trim().equals("")) {
				SupplierMaster supplierMasterCode = supplierMasterRepository.findByCodeAndUserId(
						supplierMaster.getCode().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (supplierMasterCode != null) {
					log.info("Supplier Code Allready Present");
					response.setMessage("Supplier Code Already Present");
					throw new RestException("Supplier Code Already Present");
				}
			}

			if (supplierMaster.getName() != null && !supplierMaster.getName().trim().equals("")) {
				SupplierMaster supplierMasterName = supplierMasterRepository.findByNameAndUserId(
						supplierMaster.getName().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (supplierMasterName != null) {
					log.info("Supplier Name Allready Present");
					response.setMessage("Supplier Name Already Present");
					throw new RestException("Supplier Name Already Present");
				}
			}
			
			SupplierMaster supMaster = supplierMasterRepository.findOne(supplierMaster.getId());
			supMaster.setCode(supplierMaster.getCode().trim());
			supMaster.setName(supplierMaster.getName().trim());
			supMaster.setAddress(supplierMaster.getAddress());
			supMaster.setPrimaryEmail(supplierMaster.getPrimaryEmail());
			supMaster.setPrimaryContactNumber(supplierMaster.getPrimaryContactNumber());
			supMaster.setPrimaryContactName(supplierMaster.getPrimaryContactName());
			supMaster.setGstNumber(supplierMaster.getGstNumber());
			if(supplierMaster.getLocalName() != null) {
				supMaster.setLocalName(supplierMaster.getLocalName());
			}
			supMaster.setActiveStatus(true);
			supMaster.setModifiedDate(new Date());
			supMaster.setModifiedBy(loginService.getCurrentUser());
			supplierMasterRepository.save(supMaster);
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("Successfully updated " + supplierMaster.getId());

		} catch (RestException exception) {

			response.setStatusCode(exception.getStatusCode());

			log.error("supplierMaster RestException ", exception);

		} catch (DataIntegrityViolationException exception) {

			log.error("Data Integrity Violation Exception while update supplierMaster ", exception.getMessage());
			String exceptionCause = ExceptionUtils.getRootCauseMessage(exception);
			log.error("Exception Cause 1 : " + exceptionCause);
			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			if (exceptionCause.contains("uq_supplier_master_code")) {
				response.setStatusCode(ErrorDescription.SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_DUPLICATE.getErrorCode());
			}

		} catch (Exception exception) {

			log.error("Error while Creating supplierMaster ", exception);

			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}

		return response;

	}

	public BaseDTO search(SupplierMaster supplierMaster) {
		BaseDTO response = new BaseDTO();
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(SupplierMaster.class, "supplierMaster");

		try {

			if (supplierMaster.getFilters() != null) {

				if (supplierMaster.getFilters().get("code") != null) {
					String codeOrName = (String) supplierMaster.getFilters().get("code");

					log.info(" codeOrName " + codeOrName);

					criteria.add(Restrictions.or(
							Restrictions.like("supplierMaster.code", "%" + codeOrName + "%").ignoreCase(),
							Restrictions.like("supplierMaster.name", "%" + codeOrName + "%").ignoreCase()));
				}

				if (supplierMaster.getFilters().get("registrationDate") != null) {
					log.info(" Reg Date : " + new Date((Long) supplierMaster.getFilters().get("registrationDate")));
					Date regDate = new Date((Long) supplierMaster.getFilters().get("registrationDate"));

					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String registDate = dateFormat.format(regDate);
					Date date = dateFormat.parse(registDate);

					criteria.add(Restrictions.eq("supplierMaster.registrationDate", date));
				}

				if (supplierMaster.getFilters().get("primaryContactName") != null) {
					String contName = (String) supplierMaster.getFilters().get("primaryContactName");

					log.info(" contName " + contName);

					criteria.add(
							Restrictions.like("supplierMaster.primaryContactName", "%" + contName + "%").ignoreCase());
				}

				if (supplierMaster.getFilters().get("primaryEmail") != null) {
					String email = (String) supplierMaster.getFilters().get("primaryEmail");

					log.info(" email " + email);

					criteria.add(Restrictions.like("supplierMaster.primaryEmail", "%" + email + "%").ignoreCase());
				}

				if (supplierMaster.getFilters().get("primaryContactNumber") != null) {
					String contactNumber = (String) supplierMaster.getFilters().get("primaryContactNumber");

					log.info(" contactNumber " + contactNumber);

					criteria.add(Restrictions.like("supplierMaster.primaryContactNumber", "%" + contactNumber + "%")
							.ignoreCase());
				}

				if (supplierMaster.getFilters().get("createdDate") != null) {
					log.info(" Created Date : " + new Date((Long) supplierMaster.getFilters().get("createdDate")));

					Date regDate = new Date((long) supplierMaster.getFilters().get("createdDate"));
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String strDate = dateFormat.format(regDate);
					Date minDate = dateFormat.parse(strDate);
					Date maxDate = new Date(minDate.getTime() + TimeUnit.DAYS.toMillis(1));
					criteria.add(Restrictions.conjunction().add(Restrictions.ge("supplierMaster.createdDate", minDate))
							.add(Restrictions.lt("supplierMaster.createdDate", maxDate)));

				}

				if (supplierMaster.getFilters().get("activeStatus") != null) {
					String activeStatus = (String) supplierMaster.getFilters().get("activeStatus");

					log.info(" activeStatus " + activeStatus);

					criteria.add(Restrictions.eq("supplierMaster.activeStatus", Boolean.valueOf(activeStatus)));
				}

			}
			criteria.add(Restrictions.isNotNull("supplierMaster.userMaster.id"));
			if (loginService.getCurrentUser().getId() != 809) {
				criteria.add(Restrictions.eq("supplierMaster.userMaster.id", loginService.getCurrentUser().getId()));
			}
			criteria.setProjection(Projections.rowCount());
			Integer totalResult = ((Long) criteria.uniqueResult()).intValue();
			criteria.setProjection(null);

			// For Pagination
			if (supplierMaster.getPaginationDTO() != null) {
				Integer pageNo = supplierMaster.getPaginationDTO().getPageNo();
				Integer pageSize = supplierMaster.getPaginationDTO().getPageSize();

				if (pageNo != null && pageSize != null) {
					criteria.setFirstResult(pageNo * pageSize);
					criteria.setMaxResults(pageSize);
					log.info("PageNo : [" + pageNo + "] pageSize[" + pageSize + "]");
				}

				String sortField = supplierMaster.getPaginationDTO().getSortField();
				String sortOrder = supplierMaster.getPaginationDTO().getSortOrder();
				if (sortField != null && sortOrder != null) {
					log.info("sortField : [" + sortField + "] sortOrder[" + sortOrder + "]");

					if (sortField.equals("code")) {

						sortField = "supplierMaster.code";

					} else if (sortField.equals("registrationDate")) {

						sortField = "supplierMaster.registrationDate";

					} else if (sortField.equals("primaryContactName")) {

						sortField = "supplierMaster.primaryContactName";

					} else if (sortField.equals("primaryEmail")) {

						sortField = "supplierMaster.primaryEmail";

					} else if (sortField.equals("primaryContactNumber")) {

						sortField = "supplierMaster.primaryContactNumber";

					} else if (sortField.equals("createdDate")) {

						sortField = "supplierMaster.createdDate";

					} else if (sortField.equals("activeStatus")) {
						sortField = "supplierMaster.activeStatus";
					}

					if (sortOrder.equals("DESCENDING")) {
						criteria.addOrder(Order.desc(sortField));
					} else {
						criteria.addOrder(Order.asc(sortField));
					}
				} else {
					criteria.addOrder(Order.desc("supplierMaster.createdDate"));
				}
			}
			

			log.info("Criteria Query  : " + criteria);

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("supplierMaster.id"));
			projectionList.add(Projections.property("supplierMaster.code"));
			projectionList.add(Projections.property("supplierMaster.name"));
			projectionList.add(Projections.property("supplierMaster.registrationDate"));
			projectionList.add(Projections.property("supplierMaster.primaryContactName"));
			projectionList.add(Projections.property("supplierMaster.primaryEmail"));
			projectionList.add(Projections.property("supplierMaster.primaryContactNumber"));
			projectionList.add(Projections.property("supplierMaster.createdDate"));
			projectionList.add(Projections.property("supplierMaster.activeStatus"));

			criteria.setProjection(projectionList);
			List<SupplierMaster> supplierMasterList = new ArrayList<>();
			List<?> resultList = criteria.list();
			if (resultList != null) {
				Iterator<?> it = resultList.iterator();
				while (it.hasNext()) {
					Object ob[] = (Object[]) it.next();
					SupplierMaster responseEntity = new SupplierMaster();
					responseEntity.setId((Long) ob[0]);
					responseEntity.setCode((String) ob[1]);
					responseEntity.setName((String) ob[2]);
					responseEntity.setRegistrationDate((Date) ob[3]);
					responseEntity.setPrimaryContactName((String) ob[4]);
					responseEntity.setPrimaryEmail((String) ob[5]);
					responseEntity.setPrimaryContactNumber((String) ob[6]);
					responseEntity.setCreatedDate((Date) ob[7]);
					responseEntity.setActiveStatus((boolean) ob[8]);

					supplierMasterList.add(responseEntity);
					response.setTotalRecords(totalResult);
					response.setResponseContent(supplierMasterList);
					response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());

				}
			}

		} catch (RestException restException) {
			response.setStatusCode(restException.getStatusCode());
			log.error("RestException in FDSService search() ", restException);
		} catch (Exception exception) {
			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("Exception in FDSService search() ", exception);
		}

		return responseWrapper.send(response);

	}

	@Transactional
	public BaseDTO delete(Long id) {
		log.info("<< supplierMaster Delete started >>" + id);

		BaseDTO baseDTO = new BaseDTO();
		SupplierMaster supplierMaster = null;
		try {

			Validate.notNull(id, ErrorDescription.SUPPLIER_MASTER_SHOULD_NOT_BE_EMPTY);

			supplierMaster = supplierMasterRepository.findOne(id);
			supplierMasterRepository.delete(supplierMaster.getId());

			log.info("supplierMasterService Delete deleted successfully....!!!");
		} catch (RestException exception) {
			baseDTO.setStatusCode(exception.getStatusCode());
			log.error("supplierMasterService delete method RestException ", exception);
		} catch (DataIntegrityViolationException exception) {

			log.error("Exception occured : ", exception);
//
//			if (exception.getCause().getCause() instanceof PSQLException) {
//				baseDTO.setStatusCode(ErrorDescription.CANNOT_DELETE_REFERENCED_RECORD.getErrorCode());
//			}
		} catch (Exception exception) {

			log.error("Exception occurred in SupplierMaster delete method -:", exception);

			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return responseWrapper.send(baseDTO);

	}

	public BaseDTO getAll() {
		log.info("<< supplierMaster getAll started >>");

		BaseDTO baseDTO = new BaseDTO();
		List<SupplierMaster> supplierMasterList = null;
		try {
			supplierMasterList = supplierMasterRepository.findAll();
			baseDTO.setResponseContent(supplierMasterList);
		} catch (RestException exception) {
			baseDTO.setStatusCode(exception.getStatusCode());
			log.error("supplierMasterService getAll method RestException ", exception);
		} catch (Exception exception) {
			log.error("Exception occurred in SupplierMaster getAll method -:", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return responseWrapper.send(baseDTO);

	}

	public BaseDTO loadSupplierAutoComplete(String supplierName) {
		log.info("<-== supplier Master Service loadSupplierAutoComplete ==-> " + supplierName);
		BaseDTO baseDTO = new BaseDTO();
		try {
			supplierName = "%" + supplierName + "%";
			log.info("supplierName==>" + supplierName);
			List<SupplierMaster> supplierMasterList = supplierMasterRepository.findBySupplierByName(supplierName);
			baseDTO.setResponseContent(supplierMasterList);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("<-== supplier Master Service loadSupplierAutoComplete list ==->");
		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("found exception in  loadSupplierAutoComplete", e);
		}
		log.info("<-== End supplier Master loadSupplierAutoComplete Service ==->");
		return responseWrapper.send(baseDTO);
	}

	public BaseDTO checkSupplier(Long id) {
		log.info("Checking user is supplier or not for Id {}", id);
		Long supplierMaster = supplierMasterRepository.findSupplierMasterIdByUserId(id);
		BaseDTO baseDTO = new BaseDTO();
		if (supplierMaster == null) {
//			String file = customerDocumentsRepository.findCustomerDocumentForUserId(id);
//			baseDTO.setMessage("User Not registered as supplier");
//			baseDTO.setTotalRecords(0);
//			Map map = new HashMap();
//			map.put("fileName", file);
//			baseDTO.setResponseContent(map);
			return baseDTO;
		} else {
			baseDTO.setMessage("User Registered as supplier");
			baseDTO.setTotalRecords(1);
			log.info("Completed Checking user is supplier or not for Id {}", id);
			return baseDTO;
		}
	}

	public BaseDTO getSupplierDetails(Long userId) {
		BaseDTO baseDTO = new BaseDTO();
//		List<Object[]> supplierDetails = this.supplierMasterRepository.findSupplierDetails(userId);
//		if (supplierDetails == null) {
//			log.error("No supplier associated with the id {}", userId);
//			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
//			baseDTO.setErrorDescription("User not registered as a supplier");
//			return baseDTO;
//		}
//		SupplierDetailsDTO supplierDetailsDTO = new SupplierDetailsDTO();
//		supplierDetails.forEach(supplierDetail -> {
//			supplierDetailsDTO.setSupplierId((Long) supplierDetail[0]);
//			supplierDetailsDTO.setAccountNumber((String) supplierDetail[2]);
//			supplierDetailsDTO.setBusinessTypeCode((String) supplierDetail[4]);
//			supplierDetailsDTO.setBusinessTypeId((Long) supplierDetail[3]);
//			supplierDetailsDTO.setSupplierTypeCode((String) supplierDetail[6]);
//			supplierDetailsDTO.setSupplierTypeId((Long) supplierDetail[5]);
//			supplierDetailsDTO.setSupplierName((String) supplierDetail[1]);
//		});

		log.info("Successfully fetched all the supplier details");
		baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		baseDTO.setMessage("Successfully fetched supplier details");
//		baseDTO.setResponseContent(supplierDetailsDTO);
		return baseDTO;
	}

	@Transactional
	public BaseDTO updateSupplierDetails(SupplierDetailsResponseDTO supplierDetailsDTO) {
		log.info("Stared Updating Supplier Details");
		BaseDTO baseDTO = new BaseDTO();
		SupplierMaster supplierMasterDetails = this.supplierMasterRepository
				.findOneById(supplierDetailsDTO.getSupplierId());
		UserMaster userMaster = supplierMasterDetails.getUserMaster();

		Authentication authentication = new UsernamePasswordAuthenticationToken(userMaster, userMaster.getPassword(),
				null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		supplierMasterDetails.setAccountNumber(supplierDetailsDTO.getAccountNumber());
		supplierMasterDetails.setName(supplierDetailsDTO.getSupplierName());
		this.supplierMasterRepository.save(supplierMasterDetails);
		SecurityContextHolder.clearContext();
		log.info("Successfully Updated Supplier Details");
		baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		baseDTO.setMessage("Successfully Updated the Supplier Details");
		return baseDTO;
	}

	public BaseDTO getAllSuplierMasterServices() {

		BaseDTO baseDTO = new BaseDTO();
		try {
			log.info("getting all SupplierMaster from database  and storing into the list");
			List<SupplierMaster> supplierMasterList = supplierMasterRepository.getAllSupplierListNew();

			baseDTO.setResponseContents(supplierMasterList);
			log.info("supplierMasterList is returned from data base" + supplierMasterList.toString());
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());

		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("found exception in supplierMasterList", e);
		}

		return baseDTO;

	}

	public BaseDTO getSupplierMasterByUserId(Long userId) {

		BaseDTO baseDTO = new BaseDTO();
		try {
			log.info("<== SupplierMasterService :: getSupplierMasterByUserId ==>");
			SupplierMaster supplierMaster = supplierMasterRepository.findSupplierByUser(userId);
			if (supplierMaster != null) {
				log.info("SupplierMasterService :: supplierMaster size==> " + supplierMaster);
				baseDTO.setResponseContent(supplierMaster);
				baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			} else {
				log.info("Supplier master not found");
				baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			}

		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("found exception in supplierMasterList", e);
		}

		return baseDTO;

	}

}
