package co.orffosoft.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductVarityMasterResponse {
	
	private Long varityId;
	private String varityName;
	private String varityLname;
	private String varitycode;
	Date createdDate;
	private Long groupId;
	private String groupName;
	private String groupCode;
	private Long catageoryId;
	private String catageoryName;
	private String catageoryCode;
	private String status;
	private String catageoryCodeorName;
	private String groupCodeorName;
	private String varityCodeorName;
	private String varityCodeorNameinTamil;
	private Boolean activeStatus;
	private Integer first;
	private Integer size;
	PaginationDTO paginationDTO = new PaginationDTO();
	
	public ProductVarityMasterResponse(){
		
	}
	

}
