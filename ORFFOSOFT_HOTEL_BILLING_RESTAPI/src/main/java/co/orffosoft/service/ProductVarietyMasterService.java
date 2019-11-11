package co.orffosoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.ErrorCodeDescription;
import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.ProductVarietyMasterDTO;
import co.orffosoft.dto.ProductVariryMastersearchDTO;
import co.orffosoft.dto.ProductVarityMasterResponse;
import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.entity.ProductVarietyMaster;
import co.orffosoft.entity.UomMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.UomMasterRepository;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.rest.util.ObjectConverter;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductVarietyMasterService {

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UomMasterRepository uomMasterRepository;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	ResponseWrapper responseWrapper;

	@Autowired
	LoginService loginService;

	@Transactional
	public BaseDTO create(ProductVarietyMasterDTO productVarietyMasterDTO) {
		log.info("ProductVarietyMasterService   create-------#Start");

		BaseDTO baseDto = new BaseDTO();
		try {

			if (productVarietyMasterDTO == null) {
				throw new RestException(ErrorDescription.REQUEST_OBJECT_SHOULD_NOT_EMPTY);

			}

			if (productVarietyMasterDTO.getCode() != null && !productVarietyMasterDTO.getCode().trim().equals("")) {
				ProductVarietyMaster productrep = productVarietyMasterRepository.findByCodeByUser(
						productVarietyMasterDTO.getCode().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (productrep != null) {

					log.info("Product Variety Code Allready Present");
					throw new RestException(ErrorDescription.ERROR_PRODUCT_VARIETY_CODE);
				}
			}

			if (productVarietyMasterDTO.getName() != null && !productVarietyMasterDTO.getName().trim().equals("")) {
				ProductVarietyMaster productrep = productVarietyMasterRepository.findByNameByUser(
						productVarietyMasterDTO.getName().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (productrep != null) {

					log.info("Product Variety Name Allready Present");
					throw new RestException(ErrorDescription.ERROR_PRODUCT_VARIETY_NAME);
				}
			}

			if (productVarietyMasterDTO != null) {
				ProductVarietyMaster productVarietyMaster = new ProductVarietyMaster();
				productVarietyMaster.setCode(productVarietyMasterDTO.getCode().trim());
				productVarietyMaster.setName(productVarietyMasterDTO.getName().trim());
				productVarietyMaster.setHsnCode(productVarietyMasterDTO.getHsnCode().trim());

				UserMaster createdBy = userMasterRepository.findOne(productVarietyMasterDTO.getCreatedBy().getId());

				productVarietyMaster.setCreatedBy(createdBy);
				productVarietyMaster.setCreatedDate(new Date());

				if (productVarietyMasterDTO.getUomMaster() != null
						&& productVarietyMasterDTO.getUomMaster().getId() != null) {
					UomMaster uomMaster = uomMasterRepository.findOne(productVarietyMasterDTO.getUomMaster().getId());
					productVarietyMaster.setUomMaster(uomMaster);
				} else {
					productVarietyMaster.setUomMaster(null);
				}
				if (productVarietyMasterDTO.getCgstPercentage() != null) {
					productVarietyMaster.setCgst_percentage(productVarietyMasterDTO.getCgstPercentage());
				}
				if (productVarietyMasterDTO.getSgstPercentage() != null) {
					productVarietyMaster.setCgst_percentage(productVarietyMasterDTO.getCgstPercentage());
				}
				if (productVarietyMasterDTO.getId() != null) {
					productVarietyMaster.setActiveStatus(productVarietyMasterDTO.isStatus());
				} else {
					productVarietyMaster.setActiveStatus(true);
				}

				productVarietyMaster.setUserId(loginService.getCurrentUser().getId());

				log.info("<<==== productVarietyMaster " + productVarietyMaster.getId());
				productVarietyMasterRepository.save(productVarietyMaster);
				baseDto.setStatusCode(0);
			}
		} catch (RestException restexp) {
			log.error("Exception occered ", restexp);
			baseDto.setStatusCode(restexp.getStatusCode());
		} catch (DataIntegrityViolationException diExp) {
			log.error("Exception occered ", diExp);
			baseDto.setStatusCode(1);
		}
		log.info("ProductVarietyMasterService create-------#End");
		return baseDto;
	}

	public WrapperDTO getProductVariery() {
		log.info("ProductVarietyMasterService   getProductVariery-------#Start");
		WrapperDTO wrapperDto = new WrapperDTO();
		List<ProductVarietyMasterDTO> productVarietyMAsterDtoList = new ArrayList<ProductVarietyMasterDTO>();
		try {
			List<ProductVarietyMaster> productVarietyMasterList = productVarietyMasterRepository.getProductList();
			for (ProductVarietyMaster productVarietyMaster : productVarietyMasterList) {
				ProductVarietyMasterDTO productVarietyMasterDTO = ObjectConverter
						.productVarietyMasterToProductVarietyMasterDTO(productVarietyMaster);
				productVarietyMAsterDtoList.add(productVarietyMasterDTO);
			}

			wrapperDto.setProductVarietyMasterDtoCollection(productVarietyMAsterDtoList);

			log.info("Size of productVarietyMAsterDtoList  :" + productVarietyMAsterDtoList.size());
			log.info("ProductVarietyMasterService   getProductVariery-------#End");
		} catch (Exception e) {
			log.info("-----------Data is not available------", e);
		}

		return wrapperDto;
	}

	@Transactional
	public BaseDTO update(ProductVarietyMasterDTO productVarietyMasterDTO) {
		log.info("ProductVarietyMasterService   update-------#Start");
		BaseDTO baseDto = new BaseDTO();
		try {
			if (productVarietyMasterDTO.getCode() != null && !productVarietyMasterDTO.getCode().trim().equals("")) {
				ProductVarietyMaster productrep = productVarietyMasterRepository.findByCodeByUser(
						productVarietyMasterDTO.getCode().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (productrep != null && !productrep.getId().equals(productVarietyMasterDTO.getId())) {
					log.info("Product Variety Code Allready Present");
					throw new RestException(ErrorDescription.ERROR_PRODUCT_VARIETY_CODE);
				}
			}

			if (productVarietyMasterDTO.getName() != null && !productVarietyMasterDTO.getName().trim().equals("")) {
				ProductVarietyMaster productrep = productVarietyMasterRepository.findByNameByUser(
						productVarietyMasterDTO.getName().trim().toLowerCase(), loginService.getCurrentUser().getId());
				if (productrep != null && !productrep.getId().equals(productVarietyMasterDTO.getId())) {
					log.info("Product Variety name Allready Present");
					throw new RestException(ErrorDescription.ERROR_PRODUCT_VARIETY_NAME);
				}
			}
			ProductVarietyMaster productVarietyMaster = productVarietyMasterRepository
					.findOne(productVarietyMasterDTO.getId());
			
			productVarietyMaster.setName(productVarietyMasterDTO.getName().trim());
			productVarietyMaster.setCode(productVarietyMasterDTO.getCode().trim());


			if (productVarietyMasterDTO.getUomMaster() != null
					&& productVarietyMasterDTO.getUomMaster().getId() != null) {
				UomMaster uomMaster = uomMasterRepository.findOne(productVarietyMasterDTO.getUomMaster().getId());
				productVarietyMaster.setUomMaster(uomMaster);
			} else {
				productVarietyMaster.setUomMaster(null);
			}
			productVarietyMaster.setHsnCode(productVarietyMasterDTO.getHsnCode().trim());

			if (productVarietyMasterDTO.getCgstPercentage() != null) {
				productVarietyMaster.setCgst_percentage(productVarietyMasterDTO.getCgstPercentage());
			}
			if (productVarietyMasterDTO.getSgstPercentage() != null) {
				productVarietyMaster.setCgst_percentage(productVarietyMasterDTO.getCgstPercentage());
			}
			productVarietyMaster.setActiveStatus(productVarietyMasterDTO.isStatus());
			productVarietyMaster.setModifiedBy(productVarietyMasterDTO.getUserMaster());

			productVarietyMasterRepository.save(productVarietyMaster);
			baseDto.setStatusCode(0);

			log.info("ProductVarietyMasterService   update-------#End");
		} catch (RestException restexp) {
			log.error("Exception occered ", restexp);
			baseDto.setStatusCode(restexp.getStatusCode());
		} catch (DataIntegrityViolationException diExp) {
			log.error("Exception occered ", diExp);
		}
		return baseDto;

	}

	@SuppressWarnings("unchecked")
	public WrapperDTO search(ProductVarietyMasterDTO productVarietyMasterDTO) {
		WrapperDTO wrapperDTO = new WrapperDTO();

		log.info("ProductVarietyMasterService   search-------#Start");
		Set<ProductVarietyMasterDTO> productVarietyMsterSet = new HashSet<ProductVarietyMasterDTO>();

		log.info("code  :" + productVarietyMasterDTO.getCode());
		log.info("name  :" + productVarietyMasterDTO.getName());
		log.info("Lname  :" + productVarietyMasterDTO.getLname());
		// log.info(" product category
		// id:"+productVarietyMasterDTO.getProductCategoryDTO().getId());
		try {
			List<ProductVarietyMaster> productVarietyMasterDtoListTemp = null;
			Session session = entityManager.unwrap(Session.class);
			Criteria criteria = session.createCriteria(ProductVarietyMaster.class);
			log.info("-----------criteria----------");
			if (productVarietyMasterDTO.getCode() != null && !productVarietyMasterDTO.getCode().trim().equals("")) {
				criteria.add(
						Restrictions.like("code", "%" + productVarietyMasterDTO.getCode().trim() + "%").ignoreCase());
			}
			if (productVarietyMasterDTO.getName() != null && !productVarietyMasterDTO.getName().trim().equals("")) {
				criteria.add(
						Restrictions.like("name", "%" + productVarietyMasterDTO.getName().trim() + "%").ignoreCase());
			}
			if (productVarietyMasterDTO.getLname() != null && !productVarietyMasterDTO.getLname().trim().equals("")) {
				criteria.add(
						Restrictions.like("lname", "%" + productVarietyMasterDTO.getLname().trim() + "%").ignoreCase());
			}

			if (productVarietyMasterDTO.getStatusValue() != null
					&& productVarietyMasterDTO.getStatusValue().length() > 0
					&& (productVarietyMasterDTO.isActiveStatus() || !productVarietyMasterDTO.isActiveStatus())) {

				log.info("active status is" + productVarietyMasterDTO.isActiveStatus());
				criteria.add(Restrictions.eq("activeStatus", productVarietyMasterDTO.isActiveStatus()));

			}

			criteria.addOrder(Order.desc("id"));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			productVarietyMasterDtoListTemp = criteria.list();
			log.info("--CriteriaList---" + criteria.list().toString());
			for (ProductVarietyMaster productVarietyMaster : productVarietyMasterDtoListTemp) {
				productVarietyMsterSet
						.add(ObjectConverter.productVarietyMasterToProductVarietyMasterDTO(productVarietyMaster));
				wrapperDTO.setProductVarietyMasterDtoCollection(productVarietyMsterSet);
			}
			if (productVarietyMsterSet.size() == 0) {
				log.info("Product variety not found");
				//wrapperDTO.setStatusCode(ErrorCodeDescription.PRODUCT_VARIETY_NOT_FOUND.getErrorCode());
			}
			log.info("no of search productVarietyMsterList :" + productVarietyMsterSet != null
					? productVarietyMsterSet.size()
					: 0);

		} catch (Exception e) {
			log.error(e);
		}

		return wrapperDTO;

	}

	public BaseDTO delete(Long id) {
		log.info("ProductVarietyMasterService Delete -->START" + id);
		BaseDTO baseDTO = new BaseDTO();
		try {
			if (id != null) {
				productVarietyMasterRepository.delete(id);
			}
			log.info("ProductVarietyMaster deleted successfully with Id" + id);
			baseDTO.setStatusCode(0);
			baseDTO.setErrorDescription("SUCCESS");
		} catch (DataIntegrityViolationException e) {
			log.error("Exception occered ", e);
			baseDTO.setStatusCode(ErrorDescription.THIS_RECORD_ALREADY_USED.getCode());
		} catch (Exception exp) {
			log.error("Exception occered ", exp);
		}
		log.info("<---Ends ProductVarietyMasterService .Delete ends--->" + baseDTO);
		return baseDTO;
	}

	public BaseDTO getVaritybyId(Long id) {
		log.info("ProductVarietyMasterService getmethod -->START", id);
		BaseDTO baseDTO = new BaseDTO();
		try {
			ProductVarietyMasterDTO productVarietyMasterDTO = new ProductVarietyMasterDTO();
			ProductVarietyMaster productVarietyMaster = productVarietyMasterRepository.findOne(id);

			if (productVarietyMaster != null) {
				productVarietyMasterDTO.setId(productVarietyMaster.getId());
				productVarietyMasterDTO.setCode(productVarietyMaster.getCode());
				productVarietyMasterDTO.setName(productVarietyMaster.getName());
				productVarietyMasterDTO.setHsnCode(productVarietyMaster.getHsnCode());
				productVarietyMasterDTO.setLname(productVarietyMaster.getLname());
				productVarietyMasterDTO.setStatus(productVarietyMaster.getActiveStatus());
				if(productVarietyMasterDTO.isStatus() == true) {
					productVarietyMasterDTO.setStatusValue("true");
				} else {
					productVarietyMasterDTO.setStatusValue("false");
				}
				productVarietyMasterDTO.setUomMaster(productVarietyMaster.getUomMaster());
				if (productVarietyMaster.getCgst_percentage() != null) {
					productVarietyMasterDTO.setCgstPercentage(productVarietyMaster.getCgst_percentage());
				}
				if (productVarietyMaster.getSgst_percentage() != null) {
					productVarietyMasterDTO.setSgstPercentage(productVarietyMaster.getSgst_percentage());
				}

				// ProductVarietyMasterDTO pvdto = ObjectConverter
				// .productVarietyMasterToProductVarietyMasterDTO(productVarietyMaster);
				// pvdto.setUomMaster(uomMasterRepository.findOne(productVarietyMaster.getUomMaster().getId()));

				baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
				baseDTO.setResponseContent(productVarietyMasterDTO);
			} else {
				baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
			}

		} catch (Exception exception) {
			log.error("exception at getVaritybyId", exception);
		}

		return baseDTO;
	}

	/*
	 * This method is used to search and getAll on load Varieties
	 */
	public BaseDTO searchProductVarities(ProductVariryMastersearchDTO productVariryMastersearchDTO) {

		if (productVariryMastersearchDTO == null) {
			throw new RestException(ErrorDescription.REQUEST_OBJECT_SHOULD_NOT_EMPTY);

		}

		log.info("productVariryMastersearchDTO === >>>", productVariryMastersearchDTO);
		BaseDTO baseDTO = new BaseDTO();
		Integer totalRecords = 0;
		Criteria criteria = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			criteria = session.createCriteria(ProductVarietyMaster.class, "productVarietyMaster");
			log.info(" Criterai Search Started ");

			if (!StringUtils.isEmpty(productVariryMastersearchDTO.getVarityCodeOrName())) {
				log.info("Product Variety CodeOrName == >", productVariryMastersearchDTO.getVarityCodeOrName());
				criteria.add(
						Restrictions.or(
								Restrictions
										.like("productVarietyMaster.code",
												"%" + productVariryMastersearchDTO.getVarityCodeOrName() + '%')
										.ignoreCase(),
								Restrictions
										.like("productVarietyMaster.name",
												"%" + productVariryMastersearchDTO.getVarityCodeOrName() + '%')
										.ignoreCase()));
			}

			if (!StringUtils.isEmpty(productVariryMastersearchDTO.getVarityCodeOrNameInTamil())) {
				log.info("Product Variety Tamil Name == >", productVariryMastersearchDTO.getVarityCodeOrNameInTamil());
				criteria.add(
						Restrictions.or(Restrictions
								.like("productVarietyMaster.lname",
										"%" + productVariryMastersearchDTO.getVarityCodeOrNameInTamil() + '%')
								.ignoreCase()));
			}

			if (productVariryMastersearchDTO.getActiveStatus() != null) {
				log.info("ActiveStatus  == >", productVariryMastersearchDTO.getActiveStatus());
				criteria.add(Restrictions.eq("productVarietyMaster.activeStatus",
						productVariryMastersearchDTO.getActiveStatus()));
			}

			if (productVariryMastersearchDTO.getCreatedDate() != null) {
				log.info("CreatedDate :" + productVariryMastersearchDTO.getCreatedDate());

				java.sql.Date startDateTime = new java.sql.Date(
						productVariryMastersearchDTO.getCreatedDate().getTime());
				java.sql.Date endDateTime = new java.sql.Date(
						AppUtil.getEndDateTime(productVariryMastersearchDTO.getCreatedDate()).getTime());

				criteria.add(Restrictions.between("productVarietyMaster.createdDate", startDateTime, endDateTime));

				/*
				 * criteria.add(Restrictions.eq( "productVarietyMaster.createdDate",
				 * productVariryMastersearchDTO.getCreatedDate()));
				 */
			}
			criteria.add(Restrictions.isNotNull("productVarietyMaster.userId"));
			if (loginService.getCurrentUser().getId() != 809) {
				criteria.add(Restrictions.eq("productVarietyMaster.userId", loginService.getCurrentUser().getId()));
			}

			log.info("Critera == >>>" + criteria);

			criteria.setProjection(Projections.rowCount());
			totalRecords = ((Long) criteria.uniqueResult()).intValue();
			criteria.setProjection(null);

			if (productVariryMastersearchDTO.getPaginationDTO() != null) {
				Integer pageNo = productVariryMastersearchDTO.getPaginationDTO().getPageNo();
				Integer pageSize = productVariryMastersearchDTO.getPaginationDTO().getPageSize();

				if (pageNo != null && pageSize != null) {
					criteria.setFirstResult(pageNo * pageSize);
					criteria.setMaxResults(pageSize);
					log.info("PageNo : [" + pageNo + "] pageSize[" + pageSize + "]");
				}

				String sortField = productVariryMastersearchDTO.getPaginationDTO().getSortField();
				String sortOrder = productVariryMastersearchDTO.getPaginationDTO().getSortOrder();
				if (sortField != null && sortOrder != null) {
					log.info("sortField : [" + sortField + "] sortOrder[" + sortOrder + "]");

					if (sortField.equals("varityCodeOrName")) {
						sortField = "productVarietyMaster.code";
					} else if (sortField.equals("activeStatus")) {
						sortField = "productVarietyMaster.activeStatus";
					}

					if (sortOrder.equals("DESCENDING")) {
						criteria.addOrder(Order.desc(sortField));
					} else {
						criteria.addOrder(Order.asc(sortField));
					}
				} else {
					criteria.addOrder(Order.desc("createdDate"));
				}
			}

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("productVarietyMaster.id"));
			projectionList.add(Projections.property("productVarietyMaster.name"));
			projectionList.add(Projections.property("productVarietyMaster.code"));
			projectionList.add(Projections.property("productVarietyMaster.createdDate"));
			projectionList.add(Projections.property("productVarietyMaster.activeStatus"));
			criteria.setProjection(projectionList);

			List<?> resultList = criteria.list();

			if (resultList == null || resultList.isEmpty() || resultList.size() == 0) {
				log.info("Product Variety Master List is null or empty ");
				baseDTO.setStatusCode(ErrorDescription.PRODUCT_VARIETY_LIST_EMPTY.getCode());
				return baseDTO;
			}
			log.info("criteria list executed and the list size is  : " + resultList.size());
			List<ProductVarityMasterResponse> varityMasterResponseDTOList = new ArrayList<>();

			Iterator<?> it = resultList.iterator();
			while (it.hasNext()) {
				Object ob[] = (Object[]) it.next();

				ProductVarityMasterResponse varityMasterResponse = new ProductVarityMasterResponse();
				varityMasterResponse.setVarityId((Long) ob[0]);
				varityMasterResponse.setVarityName((String) ob[1]);
				varityMasterResponse.setVaritycode((String) ob[2]);
				varityMasterResponse.setCreatedDate((Date) ob[3]);
				varityMasterResponse.setActiveStatus((Boolean) ob[4]);
				log.info(varityMasterResponse);
				varityMasterResponseDTOList.add(varityMasterResponse);
			}
			baseDTO.setResponseContent(varityMasterResponseDTOList);
			baseDTO.setTotalRecords(totalRecords);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (RestException re) {
			baseDTO.setStatusCode(re.getStatusCode());
		} catch (JDBCException jdbcExp) {
			log.error("<< JDBC Exception ==>>", jdbcExp);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		} catch (Exception exp) {
			log.error("<<== Exception In Search Service == >>", exp);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		log.info("<< == End Of Product Variety Master Search Method ==>>");

		return responseWrapper.send(baseDTO);
	}

	public BaseDTO getUOM() {

		BaseDTO baseDTO = new BaseDTO();

		try {

			List<UomMaster> uommaster = uomMasterRepository.findAll();

			if (uommaster == null || uommaster.isEmpty()) {

				throw new RestException(ErrorDescription.UOM_MASTER_SHOULD_NOT_EMPTY);

			}
			log.info(" uom master listsize", uommaster.size());
			baseDTO.setResponseContent(uommaster);

			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());

		} catch (RestException e) {
			baseDTO.setStatusCode(ErrorDescription.UOM_MASTER_SHOULD_NOT_EMPTY.getCode());

		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());

		}
		log.info(" response object", baseDTO);
		return responseWrapper.send(baseDTO);
	}

	public BaseDTO getAllProductVarietys() {
		log.info("ProductVarietyMasterService   getAllProductVarietys-------#Start");
		BaseDTO baseDTO = new BaseDTO();
		try {
			List<ProductVarietyMaster> productVarietyList = productVarietyMasterRepository.findAll();
			baseDTO.setResponseContents(productVarietyList);
			log.info("Size of productVarietyMAster  :" + productVarietyList.size());
			log.info("ProductVarietyMasterService   getAllProductVarietys-------#End");
		} catch (Exception e) {
			log.info("-----------Data is not available------", e);
		}
		return baseDTO;
	}

}
