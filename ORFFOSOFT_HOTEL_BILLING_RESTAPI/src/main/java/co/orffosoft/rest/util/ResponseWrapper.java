package co.orffosoft.rest.util;

import java.util.Map;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.entity.ErrorMaster;
import co.orffosoft.repository.CacheRepository;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ResponseWrapper {

	@Autowired
	CacheRepository cacheRepository;
	
	
	Map<String, ErrorMaster> errorMap;

	/**
	 * @param wrapperDTO
	 * @return
	 */
	@Deprecated
	public WrapperDTO send(WrapperDTO wrapperDTO) {
		if (wrapperDTO == null) {
			return null;
		}
		String defaultErrorDescription = null;
		int statusCode = wrapperDTO.getStatusCode();
		log.info("ResponseWrapper-statusCode: " + statusCode);
		Map<String, ErrorMaster> errorMap = cacheRepository.loadErrorMaster(ErrorMaster.class.getName());
		if (errorMap != null && !errorMap.isEmpty()) {
			String languageCode = (String) ThreadContext.get("LanguageCode");
			log.info("ResponseWrapper-languageCode: " + languageCode);
			String key = new StringBuilder().append(statusCode).append("_").append(languageCode).toString();
			log.info("ResponseWrapper-key: " + key);
			ErrorMaster errorMaster = errorMap.get(key);
			if (errorMaster != null && errorMaster.getDescription() != null) {
				wrapperDTO.setErrorDescription(errorMaster.getDescription());
			} else {
				defaultErrorDescription = "Error Description Not Found";
			}

		} else {
			defaultErrorDescription = "Error Details Not Loaded";
		}

		if (defaultErrorDescription != null) {
			wrapperDTO.setErrorDescription(defaultErrorDescription);
		}

		log.info("ResponseWrapper-errorDescription: " + wrapperDTO.getErrorDescription());

		return wrapperDTO;
	}
	
	
	public BaseDTO send(BaseDTO baseDTO) {
		
		if (baseDTO == null) {
			return null;
		}
		
		
		String languageCode = (String) ThreadContext.get("LanguageCode");
		log.info("Language Code  = " + languageCode);
		
		int statusCode = baseDTO.getStatusCode();
		if(errorMap == null || errorMap.isEmpty()) {
			errorMap = cacheRepository.loadErrorMaster(ErrorMaster.class.getName());
		}

		if(languageCode == null || languageCode.isEmpty()) {
			languageCode = "en";
		} else {
			languageCode = languageCode.split("_")[0];
		}

		ErrorMaster errorMaster = errorMap.get(languageCode + "_" + statusCode);

		if (errorMaster != null && errorMaster.getDescription() != null) {
			log.info("Message------>"+errorMaster.getDescription());
			baseDTO.setErrorDescription(errorMaster.getDescription());
		} else {
			baseDTO.setErrorDescription("Error message not found");
		}	

	//	log.info(baseDTO);
		return baseDTO;
	}

}
