package co.orffosoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.PaginationRequestData;
import co.orffosoft.core.util.PaginationResponseData;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.Validate;
import co.orffosoft.dto.AppFeatureDto;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.RoleDTO;
import co.orffosoft.entity.AppFeature;
import co.orffosoft.entity.Application;
import co.orffosoft.entity.RoleMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.repository.ApplicationRepository;
import co.orffosoft.repository.CacheRepository;
import co.orffosoft.repository.FeatureRepository;
import co.orffosoft.repository.RoleMasterRepository;
import co.orffosoft.repository.UserMasterRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RoleMasterService {

	@Autowired
	RoleMasterRepository roleMasterRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	FeatureRepository featureRepository;

	@Autowired
	CacheRepository cacheRepository;

	@Autowired
	UserMasterRepository userMasterRepo;
	
	@Autowired
	ApplicationRepository applicationRepository;

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public BaseDTO addRoleDetails(RoleMaster roleMaster) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start RoleService.addUserDetails ---------- >>>>>>>");
			addRoleDetailsValidator(roleMaster);
			UserMaster createdUser = userMasterRepo.findOne(roleMaster.getCreatedBy());
			Validate.notNull(createdUser, ErrorDescription.USER_DOES_NOT_EXISTS);
			roleMaster.setCreatedBy(createdUser.getId());
			roleMaster.setCreatedDate(new Date());
			roleMaster.setFeature(new ArrayList<>());

			roleMaster.getFeature().stream().forEach(appFeature -> {
				AppFeature feat = featureRepository.findOne(appFeature.getId());
				if (feat != null)
					roleMaster.getFeature().add(feat);
			});

			cacheRepository.save(RoleMaster.class.getName(), roleMaster, roleMasterRepository);
			response.setStatusCode(ErrorDescription.ROLE_ADDED_SUCCESSFULLY.getErrorCode());
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
				if (duplicateInputValue.equals(roleMaster.getRoleName())) {
					response.setStatusCode(ErrorDescription.ROLENAME_ALREADY_EXISTS.getErrorCode());
				}
			}
		} catch (RestException re) {
			log.warn("Error while adding role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Error while adding role=====", e);
		}
		log.info("<<<< ------- End RoleService.addUserDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO updateRoleDetails(RoleDTO roleDto) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start RoleService.updateRoleDetails ---------- >>>>>>>");
			updateRoleMasterValidator(roleDto);
			UserMaster modifiedUser = userMasterRepo.findOne(roleDto.getModifiedBy());
			Validate.notNull(modifiedUser, ErrorDescription.USER_DOES_NOT_EXISTS);
			RoleMaster roleMaster=roleMasterRepository.findOne(roleDto.getId());
			roleMaster.setModifiedDate(new Date());
			// List<AppFeature> featureList=roleMaster.getFeature();
			roleMaster.setFeature(new ArrayList<>());
			roleMaster.setRoleName(roleDto.getRoleName());
			roleMaster.setStatus(true);
			Application app=applicationRepository.findOne(roleDto.getApplication().getId());
			if(app!=null)
				roleMaster.setApplication(app);
			List<Long> chilFeatures=roleDto.getFeaturesList();
			roleDto.getFeaturesList().stream().forEach(appFeature -> {
				AppFeature feat = featureRepository.findOne(appFeature);
				if (feat != null)
					roleMaster.getFeature().add(feat);
				if(feat.getParent()!=null)
					checkParentExists(feat,roleMaster,chilFeatures);
				
			});
			roleMaster.setFeature(new ArrayList<AppFeature>(new LinkedHashSet<AppFeature>(roleMaster.getFeature())));
			/*
			 * for(AppFeature app:featureList) { AppFeature
			 * feat=featureRepository.findOne(app.getId()); if(feat!=null)
			 * roleMaster.getFeature().add(feat); }
			 */
			cacheRepository.remove(RoleMaster.class.getName(), roleMaster.getId());
			cacheRepository.save(RoleMaster.class.getName(), roleMaster, roleMasterRepository);
			response.setStatusCode(ErrorDescription.ROLE_UPDATED_SUCCESSFULLY.getErrorCode());
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
				if (duplicateInputValue.equals(roleDto.getRoleName())) {
					response.setStatusCode(ErrorDescription.ROLENAME_ALREADY_EXISTS.getErrorCode());
				}
			}
		} catch (ObjectOptimisticLockingFailureException lockEx) {
			log.warn("====>> Error while updateRoleDetails <<====", lockEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_LOCKED_RECORD.getErrorCode());
		} catch (JpaObjectRetrievalFailureException ObjFailEx) {
			log.warn("====>> Error while updateRoleDetails <<====", ObjFailEx);
			response.setStatusCode(ErrorDescription.CANNOT_UPDATE_DELETED_RECORD.getErrorCode());
		} catch (RestException re) {
			log.warn("Error while updating role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Error while updating role=====", e);
		}
		log.info("<<<< ------- End RoleService.updateRoleDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO getRoleDetails(RoleMaster roleMaster) {
		BaseDTO response = new BaseDTO();
		RoleMaster roleResponse = null;
		try {
			log.info("<<<< ------- Start RoleService.getRoleDetails ---------- >>>>>>>");
			getRoleMasterDetailsValidator(roleMaster);
			roleResponse = cacheRepository.get(RoleMaster.class.getName(), roleMaster.getId(), roleMasterRepository);
			RoleDTO role=new RoleDTO();
			role.setRoleName(roleResponse.getRoleName());
			role.setApplication(roleResponse.getApplication());
			List<Long> featureIds=new ArrayList<>();
 			for(AppFeature feature:roleResponse.getFeature())
			{
 				featureIds.add(feature.getId());
			}
			role.setFeaturesList(featureIds);
			response.setStatusCode(ErrorDescription.ROLE_RETRIEVED_SUCCESSFULLY.getErrorCode());
			response.setResponseContent(role);
		} catch (RestException re) {
			log.warn("Error while get role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Error while get role=====", e);
		}
		log.info("<<<< ------- End RoleService.getRoleDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO getAllRoleDetails() {
		BaseDTO response = new BaseDTO();
		List<RoleMaster> roleMasterList = new ArrayList<>();
		try {
			log.info("<<<< ------- Role master service get all service called---------- >>>>>>>");
			Sort sort = new Sort(Sort.Direction.DESC, "id");
//			roleMasterList = cacheRepository.getAll(RoleMaster.class.getName(), roleMasterRepository, sort);
			roleMasterList = roleMasterRepository.findAllRoleMaster();
			List<RoleMaster> roleMasterListResponse = new ArrayList<>();
			for(RoleMaster roleMaster : roleMasterList)
			{
				UserMaster master = userMasterRepo.findOne(roleMaster.getCreatedBy());
				roleMaster.setCreatedByName(master.getUsername());
				roleMasterListResponse.add(roleMaster);
			}
			response.setStatusCode(ErrorDescription.ROLE_LIST_RETRIEVED.getErrorCode());
			response.setResponseContents(roleMasterListResponse);
			log.info("<----Role masters fetched succssfully, No of records-->"+roleMasterListResponse.size());
		} catch (RestException re) {
			log.warn("Error while get All role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End RoleService.getRoleDetails ---------- >>>>>>>");
		return response;
	}
	
	public BaseDTO getAllActiveRoleDetails() {
		BaseDTO response = new BaseDTO();
		List<RoleMaster> roleMasterList = new ArrayList<>();
		try {
			log.info("<<<< ------- Role master service get all Active service called---------- >>>>>>>");
			Sort sort = new Sort(Sort.Direction.DESC, "id");
			roleMasterList = cacheRepository.getAll(RoleMaster.class.getName(), roleMasterRepository, sort);
			roleMasterList = roleMasterRepository.findAll();
			response.setStatusCode(ErrorDescription.ROLE_LIST_RETRIEVED.getErrorCode());
			response.setResponseContents(roleMasterList);
			log.info("<----Role masters fetched succssfully, No of records-->"+roleMasterList.size());
		} catch (RestException re) {
			log.warn("Error while get All role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End RoleService.getRoleDetails Active ---------- >>>>>>>");
		return response;
	}

	public BaseDTO getAllRoleDetailsLazy(PaginationRequestData req) {
		BaseDTO response = new BaseDTO();
		Page<RoleMaster> roleMasterList = null;
		try {
			log.info("<<<< ------- Start RoleService.getRoleDetails ---------- >>>>>>>");
			PaginationResponseData data = new PaginationResponseData();
			Pageable pagerequest = new PageRequest(req.getPageNo(), req.getPaginationSize());
			roleMasterList = roleMasterRepository.findAll(pagerequest);
			response.setStatusCode(ErrorDescription.ROLE_LIST_RETRIEVED.getErrorCode());
			if (roleMasterList != null) {
				data.setContents(roleMasterList.getContent());
				data.setNumberOfElements(roleMasterList.getNumberOfElements());
				data.setTotalElements(roleMasterList.getTotalElements());
				data.setTotalPages(roleMasterList.getTotalPages());
			} else {
				data.setNumberOfElements(0);
				data.setTotalElements(0l);
				data.setTotalPages(0);
			}
			response.setPaginationResponseData(data);
		} catch (RestException re) {
			log.warn("Error while getting role details lazy=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End RoleService.getRoleDetails ---------- >>>>>>>");
		return response;
	}

	public BaseDTO searchRoles(RoleMaster roleMaster) {
		log.info("<<<<<< ======= Start RoleMasterService.searchRoles==============>>>>>.");
		BaseDTO response = new BaseDTO();
		try {

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

			CriteriaQuery<RoleMaster> criteriaQuery = criteriaBuilder.createQuery(RoleMaster.class);
			Root<RoleMaster> from = criteriaQuery.from(RoleMaster.class);

			ParameterExpression<String> rolenameParam = criteriaBuilder.parameter(String.class, "name");
			ParameterExpression<Boolean> statusParam = criteriaBuilder.parameter(Boolean.class, "status");

			Predicate condition = criteriaBuilder.and(
					criteriaBuilder.or(criteriaBuilder.isNull(rolenameParam),
							criteriaBuilder.equal(from.get("roleName"), rolenameParam)),
					criteriaBuilder.or(criteriaBuilder.isNull(statusParam),
							criteriaBuilder.equal(from.get("status"), statusParam)));

			criteriaQuery.where(condition);

			TypedQuery<RoleMaster> typedQuery = em.createQuery(criteriaQuery);
			typedQuery.setParameter("name", roleMaster.getRoleName());
			typedQuery.setParameter("status", roleMaster.getStatus());
//			typedQuery.setFirstResult(roleMaster.getFirst());
//			typedQuery.setMaxResults(roleMaster.getPagesize());
			List<RoleMaster> roleMasterList = typedQuery.getResultList();
			response.setResponseContents(roleMasterList);
			response.setStatusCode(ErrorDescription.ROLE_RETRIEVED_SUCCESSFULLY.getErrorCode());
		} catch (Exception e) {
			log.error("Exception while searchRoles ====== >>>>>>", e);
		}
		log.info("<<<<<< ======= End RoleMasterService.searchRoles==============>>>>>.");
		return response;
	}
	public BaseDTO addRoleDetailsDto(RoleDTO roleMasterDto) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start RoleService.addUserDetails ---------- >>>>>>>");
			addRoleDetailsValidatorDto(roleMasterDto);
			UserMaster createdUser = userMasterRepo.findOne(roleMasterDto.getCreatedBy());
			Validate.notNull(createdUser, ErrorDescription.USER_DOES_NOT_EXISTS);
			RoleMaster roleMaster=new RoleMaster();
			roleMaster.setCreatedBy(createdUser.getId());
			roleMaster.setCreatedDate(new Date());
			roleMaster.setFeature(new ArrayList<>());
			roleMaster.setRoleName(roleMasterDto.getRoleName());
			roleMaster.setStatus(true);
			Application app=applicationRepository.findOne(roleMasterDto.getApplication().getId());
			roleMaster.setApplication(app);
			List<Long> chilFeatures=roleMasterDto.getFeaturesList();
			
			roleMasterDto.getFeaturesList().stream().forEach(appFeature -> {
				if(appFeature!=null)
				{
				AppFeature feat = featureRepository.findOne(appFeature);
				
				if (feat != null)
					roleMaster.getFeature().add(feat);
				if(feat.getParent()!=null)
					checkParentExists(feat,roleMaster,chilFeatures);
				}
				
			});

		roleMaster.setFeature(new ArrayList<AppFeature>(new LinkedHashSet<AppFeature>(roleMaster.getFeature())));
			cacheRepository.save(RoleMaster.class.getName(), roleMaster, roleMasterRepository);
			response.setStatusCode(ErrorDescription.ROLE_ADDED_SUCCESSFULLY.getErrorCode());
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
				if (duplicateInputValue.equals(roleMasterDto.getRoleName())) {
					response.setStatusCode(ErrorDescription.ROLENAME_ALREADY_EXISTS.getErrorCode());
				}
			}
		} catch (RestException re) {
			log.warn("Error while adding role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Error while adding role=====", e);
		}
		log.info("<<<< ------- End RoleService.addUserDetails ---------- >>>>>>>");
		return response;
	}
	
	public void checkParentExists(AppFeature feature,RoleMaster role,List<Long> featureList)
	{
		log.info("Feature list....."+featureList);
		log.info("parent id..."+feature.getId());
			if(!featureList.contains(feature.getId()))
				role.getFeature().add(feature);
			
			if(feature.getParent()!=null)
				checkParentExists(feature.getParent(),role,featureList);
	}
	
	public BaseDTO getRoleDetailsDto(RoleDTO roleMasterDto) {
		BaseDTO response = new BaseDTO();
		RoleMaster roleResponse = null;
		try {
			log.info("<<<< ------- Start RoleService.getRoleDetailsDto ---------- >>>>>>>");
			getRoleMasterDetailsValidator(roleMasterDto);
			roleResponse = cacheRepository.get(RoleMaster.class.getName(), roleMasterDto.getId(), roleMasterRepository);
			response.setStatusCode(ErrorDescription.ROLE_RETRIEVED_SUCCESSFULLY.getErrorCode());
			response.setResponseContent(roleResponse);
		} catch (RestException re) {
			log.warn("Error while get role=====", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Error while get role=====", e);
		}
		log.info("<<<< ------- End RoleService.getRoleDetailsDto ---------- >>>>>>>");
		return response;
	}
	
	public BaseDTO getAllAppfeatureDto(List<AppFeature> appFeatureList) {
		BaseDTO response = new BaseDTO();
		try {
			log.info("<<<< ------- Start AppfeatureService.getAllAppfeature ---------- >>>>>>>");
			Validate.objectNotNull(appFeatureList, ErrorDescription.APPFEATURE_EMPTY);
			List<AppFeatureDto> features = new ArrayList<AppFeatureDto>();
			if (appFeatureList != null && appFeatureList.size() > 0) {
				for (AppFeature appFeature : appFeatureList) {
					AppFeatureDto featureDto = new AppFeatureDto();
					
					featureDto.setFeatureName(appFeature.getFeatureName());
					featureDto.setId(appFeature.getId());
				
					AppFeatureDto parentFeatureDto = null;
					if (appFeature.getParent() != null) {
						parentFeatureDto = new AppFeatureDto();
						
						parentFeatureDto.setFeatureName(appFeature.getParent()
								.getFeatureName());
						parentFeatureDto.setId(appFeature.getParent().getId());
				
					}
					featureDto.setParent(parentFeatureDto);
					features.add(featureDto);
					// log.info("------added to the features and the length---:"+features.size());
				}
			}
			
			List<AppFeatureDto> appFeatureDtos2 = new ArrayList<AppFeatureDto>();
			for (AppFeature appFeature : appFeatureList) {

				AppFeatureDto appFeatureDto = new AppFeatureDto();

				List<AppFeature> appFeatureDtos3 = appFeature.getFeatures();
				List<AppFeatureDto> appFeatureDtos4 = new ArrayList<AppFeatureDto>();
//				BeanUtils.copyProperties(appFeatureDto,appFeature);
				appFeatureDto=appfeatureToAppfeatureDto(appFeature);
				Map<String, Boolean> map = new HashMap<String, Boolean>();
				Map<String, Long> featureMap = new HashMap<String, Long>();
				for (AppFeature appFeature2 : appFeatureDtos3) {
					AppFeatureDto appFeatureDto1 = new AppFeatureDto();
//					BeanUtils.copyProperties( appFeatureDto1,appFeature2);
					appFeatureDto1=appfeatureToAppfeatureDto(appFeature2);
					
					AppFeature feature = appFeature2.getParent();
					AppFeatureDto appFeatureDto2 = new AppFeatureDto();
//					BeanUtils.copyProperties( appFeatureDto2,feature);

					appFeatureDto2=appfeatureToAppfeatureDto(feature);
					appFeatureDto1.setParent(appFeatureDto2);
					appFeatureDtos4.add(appFeatureDto1);
					
					
						map.put(appFeature2.getActionKey(), true);
						featureMap.put(appFeature2.getActionKey(), appFeature2.getId());
						
					
				}
				appFeatureDto.setFeatures(appFeatureDtos4);
				appFeatureDto.setLeaf(map);
				appFeatureDto.setFeatureIds(featureMap);
				AppFeature parent1 = appFeature.getParent();
				if (parent1 != null) {
					AppFeatureDto parent = new AppFeatureDto();
//					BeanUtils.copyProperties( parent,parent1);
					parent=appfeatureToAppfeatureDto(parent1);
					appFeatureDto.setParent(parent);
				}

				appFeatureDtos2.add(appFeatureDto);

			}
			
			
			log.info("feature list size========>>.>>>>>"+features.size());
			log.info("feature list size========>>.>>>>>"+appFeatureList.size());
			response.setStatusCode(ErrorDescription.APPFEATURE_RETRIEVED_SUCCESSFULLY.getErrorCode());
			response.setResponseContents(appFeatureDtos2);
		} catch (RestException re) {
			log.warn("Exception While getAllAppfeature ===>>", re);
			response.setStatusCode(re.getStatusCode());
		} catch (Exception e) {
			log.error("Exception Occured ===>>", e);
		}
		log.info("<<<< ------- End AppfeatureService.getAllAppfeature ---------- >>>>>>>");
		return response;
	}
	public AppFeatureDto appfeatureToAppfeatureDto(AppFeature appfeature)
	{
		AppFeatureDto appDto=new AppFeatureDto();
		appDto.setId(appfeature.getId());
		appDto.setFeatureName(appfeature.getFeatureName());
		appDto.setDescription(appfeature.getDescription());
		
		if(appfeature.getPageName()!=null)
		{
			appDto.setPageName(appfeature.getPageName());
			try {
			String[] leaf=appfeature.getPageName().split(",");
			appDto.setAction(leaf[2]);
			} catch(Exception e)
			{
				appDto.setAction(appfeature.getPageName());
				log.info("Exception occure for=====>>>"+appfeature.getFeatureName());
			}
		}
		return appDto;
	}	public BaseDTO deleteRole(RoleMaster roleMaster) {
		log.info("<-----Delete role called---->");
		BaseDTO response =  new BaseDTO();
		try {
			Validate.objectNotNull(roleMaster.getId(), ErrorDescription.ROLE_ID_REQUIRED);
			String roleUserQuery = "delete from role_user where role_id="+roleMaster.getId();
			String roleFeatureQuery = "delete from role_feature where role_id="+roleMaster.getId();
			cacheRepository.remove(RoleMaster.class.getName(), roleMaster.getId());
			jdbcTemplate.execute(roleFeatureQuery);
			jdbcTemplate.execute(roleUserQuery);
			roleMasterRepository.delete(roleMaster.getId());
			
			
			response.setStatusCode(0);
			return response;
			
		}catch(RestException e) {
			log.info("exception occured while delting==>"+e.getStatusCode());
			response.setStatusCode(e.getStatusCode());
			return response;
		}catch (DataIntegrityViolationException divEX) {
			log.warn("Exception :: -- > " + divEX.getCause().getCause().getMessage());
			return response;
		}
	}
	public void addRoleDetailsValidator(RoleMaster roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getRoleName(), ErrorDescription.ROLE_NAME_REQUIRED);
		Validate.objectNotNull(roleMaster, ErrorDescription.LROLE_NAME_REQUIRED);
	}
	public void addRoleDetailsValidatorDto(RoleDTO roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getRoleName(), ErrorDescription.ROLE_NAME_REQUIRED);
		Validate.objectNotNull(roleMaster, ErrorDescription.LROLE_NAME_REQUIRED);
	}

	public void updateRoleMasterValidator(RoleMaster roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getId(), ErrorDescription.ROLE_ID_REQUIRED);
		Validate.objectNotNull(roleMaster.getRoleName(), ErrorDescription.ROLE_NAME_REQUIRED);
		Validate.objectNotNull(roleMaster.getFeatList(), ErrorDescription.APPFEATURE_EMPTY);
	}
	public void updateRoleMasterValidator(RoleDTO roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getId(), ErrorDescription.ROLE_ID_REQUIRED);
		Validate.objectNotNull(roleMaster.getRoleName(), ErrorDescription.ROLE_NAME_REQUIRED);
		Validate.objectNotNull(roleMaster.getFeaturesList(), ErrorDescription.APPFEATURE_EMPTY);
	}

	public void getRoleMasterDetailsValidator(RoleMaster roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getId(), ErrorDescription.ROLE_ID_REQUIRED);
	}
	public void getRoleMasterDetailsValidator(RoleDTO roleMaster) {
		Validate.objectNotNull(roleMaster, ErrorDescription.ROLE_EMPTY);
		Validate.objectNotNull(roleMaster.getId(), ErrorDescription.ROLE_ID_REQUIRED);
	}
}
