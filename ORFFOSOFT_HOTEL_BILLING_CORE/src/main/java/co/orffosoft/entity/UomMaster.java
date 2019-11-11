package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "uom_master", indexes = { @Index(name = "IDX_UOM_MASTER_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_UOM_MASTER_MODIFIEDDATE", columnList = "modified_date") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_uom_master_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_uom_master_modifiedby")) })
@GenericGenerator(name = "uomMasterSeqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "uom_master_id_seq"),
		@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class UomMaster extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2623407166568999386L;

	@Id
	@GeneratedValue(generator = "uomMasterSeqGenerator")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "local_name")
	private String localName;

	@Column(name = "code")
	private String code;

	@Column(name = "active_status")
	private Boolean activeStatus;

	public UomMaster() {
	}

	public UomMaster(Long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

}