package co.orffosoft.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductVariryMastersearchDTO {

	private String catageoryCodeOrName;
	private String groupCodeOrName;
	private String varityCodeOrName;
	private String varityCodeOrNameInTamil;

	Date createdDate;

	private String status;
	private Boolean activeStatus;
	private Integer first;
	private Integer size;
	PaginationDTO paginationDTO = new PaginationDTO();

	public ProductVariryMastersearchDTO() {

	}

}
