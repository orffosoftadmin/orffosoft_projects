package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class PaginationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826030626927359006L;

	Integer pageNo, first;

	Integer pageSize;
	
	String sortField;
	
	String sortOrder;
	
//	RetirementType retirementType;
	
	Map<String, Object> filters;
	
	Long userId;
	
//	ProductWiseRequirementDto productWiseRequirementDto;
	
	public PaginationDTO() {
		
	}

	public PaginationDTO(Integer pageNo, Integer pageSize, String sortField, String sortOrder) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	public PaginationDTO(Integer first, Integer pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
		this.first = first;
		this.pageSize = pageSize;
		this.sortField = sortField;
		this.sortOrder = sortOrder;
		this.filters = filters;
	}
}