package co.orffosoft.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginResponseMobileDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private UserMasterMobileDTO userDetails;

	private boolean authenticationStatus;
	
	private String sessionid;
	
	public LoginResponseMobileDTO() {
		// TODO Auto-generated constructor stub
	}

}
