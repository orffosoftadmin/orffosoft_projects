package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.RoleMaster;
import co.orffosoft.enums.UserType;
import lombok.Data;


@Data
public class UserMasterDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3425616477020093109L;


	private Long id;

	private String username;

	private String password;
	
	private String confirmPassword;
	
	private String storeCode;
	
	private String storeName;
	
	private String resetPassword;

	List<RoleMaster> roleMaster;

	List<EntityMaster> region;

	List<GroupDTO> groupList;

	private Boolean status;

	private Long createdBy;

	private Long modifiedBy;
	
	private Long userMasterVersion;

	private String emailId;
	
	private String name;
	
	private String userType;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private String type;
	
	List<RoleMasterDTO> roleMasterDTO;

//    List<RegionDTO> regionDTO;
	
	private Boolean isDelete=false;
	
	private String roleName;
	
}