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
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.DailyTransactionReportDTO;
import co.orffosoft.repository.ItemPriceRepository;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DailyTransactionReportService {

	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	ItemPriceRepository itemPriceRepository;

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@PersistenceContext
	EntityManager manager;

	@Transactional
	@SuppressWarnings("unchecked")
	public BaseDTO generateReport(DailyTransactionReportDTO items) {
		log.info(" >> DailyTransactionReportService >>  generateReport method >> ");
		BaseDTO response = new BaseDTO();
		List<DailyTransactionReportDTO> dailyTransactionReportDTOList = new ArrayList<>();
		DailyTransactionReportDTO dailyTransactionReportDTO = new DailyTransactionReportDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = null;
		Query sql = null;
		List<Object[]> obj = null;
		Iterator<Object[]> billReport = null;
		String parameter = "";
		try {

			query = " select bilH.bill_h_bill_no as BillNo ,bilH.bill_h_date as BillDate ,pvm.name as ItemName ,bilD.bill_d_item_qnty as ItemQnty ,bilD.bill_d_unitrate as UnitRate , "
					+ " bilD.bill_d_totalunitrate as TotalUnitRate , bilD.bill_d_discount_value as DiscountValue , bilD.bill_d_cgst_percentage as CGSTPercentage , "
					+ " bilD.bill_d_cgst_value as CGSTValue , bilD.bill_d_sgst_percentage as SGSTPercentage,  bilD.bill_d_sgst_value as SGSTValue , "
					+ " bilD.bill_d_net_amount as NetAmount, um.username as UserName , cm.name as CustomerName"
					+ " from bill_h bilH inner join bill_d bilD on bilH.bill_h_pk = bilD.bill_d_bill_h_fk "
					+ " inner join product_variety_master pvm on bilD.bill_d_sku_fk = pvm.id "
					+ " inner join user_master um on um.id = bilH.created_by left join customer_master cm on cm.id = bilH.bill_h_customer_fk where :input ";

			if (items.getFromDate() != null) {
				Calendar calFromDate = Calendar.getInstance();
				calFromDate.setTime(items.getFromDate());

				StringTokenizer fromDate = new StringTokenizer(sdf.format(calFromDate.getTime()), " ");
				while (fromDate.hasMoreTokens()) {
					items.setFromDateStr(fromDate.nextToken() + " 00:00:00 ");
					break;
				}

				parameter = parameter + " bilH.bill_h_date between ' " + items.getFromDateStr() + "' and ";
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
				parameter = parameter + " bilH.bill_h_bill_no ilike '" + items.getBillNo() + "' and ";
			}
			if (items.getCustomerName() != null && !items.getCustomerName().isEmpty()
					&& items.getCustomerName().length() > 0) {
				parameter = parameter + " and cm.name ilike '%" + items.getCustomerName() + "%' and ";
			}
			if (items.getCustomerMobileNo() != null) {
				parameter = parameter + " cm.primary_contact_number ilike '%" + items.getCustomerMobileNo() + "%' and ";
			}
			parameter = parameter + " bilH.created_by =" + items.getUserId()+" order by bilH.bill_h_date asc";

			query = query.replaceAll(":input", parameter);

			sql = manager.createNativeQuery(query);

			obj = sql.getResultList();
			billReport = obj.iterator();
			if (billReport != null) {
				while (billReport.hasNext()) {
					dailyTransactionReportDTO = new DailyTransactionReportDTO();
					Object[] ob = billReport.next();
					if (ob[0] != null) {
						dailyTransactionReportDTO.setBillNo(ob[0].toString());
					}

					if (ob[1] != null) {
						dailyTransactionReportDTO.setBillDate((Date) ob[1]);
					}

					if (ob[2] != null) {
						dailyTransactionReportDTO.setItemName(ob[2].toString());
					}

					if (ob[3] != null) {
						dailyTransactionReportDTO.setQnty(Long.parseLong(ob[3].toString()));
					}

					if (ob[4] != null) {
						dailyTransactionReportDTO.setUnitPrice(Double.parseDouble(ob[4].toString()));
					}

					if (ob[5] != null) {
						dailyTransactionReportDTO.setTotalUnitPrice(Double.parseDouble(ob[5].toString()));
					}

					if (ob[6] != null) {
						dailyTransactionReportDTO.setDiscount(Long.parseLong(ob[6].toString()));
					}

					if (ob[7] != null) {
						dailyTransactionReportDTO.setCgstPercent(Long.parseLong(ob[7].toString()));
					}

					if (ob[8] != null) {
						dailyTransactionReportDTO.setCgstAmount(Double.parseDouble(ob[8].toString()));
					}

					if (ob[9] != null) {
						dailyTransactionReportDTO.setSgstPercent(Long.parseLong(ob[9].toString()));
					}

					if (ob[10] != null) {
						dailyTransactionReportDTO.setSgstAmount(Double.parseDouble(ob[10].toString()));
					}

					if (ob[11] != null) {
						dailyTransactionReportDTO.setNetPrice(Double.parseDouble(ob[11].toString()));
					}

					if (ob[12] != null) {
						dailyTransactionReportDTO.setUserName(ob[12].toString());
					}

					if (ob[13] != null) {
						dailyTransactionReportDTO.setCustomerName(ob[13].toString());
					}

					dailyTransactionReportDTOList.add(dailyTransactionReportDTO);
				}
			}

			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			response.setResponseContents(dailyTransactionReportDTOList);
			log.info("<<<  === Success Response === >>>");
		} catch (Exception e) {
			log.error(" >>  Exception Occured In DailyTransactionReportService >> generateReport method >> ", e);
		}
		return response;
	}

}
