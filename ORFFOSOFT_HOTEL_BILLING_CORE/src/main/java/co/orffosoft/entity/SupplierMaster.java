/**
 * 
 */
package co.orffosoft.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.Trackable;
import co.orffosoft.dto.PaginationDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
// @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EqualsAndHashCode(callSuper = false, of = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "supplier_master", uniqueConstraints = {
		@UniqueConstraint(name = "uq_supplier_master_code", columnNames = "code"),
		@UniqueConstraint(name = "uq_supplier_master_name", columnNames = "name") })
@AssociationOverrides({
		@AssociationOverride(name = "created_by", joinColumns = @JoinColumn(name = "fk_supplier_master_createdby")),
		@AssociationOverride(name = "modified_by", joinColumns = @JoinColumn(name = "fk_supplier_master_modifiedby")) })
@ToString
@Getter
@Setter
public class SupplierMaster extends Trackable implements Serializable {

	private static final long serialVersionUID = -3772243515279792934L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_master_id_seq")
	@SequenceGenerator(name = "supplier_master_id_seq", sequenceName = "supplier_master_id_seq")
	@Column(name = "id", updatable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_parentid"))
	private SupplierMaster parent;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "business_type_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_businesstypeid"))
//	BusinessTypeMaster businessTypeMaster;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "supplier_type_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_typeid"))
//	SupplierTypeMaster supplierTypeMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "yarn_unit_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_yarn_unit_id"))
	EntityMaster entityMaster;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "l_name")
	private String localName;

	/*
	 * @JsonSerialize(using = JsonDateSerializer.class)
	 * 
	 * @JsonDeserialize(using = JsonDateDeserializer.class)
	 */
	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "gst_number")
	private String gstNumber;

	@Column(name = "credit_allowed")
	private Boolean creditAllowed;

	@Column(name = "max_installment_month")
	private Integer maxInstallmentMonth;

	@Column(name = "credit_limit")
	private Double creditLimit;

	@Column(name = "interest_percentage")
	private Double interestPercentage;

	@Column(name = "return_allowed")
	private Boolean returnAllowed;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "bank_id", columnDefinition = "id", foreignKey
	 * = @ForeignKey(name = "fk_supplier_master_bankid") ) BankMaster bankMaster;
	 */

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "primary_contact_name")
	private String primaryContactName;

	@Column(name = "primary_contact_number")
	private String primaryContactNumber;

	@Column(name = "primary_email")
	private String primaryEmail;

	@Column(name = "fax_number")
	private String faxNumber;

	@Column(name = "secondary_contact_name")
	private String secondaryContactName;

	@Column(name = "secondary_contact_number")
	private String secondaryContactNumber;

	@Column(name = "secondary_email")
	private String secondaryEmail;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "billing_address_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_billingaddressid"))
	AddressMaster addressMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_addressid"))
	AddressMaster addressId;

	@Column(name = "delay_payment_interest")
	private Boolean delayPaymentInterest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_userid"))
	private UserMaster userMaster;

	@Column(name = "version")
	@Version
	private Long version;

	@Column(name = "description")
	private String description;

	@Column(name = "loom_type")
	private String loomType;

	@Column(name = "dandp_code")
	private String dandpCode;

	@Column(name = "supplier_class")
	private String supplierClass;

	@Column(name = "supplier_grade")
	private String supplierGrade;

	@Column(name = "suppervisor_code")
	private String suppervisorCode;

	@Column(name = "supply_mode")
	private String supplyMode;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "bank_branch_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_bankid"))
//	BankBranchMaster branchMaster;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "circle_id", columnDefinition = "id", foreignKey = @ForeignKey(name = "fk_supplier_master_circleid"))
//	CircleMaster circleMaster;

	@Transient
	PaginationDTO paginationDTO;

	@Transient
	Map<String, Object> filters;

	@Transient
	private Double currentReqQty;

	@Transient
	private Double openingStockQty;

	// added BusinessDetails columns
	@Column(name = "registration_number")
	private String registrationNumber;

	@Column(name = "directors_name")
	private String directorsName;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "nationality_id")
//	private Nationality nationality;

	@Column(name = "tax_number")
	private String panNumber;

	@Column(name = "establishment_year")
	private Integer yearOfEstablishment;

	@Column(name = "natureof_business")
	private String natureOfBusiness;

	@Column(name = "legal_status")
	private String legalStatus;

	@Column(name = "company_category")
	private String companyCategory;

	@Column(name = "preregistered_with")
	private String preRegisteredWith;

	@Column(name = "aadhaar_number")
	private String aadharNumber;

	@Column(name = "social_category")
	private String socialCategory;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "differently_abled")
	private Boolean differentlyAbled;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "organization_type_id")
//	private OrganizationTypeMaster organizationTypeMaster;

	public SupplierMaster() {
		// TODO Auto-generated constructor stub
	}

	public SupplierMaster(Long id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public SupplierMaster(String code, String name) {
		this.code = code;
		this.name = name;
	}
	

	public SupplierMaster(Long id, String code, String name ,String gstNumber) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.gstNumber= gstNumber;
	}

	/*
	 * @Transient private Double totalQty;
	 */

}
