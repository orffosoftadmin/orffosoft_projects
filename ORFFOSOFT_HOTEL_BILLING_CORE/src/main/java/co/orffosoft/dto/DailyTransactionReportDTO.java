package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DailyTransactionReportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3803663386621461351L;
	
	Long bill_Id;

	String customerName;
	
	String storeCode;
	
	String storeName;
	
	Long userId;
	
	Long customerMobileNo;

	String billNo;
	
	Date billDate;
	
	String billDateStr;
	
	Date fromDate;
	
	String fromDateStr;
	
	Date toDate;
	
	String toDateStr;
	
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
	
}

