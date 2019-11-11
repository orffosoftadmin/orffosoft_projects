package co.orffosoft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.core.util.StockTransactionTypeIFC;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.SalesReturnDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.SalesReturn;
import co.orffosoft.entity.SalesReturnItems;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.entity.StockTransactionType;
import co.orffosoft.enums.SequenceName;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.SalesReturnItemsRepository;
import co.orffosoft.repository.SalesReturnRepository;
import co.orffosoft.repository.SequenceConfigRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SalesReturnService {

	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@PersistenceContext
	EntityManager manager;

	@Autowired
	SequenceConfigRepository sequenceConfigRepository;
	
	@Autowired
	SalesReturnRepository salesReturnRepository;
	
	@Autowired
	SalesReturnItemsRepository salesReturnItemsRepository;
	
	
	@Transactional
	public BaseDTO generateReport(SalesReturnDTO items) {
		log.info(" >> DailyTransactionReportService >>  generateReport method >> ");
		BaseDTO response = new BaseDTO();
		List<SalesReturnDTO> salesReturnDTOList = new ArrayList<>();
		SalesReturnDTO salesReturnDTO = new SalesReturnDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = null;
		Query sql = null;
		List<Object[]> obj = null;
		Iterator<Object[]> billReport = null;
		String parameter = "";
		try {

			query = " select bill_h.bill_h_pk as billId , bill_h.bill_h_bill_no as billNo , cm.name as customerName , cm.primary_contact_number as mobileNumber, "
					+ " bill_h.bill_h_date as billDate,  bill_h.bill_h_net_amount as netAmount , um.username as userName "
					+ " from bill_h bill_h left join customer_master cm on bill_h.bill_h_customer_fk = cm.id "
					+ " inner join user_master um on um.id = bill_h.created_by " + " where :input ";

			if (items.getFromDate() != null) {
				Calendar calFromDate = Calendar.getInstance();
				calFromDate.setTime(items.getFromDate());

				StringTokenizer fromDate = new StringTokenizer(sdf.format(calFromDate.getTime()), " ");
				while (fromDate.hasMoreTokens()) {
					items.setFromDateStr(fromDate.nextToken() + " 00:00:00 ");
					break;
				}

				parameter = parameter + " bill_h.bill_h_date between ' " + items.getFromDateStr() + "' and ";
			}
			if (items.getToDate() != null) {
				Calendar calToDate = Calendar.getInstance();
				calToDate.setTime(items.getToDate());

				StringTokenizer toDate = new StringTokenizer(sdf.format(calToDate.getTime()), " ");
				while (toDate.hasMoreTokens()) {
					items.setToDateStr(toDate.nextToken() + " 23:59:59 ");
					break;
				}

				parameter = parameter + "' " + items.getToDateStr() + "' and ";
			}
			if (items.getBillNo() != null && !items.getBillNo().isEmpty() && items.getBillNo().length() > 0) {
				parameter = parameter + " bill_h.bill_h_bill_no ilike '" + items.getBillNo() + "' and ";
			}
			if (items.getCustomerName() != null && !items.getCustomerName().isEmpty()
					&& items.getCustomerName().length() > 0) {
				parameter = parameter + " and cm.name ilike '%" + items.getCustomerName() + "%' and ";
			}
			if (items.getCustomerMobileNo() != null) {
				parameter = parameter + " cm.primary_contact_number ilike '%" + items.getCustomerMobileNo() + "%' and ";
			}
			parameter = parameter + " bill_h.created_by =" + items.getUserId() + " order by bill_h.bill_h_date asc";

			query = query.replaceAll(":input", parameter);

			sql = manager.createNativeQuery(query);

			obj = sql.getResultList();
			billReport = obj.iterator();
			if (billReport != null) {
				while (billReport.hasNext()) {
					salesReturnDTO = new SalesReturnDTO();
					Object[] ob = billReport.next();

					if (ob[0] != null) {
						salesReturnDTO.setBillId(Long.parseLong(ob[0].toString()));
					}

					if (ob[1] != null) {
						salesReturnDTO.setBillNo(ob[1].toString());
					}

					if (ob[2] != null) {
						salesReturnDTO.setCustomerName(ob[2].toString());
					}

					if (ob[3] != null) {
						salesReturnDTO.setCustomerMobileNo(Long.parseLong(ob[3].toString()));
					}

					if (ob[4] != null) {
						salesReturnDTO.setBillDate((Date) (ob[4]));
					}

					if (ob[5] != null) {
						salesReturnDTO.setNetPrice(Double.parseDouble(ob[5].toString()));
					}

					if (ob[6] != null) {
						salesReturnDTO.setUserName(ob[6].toString());
					}

					salesReturnDTOList.add(salesReturnDTO);
				}
			}

			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContents(salesReturnDTOList);
			log.info("<<<  === Success Response === >>>");
		} catch (Exception e) {
			log.error(" >>  Exception Occured In DailyTransactionReportService >> generateReport method >> ", e);
		}
		return response;

	}

	/**
	 * @param dto
	 * @return
	 */
	public BaseDTO getBillDetailsByID(SalesReturnDTO dto) {
		log.info(" >> DailyTransactionReportService >>  getBillDetailsByID method >> ");
		BaseDTO response = new BaseDTO();
		List<SalesReturnDTO> salesReturnDTOList = new ArrayList<>();
		SalesReturnDTO salesReturnDTO = new SalesReturnDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = null;
		Query sql = null;
		List<Object[]> obj = null;
		Iterator<Object[]> billReport = null;
		try {

			query = " select bilH.bill_h_pk as billId, pvm.id as itemId, cm.id as customerFk , cm.name as CustomerName  ,pvm.name as ItemName ,  pvm.hsn_code as HsnCode ,  bilD.bill_d_item_qnty as ItemQnty , "
					+ " bilD.bill_d_unitrate as UnitRate  , bilD.bill_d_cgst_percentage as CGSTPercentage , bilD.bill_d_cgst_value as CGSTValue , "
					+ " bilD.bill_d_sgst_percentage as SGSTPercentage,  bilD.bill_d_sgst_value as SGSTValue , bilD.bill_d_totalunitrate as TotalUnitRate , "
					+ " bilD.bill_d_discount_value as DiscountValue , bilD.bill_d_net_amount as NetAmount "
					+ " from bill_h bilH inner join bill_d bilD on bilH.bill_h_pk = bilD.bill_d_bill_h_fk "
					+ " inner join product_variety_master pvm on bilD.bill_d_sku_fk = pvm.id "
					+ " inner join user_master um on um.id = bilH.created_by left join customer_master cm on cm.id = bilH.bill_h_customer_fk "
					+ " where bilH.bill_h_pk = " + dto.getBillId() + " and bilH.created_by = " + dto.getUserId()
					+ " order by bilH.bill_h_date asc";
			sql = manager.createNativeQuery(query);

			obj = sql.getResultList();
			billReport = obj.iterator();
			if (billReport != null) {
				while (billReport.hasNext()) {
					salesReturnDTO = new SalesReturnDTO();
					Object[] ob = billReport.next();

					if (ob[0] != null) {
						salesReturnDTO.setBillId(Long.parseLong(ob[0].toString()));
					}
					
					if (ob[1] != null) {
						salesReturnDTO.setItemId(Long.parseLong(ob[1].toString()));
					}
					
					if (ob[2] != null) {
						salesReturnDTO.setCustomerFk(Long.parseLong(ob[2].toString()));
					}

					if (ob[3] != null) {
						salesReturnDTO.setCustomerName(ob[3].toString());
					}
					if (ob[4] != null) {
						salesReturnDTO.setItemName(ob[4].toString());
					}

					if (ob[5] != null) {
						salesReturnDTO.setHsnCode(ob[5].toString());
					}

					if (ob[6] != null) {
						salesReturnDTO.setQnty(Long.parseLong(ob[6].toString()));
					}

					if (ob[7] != null) {
						salesReturnDTO.setUnitPrice(Double.parseDouble(ob[7].toString()));
					}

					if (ob[8] != null) {
						salesReturnDTO.setCgstPercent(Long.parseLong(ob[8].toString()));
					}

					if (ob[9] != null) {
						salesReturnDTO.setCgstAmount(Double.parseDouble(ob[9].toString()));
					}

					if (ob[10] != null) {
						salesReturnDTO.setSgstPercent(Long.parseLong(ob[10].toString()));
					}

					if (ob[11] != null) {
						salesReturnDTO.setSgstAmount(Double.parseDouble(ob[11].toString()));
					}

					if (ob[12] != null) {
						salesReturnDTO.setTotalUnitPrice(Double.parseDouble(ob[12].toString()));
					}

					if (ob[13] != null) {
						salesReturnDTO.setDiscount(Long.parseLong(ob[13].toString()));
					} else {
						salesReturnDTO.setDiscount(0L);
					}

					if (ob[14] != null) {
						salesReturnDTO.setNetPrice(Double.parseDouble(ob[14].toString()));
					}
					salesReturnDTO.setReturnedQnty(0L);
					salesReturnDTO.setReturnedAmount(0D);

					salesReturnDTOList.add(salesReturnDTO);
				}
			}

			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContents(salesReturnDTOList);
			log.info("<<<  === Success Response === >>>");
		} catch (Exception e) {
			log.error(" >>  Exception Occured In DailyTransactionReportService >> getBillDetailsByID method >> ", e);
		}
		return response;

	}

	/**
	 * @param dto
	 * @return
	 */
	@Transactional
	public BaseDTO submit(SalesReturnDTO dto) {
		log.info("<<<  === Inside SalesReturn Service ==>> submit === >>>");
		BaseDTO response = new BaseDTO();
		SalesReturn salesReturn = new SalesReturn();
		SalesReturnItems salesReturnItems = new SalesReturnItems();
		try {
			if (dto != null) {
				salesReturn.setBill_h_fk(dto.getBillId());

				SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.SALES_RETURN);
				
				if (sequenceConfig == null) {
					log.error("Sequence not found for SALES_RETURN");
					response.setMessage("Sequence not found for SALES_RETURN");
					throw new RestException();
				}
				EntityMaster storeDetails = loginService.getStoreDetails(loginService.getCurrentUser().getEntityId());
				if (storeDetails != null && sequenceConfig != null) {
					salesReturn.setBill_no(storeDetails.getCode() + "/" + sequenceConfig.getPrefix() + "/"
							+ sequenceConfig.getCurrentValue());
				}
				salesReturn.setReturn_date(new Date());
				salesReturn.setNet_total(dto.getSalesReturnDTOList().stream().mapToDouble(i->i.getReturnedAmount()).sum());
				salesReturn.setCreated_by(loginService.getCurrentUser().getId());
				salesReturn.setCreated_date(new Date());
				if(dto.getCustomerFk() != null) {
					salesReturn.setCustomer_fk(dto.getCustomerFk());
				}
				
				
				sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);
				sequenceConfigRepository.save(sequenceConfig);
				log.info(" == >> SequenceConfig Saved Successfully == >>");
				SalesReturn salesRt = salesReturnRepository.save(salesReturn);
				
				if (salesRt == null) {
					response.setMessage("Sales Return Not Saved");
					log.error(">>>>>> Sales Return Not Saved Properly see log Files >>>");
					new RestException("Sales Return Not Saved");
				}
				
				StockTransactionType st = stockTransactionTypeRepository.getGRNID(StockTransactionTypeIFC.SALE_RETURN);
				if(st == null ) {
					response.setMessage("Stock Transaction Type Not Found For Sales Return");
					new RestException("Stock Transaction Type Not Found");
				}
				for (SalesReturnDTO dt : dto.getSalesReturnDTOList()) {
					 if(dt != null) {
						 salesReturnItems = new SalesReturnItems();
						 salesReturnItems.setSales_return_id(salesRt.getId());
						 salesReturnItems.setSku_id(dto.getItemId());
						// salesReturnItems
						 
					}
				}

			}
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			log.info(" == >> SalesReturnService > > Submit == >>");
		} catch (Exception e) {
			log.error("Exception Occured IN SalesReturn Service", e);
		}
		return response;
	}

}
