package co.orffosoft.dto;

import java.util.List;

import co.orffosoft.entity.Application;
import lombok.Data;

@Data
public class RoleDTO {
	
	Long id;
	
	String roleName;
	
	Application application;
	
	List<Long> featuresList;
	
	Long createdBy;
	
	List<AppFeatureDto> featureList;
	
	Long modifiedBy;
	
}
