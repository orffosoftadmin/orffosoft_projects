package co.orffosoft.utill;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import co.orffosoft.bean.LoginBean;
import co.orffosoft.dto.BaseDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Scope("session")
public class HttpService {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	LoginBean loginBean;

	private void trackDetails(MultiValueMap<String, String> headers) {

		if (headers != null && headers.get("trackId") != null) {
			headers.remove("trackId");
		}
		if (headers == null)
			headers = new LinkedMultiValueMap<String, String>();
		headers.add("trackId", ThreadContext.get("TrackId"));

		Iterator<String> it = headers.keySet().iterator();

		while (it.hasNext()) {
			String theKey = (String) it.next();
			// log.info("Key [" + theKey + "] Value " +
			// queryParameters.getFirst(theKey) + "]");
		}

	}

	public BaseDTO post(String URL, Object object) {

		log.info("Post to [" + URL + "]");

		trackDetails(loginBean.headers);

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(object, loginBean.headers);

		ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpRequestEntity,
				BaseDTO.class);

		return responseEntity.getBody();
	}

	public BaseDTO get(String URL) {

		log.info("Get to [" + URL + "]");

		trackDetails(loginBean.headers);

		log.info("header" + loginBean.headers);

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(loginBean.headers);

		ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, httpRequestEntity,
				BaseDTO.class);

		return responseEntity.getBody();
	}

	public BaseDTO put(String URL, Object object) {

		log.info("Put to [" + URL + "]");

		trackDetails(loginBean.headers);

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(object, loginBean.headers);

		ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, httpRequestEntity,
				BaseDTO.class);

		return responseEntity.getBody();
	}

	public BaseDTO delete(String URL) {

		log.info("Get to [" + URL + "]");

		trackDetails(loginBean.headers);

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(loginBean.headers);

		ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.DELETE, loginBean.requestEntity,
				BaseDTO.class);

		return responseEntity.getBody();
	}

	public InputStream generatePDF(String URL, Object object) {

		log.info("Generate PDF request to [" + URL + "]");

		trackDetails(loginBean.headers);

		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(object, loginBean.headers);

		ResponseEntity<byte[]> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpRequestEntity,
				byte[].class);

		if (responseEntity == null || responseEntity.getBody() == null) {
			return null;
		}

		InputStream inputStream = new ByteArrayInputStream(responseEntity.getBody());

		return inputStream;
	}

	public BaseDTO uploadFile(String URL, Object object) {

		log.info("Get to [" + URL + "]");

		trackDetails(loginBean.headers);

		loginBean.headers.add("Content-Type", "multipart/form-data");

		restTemplate.getMessageConverters().add(new ResourceHttpMessageConverter());

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(object, loginBean.headers);

		ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpRequestEntity,
				BaseDTO.class);

		return responseEntity.getBody();
	}

	public InputStream downloadFile(String URL, Object object) {

		log.info("Generate PDF request to [" + URL + "]");

		trackDetails(loginBean.headers);

		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		HttpEntity<?> httpRequestEntity = new HttpEntity<>(object, loginBean.headers);

		ResponseEntity<byte[]> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpRequestEntity,
				byte[].class);

		if (responseEntity == null || responseEntity.getBody() == null) {
			return null;
		}

		InputStream inputStream = new ByteArrayInputStream(responseEntity.getBody());

		return inputStream;
	}

}
