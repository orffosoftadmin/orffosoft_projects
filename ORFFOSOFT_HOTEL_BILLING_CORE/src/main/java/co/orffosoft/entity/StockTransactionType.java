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
@EqualsAndHashCode(callSuper = false, of = "stock_tran_type_pk")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "stock_transaction_type")
@Getter
@Setter
public class StockTransactionType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_transaction_type_stock_tran_type_pk_seq")
	@SequenceGenerator(name = "stock_transaction_type_stock_tran_type_pk_seq", sequenceName = "stock_transaction_type_stock_tran_type_pk_seq")
	private Long stock_tran_type_pk;
	
	@Column(name = "stock_tran_type_code")
	private String stock_tran_type_code;
	
	@Column(name = "stock_tran_type_name")
	private String stock_tran_type_name;
	
	@Column(name = "stock_tran_type_description")
	private String stock_tran_type_description;
	
	@Column(name = "stock_tran_type_status")
	private Long stock_tran_type_status;
	
	@Column(name = "created_by")
	private Long created_by;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "modified_by")
	private Long modified_by;
	
	@Column(name = "modified_date")
	private Date modified_date;

}
