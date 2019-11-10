package co.orffosoft.core.util;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/** This method is for performing the pagination Operation  */
@ToString
@Data
public class PaginationResponseData {
	

	Long TotalElements;

	Integer NumberOfElements;

	Integer TotalPages;

	List<?> Contents;
	

}
