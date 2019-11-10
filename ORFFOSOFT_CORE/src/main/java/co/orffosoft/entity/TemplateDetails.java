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
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import co.orffosoft.enums.TemplateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "template_details", indexes = {
		@Index(name = "idx_template_details_createddate", columnList = "created_date"),
		@Index(name = "idx_template_details_modifieddate", columnList = "modified_date") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_template_details_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_template_details_modifiedby")) })
public class TemplateDetails extends Trackable implements Serializable {

	private static final long serialVersionUID = -5080504206617911632L;

	@Id
	@SequenceGenerator(name = "template_details_id_seq", sequenceName = "template_details_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_details_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "template_type")
	private String templateType;

	@Column(name = "template_code")
	@Enumerated(EnumType.STRING)
	private TemplateCode templateCode;

	@Column(name = "description")
	private String description;

	@Column(name = "l_description")
	private String localDescription;

	@Column(name = "subject")
	private String subject;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "template_group")
	private String templateGroup;

}