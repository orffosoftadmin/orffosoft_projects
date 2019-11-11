package co.orffosoft.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import co.orffosoft.core.util.PaginationResponseData;
import lombok.Data;

@Data
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** error code. 0 if success else unique error code value */

	Integer statusCode = 2000;

	String message;
	
	String generalContent;

	String errorDescription;

	String languageErrorDescription;

	int totalRecords;

	String trackId;
	
	String executionTime;

	PaginationResponseData paginationResponseData;

	Object responseContent;

	List<?> responseContents;
	
	String dowloadUrlPath;
	
	List<Map<String, Object>> listOfData;
	List<Map<String, Object>> totalListOfData;

	public BaseDTO(String string, String error) {
		this.message = string;
		this.errorDescription = error;
	}

	public BaseDTO(int code){
		this.statusCode=code;
	}
	
	public BaseDTO() {
		// TODO Auto-generated constructor stub
	}

}