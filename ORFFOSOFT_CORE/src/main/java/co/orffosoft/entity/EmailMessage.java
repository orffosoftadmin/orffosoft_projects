package co.orffosoft.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "email_message", indexes = { @Index(name = "IDX_EMAIL_MESSAGE_MAILSUBJECT", columnList = "mail_subject"),
		@Index(name = "IDX_EMAIL_MESSAGE_TOADDRESS", columnList = "to_address") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_email_message_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_email_message_modifiedby")) })
@GenericGenerator(name = "emailMessageSeqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "email_message_id_seq"),
		@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class EmailMessage extends Trackable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6121423025960850505L;

	@Id
	@GeneratedValue(generator = "emailMessageSeqGenerator")
	@Column(name = "id", updatable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "config_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_email_message_configid"))
	private EmailConfig emailConfig;

	@Column(name = "mail_subject")
	private String mailSubject;

	@Column(name = "to_address")
	private String toAddress;

	@Column(name = "cc_address")
	private String ccAddress;

	@Column(name = "bcc_address")
	private String bccAddress;

	@Column(name = "mail_message")
	private String mailMessage;

	@Column(name = "content_type")
	private String contentType;

	@Column(name = "attachment_path")
	private String attachmentPath;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "mail_sent")
	private String mailSent;

	@Column(name = "important_mail")
	private String importantMail;

	@Column(name = "version")
	@Version
	private Long version;

}