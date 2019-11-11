package co.orffosoft.dto;

import java.util.Date;

import co.orffosoft.entity.UomMaster;
import co.orffosoft.entity.UserMaster;
import lombok.Data;
@Data
public class ProductVarietyMasterDTO {
	Long id;
	private String code;
	private String name;
	private String lname;
	private Double lengthActual;
	private Double lengthTolerance;
	private Double widthActual;
	private Double widthTolerance;
	private Double warpYarnWeight;
	private String warpYarnCountActual;
	private Double warpYarnCountTolerance;
	private Double weftYarnWeight;
	private String weftYarnCountActual;
	private Double weftYarnCountTolerance;
	private Double picksPerInchActual;
	private Double picksPerInchTolerance;
	private Double endspPerInchActual;
	private Double endsPerInchTolerance;
	private boolean activeStatus;
	private String statusValue;
	private UserDTO createdBy;
	Date createdDate;
	private UserDTO modifiedBy;
	Date modifiedDate;
	private String hsnCode;
	private String selectable;
	private String description;
	private String costingType;

	private boolean blkorder; 
	private Long version;
	
	private Long cgstPercentage;
	private Long sgstPercentage;
	private boolean status;
	

	
	private UomMaster uomMaster;
	private UomMaster luomMaster;
	private UomMaster wuomMaster;
	private UserMaster userMaster;
}


