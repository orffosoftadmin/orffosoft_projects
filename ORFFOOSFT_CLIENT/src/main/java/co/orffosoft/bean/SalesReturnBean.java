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
import co.orffosoft.dto.SalesReturnDTO;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("salesReturnBean")
@Scope("session")
@Data
public class SalesReturnBean {

	/**
	* 
	*/
	private static final long serialVersionUID = -3927409251841374148L;

	private final String SALES_RETURN = "/pages/sales/salesReturn.xhtml?faces-redirect=true;";

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

	SalesReturnDTO salesReturnDTO;

	List<SalesReturnDTO> salesReturnDTOList;

	List<SalesReturnDTO> viewBillDetailsList;

	public static final String SERVER_URL = AppUtil.getPortalServerURL();

	/**
	 * @return
	 */
	public String loadListPage() {

		salesReturnDTO = new SalesReturnDTO();
		salesReturnDTOList = new ArrayList<>();
		viewBillDetailsList = new ArrayList<>();
		return SALES_RETURN;
	}

	/**
	 * 
	 */
	public void generateReport() {

		log.info(":::<-   SalesReturnBean >> generateReport ->::: ");
		BaseDTO baseDTO = null;
		try {

			if (salesReturnDTO != null) {

				if (salesReturnDTO.getFromDate() == null) {
					AppUtil.addWarn("Please Select From Date");
					return;
				}
				if (salesReturnDTO.getToDate() == null) {
					AppUtil.addWarn("Please Select To Date");
					return;
				}
				salesReturnDTO.setUserId(loginBean.getUserDetailSession().getId());
				salesReturnDTO.setStoreCode(loginBean.getEntityMaster().getCode());
				salesReturnDTO.setStoreName(loginBean.getEntityMaster().getName());

				String url = SERVER_URL + "/salesReturnController/generateReport";
				log.info("::: SalesReturnBean >>  generateReport URL :::", url);
				baseDTO = httpService.post(url, salesReturnDTO);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					salesReturnDTOList = new ArrayList<>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					salesReturnDTOList = mapper.readValue(jsonResponse, new TypeReference<List<SalesReturnDTO>>() {
					});
					log.info("SalesReturnBean >>  generateReport Method  Succes -->");
				} else {
					AppUtil.addInfo("No Record Found");
					log.info("SalesReturnBean >>  generateReport Method  >> No Record Found -->");
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured in SalesReturnBean >>  generateReport Method ", e);
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

	public void salesReturnProcess(SalesReturnDTO dto) {

	}

	public void viewBillDetails(SalesReturnDTO dto) {
		try {
			if (dto.getBillId() != null) {
				String url = SERVER_URL + "/salesReturnController/getbilldetailsbyid";
				log.info("::: SalesReturnBean >>  viewBillDetails URL :::", url);
				dto.setUserId(loginBean.getUserDetailSession().getId());
				dto.setStoreCode(loginBean.getEntityMaster().getCode());
				dto.setStoreName(loginBean.getEntityMaster().getName());

				BaseDTO baseDTO = httpService.post(url, dto);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					viewBillDetailsList = new ArrayList<>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					viewBillDetailsList = mapper.readValue(jsonResponse, new TypeReference<List<SalesReturnDTO>>() {
					});
					log.info("SalesReturnBean >>  viewBillDetails Method  Succes -->");
				} else {
					AppUtil.addInfo("No Record Found");
					log.info("SalesReturnBean >>  viewBillDetails Method  >> No Record Found -->");
				}
			}
		} catch (Exception e) {
			log.error("Exception Occured In Sales Returnbean ", e);
		}
		log.info(" === >>>>> End Of SalesReturn Bean ViewBillDetails === >>>>>");

	}

	public void submit() {

		try {

			if (salesReturnDTOList != null && salesReturnDTOList.size() > 0) {
				salesReturnDTO.setSalesReturnDTOList(salesReturnDTOList);
				String url = SERVER_URL + "/salesReturnController/submitsalesreturn";
				log.info("::: SalesReturnBean >>  generateReport URL :::", url);
				BaseDTO baseDTO = httpService.post(url, salesReturnDTO);
				if (baseDTO.getStatusCode() == 0) {
					ObjectMapper mapper = new ObjectMapper();
					salesReturnDTOList = new ArrayList<>();
					String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
					salesReturnDTOList = mapper.readValue(jsonResponse, new TypeReference<List<SalesReturnDTO>>() {
					});
					log.info("SalesReturnBean >>  generateReport Method  Succes -->");
				} else {
					AppUtil.addInfo(baseDTO.getMessage());
					log.info("SalesReturnBean >>  generateReport Method  >> No Record Found -->");
				}

			}

		} catch (Exception e) {
			log.error("Exception Occured in SalesReturnBean", e);
		}

	}

	public void updateReturnQnty(SalesReturnDTO dto) {

		if (dto != null) {

			if (!(dto.getReturnedQnty() <= dto.getQnty())) {
				AppUtil.addWarn("Return Qnty More Then Purchased Qnty");
				dto.setReturnedQnty(0L);
			} else if (dto.getReturnedQnty() > 0) {
				Double totalNetReturnPrice = (dto.getUnitPrice() + dto.getCgstAmount() + dto.getSgstAmount())
						- dto.getDiscount();
				dto.setReturnedAmount(totalNetReturnPrice * dto.getReturnedQnty());
			}
		}
	}

}
