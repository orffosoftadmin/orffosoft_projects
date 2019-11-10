package co.orffosoft.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="role_master", indexes={
@Index(name="IDX_ROLE_MASTER_CREATEDDATE", columnList="created_date"),
@Index(name="IDX_ROLE_MASTER_MODIFIEDDATE", columnList="modified_date")},
uniqueConstraints = @UniqueConstraint(columnNames = {"role_name"},name="UQ_ROLE_MASTER_ROLENAME"))
@EqualsAndHashCode(callSuper = false,of = { "id" })
public class RoleMaster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "role_master_id_seq", sequenceName = "role_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;
		
	/**Name of the Role*/
	@Column(name = "role_name")
	private String roleName;
	
	/**Mapping table created for role and user.*/
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH})
	@JoinTable(name="role_feature", joinColumns={@JoinColumn(name="role_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ROLEMASTER_ROLEID"))}, inverseJoinColumns={@JoinColumn(name="feature_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ROLEMASTER_FEATUREID"))})
	private List<AppFeature> feature;
	
	/** active to check whether the role is active or not */
	@Column(name = "status")
	private Boolean status;
	
	@Version
	@Column(name = "version")
	private Long roleVersion;
	
	@OneToOne
	@JoinColumn(name = "application_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_ROLEMASTER_APPLICATION_ID"))
	private Application application;
	
	public Long createdBy;

	@Column(name = "created_date", nullable = true)
	public Date createdDate;

	
	public Long modifiedBy;
	
	@Transient
	public String createdByName;

	@Column(name = "modified_date", nullable = true)
	public Date modifiedDate;
	
	private transient List<Long> featList=new ArrayList<>();
	
}
