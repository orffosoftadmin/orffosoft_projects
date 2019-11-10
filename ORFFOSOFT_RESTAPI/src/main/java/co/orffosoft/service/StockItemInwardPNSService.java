package co.orffosoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.StockTransactionTypeIFC;
import co.orffosoft.core.util.Validate;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.StockItemInwardPNSDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.GoodsReceiptNote_D;
import co.orffosoft.entity.GoodsReceiptNote_H;
import co.orffosoft.entity.ItemPrice;
import co.orffosoft.entity.ProductVarietyMaster;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.entity.StockTransaction;
import co.orffosoft.entity.StockTransactionType;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.enums.SequenceName;
import co.orffosoft.enums.StockTransferStatus;
import co.orffosoft.enums.StockTransferType;
import co.orffosoft.repository.EntityMasterRepository;
import co.orffosoft.repository.GoodsReceiptNote_D_Repository;
import co.orffosoft.repository.GoodsReceiptNote_H_Repository;
import co.orffosoft.repository.ItemPriceRepository;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.SequenceConfigRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import co.orffosoft.repository.SupplierMasterRepository;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StockItemInwardPNSService {

	@Autowired
	SupplierMasterRepository supplierMasterRepository;

	@Autowired
	SequenceConfigRepository sequenceConfigRepository;

	@Autowired
	LoginService loginService;

	@Autowired
	EntityManager entityManager;

	@Autowired
	SequenceConfigService sequenceConfigService;

	@Autowired
	ResponseWrapper responseWrapper;

	
	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@Autowired
	EntityMasterRepository entityMasterRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	GoodsReceiptNote_D_Repository goodsReceiptNote_D_Repository;

	@Autowired
	GoodsReceiptNote_H_Repository goodsReceiptNote_H_Repository;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	ItemPriceRepository itemPriceRepository;

	public BaseDTO getAllProductVariety() {

		log.info("<-Inside SERVICE-Starts AllProductVariety-->");
		BaseDTO baseDTO = new BaseDTO();
		try {
			List<ProductVarietyMaster> productVarietyList = productVarietyMasterRepository
					.getProductVarietyItemInward();
			baseDTO.setResponseContent(productVarietyList);
			baseDTO.setTotalRecords(productVarietyList.size());
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("<-AllProductVariety GetAll Data Success-->");
		} catch (Exception exception) {
			log.error("exception Occured AllProductVariety : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;
	}

	@Transactional
	public BaseDTO saveStockItem(StockItemInwardPNSDTO stockUpload) {
		log.info("<-Inside SERVICE-Starts saveStockItem-->");
		BaseDTO baseDTO = new BaseDTO();
		GoodsReceiptNote_H goodsReceiptNote_H = new GoodsReceiptNote_H();
		try {

			// Save to Header Table
			if (stockUpload.getGoodsReceiptNote_H().getGrn_h_id() == null) {
				goodsReceiptNote_H = saveGoodsReceiptNote_H(stockUpload);
			}

			if (goodsReceiptNote_H.getGrn_h_id() != null) {
				// Save to Header Table
				saveGoodsReceiptNote_D(stockUpload, goodsReceiptNote_H);
			}

			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (Exception exception) {
			log.error("exception Occured saveStockItem : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;
	}

	@Transactional
	private void saveGoodsReceiptNote_D(StockItemInwardPNSDTO stockUpload, GoodsReceiptNote_H goodsReceiptNote_h) {
		StockTransaction stockTransaction = new StockTransaction();
		ItemPrice itemPrice = new ItemPrice();
		if (stockUpload.getGoodsReceiptNote_DList() != null) {
			StockTransactionType st = stockTransactionTypeRepository.getGRNID(StockTransactionTypeIFC.GRN);
			for (GoodsReceiptNote_D grnd : stockUpload.getGoodsReceiptNote_DList()) {
				stockTransaction = new StockTransaction();
				grnd.setGoodsReceiptNote_H(goodsReceiptNote_h);
				grnd.setProductVarietyMaster(
						productVarietyMasterRepository.findOne(grnd.getProductVarietyMaster().getId()));
				grnd.setGrn_D_Date(new Date());
				grnd.setGrn_D_Reject_Qnty(grnd.getGrn_D_Item_Qnty() - grnd.getGrn_D_Accepted_Qnty());
				grnd.setCreatedBy(loginService.getCurrentUser());
				grnd.setCreatedDate(new Date());

				// For Stock Update In Stock Transaction Table

				stockTransaction.setStock_tran_grn_h_id_fk(goodsReceiptNote_h.getGrn_h_id());
				stockTransaction
						.setStock_tran_supplier_id_fk(stockUpload.getGoodsReceiptNote_H().getSupplierMaster().getId());
				stockTransaction.setStock_tran_sku_id_fk(grnd.getProductVarietyMaster().getId());
				stockTransaction.setStock_tran_date(new Date());
				stockTransaction.setStock_tran_type_fk(st.getStock_tran_type_pk());
				StockTransaction stockTran = stockTransactionRepository
						.getSkuId(grnd.getProductVarietyMaster().getId());
				
				if (stockTran == null) {
					stockTransaction.setStock_tran_opening_bal(grnd.getGrn_D_Accepted_Qnty());
					stockTransaction.setStock_tran_received_qnty(grnd.getGrn_D_Accepted_Qnty());
					stockTransaction.setStock_tran_closing_bal(grnd.getGrn_D_Accepted_Qnty());
				} else {
					stockTransaction.setStock_tran_received_qnty(grnd.getGrn_D_Accepted_Qnty());
					stockTransaction.setStock_tran_closing_bal(
							stockTran.getStock_tran_closing_bal() + grnd.getGrn_D_Accepted_Qnty());
				}
				stockTransaction.setStock_tran_issued_qnty(0L);
				if (grnd.getGrn_D_Selling_Amount() != null) {
					stockTransaction.setStock_tran_sellingprice(grnd.getGrn_D_Selling_Amount());
				}
				if (grnd.getGrn_D_Purchase_Amount() != null) {
					stockTransaction.setStock_tran_purchaseprice(grnd.getGrn_D_Purchase_Amount());
				}
				stockTransaction.setCreated_by(loginService.getCurrentUser().getId());
				stockTransaction.setCreated_date(new Date());
				stockTransactionRepository.save(stockTransaction);
				
				// For Item Price update simultaneously using itemPrice Table
				itemPrice = new ItemPrice();
				itemPrice.setItemprice_stock_tran_fk(stockTransaction.getStock_tran_pk());
				itemPrice.setItemprice_grn_h_fk(stockTransaction.getStock_tran_grn_h_id_fk());
				itemPrice.setItemprice_sku_fk(stockTransaction.getStock_tran_sku_id_fk());
				itemPrice.setItemprice_purchase_price(stockTransaction.getStock_tran_purchaseprice());
				itemPrice.setItemprice_selling_price(stockTransaction.getStock_tran_sellingprice());
				itemPrice.setItemprice_old_price(stockTransaction.getStock_tran_sellingprice());
				itemPrice.setItemprice_new_price(stockTransaction.getStock_tran_sellingprice());
				itemPrice.setItemprice_type("GRN Price");
				itemPrice.setCreated_by(loginService.getCurrentUser().getId());
				itemPrice.setCreated_date(new Date());
				itemPriceRepository.save(itemPrice);

			}
		}
		goodsReceiptNote_D_Repository.save(stockUpload.getGoodsReceiptNote_DList());

	}

	private GoodsReceiptNote_H saveGoodsReceiptNote_H(StockItemInwardPNSDTO stockUpload) {
		GoodsReceiptNote_H goodsReceiptNote_H = new GoodsReceiptNote_H();
		
		goodsReceiptNote_H.setSupplierMaster(
				supplierMasterRepository.findOne(stockUpload.getGoodsReceiptNote_H().getSupplierMaster().getId()));
		SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.GRN);
		if (sequenceConfig == null) {
			log.error("Sequence Config not configured for GRN");
			new RestException("Sequence Config not configured for GRN");
		}
		EntityMaster entityMaster = entityMasterRepository.findOne(loginService.getCurrentUser().getEntityId());
		if (entityMaster == null ) {
			log.error("EntityMaster Id Not Found");
			new RestException("EntityMaster Id Not Found");
		}
		goodsReceiptNote_H.setGrn_H_Number(sequenceConfig.getPrefix() + "-" + entityMaster.getCode()+ "-" + sequenceConfig.getCurrentValue());
		goodsReceiptNote_H.setGrn_H_Date(new Date());
		goodsReceiptNote_H.setGrn_H_Total_Number(stockUpload.getGoodsReceiptNote_H().getGrn_H_Total_Number());
		goodsReceiptNote_H.setGrn_H_Gross_Amount(stockUpload.getGoodsReceiptNote_H().getGrn_H_Gross_Amount());
		goodsReceiptNote_H
				.setGrn_H_Discount_Percentage(stockUpload.getGoodsReceiptNote_H().getGrn_H_Discount_Percentage());
		goodsReceiptNote_H.setGrn_H_Discount_Amount(stockUpload.getGoodsReceiptNote_H().getGrn_H_Discount_Amount());
		goodsReceiptNote_H.setGrn_H_Status("Active");
		goodsReceiptNote_H.setUserMaster(userMasterRepository.findOne(loginService.getCurrentUser().getId()));
		goodsReceiptNote_H.setCreated_date(new Date());
		goodsReceiptNote_H = goodsReceiptNote_H_Repository.save(goodsReceiptNote_H);
		sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);
		sequenceConfigRepository.save(sequenceConfig);

		return goodsReceiptNote_H;

	}

	@Transactional
	// update StockItemPNS Inward
	public BaseDTO updateStockItemInward(StockItemInwardPNSDTO stockItems) {

		log.info("<-Inside SERVICE-Starts updateStockItem-->");
		BaseDTO baseDTO = new BaseDTO();
		// StockTransfer stockTransfer = stockItems.getStockTransfer();
		// List<StockTransferItems> stockTransferItemsList =
		// stockItems.getStockTransferItemsList();
		// List<StockTransferItems> stockTransferItemsDeleteList =
		// stockItems.getStockTransferItemsDeleteList();
		// List<PurchaseInvoice> purchaseInvoiceList =
		// stockItems.getPurchaseInvoiceList();
		Double size = 0.0;
//		EmployeeMaster empMaster = employeeMasterRepository.findEmployeeByUser(loginService.getCurrentUser().getId());
		try {
			// log.info("<===== StockTransfer Method Calling =========>");
			// StockTransfer stockTransferReturn = stocktransferDataUpdate(stockTransfer);
			//
			// log.info("<===== stockTransferItemListUpdate Method Calling =========>");
			// stockTransferItemListUpdate(stockTransferItemsList, stockTransferReturn);
			//
			// log.info("<===== purchaseInvoiceListUpdate Method Calling =========>");
			// purchaseInvoiceListUpdate(purchaseInvoiceList, stockTransferReturn);
			//
			// log.info("<===== stockItemInwardPNSDelete Method Calling =========>");
			// stockItemInwardPNSDelete(stockTransferItemsDeleteList);
			//
			// InventoryItems inventoryItems =
			// inventoryItemsRepository.findByStockInward(stockTransferReturn.getId());
			// if (inventoryItems == null) {
			// log.info("<- InventoryItems Creation New Processed-->");
			// inventoryItems = new InventoryItems();
			// inventoryItems.setReceivedQty(size);
			// inventoryItems.setProductVarietyMaster(stockTransferItemsList.get(0).getProductVarietyMaster());
			// inventoryItems.setEntityMaster(empMaster.getPersonalInfoEmployment().getWorkLocation());
			// inventoryItems.setStockTransferInward(stockTransferReturn);
			// inventoryItemsRepository.save(inventoryItems);
			// log.info("<- InventoryItemsUpdation Save Done size -->" + size + "," +
			// inventoryItems.getId());
			// } else {
			// log.info("<- InventoryItems Updation Processed-->");
			// inventoryItems.setReceivedQty(size);
			// inventoryItemsRepository.save(inventoryItems);
			// log.info("<- InventoryItemsUpdation Update Done size -->" + size + "," +
			// inventoryItems.getId());
			// }
			// log.info("<- updateStockItemInwardPNS InventoryItems Success-->" +
			// inventoryItems.getId());
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (Exception exception) {
			log.error("Exception Occured updateStockItemInwardPNS : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;
	}

	

	// This is method is used for LazySearch
	@SuppressWarnings("deprecation")
	public BaseDTO lazySearchStockTransfer(StockItemInwardPNSDTO stockTransferDTO) {
		log.info("<-Inside SERVICE Starts Lazy Search StockTranfer-->");
		BaseDTO baseDTO = new BaseDTO();

		try {
			Integer totalResult = 0;
			Session session = entityManager.unwrap(Session.class);
			Criteria criteria = session.createCriteria(GoodsReceiptNote_H.class, "goodsReceiptNoteH");
			criteria.createAlias("goodsReceiptNoteH.supplierMaster", "supplier", CriteriaSpecification.LEFT_JOIN);
			criteria.createCriteria("goodsReceiptNoteH.userMaster", "userMaster");
			
			if (stockTransferDTO.getFilters() != null) {

				if (stockTransferDTO.getFilters().get("grn_h_id") != null) {
					Long id = (Long) stockTransferDTO.getFilters().get("grn_h_id");
					log.info(" ID Filter : " + id);
					criteria.add(Restrictions.like("goodsReceiptNoteH.grn_h_id", "%" + id + '%').ignoreCase());
				}

				String transferType = (String) stockTransferDTO.getFilters().get("grn_H_Number");
				if (transferType != null) {
					log.info(" Stock Tranfer Type INWARD Type filter value is -----> ");
					StockTransferType status = StockTransferType.valueOf(transferType);
					log.info(" transferType Filter : " + transferType);
					criteria.add(Restrictions.eq("goodsReceiptNoteH.grn_H_Number", status));
				}

				String codeName = (String) stockTransferDTO.getFilters().get("supplierCodeName");
				if (StringUtils.isNotEmpty(codeName)) {
					log.info("Supplier Code Name :" + codeName);
					if (AppUtil.isInteger(codeName)) {
						criteria.add(Restrictions.like("goodsReceiptNoteH.supplierMaster.code", "%" + codeName + '%')
								.ignoreCase());
					} else {
						criteria.add(Restrictions.like("goodsReceiptNoteH.supplierMaster.name", "%" + codeName + '%')
								.ignoreCase());
					}
				}

				String status = (String) stockTransferDTO.getFilters().get("status");
				if (status != null) {
					StockTransferStatus stockTransferStatus = StockTransferStatus.valueOf(status);
					log.info(" status Filter : " + status);
					criteria.add(Restrictions.eq("goodsReceiptNoteH.grn_H_Status", stockTransferStatus));
				}

				if (stockTransferDTO.getFilters().get("grn_H_Date") != null) {

					Date orderDate = new Date((long) stockTransferDTO.getFilters().get("grn_H_Date"));
					log.info("purchaseDate Filter : " + orderDate);
					criteria.add(
							Restrictions.eq("goodsReceiptNoteH.grn_H_Date", new java.sql.Date(orderDate.getTime())));
				}

			}

			criteria.setProjection(null);
			if (stockTransferDTO.getPaginationDTO() != null) {

				String sortField = stockTransferDTO.getPaginationDTO().getSortField();
				String sortOrder = stockTransferDTO.getPaginationDTO().getSortOrder();
				if (sortField != null && sortOrder != null) {
					log.info("sortField : [" + sortField + "] sortOrder[" + sortOrder + "]");

					if (sortField.equals("id")) {

						sortField = "goodsReceiptNoteH.grn_h_id";

					}
					// else if (sortField.equals("supplierType")) {
					// //
					// sortField = "goodsReceiptNoteH.supplierMaster.code";
					//
					// } else if (sortField.equals("supplierCodeName")) {
					// //
					// sortField = "goodsReceiptNoteH.supplierMaster.code";
					//
					// }
					else if (sortField.equals("status")) {

						sortField = "goodsReceiptNoteH.grn_H_Status";

					}

					else if (sortField.equals("grn_H_Date")) {

						sortField = "goodsReceiptNoteH.grn_H_Date";

					}

					if (sortOrder.equals("DESCENDING")) {
						criteria.addOrder(Order.desc(sortField));
					} else {
						criteria.addOrder(Order.asc(sortField));
					}
				} else {
					criteria.addOrder(Order.desc("goodsReceiptNoteH.grn_h_id"));
				}

				totalResult = getProjectionCount(criteria);
				Integer pageNo = stockTransferDTO.getPaginationDTO().getPageNo();
				Integer pageSize = stockTransferDTO.getPaginationDTO().getPageSize();

				if (pageNo != null && pageSize != null) {
					criteria.setFirstResult(pageNo * pageSize);
					criteria.setMaxResults(pageSize);
					log.info("PageNo : [" + pageNo + "] pageSize[" + pageSize + "]");
				}

			}

			log.info("Criteria Query  : ");

			ProjectionList projectionList = Projections.projectionList();

			projectionList.add(Projections.property("goodsReceiptNoteH.grn_h_id"));
			projectionList.add(Projections.property("goodsReceiptNoteH.grn_H_Number"));
			projectionList.add(Projections.property("supplier.code"));
			projectionList.add(Projections.property("supplier.name"));
			projectionList.add(Projections.property("goodsReceiptNoteH.grn_H_Status"));
			projectionList.add(Projections.property("goodsReceiptNoteH.grn_H_Date"));
			projectionList.add(Projections.property("userMaster.username"));

			criteria.setProjection(projectionList);

			List<?> resultList = criteria.list();

			List<StockItemInwardPNSDTO> responseList = new ArrayList<StockItemInwardPNSDTO>();

			Iterator<?> it = resultList.iterator();
			while (it.hasNext()) {
				Object ob[] = (Object[]) it.next();
				StockItemInwardPNSDTO response = new StockItemInwardPNSDTO();
				response.setGrnHID((Long) ob[0]);
				response.setGrnNumber(ob[1].toString());
				if (ob[2] != null && ob[3] != null) {
					response.setSupplierCodeName(((String) ob[2]) + " / " + (String) ob[3]);
				}
				if (ob[4] != null && ob[4] != null) {
					response.setStatus(ob[4].toString());
				}
				if (ob[5] != null && ob[5] != null) {
					response.setGrnDate((Date) ob[5]);
				}
				if (ob[6] != null && ob[6] != null) {
					response.setGrnCreatedBy(ob[6].toString());
				}
				responseList.add(response);
			}

			baseDTO.setResponseContents(responseList);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			baseDTO.setTotalRecords(responseList.size());

		} catch (RestException restException) {
			baseDTO.setStatusCode(restException.getStatusCode());
			log.error("RestException in PaymentService search() ", restException);
		} catch (Exception exception) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("Exception in PaymentService search() ", exception);
		}
		return responseWrapper.send(baseDTO);
	}

	public Integer getProjectionCount(Criteria criteria) {

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("stockTransfer.id"));
		projectionList.add(Projections.property("stockTransfer.transferType"));
		projectionList.add(Projections.property("supplierTypeMaster.code"));
		projectionList.add(Projections.property("supplierMaster.code"));
		projectionList.add(Projections.property("supplierMaster.name"));

		projectionList.add(Projections.property("stockTransfer.status"));

		projectionList.add(Projections.property("stockTransfer.dateReceived"));

		criteria.setProjection(projectionList);

		List<?> resultList = criteria.list();

		return resultList.size();

	}

	// View selected StockItem List
	// product group master
	public BaseDTO getAllProductVarietyMasterList(Long id) {

		log.info("<-Inside SERVICE- Starts getAllProductVarietyMasterList-->");
		BaseDTO baseDTO = new BaseDTO();
		try {
			List<ProductVarietyMaster> intendList = productVarietyMasterRepository.getAllProductVarietyMaster(id);
			log.info("<-Inside SERVICE- Starts getAllProductVarietyMasterList--> size is :" + intendList.size());
			baseDTO.setResponseContent(intendList);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("<-getAllProductCategoryList Data Success-->");
		} catch (Exception exception) {
			log.error("exception Occured getAllProductCategoryList : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;

	}

	// Selected Variety Master
	public BaseDTO getSelectedProductVarietyMaster(Long id) {

		log.info("<-Inside SERVICE- Starts getAllProductVarietyMasterList-->");
		BaseDTO baseDTO = new BaseDTO();
		try {
			ProductVarietyMaster intendList = productVarietyMasterRepository.getSelectedProductVarietyMaster(id);
			log.info("<-Inside SERVICE- Starts getAllProductVarietyMasterList--> ");
			baseDTO.setResponseContent(intendList);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			log.info("<-getAllProductCategoryList Data Success-->");
		} catch (Exception exception) {
			log.error("exception Occured getAllProductCategoryList : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;

	}

	public BaseDTO autoCompleteSupplier(String suppliercode) {
		BaseDTO response = new BaseDTO();
		List<SupplierMaster> supplierMasterList = new ArrayList<>();
		SupplierMaster supplierMaster = new SupplierMaster();
		try {
			suppliercode = "%" + suppliercode.trim() + "%";
			Long userId = loginService.getCurrentUser().getId();
			List<SupplierMaster> supplierMasterlistt = supplierMasterRepository.autoCompleteSupplier(suppliercode,
					userId);
			if (supplierMasterlistt != null) {
				for (SupplierMaster sup : supplierMasterlistt) {
					supplierMaster = new SupplierMaster();
					if (sup.getName() != null) {
						supplierMaster.setId(sup.getId());
						supplierMaster.setCode(sup.getCode());
						supplierMaster.setName(sup.getName());
						supplierMaster.setGstNumber(sup.getGstNumber());
						supplierMaster.setAadharNumber(sup.getAadharNumber());
						supplierMasterList.add(supplierMaster);
					}

				}
			}
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContents(supplierMasterList);
		} catch (Exception e) {
			log.error("Exception Occured In StockItemInwardPNS Service autoCompleteSupplier", e);
		}
		return response;
	}

	public BaseDTO autoCompleteItem(String itemName) {
		BaseDTO response = new BaseDTO();
		List<ProductVarietyMaster> productVarietyMasterList = new ArrayList<>();
		ProductVarietyMaster productVarietyMaster = new ProductVarietyMaster();
		try {
			itemName = "%" + itemName.trim() + "%";
			Long userId = loginService.getCurrentUser().getId();
			List<ProductVarietyMaster> productVarietyMasterListt = productVarietyMasterRepository
					.autoCompleteItem(itemName, userId);
			if (productVarietyMasterListt != null) {
				for (ProductVarietyMaster pvm : productVarietyMasterListt) {
					productVarietyMaster = new ProductVarietyMaster();
					if (pvm.getName() != null) {
						productVarietyMaster.setId(pvm.getId());
						productVarietyMaster.setCode(pvm.getCode());
						productVarietyMaster.setName(pvm.getName());
						productVarietyMaster.setCgst_percentage(pvm.getCgst_percentage());
						productVarietyMaster.setSgst_percentage(pvm.getSgst_percentage());
						productVarietyMaster.setHsnCode(pvm.getHsnCode());
						if (pvm.getUomMaster() != null) {
							productVarietyMaster.setUomMaster(pvm.getUomMaster());
						}
						productVarietyMaster.setActiveStatus(pvm.getActiveStatus());
						productVarietyMasterList.add(productVarietyMaster);
					}

				}
			}
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContents(productVarietyMasterList);
		} catch (Exception e) {
			log.error("Exception Occured In StockItemInwardPNS Service autoCompleteSupplier", e);
		}
		return response;
	}
}
