package co.orffosoft.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class InitialStockUploadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7794042911312265943L;

	String itemName;

	Long quantity;

	Long cgstPercentage;

	Long sgstPercentage;

	Double purchaseAmout;

	Double sellingAmount;

	Double cgstAmount;

	Double sgstAmount;

	Double netAmount;

	Long skuId;

	Double totalPurchaseAmt;

	Double totalSellingAmt;

}
