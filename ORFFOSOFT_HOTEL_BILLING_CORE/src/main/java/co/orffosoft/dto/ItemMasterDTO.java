package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ItemMasterDTO implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7544085809474912989L;

	Long id;

	private String itemCode;

	private String itemName;
	
	private String itemCodeOrName;
	
	String itemCodeOrNameInTamil;
	
	private Long activeStatus;

	String regionalName;

	private Date createdDate;

	private UserDTO createdBy;

	private UserDTO modifiedBy;

	private Date modifiedDate;

	String username;
	PaginationDTO paginationDTO = new PaginationDTO();
    private String statusValue;

	
}
