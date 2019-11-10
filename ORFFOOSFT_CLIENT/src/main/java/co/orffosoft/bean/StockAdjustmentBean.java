package co.orffosoft.bean;

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
import co.orffosoft.dto.DailyTransactionReportDTO;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("stockAdjustmentBean")
@Scope("session")
@Data
public class StockAdjustmentBean {
	
	/**
	* 
	*/
	private static final long serialVersionUID = -3927409251841374148L;

	private final String DAILY_TRANSACTION = "/pages/billing/billing_report/DailyTransactionReport.xhtml?faces-redirect=true;";

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

	DailyTransactionReportDTO dailyTransactionReportDTO;

	List<DailyTransactionReportDTO> dailyTransactionReportDTOList;

	public static final String SERVER_URL = AppUtil.getPortalServerURL();

	/**
	 * @return
	 */
	public String loadListPage() {

		dailyTransactionReportDTO = new DailyTransactionReportDTO();
		dailyTransactionReportDTOList = new ArrayList<>();

		return DAILY_TRANSACTION;
	}

	/**
	 * 
	 */
	public void generateReport() {

		log.info(":::<-   DailyTransactionReportBean >> generateReport ->::: ");
		BaseDTO baseDTO = null;
		try {

			if (dailyTransactionReportDTO != null) {

				if (dailyTransactionReportDTO.getFromDate() == null) {
					AppUtil.addWarn("Please Select From Date");
					return;
				}
				if (dailyTransactionReportDTO.getToDate() == null) {
					AppUtil.addWarn("Please Select To Date");
					return;
				}
				dailyTransactionReportDTO.setUserId(loginBean.getUserDetailSession().getId());
				dailyTransactionReportDTO.setStoreCode(loginBean.getEntityMaster().getCode());
				dailyTransactionReportDTO.setStoreName(loginBean.getEntityMaster().getName());

				String url = SERVER_URL + "/dailyTransactionReportController/generateReport";
				log.info("::: DailyTransactionReportBean >>  generateReport URL :::", url);
				baseDTO = httpService.post(url,dailyTransactionReportDTO);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					dailyTransactionReportDTOList = new ArrayList<>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					dailyTransactionReportDTOList = mapper.readValue(jsonResponse,
							new TypeReference<List<DailyTransactionReportDTO>>() {
							});
					log.info("DailyTransactionReportBean >>  generateReport Method  Succes -->");
				} else {
					AppUtil.addInfo("No Record Found");
					log.info("DailyTransactionReportBean >>  generateReport Method  >> No Record Found -->");
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured in DailyTransactionReportBean >>  generateReport Method ", e);
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
	public void removeItem(DailyTransactionReportDTO item) {
		
	}


}
