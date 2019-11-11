package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import co.orffosoft.dto.PaginationDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "app_config")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_app_config_createdby") ),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_app_config_modifiedby") ) })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class AppConfig extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6206213613551857395L;

	@Id
	@Column(name = "app_key")
	private String appKey;

	@Column(name = "app_value")
	private String appValue;

	@Column(name = "version")
	private Long version;

	@Transient
	private PaginationDTO paginationDTO;
	
	@Transient
	private Map<String, Object> filters;
}