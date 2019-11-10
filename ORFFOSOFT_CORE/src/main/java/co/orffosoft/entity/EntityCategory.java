package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "entity_category", indexes = {
		@Index(name = "IDX_ENTITY_CATEGORY_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_ENTITY_CATEGORY_MODIFIEDDATE", columnList = "modified_date") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = "name", name = "UQ_ENTITY_CATEGORY_NAME"),
				@UniqueConstraint(columnNames = "code", name = "UQ_ENTITY_CATEGORY_CODE"),
				@UniqueConstraint(columnNames = "id", name = "UQ_ENTITY_CATEGORY_ID") })
@Data
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class EntityCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "entity_category_id_seq", sequenceName = "entity_category_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_category_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "code", columnDefinition = "varchar(50)", nullable = false)
	private String code;

	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;

	@Column(name = "l_name", columnDefinition = "varchar(150)")
	private String lname;

	@ManyToOne
	@JoinColumn(name = "created_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ENTITY_CATEGORY_CREATEDBY") )
	private UserMaster createdBy;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "modified_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ENTITY_CATEGORY_MODIFIEDBY") )
	private UserMaster modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@Version
	@Column(name = "version")
	private Long version;

}
