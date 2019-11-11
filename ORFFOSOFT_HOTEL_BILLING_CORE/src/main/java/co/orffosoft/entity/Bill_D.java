package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(callSuper = false, of = "bill_d_pk")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "bill_d", uniqueConstraints = {
		@UniqueConstraint(name = "bill_d_pk", columnNames = "bill_d_pk")})
@ToString
@Getter
@Setter
public class Bill_D implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -8697432668165900774L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_d_bill_d_pk_seq")
	@SequenceGenerator(name = "bill_d_bill_d_pk_seq", sequenceName = "bill_d_bill_d_pk_seq")
	@Column(name = "bill_d_pk", updatable = false)
	private Long bill_d_pk;

	@Column(name = "bill_d_bill_h_fk")
	private Long bill_d_bill_h_fk;

	@Column(name = "bill_d_sku_fk")
	private Long bill_d_sku_fk;

	@Column(name = "bill_d_item_qnty")
	private Long bill_d_item_qnty;

	@Column(name = "bill_d_selling_price")
	private Double bill_d_selling_price;

	@Column(name = "bill_d_unitrate")
	private Double bill_d_unitrate;

	@Column(name = "bill_d_totalunitrate")
	private Double bill_d_totalunitrate;
	
	@Column(name = "bill_d_purchase_price")
	private Double bill_d_purchase_price;
	
	@Column(name = "bill_d_discount_percentage")
	private Double bill_d_discount_percentage;

	@Column(name = "bill_d_discount_value")
	private Double bill_d_discount_value;

	@Column(name = "bill_d_cgst_percentage")
	private Double bill_d_cgst_percentage;

	@Column(name = "bill_d_cgst_value")
	private Double bill_d_cgst_value;

	@Column(name = "bill_d_sgst_percentage")
	private Double bill_d_sgst_percentage;
	
	@Column(name = "bill_d_sgst_value")
	private Double bill_d_sgst_value;

	@Column(name = "bill_d_net_amount")
	private Double bill_d_net_amount;
	
	@Column(name = "created_by")
	private Long created_by;

	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "modified_by")
	private Long modified_by;

	@Column(name = "modified_date")
	private Date modified_date;


}
