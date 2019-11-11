package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import co.orffosoft.enums.ErrorMessageType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "error_master", indexes = { @Index(name = "IDX_ERROR_MASTER_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_ERROR_MASTER_MODIFIEDDATE", columnList = "modified_date") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_error_master_createdby") ),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_error_master_modifiedby") ) })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class ErrorMaster extends Trackable implements Serializable {

	/***
	 * 
	 */
	private static final long serialVersionUID = 4958933354139891338L;

	@Id
	@SequenceGenerator(name = "error_master_id_seq", sequenceName = "error_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "error_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "code")
	private Integer code;

	@Column(name = "language_code")
	private String languageCode;

	@Column(name = "description")
	private String description;

	@Column(name = "version")
	private Long version;

	@Column(name = "message_type")
	@Enumerated(EnumType.STRING)
	private ErrorMessageType messageType;

	public ErrorMaster() {

	}

	public ErrorMaster(Long id, Integer code, String languageCode, String description, Long version,
			ErrorMessageType messageType) {
		super();
		this.id = id;
		this.code = code;
		this.languageCode = languageCode;
		this.description = description;
		this.version = version;
		this.messageType = messageType;
	}

}