package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "customer_master", indexes = {
		@Index(name = "IDX_CUSTOMER_MASTER_ACIVESTATUS", columnList = "acive_status"),
		@Index(name = "IDX_CUSTOMER_MASTER_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_CUSTOMER_MASTER_MODIFIEDDATE", columnList = "modified_date"),
		@Index(name = "IDX_CUSTOMER_MASTER_NAME", columnList = "name"),
		@Index(name = "IDX_CUSTOMER_MASTER_REGISTRATIONDATE", columnList = "registration_date") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_customer_master_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_customer_master_modifiedby")) })
@GenericGenerator(name = "customerMasterSeqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "customer_master_id_seq"),
		@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
public class CustomerMaster extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -425515053366522609L;

	@Id
	@GeneratedValue(generator = "customerMasterSeqGenerator")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;

	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "primary_contact_number")
	private String primaryContactNumber;
	
	@Column(name = "acive_status")
	private Boolean activeStatus;

	@Version
	@Column(name = "version")
	private Long version;

	@Column(name = "entity_id")
	private Long entityId;
	
	@Column(name = "sync_code")
	private Long syncCode;

	@Column(name = "sync_status")
	private Boolean syncStatus;
}
