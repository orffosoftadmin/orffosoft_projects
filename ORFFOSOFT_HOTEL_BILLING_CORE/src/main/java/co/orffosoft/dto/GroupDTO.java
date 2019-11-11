package co.orffosoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"id"})
@JsonIgnoreProperties
public class GroupDTO {
	
	String id;
	
	String name;

	String type;
	
	String revision;
	
	Boolean status;
	
}
