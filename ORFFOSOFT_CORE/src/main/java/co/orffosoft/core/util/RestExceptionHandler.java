package co.orffosoft.core.util;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.orffosoft.dto.BaseDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("Web Request" + request);
		log.error("Malformed JSON request : Bad request" + status.getReasonPhrase());
		String error = "Malformed JSON request";
		log.error("Exception", ex);
		return buildResponseEntity(new BaseDTO(HttpStatus.BAD_REQUEST.toString(), error), status);
	}

	private ResponseEntity<Object> buildResponseEntity(BaseDTO baseDto, HttpStatus status) {
		return new ResponseEntity<>(baseDto, status);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log.error("Web Request" + request);
		log.error("Http Internal Error" + status.getReasonPhrase());
		log.error("Exception", ex);
		return new ResponseEntity<>(new BaseDTO(status.name().toString(), status.getReasonPhrase()), status);
	}

}
