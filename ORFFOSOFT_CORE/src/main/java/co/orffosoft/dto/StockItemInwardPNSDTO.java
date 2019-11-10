package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.entity.GoodsReceiptNote_D;
import co.orffosoft.entity.GoodsReceiptNote_H;
import co.orffosoft.entity.UserMaster;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class StockItemInwardPNSDTO implements Serializable{
	
	private static final long serialVersionUID = 5352595304745840618L;
	
	UserMaster userMaster;
	
	String transferType;	
	
	GoodsReceiptNote_D goodsReceiptNote_D;
	
	List<GoodsReceiptNote_D> goodsReceiptNote_DList;
	
	GoodsReceiptNote_H GoodsReceiptNote_H;
	
	List<GoodsReceiptNote_H> GoodsReceiptNote_HList;
	
	String grnNumber;
	
	String supplierCodeName;
	
	Date grnCreatedDate;
	
	String grnCreatedBy;

	Long id;

	String status;
	
	Long grnHID;
	
	Date grnDate;
	
	String userName;
	
	Date paymentDueDate;

	@Transient
	private PaginationDTO paginationDTO;
	
	@Transient
	private Map<String, Object> filters;
}
