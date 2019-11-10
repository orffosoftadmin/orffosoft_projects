package co.orffosoft.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of={"id"},callSuper=false)
@ToString
public class CustomerMasterDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	Long id;

	String name;

	String code;

	CustomerMasterDTO customerMaster;

	Date regDate;

	Date dateOfAnniv;

	String gstNumber;

	Boolean creditAllowed;

	Long maxInstallmentMonth;

	Long creditLimit;

	Boolean delayPaymentInterest;

	Double interestPercentage;

	Boolean returnAllowed;

	String accountNumber;

	String primaryContactName;

	String primaryContactNumber;

	String primaryLandPhoneNumber;

	String primaryEmail;

	String faxNumber;

	String secondaryContactName;

	String secondaryContactNumber;

	String secondaryLandPhoneNumber;

	String secondaryEmail;

	Boolean activeStatus;

	Date dateOfBirth;

	UserMasterDTO createdBy;

	Long modifiedBy;

	Date createdDate;

	Date modifiedDate;

	String aadharNumber;

	String spouseName;

	String fatherName;

	String occupation;

	Long version;

/*** Knt Registration Sync ***/
	
	String designation;
	
	String photoUrl;
	private Date registrationDate;
	private Boolean interestAlloewd;
	private String primaryFax;
	private String secondaryFax;
	private Long parentCustomerId;
	private String parentCustomerCode;
	private String parentCustomerName;
	private Long syncCode;
	
}
