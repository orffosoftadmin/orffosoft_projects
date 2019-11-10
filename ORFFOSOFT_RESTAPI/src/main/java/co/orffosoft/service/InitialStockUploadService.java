package co.orffosoft.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.StockTransactionTypeIFC;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.InitialStockUploadDTO;
import co.orffosoft.entity.GoodsReceiptNote_D;
import co.orffosoft.entity.GoodsReceiptNote_H;
import co.orffosoft.entity.ItemPrice;
import co.orffosoft.entity.ProductVarietyMaster;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.entity.StockTransaction;
import co.orffosoft.entity.StockTransactionType;
import co.orffosoft.enums.SequenceName;
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

@Log4j2
@Service
public class InitialStockUploadService {

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

	@Transactional
	public BaseDTO SaveInitialStockUpload(List<InitialStockUploadDTO> items) {
		log.info("<-Inside Initial Stock Upload >> InitialStockUpload Method Starts -->");
		BaseDTO baseDTO = new BaseDTO();
		GoodsReceiptNote_H goodsReceiptNote_H = new GoodsReceiptNote_H();
		try {

			// Save to Header Table
			if (items != null) {
				goodsReceiptNote_H = saveGoodsReceiptNote_H(items);
				saveGoodsReceiptNote_D(items, goodsReceiptNote_H);
			}
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
		} catch (Exception exception) {
			log.error("exception Occured saveStockItem : ", exception);
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		}
		return baseDTO;
	}

	@Transactional
	private GoodsReceiptNote_H saveGoodsReceiptNote_H(List<InitialStockUploadDTO> items) {

		log.info(">> Inside InitialStockUploadService >>saveGoodsReceiptNote_H >>> ");
		GoodsReceiptNote_H goodsReceiptNote_H = new GoodsReceiptNote_H();
		try {
			goodsReceiptNote_H.setUserMaster(userMasterRepository.findOne(loginService.getCurrentUser().getId()));
			SequenceConfig sequenceConfig = sequenceConfigRepository
					.findBySequenceName(SequenceName.INITIAL_STOCK_UPLOAD);
			goodsReceiptNote_H.setGrn_H_Number(sequenceConfig.getPrefix() + "-" + sequenceConfig.getCurrentValue());
			goodsReceiptNote_H.setGrn_H_Date(new Date());
			goodsReceiptNote_H.setGrn_H_Total_Number((double) items.size());
			goodsReceiptNote_H.setGrn_H_Gross_Amount(items.stream().mapToDouble(x -> x.getTotalPurchaseAmt()).sum());
			goodsReceiptNote_H.setUserMaster(goodsReceiptNote_H.getUserMaster());
			goodsReceiptNote_H.setCreated_date(new Date());
			goodsReceiptNote_H = goodsReceiptNote_H_Repository.save(goodsReceiptNote_H);
			log.info(
					">> Inside InitialStockUploadService >>saveGoodsReceiptNote_H >>> GoodsReceiptNote_H Saved Successfully");
			sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);
			sequenceConfigRepository.save(sequenceConfig);
			log.info(
					">> Inside InitialStockUploadService >>saveGoodsReceiptNote_H >>> SequenceConfig Saved Successfully");
		} catch (Exception e) {
			log.error(">> Exception Occured Inside InitialStockUploadService >>saveGoodsReceiptNote_H >>>", e);
		}
		return goodsReceiptNote_H;
	}

	@Transactional
	private void saveGoodsReceiptNote_D(List<InitialStockUploadDTO> items, GoodsReceiptNote_H goodsReceiptNote_h) {
		StockTransaction stockTransaction = new StockTransaction();
		ProductVarietyMaster productVariety = new ProductVarietyMaster();
		GoodsReceiptNote_D goodsReceiptNote_D = new GoodsReceiptNote_D();
		ItemPrice itemPrice = new ItemPrice();
		try {
			if (goodsReceiptNote_h != null) {
				StockTransactionType st = stockTransactionTypeRepository.getGRNID(StockTransactionTypeIFC.STKUPD_GRN);
				if (st == null) {
					throw new RestException("Stock Transaction Type Not Found");
				}
				for (InitialStockUploadDTO item : items) {

					// For Stock Update In Stock Transaction Table

					stockTransaction = new StockTransaction();
					productVariety = new ProductVarietyMaster();
					goodsReceiptNote_D = new GoodsReceiptNote_D();

					stockTransaction.setStock_tran_grn_h_id_fk(goodsReceiptNote_h.getGrn_h_id());
					ProductVarietyMaster productVarietyMaster = productVarietyMasterRepository
							.findByName(item.getItemName(), loginService.getCurrentUser().getId());
					if (productVarietyMaster != null) {
						productVariety = productVarietyMaster;

					} else {
						productVariety.setName(item.getItemName());
						productVariety.setCgst_percentage(item.getCgstPercentage());
						productVariety.setSgst_percentage(item.getSgstPercentage());
						productVariety.setCreatedBy(loginService.getCurrentUser());
						productVariety.setCreatedDate(new Date());
						productVariety.setActiveStatus(true);
						productVariety.setUserId(loginService.getCurrentUser().getId());
						productVariety = productVarietyMasterRepository.save(productVariety);
					}
					if (productVariety == null) {
						log.error("<<<<  Item Name Not Saved >>>> ");
						throw new RestException("<<<< Item Name Not Saved >>>>");
					}
					stockTransaction.setStock_tran_sku_id_fk(productVariety.getId());
					stockTransaction.setStock_tran_date(new Date());
					stockTransaction.setStock_tran_received_qnty(Double.parseDouble(item.getQuantity().toString()));
					stockTransaction.setStock_tran_type_fk(st.getStock_tran_type_pk());
					stockTransaction.setStock_tran_issued_qnty(0l);
					stockTransaction.setCreated_by(loginService.getCurrentUser().getId());
					stockTransaction.setCreated_date(new Date());
					stockTransaction.setStock_tran_purchaseprice(item.getPurchaseAmout());
					stockTransaction.setStock_tran_sellingprice(item.getSellingAmount());

					StockTransaction stockTran = stockTransactionRepository.getSkuId(productVariety.getId());
					// Change Below Line check

					if (stockTran == null) {
						stockTransaction.setStock_tran_opening_bal(Double.parseDouble(item.getQuantity().toString()));
						stockTransaction.setStock_tran_received_qnty(Double.parseDouble(item.getQuantity().toString()));
						stockTransaction.setStock_tran_issued_qnty(0l);
						stockTransaction.setStock_tran_closing_bal(Double.parseDouble(item.getQuantity().toString()));
					} else {
						stockTransaction.setStock_tran_received_qnty(Double.parseDouble(item.getQuantity().toString()));
						stockTransaction.setStock_tran_closing_bal(stockTran.getStock_tran_closing_bal()
								+ Double.parseDouble(item.getQuantity().toString()));
					}

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
					itemPrice.setItemprice_type("STKUPD/GRN Price");
					itemPrice.setCreated_by(loginService.getCurrentUser().getId());
					itemPrice.setCreated_date(new Date());
					itemPriceRepository.save(itemPrice);

					// Save to Goods_ReceiptNote_D
					goodsReceiptNote_D.setGoodsReceiptNote_H(goodsReceiptNote_h);
					goodsReceiptNote_D.setProductVarietyMaster(productVariety);
					goodsReceiptNote_D.setGrn_D_Item_Qnty(item.getQuantity());
					goodsReceiptNote_D.setGrn_D_Date(new Date());
					goodsReceiptNote_D.setGrn_D_Cgst_Percentage(item.getCgstPercentage());
					goodsReceiptNote_D.setGrn_D_Cgst_Amount(item.getCgstAmount());
					goodsReceiptNote_D.setGrn_D_Sgst_Percentage(item.getSgstPercentage());
					goodsReceiptNote_D.setGrn_D_Sgst_Amount(item.getSgstAmount());
					goodsReceiptNote_D.setGrn_D_Accepted_Qnty(Double.parseDouble(item.getQuantity().toString()));
					goodsReceiptNote_D.setGrn_D_Net_Amount(item.getPurchaseAmout());
					goodsReceiptNote_D.setGrn_D_Purchase_Amount(item.getPurchaseAmout());
					goodsReceiptNote_D.setGrn_D_Selling_Amount(item.getSellingAmount());
					goodsReceiptNote_D.setGrn_D_Reject_Qnty(0D);
					goodsReceiptNote_D.setGrn_D_Net_Amount(item.getNetAmount());
					goodsReceiptNote_D.setCreatedBy(loginService.getCurrentUser());
					goodsReceiptNote_D.setCreatedDate(new Date());
					goodsReceiptNote_D.setGrn_D_Total_Purchase_Amt(item.getTotalPurchaseAmt());
					goodsReceiptNote_D.setGrn_D_Total_Selling_Amt(item.getTotalSellingAmt());
					goodsReceiptNote_D_Repository.save(goodsReceiptNote_D);
				}
			}

		} catch (Exception e) {
			log.error("<<<<  Exception Occured In InitialStockUpload  saveGoodsReceiptNote_D >>>> ", e);
		}

	}

}
