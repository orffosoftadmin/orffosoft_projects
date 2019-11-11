package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper = false, of = "grn_d_id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "goods_receipt_note_d")
@AssociationOverrides({
		@AssociationOverride(name = "grn_d_created_by", joinColumns = @JoinColumn(name = "fk_grn_createdby")),
		@AssociationOverride(name = "grn_d_modified_by", joinColumns = @JoinColumn(name = "fk_grn_modifiedby")) })
@Getter
@Setter
public class GoodsReceiptNote_D extends Trackable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_receipt_note_d_grn_d_id_seq")
	@SequenceGenerator(name = "goods_receipt_note_d_grn_d_id_seq", sequenceName = "goods_receipt_note_d_grn_d_id_seq")
	private Long grn_d_id;

	@ManyToOne
	@JoinColumn(name = "grn_d_grn_h_id_fk", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_grn_d_grn_h_id"))
	private GoodsReceiptNote_H goodsReceiptNote_H;
//
	@ManyToOne
	@JoinColumn(name = "grn_d_sku_id_fk", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_sku_id"))
	private ProductVarietyMaster productVarietyMaster;
//
//	@ManyToOne
//	@JoinColumn(name = "grn_h_stock_transfer_id_fk", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_grn_stock_transfer"))
//	private StockTransfer stockTransfer;

	@Column(name = "grn_d_item_qnty")
	private Long grn_D_Item_Qnty;
	
	@Column(name = "grn_d_expiry_date")
	private String grn_D_Expiry_Date;
	
	@Column(name = "grn_d_date")
	private Date grn_D_Date;
	
	@Column(name = "grn_d_discount_amount")
	private Double grn_D_Discount_Amount;
	
	@Column(name = "grn_d_discount_percentage")
	private Double grn_D_Discount_Percentage;
	
	@Column(name = "grn_d_cgst_amount")
	private Double grn_D_Cgst_Amount;

	@Column(name = "grn_d_cgst_percentage")
	private Long grn_D_Cgst_Percentage;
	
	@Column(name = "grn_d_sgst_percentage")
	private Long grn_D_Sgst_Percentage;
	
	@Column(name = "grn_d_sgst_amount")
	private Double grn_D_Sgst_Amount;
	
	@Column(name = "grn_d_reject_qnty")
	private Double grn_D_Reject_Qnty;
	
	@Column(name = "grn_d_accepted_qnty")
	private Double grn_D_Accepted_Qnty;
	
	@Column(name = "grn_d_rate")
	private Double grn_D_Rate;
	
	@Column(name = "grn_d_purchase_amount")
	private Double grn_D_Purchase_Amount;
	
	@Column(name = "grn_d_selling_amount")
	private Double grn_D_Selling_Amount;
	
	@Column(name = "grn_d_total_purchase_amt")
	private Double grn_D_Total_Purchase_Amt;
	
	@Column(name = "grn_d_total_selling_amt")
	private Double grn_D_Total_Selling_Amt;
	
	@Column(name = "grn_d_net_amount")
	private Double grn_D_Net_Amount;
	
	@Column(name="grn_d_status")
	private String grn_D_Status;

	@Column(name = "version")
	@Version
	private Long version;

}
