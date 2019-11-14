package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
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

@Getter
@Setter
@Entity
@Table(name = "entity_master", uniqueConstraints = {
				@UniqueConstraint(columnNames = "code", name = "UQ_ENTITY_MASTER_CODE"),
				@UniqueConstraint(columnNames = "name", name = "UQ_ENTITY_MASTER_NAME") })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@EqualsAndHashCode(of = { "id" })
public class EntityMaster extends Trackable implements Serializable {

	private static final long serialVersionUID = -4344810836873889036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "code", columnDefinition = "varchar(50)", nullable = false)
	private String code;

	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ENTITY_MASTER_PARENTID"))
//	private EntityMaster entityMasterParent;

	@Column(name = "gst_number", nullable = false)
	private String gstNumber;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email_id")
	private String emailId;

	@Version
	@Column(name = "version")
	private Long version;

}
