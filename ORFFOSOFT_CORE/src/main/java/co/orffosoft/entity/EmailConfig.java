package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import lombok.Data;

@Entity
@Data
@Table(name = "email_config", indexes = {
		@Index(name = "IDX_EMAIL_CONFIG_FROMMAILADDRESS", columnList = "from_mail_address"),
		@Index(name = "IDX_EMAIL_CONFIG_NAME", columnList = "name") })
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class EmailConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7282568605510233239L;

	@Id
	@SequenceGenerator(name = "email_config_id_seq", sequenceName = "email_config_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_config_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "host")
	private String host;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "from_mail_address")
	private String fromMailAddress;

	@Column(name = "from_alias")
	private String fromAlias;

	@Column(name = "port_number")
	private Long portNumber;

	@Column(name = "protocol")
	private String protocol;

	@Column(name = "code")
	private String code;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_email_config_createdby") )
	private UserMaster createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "modified_by", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_email_config_modifiedby") )
	private UserMaster modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "auth_required")
	private Boolean authRequired;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@Version
	@Column(name = "version")
	private Long version;
}
