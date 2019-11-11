package co.orffosoft.core.util;

import lombok.Data;
import lombok.ToString;

/** This method is for performing the pagination Operation  */
@ToString
@Data

public class PaginationRequestData {

	/* which no.th page Required */
	Integer pageNo;

	/* the Size of the page required */
	Integer paginationSize;

}
