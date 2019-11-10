package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "user_master", indexes = { @Index(name = "IDX_USER_MASTER_CREATEDDATE", columnList = "created_date"),
		@Index(name = "IDX_USER_MASTER_MODIFIEDDATE", columnList = "modified_date") }, uniqueConstraints = @UniqueConstraint(columnNames = {
				"username" }, name = "UQ_USER_MASTER_USERNAME"))
// @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EqualsAndHashCode(of = { "id" })
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "user_master_id_seq", sequenceName = "user_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "second_password")
	private String secondPassword;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JsonBackReference
	@Cascade({ CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "role_user", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_IDX_USERID")) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_IDX_ROLEID")) })
	List<RoleMaster> roleMaster;

//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ManyToMany
//	@JsonBackReference("region")
//	@Cascade({ CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinTable(name = "user_entity", joinColumns = {
//			@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_REGION_USERID")) }, inverseJoinColumns = {
//					@JoinColumn(name = "entity_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_userentity_entityid")) })
//	List<EntityMaster> region;

	@Column(name = "entity_id")
	private Long entityId;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "entity_id" , nullable = false)
//	private EntityMaster entityMaster;
	
	
	@Column(name = "version")
	@Version
	private Long userMasterVersion;

	private Boolean status;

	public Long createdBy;

	@Column(name = "created_date", nullable = true)
	public Date createdDate;

	public Long modifiedBy;

	@Column(name = "modified_date", nullable = true)
	public Date modifiedDate;

	@Column(name = "user_type")
	private String userType;

	public UserMaster(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	public UserMaster() {
	}

	
	@Transient
	String empName,empCode;
	
	@Transient
	Long empId;
	
	@Transient
	Long entityCode;
	
	@Transient
	String entityName;
	
}