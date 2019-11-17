package co.orffosoft.dto;


import java.util.Date;

import lombok.Data;

@Data
public class StockUtilityDTO {
	
	private int stockPk;
	private String stockId;
	private String usedDateStr;
	private int createdBy;
	private String createdByName;
	private Date createdDate;
	private String createdDateStr;
	private int modifyBy;
	private String modifyByName;
	private Date modifyDate;
	private String modifyDateStr;
}
