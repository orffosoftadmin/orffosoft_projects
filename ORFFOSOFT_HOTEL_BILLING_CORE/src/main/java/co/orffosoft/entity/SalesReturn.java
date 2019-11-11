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
@Table(name = "sales_return", uniqueConstraints = {
		@UniqueConstraint(name = "id", columnNames = "id"),
		@UniqueConstraint(name = "bill_no", columnNames = "bill_no") })
@ToString
@Getter
@Setter
public class SalesReturn implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3212189960156721419L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_return_id_seq")
	@SequenceGenerator(name = "sales_return_id_seq", sequenceName = "sales_return_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "bill_h_fk")
	private Long bill_h_fk;
	
	@Column(name = "return_date")
	private Date return_date;

	@Column(name = "net_total")
	private Double net_total;
	
	@Column(name = "created_by")
	private Long created_by;

	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "modified_by")
	private Long modified_by;

	@Column(name = "modified_date")
	private Date modified_date;

	@Column(name = "bill_no")
	private String bill_no;
	
	@Column(name = "customer_fk")
	private Long customer_fk;


}
