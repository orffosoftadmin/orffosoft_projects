package co.orffosoft.dto;

import java.util.Date;

import co.orffosoft.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4284796302533070987L;

	Long id;

	String username;

	String password;
	
	Date createdDate;
	
	Long createdBy;
	
	Long modifiedBy;
	
	private String designation;
	
	Boolean status;
	
	Long userMasterVersion;
	
	Date modifiedDate;
	
	String userType;
	 
	Long version;

}


 
