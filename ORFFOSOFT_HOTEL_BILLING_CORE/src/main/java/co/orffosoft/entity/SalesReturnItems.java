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
@EqualsAndHashCode(callSuper = false, of = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "sales_return_items", uniqueConstraints = {
		@UniqueConstraint(name = "id", columnNames = "id")})
@ToString
@Getter
@Setter

public class SalesReturnItems implements Serializable {

	
	private static final long serialVersionUID = -8697432668165900774L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_return_items_id_seq")
	@SequenceGenerator(name = "sales_return_items_id_seq", sequenceName = "sales_return_items_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "sales_return_id")
	private Long sales_return_id;
	
	@Column(name = "sku_id")
	private Long sku_id;

	@Column(name = "item_qty")
	private Long item_qty;

	@Column(name = "selling_price")
	private Double selling_price;

	@Column(name = "purchase_price")
	private Double purchase_price;

	@Column(name = "discount_percentage")
	private Double discount_percentage;
	
	@Column(name = "discount_value")
	private Double discount_value;
	
	@Column(name = "cgst_percentage")
	private Double cgst_percentage;

	@Column(name = "cgst_value")
	private Double cgst_value;

	@Column(name = "sgst_percentage")
	private Double sgst_percentage;

	@Column(name = "sgst_value")
	private Double sgst_value;

	@Column(name = "net_amount")
	private Double net_amount;
	
	@Column(name = "created_by")
	private Long created_by;

	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "modified_by")
	private Long modified_by;

	@Column(name = "modified_date")
	private Date modified_date;
	
}
