package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Table(name = "entity_type_master")
@AssociationOverrides({
	@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_entity_master_createdby")),
	@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_entity_master_modifiedby")) })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
public class EntityTypeMaster extends Trackable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_gen")
	@SequenceGenerator(name = "auto_gen", sequenceName = "entity_type_master_id_seq")
	Long id;

	@Column(name = "code")
	String entityCode;

	@Column(name = "name")
	String entityName;

	@Column(name = "l_name")
	String localName;

	@JoinColumn(name = "group_name", referencedColumnName = "name", foreignKey = @ForeignKey(name = "fk_entity_group_name"))
	String groupName;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@Version
	@Column(name = "version")
	private Long version;
}
