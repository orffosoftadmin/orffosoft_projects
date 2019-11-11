package co.orffosoft.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom Application Properties are listed here Note : If the property is
 * missing in your application.properties file defaults specified here will be
 * taken.
 * 
 */
@Service
public class AppPreference {

	@Getter
	@Setter
	@Value("${activiti.enabled:false}")
	private Boolean isActivitiEnabled;

	@Getter
	@Setter
	@Value("${operation.pdf.download.dir:/home/projects/cooptex/operation/pdf/download}")
	private String operationPdfDir;

	@Getter
	@Setter
	@Value("${operation.pdf.download.dir:/home/projects/cooptex/operation/qrcode}")
	private String operationQRCodeDir;
	
	@Getter
	@Setter
	@Value("${operation.api.url:/api/v1/operation}")
	private String operationApiUrl;

	@Getter
	@Setter
	@Value("${primeface.uploader.type:commons}")
	private String primefaceUploaderType;
	
	public String getPortalServerURL() {
		return AppUtil.getPortalServerURL();
	}
}
