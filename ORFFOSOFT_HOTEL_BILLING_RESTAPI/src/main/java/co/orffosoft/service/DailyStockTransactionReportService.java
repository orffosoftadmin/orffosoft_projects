package co.orffosoft.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import co.orffosoft.dto.DailyStockTransactionReportDTO;
import co.orffosoft.repository.ItemPriceRepository;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DailyStockTransactionReportService {

	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PersistenceContext
	EntityManager manager;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	ItemPriceRepository itemPriceRepository;

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@Transactional
	public BaseDTO generateReport(DailyStockTransactionReportDTO items) {

		log.info(" >> DailyStockTransactionReportService >>  generateReport method >> ");
		BaseDTO response = new BaseDTO();
		List<DailyStockTransactionReportDTO> dailyStokTransactionReportDTOList = new ArrayList<>();
		DailyStockTransactionReportDTO dailyStockTransactionReportDTO = new DailyStockTransactionReportDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = null;
		Query sql = null;
		List<Object[]> obj = null;
		Iterator<Object[]> billReport = null;
		String parameter = "";
		HashMap<Long, Long> openingHashMap = new HashMap<>();
		try {

			if (items.getFromDate() != null) {
				Calendar calFromDate = Calendar.getInstance();
				calFromDate.setTime(items.getFromDate());

				StringTokenizer fromDate = new StringTokenizer(sdf.format(calFromDate.getTime()), " ");
				while (fromDate.hasMoreTokens()) {
					items.setFromDateStr(fromDate.nextToken() + " 00:00:00 ");
					break;
				}

			}
			if (items.getToDate() != null) {
				Calendar calToDate = Calendar.getInstance();
				calToDate.setTime(items.getToDate());

				StringTokenizer toDate = new StringTokenizer(sdf.format(calToDate.getTime()), " ");
				while (toDate.hasMoreTokens()) {
					items.setToDateStr(toDate.nextToken() + " 12:59:59 ");
					break;
				}

			}

			String openingBal = " select st.stock_tran_sku_id_fk as skuId , sum(st.stock_tran_received_qnty-st.stock_tran_issued_qnty) as closginStock "
					+ " from stock_transaction st inner join product_variety_master pvm on st.stock_tran_sku_id_fk = pvm.id "
					+ " where stock_tran_date <= '" + items.getFromDateStr() + "' and st.created_by =  "
					+ items.getUserId() + " group by st.stock_tran_sku_id_fk order by st.stock_tran_sku_id_fk asc ";

			Query openingBalQuery = manager.createNativeQuery(openingBal);
			List<Object[]> openingBalObj = openingBalQuery.getResultList();
			Iterator<Object[]> openingReport = openingBalObj.iterator();
			if (openingReport != null) {
				while (openingReport.hasNext()) {
					Object[] kk = openingReport.next();
					if (kk[0] != null && kk[1] != null) {
						openingHashMap.put(Long.parseLong(kk[0].toString()), Long.parseLong(kk[1].toString()));
					}
				}
			}
			String stockTransaction = " select pvm.id , pvm.name , st.stock_tran_date, sty.stock_tran_type_description , sty.stock_tran_type_code , case when sty.stock_tran_type_code = 'SALE' "
					+ " then st.stock_tran_issued_qnty when sty.stock_tran_type_code = 'STKUPD/GRN' then st.stock_tran_received_qnty "
					+ " when sty.stock_tran_type_code = 'GRN' then st.stock_tran_received_qnty "
					+ " when sty.stock_tran_type_code = 'RETURN' then st.stock_tran_received_qnty "
					+ " when sty.stock_tran_type_code = 'DAMAGED' then st.stock_tran_issued_qnty "
					+ " when sty.stock_tran_type_code = 'STOCK-ADJUSTMENT_ADD' then  st.stock_tran_received_qnty "
					+ " when sty.stock_tran_type_code = 'STOCK-ADJUSTMENT_MINUS' then st.stock_tran_issued_qnty end as stockQnty "
					+ " from stock_transaction st inner join stock_transaction_type sty on st.stock_tran_type_fk = sty.stock_tran_type_pk "
					+ " inner join product_variety_master pvm on pvm.id = st.stock_tran_sku_id_fk "
					+ " where st.stock_tran_date between '" + items.getFromDateStr() + "' and '" + items.getToDateStr()
					+ "' and st.created_by = " + items.getUserId() + " order by pvm.id, st.stock_tran_date asc";

			Query querry = manager.createNativeQuery(stockTransaction);
			List<Object[]> stockTransactionReport = querry.getResultList();
			Iterator<Object[]> stockReport = stockTransactionReport.iterator();
			while (stockReport.hasNext()) {
				Object[] ob1 = stockReport.next();
				dailyStockTransactionReportDTO = new DailyStockTransactionReportDTO();
				dailyStockTransactionReportDTO.setItemId(Long.parseLong(ob1[0].toString()));
				dailyStockTransactionReportDTO.setItemName(ob1[1].toString());
				dailyStockTransactionReportDTO.setStockTransactionDate((Date) ob1[2]);
				dailyStockTransactionReportDTO.setTransactionType(ob1[3].toString());
				dailyStockTransactionReportDTO.setSaleQnty(0L);
				dailyStockTransactionReportDTO.setGrnReceivedQnty(0L);
				dailyStockTransactionReportDTO.setSaleReturnQnty(0L);
				dailyStockTransactionReportDTO.setDamageQnty(0L);
				dailyStockTransactionReportDTO.setStockAdjuestMentAddQnty(0L);
				dailyStockTransactionReportDTO.setStockadjusmtneMinusQnty(0L);
				if (dailyStockTransactionReportDTO.getTransactionType().equals("GRN".toString())
						|| dailyStockTransactionReportDTO.getTransactionType().equals("STKUPD/GRN".toString())) {
					
					dailyStockTransactionReportDTO.setGrnReceivedQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemReceivedQnty(Long.parseLong(ob1[4].toString()));
					
				} else if (dailyStockTransactionReportDTO.getTransactionType().equals("SALE".toString())) {
					
					dailyStockTransactionReportDTO.setSaleQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemIssuedQnty(Long.parseLong(ob1[4].toString()));
					
				} else if (dailyStockTransactionReportDTO.getTransactionType().equals("RETURN".toString())) {
					
					dailyStockTransactionReportDTO.setSaleReturnQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemReceivedQnty(Long.parseLong(ob1[4].toString()));
					
				} else if (dailyStockTransactionReportDTO.getTransactionType().equals("DAMAGED".toString())) {
					
					dailyStockTransactionReportDTO.setDamageQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemIssuedQnty(Long.parseLong(ob1[4].toString()));
					
				} else if (dailyStockTransactionReportDTO.getTransactionType()
						.equals("STOCK_ADJUSTMENT_ADD".toString())) {
					
					dailyStockTransactionReportDTO.setStockAdjuestMentAddQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemReceivedQnty(Long.parseLong(ob1[4].toString()));
					
				} else if (dailyStockTransactionReportDTO.getTransactionType()
						.equals("STOCK_ADJUSTMENT_MINUS".toString())) {
					
					dailyStockTransactionReportDTO.setStockadjusmtneMinusQnty(Long.parseLong(ob1[4].toString()));
					dailyStockTransactionReportDTO.setItemIssuedQnty(Long.parseLong(ob1[4].toString()));
				}
				dailyStokTransactionReportDTOList.add(dailyStockTransactionReportDTO);

			}

			for(DailyStockTransactionReportDTO inner : dailyStokTransactionReportDTOList) {
				if(openingHashMap.containsKey(inner.getItemId())) {
					inner.setOpeningStockQty(openingHashMap.get(inner.getItemId()));
//					inner.setTotalClosingStockQnty(dailyStokTransactionReportDTOList.stream().filter(i -> i.equals(inner.getItemId())).mapToLong( i -> i).sum();
//					inner.setTotalClosingStockQnty(inner.getOpeningStockQty() - inner.getItemReceivedQnty());
				} else {
					inner.setOpeningStockQty(inner.getItemReceivedQnty());
//					inner.setTotalClosingStockQnty(inner.getOpeningStockQty() - );
				}
			}
			
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			log.info("<<<  === Success Response === >>>");
		} catch (

		Exception e) {
			log.error(" >>  Exception Occured In DailyTransactionReportService >> generateReport method >> ", e);
		}
		return response;
	}

}
