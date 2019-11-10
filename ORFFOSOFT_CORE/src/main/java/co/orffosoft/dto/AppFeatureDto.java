package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import co.orffosoft.entity.Application;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = {"id"})
public class AppFeatureDto implements Serializable {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String featureName;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private String pageName;

	@Getter
	@Setter
	private List<AppFeatureDto> features; // Is the feature is parent or Child

	@Getter
	@Setter
	private AppFeatureDto parent;
	
	@Getter
	@Setter
	private Application application;
	
	@Getter
	@Setter
	public Long createdBy;

	@Getter
	@Setter
	public Date createdDate;

	@Getter
	@Setter
	public Long modifiedBy;

	@Getter
	@Setter
	
	public Date modifiedDate;
	
	@Getter
	@Setter
	private Map<String,Boolean> leaf=new HashMap<String,Boolean>();
	
	@Getter
	@Setter
	private String action;
	
	@Getter
	@Setter
	private Map<String,Long> featureIds=new HashMap<String,Long>();
	
	@Getter
	@Setter
	private Boolean isAdd=false;
	
	@Getter
	@Setter
	private Boolean isEdit=false;
	
	@Getter
	@Setter
	private Boolean isView=false;
	
	@Getter
	@Setter
	private Boolean isDelete=false;
	
	@Getter
	@Setter
	private Boolean selectAll=false;
	
	
	@Getter
	@Setter
	private Boolean isApproved=false;
	
	@Getter
	@Setter
	private Boolean isRejected=false;
	
}
