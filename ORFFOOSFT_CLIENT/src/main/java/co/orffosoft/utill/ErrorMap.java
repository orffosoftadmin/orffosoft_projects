package co.orffosoft.utill;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.orffosoft.bean.LanguageBean;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.entity.ErrorMaster;
import co.orffosoft.enums.ErrorMessageType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Setter
@Getter
@Scope("session")
public class ErrorMap {

	private Map<Integer, ErrorMaster> error = new TreeMap<Integer, ErrorMaster>();

	@Autowired
	LanguageBean languageBean;

	public void setError(List<ErrorMaster> list) {
		for (ErrorMaster master : list) {
			this.error.put(master.getCode(), master);
		}
		log.info("Size of errorMap : " + error.size());
	}

	public ErrorMaster getErrorByCode(Integer code) {
		if (code == null) {
			return null;
		}

		return this.error.get(code);
	}

	public String getMessage(int statusCode) {
		ErrorMaster errorMaster = this.getErrorByCode(statusCode);
		if (errorMaster == null) {
			return null;
		}
		if (!languageBean.getLocaleCode().equals("ta_IN")) {
			return errorMaster.getDescription();
		} else {
			return errorMaster.getDescription();
		}
	}

	/**
	 * @param statusCode
	 */
	public void notify(int statusCode) {

		log.info("Notify : " + statusCode);

		log.info(getMessage(statusCode));

		ErrorMaster errorMaster = this.getErrorByCode(statusCode);

		if (errorMaster != null) {

			ErrorMessageType messageType = errorMaster.getMessageType();
			
			String errorDescription = errorMaster.getDescription();
			
			log.info("errorDescription  ----- > "+errorDescription);

			log.info("messageType : " + messageType);

			if ((ErrorMessageType.INFO).equals(messageType)) {
				if (!languageBean.getLocaleCode().equals("ta_IN")) {
					AppUtil.addInfo(errorDescription);
				} else {
					AppUtil.addInfo(errorDescription);
				}
			} else if ((ErrorMessageType.ERROR).equals(messageType)) {
				if (!languageBean.getLocaleCode().equals("ta_IN")) {
					AppUtil.addError(errorDescription);
				} else {
					AppUtil.addError(errorDescription);
				}
			} else if ((ErrorMessageType.WARN).equals(messageType)) {
				if (!languageBean.getLocaleCode().equals("ta_IN")) {
					AppUtil.addWarn(errorDescription);
				} else {
					AppUtil.addWarn(errorDescription);
				}
			}
		}
	}

	public void notify(int statusCode, String language) {

		log.info(getMessage(statusCode));

		ErrorMaster errorMaster = this.getErrorByCode(statusCode);

		if (errorMaster != null) {
			if (errorMaster.getMessageType().equals(ErrorMessageType.INFO)) {
				if (!language.equals("ta_IN")) {
					AppUtil.addInfo(errorMaster.getDescription());
				} else {
					AppUtil.addInfo(errorMaster.getDescription());
				}
			} else if (errorMaster.getMessageType().equals(ErrorMessageType.ERROR)) {
				if (!language.equals("ta_IN")) {
					AppUtil.addError(errorMaster.getDescription());
				} else {
					AppUtil.addError(errorMaster.getDescription());
				}
			} else if (errorMaster.getMessageType().equals(ErrorMessageType.WARN)) {
				if (!language.equals("ta_IN")) {
					AppUtil.addWarn(errorMaster.getDescription());
				} else {
					AppUtil.addWarn(errorMaster.getDescription());
				}
			}
		}
	}

	public void loadErrorMessages(String serverURL, HttpEntity<?> requestEntity) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WrapperDTO> responseEntity = restTemplate.exchange(serverURL + "/errors", HttpMethod.GET,
				requestEntity, WrapperDTO.class);
		WrapperDTO wrapperDTO = responseEntity.getBody();
		if (wrapperDTO != null && wrapperDTO.getStatusCode() == 0) {
			List<ErrorMaster> errorMasterList = wrapperDTO.getErrorMasterList();
			setError(errorMasterList);

		}
	}

	public String msg(int statusCode) {
		try {
			return this.getMessage(statusCode);
		} catch (Exception ex) {
			log.error("Exception at msg() >>> ", ex);
		}
		return "";
	}

	public ErrorMaster getErrorMaster(int statusCode) {
		ErrorMaster errorMaster = null;
		try {
			log.info("getErrorMaster : " + statusCode);

			log.info(getMessage(statusCode));

			errorMaster = this.getErrorByCode(statusCode);
		} catch (Exception ex) {
			log.error("Exception at getErrorMaster() >>> ", ex);
		}
		return errorMaster;
	}
}
