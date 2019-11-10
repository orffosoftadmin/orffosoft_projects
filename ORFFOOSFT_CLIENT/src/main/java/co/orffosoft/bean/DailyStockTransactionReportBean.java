package co.orffosoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppPreference;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.DailyStockTransactionReportDTO;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("dailyStockTransactionReportBean")
@Scope("session")
@Data
public class DailyStockTransactionReportBean implements Serializable {
	
	/**
	* 
	*/
	private static final long serialVersionUID = -3927409251841374148L;

	private final String DAILY_STOCK_TRANSACTION = "/pages/billing/billing_report/DailyStockTransactionReport.xhtml?faces-redirect=true;";

	@Autowired
	HttpService httpService;

	@Autowired
	AppPreference appPreference;

	@Autowired
	ErrorMap errorMap;

	@Autowired
	LoginBean loginBean;

	@Autowired
	CommonDataBean commonDataBean;

	DailyStockTransactionReportDTO dailyStockTransactionReportDTO;

	List<DailyStockTransactionReportDTO> dailyStockTransactionReportDTOList;

	public static final String SERVER_URL = AppUtil.getPortalServerURL();

	/**
	 * @return
	 */
	public String loadListPage() {

		dailyStockTransactionReportDTO = new DailyStockTransactionReportDTO();
		dailyStockTransactionReportDTOList = new ArrayList<>();

		return DAILY_STOCK_TRANSACTION;
	}

	/**
	 * 
	 */
	public void generateReport() {

		log.info(":::<-   DailyStockTransactionReportBean >> generateReport ->::: ");
		BaseDTO baseDTO = null;
		try {

			if (dailyStockTransactionReportDTO != null) {

				if (dailyStockTransactionReportDTO.getFromDate() == null) {
					AppUtil.addWarn("Please Select From Date");
					return;
				}
				if (dailyStockTransactionReportDTO.getToDate() == null) {
					AppUtil.addWarn("Please Select To Date");
					return;
				}
				dailyStockTransactionReportDTO.setUserId(loginBean.getUserDetailSession().getId());
				dailyStockTransactionReportDTO.setStoreCode(loginBean.getEntityMaster().getCode());
				dailyStockTransactionReportDTO.setStoreName(loginBean.getEntityMaster().getName());

				String url = SERVER_URL + "/dailyStockTransactionReportController/generateReport";
				log.info("::: DailyTransactionReportBean >>  generateReport URL :::", url);
				baseDTO = httpService.post(url,dailyStockTransactionReportDTO);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					dailyStockTransactionReportDTOList = new ArrayList<>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					dailyStockTransactionReportDTOList = mapper.readValue(jsonResponse,
							new TypeReference<List<DailyStockTransactionReportDTO>>() {
							});
					log.info("DailyStockTransactionReportBean >>  generateReport Method  Succes -->");
				} else {
					AppUtil.addInfo("No Record Found");
					log.info("DailyStockTransactionReportBean >>  generateReport Method  >> No Record Found -->");
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured in DailyStockTransactionReportBean >>  generateReport Method ", e);
		}

	}

	/**
	 * 
	 */
	public void clearData() {
		loadListPage();
	}
	
	/**
	 * @param item
	 */
	public void removeItem(DailyStockTransactionReportDTO item) {
		
	}
	
	
	
}
