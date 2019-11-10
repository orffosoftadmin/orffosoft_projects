package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

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
@Table(name = "file_movement_config", uniqueConstraints = @UniqueConstraint(name = "uk_filemvmntconfig_featureid_forwardlevel", columnNames = {
		"feature_id", "forward_level" }) )
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_file_movement_config_createdby") ),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_file_movement_config_modifiedby") ) })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class FileMovementConfig extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7850394690426970135L;

	@Id
	@SequenceGenerator(name = "file_movement_config_id_seq", sequenceName = "file_movement_config_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_movement_config_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "feature_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_file_movement_config_featureid") )
	private AppFeature appFeature;

	@Column(name = "forward_level")
	private Integer forwardLevel;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "section_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_file_movement_config_sectionid") )
//	private SectionMaster sectionMaster;
//
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "designation_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_file_movement_config_designationid") )
//	private Designation designation;

	@Column(name = "version")
	@Version
	private Long version;

}