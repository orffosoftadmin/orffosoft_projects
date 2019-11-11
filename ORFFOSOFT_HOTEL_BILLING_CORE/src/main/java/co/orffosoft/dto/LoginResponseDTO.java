
package co.orffosoft.dto;

import java.util.Map;

import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.UserMaster;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ftuser
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginResponseDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1709698346135735570L;

	private UserMaster userDetails;
	
	private EntityMaster entityMaster;

	private String message;

	private boolean authenticationStatus;

	private String prePath = "";

	private String sessionid;

	private String misTableRowSize;

	private String misTablePageTemplate;

	private Map<String, Boolean> userFeatures;

	private Map<String, String> keyValueMap;

	/**
	 * 
	 */
	public LoginResponseDTO() {
		// TODO Auto-generated constructor stub
	}

}
