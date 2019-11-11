package co.orffosoft.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class RoleMasterDTO {

	
	private long id;
	
	private long createdBy;
	
	private Date createdDate;
}
