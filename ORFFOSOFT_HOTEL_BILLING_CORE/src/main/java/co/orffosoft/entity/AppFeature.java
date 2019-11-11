package co.orffosoft.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "app_feature", indexes = {

		@Index(name = "IDX_FEATURE_NAME", columnList = "feature_name") }, uniqueConstraints = @UniqueConstraint(columnNames = {
				"feature_name" }, name = "UK_APPFEATURE_FEATURE_NAME") )

@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EqualsAndHashCode(callSuper = false, exclude = { "features" })
public class AppFeature extends Trackable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "app_feature_id_seq", sequenceName = "app_feature_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_feature_id_seq")
	@Column(name = "id", updatable = false)
	@Getter
	@Setter
	private Long id;

	@Column(name = "feature_name", nullable = false)
	@Getter
	@Setter
	private String featureName;

	@Column(name = "description", nullable = true)
	@Getter
	@Setter
	private String description;

	@Column(name = "style_class", nullable = true)
	@Getter
	@Setter
	private String pageName;

	/** The features. */

	@OneToMany(mappedBy = "parent")
	@Getter
	@Setter
	@JsonBackReference("features")
	private List<AppFeature> features; // Is the feature is parent or Child

	/** The parent. */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_APPFEATURE_PARENTID") )
	@Getter
	@Setter
	@JsonBackReference("parent")
	private AppFeature parent;

	@Column(name = "code", nullable = true)
	@Getter
	@Setter
	private String code;

//	@ManyToOne
//	@JoinColumn(name = "application_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_APPFEATURE_APPLICATION") )
//	@Getter
//	@Setter
//	private Application application;

	@Version
	@Column(name = "version")
	private Long appFeatureVersion;

	@Column(name = "action_key")
	@Getter
	@Setter
	private String actionKey;

	@Column(name = "has_file_movement")
	@Getter
	@Setter
	private Boolean hasFileMovement;

	@Column(name = "active_status")
	@Getter
	@Setter
	private Boolean activeStatus;

}
