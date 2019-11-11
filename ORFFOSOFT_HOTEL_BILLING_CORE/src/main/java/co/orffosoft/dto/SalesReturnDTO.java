package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SalesReturnDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734555980938145396L;
	
	Date fromDate;
	
	Date toDate;
	
	String fromDateStr;
	
	String toDateStr;
	
	Long customerMobileNo;
	
	String customerName;
	
	String billNo;
	
	Date billDate;
	
	String itemName;
	
	Long qnty;
	
	Double unitPrice;
	
    Long cgst;
	
	Long sgst;
	
	Long discount;
	
	Double netPrice;
	
	String userName;
	
	Long cgstPercent;
	
	Double cgstAmount;
	
	Long sgstPercent;
	
	Double sgstAmount;
	
	Double totalUnitPrice;
	
	Long userId;
	
	String storeCode;
	
	String storeName;
	
	Boolean isSelected;
	
	Long billId;
	
	List<SalesReturnDTO> salesReturnDTOList;
	
	String hsnCode;
	
	Long customerFk;
	
	Long itemId;
	
	Long returnedQnty;
	
	Double returnedAmount;

}
