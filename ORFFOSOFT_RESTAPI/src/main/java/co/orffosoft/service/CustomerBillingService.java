package co.orffosoft.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.StockTransactionTypeIFC;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerBillingDTO;
import co.orffosoft.entity.Bill_D;
import co.orffosoft.entity.Bill_H;
import co.orffosoft.entity.CustomerMaster;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.entity.StockTransaction;
import co.orffosoft.entity.StockTransactionType;
import co.orffosoft.enums.SequenceName;
import co.orffosoft.repository.Bill_D_Repository;
import co.orffosoft.repository.Bill_H_Repository;
import co.orffosoft.repository.CustomerMasterRepository;
import co.orffosoft.repository.EntityMasterRepository;
import co.orffosoft.repository.GoodsReceiptNote_D_Repository;
import co.orffosoft.repository.ItemPriceRepository;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.SequenceConfigRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerBillingService {

	@Autowired
	LoginService loginService;

	@Autowired
	CustomerMasterRepository customerMasterRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	GoodsReceiptNote_D_Repository goodsReceiptNote_D_Repository;

	@Autowired
	ItemPriceRepository itemPriceRepository;

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@Autowired
	SequenceConfigRepository sequenceConfigRepository;

	@Autowired
	Bill_H_Repository bill_H_Repository;

	@Autowired
	Bill_D_Repository bill_D_Repository;
	
	@Autowired
	EntityMasterRepository entityMasterRepository;

	/**
	 * @param mobno
	 * @return
	 */
	public BaseDTO autoCompleteMobileNo(String mobno) {
		log.info("Inside CustomerBillingService Class autoCompleteMobileNo method");
		BaseDTO response = new BaseDTO();
		List<CustomerMaster> customerMasterList = new ArrayList<>();
		CustomerMaster customerMaster = new CustomerMaster();
		try {
			mobno = "%" + mobno.trim() + "%";
			Long entityId = loginService.getCurrentUser().getEntityId();
			List<CustomerMaster> customerMasterlistt = customerMasterRepository.loadMobileNumberAutoSearch(mobno,
					entityId);
			log.info("Retrival Process from Repository Done");
			if (customerMasterlistt != null) {
				for (CustomerMaster cus : customerMasterlistt) {
					customerMaster = new CustomerMaster();
					if (cus.getName() != null && cus.getPrimaryContactNumber() != null) {
						customerMaster.setId(cus.getId());
						customerMaster.setName(cus.getName());
						customerMaster.setPrimaryContactNumber(cus.getPrimaryContactNumber());
						customerMasterList.add(customerMaster);
					}

				}
			}
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			log.info("<<<  === Success Response === >>>");
			response.setResponseContents(customerMasterList);
		} catch (Exception e) {
			log.error("Exception Occured In CustomerBillingService Service autoCompleteSupplier", e);
		}
		return response;
	}

	/**
	 * @param mobno
	 * @return
	 */
	public BaseDTO findItemPriceDetails(Long itemId) {
		BaseDTO response = new BaseDTO();
		CustomerBillingDTO customerBillingDTO = new CustomerBillingDTO();
		log.info("Inside CustomerBillingService Class findItemPriceDetails method");
		try {
			log.info("Inside Try Block");
			Long object = stockTransactionRepository.findClosingBalanceBasedOnSupplierIdAndItem(itemId);
			customerBillingDTO.setItemId(itemId);
			customerBillingDTO.setStockQnty(0L);
			customerBillingDTO.setSellingPrices(new ArrayList<>());
			if (object != null) {
				customerBillingDTO.setStockQnty(object);
				List<BigDecimal> priceDetails = itemPriceRepository.findSellingPriceByItemId(itemId);
				if (priceDetails != null) {
					for (BigDecimal obj : priceDetails) {
						Double sellingPrice = Double.parseDouble(obj.toString());
						customerBillingDTO.getSellingPrices().add(sellingPrice);
					}

				}
			}

			log.info("<<<  === Success Response === >>>");
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContent(customerBillingDTO);
		} catch (Exception e) {
			log.error("Exception Occured In CustomerBillingService Service findItemPriceDetails", e);
		}
		return response;
	}

	/**
	 * @param mobno
	 * @return
	 */
	@Transactional
	public BaseDTO billCreation(List<CustomerBillingDTO> billingDtoList) {

		BaseDTO response = new BaseDTO();
		CustomerBillingDTO customerBillingDTO = new CustomerBillingDTO();
		log.info("Inside CustomerBillingService Class billCreation method");
		Bill_H bill_H = new Bill_H();
		Bill_D bill_D = new Bill_D();
		StockTransaction stockTransaction = new StockTransaction();
		try {
			log.info("Inside Try Block");
			Long userId = loginService.getCurrentUser().getId();
			bill_H = new Bill_H();
			bill_H.setBill_h_date(new Date());
			if (billingDtoList != null && billingDtoList.size() > 0) {
				bill_H.setBill_h_customer_fk(billingDtoList.get(0).getBill_H_CustomerFK());
			}

			SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.BILL_PAYEMENT);
			EntityMaster storeDetails = entityMasterRepository.findOne(loginService.getCurrentUser().getEntityId());
			if (storeDetails != null && sequenceConfig != null) {
				bill_H.setBill_h_bill_no(storeDetails.getCode() + "/" + sequenceConfig.getPrefix() + "/"
						+ sequenceConfig.getCurrentValue());
			}
			// commented on 6/11/2019 
//			bill_H.setBill_h_net_amount(billingDtoList.stream().mapToDouble(i -> i.getBill_D_NetAmount()).sum());
			
			bill_H.setBill_h_net_amount(billingDtoList.stream().mapToDouble(i -> i.getTotalNetPrice()).sum());
			bill_H.setCreated_by(userId);
			bill_H.setCreated_date(new Date());
			bill_H = bill_H_Repository.save(bill_H);
			sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);
			sequenceConfigRepository.save(sequenceConfig);

			StockTransactionType st = stockTransactionTypeRepository.getGRNID(StockTransactionTypeIFC.SALE);

			if (bill_H != null) {
				for (CustomerBillingDTO dto : billingDtoList) {
					if (dto.getItemId() != null) {
						bill_D = new Bill_D();
						bill_D.setBill_d_bill_h_fk(bill_H.getBill_h_pk());
						bill_D.setBill_d_sku_fk(dto.getItemId());
						bill_D.setBill_d_item_qnty(dto.getBilledQnty());
						bill_D.setBill_d_unitrate(dto.getUnitRate());
						bill_D.setBill_d_totalunitrate(dto.getTotalRate());
						bill_D.setBill_d_cgst_percentage(Double.parseDouble(dto.getCgstPercent().toString()));
						bill_D.setBill_d_cgst_value(dto.getCgstAmount());
						if (dto.getSgstPercent() != null) {
							bill_D.setBill_d_sgst_percentage(Double.parseDouble(dto.getSgstPercent().toString()));
							bill_D.setBill_d_sgst_value(dto.getSgstAmount());
						}
						
						bill_D.setBill_d_discount_percentage(dto.getDiscountPercent());
						bill_D.setBill_d_discount_value(dto.getBill_D_DiscountValue());
						bill_D.setBill_d_net_amount(dto.getTotalNetPrice());
						bill_D.setCreated_by(userId);
						bill_D.setCreated_date(new Date());
						bill_D_Repository.save(bill_D);

						// For Stock Update In Stock Transaction Table

						if (st != null) {
							stockTransaction.setStock_tran_sku_id_fk(dto.getItemId());
							stockTransaction.setStock_tran_date(new Date());
							stockTransaction.setStock_tran_type_fk(st.getStock_tran_type_pk());
							stockTransaction.setStock_tran_received_qnty(0D);
							stockTransaction.setStock_tran_issued_qnty(dto.getBilledQnty());
							if (dto.getUnitRate() != null) {
								stockTransaction.setStock_tran_sellingprice(dto.getUnitRate());
							}
							if (dto.getBill_D_PurchasePrice() != null) {
								stockTransaction.setStock_tran_purchaseprice(dto.getBill_D_PurchasePrice());
							}
							stockTransaction.setCreated_by(loginService.getCurrentUser().getId());
							stockTransaction.setCreated_date(new Date());
							stockTransactionRepository.save(stockTransaction);
						}

					}

				}

			}

			log.info("<<<  === Success Response === >>>");
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContent(customerBillingDTO);
		} catch (Exception e) {
			response.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getCode());
			log.error("Exception Occured In CustomerBillingService billCreation", e);
		}
		log.info("<<<  === End Of CustomerBillingService billCreation === >>>");
		return response;

	}

}
