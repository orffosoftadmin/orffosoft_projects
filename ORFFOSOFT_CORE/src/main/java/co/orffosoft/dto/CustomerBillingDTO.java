package co.orffosoft.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CustomerBillingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3803663386621461351L;
	
	Long tableId;

	Long bill_H_Pk;
	
	Date billDate;
	
	Long bill_H_CustomerFK;
	
	String bill_H_BillNo;
	
	Long bill_D_Pk;
	
	Long bill_D_Bill_H_Fk;
	
	Long bill_D_SkuFk;
	
	Long bill_D_ItemQnty;
	
	Double bill_D_SellingPrice;
	
	Double bill_D_PurchasePrice;
	
	Double bill_D_DiscountPercentage;
	
	Double bill_D_DiscountValue;
	
	Double bll_D_CgstPercentage;
	
	Double bill_D_CgstValue;
	
	Double bill_D_Sgst_Percentage;
	
	Double bill_D_SgstValue;
	
	Double bill_D_NetAmount;
	
	String ItemCode;
	
	String itemName;
	
	String itemCodeName;
	
	String hsnCode;
	
	Long stockQnty;
	
	Long created_By;
	
	Date created_Date;
	
	Long modified_By;
	
	Date modified_date;
	
	String uomName;
	
	Long billedQnty;
	
	Double unitRate;
	
	Double totalRate;
	
	Double discountPercent;
	
	Long cgstPercent;
	
	Double cgstAmount;
	
    Long sgstPercent;
	
	Double sgstAmount; 
	
	Double totalNetPrice;
	
	Double sellingPrice;
	
	List<Double> sellingPrices;
	
	Long itemId;
	
	List<Double> itemUnitRates;
	
	Long supplierId;
	
	String supplierName;
	
	List<CustomerBillingDTO> customerBillingDTOList = new ArrayList<>();
	
}
