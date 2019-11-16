package co.orffosoft.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ItemDTO {
	private int itemPk;
	private String itemCode;
	private String itemName;
	private int itemTypeFk;
	private String itemTypeName;
	private int uomFk;
	private String uomName;
	private int statusFk;
	private int status;
	private String createdBy;
	private Date createdDate;
	private String modifyBy;
	private Date modifyDate;
}
