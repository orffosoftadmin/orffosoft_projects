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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import co.orffosoft.core.util.Trackable;
import co.orffosoft.enums.SequenceName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "sequence_config", indexes = {
		@Index(name = "uq_sequence_config_name", columnList = "name") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = "name", name = "uq_sequence_config_name") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_sequence_config_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_sequence_config_modifiedby")) })
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
public class SequenceConfig extends Trackable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequence_config_id_seq", sequenceName = "sequence_config_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_config_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	SequenceName sequenceName;

	@Column(name = "description", length = 150)
	String description;

	@Column(name = "current_value", nullable = false)
	Long currentValue;

	@Column(name = "prefix", length = 10)
	String prefix;

	@Column(name = "suffix", length = 10)
	String suffix;

	@Column(name = "is_year_required", nullable = false, columnDefinition = "boolean default '0'")
	Boolean isYearRequired;

	@Column(name = "is_month_required", nullable = false, columnDefinition = "boolean default '0'")
	Boolean isMonthRequired;

	@Column(name = "separator", length = 1)
	String separator;

	@Column(name = "code_separator", length = 1)
	String codeSeparator;

	@Version
	@Column(name = "version")
	private Long version;
}
