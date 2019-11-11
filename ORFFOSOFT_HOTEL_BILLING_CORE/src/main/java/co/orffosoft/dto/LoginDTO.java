/**
 * 
 */
package co.orffosoft.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ftuser
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813870311678690017L;

	private String username;

	private String password;

	private String emailId;
	
	private String itemName;
	
	private Long soldQuantity;
	
	private String storeCode;

	/**
	 * 
	 */
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

}
