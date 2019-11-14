package co.orffosoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jasypt.digest.StringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.ModelEntityMapper;
import co.orffosoft.core.util.PaginationRequestData;
import co.orffosoft.core.util.PaginationResponseData;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.Validate;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.GroupDTO;
import co.orffosoft.dto.UserMasterDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.RoleMaster;
import co.orffosoft.entity.RoleUser;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.enums.UserType;
import co.orffosoft.repository.CacheRepository;
import co.orffosoft.repository.EntityMasterRepository;
import co.orffosoft.repository.RoleMasterRepository;
import co.orffosoft.repository.RoleUserRepository;
import co.orffosoft.repository.SupplierMasterRepository;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserMasterService {

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	RoleMasterRepository roleMasterRepository;

	@Autowired
	StringDigester stringDigester;

	// @Autowired
	// RegionRepository regionRepository;

	@Autowired
	EntityMasterRepository entityMasterRepository;

	@Autowired
	CacheRepository cacheRepository;

	@PersistenceContext
	EntityManager em;

	@Autowired
	IdentityService identityService;

	@Autowired
	SupplierMasterRepository supplierMasterRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ResponseWrapper responseWrapper;

	@Autowired
	LoginService loginService;

	@Autowired
	RoleUserRepository roleUserRepository;

	public BaseDTO addUserDetails(UserMaster userMaster) {
		BaseDTO response = new BaseDTO();
		try {

			log.info("<<<< ------- Start UserManagementController.addUserDetails ---------- >>>>>>>" + userMaster);
			validateUser(userMaster, "ADD");
			String password = stringDigester.digest(userMaster.getPassword());
			userMaster.setRoleMaster(new ArrayList<>());
			userMaster.setCreatedDate(new Date());
			userMaster.setPassword(password);
			log.info("ROle =====>>>>" + userMaster.getRoleMaster());
			if (userMaster.getRoleMaster() != null)
				userMaster.getRoleMaster().stream().forEach(roleMaster -> {
					log.info("ROle =====>>>>" + roleMaster.getId());
					RoleMaster role = roleMasterRepository.findOne(roleMaster.getId());
					if (role != null)
						userMaster.getRoleMaster().add(role);
				});

			UserMaster createdUser = userMasterRepository.findOne(userMaster.getCreatedBy());
			Validate.notNull(createdUser, ErrorDescription.USER_DOES_NOT_EXISTS);
			userMaster.setCreatedBy(createdUser.getId());
			// if (userMaster.getRegion() != null)
			// userMaster.getRegion().stream().forEach(regionMaster -> {
			// EntityMaster region = entityMasterRepository.findOne(regionMaster.getId());
			// if (region != null)
			// userMaster.getRegion().add(region);
			// });
			userMaster.setStatus(true);
			UserMaster user = cacheRepository.save(UserMaster.class.getName(), userMaster, userMasterRepository);
			response.setStatusCode(ErrorDescription.USER_ADDED_SUCCESSFULLY.getErrorCode());
			response.setResponseContent(user);

		} catch (DataIntegrityViolationException divEX) {
			log.warn("Exception :: -- > " + divEX.getCause().getCause().getMessage());
			String exceptionCause = divEX.getCause().getCause().getMessage();
			log.warn("Exception Cause ::: " + exceptionCause);
			if (exceptionCause.contains("=")) {
				String duplicateInputValue = exceptionCause.split("=")[1];
				log.warn("duplicate value ::: " + duplicateInputValue);
				if (duplicateInputValue.contains("(")) {
					duplicateInputValue = StringUtils.substringBetween(duplicateInputValue, "(", ")");
				}
				log.warn("Duplicate input value ::: " + duplicateInputValue);
				if (duplicateInputValue.equals(userMaster.getUsername())) {
					response.setStatusCode(ErrorDescription.USERNAME_ALREADY_EXISTS.getErrorCode());
				}
			}
		} catch (RestException re) {
			log.warn("<<===  Exception While Adding ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserManagementController.addUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO updateUserDetails(UserMaster userMaster) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start UserService.updateUserDetails ---------- >>>>>>>");
			validateUser(userMaster, "EDIT");
			UserMaster existingUserMaster = userMasterRepository.findOne(userMaster.getId());

			Validate.objectNotNull(existingUserMaster, ErrorDescription.USER_DOES_NOT_EXISTS);
			// List<RoleMaster> roleList=userMaster.getRoleMaster();
			existingUserMaster.setUsername(userMaster.getUsername());
			existingUserMaster.setRoleMaster(new ArrayList<>());
			existingUserMaster.setModifiedDate(new Date());

			userMaster.getRoleMaster().stream().forEach(roleMaster -> {
				RoleMaster role = roleMasterRepository.findOne(roleMaster.getId());
				if (role != null)
					existingUserMaster.getRoleMaster().add(role);
			});

			/*
			 * for(RoleMaster roleIterator:roleList) { RoleMaster
			 * role=roleMasterRepository.findOne(roleIterator.getId()); if(role!=null)
			 * existingUserMaster.getRoleMaster().add(role); }
			 */
			UserMaster modifiedByUser = userMasterRepository.findOne(userMaster.getModifiedBy());
			Validate.notNull(modifiedByUser, ErrorDescription.MODIFIED_BY_REQUIRED);
			existingUserMaster.setModifiedBy(modifiedByUser.getId());
			existingUserMaster.setModifiedDate(new Date());
			// userMaster.getRegion().stream().forEach(regionMaster -> {
			// EntityMaster region = entityMasterRepository.findOne(regionMaster.getId());
			// if (region != null)
			// userMaster.getRegion().add(region);
			// });
			cacheRepository.remove(UserMaster.class.getName(), existingUserMaster.getId());
			cacheRepository.save(UserMaster.class.getName(), existingUserMaster, userMasterRepository);
			response.setStatusCode(ErrorDescription.USER_UPDATED_SUCCESSFULLY.getErrorCode());
		} catch (DataIntegrityViolationException divEX) {
			log.warn("Exception :: -- > " + divEX.getCause().getCause().getMessage());
			String exceptionCause = divEX.getCause().getCause().getMessage();
			log.warn("Exception Cause ::: " + exceptionCause);
			if (exceptionCause.contains("=")) {
				String duplicateInputValue = exceptionCause.split("=")[1];
				log.warn("duplicate value ::: " + duplicateInputValue);
				if (duplicateInputValue.contains("(")) {
					duplicateInputValue = StringUtils.substringBetween(duplicateInputValue, "(", ")");
				}
				log.warn("Duplicate input value ::: " + duplicateInputValue);
				if (duplicateInputValue.equals(userMaster.getUsername())) {
					response.setStatusCode(ErrorDescription.USERNAME_ALREADY_EXISTS.getErrorCode());
				}
			}

		} catch (ObjectOptimisticLockingFailureException lockEx) {
			log.warn("====>> Error while Updating <<====", lockEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_LOCKED_RECORD.getErrorCode());
		} catch (JpaObjectRetrievalFailureException ObjFailEx) {
			log.warn("====>> Error while Updating <<====", ObjFailEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_DELETED_RECORD.getErrorCode());
		} catch (RestException re) {
			log.warn("<<===  Exception While Updating ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserService.updateUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO getAllUserDetailsLazy(PaginationRequestData req) {
		BaseDTO response = new BaseDTO();
		Page<UserMaster> userMasterList = null;
		try {

			log.info("<<<< ------- Start UserService.getAllUserDetailsLazy ---------- >>>>>>>");
			PaginationResponseData data = new PaginationResponseData();
			Pageable pagerequest = new PageRequest(req.getPageNo(), req.getPaginationSize());
			userMasterList = userMasterRepository.findAll(pagerequest);
			response.setStatusCode(ErrorDescription.USER_RETRIEVED_SUCCESSFULLY.getErrorCode());
			if (userMasterList != null) {
				data.setContents(userMasterList.getContent());
				data.setNumberOfElements(userMasterList.getNumberOfElements());
				data.setTotalPages(userMasterList.getTotalPages());
				data.setTotalElements(userMasterList.getTotalElements());
			}

			response.setPaginationResponseData(data);
		} catch (RestException re) {
			log.warn("<<===  Exception While getAllUserDetailsLazy ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserService.getAllUserDetailsLazy ---------- >>>>>>>");
		return response;
	}

	public BaseDTO getAllUserDetails() {
		BaseDTO response = new BaseDTO();
		List<UserMaster> userMasterList = null;
		UserMaster userMasters = new UserMaster();
		List<UserMaster> userMasterListResponse = new ArrayList<UserMaster>();
		try {

			log.info("<<<< ------- Start UserService.getAllUserDetails ---------- >>>>>>>");
//			EntityMaster entityMaster = entityMasterRepository.findOne(loginService.getCurrentUser().getEntityId());
//			if (entityMaster != null) {
				userMasterList = userMasterRepository.findAllUserByEntity(loginService.getCurrentUser().getEntityId());
				Validate.objectNotNull(userMasterList, ErrorDescription.USER_EMPTY);

				if (userMasterList != null) {
					for (UserMaster userMaster : userMasterList) {
						userMasters = new UserMaster();
						userMasters.setId(userMaster.getId());
						userMasters.setCreatedBy(userMaster.getCreatedBy());
						userMasters.setCreatedDate(userMaster.getCreatedDate());
						userMasters.setUsername(userMaster.getUsername());
						userMasters.setUserType(userMaster.getUserType());
						userMasters.setStatus(userMaster.getStatus());
						userMasterListResponse.add(userMasters);

					}

				}
//			}

			response.setStatusCode(ErrorDescription.USER_RETRIEVED_SUCCESSFULLY.getErrorCode());
			response.setResponseContents(userMasterListResponse);
		} catch (RestException re) {
			log.warn("<<===  Exception While getAllUserDetails ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserService.getAllUserDetails ---------- >>>>>>>");
		return response;
	}

	@SuppressWarnings("unchecked")
	public BaseDTO getUserDetails(UserMaster userDetails) {
		BaseDTO response = new BaseDTO();
		try {

			log.info("<<<< ------- Start UserService.getUserDetails ---------- >>>>>>>");
			validateUser(userDetails, "GET");
			UserMaster userMaster = cacheRepository.get(UserMaster.class.getName(), userDetails.getId(),
					userMasterRepository);
			Validate.objectNotNull(userMaster, ErrorDescription.USER_DOES_NOT_EXISTS);

			UserMasterDTO userMasterDto = new UserMasterDTO();
			userMasterDto.setId(userMaster.getId());
			userMasterDto.setRoleMaster(userMaster.getRoleMaster());
			List<Group> groupList = identityService.createGroupQuery().groupMember("" + userDetails.getId()).list();
			log.info("groupList sizes" + groupList.size());

			List<GroupDTO> resultList = (List<GroupDTO>) ModelEntityMapper.convertListToCollection(groupList);

			userMasterDto.setGroupList(resultList);
			List<EntityMaster> lisRegion = new ArrayList<EntityMaster>();
			// for (EntityMaster region : userMaster.getRegion()) {
			// if (region.getCreatedBy() != null)
			// region.setCreatedBy(null);
			// if (region.getModifiedBy() != null)
			// region.setModifiedBy(null);
			//// if (region.getEntityTypeMaster() != null)
			//// if (region.getEntityTypeMaster().getCreatedBy() != null)
			//// if (region.getEntityTypeMaster().getCreatedBy().getRegion() != null)
			//// region.getEntityTypeMaster().getCreatedBy().setRegion(null);
			// lisRegion.add(region);
			// }
			userMasterDto.setRegion(lisRegion);
			userMasterDto.setUsername(userMaster.getUsername());
			userMasterDto.setStatus(userMaster.getStatus());
			userMasterDto.setUserMasterVersion(userMaster.getUserMasterVersion());
			response.setStatusCode(ErrorDescription.USER_RETRIEVED_SUCCESSFULLY.getErrorCode());
			response.setResponseContent(userMasterDto);
		} catch (RestException re) {
			log.warn("<<===  Exception While getUserDetails ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception While getUserDetails ===>>", e);
		}
		log.info("<<<< ------- End UserService.getUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO deleteUser(UserMaster user) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start UserService.deleteUser ---------- >>>>>>>");
			validateUser(user, "DELETE");
			UserMaster userMaster = userMasterRepository.findOne(user.getId());
			Validate.objectNotNull(userMaster, ErrorDescription.USER_DOES_NOT_EXISTS);

			cacheRepository.remove(UserMaster.class.getName(), userMaster.getId());

			String deleteRegion = "delete from user_entity where user_id =" + userMaster.getId();
			String deleteGroup = "delete from act_id_membership where cast(user_id_ as numeric) =" + userMaster.getId();
			String deleteRole = "delete from role_user where user_id=" + userMaster.getId();
			jdbcTemplate.update(deleteRegion);
			jdbcTemplate.update(deleteGroup);

			jdbcTemplate.update(deleteRole);
			userMasterRepository.delete(userMaster);
			if (user.getId().equals(user.getModifiedBy())) {
				log.info("<------------Same User updation------------->");
				response.setStatusCode(ErrorDescription.SAME_USER_UPDATE.getErrorCode());
			} else
				response.setStatusCode(ErrorDescription.USER_DELETED.getErrorCode());
			log.info("User deleted successfully....!!!");
		} catch (DataIntegrityViolationException divEx) {
			log.error("Data integrityviolation exception while deleting user....", divEx);
			response.setStatusCode(ErrorDescription.USER_MAPPED_WITH_OTHER_ENTITY.getErrorCode());
		}

		catch (RestException re) {
			log.warn("<<===  Exception While deleteUser ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception While deleteUser ===>>", e);
		}
		log.info("<<<< ------- End UserService.deleteUser ---------- >>>>>>>");

		return response;
	}

	@Transactional
	public BaseDTO addNewUser(UserMasterDTO userMasterDto) {
		BaseDTO response = new BaseDTO();
		EntityMaster entityMaster = new EntityMaster();
		UserMaster request = null;
		try {
			log.info("<<<< ------- Start UserManagementController.addUserDetails ---------- >>>>>>>" + userMasterDto);

			UserMaster existingUser = userMasterRepository.findByUsername(userMasterDto.getUsername());
			if (existingUser != null) {
				log.warn("User ID already exist>> ", existingUser.getUsername());
				response.setGeneralContent("User ID already exist");
				throw new RestException("User Id Already Exist ! Please Enter Another Name ");
			}
			if (userMasterDto.getId() == null) {
				EntityMaster entityMasterCode = entityMasterRepository.findByCode(userMasterDto.getStoreCode());
				if (entityMasterCode != null) {
					log.warn("Store Code already exist >> ", entityMasterCode.getCode());
					response.setGeneralContent("Store Code already exist");
					throw new RestException(" Store Code already exist ! Please Enter Another Name ");
				}
				EntityMaster entityMasterName = entityMasterRepository.findByName(userMasterDto.getStoreName());
				if (entityMasterName != null) {
					log.warn(" Store Name already exist >> ", entityMasterName.getName());
					response.setGeneralContent("Store Name already exist");
					throw new RestException(" Store Name already exist ! Please Enter Another Name ");
				}

				entityMaster.setCode(userMasterDto.getStoreCode());
				entityMaster.setName(userMasterDto.getStoreName());
				entityMaster.setCreatedDate(new Date());
				entityMaster.setCreatedBy(loginService.getCurrentUser());
				entityMaster.setActiveStatus(true);
				if (userMasterDto.getId() == null) {
//					entityMaster.setEntityMasterParent(null);
				} else {

				}
				entityMaster = entityMasterRepository.save(entityMaster);
				if (entityMaster == null) {
					log.error("Store Information Not Saved Due to Exception Check Further");
					throw new RestException("User Details Not Saved");
				}

			}

			UserMaster userMaster = new UserMaster();

			String password = stringDigester.digest(userMasterDto.getPassword());
			userMaster.setRoleMaster(new ArrayList<>());
			userMaster.setCreatedDate(new Date());
			userMaster.setPassword(password);
			userMaster.setUsername(userMasterDto.getUsername());
			userMaster.setUserType(userMasterDto.getUserType());
			userMaster.setEntityId(entityMaster.getId());
			userMaster.setStatus(userMasterDto.getStatus());
			if (userMaster.getUserType().equalsIgnoreCase("Admin")) {
				request = cacheRepository.save(UserMaster.class.getName(), userMaster, userMasterRepository);
			} else {
				request = userMasterRepository.save(userMaster);
			}
			
			if (request == null) {
				log.error(" <<== User Master Not Saved ===>> ");
				throw new RestException(" <<==  User Master Not saved === > ");
			}

			userMasterDto.setId(request.getId());

			RoleMaster roleMaster = roleMasterRepository.findAllActiveRoleMaster(request.getUserType().toString());
			
			if (roleMaster == null) {
				log.error("Role Master Not Found For === "+ request.getUserType().toString());
				throw new RestException("Role Master Not Found For === "+ request.getUserType().toString());
			}
			
			if (roleMaster != null) {
				RoleUser roleUser = new RoleUser();
				roleUser.setUserId(request.getId());
				roleUser.setRoleId(roleMaster.getId());
				roleUserRepository.save(roleUser);
			}

			response.setStatusCode(ErrorDescription.USER_ADDED_SUCCESSFULLY.getErrorCode());
			response.setResponseContent(request);
		} catch (DataIntegrityViolationException divEX) {
			log.warn("Exception :: -- > " + divEX.getCause().getCause().getMessage());
			String exceptionCause = divEX.getCause().getCause().getMessage();
			log.warn("Exception Cause ::: " + exceptionCause);
			if (exceptionCause.contains("=")) {
				String duplicateInputValue = exceptionCause.split("=")[1];
				log.warn("duplicate value ::: " + duplicateInputValue);
				if (duplicateInputValue.contains("(")) {
					duplicateInputValue = StringUtils.substringBetween(duplicateInputValue, "(", ")");
				}
				log.warn("Duplicate input value ::: " + duplicateInputValue);
				if (duplicateInputValue.equals(userMasterDto.getUsername())) {
					response.setStatusCode(ErrorDescription.USERNAME_ALREADY_EXISTS.getErrorCode());
				} else
					response.setStatusCode(ErrorDescription.ERROR_GENERIC.getErrorCode());
			}
		} catch (RestException re) {
			log.warn("<<===  Exception While Adding ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserManagementController.addUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO updateUserDetailsDto(UserMasterDTO userMasterDto) {
		BaseDTO response = new BaseDTO();
		try {

			log.info("<<<< ------- Start UserService.updateUserDetails ---------- >>>>>>>");
			validateUser(userMasterDto, "EDIT");
			UserMaster userMaster = new UserMaster();
			UserMaster existingUserMaster = userMasterRepository.findOne(userMasterDto.getId());

			Validate.objectNotNull(existingUserMaster, ErrorDescription.USER_DOES_NOT_EXISTS);

			log.info("existingUserMaster version-->" + existingUserMaster.getUserMasterVersion());
			log.info("userMasterDto.getUserMasterVersion()-->" + userMasterDto.getUserMasterVersion());

			if (existingUserMaster.getUserMasterVersion() != userMasterDto.getUserMasterVersion()) {
				log.info("<-----Optimistic lock----->");
				response.setStatusCode(10009);
				return response;
			}
			// List<RoleMaster> roleList=userMaster.getRoleMaster();
			existingUserMaster.setUsername(userMasterDto.getUsername());
			existingUserMaster.setRoleMaster(new ArrayList<>());
			existingUserMaster.setModifiedDate(new Date());

			userMasterDto.getRoleMaster().stream().forEach(roleMaster -> {
				RoleMaster role = roleMasterRepository.findOne(roleMaster.getId());
				if (role != null)
					existingUserMaster.getRoleMaster().add(role);
			});

			/*
			 * for(RoleMaster roleIterator:roleList) { RoleMaster
			 * role=roleMasterRepository.findOne(roleIterator.getId()); if(role!=null)
			 * existingUserMaster.getRoleMaster().add(role); }
			 */
			UserMaster modifiedByUser = userMasterRepository.findOne(userMasterDto.getModifiedBy());
			Validate.notNull(modifiedByUser, ErrorDescription.MODIFIED_BY_REQUIRED);
			existingUserMaster.setModifiedBy(modifiedByUser.getId());
			existingUserMaster.setModifiedDate(new Date());
			// existingUserMaster.setRegion(new ArrayList<>());
			// userMasterDto.getRegion().stream().forEach(regionMaster -> {
			// EntityMaster region = entityMasterRepository.findOne(regionMaster.getId());
			// if (region != null)
			// existingUserMaster.getRegion().add(region);
			// });
			existingUserMaster.setStatus(userMasterDto.getStatus());
			cacheRepository.remove(UserMaster.class.getName(), existingUserMaster.getId());
			cacheRepository.save(UserMaster.class.getName(), existingUserMaster, userMasterRepository);
			saveUserGroupDetails(userMasterDto);
			if (userMasterDto.getId().equals(userMasterDto.getModifiedBy())) {
				log.info("<------------Same User updation------------->");
				response.setStatusCode(ErrorDescription.SAME_USER_UPDATE.getErrorCode());
			} else
				response.setStatusCode(ErrorDescription.USER_UPDATED_SUCCESSFULLY.getErrorCode());
		} catch (DataIntegrityViolationException divEX) {
			log.warn("Exception :: -- > " + divEX.getCause().getCause().getMessage());
			String exceptionCause = divEX.getCause().getCause().getMessage();
			log.warn("Exception Cause ::: " + exceptionCause);
			if (exceptionCause.contains("=")) {
				String duplicateInputValue = exceptionCause.split("=")[1];
				log.warn("duplicate value ::: " + duplicateInputValue);
				if (duplicateInputValue.contains("(")) {
					duplicateInputValue = StringUtils.substringBetween(duplicateInputValue, "(", ")");
				}
				log.warn("Duplicate input value ::: " + duplicateInputValue);
				if (duplicateInputValue.equals(userMasterDto.getUsername())) {
					response.setStatusCode(ErrorDescription.USERNAME_ALREADY_EXISTS.getErrorCode());
				}
			}

		} catch (ObjectOptimisticLockingFailureException lockEx) {
			log.warn("====>> Error while Updating <<====", lockEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_LOCKED_RECORD.getErrorCode());
		} catch (JpaObjectRetrievalFailureException ObjFailEx) {
			log.warn("====>> Error while Updating <<====", ObjFailEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_DELETED_RECORD.getErrorCode());
		} catch (RestException re) {
			log.warn("<<===  Exception While Updating ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End UserService.updateUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO saveUserGroupDetails(UserMasterDTO userdetail) {
		log.info("<----- Save or update the user information service started ------>");
		BaseDTO response = new BaseDTO();
		String userid = String.valueOf(userdetail.getId());
		try {

			User user = identityService.createUserQuery().userId(userid).singleResult();
			if (user == null) {
				log.info("Add new User");
				user = identityService.newUser(userid);
				user.setFirstName(userdetail.getUsername().trim());
				user.setPassword(stringDigester.digest(userdetail.getPassword()));
				identityService.saveUser(user);
			} else {
				log.info("Update existing Group");
				identityService.setUserInfo(userid, "username", userdetail.getUsername().trim());
				identityService.setUserInfo(userid, "password", userdetail.getPassword());
			}

			List<Group> groupList = identityService.createGroupQuery().groupMember(userid).list();
			if (!CollectionUtils.isEmpty(groupList)) {
				for (Group group : groupList) {
					identityService.deleteMembership(userid, group.getId());
				}

			}
			log.info("Update a group");
			if (!CollectionUtils.isEmpty(userdetail.getGroupList())) {
				log.info("create User Member ship");
				for (GroupDTO group : userdetail.getGroupList()) {
					identityService.createMembership(userid, group.getId());
				}

			}
			response.setStatusCode(0);
		} catch (Exception e) {
			response.setStatusCode(ErrorDescription.ERROR_GENERIC.getErrorCode());
			log.error("Activiti User save are Update Error", e);
		}
		log.info("<----- Save or update the user information service completed ------>");
		return response;
	}

	public void validateUser(UserMaster user, String key) {
		log.info("<<<<<< ======= Start ValidateUser==============>>>>>.");
		Validate.objectNotNull(user, ErrorDescription.USER_EMPTY);
		if (key.equals("ADD")) {
			Validate.objectNotNull(user.getCreatedBy(), ErrorDescription.CREATED_BY_REQUIRED);
			Validate.objectNotNull(user.getPassword(), ErrorDescription.PASSWORD_REQUIRED);
			// Validate.objectNotNull(user.getRoleMaster(), ErrorDescription.ROLE_EMPTY);
			Validate.objectNotNull(user.getUsername(), ErrorDescription.USERNAME_REQUIRED);
		} else if (key.equals("EDIT")) {
			Validate.objectNotNull(user.getId(), ErrorDescription.USER_EMPTY);
			Validate.objectNotNull(user.getModifiedBy(), ErrorDescription.CREATED_BY_REQUIRED);
			Validate.objectNotNull(user.getRoleMaster(), ErrorDescription.ROLE_EMPTY);
			Validate.objectNotNull(user.getUsername(), ErrorDescription.USERNAME_REQUIRED);
		} else if (key.equals("GET") || key.equals("DELETE")) {
			Validate.objectNotNull(user, ErrorDescription.USER_EMPTY);
			Validate.objectNotNull(user.getId(), ErrorDescription.USER_EMPTY);

		}
		log.info("<<<<<< ======= End ValidateUser==============>>>>>.");
	}

	public void validateUser(UserMasterDTO user, String key) {
		log.info("<<<<<< ======= Start ValidateUser==============>>>>>.");
		Validate.objectNotNull(user, ErrorDescription.USER_EMPTY);
		if (key.equals("ADD")) {
			Validate.objectNotNull(user.getCreatedBy(), ErrorDescription.CREATED_BY_REQUIRED);
			Validate.objectNotNull(user.getPassword(), ErrorDescription.PASSWORD_REQUIRED);
			Validate.objectNotNull(user, ErrorDescription.USER_TYPE_REQUIRED);
			if (!user.getUserType().equals(UserType.EMPLOYEE))
				Validate.objectNotNull(user.getRoleMaster(), ErrorDescription.ROLE_EMPTY);
			Validate.objectNotNull(user.getUsername(), ErrorDescription.USERNAME_REQUIRED);
		} else if (key.equals("EDIT")) {
			Validate.objectNotNull(user.getId(), ErrorDescription.USER_EMPTY);
			Validate.objectNotNull(user.getModifiedBy(), ErrorDescription.CREATED_BY_REQUIRED);
			Validate.objectNotNull(user.getRoleMaster(), ErrorDescription.ROLE_EMPTY);
			Validate.objectNotNull(user.getUsername(), ErrorDescription.USERNAME_REQUIRED);
		} else if (key.equals("GET") || key.equals("DELETE")) {
			Validate.objectNotNull(user, ErrorDescription.USER_EMPTY);
			Validate.objectNotNull(user.getId(), ErrorDescription.USER_EMPTY);

		}
		log.info("<<<<<< ======= End ValidateUser==============>>>>>.");
	}

	public BaseDTO userSearch(UserMaster userMaster) {

		log.info("<<<<<< ======= Start UserMasterService.getAllUsersByPagination==============>>>>>.");
		BaseDTO response = new BaseDTO();
		try {

			Session session = em.unwrap(Session.class);
			Criteria criteria = session.createCriteria(UserMaster.class, "user");

			if (userMaster.getUsername() != null) {
				log.info("planFrom : " + userMaster.getUsername());
				criteria.add(Restrictions.eq("user.username", userMaster.getUsername()));
			}
			criteria.setProjection(Projections.rowCount());
			Integer totalResult = ((Long) criteria.uniqueResult()).intValue();
			criteria.setProjection(null);

			/*
			 * if (userMaster.getPagesize() != null && userMaster.getFirst()!=null ) {
			 * Integer pageNo = userMaster.getFirst(); Integer pageSize =
			 * userMaster.getPagesize();
			 * 
			 * if (pageNo != null && pageSize != null) { criteria.setFirstResult(pageNo *
			 * pageSize); criteria.setMaxResults(pageSize); log.info("PageNo : [" + pageNo +
			 * "] pageSize[" + pageSize + "]"); } }
			 */

			List<?> resultList = criteria.list();
			log.info("criteria list executed and the list size is  : " + resultList.size());

			if (resultList == null || resultList.isEmpty() || resultList.size() == 0) {
				log.info("User List is null or empty ");
			}
			response.setResponseContent(resultList);
			response.setStatusCode(ErrorDescription.USER_RETRIEVED_SUCCESSFULLY.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception while getAllUsersByPagination ====== >>>>>>", e);
		}
		log.info("<<<<<< ======= End UserMasterService.getAllUsersByPagination==============>>>>>.");
		return response;
	}

	/**
	 * @param userType
	 * @param userId
	 * @return
	 */
	public BaseDTO getInfoByUserType(UserType userType, Long userId) {

		log.info("UserType [" + userType + "] User ID [" + userId + "]");

		BaseDTO baseDTO = new BaseDTO();

		try {

			switch (userType) {
			case EMPLOYEE:
				// EmployeeMaster employeeMaster =
				// employeeMasterRepository.findEmployeeByUser(userId);
				// if (employeeMaster != null) {
				// log.info("employeeMaster - found for UserId: " + userId + " / And User Type:
				// " + userType);
				// baseDTO.setResponseContent(employeeMaster);
				// } else {
				// log.info("employeeMaster - NOT found for UserId: " + userId + " / And User
				// Type: " + userType);
				// }
				//
				// break;

			case SUPPLIER:
				List<SupplierMaster> supplierMasterList = supplierMasterRepository.findByUser(userId);
				if (supplierMasterList != null && !supplierMasterList.isEmpty()) {
					log.info("supplierMaster - found for UserId: " + userId + " / And User Type: " + userType);
					baseDTO.setResponseContent(supplierMasterList.get(0));
				}

				break;

			default:

			}

			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
		} catch (Exception exception) {
			log.error("Exception ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
		}

		return baseDTO;
	}

	public BaseDTO getUserById(UserMaster usermaster) {

		log.info("<--- UserMasterService .getUserById ---> ", usermaster);
		BaseDTO baseDTO = new BaseDTO();
		UserMasterDTO dto = new UserMasterDTO();
		try {

			UserMaster usermaster1 = userMasterRepository.findOne(usermaster.getId());
			if (usermaster1 != null) {
				dto.setId(usermaster1.getId());
				dto.setUsername(usermaster1.getUsername());
				dto.setUserType(usermaster1.getUserType());
				dto.setStatus(usermaster1.getStatus());
				dto.setCreatedBy(usermaster1.getCreatedBy());
				dto.setCreatedDate(usermaster1.getCreatedDate());
				
				EntityMaster entityMaster = entityMasterRepository.findOne(usermaster1.getEntityId());
				if(entityMaster != null) {
					dto.setStoreName(entityMaster.getName());
					dto.setStoreCode(entityMaster.getCode());
				}
				
				baseDTO.setResponseContent(dto);
				baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			} else {
				baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
			}

		} catch (Exception exception) {

		}
		return responseWrapper.send(baseDTO);

	}

	public BaseDTO getUserDetails() {

		log.info("UserMasterService getAllForwardToUsers method started ");
		BaseDTO baseDTO = new BaseDTO();
		try {
			UserMaster userMaster = new UserMaster();
			List<UserMaster> userMasterList = new ArrayList<>();
			List<Object> userDetails = userMasterRepository.findUserNameById(loginService.getCurrentUser().getId());
			Iterator<?> data = userDetails.iterator();
			while (data.hasNext()) {
				userMaster = new UserMaster();
				Object[] b = (Object[]) data.next();
				userMaster.setId((Long) b[0]);
				userMaster.setUsername(b[1].toString());
				// userMaster.setEntityId((Long) (b[2]));
				userMaster.setEntityCode((Long) b[3]);
				userMaster.setEntityName(b[4].toString());
				userMasterList.add(userMaster);
			}
			log.error("=== >> UserMasterService UserMasterList size  ===>> ", userMasterList.size());
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			baseDTO.setResponseContents(userMasterList);

		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
			log.error("=== >> Exception Occured in UserMaster Service ===>> ", e);
		}
		return responseWrapper.send(baseDTO);

	}

}
