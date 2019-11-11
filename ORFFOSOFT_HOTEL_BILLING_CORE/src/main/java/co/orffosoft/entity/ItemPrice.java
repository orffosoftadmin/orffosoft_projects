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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper = false, of = "itemprice_pk")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "itemprice")
@Getter
@Setter
public class ItemPrice implements Serializable{

	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemprice_itemprice_pk_seq" )
	@SequenceGenerator(name = "itemprice_itemprice_pk_seq", sequenceName = "itemprice_itemprice_pk_seq" )
	private Long itemprice_pk;
	
	@Column(name = "itemprice_stock_tran_fk")
	private Long itemprice_stock_tran_fk;
	
	@Column(name = "itemprice_grn_h_fk")
	private Long itemprice_grn_h_fk;
	
	@Column(name = "itemprice_sku_fk")
	private Long itemprice_sku_fk;
	
	@Column(name = "itemprice_purchase_price")
	private Double itemprice_purchase_price;
	
	@Column(name = "itemprice_selling_price")
	private Double itemprice_selling_price;
	
	@Column(name = "itemprice_old_price")
	private Double itemprice_old_price;
	
	@Column(name = "itemprice_new_price")
	private Double itemprice_new_price;
	
	@Column(name = "itemprice_type")
	private String itemprice_type;
	
	@Column(name = "created_by")
	private Long created_by;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "modified_by")
	private Long modified_by;
	
	@Column(name = "modified_date")
	private Date modified_date;
	

}
