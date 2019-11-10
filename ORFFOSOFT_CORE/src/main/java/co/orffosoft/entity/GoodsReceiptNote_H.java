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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper = false, of = "grn_h_id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "goods_receipt_note_h", uniqueConstraints = {
		@UniqueConstraint(name = "unq_grn_ent_const", columnNames = "grn_h_number"), @UniqueConstraint(name = "fk_grn_userid", columnNames = "grn_h_user_id") })
@AssociationOverrides({
		@AssociationOverride(name = "grn_h_modified_by", joinColumns = @JoinColumn(name = "fk_grn_modifiedby")) })
@Getter
@Setter
public class GoodsReceiptNote_H implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_receipt_note_h_grn_h_id_seq")
	@SequenceGenerator(name = "goods_receipt_note_h_grn_h_id_seq", sequenceName = "goods_receipt_note_h_grn_h_id_seq")
	private Long grn_h_id;

	@ManyToOne
	@JoinColumn(name = "grn_h_user_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_grn_userid"))
	private UserMaster userMaster;

	@ManyToOne
	@JoinColumn(name = "grn_h_supplier_id_fk", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_grn_supplier_master"))
	private SupplierMaster supplierMaster;

//	@ManyToOne
//	@JoinColumn(name = "grn_h_stock_transfer_id_fk", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_grn_stock_transfer"))
//	private StockTransfer stockTransfer;

	@Column(name = "grn_h_number")
	private String grn_H_Number;
	
	@Column(name = "grn_h_date")
	private Date grn_H_Date;
	
	@Column(name = "grn_h_total_number")
	private Double grn_H_Total_Number;
	
	@Column(name = "grn_h_gross_amount")
	private Double grn_H_Gross_Amount;
	
	@Column(name = "grn_h_discount_percentage")
	private Double grn_H_Discount_Percentage;
	
	@Column(name = "grn_h_discount_amount")
	private Double grn_H_Discount_Amount;
	
	@Column(name = "grn_h_net_amount")
	private Double grn_H_Net_Amount;
	
	@Column(name="grn_h_status")
	private String grn_H_Status;
	
	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "version")
	@Version
	private Long version;

}


