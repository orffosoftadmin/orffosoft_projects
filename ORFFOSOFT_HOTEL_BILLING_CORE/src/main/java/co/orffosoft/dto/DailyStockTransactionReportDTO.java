package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;

import co.orffosoft.entity.EntityMaster;
import lombok.Data;

@Data
public class DailyStockTransactionReportDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 2284750849933451699L;
	
	String itemName;
	
	Date fromDate;
	
	String fromDateStr;
	
	Date toDate;
	
	String toDateStr;
	
	Long itemId;
	
	Long userId;
	
	EntityMaster entityMaster;
	
	Date stockTransactionDate;
	
	String saleType;
	
	Long openingStockQty;
	
	Long totalClosingStockQnty;
	
	Long saleQnty;
	
	Long saleReturnQnty;
	
	String TransactionType;
	
	Long stockAdjuestMentAddQnty;
	
	Long stockadjusmtneMinusQnty;
	
	Long damageQnty;
	
	String storeCode;
	
	String storeName;
	
	Long grnReceivedQnty;
	
	Long itemIssuedQnty;
	
	Long itemReceivedQnty;

}
