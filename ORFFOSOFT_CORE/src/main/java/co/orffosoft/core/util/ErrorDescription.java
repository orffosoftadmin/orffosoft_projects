package co.orffosoft.core.util;

public class ErrorDescription {

	public static class Error {
		private Integer errorCode;

		public Integer getErrorCode() {
			return errorCode;
		}

		public Integer getCode() {
			return errorCode;
		}

		public Error(Integer errorCode) {
			this.errorCode = errorCode;
		}
	}

	public static final Error SUCCESS_RESPONSE = new Error(0);
	public static final Error FAILURE_RESPONSE = new Error(1);
	public static final Error APPLICATION_QUERY_NOT_FOUND = new Error(3);
	public static final Error INVALID_FILE_TYPE = new Error(9);
	public static final Error ERROR_EMPTY_LIST = new Error(8);
	public static final Error EMP_EDU_DETAILS_IS_EMPTY = new Error(2);
	public static final Error EMP_EDU_DURATION_IS_EMPTY = new Error(4);
	public static final Error EMP_EDU_PERCENTAGE_IS_EMPTY = new Error(5);
	public static final Error EMP_EDU_YEAR_OF_PASSING_IS_EMPTY = new Error(6);
	public static final Error EDU_QUALIFICATION_IS_EMPTY = new Error(7);
	public static final Error EMP_DETAILS_NOT_FOUND = new Error(10);

	public static final Error EDU_DETAILS_ID_NOT_FOUND = new Error(11);
	public static final Error EDU_DETAILS_INSTITUTE_NAME_NOT_NULL = new Error(12);
	public static final Error EDU_DETAILS_CERTIFICATION_NOT_NULL = new Error(13);
	public static final Error EDU_DETAILS_QUALIFICATION_NOT_NULL = new Error(14);

	public static final Error ACTIVITI_QUERY_NOT_FOUND = new Error(20);
	public static final Error TEMPLATE_DETAILS_NOT_FOUND = new Error(21);
	public static final Error TEMPLATE_DETAILS_CONTENT_NOT_FOUND = new Error(22);
	public static final Error LOGIN_EMPLOYEE_DETAILS_REQUIRED = new Error(23);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_PRODUCT_WAREHOUSE = new Error(24);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_DISTRIBUTION_WAREHOUSE = new Error(25);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_INSPECTION_CENTER = new Error(26);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_HEAD_OFFICE = new Error(27);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_ISSR = new Error(28);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_EW = new Error(29);
	public static final Error LOGIN_EMPLOYEE_LOCATION_IS_NOT_PW = new Error(30);

	public static final Error WARN_EMP_ENTITY_TYPE_EMPTY = new Error(8773);
	public static final Error EMPLOYEE_FIRSTNAME_LENGTH_MAX = new Error(3235);
	public static final Error EMPLOYEE_LOCALFIRSTNAME_LENGTH_MAX = new Error(3236);
	public static final Error EMPLOYEE_LASTTNAME_LENGTH_MAX = new Error(3267);
	public static final Error EMPLOYEE_LOCALLASTNAME_LENGTH_MAX = new Error(3237);

	public static final Error EMPLOYEE_FIRSTNAME_LENGTH_MIN = new Error(3238);
	public static final Error EMPLOYEE_LOCALFIRSTNAME_LENGTH_MIN = new Error(3239);
	public static final Error EMPLOYEE_LASTTNAME_LENGTH_MIN = new Error(3240);
	public static final Error EMPLOYEE_LOCALLASTNAME_LENGTH_MIN = new Error(3241);

	public static final Error EMPLOYEE_MIDDLETNAME_LENGTH_MAX = new Error(3242);
	public static final Error EMPLOYEE_LOCALMIDDLENAME_LENGTH_MAX = new Error(3243);
	public static final Error EMPLOYEE_MIDDLETNAME_LENGTH_MIN = new Error(3244);
	public static final Error EMPLOYEE_LOCALMIDDLENAME_LENGTH_MIN = new Error(3245);
	public static final Error EMPLOYEE_PFNUMBER_LENGTH_MAX = new Error(3246);
	public static final Error EMPLOYEE_FATHERNAME_LENGTH_MAX = new Error(3247);
	public static final Error EMPLOYEE_FATHERNAME_LENGTH_MIN = new Error(3248);
	public static final Error EMPLOYEE_LOCALFATHERNAME_LENGTH_MAX = new Error(3249);
	public static final Error EMPLOYEE_LOCALFATHERNAME_LENGTH_MIN = new Error(3250);
	public static final Error EMPLOYEE_SPOUSENAME_LENGTH_MAX = new Error(3251);
	public static final Error EMPLOYEE_SPOUSENAME_LENGTH_MIN = new Error(3252);
	public static final Error EMPLOYEE_LOCALSPOUSENAME_LENGTH_MAX = new Error(3253);
	public static final Error EMPLOYEE_LOCALSPOUSENAME_LENGTH_MIN = new Error(3254);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION1_LENGTH_MAX = new Error(3255);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION1_LENGTH_MIN = new Error(3256);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION2_LENGTH_MAX = new Error(3257);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION2_LENGTH_MIN = new Error(3258);
	public static final Error EMPLOYEE_PANNUMBER_LENGTH_MAX = new Error(3259);
	public static final Error EMPLOYEE_PANNUMBER_LENGTH_MIN = new Error(3260);

	public static final Error EMPLOYEE_AADHAR_LENGTH_MAX = new Error(3261);
	public static final Error EMPLOYEE_AADHAR_LENGTH_MIN = new Error(3262);

	public static final Error EMPLOYEE_PFNOMINEENAME_LENGTH_MAX = new Error(3261);
	public static final Error EMPLOYEE_PFNOMINEENAME_LENGTH_MIN = new Error(3262);
	public static final Error EMPLOYEE_ACCOUNTNUMBER_LENGTH_MAX = new Error(3263);
	public static final Error EMPLOYEE_ACCOUNTNUMBER_LENGTH_MIN = new Error(3264);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION1_IS_EXISTS = new Error(3265);
	public static final Error EMPLOYEE_AADHAR_IS_EXISTS = new Error(3280);
	public static final Error EMPLOYEE_BANKACCOUNT_NO_IS_EXISTS = new Error(3281);
	public static final Error EMPLOYEE_FATHER_OR_SPOUSE_NAME_REQUIRED = new Error(3266);

	public static final Error EMPLOYEE_RELIGION_REQUIRED = new Error(3270);
	public static final Error EMPLOYEE_COMMUNITY_REQUIRED = new Error(3271);

	public static final Error EMPLOYEE_PF_NUM_IS_EXISTS = new Error(3272);
	public static final Error EMPLOYEE_PAN_NUM_IS_EXISTS = new Error(3273);
	public static final Error EMPLOYEE_CODE_IS_EXISTS = new Error(3274);
	public static final Error EMPLOYEE_CODE_IS_EMPTY = new Error(3275);

	public static final Error EMPLOYEE_CASTE_REQUIRED = new Error(3276);
	public static final Error EMPLOYEE_PAN_NUM_REQUIRED = new Error(3277);
	public static final Error EMPLOYEE_AADHAR_REQUIRED = new Error(3278);
	public static final Error EMPLOYEE_INSURANCE_NUM_IS_EXISTS = new Error(3279);
	public static final Error EMPLOYEE_DELETED_SUCCESSFULLY = new Error(3282);
	public static final Error EMPLOYEE_UPDATED_SUCCESSFULLY = new Error(3283);

	public static final Error EMPLOYEE_CONTACTDETAILS_IS_EMPTY = new Error(6007);
	public static final Error PERMENENT_ADDRES_LINE_ONE_NOT_NULL = new Error(6008);
	public static final Error PRESENT_ADDRES_LINE_ONE_NOT_NULL = new Error(7089);
	public static final Error STATE_PERMENENT_NOT_NULL = new Error(7091);
	public static final Error STATE_PRESENT_NOT_NULL = new Error(7092);
	public static final Error DISTRICT_PERMENENT_NOT_NULL = new Error(7093);
	public static final Error DISTRICT_PRESENT_NOT_NULL = new Error(7094);
	public static final Error POSTAL_CODE_PERMENENT_NOT_NULL = new Error(7096);
	public static final Error POSTAL_CODE_PRESENT_NOT_NULL = new Error(7095);
	public static final Error PERSONAL_EMAIL_NOT_NULL = new Error(6023);
	public static final Error OFFICIAL_EMAIL_NOT_NULL = new Error(6024);
	public static final Error MOBILE_NUMBER_NOT_NULL = new Error(6025);
	public static final Error EMERGENCY_CONTACT_NUMBER_NOT_NULL = new Error(6026);
	public static final Error ADDRESS_REQUIRED = new Error(22075);
	public static final Error EDIT_ERROR = new Error(112);

	public static final Error PERMENENT_ADDRESS_LINE_ONE_REACH_MAXIMUM_LENGTH = new Error(6028);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_ONE_REACH_MAXIMUM_LENGTH = new Error(6029);
	public static final Error PERMENENT_ADDRESS_LINE_TWO_REACH_MAXIMUM_LENGTH = new Error(6030);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_TWO_REACH_MAXIMUM_LENGTH = new Error(6031);
	public static final Error PERMENENT_ADDRESS_LINE_THREE_REACH_MAXIMUM_LENGTH = new Error(6032);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_THREE_REACH_MAXIMUM_LENGTH = new Error(6033);
	public static final Error PRESENT_ADDRESS_LINE_ONE_REACH_MAXIMUM_LENGTH = new Error(6034);
	public static final Error LOCAL_PRESENT_ADDRESS_LINE_ONE_REACH_MAXIMUM_LENGTH = new Error(6035);
	public static final Error PRESENT_ADDRESS_LINE_TWO_REACH_MAXIMUM_LENGTH = new Error(6036);
	public static final Error LOCAL_PRESENT_ADDRESS_LINE_TWO_REACH_MAXIMUM_LENGTH = new Error(6037);
	public static final Error PRESENT_ADDRESS_LINE_THREE_REACH_MAXIMUM_LENGTH = new Error(6038);
	public static final Error LOCAL_PRESENT_ADDRESS_LINE_THREE_REACH_MAXIMUM_LENGTH = new Error(6039);
	public static final Error PERMENENT_POSTAL_CODE_REACH_MAXIMUM_LENGTH = new Error(6040);
	public static final Error PRESENT_POSTAL_CODE_REACH_MAXIMUM_LENGTH = new Error(6041);
	public static final Error PERMENENT_landmark_REACH_MAXIMUM_LENGTH = new Error(6042);
	public static final Error PRESENT_landmark_REACH_MAXIMUM_LENGTH = new Error(6043);
	public static final Error MOBILE_NUMBER_REACH_MAXIMUM_LENGTH = new Error(6044);
	public static final Error EMERGENCY_CONTACT_REACH_MAXIMUM_LENGTH = new Error(6045);
	public static final Error PERSONAL_EMAIL_REACH_MAXIMUM_LENGTH = new Error(6046);
	public static final Error OFFICIAL_EMAIL_REACH_MAXIMUM_LENGTH = new Error(6047);
	public static final Error LANDLINE_NUMBER_REACH_MAXIMUM_LENGTH = new Error(6048);
	public static final Error PERMENENT_ADDRESS_LINE_ONE_LENGTH_MINIMUM = new Error(6052);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_ONE_MINIMUM_LENGTH = new Error(6053);
	public static final Error PERMENENT_ADDRESS_LINE_TWO_LENGTH_MINIMUM = new Error(6054);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_TWO_LENGTH_MINIMUM = new Error(6055);
	public static final Error PERMENENT_ADDRESS_LINE_THREE_LENGTH_MINIMUM = new Error(6056);
	public static final Error LOCAL_PERMENENT_ADDRESS_LINE_THREE_LENGTH_MINIMUM = new Error(6057);
	public static final Error PERMENENT_LANDMARK_LENGTH_MINIMUM = new Error(6058);
	public static final Error PERMENENT_POSTAL_CODE_LENGTH_MINIMUM = new Error(6059);
	public static final Error PRESENT_ADDRESS_LINE_TWO_LENGTH_MINIMUM = new Error(6060);
	public static final Error LOCAL_PRESENT_ADDRESS_LINE_TWO_LENGTH_MINIMUM = new Error(6061);
	public static final Error PRESENT_ADDRESS_LINE_THREE_LENGTH_MINIMUM = new Error(6062);
	public static final Error LOCAL_PRESENT_ADDRESS_LINE_THREE_LENGTH_MINIMUM = new Error(6063);
	public static final Error PRESENT_LANDMARK_LENGTH_MINIMUM = new Error(6064);
	public static final Error PRESENT_POSTAL_CODE_REACH_LENGTH_MINIMUM = new Error(6065);
	public static final Error MOBILE_NUMBER_LENGTH_MINIMUM = new Error(6066);
	public static final Error EMERGENCY_CONTACT_LENGTH_MINIMUM = new Error(6067);
	public static final Error PERSONAL_EMAIL_LENGTH_MINIMUM = new Error(6068);
	public static final Error OFFICIAL_EMAIL_LENGTH_MINIMUM = new Error(6069);
	public static final Error LANDLINE_NUMBER_LENGHT_MINIMUM = new Error(6070);
	public static final Error CREATED_BY_NULL = new Error(5019);
	public static final Error CREATED_DATE_NULL = new Error(5020);
	public static final Error INVALID_EMERGENCY_CONTACT_NUMBER = new Error(6073);

	public static final Error EMPLOYEE_DEPENDENT_NAME = new Error(8804);
	public static final Error EMPLOYEE_DEPENDENT_MAX_MIN = new Error(8810);
	public static final Error EMPLOYEE_I_DEPENDENT_NAME = new Error(8805);
	public static final Error EMPLOYEE_I_DEPENDENT_MAX_MIN = new Error(8811);
	public static final Error EMPLOYEE_RELATIONSHIP = new Error(8806);
	public static final Error EMPLOYEE_FAMILY_DATE_OF_BIRTH_EMPTH = new Error(8807);
	public static final Error EMPLOYEE_GENDER_MASTER = new Error(8808);
	public static final Error EMPLOYEE_OCCUPATION_MASTER = new Error(8809);
	public static final Error EMP_FAMILY_DETAILS_IS_NOT_EXISTS = new Error(8912);
	public static final Error EMPLOYEE_IS_NULL = new Error(3201);
	public static final Error EMP_ID_EMPTY = new Error(11415);
	public static final Error EMP_NAME__EMPTY = new Error(11416);
	public static final Error EMP_CODE_EMPTY = new Error(11418);
	public static final Error EMP_TYPE_EMPTY = new Error(11419);
	public static final Error EMP_COMPANY_NAME_MIN_LENGTH = new Error(11420);
	public static final Error EMP_JOIN_DESIGNATION_MIN_LENGTH = new Error(11421);
	public static final Error EMP_REASON_LEAVING__MANDATORY = new Error(11422);
	public static final Error EMP_LAST_DRAWN_CTC_MANDATORY = new Error(11423);
	public static final Error EMP_JOIN_DATE_MANDATORY = new Error(11424);
	public static final Error EMP_RELIEVE_DATE_MANDATORY = new Error(11425);
	public static final Error EMP_LAST_DESIGNATION_MANDATORY = new Error(11426);
	public static final Error EMP_EXP_DETAILS_ALREADY_EXIST = new Error(11427);
	public static final Error EMP_EXPERIENCE_DETAILS_IS_EMPTY = new Error(11428);
	public static final Error EMP_EXPERIENCE_DETAILS_SAVED_SUCCESSFULLY = new Error(11429);
	public static final Error EMP_EXPERIENCE_DETAILS_UPDATED_SUCCESSFULLY = new Error(11430);
	public static final Error EMP_EXPERIENCE_DETAILS_DELETED_SUCCESSFULLY = new Error(11457);
	public static final Error EMP_EXPERIENCE_DETAILS_ATLEAST_ADD_ONE_RECORD = new Error(11453);
	public static final Error EMP_EXPERIENCE_DETAILS_COMPANY_MIN_MAX_LENGTH = new Error(11454);
	public static final Error EMP_EXPERIENCE_DETAILS_DESIGNATION_MIN_MAX_LENGTH = new Error(11455);
	public static final Error EMP_SUSPENSION_DETAILS_SUSP_REF_NUMBER_REQUIRED = new Error(11432);
	public static final Error EMP_SUSPENSION_DETAILS_SUSP_REF_DATE_REQUIRED = new Error(11433);
	public static final Error EMP_SUSPENSION_DETAILS_ENTITY_TYPE_REQUIRED = new Error(11434);
	public static final Error EMP_SUSPENSION_DETAILS_ENTITY_REQUIRED = new Error(11435);
	public static final Error EMP_SUSPENSION_DETAILS_REQUIRED = new Error(11436);
	public static final Error EMP_SUSPENSION_DETAILS_FROM_DATE_REQUIRED = new Error(11437);
	public static final Error EMP_SUSPENSION_DETAILS_SAVED_SUCCESSFULLY = new Error(11438);
	public static final Error EMP_SUSPENSION_DETAILS_UPDATED_SUCCESSFULLY = new Error(11439);
	public static final Error EMP_SUSPENSION_DETAILS_DELETED_SUCCESSFULLY = new Error(11440);
	public static final Error EMP_SUSPENSION_DETAILS_LIST_IS_EMPTY = new Error(11441);
	public static final Error EMP_SUSPENSION_DETAILS_IS_EMPTY = new Error(11442);
	public static final Error EMP_SUSPENSION_ENTITY_TYPE_NOT_SELECTED = new Error(11443);
	public static final Error EMP_SUSPENSION_REFERENCE_EXIST = new Error(112334);
	public static final Error EMP_SUSPENSION_REVISION_EXIST = new Error(112335);
	public static final Error EMP_SUSPENSION_REGULAR_EXIST = new Error(112336);
	public static final Error EMP_SUSPENSION_EXTENSION_EXIST = new Error(112337);
	public static final Error EXAM_CENTRE_EMPTY = new Error(11467);
	public static final Error EXAM_CENTRE_ALREADY_EXISTS = new Error(11465);
	public static final Error EXAM_CENTRE_NAME_EQUIRED = new Error(11468);
	public static final Error EXAM_CENTRE_CODE_EQUIRED = new Error(11463);
	public static final Error EXAM_CENTRE_ADDRESS_LINE1_EQUIRED = new Error(11469);
	public static final Error EXAM_CENTRE_STATE_EQUIRED = new Error(11470);
	public static final Error EXAM_CENTRE_DISTRICT_EQUIRED = new Error(11471);
	public static final Error EXAM_CENTRE_TALUK_EQUIRED = new Error(11472);
	public static final Error EXAM_CENTRE_VILLAGE_EQUIRED = new Error(11468);
	public static final Error EXAM_CENTRE_PINCODE_EQUIRED = new Error(11473);
	public static final Error EXAM_CENTRE_PRIMARY_CONTACT_NO_EQUIRED = new Error(11474);
	public static final Error EXAM_CENTRE_PRIMARY_EMAIL_EQUIRED = new Error(11475);
	public static final Error EXAM_CENTRE__PREFERED_REGION_EQUIRED = new Error(11472);
	public static final Error EXAM_CENTRE_COUNTRY_EQUIRED = new Error(11473);
	public static final Error EXAM_CENTRE_MOBILE_VALID = new Error(114505);

	public static final Error EXAM_CENTRE_APPROVED_SUCCESSFULLY = new Error(11460);
	public static final Error EXAM_CENTRE_REJECTED_SUCCESSFULLY = new Error(11461);
	public static final Error EXAM_CENTRE_DELETED_SUCCESSFULLY = new Error(11462);
	public static final Error EXAM_CENTRE_SAVED_SUCCESSFULLY = new Error(11463);
	public static final Error EXAM_CENTRE_UPDATED_SUCCESSFULLY = new Error(11464);
	public static final Error EXAM_CENTER_NOT_AVAILABLE = new Error(11479);
	public static final Error EXAM_CENTER_INSUFFICIENT_SEATS = new Error(11480);
	public static final Error EXAM_CENTRE_ALREADY_APPROVED = new Error(21502);
	public static final Error EXAM_CENTRE_ALREADY_REJECTED = new Error(21503);
	public static final Error EMP_INTERCHANGE_SAVED_SUCCESSFULLY = new Error(21504);
	public static final Error EMP_INTERCHANGE_UPDATED_SUCCESSFULLY = new Error(21504);
	public static final Error EMP_INTERCHANGE_REFERENCE_ALREADY_EXIST = new Error(21504);
	public static final Error EMP_INTERCHANGE_DEPARTMENT_REQUIRED = new Error(21504);
	public static final Error EMP_INTERCHANGE_DESIGNATION_REQUIRED = new Error(21505);
	public static final Error EMP_INTERCHANGE_REASON_REQUIRED = new Error(21506);
	public static final Error EMP_TRANSFER_REQUEST_EMPLOYEE_NOT_FOUND = new Error(24873);
	public static final Error EMP_TRANSFER_REQUEST_REGION_OFFICE_NOT_FOUND = new Error(24874);
	public static final Error EMP_LOAN_AND_ADVANCE_LOANAMOUNT_REQUIRED = new Error(24862);
	public static final Error EMP_LOAN_AND_ADVANCE_ADVANCEMOUNT_REQUIRED = new Error(24863);
	public static final Error EMP_LOAN_AND_ADVANCE_NO_OF_INSTALLMENTS_REQUIRED = new Error(24864);
	public static final Error EMP_LOAN_AND_ADVANCE_REASON_REQUIRED = new Error(24865);
	public static final Error EMP_LOAN_AND_ADVANCE_SAVED_SUCCESSFULLY = new Error(24866);
	public static final Error EMP_LOAN_AND_ADVANCE_UPDATED_SUCCESSFULLY = new Error(24867);
	public static final Error EMP_LOAN_AND_ADVANCE_ALREADY_EXIST = new Error(24871);
	public static final Error EMP_LOAN_AND_ADVANCE_DELETED_SUCCESSFULLY = new Error(24868);
	public static final Error EMP_LOAN_AND_ADVANCE_LOANTYPE_REQUIRED = new Error(24869);
	public static final Error EMP_LOAN_AND_ADVANCE_ADVANCETYPELOAN_REQUIRED = new Error(24870);
	public static final Error EMP_LOAN_AND_ADVANCE_NOT_ELIGIBLE = new Error(24861);
	public static final Error EMP_LOAN_AND_ADVANCE_USER_ID_EMPTY = new Error(24872);
	public static final Error JOB_APPLICATION_APPROVAL_EMPTY = new Error(11444);
	public static final Error JOB_APPLICATION_ID_REQUIRED = new Error(114482);
	public static final Error JOB_APPLICATION_APPROVAL_STATUS_REQUIRED = new Error(114483);
	public static final Error JOB_APPLICATION_APPROVAL_ALREADY_IS_EXISTS = new Error(114477);
	public static final Error JOB_APPLICATION_ALREADY_REJECTED = new Error(114478);
	public static final Error JOB_APPLICATION_APPROVAL_SAVED_SUCCESSFULLY = new Error(11448);
	public static final Error JOB_APPLICATION_APPROVAL_DELETED_SUCCESSFULLY = new Error(11449);
	public static final Error JOB_APPLICATION_APPROVAL_REASON_FOR_REJECTION_REQUIRED = new Error(114481);
	public static final Error JOB_APPLICATION_APPROVED = new Error(114479);
	public static final Error JOB_APPLICATION_REJECTED = new Error(114480);
	public static final Error JOB_APPLICATION_OBJECT_NOT_NULL = new Error(1144882);
	public static final Error JOB_APPLICATION_IMAGE_PATH_NOT_EXISTS = new Error(1144883);
	public static final Error JOB_APPLICATION_SALUTION_NOT_EXISTS = new Error(1144886);

	public static final Error ORAL_TEST_MARK_ALREADY_EXISTS = new Error(114498);
	public static final Error ORAL_TEST_MARK_ALREADY_REJECTED = new Error(114501);
	public static final Error ORAL_TEST_MARK_ALREADY_APPROVED = new Error(114500);
	public static final Error ORAL_TEST_MARK_SAVED_SUCCESSFULLY = new Error(114494);
	public static final Error ORAL_TEST_MARK_UPDATED_SUCCESSFULLY = new Error(114495);
	public static final Error ORAL_TEST_MARK_DELETED_SUCCESSFULLY = new Error(114497);
	public static final Error ORAL_TEST_MARK_GENERATED_SUCCESSFULLY = new Error(114496);
	public static final Error ORAL_TEST_MARK_LIST_IS_EMPTY = new Error(114499);
	public static final Error ORAL_TEST_MARK_APPROVED_SUCCESSFULLY = new Error(114502);
	public static final Error ORAL_TEST_MARK_REJECTED_SUCCESSFULLY = new Error(114503);
	public static final Error ORAL_TEST_MARK_CAN_NOT_DELETED = new Error(114504);

	public static final Error APPOINTMENT_ORDER_LIST_IS_EMPTY = new Error(22500);
	public static final Error APPOINTMENT_ORDER_NOT_NULL = new Error(22503);
	public static final Error APPOINTMENT_ORDER_ID_NOT_NULL = new Error(22504);
	public static final Error SELECT_APPOINTMENT_ORDER = new Error(22501);
	public static final Error APPROVED_APPOINTMENT_ORDER_CANNOT_DELETE = new Error(22502);
	public static final Error APPOINTMENT_ALREADY_GENERATED_FOR_APPLICATION = new Error(22505);
	public static final Error APPOINTMENT_ALREADY_GENERATED_FOR_REGISTRATION = new Error(22506);
	public static final Error APPOINTMENT_ALREADY_GENERATED = new Error(22507);
	public static final Error APPOINTMENT_ORDER_NOT_APPROVED = new Error(22508);
	public static final Error EMPLOYE_SERVICE_REGISSTER_ALREADY_CREATED = new Error(1144884);
	public static final Error EMP_APPOINTMENT_DATE_MANDATORY = new Error(11428);
	public static final Error EMP_RETIREMENT_DATE_MANDATORY = new Error(11548);
	public static final Error EMP_WORKLOCATION_MANDATORY = new Error(11430);
	public static final Error EMP_DESIGNATION_EMPTY = new Error(11431);

	public static final Error EDU_DETAILS_INSTITUTE_NAME_NOT_MORE_THAN_50 = new Error(8812);
	public static final Error EDU_DETAILS_REGISTER_NUM_NOT_MORE_THAN_10 = new Error(8813);
	public static final Error EDU_DETAILS_DOC_PATH_NOT_MORE_THAN_400 = new Error(8814);
	public static final Error EDU_DETAILS_REMARKS_NOT_MORE_THAN_400 = new Error(8815);

	public static final Error EDU_DETAILS_INSTITUTE_NAME_MIN_LENGTH = new Error(8816);
	public static final Error EDU_DETAILS_REGISTER_NUM_MIN_LENGTH = new Error(8817);
	public static final Error EDU_DETAILS_DOC_PATH_MIN_LENGTH = new Error(8818);
	public static final Error EDU_DETAILS_REMARKS_MIN_LENGTH = new Error(8819);
	public static final Error EDU_DETAILS_UNIVERSITY_NAME_NOT_NULL = new Error(8821);
	public static final Error EDU_DETAILS_REGISTER_NO_NOT_NULL = new Error(8822);
	public static final Error EDU_DETAILS_MONTH_OF_PASSING_NULL = new Error(8823);
	public static final Error EDU_DETAILS_YEAR_OF_PASSING_NOT_NULL = new Error(8824);
	public static final Error EDU_DETAILS_CERTIFICATE_VERIFIED_NOT_NULL = new Error(8825);
	public static final Error EDU_RGISTRATION_IS_EXISTS = new Error(8826);
	public static final Error EDU_DETAILS_PERCENTAGE_NOT_NULL = new Error(8827);
	public static final Error EDU_DETAILS_UNIVERSITY_NAME_MIN_LENGTH = new Error(8828);
	public static final Error EDU_DETAILS_UNIVERSITY_NAME_NOT_MORE_THAN_50 = new Error(8829);

	public static final Error EMP_LEAVE_REFFERENCE_NUMBER_MANDATORY = new Error(8830);
	public static final Error EMP_LEAVE_REFFERENCE_NUMBER_MAX_LENGTH = new Error(8831);
	public static final Error EMP_LEAVE_REFFERENCE_DATE_MANDATORY = new Error(8832);
	public static final Error EMP_LEAVE_FROM_DATE_MANDATORY = new Error(8833);
	public static final Error EMP_LEAVE_TO_DATE_MANDATORY = new Error(8834);
	public static final Error EMP_LEAVE_NO_OF_DAYS_MANDATORY = new Error(8835);
	public static final Error EMP_LEAVE_TYPE_MANDATORY = new Error(8836);
	public static final Error EMP_LEAVE_PROGRESSIVE_TOTAL_MANDATORY = new Error(8837);
	public static final Error EMP_DUTY_FROM_DATE_MANDATORY = new Error(8838);
	public static final Error EMP_DUTY_TO_DATE_MANDATORY = new Error(8839);
	public static final Error EMP_DUTY_NO_OF_DAYS_MANDATORY = new Error(8840);
	public static final Error EMP_EARNED_LEAVE_MANDATORY = new Error(8841);
	public static final Error EMP_CREDITED_LEAVE_MANDATORY = new Error(8842);
	public static final Error EMP_EARNED_LEAVE_BALANCE_MANDATORY = new Error(8843);
	public static final Error EMP_EARNED_LEAVE_TYPE_MANDATORY = new Error(8844);
	public static final Error EMP_LEAVE_DETAILS_LIST_EMPTY = new Error(8850);
	public static final Error EMP_LEAVE_REASON_MANDATORY = new Error(8851);
	public static final Error EMP_LEAVE_TYPE_CONCESSION_IS_EMPTY = new Error(8852);
	public static final Error TRAINING_TYPE_MANDATORY = new Error(88410);
	public static final Error INTERNAL_EXTERNAL_TYPE_MANDATORY = new Error(88411);
	public static final Error START_DATE_MANDATORY = new Error(88412);
	public static final Error END_DATE_MANDATORY = new Error(88413);
	public static final Error NO_OF_DAYS_MANDATORY = new Error(88414);
	public static final Error TRAINING_REASON_MANDATORY = new Error(88415);
	public static final Error LTC_BLOCK_YEAR_FROM_MANDATORY = new Error(8845);
	public static final Error LTC_BLOCK_YEAR_TO_MANDATORY = new Error(8846);
	public static final Error LTC_BLOCK_YEAR_FROM_DATE_MANDATORY = new Error(8847);
	public static final Error LTC_BLOCK_YEAR_TO_DATE_MANDATORY = new Error(8848);
	public static final Error LTC_BLOCK_NO_OF_DAYS_MANDATORY = new Error(8849);
	public static final Error RECORD_DELETED_SUCCESSFULLY = new Error(8856);

	public static final Error ROLE_EMPTY = new Error(1020);
	public static final Error ROLENAME_ALREADY_EXISTS = new Error(1021);
	public static final Error ROLE_ADDED_SUCCESSFULLY = new Error(1022);
	public static final Error ROLE_UPDATED_SUCCESSFULLY = new Error(1023);
	public static final Error ROLE_ID_REQUIRED = new Error(1024);
	public static final Error ROLE_LIST_RETRIEVED = new Error(1025);
	public static final Error ROLE_NAME_REQUIRED = new Error(1026);
	public static final Error LROLE_NAME_REQUIRED = new Error(1027);
	public static final Error ROLE_RETRIEVED_SUCCESSFULLY = new Error(1028);

	public static final Error USER_ADDED_SUCCESSFULLY = new Error(1010);
	public static final Error USER_EMPTY = new Error(1011);
	public static final Error USERNAME_ALREADY_EXISTS = new Error(1012);
	public static final Error CREATED_BY_REQUIRED = new Error(1013);
	public static final Error USERNAME_REQUIRED = new Error(1014);
	public static final Error PASSWORD_REQUIRED = new Error(1015);
	public static final Error USER_DOES_NOT_EXISTS = new Error(1016);
	public static final Error USER_UPDATED_SUCCESSFULLY = new Error(1017);
	public static final Error USER_RETRIEVED_SUCCESSFULLY = new Error(1018);
	public static final Error USER_DELETED = new Error(1019);
	public static final Error PASSWORD_MUST_BE_ALPHANUMERIC = new Error(1071);
	public static final Error MODIFIED_BY_REQUIRED = new Error(1035);
	public static final Error MODIFIED_DATE_REQUIRED = new Error(1042);
	public static final Error CREATED_DATE_REQUIRED = new Error(1039);
	public static final Error SAME_USER_UPDATE = new Error(1041);

	public static final Error FEATURE_LIST_RETRIEVED_SUCCESSFULLY = new Error(1060);
	public static final Error FEATURE_EMPTY = new Error(1061);
	public static final Error FEATURE_NAME_REQUIRED = new Error(1062);
	public static final Error APPLICATION_TYPE_REQUIRED = new Error(1063);
	public static final Error APPFEATURE_ADDED_SUCCESSFULLY = new Error(1064);
	public static final Error APPFEATURE_EMPTY = new Error(1065);
	public static final Error APPFEATURE_DOES_NOT_EXISTS = new Error(1066);
	public static final Error APPFEATURE_RETRIEVED_SUCCESSFULLY = new Error(1067);
	public static final Error APPFEATURE_DESCRIPTION_REQUIRED = new Error(1068);
	public static final Error APPFEATURE_ALREADY_EXISTS = new Error(1069);
	public static final Error APPFEATURE_UPDATED_SUCCESSFULLY = new Error(1070);

	public static final Error APPLICATION_EMPTY = new Error(1030);
	public static final Error APPLICATION_NAME_REQURIED = new Error(1031);
	public static final Error APPLICATION_NAME_ALREADY_EXISTS = new Error(1032);
	public static final Error APPLICATION_ADDED_SUCCESSFULLY = new Error(1033);
	public static final Error APPLICATION_NOT_EXISTS = new Error(1034);
	public static final Error APPLICATION_UPDATED_SUCCESSFULLY = new Error(1036);
	public static final Error APPLICATION_LIST_RETRIEVED = new Error(1037);
	public static final Error APPLICATION_RETRIEVED_SUCCESSFULLY = new Error(1038);

	public static final Error REGION_PROFILE_EMPTY = new Error(1051);
	public static final Error REGION_PROFILE_NOT_EXISTS = new Error(1050);
	public static final Error REGION_PROFILENAME_REQUIRED = new Error(1051);
	public static final Error REGION_PROFILE_ALREADY_EXISTS = new Error(1052);
	public static final Error REGION_PROFILE_ADDED_SUCCESSFULLY = new Error(1053);
	public static final Error DUPLICATE_REGION_PROFILENAME = new Error(1054);
	public static final Error REGION_PROFILE_UPDATED_SUCCESSFULLY = new Error(1053);
	public static final Error REGION_PROFILE_RETRIEVED_SUCCESSFULLY = new Error(1054);

	public static final Error UNAUTHORIZED_USER = new Error(1000);
	public static final Error LOGIN_VALIDTE = new Error(1002);
	public static final Error CANNOT_UPDATE_LOCKED_RECORD = new Error(1003);
	public static final Error CANNOT_UPDATE_DELETED_RECORD = new Error(1004);
	public static final Error CANNOT_DELETE_REFERENCED_RECORD = new Error(1005);
	public static final Error ERROR_COMMUNITY_NOTFOUND = new Error(1100);
	public static final Error ERROR_DEPARTMENT_NOTFOUND = new Error(1101);
	public static final Error ERROR_DESIGNATION_NOTFOUND = new Error(1102);
	public static final Error ERROR_NATIONALITY_NOTFOUND = new Error(1103);
	public static final Error ERROR_RELIGION_NOTFOUND = new Error(1104);
	public static final Error ERROR_APPOINTMENT_TYPE_NOTFOUND = new Error(1105);
	public static final Error ERROR_MARITAL_STATUS_NOTFOUND = new Error(1106);
	public static final Error ERROR_ACCOUNT_NUMBER = new Error(1107);
	public static final Error ERROR_EMERGENCY_CONTACT_NUMBER = new Error(1108);
	public static final Error ERROR_LANDLINE_NUMBER = new Error(1109);
	public static final Error ERROR_MOBILE_NUMBER = new Error(1110);
	public static final Error ERROR_OFFICIAL_MAIL = new Error(1111);
	public static final Error ERROR_PERSONAL_MAIL = new Error(1112);
	public static final Error ERROR_PF_NUMBER = new Error(1113);
	public static final Error ERROR_SPP_EXISTS = new Error(1114);
	public static final Error ERROR_GENERIC = new Error(1114);
	public static final Error ERROR_PRODUCT_CAREGORY_CODE = new Error(1115);
	public static final Error ERROR_PRODUCT_CAREGORY_NAME = new Error(1116);
	public static final Error ERROR_PRODUCT_CAREGORY_REGIONAL = new Error(1117);
	public static final Error ERROR_SOCIETY_MASTER_LIST = new Error(1117);
	public static final Error ERROR_ENTITY_MASTER_LIST = new Error(1118);
	public static final Error ERROR_ENTITY_NOTFOUND = new Error(1119);
	public static final Error ERROR_EMAILID_EXIST = new Error(1120);
	public static final Error MISSING_PARAMETER = new Error(1121);
	public static final Error INVALID_PARAMETER_FORMAT = new Error(1122);
	public static final Error ERROR_PRODUCT_GROUP_CODE = new Error(1124);
	public static final Error ERRO_PRODUCT_CATEGORY_REQ = new Error(23514);
	public static final Error ERROR_PRODUCT_GROUP_NAME = new Error(1125);
	public static final Error PRODUCT_GROUP_CODE_REQ = new Error(23513);
	public static final Error ERROR_PRODUCT_GROUP_REGIONAL = new Error(1126);
	public static final Error ERROR_PLAN_NAME_DUPLICATE = new Error(1127);
	public static final Error ERROR_KNT_ID_NOT_FOUND = new Error(1128);
	public static final Error ERROR_CATEGORY_CAN_NOT_DELETED = new Error(1128);
	public static final Error ERROR_DISCOUNT_DUPLICATE = new Error(1129);
	public static final Error ERROR_DISCOUNT_CODE_DUPLICATE = new Error(1130);
	public static final Error ERROR_SROOM_CATEGORY_CODE = new Error(1132);
	public static final Error PLAN_NAME_VALID_LENGTH = new Error(1133);
	public static final Error SELECT_ANY_ONE_PLAN = new Error(1134);
	public static final Error ERROR_USERID_INVALID = new Error(1135);
	public static final Error ERROR_INVALID_USER = new Error(1136);
	public static final Error ERROR_INACTIVE_USER = new Error(1148);
	public static final Error DISCOUNT_NAME_VALID_LENGTH = new Error(1137);
	public static final Error PRODUCT_CAT_CODE_REQ = new Error(1138);
	public static final Error PRODUCT_CAT_NAME_REQ = new Error(1139);
	public static final Error REGIONAL_NAME_REQ = new Error(1140);
	public static final Error ERROR_PM_ID_NOT_FOUND = new Error(1141);
	public static final Error ERROR_PM_NAME_DUPLICATE = new Error(1142);
	public static final Error PRIORITY_MASTER_UPDATE_SUCCESSFULLY = new Error(1143);
	public static final Error ERROR_PRIORITY_NAME = new Error(11411);
	public static final Error PRODUCT_CAT_REQ = new Error(1144);
	public static final Error REGION_REQ = new Error(1145);
	public static final Error TODATE_SHOULD_GREATER_THAN_FROMDATE = new Error(1146);
	public static final Error DISCOUNT_ALREADY_EXIST = new Error(1147);
	public static final Error INVALID_SHOWROOM_CATEGORY = new Error(4000);
	public static final Error INVALID_REGION = new Error(4001);
	public static final Error INVALID_SHOWROOM_TYPE = new Error(4002);
	public static final Error INVALID_SHOWROOM_INCHARGE_TYPE = new Error(4003);
	public static final Error INVALID_WAREHOUSE_TYPE = new Error(4004);
	public static final Error INVALID_WAREHOUSE_NAME_TYPE = new Error(4005);
	public static final Error INVALID_ENTITY_TYPE = new Error(4006);
	public static final Error INVALID_EMPLOYEE_TYPE = new Error(4006);
	public static final Error MOBILE_NUMBER_EXIST = new Error(4007);
	public static final Error ERROR_EMAIL_EXIST = new Error(4008);
	public static final Error CATEGORY_NAME_VALID_LENGTH = new Error(4009);
	public static final Error PRODUCT_CATEGORY_NOT_FOUND = new Error(4010);
	public static final Error SELECT_ANY_SHOWROOM = new Error(4011);
	public static final Error INVALID_SHOWROOM_ADDRESS = new Error(4012);
	public static final Error ENTER_ATLEAST_ONE_DETAIL = new Error(4013);
	public static final Error ERROR_UPDATE_PRODUCT_CATEGORY = new Error(4014);
	public static final Error CATEGORY_LOCAL_NAME_VALID_LENGTH = new Error(4015);
	public static final Error PRODUCT_GROUP_NOT_FOUND = new Error(4016);
	public static final Error GRPUP_NAME_VALID_LENGTH = new Error(4017);
	public static final Error GROUP_LOCAL_NAME_VALID_LENGTH = new Error(4018);
	public static final Error INVALID_SHOWROOM_NAME = new Error(4026);
	public static final Error INVALID_SHOWROOM_CODE = new Error(4019);
	public static final Error INVALID_GST_NUM = new Error(4020);
	public static final Error INVALID_PRIMOB_NUM = new Error(4021);
	public static final Error INVALID_SECMOB_NUM = new Error(4022);
	public static final Error INAVALID_EMAIL = new Error(4023);
	public static final Error EXIST_CON_NUM = new Error(40201);
	public static final Error EXIST_LAND_PHONE_NUM = new Error(40202);
	public static final Error EXIST_EMAIL_ID = new Error(40203);
	public static final Error EXIST_FAX_NUM = new Error(40204);
	public static final Error ERROR_CON_NAME = new Error(40254);
	public static final Error ERROR_CON_NUM = new Error(40255);
	public static final Error ERROR_LAND_PHONE_NUM = new Error(40256);
	public static final Error ERROR_EMAIL_ID = new Error(40257);
	public static final Error ADD_SHOWROOM_ADDRESS = new Error(4024);
	public static final Error ERROR_PRIORITY_CODE_DUPLICATE = new Error(4025);
	public static final Error ERROR_PRIORITY_NAME_DUPLICATE = new Error(40261);
	public static final Error ERROR_ENTITY_CODE_DUPLICATE = new Error(4028);
	public static final Error ERROR_ENTITY_NAME_DUPLICATE = new Error(4029);
	public static final Error ERROR_ENTITY_ID_DUPLICATE = new Error(4030);
	public static final Error ENTITY_MATSER_UPDATED = new Error(4031);
	public static final Error INVALID_INPUT = new Error(4032);
	public static final Error INAVALID_PRIMARY_EMAIL = new Error(4033);
	public static final Error INAVALID_SECONDARY_EMAIL = new Error(4034);
	public static final Error INAVALID_SUPPORT_EMAIL = new Error(4035);
	public static final Error SELECT_ANY_OFFICEDETAILS = new Error(4036);
	public static final Error INAVALID_PRIMARY_FAX_NUM = new Error(4037);
	public static final Error INAVALID_SECONDARY_FAX_NUM = new Error(4038);
	public static final Error INAVALID_SUPPORT_FAX_NUM = new Error(4039);
	public static final Error INVALID_PHONE_NUM = new Error(4040);
	public static final Error INVALID_POSTAL_CODE = new Error(4041);
	public static final Error INVALID_SUPPMOB_NUM = new Error(4042);
	public static final Error ERROR_OFFICE_MASTER_ID_NOT_FOUND = new Error(4043);
	public static final Error ERROR_OFFICE_ADDRESS_ID_NOT_FOUND = new Error(4044);
	public static final Error OFFICE_MASTER_SAVED = new Error(4045);
	public static final Error OFFICE_MASTER_UPDATED = new Error(4046);
	public static final Error OFFICE_ADDRESS = new Error(4047);
	public static final Error INVALID_OFFICE_NAME = new Error(40401);
	public static final Error ERROR_BUSINESS_TYPE = new Error(5000);
	public static final Error ERROR_CUSTOMER_TYPE = new Error(5001);
	public static final Error ERROR_ORG_NAME = new Error(5002);
	public static final Error ERROR_ADD_CUSTOMER_BILLING_ADDRESS = new Error(5003);
	public static final Error ERROR_PRI_CON_NAME = new Error(5004);
	public static final Error ERROR_PRI_CON_NUM = new Error(5005);
	public static final Error ERROR_PRI_LAND_CON_NUM = new Error(50051);
	public static final Error ERROR_SEC_LAND_CON_NUM = new Error(50052);
	public static final Error ERROR_PRI_EMAIL = new Error(5006);
	public static final Error ERROR_SEC_CON_NAME = new Error(5007);
	public static final Error ERROR_SEC_CON_NUM = new Error(5008);
	public static final Error ERROR_SEC_EMAIL = new Error(5009);
	public static final Error ERROR_SELECT_ANY_ONE_ORG = new Error(5010);
	public static final Error ERROR_OFFICE_CONTACT_DETAILS_NOT_FOUND = new Error(5011);
	public static final Error ERROR_RECORDS_NOT_FOUND = new Error(5012);
	public static final Error ERROR_PRODUCT_VARIETY_CODE = new Error(5013);
	public static final Error SELECT_ANY_PRODUCT_VARIETY = new Error(5014);
	public static final Error PRODUCT_VARIETY_NOT_FOUND = new Error(5015);
	public static final Error ERROR_PRODUCT_VARIETY_NAME = new Error(5016);
	public static final Error ERROR_PRODUCT_VARIETY_LOCAL_NAME = new Error(5017);
	public static final Error ERROR_FAX_NUMBER = new Error(5018);
	public static final Error ERROR_ACC_NUMBER = new Error(5019);
	public static final Error PRODUCT_CODE_VALID_LENGTH = new Error(5020);
	public static final Error PRODUCT_NAME_VALID_LENGTH = new Error(5021);
	public static final Error PRODUCT_LOCAL_NAME_VALID_LENGTH = new Error(5022);
	public static final Error CALCULATE_TOLARANCE_VALUE = new Error(5023);
	public static final Error ERROR_PARENT_ORG = new Error(5024);
	public static final Error ERROR_BANK = new Error(5025);
	public static final Error ERROR_CONTACT_DUPLICATE = new Error(5026);
	public static final Error ERROR_SECONDARY_CONTACT_DUPLICATE = new Error(5027);
	public static final Error ERROR_SUPPORT_CONTACT_DUPLICATE = new Error(5028);
	public static final Error ERROR_EMAIL_DUPLICATE = new Error(5029);
	public static final Error ERROR_SECONDARY_EMAIL_DUPLICATE = new Error(5030);
	public static final Error ERROR_SUPPORT_EMAIL_DUPLICATE = new Error(5031);
	public static final Error EXIST_PRI_CON_NUM = new Error(5032);
	public static final Error EXIST_SEC_CON_NUM = new Error(5033);
	public static final Error EXIST_PRI_EMAILID = new Error(5034);
	public static final Error EXIST_SEC_EMAILID = new Error(5035);
	public static final Error EXIST_GST_NUM = new Error(5036);
	public static final Error ERROR_FAX_DUPLICATE = new Error(5037);
	public static final Error ERROR_SECONDARY_FAX_DUPLICATE = new Error(5038);
	public static final Error ERROR_SUPPORT_FAX_DUPLICATE = new Error(5039);
	public static final Error ERROR_ACC_NUM_EXIST = new Error(5040);
	public static final Error CONATCT_NUM_REQ = new Error(5041);
	public static final Error ERROR_KNT_MIN_MAX_AMOUNT = new Error(6001);
	public static final Error ERROR_SHOWROOM_CODE_EXIST = new Error(6002);
	public static final Error ERROR_SHOWROOM_NAME_EXIST = new Error(60021);
	public static final Error ERROR_OFFICE_NAME_EXIST = new Error(60022);
	public static final Error ERROR_CUSTOMER_MASTER_NAME_EXIST = new Error(6003);
	public static final Error ERROR_DISCOUNT_LOCAL_NAME_DUPLICATE = new Error(7001);
	public static final Error DISCOUNT_LOCAL_NAME_VALID_LENGTH = new Error(7002);
	public static final Error CALCULATE_LENGTH_TOLARANCE_VALUE = new Error(7003);
	public static final Error CALCULATE_WIDTH_TOLARANCE_VALUE = new Error(7004);
	public static final Error CALCULATE_PICK_PER_TOLARANCE_VALUE = new Error(7005);
	public static final Error CALCULATE_END_PER_TOLARANCE_VALUE = new Error(7006);
	public static final Error ERROR_ENTITY_LOCAL_NAME_DUPLICATE = new Error(8001);
	public static final Error ENTITY_TYPE_CODE_VALID_LENGTH = new Error(8002);
	public static final Error ENTITY_TYPE_NAME_VALID_LENGTH = new Error(8003);
	public static final Error ENTITY_TYPE_LNAME_VALID_LENGTH = new Error(8004);

	public static final Error ERROR_RELIGION_CODE_VALID_LENGTH = new Error(7007);
	public static final Error ERROR_RELIGION_NAME_VALID_LENGTH = new Error(7008);
	public static final Error ERROR_RELIGION_LOCAL_NAME_VALID_LENGTH = new Error(7009);
	public static final Error ERROR_RELIGION_CODE = new Error(7010);
	public static final Error ERROR_RELIGION_NAME = new Error(7011);
	public static final Error ERROR_RELIGION_REGIONAL = new Error(7012);
	public static final Error ERROR_RELIGION_ID_NOT_FOUND = new Error(7073);
	public static final Error SELECT_ANY_RELIGION_DETAILS = new Error(7014);
	public static final Error ERROR_RELIGION_STATUS_VALIDATION = new Error(7030);
	public static final Error SALES_TYPE_MASTER_SAVED_SUCCESSFULLY = new Error(7015);
	public static final Error SALES_TYPE_MASTER_DELETED_SUCCESSFULLY = new Error(7026);
	public static final Error SALES_TYPE_MASTER_UPDATE_SUCCESSFULLY = new Error(7016);
	public static final Error SALES_TYPE_MASTER_CODE_VALID_LENGTH = new Error(7017);
	public static final Error SALES_TYPE_MASTER_NAME_VALID_LENGTH = new Error(7018);
	public static final Error SALES_TYPE_MASTER_LNAME_VALID_LENGTH = new Error(7019);
	public static final Error ERROR_SALES_TYPE_CODE = new Error(7020);
	public static final Error ERROR_SALES_TYPE_NAME = new Error(7021);
	public static final Error ERROR_SALES_TYPE_LOCAL_NAME = new Error(7022);
	public static final Error SALES_TYPE_CODE_REQUIRED = new Error(7023);
	public static final Error SALES_TYPE_NAME_REQUIRED = new Error(7024);
	public static final Error SALES_TYPE_LOCAL_NAME_REQUIRED = new Error(7025);

	public static final Error CASTE_TYPE_MASTER_LNAME_VALID_LENGTH = new Error(7100);
	public static final Error CASTE_TYPE_CODE_DUPLICATED = new Error(7101);
	public static final Error CASTE_TYPE_NAME_DUPLICATED = new Error(7102);
	public static final Error CASTE_TYPE_LNAME_DUPLICATED = new Error(7103);
	public static final Error CASTE_TYPE_MASTER_SAVED_SUCCESSFULLY = new Error(7104);
	public static final Error CASTE_TYPE_MASTER_UPDATE_SUCCESSFULLY = new Error(7105);
	public static final Error CASTE_TYPE_MASTER_CODE_VALID_LENGTH = new Error(7106);
	public static final Error CASTE_TYPE_MASTER_NAME_VALID_LENGTH = new Error(7107);

	public static final Error SOCIETY_CLASS_CODE_VALID_LENGTH = new Error(9001);
	public static final Error SOCIETY_CLASS_NAME_VALID_LENGTH = new Error(9002);
	public static final Error SOCIETY_CLASS_LNAME_VALID_LENGTH = new Error(9003);
	public static final Error SOCIETY_CLASS_MIN_TURN_OVER = new Error(9004);
	public static final Error SOCIETY_CLASS_MAX_TURN_OVER = new Error(9005);
	public static final Error ERROR_SOCIETY_CLASS_MIN_MAX_VALIDATION = new Error(9006);
	public static final Error ERROR_SOCIETY_CLASS_CODE_DUPLICATE = new Error(9007);
	public static final Error ERROR_SOCIETY_CLASS_NAME_DUPLICATE = new Error(9008);
	public static final Error ERROR_SOCIETY_CLASS_LNAME_DUPLICATE = new Error(9009);
	public static final Error SELECT_ANY_SOCIETY_CLASS = new Error(9010);
	public static final Error SOCIETY_CLASS_IS_EMPTY = new Error(9011);
	public static final Error SOCIETY_CLASS_CODE_NOT_NULL = new Error(9012);
	public static final Error SOCIETY_CLASS_NAME_NOT_NULL = new Error(9013);
	public static final Error SOCIETY_CLASS_LNAME_NOT_NULL = new Error(9014);
	public static final Error SOCIETY_CLASS_MINTURN_NOT_NULL = new Error(9015);
	public static final Error SOCIETY_CLASS_MAXTURN_NOT_NULL = new Error(9016);
	public static final Error ERROR_SOCIETY_CLASS = new Error(9017);
	public static final Error SELECT_ANY_PRODUCT_CATEGORY = new Error(4441);
	public static final Error EXIST_FDS_PRODUCT = new Error(3100);
	public static final Error SELECT_ANY_PRODUCT_GROUP = new Error(4442);
	public static final Error ERROR_MENU_MASTER_CODE = new Error(4443);
	public static final Error ERROR_MENU_MASTER_NAME = new Error(4444);
	public static final Error ERROR_MENU_MASTER_LNAME = new Error(4445);
	public static final Error ERROR_MENU_FILE_FATH = new Error(4446);
	public static final Error SELECT_ANY_MENU = new Error(4447);
	public static final Error EMPLOYEE_IS_EMPTY = new Error(3201);
	public static final Error EMPLOYEE_FIRST_NAME_NOT_NULL = new Error(3202);
	public static final Error EMPLOYEE_LAST_NAME_NOT_NULL = new Error(3203);
	public static final Error EMPLOYEE_DOB_NOT_NULL = new Error(3204);
	public static final Error EMPLOYEE_GENDER_NOT_NULL = new Error(3205);
	public static final Error EMPLOYEE_HEIGHT_NOT_NULL = new Error(3206);
	public static final Error EMPLOYEE_WEIGHT_NOT_NULL = new Error(3207);
	public static final Error EMPLOYEE_BLOODGROUP_NOT_NULL = new Error(3208);
	public static final Error EMPLOYEE_MARITAL_STATUS_NOT_NULL = new Error(3209);
	public static final Error EMPLOYEE_SPOUSE_NAME_NOT_NULL = new Error(3210);
	public static final Error EMPLOYEE_FATHER_NAME_NOT_NULL = new Error(3211);
	public static final Error EMPLOYEE_MOBILENO_NOT_NULL = new Error(3212);
	public static final Error EMPLOYEE_NATIONALITY_NOT_NULL = new Error(3213);
	public static final Error EMPLOYEE_RELIGION_NOT_NULL = new Error(3214);
	public static final Error EMPLOYEE_COMMUNITY_NOT_NULL = new Error(3215);
	public static final Error EMPLOYEE_PERIDENT1_NOT_NULL = new Error(3216);
	public static final Error EMPLOYEE_EMERGENCY_NO_NOT_NULL = new Error(3217);
	public static final Error EMPLOYEE_PERSONAL_EMAIL_NOT_NULL = new Error(3218);
	public static final Error EMPLOYEE_REGISTRATION_CREATE_SUCCESS = new Error(3219);
	public static final Error EMPLOYEE_REGISTRATION_UPDATE_SUCCESS = new Error(3220);
	public static final Error EMPLOYEE_SEARCH_DATA_EMPTY = new Error(3221);
	public static final Error EMPLOYEE_SELECT_ANY_ONE = new Error(3222);
	public static final Error EMPLOYEE_AGE_INVALID = new Error(3223);
	public static final Error EMPLOYEE_AGE_ZERO = new Error(3224);
	public static final Error EMPLOYEE_PHOTO_SIZE = new Error(3225);
	public static final Error EMPLOYEE_PHOTO_FORMAT = new Error(3226);
	public static final Error EMPLOYEE_PHOTO_NOT_NULL = new Error(3227);
	public static final Error EMPLOYEE_PERSONAL_EMAIL_INVALID = new Error(3228);
	public static final Error EMPLOYEE_OFFICIAL_EMAIL_INVALID = new Error(3229);
	public static final Error EMPLOYEE_MOBILE_INVALID = new Error(3230);
	public static final Error EMPLOYEE_EMERGENCY_CONTACT_NO_INVALID = new Error(3231);
	public static final Error EMPLOYEE_PERCENTAGE_MARKS_INVALID = new Error(3232);
	public static final Error EMPLOYEE_TYPE_NOT_NULL = new Error(3233);
	public static final Error EMPLOYEE_CODE_NOT_NULL = new Error(3234);
	public static final Error EMPLOYEE_LOCAL_FIRST_NAME_NOT_NULL = new Error(3235);
	public static final Error EMPLOYEE_LOCAL_LAST_NAME_NOT_NULL = new Error(3236);
	public static final Error EMPLOYEE_PERSONALIDENTIFICATION1_NOT_NULL = new Error(3237);
	public static final Error BLOOD_GROUP_LNAME = new Error(11417);
	public static final Error ERROR_BLOOD_GROUP_NAME_DUPLICATE = new Error(11413);
	public static final Error ERROR_BLOOD_GROUP_LNAME_DUPLICATE = new Error(11414);
	public static final Error ERROR_BG_ID_NOT_FOUND = new Error(1143);
	public static final Error ERROR_BG_NAME_DUPLICATE = new Error(11445);
	public static final Error ERROR_BG_LNAME_DUPLICATE = new Error(11456);
	public static final Error BLOOD_GROUP_MASTER_UPDATE_SUCCESSFULLY = new Error(11466);
	public static final Error SELECT_ANY_ONE_BLOODGROUP = new Error(112333);
	public static final Error ERROR_BLOOD_STATUS_VALIDATION = new Error(1241);
	public static final Error BLOOD_GROUP_MASTER_DELETED_SUCCESSFULLY = new Error(12422);
	public static final Error BLOOD_GROUP_MASTER_ALREADYUSING = new Error(12423);
	public static final Error ERROR_LOOM_CODE_VALID_LENGTH = new Error(1234);
	public static final Error ERROR_LOOM_NAME_VALID_LENGTH = new Error(1235);
	public static final Error ERROR_LOOM_LOCAL_NAME_VALID_LENGTH = new Error(1236);
	public static final Error ERROR_LOOM_CODE_DUPLICATE = new Error(1237);
	public static final Error ERROR_LOOM_NAME_DUPLICATE = new Error(1238);
	public static final Error ERROR_LOOM_LOCALNAME_DUPLICATE = new Error(1239);
	public static final Error SELECT_ANY_LOOM_DETAILS = new Error(1240);
	public static final Error ERROR_LOOM_STATUS_VALIDATION = new Error(11211);
	public static final Error PRODUCT_CAT_NOT_FOUND = new Error(2100);
	//
	public static final Error CIRCLE_NOT_FOUND = new Error(2103);
	public static final Error FDS_PLAN_NOT_FOUND = new Error(2104);
	public static final Error THIS_RECORD_ALREADY_USED = new Error(2105);
	public static final Error ERROR_LEAVE_CODE_VALID_LENGTH = new Error(1634);
	public static final Error ERROR_LEAVE_NAME_VALID_LENGTH = new Error(1635);
	public static final Error ERROR_LEAVE_LOCAL_NAME_VALID_LENGTH = new Error(1636);
	public static final Error ERROR_LEAVE_CODE_DUPLICATE = new Error(1637);
	public static final Error ERROR_LEAVE_NAME_DUPLICATE = new Error(1638);
	public static final Error ERROR_LEAVE_LOCALNAME_DUPLICATE = new Error(1639);
	public static final Error SELECT_ANY_LEAVE_DETAILS = new Error(1640);
	public static final Error ERROR_MASTER_CODE_VALID_LENGTH = new Error(9106);
	public static final Error ERROR_MASTER_NAME_VALID_LENGTH = new Error(9107);
	public static final Error ERROR_LEAVE_STATUS_VALIDATION = new Error(1641);

	public static final Error INFO_GOVT_DIST_TALUK_ADDED = new Error(3900);
	public static final Error INFO_GOVT_DIST_TALUK_UPDATED = new Error(3901);

	public static final Error INFO_GOVT_DIST_TALUK_DELETE = new Error(3902);

	public static final Error EXIST_SCHEME_TYPE = new Error(9200);
	public static final Error DISTTALUKWISE_IS_EMPTY = new Error(9210);
	public static final Error DISTTALUKWISE_SCHEMETYPE_NOT_NULL = new Error(9211);
	public static final Error DISTTALUKWISE_PRODUCTIONPLAN_NOT_NULL = new Error(9212);
	public static final Error DISTTALUKWISE_FROM_DATE_NOT_NULL = new Error(9213);
	public static final Error DISTTALUKWISE_TO_DATE_NOT_NULL = new Error(9214);
	public static final Error DISTTALUKWISE_DISTRICTMASTER_NOT_NULL = new Error(9215);
	public static final Error DISTTALUKWISE_TALUKMASTER_NOT_NULL = new Error(9216);
	public static final Error DISTTALUKWISE_PRODUCTCAT_NOT_NULL = new Error(9217);
	public static final Error DISTTALUKWISE_PRODUCTGROUP_NOT_NULL = new Error(9217);
	public static final Error DISTTALUKWISE_PRODUCTQTY_NOT_NULL = new Error(9217);
	public static final Error SELECT_ANY_GOVTDISTTALUK = new Error(9218);

	public static final Error ERROR_DISTTALUKWISE_CODE_DUPLICATE = new Error(9219);

	public static final Error RETAILINPUTFORM_IS_EMPTY = new Error(9600);
	public static final Error ERROR_ENITYMASTER_NOT_FOUND = new Error(9601);
	public static final Error PLAN_NUMBER_NOT_NULL = new Error(9222);
	public static final Error SEVEN_DIGIT_NUMBER_VALID_LENGTH = new Error(9223);
	public static final Error ERROR_RETAIL_INPUTFORM_PREPAREDBY_NOT_FOUND = new Error(9613);
	public static final Error ERROR_RETAIL_PLAN_ALREADY_EXIST = new Error(9614);
	public static final Error ERROR_RETAIL_INPUT_FORM_TO_YEAR_VALID_LENGTH = new Error(9615);
	public static final Error ERROR_RETAIL_INPUT_FORM_TO_MONTHNOT_NULL = new Error(9616);
	public static final Error ERROR_RETAIL_INPUT_FORM_TO_MONTH_VALID_LENGTH = new Error(9617);
	public static final Error ERROR_RETAIL_INPUT_FORM_FROM_YEAR_VALID_LENGTH = new Error(9618);
	public static final Error ERROR_RETAIL_INPUT_FORM_FROM_MONTH_VALID_LENGTH = new Error(9619);
	public static final Error ERROR_RETAIL_INPUT_FORM_PHASE_NUMBER_VALID_LENGTH = new Error(3907);
	public static final Error ERROR_RETAIL_INPUT_FORM_PHASE_NUMBER_NOT_NULL = new Error(3908);
	public static final Error ERROR_RETAIL_INPUT_FORM_FROM_MONTH_NOT_NULL = new Error(3909);
	public static final Error ERROR_RETAIL_INPUT_FORM_FROM_YEAR_NOT_NULL = new Error(3910);
	public static final Error ERROR_RETAIL_INPUT_FORM_TO_YEAR_NOT_NULL = new Error(3911);
	public static final Error ERROR_RETAIL_INPUT_FORM_ALREADY_EXIST = new Error(3912);
	public static final Error PHASE_NUMBER_EXIST = new Error(3913);
	public static final Error FROM_YEAR_EXIST = new Error(3914);
	public static final Error TO_YEAR_EXIST = new Error(3915);
	public static final Error RETAIL_INPUT_FORM_PLAN_NUMBER_EXIST = new Error(3916);
	public static final Error NO_RECORD_FOUND = new Error(3917);
	public static final Error CREATED_BY_EMPTY = new Error(3918);
	public static final Error CREATED_DATE_EMPTY = new Error(3919);
	public static final Error STATUS_EMPTY = new Error(3920);
	public static final Error NO_VALUES_FOR_GIVEN_VALUES = new Error(3921);
	public static final Error QUERY_NOT_FOUND = new Error(3922);

	public static final Error PROCUREMENT_ORDER_PLAN_REQUIRED = new Error(3923);
	public static final Error PROCUREMENT_ORDER_PRODUCING_REGION_REQUIRED = new Error(3924);
	public static final Error PROCUREMENT_ORDER_CATEGORY_REQUIRED = new Error(3925);
	public static final Error PROCUREMENT_ORDER_PROCUREMENT_FROM_REQUIRED = new Error(3942);
	public static final Error PROCUREMENT_ORDER_PROCUREMENT_TO_REQUIRED = new Error(3943);
	public static final Error PROCUREMENT_PLAN_CODE_NOT_CONFIGURED = new Error(4106);
	public static final Error PROCUREMENT_ORDER_SELECT_ONE_RECORD = new Error(4111);
	public static final Error PROCUREMENT_ORDER_CANNOT_EDIT_RECORD = new Error(4112);
	public static final Error PROCUREMENT_ORDER_APPROVED = new Error(4113);
	public static final Error PROCUREMENT_ORDER_REJECTED = new Error(4114);
	public static final Error PROCUREMENT_ORDER_FINALIZED = new Error(4115);
	public static final Error PROCUREMENT_ORDER_FROM_DATE_REQUIRED = new Error(4116);
	public static final Error PROCUREMENT_ORDER_TO_DATE_REQUIRED = new Error(4117);
	public static final Error PROCUREMENT_ORDER_STATUS_REQUIRED = new Error(4118);
	public static final Error PROCUREMENT_ORDER_DETAILS_REQUIRED = new Error(4119);
	public static final Error PROCUREMENT_ORDER_CANNOT_DELETE = new Error(4120);
	public static final Error PROCUREMENT_ORDER_VALID_DATE_NOT_LATER_THAN = new Error(4122);
	public static final Error ERROR_REGIONWISE_ITEMQTY_ITEMVALUE_LIST_EMPTY = new Error(3926);
	public static final Error ERROR_ENTITY_MASTER_LIST_NOT_FOUND = new Error(3927);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_LIST_NOT_FOUND = new Error(3928);
	public static final Error ERROR_PRODUCING_REGION_LIST_NOT_FOUND = new Error(3929);
	public static final Error ERROR_CATEGORYWISE_ITEMQTY_ITEMVALUE_LIST_EMPTY = new Error(3930);
	public static final Error ERROR_QTY_AND_VALUES_ARE_NULL = new Error(3931);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_REQ_OBJ_NOT_FOUND = new Error(3932);
	public static final Error ERROR_FROM_MONTH_EMPTY = new Error(3933);
	public static final Error ERROR_TO_MONTH_EMPTY = new Error(3934);
	public static final Error ERROR_TO_YEAR_EMPTY = new Error(3935);
	public static final Error ERROR_FROM_YEAR_EMPTY = new Error(3936);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_ID_NULL = new Error(3937);
	public static final Error ERROR_RETAIL_INPUT_FORM_LIST_NOT_FOUND = new Error(3938);
	public static final Error ERROR_REGION_ID_NOT_FOUND = new Error(3939);
	public static final Error RETAIL_INPUT_FORM_SUBMITTED = new Error(3940);
	public static final Error NO_RESULT_FOR_QUERY = new Error(3941);
	public static final Error PROCUREMENT_ORDER_ALREDY_EXIST_FOR_PLAN = new Error(3944);

	public static final Error DANDP_ID_EMPTY = new Error(4900);
	public static final Error ERROR_CATEGORYWISE_QTY_VALUE_LIST_EMPTY = new Error(4901);
	public static final Error ERROR_DANDP_ID_EMPTY = new Error(4902);
	public static final Error ERROR_CATEGORY_ID_EMPTY = new Error(4903);
	public static final Error ERROR_RETAIL_PROCUREMENT_ORDER_REQUEST_NULL = new Error(4094);
	public static final Error ERROR_RETAIL_PROCUREMENT_ORDER_ID_EMPTY = new Error(4095);
	public static final Error INFO_RETAIL_PROCUREMNET_ORDER_DELETED_SUCCESSFULLY = new Error(4096);
	public static final Error SELECT_ATLEAST_ONE_RECORD = new Error(4097);
	public static final Error ERROR_RETAIL_PROCUREMNET_ORDER_CANNOT_BE_DELETED = new Error(4098);
	public static final Error RETAIL_PROCUREMENT_ORDER_EMPTY = new Error(4099);
	public static final Error RETAIL_PROCUREMENT_ORDER_SUBMITTED_SUCCESSFULLY = new Error(4100);
	public static final Error ERROR_PLAN_NUMBER_VALID_LENGTH = new Error(4101);
	public static final Error ERROR_RETAIL_PROCUREMENT_ORDER_ALREADY_EXITS = new Error(4102);
	public static final Error ERROR_PLAN_NUMBER_ALREADY_EXITS = new Error(4103);
	public static final Error ERROR_PRODCUT_CATEGORY_NULL = new Error(4104);
	public static final Error ERROR_RETAIL_PROCUREMENT_ORDER_REQUEST_EMPTY = new Error(4105);
	public static final Error ERROR_PROCUREMENT_ORDER_CREATED_FOR_PLAN = new Error(4107);
	public static final Error PLAN_ID_NULL = new Error(4108);
	public static final Error ERROR_PRODUCING_REGION_NOT_FOUND = new Error(4109);
	public static final Error ITEM_VALUE_EMPTY = new Error(4110);
	public static final Error RETAIL_PROCUREMENT_ORDER_SAVED_SUCCESSFULLY = new Error(4121);
	public static final Error RETAIL_PRODUCTION_PLAN_NOT_NULL = new Error(8500);
	public static final Error RETAIL_PRODUCTION_PLAN_NAME_NOT_NULL = new Error(8501);
	public static final Error RETAIL_PRODUCTION_PLAN_FROM_NOT_NULL = new Error(8502);
	public static final Error RETAIL_PRODUCTION_PLAN_TO_NOT_NULL = new Error(8503);
	public static final Error RETAIL_PRODUCTION_SALES_FROM_NOT_NULL = new Error(8504);
	public static final Error RETAIL_PRODUCTION_SALES_TO_NOT_NULL = new Error(8505);
	public static final Error RETAIL_PRODUCTION_PLAN_CODE_INVALID = new Error(8506);
	public static final Error RETAIL_PRODUCTION_PLAN_NAME_INVALID_LENGTH = new Error(8507);
	public static final Error RETAIL_PRODUCTION_PLAN_REGIONLIST_NOT_NULL = new Error(8508);
	public static final Error RETAIL_PRODUCTION_PLAN_PRODUCTLIST_NOT_NULL = new Error(8509);
	public static final Error RETAIL_PRODUCTION_PERCENTAGE_NOT_NULL = new Error(8510);
	public static final Error RETAIL_PRODUCTION_DUE_DATE_NOT_NULL = new Error(8511);
	public static final Error RETAIL_PRODUCTION_PERCENTAGE_INVALID = new Error(8512);
	public static final Error RETAIL_PRODUCTION_SALES_FROMDATE_LESS_THAN_TODATE = new Error(8513);
	public static final Error RETAIL_PRODUCTION_PLAN_FROMDATE_LESS_THAN_TODATE = new Error(8514);
	public static final Error RETAIL_PRODUCTION_PLAN_DUEDATE_LESS_THAN_TODAYDATE = new Error(8515);
	public static final Error RETAIL_PRODUCTION_PLAN_TEMPLATE_NOT_FOUND = new Error(8516);
	public static final Error RETAIL_PRODUCTION_PLAN_CANNOT_BE_MODIFIED = new Error(8517);
	public static final Error RETAIL_PRODUCTION_PLAN_DUPLICATE_RETAIL_PRODUCTION_PLAN_CODE = new Error(8518);
	public static final Error RETAIL_PRODUCTION_PLAN_EMPTY_REGION_WISE_SALES_DATA = new Error(8519);
	public static final Error RETAIL_PRODUCTION_PLAN_LIST_EMPTY = new Error(8520);
	public static final Error RETAIL_PRODUCTION_PLAN_ID_EMPTY = new Error(8521);
	public static final Error RETAIL_PRODUCTION_PLAN_FROM_PLAN_TO_VALID = new Error(8522);
	public static final Error RETAIL_PRODUCTION_PLAN_FROM_PLAN_TO_MONTH_RANGE = new Error(8523);
	public static final Error RETAIL_PRODUCTION_PLAN_SAVE_SUCCESS = new Error(8524);
	public static final Error RETAIL_PRODUCTION_PLAN_SELECT_ONE_PLAN = new Error(8525);
	public static final Error RETAIL_PRODUCTION_PLAN_NAME_INVALID = new Error(8526);
	public static final Error RETAIL_PRODUCTION_PLAN_BASE_STOCK_PERCENTAGE_INVALID = new Error(8527);
	public static final Error RETAIL_PRODUCTION_PLAN_UPDATED = new Error(8528);
	public static final Error RETAIL_PRODUCTION_PLAN_DUE_DATE_SHOULD_NOT_PAST_DATE = new Error(8529);
	public static final Error RETAIL_PRODUCTION_PLAN_APPROVED = new Error(8530);
	public static final Error RETAIL_PRODUCTION_PLAN_REJECTED = new Error(8531);
	public static final Error RETAIL_PRODUCTION_PLAN_CANCELLED = new Error(8532);
	public static final Error RETAIL_PRODUCTION_PLAN_ELIGIBLE_PERCENTAGE_DIFFERENCE = new Error(8533);
	public static final Error RETAIL_PRODUCTION_PLAN_DRAFT_SUBMITTED = new Error(8534);
	public static final Error RETAIL_PRODUCTION_PLAN_DELETED = new Error(8535);
	public static final Error RETAIL_PRODUCTION_PLAN_CANNOT_EDIT = new Error(8536);
	public static final Error RETAIL_PRODUCTION_PLAN_SHOWROOM_MARGIN = new Error(8537);
	public static final Error RETAIL_PRODUCTION_PLAN_RO_MARGIN = new Error(8538);
	public static final Error RETAIL_PRODUCTION_PLAN_FINAL_MARGIN = new Error(8539);
	public static final Error RETAIL_PRODUCTION_PLAN_MONTHLY_PROCUREMENT_NOT_APPROVED = new Error(8540);
	public static final Error ERROR_SELECT_ONE_REGION = new Error(8541);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_ID_NOT_NULL = new Error(8542);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_REGION_WISE_IS_EMPTY = new Error(8543);
	public static final Error RETAIL_PRODUCTION_PLAN_DRAFT_PDF_FORMAT_TEMPLATE_NOT_FOUND = new Error(8544);
	public static final Error RETAIL_PRODUCTION_PLAN_SUBMIT_SUCCESS = new Error(8545);

	public static final Error RETAIL_SOCIETY_PLAN_EMPTY = new Error(7938);
	public static final Error RETAIL_SOCIETY_PRODUCTION_PLAN_EMPTY = new Error(7939);
	public static final Error RETAIL_PROD_PLAN_ID_ERROR = new Error(7940);
	public static final Error PRODUCT_GROUP_EMPTY = new Error(7941);
	public static final Error PRODUCT_CATEGORY_EMPTY = new Error(7942);
	public static final Error PRODUCT_VARIETY_EMPTY = new Error(7943);
	public static final Error RETAIL_SOCIETY_FROM_MONTH_EMPTY = new Error(7944);
	public static final Error RETAIL_SOCIETY_FROM_YEAR_EMPTY = new Error(7945);
	public static final Error RETAIL_SOCIETY_TO_MONTH_EMPTY = new Error(7946);
	public static final Error RETAIL_SOCIETY_TO_YEAR_EMPTY = new Error(7947);
	public static final Error RETAIL_SOCIETY_PLAN_DETAILS_EMPTY = new Error(7948);
	public static final Error RETAIL_SOCIETY_ENTITY_MASTER_EMPTY = new Error(7949);
	public static final Error MONTH_NAME_LENGTH_MISMATCH = new Error(7950);
	public static final Error PRODUCT_VARIETY_DUPLICATED = new Error(7951);
	public static final Error RETAIL_SOCIETY_PLAN_FROM_MONTH_DUPLICATE = new Error(7952);
	public static final Error RETAIL_SOCIETY_PLAN_TO_MONTH_DUPLICATE = new Error(7953);
	public static final Error RETAIL_SOCIETY_PLAN_FROM_YEAR_DUPLICATE = new Error(7954);
	public static final Error RETAIL_SOCIETY_PLAN_TO_YEAR_DUPLICATE = new Error(7955);
	public static final Error FROM_MONTH_GREATER = new Error(8801);
	public static final Error MONTH_NUMBER_EXCEEDS = new Error(8802);
	public static final Error FROM_YEAR_GREATER = new Error(8803);
	public static final Error ERROR_RETAIL_SOCIETY_PRODUCTION_PLAN_TEMPLATE_NOT_FOUND = new Error(8804);
	public static final Error REGION_NOT_FOUND = new Error(8805);
	public static final Error PRODUCT_VARIETY_MISMATCH = new Error(8806);
	public static final Error SOCIETY_WISE_PLAN_AMOUNT_EXEEDS = new Error(8807);
	public static final Error USER_GROUP_NOT_FOUND_RETAIL_SOCIETY_PLAN = new Error(8808);
	public static final Error NOTIFICATION_OBJECT_FOUND_NULL = new Error(8809);
	public static final Error PLAN_ALREADY_EXISTS = new Error(8810);
	public static final Error RETAIL_PRODUCTION_PLAN_NOT_ACTIVE = new Error(8811);
	public static final Error PRODUCT_VARIETY_NOT_ACTIVE = new Error(8812);
	public static final Error ERROR_RETAIL_SOCIETY_PLAN_NOT_FOUND = new Error(8813);
	public static final Error ERROR_PROD_VARIETY_NOT_FOUND = new Error(8814);
	public static final Error ERROR_PROD_CATEGORY_NOT_FOUND = new Error(8815);
	public static final Error ERROR_PRODUCT_QUANDITY_NULL = new Error(8816);
	public static final Error ERROR_PRODUCT_VALUE_NULL = new Error(8817);
	public static final Error ERROR_PRODUCT_QUANDITY_VALUE_NULL = new Error(8818);
	public static final Error ERROR_VALUE_BASED_ON_PRODUCT = new Error(8819);
	public static final Error SOCIETY_PLAN_APPLICATION_QUERY_NOT_FOUND = new Error(8820);
	public static final Error SOCIETY_PLAN_UPDATED_SUCCESSFULLY = new Error(8823);
	public static final Error CANNOT_EDIT_PLAN = new Error(8825);

	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_DUPLICATE = new Error(7957);
	public static final Error ERROR_INVALID_MONTH_WISE_PROC_PRCNT = new Error(7958);
	public static final Error ERROR_INVALID_MONTH_WISE_PROC_VALUE = new Error(7959);
	public static final Error ERROR_EMPTY_MONTH_WISE_PROC_PRCNT = new Error(7960);
	public static final Error ERROR_EMPTY_MONTH_WISE_PROC_VALUE = new Error(7961);
	public static final Error ERROR_RETAIL_PRODUCTION_PLAN_NOT_FOUND = new Error(7962);
	public static final Error ERROR_EMPTY_RETAIL_MONTHWISE_PROC = new Error(7963);
	public static final Error ERROR_EMPTY_RETAIL_MONTHWISE_PROC_LIST = new Error(7964);
	public static final Error ERROR_MONTHWISE_PROC_PLAN_NOT_FOUND = new Error(7965);
	public static final Error ERROR_REATIL_PRODUCTION_PALN_NOT_APPROVED = new Error(7966);
	public static final Error ERROR_DUPLICATE_PLAN_AND_MONTH = new Error(7967);
	public static final Error ERROR_INVALID_COUNT_FOR_UPDATE = new Error(7968);
	public static final Error INFO_RETAIL_MONTHWISE_PROCUREMNET_ADDED_SUCCESSFULLY = new Error(7969);
	public static final Error INFO_RETAIL_MONTHWISE_PROCUREMNET_UPDATED_SUCCESSFULLY = new Error(7970);
	public static final Error INFO_RETAIL_MONTHWISE_PROCUREMNET_DELETED_SUCCESSFULLY = new Error(7973);
	public static final Error RETAIL_MONTHWISE_PROCUREMNET_REJECTED = new Error(7971);
	public static final Error RETAIL_MONTHWISE_PROCUREMNET_APPROVED = new Error(7972);
	public static final Error RETAIL_MONTHWISE_PROCUREMNET_SUBMITTED = new Error(7974);
	public static final Error INFO_RETAIL_MONTHWISE_PROCUREMNET_CANNOT_DELETED = new Error(7975);
	public static final Error INFO_RETAIL_MONTHWISE_PROCUREMNET_CANNOT_VIEWD = new Error(7976);
	public static final Error INFO_RETAIL_MONTHWISE_ALREADY_SUBMITTED = new Error(7977);

	public static final Error SEQUENCE_CONFIG_NOT_EXIST = new Error(105);
	public static final Error STOCK_TRANS_SEARCH_REQUEST_DTO_REQUIRED = new Error(9900);
	public static final Error STOCK_TRANS_SELECT_ONE_RECORD = new Error(9901);
	public static final Error STOCK_TRANS_DELETED_SUCCESSFULLY = new Error(9902);
	public static final Error STOCK_TRANS_SAVED_SUCCESSFULLY = new Error(9903);
	public static final Error STOCK_TRANS_DNP_REQUIRED = new Error(9904);
	public static final Error STOCK_TRANS_SHIPPING_TO_REQUIRED = new Error(9905);
	public static final Error STOCK_TRANS_PO_REQUIRED = new Error(9906);
	public static final Error STOCK_TRANS_CANNOT_BE_EDITTED = new Error(9907);
	public static final Error STOCK_TRANS_SUPPLIER_REQUIRED = new Error(9908);
	public static final Error STOCK_TRANS_CURRENT_DISPATCH_MORE = new Error(9909);
	public static final Error STOCK_TRANS_CURRENT_DISPATCH_NEGATIVE = new Error(9910);
	public static final Error STOCK_TRANS_CURRENT_QUANTITY_NEGATIVE = new Error(9911);
	public static final Error STOCK_TRANS_CURRENT_QUANTITY_EXCEEDS = new Error(9912);
	public static final Error STOCK_TRANS_REFERENCE_NUMBER_DUPLICATED = new Error(9913);
	public static final Error STOCK_TRANS_AT_NUMBER_DUPLICATED = new Error(9914);
	public static final Error STOCK_TRANSFER_SUPPLIER_MANDATORY = new Error(9915);
	public static final Error STOCK_TRANSFER_STATUS_MANDATORY = new Error(9916);
	public static final Error STOCK_TRANSFER_TYPE_MANDATORY = new Error(9917);
	public static final Error STOCK_TRANSFER_PRODUCT_NOT_FOUND_FOR_ATNUMBER = new Error(9918);
	public static final Error STOCK_TRANSFER_ATNUMBER_NOT_FOUND_IN_INWARD = new Error(9919);
	public static final Error STOCK_TRANSFER_PRODUCT_WAREHOUSE_REQUIRED = new Error(9920);
	public static final Error STOCK_TRANSFER_STOCK_NOT_AVAILABLE = new Error(9921);
	public static final Error STOCK_TRANSFER_STOCK_ITEMS_REQUIRED = new Error(9922);
	public static final Error STOCK_TRANSFER_QR_CODE_DUPLICATED = new Error(9923);
	public static final Error STOCK_TRANSFER_QR_CODE_INVALID = new Error(9924);
	public static final Error STOCK_TRANSFER_DISTRIBUTION_WAREHOUSE_REQUIRED = new Error(9925);
	public static final Error STOCK_TRANSFER_DISPATCH_MORE_THAN_AVAILABLILITY = new Error(9926);
	public static final Error STOCK_TRANSFER_DISPATCH_ZERO = new Error(9927);
	public static final Error STOCK_TRANSFER_PRODUCT_PRICE_NOT_FOUND = new Error(9928);

	public static final Error COUNTRY_EMPTY = new Error(1070);
	public static final Error COUNTRY_MASTER_SHOULD_NOT_BE_NULL = new Error(114552);
	public static final Error COUNTRY_MASTER_ID_SHOULD_NOT_BE_NULL = new Error(114553);
	public static final Error COUNTRY_MASTER_NAME_SHOULD_NOT_BE_NULL = new Error(114554);
	public static final Error COUNTRY_MASTER_LANGUAGE_NAME_SHOULD_NOT_BE_NULL = new Error(114555);
	public static final Error COUNTRY_MASTER_CODE_SHOULD_NOT_BE_NULL = new Error(114556);
	public static final Error COUNTRY_MASTER_CODE_SHOULD_NOT_BE_DUPLICATE = new Error(114557);
	public static final Error COUNTRY_MASTER_NAME_DOES_NOT_EXITS = new Error(114558);
	public static final Error COUNTRY_MASTER_L_NAME_SHOULD_NOT_BE_DUPLICATE = new Error(114559);
	public static final Error COUNTRY_MASTER_STATUS_SHOULD_NOT_BE_EMPTY = new Error(114560);

	public static final Error STATE_NAME_REQUIRED = new Error(1080);
	public static final Error STATE_EMPTY = new Error(1081);
	public static final Error STATE_CODE_REQUIRED = new Error(1082);
	public static final Error STATE_LNAME_REQUIRED = new Error(1083);
	public static final Error STATE_STATUS_REQUIRED = new Error(1084);
	public static final Error STATE_CREATEDBY_REQUIRED = new Error(1085);
	public static final Error STATE_ADDED_SUCCESSFULLY = new Error(1086);
	public static final Error STATE_NAME_ALREADY_EXISTS = new Error(1087);
	public static final Error STATE_CODE_ALREADY_EXISTS = new Error(1088);
	public static final Error STATE_LNAME_ALREADY_EXISTS = new Error(1089);
	public static final Error STATE_MODIFIEDBY_REQUIRED = new Error(1090);
	public static final Error STATE_UPDATED_SUCCESSFULLY = new Error(1091);
	public static final Error STATE_DOES_NOT_EXISTS = new Error(1092);
	public static final Error STATE_RETRIEVED_SUCCESSFULLY = new Error(1093);
	public static final Error STATE_ID_REQUIRED = new Error(1094);
	public static final Error DISTRICT_MASTER_REQUIRED = new Error(1300);
	public static final Error DISTRICT_MASTER_CODE_REQUIRED = new Error(1301);
	public static final Error DISTRICT_MASTER_NAME_REQUIRED = new Error(1302);
	public static final Error DISTRICT_MASTER_LNAME_REQUIRED = new Error(1303);
	public static final Error DISTRICT_MASTER_STATE_REQUIRED = new Error(1304);
	public static final Error SELECT_DISTRICT_MASTER = new Error(1305);
	public static final Error DISTRICT_SAVED_SUCCESSFULLY = new Error(1306);
	public static final Error DISTRICT_DELETED_SUCCESSFULLY = new Error(1307);
	public static final Error DISTRICT_CODE_ALREADY_EXISTS = new Error(1308);
	public static final Error DISTRICT_NAME_ALREADY_EXISTS = new Error(1309);
	public static final Error DISTRICT_LNAME_ALREADY_EXISTS = new Error(1310);
	public static final Error DISTRICT_UPDATED_SUCCESSFULLY = new Error(1311);

	public static final Error TALUK_EMPTY = new Error(1320);
	public static final Error TALUK_CODE_REQUIRED = new Error(1321);
	public static final Error TALUK_NAME_REQUIRED = new Error(1322);
	public static final Error TALUK_LNAME_REQUIRED = new Error(1323);
	public static final Error TALUK_STATUS_REQUIRED = new Error(1324);
	public static final Error TALUK_CREATEDBY_REQUIRED = new Error(1325);
	public static final Error TALUK_ADDED_SUCCESSFULLY = new Error(1326);
	public static final Error TALUK_CODE_ALREADY_EXISTS = new Error(1327);
	public static final Error TALUK_NAME_ALREADY_EXISTS = new Error(1328);
	public static final Error TALUK_LNAME_ALREADY_EXISTS = new Error(1329);
	public static final Error TALUK_MODIFIEDBY_REQUIRED = new Error(1330);
	public static final Error TALUK_UPDATED_SUCCESSFULLY = new Error(1331);
	public static final Error TALUK_DOES_NOT_EXISTS = new Error(1332);
	public static final Error TALUK_RETRIEVED_SUCCESSFULLY = new Error(11336);
	public static final Error TALUK_DELETED_SUCCESSFULLY = new Error(13331);
	public static final Error SELECT_TALUK_MASTER = new Error(1334);

	public static final Error CIRCLE_MASTER_REQUIRED = new Error(1340);
	public static final Error CIRCLE_MASTER_CODE_REQUIRED = new Error(1341);
	public static final Error CIRCLE_MASTER_NAME_REQUIRED = new Error(1342);
	public static final Error CIRCLE_MASTER_LNAME_REQUIRED = new Error(1343);
	public static final Error CIRCLE_MASTER_STATE_REQUIRED = new Error(1344);
	public static final Error SELECT_CIRCLE_MASTER = new Error(1345);
	public static final Error CIRCLE_SAVED_SUCCESSFULLY = new Error(1346);
	public static final Error CIRCLE_DELETED_SUCCESSFULLY = new Error(1347);
	public static final Error CIRCLE_CODE_ALREADY_EXISTS = new Error(1348);
	public static final Error CIRCLE_NAME_ALREADY_EXISTS = new Error(1349);
	public static final Error CIRCLE_LNAME_ALREADY_EXISTS = new Error(1350);
	public static final Error CIRCLE_UPDATED_SUCCESSFULLY = new Error(1351);

	public static final Error PAY_SCALE_GROUP_EMPTY = new Error(1201);
	public static final Error PAY_SCALE_GROUP_FROM_AMOUNT_NOT_NULL = new Error(1202);
	public static final Error PAY_SCALE_GROUP_TO_AMOUNT_NOT_NULL = new Error(1203);
	public static final Error CREATED_DATE_NOT_NULL = new Error(1204);
	public static final Error OPTIMISTIC_LOCKING_FAILED = new Error(1205);
	public static final Error PAYSCALE_GROUP_RETRIEVED_SUCCESSFULLY = new Error(1206);
	public static final Error ID_NOT_PRESENT = new Error(1207);
	public static final Error PAYSCALE_GROUP_NOT_EXISTS = new Error(1208);
	public static final Error PAYSCALE_GROUP_DELETE_SUCCESSFULLY = new Error(1209);
	public static final Error FROM_AMOUNT_NOT_LESS_THAN_TO_AMOUNT = new Error(1210);
	public static final Error PAYSCALE_SAVE_SUCCESS = new Error(1211);
	public static final Error PAYSCALE_UPDATE_SUCCESS = new Error(1212);
	public static final Error PAYSCALE_SELECT_EMPTY = new Error(1213);
	public static final Error PAYSCALE_NOT_EXIST = new Error(1214);
	public static final Error PAYSCALE_DELETED_SUCCESS = new Error(1215);

	public static final Error EMP_ACHIVEMENTS_IS_EMPTY = new Error(7000);
	public static final Error EMP_ACHIVEMETS_AWARDEDBY_IS_EMPTY = new Error(7001);
	public static final Error EMP_ACHIVEMETS_AWARDEDBY_NAME_MAX = new Error(7002);
	public static final Error EMP_ACHIVEMETS_AWARDEDBY_NAME_MIN = new Error(7003);
	public static final Error EMP_ACHIVEMETS_DESCRIPTION_MAX = new Error(7004);
	public static final Error EMP_ACHIVEMETS_DESCRIPTION_MIN = new Error(7005);
	public static final Error EMP_ACHIVEMETS_IS_NOT_EXISTS = new Error(7006);

	public static final Error EMP_DETAILS_OF_CHARGE_FRAMED_REQ = new Error(7020);
	public static final Error EMP_DETAILS_OF_CHARGE_FRAMED_MAX = new Error(7021);
	public static final Error EMP_DETAILS_OF_CHARGE_FRAMED_MIN = new Error(7022);
	public static final Error EMP_DISCIPLINARY_IS_NOT_EXISTS = new Error(7023);

	public static final Error SYSTEM_NOTIFICATION_REQUEST_OBJECT_NOT_NULL = new Error(80000);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_FROM_USER_ID_NOT_NULL = new Error(80001);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_TO_USER_ID_NOT_NULL = new Error(80002);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_TO_USER_GROUP_ID_NOT_NULL = new Error(80003);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_REFERENCE_NUMBER_NOT_NULL = new Error(80004);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_SUBJECT_NOT_NULL = new Error(80005);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_MESSAGE_NOT_NULL = new Error(80006);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_ATTACHMENT_PATH_NOT_NULL = new Error(80007);
	public static final Error SYSTEM_NOTIFICATION_REQUEST_URL_PATH_NOT_NULL = new Error(80008);
	public static final Error USER_GROUP_NOT_FOUND = new Error(80009);
	public static final Error SYSTEM_NOTIFICATION_RECIPIENT_NOT_EMPTY = new Error(80010);
	public static final Error SYSTEM_NOTIFICATION_MESSAGE_READED_SUCCESSFULLY = new Error(80011);
	public static final Error SYSTEM_NOTIFICATION_NOT_EXIST = new Error(80012);
	public static final Error SYSTEM_NOTIFICATION_DELETED_SUCCESSFULLY = new Error(80013);

	public static final Error QUOTATION_NUMBER_NOT_EMPTY = new Error(8972);
	public static final Error PRODUCT_SELECTED_BY_LIST_EMPTY = new Error(12001);
	public static final Error QUOTATION_ID_EMPTY = new Error(12002);
	public static final Error DANPOFFICE_ID_EMPTY = new Error(12003);
	public static final Error SUPPLIER_ID_EMPTY = new Error(12004);
	public static final Error VALID_DATE_EMPTY = new Error(12005);
	public static final Error BILLING_ENTITY_ID_EMPTY = new Error(12006);
	public static final Error DELIVERY_ENTITY_ID_EMPTY = new Error(12007);
	public static final Error BUYER_ENTITY_ID_EMPTY = new Error(12008);
	public static final Error DANPOFFICE_IS_EMPTY = new Error(12009);
	public static final Error QUOTATION_NUMBER_PREFIX_NOT_EMPTY = new Error(12010);
	public static final Error SUPPLIER_IS_EMPTY = new Error(12011);
	public static final Error BUYER_ENTITY_IS_EMPTY = new Error(12012);
	public static final Error BILLING_ENTITY_IS_EMPTY = new Error(12013);
	public static final Error DELIVERY_ENTITY_IS_EMPTY = new Error(12014);
	public static final Error QUOTATION_REQUEST_EMPTY = new Error(12015);
	public static final Error QUOTATION_NUMBER_EXIST = new Error(12016);
	public static final Error QUOTATION_APPROVED_SUCCESSFULLY = new Error(12017);
	public static final Error QUOTATION_REJECTED = new Error(12018);
	public static final Error SUBMITTED_QUOTATION_CANNOT_EDITED = new Error(12019);
	public static final Error APPROVED_QUOTATION_CANNOT_EDITED = new Error(12021);
	public static final Error REJECTED_QUOTATION_CANNOT_EDITED = new Error(12022);
	public static final Error APPROVED_QUOTATION_CANNOT_BE_DELETED = new Error(12030);
	public static final Error CANNOT_DELETE_QUOTATION = new Error(12031);
	public static final Error PLEASE_ENTER_APPROVE_COMMENTS = new Error(12032);
	public static final Error PLEASE_ENTER_REJECT_COMMENTS = new Error(12033);
	public static final Error QUOTATION_LIST_EMPTY = new Error(12034);

	public static final Error REGION_ADDED_SUCCESSFULLY = new Error(1250);
	public static final Error DUPLICATE_REGION_NAME = new Error(1251);
	public static final Error REGION_EMPTY = new Error(1252);
	public static final Error REGION_RETRIVED_SUCCESSFULLY = new Error(1253);
	public static final Error REGION_UPDATED_SUCCESSFULLY = new Error(1254);
	public static final Error REGION_DOES_NOT_EXISTS = new Error(1255);
	public static final Error REGION_NAME_REQUIRED = new Error(1256);
	public static final Error REGION_DELETED_SUCCESSFULLY = new Error(1257);

	public static final Error WARN_EMP_PROMOTION_REF_NO = new Error(3001);
	public static final Error WARN_EMP_PROMOTION_REF_DATE = new Error(3002);
	public static final Error EMP_PROMOTION_CADRE = new Error(3003);
	public static final Error WARN_EMP_PROMOTION_CURR_DESIGNATION = new Error(3004);
	public static final Error EMP_PROMOTION_SENIORITY = new Error(3005);
	public static final Error EMP_PROMOTION_REGION_FROM = new Error(3006);
	public static final Error EMP_PROMOTION_REGION_TO = new Error(3007);
	public static final Error WARN_EMP_PROMOTION_DEPARTMENT = new Error(3008);
	public static final Error WARN_EMP_PROMOTION_EFFECTIVE_DATE = new Error(3009);

	public static final Error TRANSFER_REFERENCE_NO = new Error(9801);
	public static final Error TRANSFER_REFERENCE_DATE = new Error(9802);
	public static final Error TRANSFER_FROM_REGION = new Error(9803);
	public static final Error TRANSFER_TO_REGION = new Error(9804);
	public static final Error TRANSFER_FROM_DEPARTMENT = new Error(9805);
	public static final Error TRANSFER_TO_DEPARTMENT = new Error(9806);
	public static final Error TRANSFER_DETAILS_REMARKS_MAX = new Error(9807);
	public static final Error TRANSFER_REFERENCE_NO_EXISTS = new Error(9808);
	public static final Error ERROR_EMP_TRANSFER_DETAILS_NOT_FOUND = new Error(9809);
	public static final Error INFO_EMP_TRANSFER_DETAILS_CREATED = new Error(9810);
	public static final Error INFO_EMP_TRANSFER_DETAILS_UPDATED = new Error(9811);
	public static final Error INFO_EMP_TRANSFER_DETAILS_DELETED = new Error(9812);
	public static final Error INFO_EMP_TRANSFER_DETAILS_APPROVED = new Error(9813);
	public static final Error INFO_EMP_TRANSFER_DETAILS_REJECTED = new Error(9814);
	public static final Error ERROR_EMP_TRANSFER_DETAILS_ALREADY_APPROVED = new Error(9815);
	public static final Error ERROR_EMP_TRANSFER_DETAILS_ALREADY_REJECTED = new Error(9816);
	public static final Error INFO_EMP_TRANSFER_TRANSFER_DOCUMENT_UPLOADED = new Error(9817);
	public static final Error ERROR_EMP_TRANSFER_AVAILABILITY_NOT_FOUND = new Error(9818);
	public static final Error ERROR_EMP_TRANSFER_AVAILABILITY_FROM_DATE_NOT_FOUND = new Error(9819);
	public static final Error ERROR_EMP_TRANSFER_AVAILABILITY_NO_OF_POSITION_NOT_FOUND = new Error(9820);
	public static final Error ERROR_EMP_TRANSFER_JOINING_DATE_NOT_FOUND = new Error(9821);
	public static final Error ERROR_EMP_TRANSFER_APPROVE_COMMENTS_NOT_FOUND = new Error(9822);

	public static final Error CONTRACT_PRODUCTION_PLAN_SAVED_SUCCESSFULLY = new Error(9850);
	public static final Error CONTRACT_PRODUCTION_PLAN_CODE_DUPLICATED = new Error(9851);
	public static final Error CONTRACT_PRODUCTION_SELECT_ONE_RECORD = new Error(9852);
	public static final Error CONTRACT_PRODUCTION_CANNOT_BE_EDITED = new Error(9853);
	public static final Error CONTRACT_PRODUCTION_CANNOT_BE_DELETED = new Error(9854);
	public static final Error CADRE_MASTER_ADDED = new Error(1351);
	public static final Error CADER_NAME_ALREADY_EXISTS = new Error(1352);
	public static final Error CADER_IS_EMPTY = new Error(1357);
	public static final Error CADER_RETRIVED_SUCCESSFULLY = new Error(1353);
	public static final Error DELETE_SUCCESSFULLY = new Error(1354);
	public static final Error CONTRACT_PRODUCTION_PLAN_APPROVE_SUCCESSFULLY = new Error(9855);
	public static final Error CONTRACT_PRODUCTION_PLAN_REJECT_SUCCESSFULLY = new Error(9856);
	public static final Error CONTRACT_PRODUCTION_PLAN_FINALAPPROVE_SUCCESSFULLY = new Error(9857);

	public static final Error PRODCUT_QR_CODE_NOT_EMPTY = new Error(78000);
	public static final Error PRODCUT_QR_CODE_STOCK_TRANSFER_NOT_EMPTY = new Error(78001);
	public static final Error PRODCUT_QR_CODE_FROM_ENTITY_NOT_EMPTY = new Error(78002);
	public static final Error PRODCUT_QR_CODE_TO_ENTITY_NOT_EMPTY = new Error(78003);
	public static final Error PRODCUT_QR_CODE_STATUS_NOT_EMPTY = new Error(78004);
	public static final Error PRODCUT_QR_CODE_SUBMITTED_SUCCESSFULLY = new Error(78005);
	public static final Error PLEASE_SELECT_REGION_TYPE = new Error(78006);
	public static final Error PRICE_NOT_AVAILABLE = new Error(78007);
	public static final Error PLEASE_INPUT_AT_NUMBER = new Error(78008);
	public static final Error PLEASE_SELECT_ANY_ONE_QR_CODE = new Error(78009);
	public static final Error PRODCUT_QR_CODE_DELETED_SUCCESSFULLY = new Error(78010);
	public static final Error PLEASE_SELECT_STOCK_TRANSFER_NUMBER = new Error(78011);
	public static final Error PRODUCT_QR_CODE_ITEM_LIST_EMPTY = new Error(78012);
	public static final Error PRODUCT_QR_CODE_GENERATED_SUCCESSFULLY = new Error(78013);
	public static final Error PLEASE_SELECT_SOCIETY = new Error(78014);
	public static final Error PLEASE_COMPLETE_REGION_CATEGORIZATION = new Error(78015);
	public static final Error ALL_SCAN_COMPLETED = new Error(78016);
	public static final Error PRODUCT_QR_CODE_COMPLETED = new Error(78017);
	public static final Error PRODUCT_QR_CODE_IMAGE_PATH_NOT_FOUND = new Error(78018);
	public static final Error STOCK_INWARD_EXISTS = new Error(78019);
	public static final Error QR_COMPLETED_CANNOT_BE_DELETED = new Error(78020); // Payment
	public static final Error PAYMENT_REQUEST_EMPTY = new Error(78021);
	public static final Error PLEASE_SELECT_ANY_ONE_VOUCHER = new Error(78022);
	public static final Error PAYMENT_SUBMITTED_SUCCESSFULLY = new Error(78023);
	public static final Error PAYMENT_TRANSACTION_FAILURE = new Error(78121);
	public static final Error LOGIN_USER_INFO_NOT_AVAILABLE = new Error(78024);
	public static final Error BANK_INFO_NOT_AVAILABLE = new Error(78025);
	public static final Error PAYMNET_METHOD_NOT_AVAILABLE = new Error(78026);
	public static final Error PLEASE_SELECT_PAYMENT = new Error(78027);
	public static final Error PLEASE_SELECT_APPROVED_VOUCHER = new Error(78028);
	public static final Error FILE_PATH_NOT_FOUND = new Error(78029);
	public static final Error PLEASE_SELECT_DISTRICT = new Error(78030);
	public static final Error DISTRICT_TALUK_REQUEST_NULL = new Error(78031);
	public static final Error GOVT_PLAN_ID_NULL = new Error(78032);
	public static final Error REQUIREMENT_LIST_EMPTY = new Error(78033);
	public static final Error DTW_PRODUCT_GROUP_EMPTY = new Error(78034);
	public static final Error GOVT_SCHEME_PLAN_NOT_AVAILABLE = new Error(78035);
	public static final Error DISTRICT_TALUK_SAVED_SUCCESSFULLY = new Error(78036);
	public static final Error GROUP_VALUE_EMPTY = new Error(78037);
	public static final Error DISTRICT_TALUK_APPROVED = new Error(78039);
	public static final Error DISTRICT_TALUK_REJECTED = new Error(78040);
	public static final Error NO_RECORDS_FOUND_FROM_FILE = new Error(78041);
	public static final Error PLEASE_SELECT_FORWARD_TO = new Error(78042);
	public static final Error PLEASE_SELECT_FORWARD_FOR = new Error(78043);
	public static final Error ALL_RECORDS_NOT_VERIFIED = new Error(78045);
	public static final Error ACCEPTED_NOT_MORE_THAN_RECEIVED = new Error(78038);
	public static final Error HSN_CODE_NOT_CONFIGURED = new Error(78046);
	public static final Error PRODUCT_PRICE_NOT_CONFIGURED = new Error(78047);
	public static final Error PRODUCT_TAX_DETAILS_NOT_CONFIGURED = new Error(78048);
	public static final Error PRODUCT_ALREADY_EXISTS = new Error(78049);
	public static final Error DISCONT_INVALID = new Error(78050);
	public static final Error SALES_QUOTATION_ADDES_SUCCESSFULLY = new Error(78051);
	public static final Error GROUP_ALREADY_EXISTS = new Error(1270);
	public static final Error ERROR_SPECIAL_CHARACTER_NOT_ALLOWED = new Error(1271);
	public static final Error GROUP_ADDED_SUCCESSFULLY = new Error(1272);
	public static final Error GROUP_NOT_FOUND = new Error(1273);
	public static final Error GROUP_REQUIRED = new Error(1274);
	public static final Error GROUP_UPDATED_SUCCESSFULLY = new Error(1275);
	public static final Error CADER_LNAME_ALREADY_EXISTS = new Error(1355);

	public static final Error ERROR_QULIFICATION_IS_NULL = new Error(3010);
	public static final Error ERROR_QULIFICATION_NOT_FOUND = new Error(3011);
	public static final Error RECORED_CAN_NOT_BE_DELETED = new Error(1356);
	public static final Error CADRE_NAME_REQUIRED = new Error(1358);
	public static final Error CADRE_lNAME_REQUIRED = new Error(1359);
	public static final Error CADRE_NAME_MAX_LENGTH = new Error(1360);
	public static final Error CADRE_NAME_MIN_LENGTH = new Error(1361);
	public static final Error CADRE_LNAME_MIN_LENGTH = new Error(1362);
	public static final Error CADRE_LNAME_MAX_LENGTH = new Error(1363);
	public static final Error CADRE_PAYSCALE_REQUIRED = new Error(1364);
	public static final Error CANNOT_DELETE_EMPTY_RECORD = new Error(1365);
	public static final Error CADRE_DELETED_SUCCESS = new Error(1366);
	public static final Error CADRE_SAVE_SUCCESS = new Error(1367);
	public static final Error CADRE_UPDATE_SUCCESS = new Error(1368);
	public static final Error CADRE_SELECT_ERROR = new Error(1369);
	public static final Error CADRE_NOT_EXIST = new Error(1370);
	public static final Error EDUCATION_QUALIFICTION_IS_EMPTY = new Error(1400);
	public static final Error EDUCATION_QUALIFICTION_NAME_REQUIRED = new Error(1401);
	public static final Error EDUCATION_QUALIFICTION_lNAME_REQUIRED = new Error(1402);
	public static final Error EDUCATION_QUALIFICTION_REQUIRED = new Error(1403);
	public static final Error EDUCATION_QUALIFICTION_STATUS_REQUIRED = new Error(1404);
	public static final Error EDUCATION_QUALIFICTION_SAVE_SUCCESS = new Error(1405);
	public static final Error EDUCATION_QUALIFICTION_DELETE_SUCCESS = new Error(1406);
	public static final Error EDUCATION_QUALIFICTION_UPDATE_SUCCESS = new Error(1407);
	public static final Error EDUCATION_QUALIFICTION_LIST_EMPTY = new Error(1408);
	public static final Error EDUCATION_QUALIFICTION_ID_NOT_EXIST = new Error(1409);
	public static final Error EDUCATION_QUALIFICTION_NAME_ALREADY_EXIST = new Error(1410);
	public static final Error EDUCATION_QUALIFICTION_LNAME_ALREADY_EXIST = new Error(1411);
	public static final Error EDUCATION_QUALIFICTION_ID_REQUIRED = new Error(1412);
	public static final Error EDUCATION_QUALIFICATION_SELECT = new Error(1413);
	public static final Error EDUCATION_QUALIFICATION_NO_SELECTED = new Error(1414);

	public static final Error LOAN_NAME_REQUIRED = new Error(1600);
	public static final Error LOAN_lNAME_REQUIRED = new Error(1601);
	public static final Error LOAN_AMOUNT = new Error(1602);
	public static final Error LOAN_START_DATE_MANDATORY = new Error(1603);
	public static final Error LOAN_END_MANDATORY = new Error(1604);
	public static final Error LOAN_INSTALLMENT_AMOUNT_MANDATORY = new Error(1605);
	public static final Error LOAN_PREMIMIUM_AMOUNT_MANDATORY = new Error(1606);
	public static final Error LOAN_STATUS = new Error(1607);
	public static final Error LOAN_SAVE_SUCCESS = new Error(1608);
	public static final Error LOAN_DELETED_SUCCESS = new Error(1609);
	public static final Error LOAN_UPDATE_SUCCESS = new Error(1610);
	public static final Error LOAN_SELECT_ERROR = new Error(1611);
	public static final Error LOAN_NOT_EXIST = new Error(1612);
	public static final Error LOAN_LIST_IS_EMPTY = new Error(1613);
	public static final Error LOAN_NAME_ALREADY_EXIST = new Error(1614);
	public static final Error LOAN_ID_SHOULD_NOTBE_EMPTY = new Error(1615);
	public static final Error LOAN_SELECT = new Error(1616);
	public static final Error LOAN_NO_SELECTED = new Error(1617);
	public static final Error LOAN_LOCALNAME_ALREADY_EXIST = new Error(1618);

	public static final Error EMP_PAYSCALE_CADRE_EMPTY = new Error(6000);
	public static final Error EMP_PAYSCALE_EFFECTIVE_DATE_EMPTY = new Error(9101);
	public static final Error EMP_EDU_DETAILS_DELETED = new Error(9100);
	public static final Error EMP_PAYSCALE_DELETED = new Error(7000);
	public static final Error EMP_REGISTRATION_NUM_EXIST = new Error(6004);
	public static final Error EMP_REGISTRATION_NUM_REQUIRED = new Error(6005);
	public static final Error EMP_ADDITIONAL_INFO_SAVED_SUCCESS = new Error(6006);
	public static final Error EMP_PHOTO_UPLOAD_FAILED = new Error(6009);
	public static final Error EMP_PHOTO_DISPLAY_FAILED = new Error(6010);
	public static final Error EMPLOYEE_CREATED_SUCCESSFULLY = new Error(6111);
	public static final Error EMP_EDU_DOC_DISPLAY_FAILED = new Error(6012);
	public static final Error EMP_FAMILY_LIST_EMPTY = new Error(11549);
	public static final Error ERROR_PERMANENT_ADD_LINE_ONE = new Error(6014);
	public static final Error ERROR_PERMANENT_ADD_LINE_TWO = new Error(6015);
	public static final Error ERROR_PERMANENT_ADD_LINE_THREE = new Error(6016);
	public static final Error ERROR_PRESENT_ADD_LINE_ONE = new Error(6017);
	public static final Error ERROR_PRESENT_ADD_LINE_TWO = new Error(6018);
	public static final Error ERROR_PRESENT_ADD_LINE_THREE = new Error(6019);
	public static final Error INVALID_PERMENENT_POSTAL_CODE = new Error(6020);
	public static final Error INVALID_PRESENT_POSTAL_CODE = new Error(6021);

	public static final Error EMP_TRANSFER_DETAILS_EXIST = new Error(9882);
	public static final Error INTERNAL_ERROR = new Error(2000);
	public static final Error ERROR_RETAIL_SALES_DNP_REQUEST_OBJECT_NULL = new Error(9070);
	public static final Error ERROR_DNP_OFFICE_NULL = new Error(9071);
	public static final Error ERROR_DNP_OFFICE_NOT_FOUND = new Error(9072);
	public static final Error ERROR_RETAIL_SALES_DNP_PROCUREMENT_PLAN_NULL = new Error(9073);
	public static final Error ERROR_RETAIL_SALES_DNP_PROCUREMENT_PLAN_NOT_FOUND = new Error(9074);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_SAVED_SUCCESSFULLY = new Error(9075);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_SUBMITTED_SUCCESSFULLY = new Error(9076);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_UPDATED_SUCCESSFULLY = new Error(9077);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_DELETED_SUCCESSFULLY = new Error(9078);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_CANNOT_BE_DELETED = new Error(9079);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_APPROVED = new Error(9080);
	public static final Error INFO_RETAIL_SALES_DNP_PROCUREMENT_PLAN_REJECTED = new Error(9081);
	public static final Error ERROR_NO_PRODUCTS_FOUND_FOR_SELECTED_PLAN_AND_DNP_OFFICE = new Error(9082);
	public static final Error ERROR_AVERAGE_PURCHASE_PRICE_NOT_AVAILABLE = new Error(9083);
	public static final Error ERROR_UPDATED_TOTAL_PRODUCT_QUANTITY_SHOULD_NOT_EXCEED_PREVIOUS_QUANTITY = new Error(
			9084);
	public static final Error ERROR_UPDATED_TOTAL_PRODUCT_QUANTITY_WITH_VALID_DATA = new Error(9085);
	public static final Error ERROR_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_NULL = new Error(1151);
	public static final Error ERROR_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_NOT_FOUND = new Error(1152);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_SAVED_SUCCESSFULLY = new Error(1153);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_SUBMITTED_SUCCESSFULLY = new Error(1154);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_UPDATED_SUCCESSFULLY = new Error(1155);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_DELETED_SUCCESSFULLY = new Error(1156);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_CANNOT_BE_DELETED = new Error(1157);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_APPROVED = new Error(1158);
	public static final Error INFO_RETAIL_SALES_SOCIETYWISE_PROCUREMENT_PLAN_REJECTED = new Error(1159);
	public static final Error ERROR_RETAIL_SALES_SOCIETYWISE_PLAN_REQUEST_OBJECT_NULL = new Error(1160);
	public static final Error ERROR_PRODUCT_VARIETY_NULL = new Error(1161);
	public static final Error ERROR_EMPTY_LOGIN_DETAILS = new Error(10000);
	public static final Error ERROR_USER_NAME_EMPTY = new Error(10001);
	public static final Error ERROR_PASSWORD_EMPTY = new Error(10002);
	public static final Error ERROR_USER_DOES_NOT_EXISTS = new Error(10003);
	public static final Error ERROR_EMPLOYEE_MASTER_DOES_NOT_EXISTS = new Error(10004);
	public static final Error ERROR_EMPLOYEE_DETAILS_DOES_NOT_EXISTS = new Error(10005);
	public static final Error ERROR_EMPLOYEE_INFO_NOT_IN_SERVICE = new Error(10006);
	public static final Error ERROR_EMPLOYEE_UN_AUTHORIZED_FORAPP = new Error(10007);
	public static final Error ERROR_USER_NOT_ACTIVE = new Error(10008);
	public static final Error ERROR_EMPLOYEE_NOT_ACTIVE = new Error(10009);
	public static final Error ERROR_PASSWORD_MISMATCH = new Error(10010);
	public static final Error ERROR_PROCUREMENT_LIST_NOT_FOUND = new Error(10011);
	public static final Error ERROR_PROCUREMENT_ORDER_NOT_FOUND = new Error(10012);
	public static final Error ERROR_SUPPLIER_LIST_NOT_FOUND = new Error(10013);
	public static final Error ERROR_ENTITY_TYPE_NOT_FOUND = new Error(10014);
	public static final Error ERROR_ENTITY_TYPE_MISMATCH = new Error(10015);
	public static final Error ERROR_ENTITY_MASTER_NOT_ACTIVE = new Error(10016);
	public static final Error ERROR_PROCUREMENT_ORDER_NOT_ACTIVE = new Error(10017);
	public static final Error ERROR_SCANNED_PRODUCT_NULL = new Error(10018);
	public static final Error ERROR_PROCUREMENT_ORDER_EMPTY = new Error(10019);
	public static final Error ERROR_SOCIETY_EMPTY = new Error(10020);
	public static final Error ERROR_AT_NUMBER_NULL = new Error(10021);
	public static final Error ERROR_PRODUCT_APPRAISAL_NULL = new Error(10022);
	public static final Error ERROR_PROCUREMENT_ORDER_DETAILS_NULL = new Error(10023);
	public static final Error ERROR_SCAN_PROD_QUANTITY_MISMATCH = new Error(10024);
	public static final Error ERROR_SUM_VALUE_NULL = new Error(10025);
	public static final Error ERROR_DUPLICATE_AT_NUMBER = new Error(10026);
	public static final Error ERROR_SCANNED_PRODUCT_NOT_FOUND = new Error(10027);
	public static final Error ERROR_SCANNED_PROD_DETAILS_NULL = new Error(10028);
	public static final Error EMPTY_SEARCH_RESULT_MOBILE = new Error(10029);
	public static final Error DELETE_SELECTED_PRODUCT_SUCCESS = new Error(10030);
	public static final Error ERROR_CONFIRMED_PRODUCT_EMPTY = new Error(10031);
	public static final Error ERROR_PRODUCT_SELECTION_EMPTY = new Error(10032);
	public static final Error ERROR_QUERY_EMPTY = new Error(10033);
	public static final Error ERROR_SEARCH_PARAM_EMPTY = new Error(10034);
	public static final Error RECORDS_TO_UPDATE_EMPTY = new Error(10035);
	public static final Error SUPPLIERS_LIST_NOT_FOUND = new Error(33004);
	public static final Error EMPLOYEE_PERSONAL_INFO_EMPTY = new Error(33005);
	public static final Error EMPLOYEE_MASTER_EMPTY = new Error(33006);
	public static final Error ERROR_EMPLOYEE_NOT_FOUND = new Error(33009);
	public static final Error ERROR_EMPLOYEE_INFO_NOT_FOUND = new Error(33010);
	public static final Error ERROR_EMPLOYEE_INFO_NOT_ACTIVE = new Error(33011);
	public static final Error WARN_EMP_PROMOTION_CURR_PAYSCALE = new Error(2001);
	public static final Error WARN_EMP_PROMOTED_DESIG_EMPTY = new Error(2002);
	public static final Error WARN_EMP_PROMOTION_REF_PAYSCALE = new Error(2003);
	public static final Error WARN_EMP_PROMOTION_REF_NO_LENGTH = new Error(2004);
	public static final Error WARN_EMP_PROMOTION_PROC_REF_NO_LENGTH = new Error(2005);
	public static final Error EMP_PROMOTION_ID_ISNULL = new Error(2006);
	public static final Error EMP_PROMOTION_CANNOT_DELETE = new Error(2007);
	public static final Error EMP_PROMOTION_IS_EMPTY = new Error(2008);
	public static final Error EMP_PROMOTION_REGION_LIST_EMPTY = new Error(2010);
	public static final Error EMP_PROMOTION_DESIGNATION_ID_MANDATORY = new Error(2011);
	public static final Error EMP_PROMOTION_DEPARTMENT_ID_MANDATORY = new Error(2012);
	public static final Error EMP_PROMOTION_YEAR_IS_MANDATORY = new Error(2013);
	public static final Error EMP_PROMOTION_MONTH_IS_MANDATORY = new Error(2014);
	public static final Error EMP_PROMOTION_LIST_IS_EMPTY = new Error(2015);
	public static final Error EMP_PROMOTION_SAVE_SUCCESS = new Error(2016);
	public static final Error EMP_PROMOTION_UPDATE_SUCCESS = new Error(2017);
	public static final Error EMP_PROMOTION_DELETE_SUCCESS = new Error(2018);
	public static final Error EMP_FAMILY_LIST_ROW_REMOVED = new Error(6074);
	public static final Error EMP_FAMILY_ID_NULL = new Error(6074);
	public static final Error EMP_PAYSCALE_LIST_EMPTY = new Error(6075);
	public static final Error EMP_COMMUNITY_FILE_UPLOAD_SUCCESS = new Error(11400);
	public static final Error EMP_PAN_FILE_UPLOAD_SUCCESS = new Error(11401);
	public static final Error EMP_EX_SERVICE_FILE_UPLOAD_SUCCESS = new Error(11402);
	public static final Error EMP_FREEDOM_FIGHTER_FILE_IS_EMPTY = new Error(6085);
	public static final Error EMP_ACHIEVEMENT_LIST_IS_EMPTY = new Error(6086);
	public static final Error EMP_RELIEVING_DOC_UPLOAD_SUCCESS = new Error(11458);
	public static final Error EMP_SELECTED_EDU_DETAIL_EMPTY = new Error(6072);
	public static final Error EMP_SELECTED_EDU_LIST_EMPTY = new Error(6074);
	public static final Error EMP_DIFFENENTLYABLED_FILE_UPLOAD_SUCCESS = new Error(6079);
	public static final Error EMP_FREEDOM_FIGHTER_FILE_UPLOAD_SUCCESS = new Error(6080);
	public static final Error EMP_COMMUNITY_FILE_IS_EMPTY = new Error(6081);
	public static final Error EMP_PAN_FILE_IS_EMPTY = new Error(6082);
	public static final Error EMP_EX_SERVICE_FILE_IS_EMPTY = new Error(6083);
	public static final Error EMP_DIFFENENTLYABLED_FILE_IS_EMPTY = new Error(6084);
	public static final Error EMP_ACHIEVEMENT_IS_EMPTY = new Error(6087);
	public static final Error EMP_EXP_LIST_IS_EMPTY = new Error(6088);
	public static final Error ENTER_ATLEAST_ONE_VALUE = new Error(6089);
	public static final Error EMP_ACHIVE_LIST_EXCEEDS = new Error(6090);
	public static final Error EMP_EXP_IS_EMPTY = new Error(6091);
	public static final Error EMP_RELIEVING_DOC_EMPTY = new Error(6092);
	public static final Error EMP_CONTACT_DETAILS_IS_EMPTY = new Error(6093);
	public static final Error EMPLOYEE_ADDRESS_PROOF_FORMAT = new Error(6094);
	public static final Error EMPLOYEE_ADDRESS_PROOF_DOC_IS_EMPTY = new Error(6095);
	public static final Error EMP_CONTACT_DETAILS_LAND_LINE_CODE_EMPTY = new Error(11444);
	public static final Error EMP_CONTACT_DETAILS_LAND_LINE_NUMBER_EMPTY = new Error(11446);
	public static final Error TALUK_ID_NULL = new Error(11447);
	public static final Error EXPERIENCE_FIELD_EMPTY = new Error(11448);
	public static final Error EXPERIENCE_COMPANY_LENGTH = new Error(11449);
	public static final Error EXPERIENCE_DESIGNATION_LENGTH = new Error(11450);
	public static final Error ENTITY_TYPE_ID_NOT_EXIST = new Error(11451);
	public static final Error EMP_CADRE_IS_NULL = new Error(6096);
	public static final Error NO_EMP_SELECTED = new Error(6097);
	public static final Error EDU_DETAILS_PERCENTAGE_VALIDATION = new Error(6098);
	public static final Error EDU_INSTITUTENAME_VALIDATION = new Error(6099);
	public static final Error EMP_EDU_YEAR_VALIDATION = new Error(6100);
	public static final Error EMP_EDU_DOC_EMPTY = new Error(6101);
	public static final Error EMP_IS_ACTIVE = new Error(6102);
	public static final Error EMP_NOT_FOUND = new Error(6103);
	public static final Error PAYSCALE_ID_NOT_EXIST = new Error(11517);
	public static final Error EMP_INTERCHANGE_ROW_REMOVED = new Error(11530);
	public static final Error EMP_INTERCHANGE_LIST_EMPTY = new Error(11531);
	public static final Error SELECT_EMPLOYEE_ID = new Error(11504);
	public static final Error HEIGHT_NEGATIVE_NOT_ALLOWED = new Error(11505);
	public static final Error WEIGHT_NEGATIVE_NOT_ALLOWED = new Error(11506);
	public static final Error ENTITY_MASTER_MAPPED = new Error(4209);
	public static final Error EMPLOYEE_TRANSFER_REF_NO_MAX_MIN = new Error(11535);
	public static final Error TRANSFER_FROM_EMPTY = new Error(11536);
	public static final Error TRANSFER_TO_EMPTY = new Error(11537);
	public static final Error SECTION_FROM_EMPTY = new Error(11538);
	public static final Error SECTION_TO_EMPTY = new Error(11539);
	public static final Error RELIEVED_ON_EMPTY = new Error(11540);
	public static final Error ASSUMTION_OF_CHANGE_EMPTY = new Error(11541);
	public static final Error INTERCHANGE_REFERENCE_NO = new Error(11542);
	public static final Error INTERCHANGE_REFERENCE_DATE = new Error(11543);
	public static final Error EMP_PROMOTION_REF_NO_EXIST = new Error(2006);
	public static final Error PUNISHMENT_LIST_NOT_AVAILABLE = new Error(1258);
	public static final Error EMP_DISCIPLINARY_REF_NO_LENGTH = new Error(60001);
	public static final Error EMP_SCANNED_DOC_IS_EMPTY = new Error(7031);
	public static final Error EMP_SCANNED_DOC_TYPE_ERROR = new Error(7032);
	public static final Error EMP_SCANNED_DOC_SIZE_ERROR = new Error(7033);
	public static final Error EMP_SCANNED_DOC_DELETE_SUCCESS = new Error(7034);
	public static final Error EMPLOYEE_INTERCHANGE_REF_NO_MAX_MIN = new Error(11544);
	public static final Error EMP_ENTITY_EMPTY = new Error(11545);
	public static final Error FAMILY_DOB_MANDATORY = new Error(11547);
	public static final Error EMP_TRANSFER_LIST_EMPTY = new Error(11550);
	public static final Error EMP_DISCIPLINARY_REF_EXIST = new Error(11546);
	public static final Error QUALIFICATIONS_NOT_FOUND = new Error(60003);
	public static final Error EMP_EDUCATION_REG_NO_LENGTH = new Error(60004);
	public static final Error EDU_DETAILS_INSTITUTE_NAME_LENGTH = new Error(60005);
	public static final Error EDU_DETAILS_UNIVERSITY_NAME_LENGTH = new Error(60006);
	public static final Error PAYSCALE_NOT_FOUND = new Error(60007);
	public static final Error EMP_MIDDLENAME_LENGTH_VALIDATION = new Error(7035);
	public static final Error EMP_LOCAL_MIDDLENAME_LENGTH_VALIDATION = new Error(7036);
	public static final Error EMP_PROCEEDING_REF_NO_EXIST = new Error(2300);
	public static final Error EMP_REVISED_BASICPAY_EMPTY = new Error(23001);
	public static final Error REFERENCE_NO_LENGTH = new Error(23002);
	public static final Error PURCHASE_ORDER_ID_EMPTY = new Error(24000);
	public static final Error PURCHASE_ORDER_SELECT_ONE_RECORD = new Error(24001);
	public static final Error PURCHASE_ORDER_DELETE_SUCCESS = new Error(24002);
	public static final Error PURCHASE_ORDER_CANNOT_BE_MODIFIED = new Error(24003);
	public static final Error PURCHASE_ORDER_CODE_DUPLICATE = new Error(24005);
	public static final Error PURCHASE_ORDER_EMPTY_PRODUCT_DETAILS = new Error(24006);
	public static final Error PURCHASE_ORDER_LIST_EMPTY = new Error(24009);
	public static final Error PURCHASE_ORDER_SAVE_SUCCESS = new Error(24010);
	public static final Error PURCHASE_ORDER_SELECT_ANY_ONE = new Error(24011);
	public static final Error PURCHASE_ORDER_UPDATED = new Error(24012);
	public static final Error PURCHASE_ORDER_SUBMITTED = new Error(24013);
	public static final Error PURCHASE_ORDER_DELETED = new Error(24015);
	public static final Error PURCHASE_ORDER_CANNOT_EDIT = new Error(24016);
	public static final Error PURCHASE_ORDER_SOCIETY_NOT_NULL = new Error(24017);
	public static final Error PURCHASE_ORDER_QUOTATION_NOT_NULL = new Error(24018);
	public static final Error PURCHASE_ORDER_ORDERTYPE_NOT_NULL = new Error(24019);
	public static final Error PURCHASE_ORDER_SHIPPING_ADDRESS_NOT_NULL = new Error(24020);
	public static final Error PURCHASE_ORDER_BILLING_ADDRESS_NOT_NULL = new Error(24021);
	public static final Error PURCHASE_ORDER_VALID_DATE_NOT_NULL = new Error(24022);
	public static final Error PURCHASE_ORDER_DELIVERY_DATE_NOT_NULL = new Error(24023);
	public static final Error PURCHASE_ORDER_EMPTY = new Error(24024);
	public static final Error RETAIL_QUALITY_CHECK_ID_EMPTY = new Error(24100);
	public static final Error RETAIL_QUALITY_CHECK_DELETE_SUCCESS = new Error(24101);
	public static final Error RETAIL_QUALITY_CHECK_LIST_EMPTY = new Error(24102);
	public static final Error RETAIL_QUALITY_CHECK_SELECT_ANY_ONE = new Error(24103);
	public static final Error RETAIL_QUALITY_CHECK_SAVE_SUCCESS = new Error(24104);
	public static final Error RETAIL_QUALITY_CHECK_SUBMIT_SUCCESS = new Error(24105);
	public static final Error RETAIL_QUALITY_CHECK_CANNOT_EDIT = new Error(24106);
	public static final Error RETAIL_QUALITY_CHECK_EMPTY = new Error(24107);
	public static final Error RETAIL_QUALITY_CHECK_PRODUCT_WISE_LIST_EMPTY = new Error(24108);
	public static final Error RETAIL_QUALITY_CHECK_ATNUMBER_WISE_VALIDATION_MESSAGE = new Error(24109);
	public static final Error RETAIL_QUALITY_CHECK_ISVERIFIED = new Error(24110);
	public static final Error RETAIL_QUALITY_CHECK_CANNOT_BE_DELETED = new Error(24111);
	public static final Error EMP_ENTITY_NOT_NULL = new Error(24006);
	public static final Error EMP_ADDITIONAL_CHARGE_REFERENCE_DATE_NOT_NULL = new Error(24007);
	public static final Error EMP_ADDITIONAL_CHARGE_REFERENCE_NUM_NOT_NULL = new Error(24008);
	public static final Error EMP_ADDITIONAL_CHARGE_PAYMENT_NOT_NULL = new Error(24009);
	public static final Error EMP_DATE_OF_ADDITIONAL_CAHRGE_NOT_NILL = new Error(2501);
	public static final Error EMP_ADDITIONAL_CHARGE_REMARKS = new Error(25021);
	public static final Error EMP_ADDDITIONAL_CHARGE_NULL = new Error(25022);
	public static final Error EMP_ADDITIONAL_CHARGE_REF_NO_EXIST = new Error(25023);
	public static final Error EMP_INCREMENRT_DETAILS_NULL = new Error(24002);
	public static final Error EMP_INCREMENT_LIST_EMPTY = new Error(24003);
	public static final Error EMP_INCREMENT_REFERENCE_NUM_EXIST = new Error(1072);
	public static final Error EMP_INCREMENRT_NULL = new Error(24005);
	public static final Error INCREMENT_CYCLE_NOT_FOUND = new Error(24001);
	public static final Error EMP_INCREMENT_CYCLE_NOT_NULL = new Error(9050);
	public static final Error EMP_INCREMENT_AMOUNT_NOT_NULL = new Error(9051);
	public static final Error EMP_BASIC_PAY_NOT_NULL = new Error(9052);
	public static final Error EMP_REVISED_BASIC_PAY_NOT_NULL = new Error(9053);
	public static final Error EMP_INCREMENT_REFERENCE_NUMBER_NOT_NULL = new Error(9054);
	public static final Error EMP_INCREMENT_REFERENCE_DATE_NOT_NULL = new Error(9055);
	public static final Error EMP_INCREMENT_DATE_OF_ENTRY_NOT_NULL = new Error(9056);
	public static final Error EMP_INCREMENT_EFFECTIVE_DATE_NOT_NULL = new Error(9057);
	public static final Error EMP_PAY_SCALE_EMPTY = new Error(9058);
	public static final Error EMP_ADDITIONAL_REF_NO_EXIST = new Error(9059);
	public static final Error VALID_AWARD_NAME = new Error(33015);
	public static final Error VALID_AWARDED_BY = new Error(33016);
	public static final Error VALID_AWARDED_DESCRIPTION = new Error(33017);
	public static final Error EMPLOYEE_CONTACT_NUMBER_EXISTS = new Error(33018);
	public static final Error EMPLOYEE_EMIAL_ID_EXISTS = new Error(33019);
	public static final Error REGION_CODE_REQUIRED = new Error(1260);
	public static final Error DUPLICATE_REGION_CODE = new Error(1259);
	public static final Error EMP_EDUCATION_DETAILS_SAVED = new Error(33020);
	public static final Error EMP_PAYSCALE_SAVED = new Error(33021);
	public static final Error EMP_DISCIPLINARY_ACTION_CREATED = new Error(33022);
	public static final Error EMP_PROMOTION_DETAILS_CREATED = new Error(33023);
	public static final Error EMP_EDU_PERCENTAGE_VALIDATION = new Error(33024);
	public static final Error USER_TYPE_REQUIRED = new Error(1040);
	public static final Error USER_MAPPED_WITH_OTHER_ENTITY = new Error(7500);
	public static final Error PRIORITY_MASTER_ID_NOT_FOUND = new Error(75001);
	public static final Error PRIORITY_MASTER_RECORD_NOT_FOUND = new Error(75002);
	public static final Error NON_PRIORITY_MASTER_RECORD_NOT_FOUND = new Error(75003);
	public static final Error PRIORITY_MASTER_NOT_FOUND = new Error(75004);
	public static final Error PRIORITY_NAME_EXISTS = new Error(75005);
	public static final Error PRIORITY_CODE_EXISTS = new Error(75006);
	public static final Error PRIORITY_MASTER_SAVED = new Error(75007);
	public static final Error PRIORITY_MASTER_UPDATED = new Error(75008);
	public static final Error PRIORITY_MASTER_DELETED = new Error(75009);
	public static final Error EMP_EDUCATION_DETAILS_UPDATED = new Error(75010);
	public static final Error EMP_PAYSCALE_UPDATED = new Error(75011);
	public static final Error EMP_PROMOTION_DETAILS_UPDATED = new Error(75012);
	public static final Error EMP_DISCIPLINARY_ACTION_UPDATED = new Error(75013);
	public static final Error PRIORITY_CODE_NOT_NULL = new Error(75014);
	public static final Error PRIORITY_NAME_NOT_NULL = new Error(75015);
	public static final Error EMP_LEAVE_TRAVEL_CONCESSION_CREATED = new Error(75016);
	public static final Error EMP_LEAVE_TRAVEL_CONCESSION_UPDATED = new Error(75017);
	public static final Error EMP_EMPLOYMENT_DETAILS_CREATED = new Error(75018);
	public static final Error EMP_EMPLOYMENT_DETAILS_UPDATED = new Error(75019);
	public static final Error ROSTER_POINT_REQUIRED = new Error(1500);
	public static final Error ROSTER_NAME_REQUIRED = new Error(1501);
	public static final Error COMMUNITY_CODE_REQUIRED = new Error(1502);
	public static final Error CATEGORY_REQUIRED = new Error(1503);
	public static final Error PRIORITY_REQUIRED = new Error(1504);
	public static final Error COMMUNAL_ROSTER_ADDED_SUCCESSFULLY = new Error(1505);
	public static final Error COMMUNAL_ROSTER_UPDATED_SUCCESSFULLY = new Error(1506);
	public static final Error ROSTER_POINT_ALREADY_EXISTS = new Error(1507);
	public static final Error ROSTER_NOT_EMPTY = new Error(1577);
	public static final Error EMP_FAMILY_DETAILS_SAVED = new Error(11403);
	public static final Error EMP_FAMILY_DETAILS_UPDATED = new Error(11404);
	public static final Error EMP_EMPLOYEEMENT_DETAILS_SAVED = new Error(11405);
	public static final Error EMP_EMPLOYEEMENT_DETAILS_UPDATED = new Error(11406);
	public static final Error INTERCHANGE_SAVED = new Error(11407);
	public static final Error INTERCHANGE_UPDATE = new Error(11408);
	public static final Error TRANSFER_SAVED = new Error(11409);
	public static final Error TRANSFER_UPDATE = new Error(11410);
	public static final Error INCREMENRTAL_SAVED = new Error(11500);
	public static final Error INCREMENRTAL_UPDATED = new Error(11501);
	public static final Error EMP_ADDITIONAL_CHARGE_DETAILS_SAVED = new Error(11502);
	public static final Error EMP_ADDITIONAL_CHARGE_DETAILS_UPDATED = new Error(11503);
	public static final Error EMP_DISCIPLINARY_ACTION_SAVED = new Error(11600);
	public static final Error EMP_ADDRESS_DETAILS_SAVED = new Error(11602);
	public static final Error EMP_ADDRESS_DETAILS_UPDATED = new Error(11603);
	public static final Error EMPLOYMENT_DATE_OF_JOINING = new Error(33025);
	public static final Error RECORDS_FOUND = new Error(33026);
	public static final Error APP_CONFIG_VALUE_NOT_FOUND = new Error(112338);
	public static final Error APP_CONFIG_NOT_FOUND = new Error(112339);
	public static final Error APP_CONFIG_REQUEST_EMPTY = new Error(112340);
	public static final Error EMP_RECORD_DELETED = new Error(112341);
	public static final Error EMPLOYEE_REF_NUMBER_EXISTS = new Error(11532);
	public static final Error EMP_DESTITUTE_WIDOW_FILE_UPLOAD_SUCCESS = new Error(7080);
	public static final Error DES_NOT_EMPTY = new Error(7081);
	public static final Error JOIN_DATE_NOT_EMPTY = new Error(7082);
	public static final Error RELIEVE_DATE_NOT_EMPTY = new Error(7083);
	public static final Error LAST_DRAWN_SALARY_NOT_EMPTY = new Error(7084);
	public static final Error REASON_FOR_LEAVING_NOT_EMPTY = new Error(7085);
	public static final Error SYS_NOTIFICATION_CONFIG_REQUEST_EMPTY = new Error(112342);
	public static final Error SYS_NOTIFICATION_CONFIG_NOT_FOUND = new Error(112343);
	public static final Error VACANCIES_TO_BE_DISTRIBUTED_REQUIRED = new Error(5100);
	public static final Error FROM_ROSTER_POINT_REQUIRED = new Error(5101);
	public static final Error TO_ROSTER_POINT_REQUIRED = new Error(5102);
	public static final Error PREVIOUS_ROSTER_POINT = new Error(5103);
	public static final Error STAFF_ELIGIBILITY_REQUIRED = new Error(5104);
	public static final Error DESIGNATION_REQUIRED = new Error(5105);
	public static final Error DEPARTMENT_REQUIRED = new Error(5106);
	public static final Error ROSTER_IS_EMPTY = new Error(5107);
	public static final Error ROSTER_LIST_FETCHED_SUCCESSFULLY = new Error(5108);
	public static final Error ROSTER_ID_IS_EMPTY = new Error(5109);
	public static final Error NO_SUCH_ROSTER_FOUND = new Error(5110);
	public static final Error ROSTER_DELETED_SUCCESSFULLY = new Error(5111);
	public static final Error ROSTER_ALREADY_APPROVED_OR_REJECTED = new Error(5112);
	public static final Error ROSTER_APPROVED = new Error(5113);
	public static final Error ROSTER_REJECTED = new Error(5114);
	public static final Error ROSTER_STATUS_REQUIRED = new Error(5115);
	public static final Error INSUFFICIENT_ROSTER_POINT = new Error(5116);
	public static final Error ROSTER_ADDED_SUCCESSFULLY = new Error(5117);
	public static final Error NO_VACANCIES_TO_GEENRATE_ROSTER = new Error(5118);
	public static final Error ROSTER_GENERATED_SUCCESSFULLY = new Error(5119);
	public static final Error CANNOT_GENERATE_ROSTER_NOT_APPROVED = new Error(5120);
	public static final Error CANNOT_DELETE_ROSTER_ASSOCIATED = new Error(5121);
	public static final Error ROSTER_ALREADY_GEENRATED = new Error(5122);
	public static final Error STAFF_ELIGIBILITY_EMPTY = new Error(12000);
	public static final Error STAFF_ELIGIBILITY_STATE_REQ = new Error(12001);
	public static final Error STAFF_ELIGIBILITY_REGION_REQ = new Error(12002);
	public static final Error STAFF_ELIGIBILITY_DEP_REQ = new Error(12003);
	public static final Error STAFF_ELIGIBILITY_DES_REQ = new Error(12004);
	public static final Error STAFF_ELIGIBILITY_SALES_FROM = new Error(12005);
	public static final Error STAFF_ELIGIBILITY_SALES_TO = new Error(12006);
	public static final Error RECRUITMENT_FOR_POST_REQ = new Error(12007);
	public static final Error RECRUITMENT_YEAR_REQ = new Error(12008);
	public static final Error STAFF_ELIGIBILITY_LIST_REQ = new Error(12009);
	public static final Error STAFF_ELIGIBILITY_APPROVED = new Error(12010);
	public static final Error STAFF_ELIGIBILITY_REJECTED = new Error(12011);
	public static final Error STAFF_ELIGIBILITY_STATUS_REQ = new Error(12012);
	public static final Error APPROVED_STAFF_ELIGIBILITY_CANNOT_DELETE = new Error(12013);
	public static final Error STAFF_ELIGIBILITY_DELETED = new Error(12014);
	public static final Error STAFF_ELIGIBILITY_NOT_YET_APPROVED = new Error(12015);
	public static final Error HOLDING_DAYS_FOR_APPROVAL = new Error(12016);
	public static final Error STAFF_ELIGIBILITY_ADDED_SUCCESSFULLY = new Error(12101);
	public static final Error MOTHER_TONGUE_IS_EMPTY = new Error(21001);
	public static final Error MOTHER_TONGUE_NAME_IS_EMPTY = new Error(21002);
	public static final Error MOTHER_TONGUE_L_NAME_IS_EMPTY = new Error(21003);
	public static final Error MOTHER_TONGUE_STATE_IS_EMPTY = new Error(21004);
	public static final Error MOTHER_TONGUE_NAME_LENGTH_VALIDATE = new Error(21005);
	public static final Error MOTHER_TONGUE_L_NAME_LENGTH_VALIDATE = new Error(21006);
	public static final Error MOTHER_TONGUE_NAME_IS_EXISTS = new Error(21007);
	public static final Error MOTHER_TONGUE_L_NAME_IS_EXISTS = new Error(21008);
	public static final Error MOTHER_TONGUE_CREATE_SUCCESS = new Error(21009);
	public static final Error MOTHER_TONGUE_UPDATE_SUCCESS = new Error(21010);
	public static final Error MOTHER_TONGUE_DELETE_SUCCESS = new Error(21011);
	public static final Error MOTHER_TONGUE_GETBYID_SUCCESS = new Error(21012);
	public static final Error MOTHER_TONGUE_GETALL_SUCCESS = new Error(21013);
	public static final Error JOB_APPLICATION_IS_EMPTY = new Error(21014);
	public static final Error JOB_APPLICATION_FIRST_NAME_IS_EMPTY = new Error(21015);
	public static final Error JOB_APPLICATION_LAST_NAME_IS_EMPTY = new Error(21016);
	public static final Error JOB_APPLICATION_APPLIED_POST_IS_EMPTY = new Error(21017);
	public static final Error JOB_APPLICATION_APPLIED_STATE_IS_EMPTY = new Error(21018);
	public static final Error JOB_APPLICATION_FIRST_NAME_LENGTH_VALIDATE = new Error(21019);
	public static final Error JOB_APPLICATION_LAST_NAME_LENGTH_VALIDATE = new Error(21020);
	public static final Error JOB_APPLICATION_MIDDLE_NAME_LENGTH_VALIDATE = new Error(21021);
	public static final Error JOB_APPLICATION_GENDER_IS_EMPTY = new Error(21022);
	public static final Error JOB_APPLICATION_DOB_IS_EMPTY = new Error(21023);
	public static final Error JOB_APPLICATION_AGE_VALIDATION = new Error(21024);
	public static final Error JOB_APPLICATION_MARITAL_STATUS_IS_EMPTY = new Error(21025);
	public static final Error JOB_APPLICATION_FATHER_OR_SPOUSE_IS_EMPTY = new Error(21026);
	public static final Error JOB_APPLICATION_FATHER_OR_SPOUSE_LENGTH_VALIDATE = new Error(21027);
	public static final Error JOB_APPLICATION_MOTHER_NAME_IS_EMPTY = new Error(21028);
	public static final Error JOB_APPLICATION_MOTHER_TONGUE_IS_EMPTY = new Error(21029);
	public static final Error JOB_APPLICATION_MOBILE_NUMBER_IS_EMPTY = new Error(21030);
	public static final Error JOB_APPLICATION_MOBILE_NUMBER_LENGTH_VALIDATE = new Error(21031);
	public static final Error JOB_APPLICATION_PAN_NUMBER_VALIDATE = new Error(21032);
	public static final Error JOB_APPLICATION_EMAIL_ID_IS_EMPTY = new Error(21033);
	public static final Error JOB_APPLICATION_EMAIL_ID_LENGTH_VALIDATE = new Error(21034);
	public static final Error JOB_APPLICATION_MOBILE_NUMBER_VALIDATE = new Error(21035);
	public static final Error JOB_APPLICATION_EMAIL_ID_VALIDATE = new Error(21036);
	public static final Error JOB_APPLICATION_PHOTO_IS_EMPTY = new Error(21037);
	public static final Error JOB_APPLICATION_SIGNATURE_DOC_IS_EMPTY = new Error(21038);
	public static final Error JOB_APPLICATION_AADHAAR_NO_IS_EXISTS = new Error(21039);
	public static final Error JOB_APPLICATION_APPLICATION_NO_IS_EXISTS = new Error(21040);
	public static final Error JOB_APPLICATION_MOBILE_NO_IS_EXISTS = new Error(21041);
	public static final Error JOB_APPLICATION_EMAIL_ID_IS_EXISTS = new Error(21042);
	public static final Error JOB_APPLICATION_AADHAAR_NO_REQUIRED = new Error(21043);
	public static final Error JOB_APPLICATION_AADHAAR_NO_LENGTH_VALIDATE = new Error(21044);
	public static final Error JOB_ADVERTISEMENT_EMPTY = new Error(22000);
	public static final Error JOB_ADVERTISEMENT_CREATED = new Error(22001);
	public static final Error JOB_ADVERTISEMENT_UPDATED = new Error(22002);
	public static final Error JOB_ADVERTISEMENT_ID_NOT_FOUND = new Error(22003);
	public static final Error JOB_ADVERTISEMENT_DELETED = new Error(22004);
	public static final Error JOB_ADVERTISEMENT_REF_NO_EXIST = new Error(22005);
	public static final Error JOB_ADVERTISEMENT_REQ_POST_ID_EMPTY = new Error(22006);
	public static final Error JOB_ADVERTISEMENT_REQ_YEAR_EMPTY = new Error(22007);
	public static final Error JOB_ADVERTISEMENT_DEPARTMENT_EMPTY = new Error(22008);
	public static final Error JOB_ADVERTISEMENT_QUALIFICATION_EMPTY = new Error(22009);
	public static final Error JOB_ADVERTISEMENT_PAYSCALE_EMPTY = new Error(22010);
	public static final Error JOB_ADVERTISEMENT_SC_EXAM_FEE_EMPTY = new Error(22011);
	public static final Error JOB_ADVERTISEMENT_OC_EXAM_FEE_EMPTY = new Error(22012);
	public static final Error JOB_ADVERTISEMENT_OFFLINE_START_DATE_EMPTY = new Error(22013);
	public static final Error JOB_ADVERTISEMENT_OFFLINE_END_DATE_EMPTY = new Error(22014);
	public static final Error JOB_ADVERTISEMENT_ONLINE_START_DATE_EMPTY = new Error(22015);
	public static final Error JOB_ADVERTISEMENT_ONLINE_END_DATE_EMPTY = new Error(22016);
	public static final Error JOB_ADVERTISEMENT_ONLINE_MODIFY_DATE_EMPTY = new Error(22017);
	public static final Error JOB_ADVERTISEMENT_TENTATIVE_HT_DATE_EMPTY = new Error(22018);
	public static final Error JOB_ADVERTISEMENT_TENTATIVE_WRITTEN_EXAM_DATE_EMPTY = new Error(22019);
	public static final Error JOB_ADVERTISEMENT_ROSTER_EMPTY = new Error(22020);
	public static final Error JOB_ADVERTISEMENT_SC_EXAM_FEE = new Error(22021);
	public static final Error JOB_ADVERTISEMENT_OC_EXAM_FEE = new Error(22022);
	public static final Error SELECT_JOB_ADVERTISEMENT_ID = new Error(22023);
	public static final Error JOB_ADVERTISEMENT_APPROVED = new Error(22024);
	public static final Error JOB_ADVERTISEMENT_REJECTED = new Error(22025);
	public static final Error JOB_ADVERTISEMENT_ALREADY_APPROVED_OR_REJECTED = new Error(22026);
	public static final Error JOB_ADVERTISEMENT_STATUS_REQUIRED = new Error(22027);
	public static final Error ACTIVITY_TASK_ID_NOT_FOUND = new Error(22028);
	public static final Error JOB_ADVERTISEMENT_ALREADY_APPROVED = new Error(22029);
	public static final Error JOB_ADVERTISEMENT_ALREADY_REJECTED = new Error(22030);
	public static final Error JOB_ADV_OFFLINE_START_DATE_PAST = new Error(22031);
	public static final Error JOB_ADV_ONLINE_START_DATE_PAST = new Error(22032);
	public static final Error JOB_ADVERTISMENT_REQURIED = new Error(22033);
	public static final Error JOB_ADVERTISEMENT_NOTIFICATION_NO_EXIST = new Error(22034);
	public static final Error JOB_APPL_AD_INFO_IS_EMPTY = new Error(21045);
	public static final Error JOB_APPL_AD_INFO_PRESENT_ADRS_LINE1_REQUIRED = new Error(21046);
	public static final Error JOB_APPL_AD_INFO_PRESENT_ADRS_LINE1_LENGTH_VALIDATE = new Error(21047);
	public static final Error JOB_APPL_AD_INFO_PRESENT_ADRS_LINE2_LENGTH_VALIDATE = new Error(21048);
	public static final Error JOB_APPL_AD_INFO_PRESENT_ADRS_LINE3_LENGTH_VALIDATE = new Error(21049);
	public static final Error JOB_APPL_AD_INFO_PRESENT_STATE_REQUIRED = new Error(21050);
	public static final Error JOB_APPL_AD_INFO_PRESENT_DISTRICT_REQUIRED = new Error(21051);
	public static final Error JOB_APPL_AD_INFO_PRESENT_TALUK_REQUIRED = new Error(21052);
	public static final Error JOB_APPL_AD_INFO_PRESENT_VILLAGE_REQUIRED = new Error(21053);
	public static final Error JOB_APPL_AD_INFO_PRESENT_PIN_CODE_REQUIRED = new Error(21054);
	public static final Error JOB_APPL_AD_INFO_PRESENT_PIN_CODE_LENGTH_VALIDATE = new Error(21055);
	public static final Error JOB_APPL_AD_INFO_PERM_ADRS_LINE1_REQUIRED = new Error(21056);
	public static final Error JOB_APPL_AD_INFO_PERM_ADRS_LINE1_LENGTH_VALIDATE = new Error(21057);
	public static final Error JOB_APPL_AD_INFO_PERM_ADRS_LINE2_LENGTH_VALIDATE = new Error(21058);
	public static final Error JOB_APPL_AD_INFO_PERM_ADRS_LINE3_LENGTH_VALIDATE = new Error(21059);
	public static final Error JOB_APPL_AD_INFO_PERM_STATE_REQUIRED = new Error(21060);
	public static final Error JOB_APPL_AD_INFO_PERM_DISTRICT_REQUIRED = new Error(21061);
	public static final Error JOB_APPL_AD_INFO_PERM_TALUK_REQUIRED = new Error(21062);
	public static final Error JOB_APPL_AD_INFO_PERM_VILLAGE_REQUIRED = new Error(21063);
	public static final Error JOB_APPL_AD_INFO_PERM_PIN_CODE_REQUIRED = new Error(21064);
	public static final Error JOB_APPL_AD_INFO_PERM_PIN_CODE_LENGTH_VALIDATE = new Error(21065);
	public static final Error JOB_APPL_AD_RELIGION_REQUIRED = new Error(21066);
	public static final Error JOB_APPL_AD_COMMUNITY_REQUIRED = new Error(21067);
	public static final Error JOB_APPL_AD_CASTE_REQUIRED = new Error(21068);
	public static final Error JOB_APPL_AD_COMM_CERT_NO_REQUIRED = new Error(21069);
	public static final Error JOB_APPL_AD_COMM_CERT_NO_LENGTH_VALIDATE = new Error(21079);
	public static final Error JOB_APPL_AD_COMM_CERT_ISSUE_DATE_REQUIRED = new Error(21080);
	public static final Error JOB_APPL_AD_COMM_CERT_ISSUE_AUTH_REQUIRED = new Error(21081);
	public static final Error JOB_APPL_AD_COMM_CERT_ISSUE_AUTH_LENGTH_VALIDATE = new Error(21082);
	public static final Error JOB_APPL_AD_COMM_CERT_ISSUE_DISTRICT_REQUIRED = new Error(21083);
	public static final Error JOB_APPL_AD_COMM_CERT_ISSUE_TALUK_REQUIRED = new Error(21084);
	public static final Error JOB_APPLICATION_EMPTY = new Error(8000);
	public static final Error JOB_PRIMARY_EMAIL_INVALID = new Error(9000);
	public static final Error CANDIDATE_PHOTO_NOT_NULL = new Error(8100);
	public static final Error CANDIDATE_SIGN_NOT_NULL = new Error(8101);
	public static final Error CAN_SIG_EMPTY = new Error(8102);
	public static final Error CAN_SIG_UPLOAD_SUCCESS = new Error(8103);
	public static final Error COMMUNITY_CERTIFICATE_NOT_EMPTY = new Error(8105);
	public static final Error COMMUNITY_CERTIFICATE_SUCCESS = new Error(8106);
	public static final Error JOB_APPL_EDU_QUL_REQUIRED = new Error(8111);
	public static final Error JOB_APPL_DATE_PUB_REQUIRED = new Error(8112);
	public static final Error JOB_APPL_ORG_NAME_REQUIRED = new Error(8113);
	public static final Error JOB_APPL_BOARD_UNIVER_REQUIRED = new Error(8114);
	public static final Error JOB_APPL_CER_NUM_REQUIRED = new Error(8115);
	public static final Error JOB_APPL_PER_CGPA_REQUIRED = new Error(8116);
	public static final Error JOB_APPL_ORG_NAME_LENGTH_VALIDATE = new Error(8117);
	public static final Error JOB_APPL_BOARD_UNIVER_LENGTH_VALIDATE = new Error(8119);
	public static final Error JOB_APPL_CERTIFICATE_NO_LENGTH_VALIDATE = new Error(8120);
	public static final Error JOB_APPL_PER_CGPA_LENGTH_VALIDATE = new Error(8121);
	public static final Error JOB_WORK_POSITION_HOLD_REQUIRED = new Error(8122);
	public static final Error JOB_WORK_WORK_FROM_REQUIRED = new Error(8123);
	public static final Error JOB_WORK_WORK_TO_REQUIRED = new Error(8124);
	public static final Error JOB_WORK_NATURE_DUTY_REQUIRED = new Error(8125);
	public static final Error JOB_WORK_POSITION_HOLD_VALIDATE = new Error(8126);
	public static final Error JOB_WORK_NATURE_DUTY_VALIDATE = new Error(8127);
	public static final Error JOB_PAY_DD_NUM_REQUIRED = new Error(8133);
	public static final Error JOB_PAY_BANK_NAME_REQUIRED = new Error(8134);
	public static final Error JOB_PAY_BRANCH_NAME_REQUIRED = new Error(8135);
	public static final Error JOB_PAY_NAME_OF_FAVOR_REQUIRED = new Error(8136);
	public static final Error JOB_PAY_DD_AMOUNT_REQUIRED = new Error(8137);
	public static final Error JOB_PAY_DD_NUM_LENGTH_VALIDATE = new Error(8128);
	public static final Error JOB_PAY_BANK_NAME_LENGTH_VALIDATE = new Error(8129);
	public static final Error JOB_PAY_BRANCH_NAME_LENGTH_VALIDATE = new Error(8130);
	public static final Error JOB_PAY_NAME_OF_FAVOR_LENGTH_VALIDATE = new Error(8131);
	public static final Error JOB_PAY_DD_AMOUNT_LENGTH_VALIDATE = new Error(8132);
	public static final Error JOB_APPLICATION_DD_NUM_IS_EXISTS = new Error(8133);
	public static final Error PSTM_DOC_EMPTY = new Error(8139);
	public static final Error PSTM_DOC_UPLOAD_SUCCESS = new Error(8140);
	public static final Error GOV_DOC_EMPTY = new Error(8141);
	public static final Error GOV_DOC_UPLOAD_SUCCESS = new Error(8142);
	public static final Error EXP_CER_DOC_EMPTY = new Error(8143);
	public static final Error EXP_CER_UPLOAD_SUCCESS = new Error(8144);
	public static final Error CER_DOC_EMPTY = new Error(8145);
	public static final Error CER_UPLOAD_SUCCESS = new Error(8146);
	public static final Error EDU_QUI_SAVED = new Error(8147);
	public static final Error WORK_EXP_SAVED = new Error(8148);
	public static final Error JOB_PRIMARY_SAVED = new Error(8149);
	public static final Error JOB_ADDITIONAL_INFO_SAVED = new Error(8150);
	public static final Error STATE_ID_EMPTY = new Error(8151);
	public static final Error DISTRICT_ID_IS_EMPTY = new Error(8152);
	public static final Error TALUK_ID_IS_EMPTY = new Error(8153);
	public static final Error EDU_QUL_ID_NOT_EXISTS = new Error(8154);
	public static final Error WORK_EXP_ID_NOT_EXISTS = new Error(8155);
	public static final Error DD_NUM_EMPTY = new Error(8156);
	public static final Error DD_NUN_UPLOAD_SUCCESS = new Error(8157);
	public static final Error JOB_OTHER_SAVED_SUCCESS = new Error(8158);
	public static final Error JOB_PAYMENT_SAVED_SUCCESS = new Error(8159);
	public static final Error DIS_WIDOW_EMPTY = new Error(8160);
	public static final Error DIS_WIDOW_UPLOAD_SUCCESS = new Error(8161);
	public static final Error EX_SERVICEMAN_EMPTY = new Error(8162);
	public static final Error EX_SERVICEMAN_ERROR = new Error(8163);
	public static final Error PRIORITY_EMPTY = new Error(8164);
	public static final Error PRIORITY_UPLOAD_SUCCESS = new Error(8165);
	public static final Error PHYSICALLY_CHALLENGED_EMPTY = new Error(8166);
	public static final Error PHYSICALLY_CHALLENGED_UPLOAD_SUCCESS = new Error(8167);
	public static final Error CER_NUM_LENGTH_VALIDATE = new Error(8168);
	public static final Error ISS_AUT_LENGTH_VALIDATE = new Error(8169);
	public static final Error REQUEST_OBJECT_SHOULD_NOT_EMPTY = new Error(1800);
	public static final Error PRODUCT_VARIETY_LIST_EMPTY = new Error(1801);
	public static final Error INFO_PRODUCT_VARIETY_MASTER_DELETED = new Error(1802);
	public static final Error UOM_MASTER_SHOULD_NOT_EMPTY = new Error(1804);
	public static final Error PRODUCT_VARIETY_CODE_VALID_LENGTH = new Error(1805);
	public static final Error PRODUCT_VARIETY_NAME_VALID_LENGTH = new Error(1806);
	public static final Error PRODUCT_VARIETY_LOCAL_NAME_VALID_LENGTH = new Error(1807);
	public static final Error CALCULATE_VARIETY_LENGTH_TOLARANCE_VALUE = new Error(1808);
	public static final Error CALCULATE_VARIETY_WIDTH_TOLARANCE_VALUE = new Error(1809);
	public static final Error CALCULATE_VARIETY_PICK_PER_TOLARANCE_VALUE = new Error(1810);
	public static final Error CALCULATE_VARIETY_END_PER_TOLARANCE_VALUE = new Error(1811);
	public static final Error PRODUCT_VARIETY_VARIETY_MASTER_ADD = new Error(1812);
	public static final Error PRODUCT_VARIETY_ACTUAL_LENGTH = new Error(1813);
	public static final Error PRODUCT_VARIETY_ACTUAL_WIDTH = new Error(1814);
	public static final Error PRODUCT_VARIETY_REEDS_PICK_ACTUAL = new Error(1815);
	public static final Error PRODUCT_VARIETY_REEDS_ENDS_ACTUAL = new Error(1816);
	public static final Error PRODUCT_VARIETY_ACTUAL_LENGTH_UNIT_OF_MEASUREMENT = new Error(1817);
	public static final Error PRODUCT_VARIETY_ACTUAL_WIDTH_UNIT_OF_MEASUREMENT = new Error(1818);
	public static final Error PRODUCT_VARIETY_WEFT_YARN_WEIGHT = new Error(1819);
	public static final Error PRODUCT_VARIETY_WARP_YARN_WEIGHT = new Error(1820);
	public static final Error PRODUCT_VARIETY_ENTER_WARP_YARN_WEIGHT = new Error(1821);
	public static final Error PRODUCT_VARIETY_ENTER_WARP_YARN_TYPE = new Error(1822);
	public static final Error PRODUCT_VARIETY_ENTER_WEFT_YARN_WEIGHT = new Error(1823);
	public static final Error PRODUCT_VARIETY_ENTER_WEFT_YARN_TYPE = new Error(1824);
	public static final Error PRODUCT_VARIETY_VARIETY_MASTER_EDIT = new Error(1825);
	public static final Error HALL_TICKET_REQUIRED = new Error(21500);
	public static final Error SELECTED_NOMINAL_IS_EMPTY = new Error(21501);
	public static final Error NOMINAL_DETAILS_IS_EMPTY = new Error(21515);
	public static final Error NOMINAL_LIST_EMPTY = new Error(21516);
	public static final Error SELECTED_HALL_TICKET_IS_EMPTY = new Error(21517);
	public static final Error SELECTED_APPLIED_POST_IS_EMPTY = new Error(21518);
	public static final Error NOMINAL_IS_NOT_APPROVED = new Error(21519);
	public static final Error NOMINAL_IS_ALREADY_APPROVED = new Error(21520);
	public static final Error NOMINAL_APPROVED_SUCCESSFULLY = new Error(21521);
	public static final Error NOMINAL_IS_ALREADY_EXIST = new Error(21580);
	public static final Error NOMINAL_DETAILS_NOTIFICATION_IS_EMPTY = new Error(21522);

	public static final Error RECORD_APPROVED = new Error(21504);
	public static final Error RECORD_REJECTED = new Error(21505);
	public static final Error SELECT_RECORD = new Error(21506);
	public static final Error INPROGRESS_ROSTER = new Error(21507);
	public static final Error REJECTED_ROSTER = new Error(21508);
	public static final Error PHOTO_SIZE_INVALID = new Error(21510);
	public static final Error APPROVED_RECORD_CANOT_DELETE = new Error(21511);
	public static final Error COMMUNITY_CER_IS_EXISTS = new Error(8170);
	public static final Error APP_NUM_IS_EXISTS = new Error(8171);
	public static final Error ERROR_PURCHASE_INVOICE_REQUEST_NULL = new Error(5061);
	public static final Error ERROR_PURCHASE_INVOICE_NULL = new Error(5062);
	public static final Error ERROR_PURCHASE_INVOICE_ITEMS_NULL = new Error(5063);
	public static final Error ERROR_PURCHASE_INVOICE_ISSUED_PRODUCTWARE_HOUSE_NULL = new Error(5064);
	public static final Error ERROR_PURCHASE_INVOICE_ISSUED_PRODUCTWARE_HOUSE_NOT_FOUND = new Error(5065);
	public static final Error ERROR_PURCHASE_INVOICE_SUPPLIER_NULL = new Error(5066);
	public static final Error ERROR_PURCHASE_INVOICE_SUPPLIER_NOT_FOUND = new Error(5067);
	public static final Error ERROR_PURCHASE_INVOICE_INWARD_NUMBER_NULL = new Error(5068);
	public static final Error ERROR_PURCHASE_INVOICE_INWARD_NUMBER_NOT_FOUND = new Error(5069);
	public static final Error ERROR_PURCHASE_INVOICE_EMPTY_STOCK_INWARD_LIST = new Error(5070);
	public static final Error ERROR_PURCHASE_INVOICE_EMPTY_PRODUCT_WAREHOUSES_LIST = new Error(5071);
	public static final Error ERROR_PURCHASE_INVOICE_EMPTY_DNP_OFFICES_LIST = new Error(5072);
	public static final Error ERROR_PURCHASE_INVOICE_EMPTY_PRODUCT_LIST = new Error(5073);
	public static final Error INFO_PURCHASE_INVOICE_SUBMITTED_SUCCESSFULLY = new Error(5074);
	public static final Error INFO_PURCHASE_INVOICE_APPROVED_SUCCESSFULLY = new Error(5075);
	public static final Error GL_ACCOUNT_GROUP_NAME_CANNOT_BE_EMPTY = new Error(114484);
	public static final Error GL_ACCOUNT_GROUP_CODE_CANNOT_BE_EMPTY = new Error(114485);
	public static final Error GL_ACCOUNT_GROUP_REGION_NAME_CANNOT_BE_EMPTY = new Error(114486);
	public static final Error PLEASE_SELECT_GL_ACCOUNT_CATEGORY = new Error(114487);
	public static final Error GL_ACCOUNT_GROUP_LOCALNAME_ALREADY_EXISTS = new Error(114488);
	public static final Error GL_ACCOUNT_GROUP_NAME_DOES_NOT_EXISTS = new Error(114489);
	public static final Error GL_ACCOUNT_GROUP_ID_CANNOT_BE_EMPTY = new Error(114490);
	public static final Error GL_ACCOUNT_GROUP_CODE_SHOULD_NOT_BE_DUPLICATE = new Error(114491);
	public static final Error GL_ACCOUNT_GROUP_ID_IS_DOES_NOT_EXISTS = new Error(114492);
	public static final Error GL_ACCOUNT_GROUP_PARENT_ID_SHOULD_NOT_BE_NULL = new Error(114493);
	public static final Error GL_ACCOUNT_GROUP_OBJECT_SHOULD_NOT_BE_NULL = new Error(114550);

	public static final Error GL_ACCOUNT_HEAD_NAME_EMPTY = new Error(2202);
	public static final Error GL_ACCOUNT_HEAD_CODE_EMPTY = new Error(2201);
	public static final Error GL_ACCOUNT_HEAD_LOCAL_NAME_EMPTY = new Error(2203);
	public static final Error GL_ACCOUNT_HEAD_NOT_SELECTED = new Error(2204);
	public static final Error GL_ACCOUNT_HEAD_CREATE_SUCCESS = new Error(2205);
	public static final Error GL_ACCOUNT_HEAD_UPDATE_SUCCESS = new Error(2206);
	public static final Error GL_ACCOUNT_HEAD_CODE_EXISTS = new Error(2207);
	public static final Error GL_ACCOUNT_HEAD_LOCAL_NAME_EXISTS = new Error(2208);
	public static final Error GL_ACCOUNT_HEAD_SHORT_NAME_EXISTS = new Error(2209);
	public static final Error GL_ACCOUNT_HEAD_SHORT_NAME_EMPTY = new Error(2210);
	public static final Error GL_ACCOUNT_HEAD_NAME_EXISTS = new Error(2211);
	public static final Error GL_ACCOUNT_HEAD_SELECT_CATEGORY = new Error(2212);
	public static final Error GL_ACCOUNT_HEAD_SELECT_GROUP = new Error(2213);
	public static final Error GL_ACCOUNT_HEAD_SELECT_ONE_RECORD = new Error(2214);
	public static final Error GL_ACCOUNT_HEAD_RECORD_USING = new Error(2215);

	public static final Error GL_ACCOUNT_CATEGORY_SAVE_SUCCESS = new Error(9315);
	public static final Error GL_ACCOUNT_CATEGORY_UPDATE_SUCCESS = new Error(9316);
	public static final Error GL_ACCOUNT_CATEGORY_DELETE_SUCCESS = new Error(9317);
	public static final Error GL_ACCOUNT_CATEGORY_SELECT = new Error(9318);
	public static final Error GL_ACCOUNT_CATEGORY_NAME_EMPTY = new Error(9320);
	public static final Error GL_ACCOUNT_CATEGORY_NAME_MIN_MAX_ERROR = new Error(9321);
	public static final Error GL_ACCOUNT_CATEGORY_STATUS_EMPTY = new Error(9322);
	public static final Error GL_ACCOUNT_CATEGORY_LNAME_EMPTY = new Error(9323);
	public static final Error GL_ACCOUNT_CATEGORY_LNAME_MIN_MAX_ERROR = new Error(9324);
	public static final Error GL_ACCOUNT_NOT_FOUND = new Error(9325);
	public static final Error GL_ACCOUNT_IS_NULL = new Error(9326);
	public static final Error GL_ACCOUNT_CATEGORY_EMPTY = new Error(9327);
	public static final Error GL_ACCOUNT_CATEGORY_ID_EMPTY = new Error(9328);
	public static final Error GL_ACCOUNT_CATEGORY__NAME_EMPTY = new Error(9329);
	public static final Error GL_ACCOUNT_CATEGORY_LOCAL_NAME_EMPTY = new Error(9330);
	public static final Error GL_ACCOUNT_CATEGORY_CODE_EMPTY = new Error(9331);
	public static final Error GL_ACCOUNT_CATEGORY_VERSION_EMPTY = new Error(9332);
	public static final Error GL_ACCOUNT_CATEGORY_CODE_EXISTS = new Error(9314);
	public static final Error GL_ACCOUNT_CATEGORY_NAME_EXISTS = new Error(9313);
	public static final Error GL_ACCOUNT_CATEGORY_LOCAL_NAME_EXISTS = new Error(9312);

	public static final Error MARITALSTATUS_EMPTY = new Error(9333);
	public static final Error MARITALSTATUS__NAME_EMPTY = new Error(9334);
	public static final Error MARITALSTATUS_LOCAL_NAME_EMPTY = new Error(9335);
	public static final Error MARITALSTATUS_STATUS_EMPTY = new Error(9336);
	public static final Error MARITALSTATUS_IS_NULL = new Error(9337);
	public static final Error MARITALSTATUS_NOT_FOUND = new Error(9338);
	public static final Error MARITALSTATUS_SELECT = new Error(9339);
	public static final Error MARITALSTATUS_LNAME_MIN_MAX_ERROR = new Error(9340);
	public static final Error MARITALSTATUS_SAVE_SUCCESS = new Error(9341);
	public static final Error MARITALSTATUS_UPDATE_SUCCESS = new Error(9342);
	public static final Error MARITALSTATUS_DELETE_SUCCESS = new Error(9343);
	public static final Error MARITALSTATUS_NAME_EMPTY = new Error(9344);
	public static final Error MARITALSTATUS_LOCALNAME_EMPTY = new Error(9345);

	public static final Error ACCOUNT_TRANSACTION_CANNOT_BE_EMPTY = new Error(24561);
	public static final Error ACCOUNT_TRANSACTION_NAME_CANNOT_BE_EMPTY = new Error(24562);
	public static final Error ACCOUNT_TRANSACTION_DETAILS_CANNOT_BE_EMPTY = new Error(24563);
	public static final Error ACCOUNT_TRANSACTION_DETAILS_SEQUENCE_CANNOT_BE_EMPTY = new Error(24564);
	public static final Error ACCOUNT_TRANSACTION_DETAILS_LEDGER_CANNOT_BE_EMPTY = new Error(24565);
	public static final Error ACCOUNT_TRANSACTION_DETAILS_AMOUNT_CANNOT_BE_EMPTY = new Error(24566);
	public static final Error ACCOUNT_TRANSACTION_DETAILS_ACCASPECT_CANNOT_BE_EMPTY = new Error(24567);
	public static final Error ERROR_ORAL_EXAM_VENUE_NAME = new Error(32000);
	public static final Error ERROR_CONTACT_NUMBER = new Error(32001);
	public static final Error ERROR_ADDRESS_LINE_ONE = new Error(32002);
	public static final Error ERROR_PINCODE = new Error(32003);
	public static final Error ORAL_EXAM_VENUE_ROCORD_CEATED = new Error(32004);
	public static final Error ORAL_EXAM_VENUE_ROCORD_UPDATED = new Error(32005);
	public static final Error ORAL_EXAM_VENUE_ROCORD_DELETED = new Error(32006);
	public static final Error ORAL_EXAM_VENUE_ROCORD_FOUND = new Error(32007);
	public static final Error ORAL_EXAM_VENUE_ROCORD_NOT_FOUND = new Error(32008);
	public static final Error EMAIL_EXIST = new Error(32009);
	public static final Error ORAL_EXAM_VENUE_NAME_EXIST = new Error(32010);
	public static final Error CONTACT_NO_EXIST = new Error(32011);
	public static final Error ORAL_EXAM_VENUE_NOT_FOUND = new Error(32012);
	public static final Error ORAL_EXAM_VENUE_NO_OF_SEATS = new Error(32013);
	public static final Error JOB_NOTIFICATION_NO_NOT_FOUND = new Error(32014);
	public static final Error ORAL_EXAM_VENUE_REGION_NOT_FOUND = new Error(32015);
	public static final Error STATE_NOT_FOUND = new Error(32016);
	public static final Error DISTRICT_NOT_FOUND = new Error(32017);
	public static final Error ORAL_EXAM_VENUE_APPROVED = new Error(32018);
	public static final Error ORAL_EXAM_VENUE_REJECTED = new Error(32019);
	public static final Error ORAL_EXAM_VENUE_ALREADY_APPROVED = new Error(32020);
	public static final Error ORAL_EXAM_VENUE_ALREADY_REJECTED = new Error(32021);
	public static final Error ORAL_EXAM_VENUE_NAME_AND_EXAM_DATE_EXIST = new Error(32022);
	public static final Error EDU_QUA_PER = new Error(8888);
	public static final Error EX_SERVICE_MAN_UPLOAD_SUCCESSFULLY = new Error(8899);
	public static final Error EDU_UPLOAD_DOC = new Error(8889);
	public static final Error WRITTEN_EXAM_MARKLIST_EMPTY = new Error(90000);
	public static final Error WRITTEN_EXAM_DATE_EMPTY = new Error(90001);
	public static final Error WRITTEN_EXAM_REGISTER_NO_IS_REQUIRED = new Error(90002);
	public static final Error WRITTEN_EXAM_CANDIDATE_NAME_IS_REQUIRED = new Error(90003);
	public static final Error WRITTEN_EXAM_MARK_IS_REQUIRED = new Error(90004);
	public static final Error WRITTEN_EXAM_RANK_IS_REQUIRED = new Error(90005);
	public static final Error JOB_APLLICATION_NOT_AVAILABLE = new Error(90006);
	public static final Error WRITTEN_EXAM_MARK_SUCCESSFULLY_ADDED = new Error(90007);
	public static final Error WRITTEN_EXAM_MARK_ERROR = new Error(90008);
	public static final Error PRI_MASTER_EMPTY = new Error(8869);
	public static final Error PRI_CRI_NUMNER_EMPTY = new Error(8879);
	public static final Error PRI_DATE_OF_ISSUE_EMPTY = new Error(8859);
	public static final Error PRI_ISSUEING_AUT_EMPTY = new Error(8839);
	public static final Error DIF_ABLED_EMPTY = new Error(8829);
	public static final Error PERCENTAGE_DISABL_EMPTY = new Error(8898);
	public static final Error DIFABLED_CER_EMPTY = new Error(8878);
	public static final Error DIFABLED_DATE_OF_ISSUE_EMPTY = new Error(8868);
	public static final Error PRE_DIS_PERCENTAGE = new Error(8858);
	public static final Error DES_CER_NUM_EMPTY = new Error(8828);
	public static final Error DES_DATE_OF_ISSUE_EMPTY = new Error(8908);
	public static final Error DES_ISSUEING_AUT_EMPTY = new Error(8708);
	public static final Error WRITTEN_EXAM_NO_RECORDS = new Error(90009);

	public static final Error EMPTY_EXCEL_UPLOADED = new Error(90010);
	public static final Error EX_SERVICE_DATE_OF_ISS_EMPTY = new Error(8408);
	public static final Error EX_SERVICE_ISS_AUTHORITY_EMPTY = new Error(8308);
	public static final Error DIFABLED_ISSUEING_AUTOR_EMPTY = new Error(8208);
	public static final Error EX_SERVICE_CER_EMPTY = new Error(8608);
	public static final Error WRITTEN_EXAM_RECORDS_UPLOAD_SUCESS = new Error(90011);
	public static final Error SELECT_WRIITEN_EXAM = new Error(90012);
	public static final Error APPROVED_WRIITEN_EXAM_LIST_CANNOT_DELETE = new Error(90013);
	public static final Error JOB_APPLICATION_DUPLICATE_REGISTER_NO = new Error(90014);
	public static final Error ORAL_SELECTION_EMPTY = new Error(90100);
	public static final Error ORAL_SELECTION_SUMMARY_REQUIRED = new Error(90101);
	public static final Error ORAL_SELECTION_STATUS_REQUIRED = new Error(90102);
	public static final Error ORAL_SELECTION_ID_REQUIRED = new Error(90103);
	public static final Error ORAL_SELECTION_NOT_FOUND = new Error(90104);
	public static final Error ORAL_SELECTION_ADDED_SUCCESSFULLY = new Error(90105);
	public static final Error ORAL_SELECTION_APPROVED_SUCCESSFULLY = new Error(90106);
	public static final Error ORAL_SELECTION_FETCHED_SUCCESSFULLY = new Error(90107);
	public static final Error ORAL_SELECTION_DELETED_SUCCESSFULLY = new Error(90108);
	public static final Error ORAL_SELECTION_GENERATED_SUCCESSFULLY = new Error(90109);
	public static final Error ORAL_SELECTION_MAPPED_ALREADY = new Error(90110);
	public static final Error ORAL_SELECTION_ALREADY_APPROVED = new Error(90111);
	public static final Error ORAL_SELECTION_ALREADY_GENERATED = new Error(90112);
	public static final Error NO_CANDIDATES_SATISFY_CRITERIA = new Error(90113);
	public static final Error BANKMASTER_OBJECT_SHOULD_NOT_BE_NULL = new Error(225550);
	public static final Error BANKMASTER_BANK_CODE_CANNOT_BE_EMPTY = new Error(225551);
	public static final Error BANKMASTER_BANK_NAME_CANNOT_BE_EMPTY = new Error(225552);
	public static final Error BANKMASTER_ACTIVE_STATUS_CANNOT_BE_EMPTY = new Error(225553);
	public static final Error BANK_BRANCH_MASTER_BRANCH_CODE_REQUIRED = new Error(245550);
	public static final Error BANK_BRANCH_MASTER_BRANCH_NAME_REQUIRED = new Error(245551);
	public static final Error BANK_BRANCH_MASTER_BRANCH_LNAME_REQUIRED = new Error(245552);
	public static final Error BANK_BRANCH_MASTER_ACTIVE_STATUS_REQUIRED = new Error(245553);
	public static final Error BANK_BRANCH_MASTER_IFSC_CODE_REQUIRED = new Error(245554);
	public static final Error BANK_BRANCH_MASTER_CREATED_BY_REQUIRED = new Error(245555);
	public static final Error BANK_BRANCH_MASTER_MODIFIED_BY_REQUIRED = new Error(245556);
	public static final Error BANK_BRANCH_MASTER_BANK_MASTER_REQUIRED = new Error(245557);
	public static final Error BANK_BRANCH_MASTER_ADDRESS_REQUIRED = new Error(245558);
	public static final Error BANK_BRANCH_MASTER_CADDED_SUCCESSFULLY = new Error(245559);
	public static final Error BANK_BRANCH_MASTER_UPDATED_SUCCESSFULLY = new Error(245560);
	public static final Error BANK_BRANCH_MASTER_DELETED_SUCCESSFULLY = new Error(245561);
	public static final Error BANK_BRANCH_MASTER_FETCHED_SUCCESSFULLY = new Error(245562);
	public static final Error BANK_BRANCH_MASTER_DOES_NOT_EXIST = new Error(245563);
	public static final Error BANK_BRANCH_MASTER_BRANCH_CODE_ALREADY_EXISTS = new Error(245564);
	public static final Error BANK_BRANCH_MASTER_NO_RECORDS_FOUND = new Error(245565);
	public static final Error OTCL_ISNULL = new Error(21581);
	public static final Error OTCL_APPLIED_POST_ID_ISNULL = new Error(21582);
	public static final Error OTCL_ID_ISNULL = new Error(21583);
	public static final Error ENTITY_MASTER_ID_ISNULL = new Error(21584);
	public static final Error SELECT_NOTIFICATION_NO = new Error(21585);
	public static final Error REQ_YEAR_IS_EMPTY = new Error(21586);
	public static final Error REQ_POST_IS_EMPTY = new Error(21587);
	public static final Error SELECT_OT_LOC = new Error(21588);
	public static final Error SELECT_OT_VENUE = new Error(21589);
	public static final Error OTCL_APP_NO_ISEMPTY = new Error(21590);
	public static final Error OTCL_REG_NO_ISEMPTY = new Error(21591);
	public static final Error OTCL_CAND_NAME_IS_EMPTY = new Error(21592);
	public static final Error OTCL_CAND_F_NAME_IS_EMPTY = new Error(21593);
	public static final Error OTCL_APPL_POST_IS_EMPTY = new Error(21594);
	public static final Error OTCL_VENUE_IS_EMPTY = new Error(21595);
	public static final Error OTCL_TIME_SLOT_IS_EMPTY = new Error(21596);
	public static final Error OTCL_WR_EXAM_DT_IS_EMPTY = new Error(21597);
	public static final Error OTCL_COMMUNITY_IS_EMPTY = new Error(21598);
	public static final Error OTCL_DOB_IS_EMPTY = new Error(21599);
	public static final Error OTCL_NOTIFY_NO_IS_EMPTY = new Error(21600);
	public static final Error OTCL_APP_NO_EXISTS = new Error(21601);
	public static final Error OTCL_REG_NO_EXISTS = new Error(21602);
	public static final Error OTCL_SAVED_SUCCESS = new Error(21603);
	public static final Error INSUFFICIENT_ORAL_TEST_VENUE = new Error(21604);
	public static final Error OTCL_VENUE_LIST_IS_EMPTY = new Error(21605);
	public static final Error CONSOLIDATED_MARKS_ID_NOT_FOUND = new Error(6666);
	public static final Error SELECT_DEPARTMENT = new Error(23500);

	public static final Error ACTIVE_DEPARTMENT_CANNOT_DELETE = new Error(23501);
	public static final Error DEPARTMENT_NAME_EMPTY = new Error(23502);
	public static final Error DEPARTMENT_LNAME_EMPTY = new Error(23503);
	public static final Error DEPARTMENT_STATUS_EMPTY = new Error(23504);
	public static final Error DEPARTMENT_EMPTY = new Error(23505);
	public static final Error DEPARTMENT_NAME_MIN_MAX_ERROR = new Error(23506);
	public static final Error DEPARTMENT_LNAME_MIN_MAX_ERROR = new Error(23507);
	public static final Error DEPARTMENT_SAVE_SUCCESS = new Error(23508);
	public static final Error DEPARTMENT_UPDATE_SUCCESS = new Error(23509);
	public static final Error DEPARTMENT_DELETE_SUCCESS = new Error(23510);
	public static final Error DEPARTMENT_NAME_ALREADY_EXIST = new Error(23511);
	public static final Error DEPARTMENT_LNAME_ALREADY_EXIST = new Error(23512);
	public static final Error DEPARTMENT_NOT_FOUND = new Error(23515);
	public static final Error DEPARTMENT_CODE_ALREADY_EXIST = new Error(23516);
	public static final Error DESIGNATION_NOT_FOUND = new Error(23520);
	public static final Error DESIGNATION_NAME_EMPTY = new Error(23521);
	public static final Error DESIGNATION_LNAME_EMPTY = new Error(23522);
	public static final Error DESIGNATION_STATUS_EMPTY = new Error(23523);
	public static final Error DESIGNATION_EMPTY = new Error(23524);
	public static final Error DESIGNATION_NAME_MIN_MAX_ERROR = new Error(23525);
	public static final Error DESIGNATION_LNAME_MIN_MAX_ERROR = new Error(23526);
	public static final Error DESIGNATION_SAVE_SUCCESS = new Error(23527);
	public static final Error DESIGNATION_UPDATE_SUCCESS = new Error(23528);
	public static final Error DESIGNATION_DELETE_SUCCESS = new Error(23529);
	public static final Error DESIGNATION_NAME_ALREADY_EXIST = new Error(23530);
	public static final Error DESIGNATION_LNAME_ALREADY_EXIST = new Error(23531);
	public static final Error SELECT_DESIGNATION = new Error(23532);
	public static final Error DESIGNATION_CODE_ALREADY_EXIST = new Error(23533);
	public static final Error DESIGNATION_PROMOTION_PERIOD_BETWEEN_ONE_TO_TEN_YEARS = new Error(235340);
	public static final Error SECTION_NOT_FOUND = new Error(23534);
	public static final Error SECTION_NAME_EMPTY = new Error(23535);
	public static final Error SECTION_LNAME_EMPTY = new Error(23536);
	public static final Error SECTION_STATUS_EMPTY = new Error(23537);
	public static final Error SECTION_EMPTY = new Error(23538);
	public static final Error SECTION_NAME_MIN_MAX_ERROR = new Error(23539);
	public static final Error SECTION_LNAME_MIN_MAX_ERROR = new Error(23540);
	public static final Error SECTION_SAVE_SUCCESS = new Error(23541);
	public static final Error SECTION_UPDATE_SUCCESS = new Error(23542);
	public static final Error SECTION_DELETE_SUCCESS = new Error(23543);
	public static final Error SECTION_NAME_ALREADY_EXIST = new Error(23544);
	public static final Error SECTION_LNAME_ALREADY_EXIST = new Error(23545);
	public static final Error SELECT_SECTION = new Error(23546);
	public static final Error SECTION_CODE_ALREADY_EXIST = new Error(23547);
	public static final Error EMPLOYMENT_TYPE_NOT_FOUND = new Error(23548);
	public static final Error EMPLOYMENT_TYPE_NAME_EMPTY = new Error(23549);
	public static final Error EMPLOYMENT_TYPE_LNAME_EMPTY = new Error(23550);
	public static final Error EMPLOYMENT_TYPE_STATUS_EMPTY = new Error(23551);
	public static final Error EMPLOYMENT_TYPE_EMPTY = new Error(23552);
	public static final Error EMPLOYMENT_TYPE_NAME_MIN_MAX_ERROR = new Error(23553);
	public static final Error EMPLOYMENT_TYPE_LNAME_MIN_MAX_ERROR = new Error(23554);
	public static final Error EMPLOYMENT_TYPE_SAVE_SUCCESS = new Error(23555);
	public static final Error EMPLOYMENT_TYPE_UPDATE_SUCCESS = new Error(23556);
	public static final Error EMPLOYMENT_TYPE_DELETE_SUCCESS = new Error(23557);
	public static final Error EMPLOYMENT_TYPE_NAME_ALREADY_EXIST = new Error(23558);
	public static final Error EMPLOYMENT_TYPE_LNAME_ALREADY_EXIST = new Error(23559);
	public static final Error SELECT_EMPLOYMENT_TYPE = new Error(23560);
	public static final Error EMPLOYMENT_TYPE_CODE_ALREADY_EXIST = new Error(23561);
	public static final Error CITY_EMPTY = new Error(225554);
	public static final Error CITY_RETRIEVED_SUCCESSFULLY = new Error(225555);
	public static final Error AREA_EMPTY = new Error(225556);
	public static final Error AREA_RETRIEVED_SUCCESSFULLY = new Error(225557);
	public static final Error ORAL_EXAM_ERROR = new Error(6669);
	public static final Error CONSOLIDATED_SAVED_SUCCUSSFULLY = new Error(6699);
	public static final Error CONSOLIDATED_UPDATED_SUCCUSSFULLY = new Error(6999);
	public static final Error CONSOLIDATED_DELETED_SUCCESSFULLY = new Error(6990);
	public static final Error JOB_APPLICATION_SALUTATION_IS_EMPTY = new Error(6996);
	public static final Error SALES_QUOTATION_DELETED_SUCCESSFULLY = new Error(78052);
	public static final Error SALES_QUOTATION_APPROVED_SUCCESSFULLY = new Error(78053);
	public static final Error SALES_QUOTATION_REJECTED_SUCCESSFULLY = new Error(78054);
	public static final Error PLEASE_SELECT_ANY_ONE = new Error(78055);

	// Amount To Bank
	public static final Error CASH_MOVEMENT_NOT_FOUND = new Error(78056);

	public static final Error VOUCHER_REQUEST_IS_NULL = new Error(5076);
	public static final Error VOUCHER_SUPPLIER_TYPE_IS_REQUIRED = new Error(5077);
	public static final Error VOUCHER_FROM_DATE_IS_REQUIRED = new Error(5078);
	public static final Error VOUCHER_TO_DATE_IS_REQUIRED = new Error(5079);
	public static final Error VOUCHER_PAYMENT_MODE_IS_REQUIRED = new Error(5080);
	public static final Error VOUCHER_SUPPLIER_DETAILS_IS_REQUIRED = new Error(5081);
	public static final Error VOUCHER_INVOICE_DETAILS_IS_REQUIRED = new Error(5082);
	public static final Error VOUCHER_SUBMITTED_SUCCESSFULLY = new Error(5083);
	public static final Error VOUCHER_APPROVED_SUCCESSFULLY = new Error(5084);
	public static final Error VOUCHER_REJECTED_SUCCESSFULLY = new Error(5085);
	public static final Error VOUCHER_DELETED_SUCCESSFULLY = new Error(5086);
	public static final Error VOUCHER_REFERENCE_NUMBER_PREFIX_REQUIRED = new Error(5087);
	public static final Error VOUCHER_REFERENCE_NUMBER_REQUIRED = new Error(5088);
	public static final Error VOUCHER_NOT_FOUND = new Error(5089); // CustomerMaster
	public static final Error CUST_CODE_REQUIRED = new Error(2220);
	public static final Error CUST_CODE_EXISTS = new Error(2221);
	public static final Error CUST_NAME_REQUIRED = new Error(2222);
	public static final Error CUST_NAME_EXISTS = new Error(2223);
	public static final Error CUST_GSTIN_REQUIRED = new Error(2224);
	public static final Error CUST_GSTIN_EXISTS = new Error(2225);
	public static final Error CUST_ADDRESS_REQUIRED = new Error(2226);
	public static final Error CUST_ADDRESS_EXISTS = new Error(2227);
	public static final Error CUST_REGISTRATION_DATE_REQUIRED = new Error(2228);
	public static final Error CUST_STATUS_REQUIRED = new Error(2229);
	public static final Error CUST_CREDIT_ALLOW_REQUIRED = new Error(2230);
	public static final Error CUST_INSTALLMENT_REQUIRED = new Error(2231);
	public static final Error CUST_CREADIT_LIMIT_REQUIRED = new Error(2232);
	public static final Error CUST_INTEREST_APPLICABLE_REQUIRED = new Error(2233);
	public static final Error CUST_INTEREST_PERCENTAGE_REQUIRED = new Error(2234);
	public static final Error CUST_RETURN_ALLOW_REQUIRED = new Error(2235);
	public static final Error CUST_BANK_NAME_REQUIRED = new Error(2236);
	public static final Error CUST_BRANCH_NAME_REQUIRED = new Error(2237);
	public static final Error CUST_IFSC_REQUIRED = new Error(2238);
	public static final Error CUST_ACCOUNT_NUM_REQUIRED = new Error(2239);
	public static final Error CUST_CONTACT_PERSON_REQUIRED = new Error(2240);
	public static final Error CUST_CONTACT_NUMBER_REQUIRED = new Error(2241);
	public static final Error CUST_EMAIL_REQUIRED = new Error(2242);
	public static final Error CUST_BILLING_ADDRESS_REQUIRED = new Error(2244);
	public static final Error CUST_SHIPPING_ADDRESS_REQUIRED = new Error(2245);
	public static final Error CUST_CREATE_SUCCESS = new Error(2246);
	public static final Error CUST_EDIT_SUCCESS = new Error(2247);
	public static final Error CUST_SELECT_ONE = new Error(2248);
	public static final Error CUST_BUSINESS_TYPE_REQUIRED = new Error(2249);
	public static final Error CUST_CUSTOMER_TYPE_REQUIRED = new Error(2250);
	public static final Error SUPPLIER_MASTER_SHOULD_NOT_BE_EMPTY = new Error(114570);
	public static final Error SUPPLIER_MASTER_PARENET_ID_SHOULD_NOT_BE_EMPTY = new Error(114571);
	public static final Error SUPPLIER_MASTER_BUSINESS_TYPE_MASTER_ID_SHOULD_NOT_BE_EMPTY = new Error(114572);
	public static final Error SUPPLIER_MASTER_SUPPLIER_TYPE_MASTER_ID_SHOULD_NOT_BE_EMPTY = new Error(114573);
	public static final Error SUPPLIER_MASTER_BANK_MASTER_ID_SHOULD_NOT_BE_EMPTY = new Error(114574);
	public static final Error SUPPLIER_MASTER_USER_MASTER_ID_SHOULD_NOT_BE_EMPTY = new Error(114575);
	public static final Error SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_EMPTY = new Error(114576);
	public static final Error SUPPLIER_MASTER_CODE_SHOULD_NOT_BE_DUPLICATE = new Error(114577);
	public static final Error SUPPLIER_MASTER_USER_MASTER_ID_SHOULD_NOT_BE_DUPLICATE = new Error(114578);
	public static final Error SUPPLIER_MASTER_NAME_SHOULD_NOT_BE_EMPTY = new Error(114579);
	public static final Error SUPPLIER_MASTER_ID_SHOULD_NOT_BE_EMPTY = new Error(114580);
	public static final Error ACCOUNT_TRANSACTION_NAME_ID_EMPTY = new Error(2222);
	public static final Error ERROR_BUSINESS_TYPE_EMPTY = new Error(114581);
	public static final Error ERROR_SUPPLIER_TYPE_EMPTY = new Error(114582);
	public static final Error ERROR_BUSINESS_TYPE_NOT_FOUND = new Error(114583);
	public static final Error ERROR_SUPPLIER_TYPE_NOT_FOUND = new Error(114584);
	public static final Error ERROR_BANK_BRANCH_EMPTY = new Error(114585);
	public static final Error ERROR_BANK_BRANCH_NOT_FOUND = new Error(114586);

	public static final Error LEAVE_REQUEST_REQUIRED = new Error(21606);
	public static final Error LEAVE_REQUEST_ID_ISNULL = new Error(21607);
	public static final Error LEAVE_REQUEST_DELETED_SUCCESS = new Error(21608);
	public static final Error LEAVE_REQUEST_HEAD_OR_REGION_REQUIRED = new Error(21609);
	public static final Error LEAVE_REQUEST_ENTITY_TYPE_REQUIRED = new Error(21610);
	public static final Error LEAVE_REQUEST_ENTITY_REQUIRED = new Error(21611);
	public static final Error LEAVE_REQUEST_DEPARTMENT_REQUIRED = new Error(21612);
	public static final Error LEAVE_REQUEST_EMPLOYEE_NAME_REQUIRED = new Error(21613);
	public static final Error LEAVE_REQUEST_LEAVETYPE_REQUIRED = new Error(21614);
	public static final Error LEAVE_REQUEST_LEAVE_ELIGIBILITY_REQUIRED = new Error(21615);
	public static final Error LEAVE_REQUEST_REQUESTED_LEAVE_DAYS_REQUIRED = new Error(21616);
	public static final Error LEAVE_REQUEST_LEAVE_FROM_DATE_REQUIRED = new Error(21617);
	public static final Error LEAVE_REQUEST_LEAVE_TO_DATE_REQUIRED = new Error(21618);
	public static final Error LEAVE_REQUEST_REASON_REQUIRED = new Error(21619);
	public static final Error LEAVE_REQUEST_NOT_ELIGIBLE = new Error(21620);
	public static final Error LEAVE_REQUEST_INVALID_FROM_TO_DATE = new Error(21621);
	public static final Error LEAVE_REQUEST_SAVED_SUCCESS = new Error(21622);
	public static final Error LEAVE_REQUEST_UPDATED_SUCCESS = new Error(21623);
	public static final Error LEAVE_REQUEST_DOCUMENT_UPLOADED = new Error(21624);
	public static final Error LEAVE_REQUEST_LEAVE_BALANCE_REQUIRED = new Error(21625);
	public static final Error LEAVE_REQUEST_LEAVE_CONSUMED_REQUIRED = new Error(21626);
	public static final Error LEAVE_REQUEST_APPROVED_SUCCESS = new Error(21627);
	public static final Error LEAVE_REQUEST_REJECTED_SUCCESS = new Error(21628);
	public static final Error LEAVE_REQUEST_DOCUMENT_REQUIRED = new Error(21629);

	public static final Error TEMPORARY_ENGAGEMENT_ID_MISSING = new Error(90200);
	public static final Error APPROVED_TEMPORARY_ENGAGEMENT_CANNOT_DELETE = new Error(90201);
	public static final Error TEMPORARY_ENGAGEMENT_DELETED = new Error(90202);
	public static final Error TEMPORARY_ENGAGEMENT_REQUIRED = new Error(90203);
	public static final Error TEMPORARY_ENGAGEMENT_STATUS_REQ = new Error(90204);
	public static final Error TEMPORARY_ENGAGEMENT_APPROVED = new Error(90205);
	public static final Error TEMPORARY_ENGAGEMENT_REJECTED = new Error(90206);
	public static final Error SELECT_TEMPORARY_ENGAGEMENT = new Error(90207);
	public static final Error TEMPORARY_ENGAGEMENT_DEP_REQ = new Error(90208);
	public static final Error TEMPORARY_ENGAGEMENT_DES_REQ = new Error(90209);
	public static final Error TEMPORARY_ENGAGEMENT_SALES_FROM_REQ = new Error(90210);
	public static final Error TEMPORARY_ENGAGEMENT_SALES_TO_REQ = new Error(90211);
	public static final Error TEMPORARY_ENGAGEMENT_STATE_REQ = new Error(90212);
	public static final Error TEMPORARY_ENGAGEMENT_LIST_REQ = new Error(90213);
	public static final Error TEMPORARY_ENGAGEMENT_SELECTIONYEAR_REQ = new Error(90214);
	public static final Error INSURANCE_OBJECT_NOT_EXISTS = new Error(90251);
	public static final Error INSURANCE_FAMILY_DETAILS_REQUIRED = new Error(90252);
	public static final Error INSURANCE_NOMINEE_DETAILS_NOT_GREATER_THAN_FOUR = new Error(90253);
	public static final Error NO_FAMILY_DETAILS_FOR_EMPLOYEE = new Error(90254);
	public static final Error INSURANCE_TYPE_MANDATORY = new Error(90255);
	public static final Error FATHER_MOTHER_AGE_NOT_GREATER_THAN_SIXTY = new Error(90256);
	public static final Error CHILD_AGE_NOT_GREATER_THAN_TWENTY_FIVE = new Error(90257);
	public static final Error FAMILY_DETAILS_LIST_EMPTY = new Error(90258);
	public static final Error TOTAL_FAMILY_MEMBERS_FOUR = new Error(90259);
	public static final Error NOMINEE_IS_MANDATORY = new Error(90260);
	public static final Error RELATIONSHIP_IS_MANDATORY = new Error(90261);
	public static final Error TOTAL_PREMIMUM_AMOUNT_IS_MANDATORY = new Error(90262);
	public static final Error INSURANCE_TYPE_MASTER_ISNULL = new Error(90263);
	public static final Error INSURANCE_TOTAL_MEMBERS_ISNULL = new Error(90264);
	public static final Error INSURANCE_TOATL_PREMIUM_AMOUNT_ISNULL = new Error(90265);
	public static final Error INSURANCE_MEMBER_AGE_GREATER_THAN_SIXTY = new Error(90266);
	public static final Error INSURANCE_APPROVED_CANNOT_DELETE = new Error(90267);
	public static final Error INSURANCE_INSURANCE_ID_EXIST = new Error(90268);
	public static final Error INSURANCE_CREATED_SUCCESS = new Error(90269);
	public static final Error INSURANCE_UPDATED_SUCCESS = new Error(90270);
	public static final Error INSURANCE_DELETED_SUCCESS = new Error(90271);
	public static final Error INSURANCE_APPROVED_SUCCESS = new Error(90272);
	public static final Error INSURANCE_REJECTED_SUCCESS = new Error(90273);
	public static final Error MANUAL_ATTENDANCE_DEPARTMENT_REQUIRED = new Error(90300);
	public static final Error MANUAL_ATTENDANCE_HEAD_OFFICE_REGION_OFFICE_REQUIRED = new Error(90301);
	public static final Error MANUAL_ATTENDANCE_ENTITY_TYPE_REQUIRED = new Error(90302);
	public static final Error MANUAL_ATTENDANCE_ENTITY_REQUIRED = new Error(90303);
	public static final Error MANUAL_ATTENDANCE_EMPLOYEES_REQUIRED = new Error(90304);
	public static final Error MANUAL_ATTENDANCE_FROM_DATE_REQUIRED = new Error(90305);
	public static final Error MANUAL_ATTENDANCE_TO_DATE_REQUIRED = new Error(90306);
	public static final Error MANUAL_ATTENDANCE_ADDED_SUCCESSFULLY = new Error(90307);
	public static final Error MANUAL_ATTENDANCE_FETCHED_SUCCESSFULLY = new Error(90308);
	public static final Error MANUAL_ATTENDANCE_DELETED_SUCCESSFULLY = new Error(90309);
	public static final Error MANUAL_ATTENDANCE_APPROVED_SUCCESSFULLY = new Error(90310);
	public static final Error MANUAL_ATTENDANCE_UPDATED_SUCCESSFULLY = new Error(90311);
	public static final Error MANUAL_ATTENDANCE_NOT_FOUND = new Error(90312);
	public static final Error MANUAL_ATTENDANCE_ID_REQUIRED = new Error(90313);

	public static final Error COMPASSIONATE_ID_NOT_EXIST = new Error(90400);
	public static final Error COMPASSIONATE_IS_EMPTY = new Error(90401);
	public static final Error APPROVED_COMPASSIONATE_CANNOT_DELETE = new Error(90402);
	public static final Error COMPASSIONATE_DOCUMENT_SIZE_EXCEED = new Error(90403);
	public static final Error COMPASSIONATE_CUR_WORKING_DOC_REQ = new Error(90404);
	public static final Error COMPASSIONATE_WILLING_TO_WORK_DOC_REQ = new Error(90405);
	public static final Error COMPASSIONATE_WILLING_TO_RELOCATE_DOC_REQ = new Error(90406);
	public static final Error COMPASSIONATE_SETTLE_LEGAL_HEIR_DOC_REQ = new Error(90407);
	public static final Error COMPASSIONATE_DEATH_DOC_REQ = new Error(90408);
	public static final Error COMPASSIONATE_LEGAL_HEIR_DOC_REQ = new Error(90409);
	public static final Error COMPASSIONATE_NO_OBJECTION_DOC_REQ = new Error(90410);
	public static final Error COMPASSIONATE_BIRTH_CER_REQ = new Error(90411);
	public static final Error COMPASSIONATE_TRANSFER_DOC_REQ = new Error(90412);
	public static final Error COMPASSIONATE_REQUISITION_FROM_EMP_DOC_REQ = new Error(90413);
	public static final Error COMPASSIONATE_REQUISITION_FROM_APPL_DOC_REQ = new Error(90414);
	public static final Error COMPASSIONATE_OUTSTANDING_DUE_DOC_REQ = new Error(90415);
	public static final Error COMPASSIONATE_EMP_REQ = new Error(90416);
	public static final Error COMPASSIONATE_NAME_REQ = new Error(90417);
	public static final Error COMPASSIONATE_RELATIONSHIP_REQ = new Error(90418);
	public static final Error COMPASSIONATE_DATEOFBIRTH_REQ = new Error(90419);
	public static final Error COMPASSIONATE_GENDER_REQ = new Error(90420);
	public static final Error COMPASSIONATE_QUALIFICATION_REQ = new Error(90421);
	public static final Error COMPASSIONATE_SPECIALIZATION_REQ = new Error(90422);
	public static final Error COMPASSIONATE_POST_REQ = new Error(90423);
	public static final Error COMPASSIONATE_LOACTION_REQ = new Error(90424);
	public static final Error COMPASSIONATE_MARITAL_REQ = new Error(90425);
	public static final Error SELECT_COMPASSIONATE_APPOINTMENT = new Error(90426);
	public static final Error APPROVED_COMPASSIONATE_APPOINTMENT_CANNOT_DELETE = new Error(90427);
	public static final Error COMPASSIONATE_APPROVED_SUCCESS = new Error(90428);
	public static final Error COMPASSIONATE_REJECTED_SUCCESS = new Error(90429);

	public static final Error ERROR_FDS_PLAN_NAME_DUPLICATE = new Error(4281);
	public static final Error FDS_PLAN_SAVED = new Error(4282);

	public static final Error EMP_PROFILE_UPLOADED_SUCCESSFULLY = new Error(10101);
	public static final Error TRINING_TYPE_EMPTY = new Error(10111);
	public static final Error TRINING_TYPE_RETRIEVED_SUCCESSFULLY = new Error(11111);
	public static final Error INTERNAL_TYPE_EMPTY = new Error(10110);
	public static final Error INTERNAL_TYPE_RETRIEVED_SUCCESSFULLY = new Error(11011);
	public static final Error EXTERNAL_TYPE_EMPTY = new Error(110);
	public static final Error EXTERNAL_TYPE_RETRIEVED_SUCCESSFULLY = new Error(40011);
	public static final Error EMP_TRANSFER_ID_IS_EMPTY = new Error(40111);
	public static final Error EMP_INTERCHANGE_ID_IS_EMPTY = new Error(44111);
	public static final Error EMP_TRANSFER_DELETE_SUCCESSFULLY = new Error(13121);
	public static final Error EMP_INTERCHANGE_DELETE_SUCCESSFULLY = new Error(14121);
	public static final Error SELECT_RELIGION = new Error(91400);
	public static final Error ACTIVE_RELIGION_CANNOT_DELETE = new Error(91401);
	public static final Error RELIGION_NAME_EMPTY = new Error(91402);
	public static final Error RELIGION_LNAME_EMPTY = new Error(91403);
	public static final Error RELIGION_STATUS_EMPTY = new Error(91404);
	public static final Error RELIGION_EMPTY = new Error(91405);
	public static final Error RELIGION_NAME_MIN_MAX_ERROR = new Error(91406);
	public static final Error RELIGION_LNAME_MIN_MAX_ERROR = new Error(91407);
	public static final Error RELIGION_SAVE_SUCCESS = new Error(91408);
	public static final Error RELIGION_UPDATE_SUCCESS = new Error(91409);
	public static final Error RELIGION_DELETE_SUCCESS = new Error(91410);
	public static final Error RELIGION_NAME_ALREADY_EXIST = new Error(91411);
	public static final Error RELIGION_LNAME_ALREADY_EXIST = new Error(91412);
	public static final Error RELIGION_NOT_FOUND = new Error(91413);
	public static final Error RELIGION_CODE_ALREADY_EXIST = new Error(91414);
	public static final Error EMP_DETAILS = new Error(14122);
	public static final Error EMP_TRAINING_ID_IS_EMPTY = new Error(44411);
	public static final Error RECORD_CAN_NOT_DELETED = new Error(119504);
	public static final Error EMP_TRAINING_DELETE_SUCCESSFULLY = new Error(19121);
	public static final Error EMP_TRAINING_FILE_UPLOAD_SUCCESS = new Error(19122);
	public static final Error EMP_PROMOTION_DETAIL_NOT_EXIST = new Error(14123);
	public static final Error SELECT_CASTE = new Error(91500);
	public static final Error ACTIVE_CASTE_CANNOT_DELETE = new Error(91501);
	public static final Error CASTE_NAME_EMPTY = new Error(91502);
	public static final Error CASTE_LNAME_EMPTY = new Error(91503);
	public static final Error CASTE_STATUS_EMPTY = new Error(91504);
	public static final Error CASTE_EMPTY = new Error(91505);
	public static final Error CASTE_NAME_MIN_MAX_ERROR = new Error(91506);
	public static final Error CASTE_LNAME_MIN_MAX_ERROR = new Error(91507);
	public static final Error CASTE_SAVE_SUCCESS = new Error(91508);
	public static final Error CASTE_UPDATE_SUCCESS = new Error(91509);
	public static final Error CASTE_DELETE_SUCCESS = new Error(91510);
	public static final Error CASTE_NAME_ALREADY_EXIST = new Error(91511);
	public static final Error CASTE_LNAME_ALREADY_EXIST = new Error(91512);
	public static final Error CASTE_NOT_FOUND = new Error(91513);
	public static final Error CASTE_CODE_EXIST = new Error(91514);
	public static final Error CASTE_ID_NULL = new Error(91515);
	public static final Error CASTE_COMMUNITY_MASTER_EMPTY = new Error(91516);
	public static final Error CASTE_COMMUNITY_NAME_EMPTY = new Error(91517);
	public static final Error COMMUNITY_CODE_EMPTY = new Error(91616);

	public static final Error STUDENT_TRAINING_ID_SHOULD_NOT_EMPTY = new Error(92500);
	public static final Error STUDENT_TRAINING_NOT_EXIST = new Error(92501);
	public static final Error STUDENT_TRAINING_SAVED_SUCCESSFULLY = new Error(92502);
	public static final Error STUDENT_TRAINING_DELETED_SUCCESSFULLY = new Error(92503);
	public static final Error STUDENT_TRAINING_UPDATED_SUCCESSFULLY = new Error(92504);
	public static final Error STUDENT_TRAINING_LIST_EMPTY = new Error(92505);
	public static final Error STUDENT_TRAINING_SELETE = new Error(92506);
	public static final Error STUDENT_TRAINING_DOCUMENT_UPLOAD_SUCCESS = new Error(92507);

	public static final Error INTERNAL_TRAINING_ID_SHOULD_NOT_EMPTY = new Error(92600);
	public static final Error INTERNAL_TRAINING_NOT_EXIST = new Error(92601);
	public static final Error INTERNAL_TRAINING_SAVED_SUCCESSFULLY = new Error(92602);
	public static final Error INTERNAL_TRAINING_DELETED_SUCCESSFULLY = new Error(92603);
	public static final Error INTERNAL_TRAINING_UPDATED_SUCCESSFULLY = new Error(92604);
	public static final Error INTERNAL_TRAINING_LIST_EMPTY = new Error(92605);
	public static final Error INTERNAL_TRAINING_SELETE = new Error(92606);

	public static final Error EXTERNAL_TRAINING_ID_SHOULD_NOT_EMPTY = new Error(92700);
	public static final Error EXTERNAL_TRAINING_NOT_EXIST = new Error(92701);
	public static final Error EXTERNAL_TRAINING_SAVED_SUCCESSFULLY = new Error(92702);
	public static final Error EXTERNAL_TRAINING_DELETED_SUCCESSFULLY = new Error(92703);
	public static final Error EXTERNAL_TRAINING_UPDATED_SUCCESSFULLY = new Error(92704);
	public static final Error EXTERNAL_TRAINING_LIST_EMPTY = new Error(92705);
	public static final Error EXTERNAL_TRAINING_SELETE = new Error(92706);

	// Yarn Purchase Order

	public static final Error ALREADY_ORDERED_CANNOT_GREATER = new Error(79001);

	public static final Error SELECT_COMMUNITY = new Error(91600);
	public static final Error ACTIVE_COMMUNITY_CANNOT_DELETE = new Error(91601);
	public static final Error COMMUNITY_NAME_EMPTY = new Error(91602);
	public static final Error COMMUNITY_LNAME_EMPTY = new Error(91603);
	public static final Error COMMUNITY_STATUS_EMPTY = new Error(91604);
	public static final Error COMMUNITY_EMPTY = new Error(91605);
	public static final Error COMMUNITY_NAME_MIN_MAX_ERROR = new Error(91606);
	public static final Error COMMUNITY_LNAME_MIN_MAX_ERROR = new Error(91607);
	public static final Error COMMUNITY_SAVE_SUCCESS = new Error(91608);
	public static final Error COMMUNITY_UPDATE_SUCCESS = new Error(91609);
	public static final Error COMMUNITY_DELETE_SUCCESS = new Error(91610);
	public static final Error COMMUNITY_NAME_ALREADY_EXIST = new Error(91611);
	public static final Error COMMUNITY_LNAME_ALREADY_EXIST = new Error(91612);
	public static final Error COMMUNITY_NOT_FOUND = new Error(91613);
	public static final Error COMMUNITY_CODE_EXIST = new Error(91614);
	public static final Error COMMUNITY_ID_NULL = new Error(91615);
	public static final Error COMMUNITY_CODE_ALREADY_EXIST = new Error(91617);
	public static final Error LTC_UPLOAD_SUCCESS = new Error(92001);
	public static final Error SALES_ORDER_ID_EMPTY = new Error(92100);
	public static final Error SALES_ORDER_SELECT_ONE_RECORD = new Error(92101);
	public static final Error SALES_ORDER_DELETE_SUCCESS = new Error(92102);
	public static final Error SALES_ORDER_CANNOT_BE_MODIFIED = new Error(92103);
	public static final Error SALES_ORDER_CODE_DUPLICATE = new Error(92104);
	public static final Error SALES_ORDER_EMPTY_PRODUCT_DETAILS = new Error(92105);
	public static final Error SALES_ORDER_LIST_EMPTY = new Error(92106);
	public static final Error SALES_ORDER_SAVE_SUCCESS = new Error(92107);
	public static final Error SALES_ORDER_UPDATED = new Error(92108);
	public static final Error SALES_ORDER_SUBMITTED = new Error(92109);
	public static final Error SALES_ORDER_DELETED = new Error(92110);
	public static final Error SALES_ORDER_VALID_DATE_NOT_NULL = new Error(92111);
	public static final Error SALES_ORDER_DELIVERY_DATE_NOT_NULL = new Error(92112);
	public static final Error SALES_ORDER_EMPTY = new Error(92113);
	public static final Error SALES_ORDER_APPROVED = new Error(92114);
	public static final Error SALES_ORDER_REJECTED = new Error(92115);
	public static final Error SALES_ORDER_FINAL_APPROVED = new Error(92116);
	public static final Error SALES_ORDER_QUOTATION_NOT_NULL = new Error(92117);
	public static final Error SALES_ORDER_ITEMS_EMPTY = new Error(92118);
	public static final Error SALES_ORDER_ITEM_PRODUCT_EMPTY = new Error(92119);
	public static final Error SALES_ORDER_BILLING_ADDRESS_NOT_NULL = new Error(92120);
	public static final Error SALES_ORDER_SHIPPING_ADDRESS_NOT_NULL = new Error(92121);
	public static final Error SALES_ORDER_NOTE_NOT_NULL = new Error(92122);
	public static final Error SALES_ORDER_DATE = new Error(92123);

	public static final Error EMP_PAY_HEAD_IS_NULL = new Error(93000);
	public static final Error EMP_PAY_ASPECT_IS_NULL = new Error(93001);
	public static final Error EMP_PAY_AMOUNT_IS_NULL = new Error(93002);
	public static final Error PAY_HEAD_CADRE_IS_NULL = new Error(93003);
	public static final Error PAY_HEAD_CONFIG_NOT_AVAILABLE = new Error(93004);
	public static final Error EMPLOYEE_PAY_CONFIG_GENERATED_SUCCESSFULLY = new Error(93005);
	public static final Error EMPLOYEE_PAY_DETAILS_NOT_FOUND = new Error(93006);
	public static final Error EMPLOYEE_PAY_DETAILS_RETRIEVED_SUCCESSFULLY = new Error(93007);
	public static final Error GENERATE_EMPLOYEE_PAY_DETAILS = new Error(93005);
	public static final Error NO_DETAILS_FOUND_FOR_THIS_EMPLOYEE = new Error(93006);
	public static final Error BASIC_PAY_EMPTY = new Error(93007);
	public static final Error EMPLOYEE_PAY_DETAILS_UPDATED_SUCCESSFULLY = new Error(93008);
	public static final Error EMPLOYEE_PAY_DETAILS_ALREADY_ADDED = new Error(93009);
	public static final Error EMP_PAY_DETAIL_MONTH_EMPTY = new Error(93010);
	public static final Error EMP_PAY_DETAIL_YEAR_EMPTY = new Error(93011);
	public static final Error EMP_PAY_ROLL_DETAIL_SAVED_SUCCESSFULLY = new Error(93012);

	// Employee Retirement
	public static final Error EMP_RETIREMENT_NOT_FOUND = new Error(93010);
	public static final Error RETIREMENT_REGION_LIST_EMPTY = new Error(71000);
	public static final Error RETIREMENT_FROMDATE_NULL = new Error(71001);
	public static final Error RETIREMENT_TODATE_NULL = new Error(71002);
	public static final Error RETIREMENT_FROMDATE_GREATER_THAN_TODATE = new Error(71003);
	public static final Error RETIREMENT_EMP_LIST_EMPTY = new Error(71004);
	public static final Error RETIREMENT_NORMAL_SAVED_SUCCESSFULLY = new Error(71005);
	public static final Error RETIREMENT_NORMAL_APPROVED_SUCCESSFULLY = new Error(71006);
	public static final Error RETIREMENT_VOLUNTARY_SAVED_SUCCESSFULLY = new Error(71007);
	public static final Error RETIREMENT_VOLUNTARY_APPROVED_SUCCESSFULLY = new Error(71008);
	public static final Error EMP_RETIREMENT_ALREADY_EXIST = new Error(71009);
	public static final Error EMP_RETIREMENT_NORAML_SELECT_EMPTY = new Error(71010);
	public static final Error RETIREMENT_COMPULSORY_SAVED_SUCCESSFULLY = new Error(71011);
	public static final Error RETIREMENT_NORMAL_COMMENTS_REQUIRED = new Error(71012);
	public static final Error RETIREMENT_NORMAL_NOT_EXIST = new Error(71013);
	public static final Error RETIREMENT_NORMAL_REJECTED_SUCCESSFULLY = new Error(71014);
	public static final Error INFO_EMP_RETIREMENT_DOCUMENT_UPLOADED = new Error(71015);
	public static final Error RETIREMENT_VOLUNTARY_UPDATED_SUCCESSFULLY = new Error(71016);
	public static final Error RETIREMENT_VOLUNTARY_REQUEST_SUCCESSFULLY = new Error(71017);
	public static final Error RETIREMENT_VOLUNTARY_DELETED_SUCCESSFULLY = new Error(71018);

	// Employee Resignation
	public static final Error EMP_RESIGNATION_SAVED_SUCCESSFULLY = new Error(71050);
	public static final Error EMP_RESIGNATION_UPDATED_SUCCESSFULLY = new Error(71051);
	public static final Error EMP_RESIGNATION_DELETED_SUCCESSFULLY = new Error(71052);
	public static final Error EMP_RESIGNATION_NOT_FOUND = new Error(71053);
	public static final Error EMP_RESIGNATION_LIST_EMPTY = new Error(71054);
	public static final Error EMP_RESIGNATION_REJECTED_SUCCESSFULLY = new Error(71055);
	public static final Error EMP_RESIGNATION_SELECT = new Error(71056);

	public static final Error ADDITIONAL_PLAN_ID_EMPTY = new Error(71100);
	public static final Error ADDITIONAL_PLAN_SELECT_ONE_RECORD = new Error(71101);
	public static final Error ADDITIONAL_PLAN_DELETE_SUCCESS = new Error(71102);
	public static final Error ADDITIONAL_PLAN_CANNOT_BE_MODIFIED = new Error(71103);
	public static final Error ADDITIONAL_PLAN_CODE_DUPLICATE = new Error(71104);
	public static final Error ADDITIONAL_PLAN_EMPTY_PRODUCT_DETAILS = new Error(71105);
	public static final Error ADDITIONAL_PLAN_LIST_EMPTY = new Error(71106);
	public static final Error ADDITIONAL_PLAN_SAVE_SUCCESS = new Error(71107);
	public static final Error ADDITIONAL_PLAN_UPDATED = new Error(71108);
	public static final Error ADDITIONAL_PLAN_SUBMITTED = new Error(71109);
	public static final Error ADDITIONAL_PLAN_DELETED = new Error(71110);
	public static final Error ADDITIONAL_PLAN_DUE_DATE_NOT_NULL = new Error(71111);
	public static final Error ADDITIONAL_PLAN_EMPTY = new Error(71112);
	public static final Error ADDITIONAL_PLAN_APPROVED = new Error(71113);
	public static final Error ADDITIONAL_PLAN_REJECTED = new Error(71114);
	public static final Error ADDITIONAL_PLAN_NOTE_NULL = new Error(71115);

	public static final Error BANK_MASTER_ADDED_SUCCESSFULLY = new Error(1144887);

	public static final Error DISCIPLINARY_ACTION_REQUIRED = new Error(1144888);
	public static final Error DISCIPLINARY_ACTION_COMPLAINTNATURE_REQUIRED = new Error(1144889);
	public static final Error DISCIPLINARY_ACTION_GIST_OF_COMPLAINT_REQUIRED = new Error(1144890);
	public static final Error DISCIPLINARY_ACTION_EMPLOYEE_REQUIRED = new Error(1144891);
	public static final Error DISCIPLINARY_ACTION_SAVED_SUCCESSFULLY = new Error(1144892);
	public static final Error DISCIPLINARY_ACTION_UPDATED_SUCCESSFULLY = new Error(1144893);
	public static final Error DISCIPLINARY_ACTION_DELETED_SUCCESSFULLY = new Error(1144894);

	// Yarn Requirement
	public static final Error YARN_REQUIREMENT_SAVED_SUCCESSFULLY = new Error(9400);
	public static final Error YARN_REQUIREMENT_SUBMITTED_SUCCESSFULLY = new Error(9401);
	public static final Error YARN_REQUIREMENT_UPDATED_SUCCESSFULLY = new Error(9402);
	public static final Error YARN_REQUIREMENT_APPROVED_SUCCESSFULLY = new Error(9403);
	public static final Error YARN_REQUIREMENT_REJECTED_SUCCESSFULLY = new Error(9404);
	public static final Error YARN_REQUIREMENT_FINAL_APPROVED_SUCCESSFULLY = new Error(9405);
	public static final Error YARN_REQUIREMENT_IS_NULL = new Error(9406);
	public static final Error YARN_REQUIREMENT_IS_EMPTY = new Error(9407);
	public static final Error YARN_REQUIREMENT_NOT_FOUND = new Error(9408);
	public static final Error YARN_REQUIREMENT_DETAILS_IS_EMPTY = new Error(9409);
	public static final Error YARN_REQUIREMENT_NOTE_IS_EMPTY = new Error(9410);

	// SMS Request Errorcodes

	public static final Error SMS_REQUEST_EMPTY = new Error(8000);
	public static final Error MOBILE_NUMBER_EMPTY = new Error(8001);
	public static final Error SMS_CONTENT_EMPTY = new Error(8002);

	//
	public static final Error LOAN_ADV_IS_EMPTY = new Error(71114);
	public static final Error LOAN_ADV_CREATED_SUCCESS = new Error(71114);
	public static final Error LOAN_ADV_CREATE_FAILED = new Error(71114);
	public static final Error LOAN_ADV_DELETE_FAILED = new Error(71114);
	public static final Error LOAN_ADV_DELETE_SUCCESS = new Error(71114);

	// Profile Master

	public static final Error PROFILE_ADD_SUCCESSFULLY = new Error(2252);
	public static final Error PROFILE_UPDTAE_SUCCESSFULLY = new Error(2253);
	public static final Error PROFILE_DELETE_SUCCESSFULLY = new Error(2254);
	public static final Error PROFILE_NAME_EXISTS = new Error(2255);
	public static final Error PROFILE_CODE_EXISTS = new Error(2256);
	public static final Error PROFILE_NAME_REQUIRED = new Error(2257);
	public static final Error PROFILE_CODE_REQUIRED = new Error(2258);
	public static final Error PROFILE_LOCAL_NAME_REQUIRED = new Error(2259);
	public static final Error PROFILE_REGION_REQUIRED = new Error(2260);
	public static final Error PROFILE_GST_REQUIRED = new Error(2261);
	public static final Error PROFILE_OFFICE_AREA_REQUIRED = new Error(2262);
	public static final Error PROFILE_STATUS_REQUIRED = new Error(2263);
	public static final Error PROFILE_BANK_REQUIRED = new Error(2264);
	public static final Error PROFILE_BRANCH_REQUIRED = new Error(2265);
	public static final Error PROFILE_ACCOUNT_REQUIRED = new Error(2266);
	public static final Error PROFILE_IFSC_REQUIRED = new Error(2267);
	public static final Error PROFILE_BUILDING_TYPE_REQUIRED = new Error(2268);
	public static final Error PROFILE_MONTHLY_RENT_RQUIRED = new Error(2269);
	public static final Error PROFILE_RENT_DATE_REQUIRED = new Error(2270);
	public static final Error PROFILE_LEASE_AMOUNT_REQUIRED = new Error(2271);
	public static final Error PROFILE_LEASE_FROM_DATE_REQUIRED = new Error(2272);
	public static final Error PROFILE_LEASE_TO_DATE_REQUIRED = new Error(2273);
	public static final Error PROFILE_SELECT_ONE_RECORD = new Error(2274);
	public static final Error PROFILE_BIIL_COPY_UPLOAD_SUCCESS = new Error(22076);
	public static final Error PROFILE_LEASE_AGREEMENT_COPY_SUCCESS = new Error(22077);
	public static final Error PROFILE_FILE_SIZE_ERROR = new Error(22078);
	public static final Error PROFILE_FILE_FORMAT_ERROR = new Error(22079);
	public static final Error PROFILE_CAN_NOT_DELETE = new Error(22080);

	public static final Error YARN_REQ_FROM_MONTH_YEAR_NULL = new Error(9411);
	public static final Error YARN_REQ_TO_MONTH_YEAR_NULL = new Error(9412);
	public static final Error YARN_REQ_CIRCLE_IS_NULL = new Error(9413);
	public static final Error YARN_REQ_PRODUCT_GROUP_IS_NULL = new Error(9414);
	public static final Error YARN_REQ_PRODUCT_CATEGORY_IS_NULL = new Error(9415);

	public static final Error CIRCLE_ID_NOT_FOUND = new Error(1642);

	public static final Error SALES_INVOICE_CUSTOMER_TYPE_IS_NULL = new Error(8700);
	public static final Error SALES_INVOICE_CUSTOMER_NULL = new Error(8701);
	public static final Error SALES_INVOICE_SALES_ORDER_IS_NULL = new Error(8702);
	public static final Error SALES_INVOICE_BILLING_UNIT_GREATER_THAN_ORDERED_UNIT = new Error(8703);
	public static final Error SALES_INVOICE_ITEMS_LIST_EMPTY = new Error(8704);
	public static final Error SALES_INVOICE_SAVED_SUCCESSFULLY = new Error(8705);

	public static final Error HOLIDAY_MASTER_EMPTY = new Error(2275);
	public static final Error HOLIDAY_MASTER_HOLIDAY_YEAR_FIELD_EMPTY = new Error(2276);
	public static final Error HOLIDAY_MASTER_HOLIDAY_DATE_FIELD_EMPTY = new Error(2277);
	public static final Error HOLIDAY_MASTER_HOLIDAY_NAME_FIELD_EMPTY = new Error(2278);
	public static final Error HOLIDAY_MASTER_HOLIDAY_LOCAL_NAME_FIELD_EMPTY = new Error(2279);
	public static final Error HOLIDAY_MASTER_HOLIDAY_STATUS_FIELD_EMPTY = new Error(2280);
	public static final Error HOLIDAY_MASTER_HOLIDAY_TYPE_FIELD_EMPTY = new Error(2281);
	public static final Error HOLIDAY_MASTER_ID_EMPTY = new Error(2282);
	public static final Error HOLIDAY_MASTER_SELECT = new Error(2283);
	public static final Error HOLIDAY_MASTER_NAME_MIN_MAX_ERROR = new Error(2284);
	public static final Error HOLIDAY_MASTER_SAVE_SUCCESS = new Error(2285);
	public static final Error HOLIDAY_MASTER_UPDATE_SUCCESS = new Error(2286);
	public static final Error HOLIDAY_MASTER_DELETE_SUCCESS = new Error(2287);
	public static final Error HOLIDAY_MASTER_DATE_EXIST = new Error(2288);

	public static final Error BLOOD_GROUP_MASTER_SAVE_SUCCESSFULLY = new Error(12421);
	public static final Error BLOOD_GROUP_MASTER_NAME_EMPTY = new Error(12420);
	public static final Error BLOOD_GROUP_MASTER_STATUS_EMPTY = new Error(12419);
	public static final Error BLOOD_GROUP_MASTER_ID_EMPTY = new Error(12418);
	public static final Error BLOOD_GROUP_MASTER_IS_NULL = new Error(12417);
	public static final Error BLOOD_GROUP_MASTER_NOT_FOUND = new Error(12416);
	public static final Error BLOOD_GROUP_MASTER_EMPTY = new Error(12415);
	public static final Error BLOOD_GROUP_NAME_MIN_MAX_ERROR = new Error(12414);
	public static final Error BLOOD_GROUP_MASTER_NAME_ALREADY_EXIST = new Error(12413);

	// Credit sales Registration codes
	public static final Error CREDIT_SALES_REGISTRATION_DETAILS_REQUIRED = new Error(8100);
	public static final Error CREDIT_SALES_REGISTRATION_ADDED_SUCCESSFULLY = new Error(8101);
	public static final Error CREDIT_SALES_REGISTRATION_UPDATED_SUCCESSFULLY = new Error(8101);

	public static final Error SELECT_STUDENT_TRAINING = new Error(2301);
	public static final Error STUDENT_TRAINING_SAVE_SUCCESS = new Error(2302);
	public static final Error STUDENT_TRAINING_UPDATE_SUCCESS = new Error(2303);
	public static final Error STUDENT_TRAINING_DELETE_SUCCESS = new Error(2304);

	public static final Error STUDTRAINING_INSTITUTIONTYPE_EMPTY = new Error(9346);
	public static final Error STUDTRAINING_CONTACTNUMBER_EMPTY = new Error(9347);
	public static final Error STUDTRAINING_EMAIL_EMPTY = new Error(9348);
	public static final Error STUDTRAINING_ADDRESS1_EMPTY = new Error(9349);
	public static final Error STUDTRAINING_ADDRESS2_EMPTY = new Error(9350);
	public static final Error STUDTRAINING_INSTUTIONNAME_EMPTY = new Error(9351);
	public static final Error STUDTRAINING_INSTREPNAME_EMPTY = new Error(9352);
	public static final Error STUDTRAINING_REASON_EMPTY = new Error(9353);
	public static final Error STUDTRAINING_TOPIC_EMPTY = new Error(9354);
	public static final Error STUDTRAINING_TRAININGPURPOSE_EMPTY = new Error(9355);
	public static final Error STUDTRAINING_NODAYS_EMPTY = new Error(9356);
	public static final Error STUDTRAINING_NOSTUDENTS_EMPTY = new Error(9357);
	public static final Error STUDTRAINING_SHEDULEEND_EMPTY = new Error(9358);
	public static final Error STUDTRAINING_SHEDULESTART_EMPTY = new Error(9359);
	public static final Error STUDTRAINING_ENDDATE_EMPTY = new Error(9360);
	public static final Error STUDTRAINING_STARTDATE_EMPTY = new Error(9361);
	public static final Error STUDTRAINING_MOBILENUMBER_EXIST = new Error(9362);
	public static final Error STUDTRAINING_EMAILID_EXIST = new Error(9363);
	public static final Error STUDTRAINING_DOCUMENTS_NOT_EMPTY = new Error(9364);
	public static final Error STUDTRAINING_PHOTO_SIZE = new Error(9365);
	public static final Error STUDTRAINING_DOCUMENT_SUCCESS = new Error(9366);
	public static final Error STUDENT_TRAINING_REJECTED_SUCCESS = new Error(9372);
	public static final Error STUDENT_TRAINING_APPROVED_SUCCESS = new Error(9373);
	public static final Error STUDENT_TRAINING_REFNO_EXISTS = new Error(9374);

	// organizational Master codes
	public static final Error ORGANIZATION_RETREIVED_SUCCESSFULLY = new Error(8250);

	// Account Group Codes
	public static final Error ACCOUNT_GROUP_SAVE_SUCCESS = new Error(9367);
	public static final Error SELECT_ACCOUNT_GROUP = new Error(9368);
	public static final Error ACCOUNT_GROUP_DELETE_CHECK = new Error(9369);
	public static final Error ACCOUNT_GROUP_DELETED_SUCCESSFULLY = new Error(9370);
	public static final Error ACCOUNT_GROUP_UPDATE_SUCCESS = new Error(9371);

	// Society Wise Production Plan
	public static final Error SELECT_PLAN_PRODUCT = new Error(33333);
	public static final Error SELECT_PLAN_CIRCLE_PRODUCT = new Error(33393);
	public static final Error ENTER_OPENING_CURRENT_STOCK_QTY = new Error(33399);
	public static final Error TOT_SUPPLER_COMPARE_OPENING_STOCK_QTY = new Error(33390);
	public static final Error TOT_SUPPLER_COMPARE_CURRENT_STOCK_QTY = new Error(33391);
	public static final Error SELECT_PLAN = new Error(33392);
	public static final Error SELECT_PRODUCT = new Error(33394);
	public static final Error SELECT_CIRCLE = new Error(33395);
	public static final Error ADD_PLAN_NOTES = new Error(33396);
	public static final Error SOCIETY_INSERTED_SUCCESSFULLY = new Error(33397);
	public static final Error DUPLICATE_COMBINATION_NOT_ALLOWED = new Error(33398);
	public static final Error SOCIETY_PLAN_NOT_SUBMITED = new Error(33099);
	public static final Error ENTER_VALID_CURRENT_QTY = new Error(33199);
	public static final Error CONTRACT_EXPORT_INSERTED_SUCCESSFULLY = new Error(33299);
	public static final Error CONTRACT_EXPORT_SOCIETY_PLAN_NOT_SUBMITED = new Error(33499);
	public static final Error SELECT_ONE_PLAN = new Error(33599);
	public static final Error GOVT_SOCIETY_DELETED_SUCCESSFULLY = new Error(33699);
	public static final Error CONTRACT_EXPORT_DELETED_SUCCESSFULLY = new Error(33799);
	public static final Error CONTRACT_EXPORT_DELETED_NOT_DELETED = new Error(33899);
	public static final Error GOVT_SOCIETY_DELETED_NOT_DELETED = new Error(33999);
	public static final Error EMP_NOT_FOUND_THIS_USER = new Error(33009);
	public static final Error ADDITIONAL_SOCIETY_PLAN_SUBMITED_SUCCESSFULLY = new Error(33909);
	public static final Error ADDITIONAL_DELETED_SUCCESSFULLY = new Error(33919);
	public static final Error ADDITIONAL_DELETED_NOT_DELETED = new Error(33929);

	// IntendRequest
	public static final Error INTEND_REQUEST_INSERTED_SUCCESSFULLY = new Error(34001);
	public static final Error INTEND_REQUEST_ALREADY_EXISTS = new Error(34002);
	public static final Error INTEND_REQUEST_NOT_CREATED = new Error(34003);
	public static final Error INTEND_REQUEST_REQUIREMENT_NAME_REQUIRED = new Error(34004);
	public static final Error INTEND_REQUEST_FROM_DATE_REQUIRED = new Error(34005);
	public static final Error INTEND_REQUEST_TO_DATE_REQUIRED = new Error(34006);
	public static final Error INTEND_REQUEST_DUE_DATE_REQUIRED = new Error(34007);

	public static final Error INTEND_REQUEST_DELETE_SUCCESS = new Error(34008);
	public static final Error INTEND_REQUEST_ERROR_ALREADY_COMMITED = new Error(34009);

	// IntendRequirement
	public static final Error INTEND_REQUIREMENT_INSERTED_SUCCESSFULLY = new Error(34010);
	public static final Error INTEND_REQUIREMENT_REQUIREMENTCODE = new Error(34011);
	public static final Error INTEND_REQUIREMENT_CATEGORYCODE = new Error(34012);
	public static final Error INTEND_REQUIREMENT_ALREADY_EXISTS = new Error(34013);
	public static final Error INTEND_REQUIREMENT_UPDATD_SUCCESSFULLY = new Error(34014);

	// IntendConsolidation
	public static final Error INTEND_CONSOLIDATION_REQUIREMENT_FORWARDTO_REQUIRED = new Error(34015);
	public static final Error INTEND_CONSOLIDATION_REQUIREMENT_FORWARDFOR_REQUIRED = new Error(34016);
	public static final Error INTEND_CONSOLIDATION_INSERTED_SUCCESSFULLY = new Error(34017);
	public static final Error INTEND_CONSOLIDATION_APPROVED_SUCCESSFULLY = new Error(34018);
	public static final Error INTEND_CONSOLIDATION_REJECTED_SUCCESSFULLY = new Error(34019);
	public static final Error INTEND_CONSOLIDATION_EMPTY_REQUIREMENT = new Error(35100);

	// Media Master
	public static final Error MEDIA_NAME_EMPTY = new Error(34020);
	public static final Error MEDIA_NAME_MIN_MAX_ERROR = new Error(34021);
	public static final Error MEDIA_CODE_MIN_MAX_ERROR = new Error(34025);
	public static final Error MEDIA_TYPE_EMPTY = new Error(34022);
	public static final Error MEDIA_NAME_EXIST = new Error(34023);
	public static final Error MEDIA_CODE_EXIST = new Error(34024);
	public static final Error MEDIA_INSERTED_SUCCESSFULLY = new Error(34026);
	public static final Error MEDIA_DELETE_SUCCESSFULLY = new Error(34027);
	public static final Error MEDIA_NOT_FOUND = new Error(34028);
	public static final Error MEDIA_UPDATE_SUCCESSFULLY = new Error(34029);
	public static final Error MEDIA_LNAME_EXIST = new Error(34876);

	// Procurement Order
	public static final Error PROCUREMENT_SUBMITED_SUCCESSFULLY = new Error(43909);
	public static final Error PROCUREMENT_NOT_SUBMITED_SUCCESSFULLY = new Error(43999);
	public static final Error SELECT_PLAN_CODE = new Error(44444);
	public static final Error SELECT_DP_OFFICE = new Error(44441);
	public static final Error SELECT_INDENTING_REGIONAL_ENTITY = new Error(44442);
	public static final Error SELECT_ISSR_ENTITY = new Error(44443);
	public static final Error ENTER_CURRENT_ISSUED_QUANTITY = new Error(44445);
	public static final Error SELECT_VALIDITY_DATE = new Error(44446);
	public static final Error ENTER_NOT_LATER_THAN_DATE = new Error(44447);
	public static final Error COMBINATION_OF_PRODUCT_ISSR = new Error(44448);
	public static final Error GREATER_THAN_OF_TOTAL_QTY_ISSUED_QTY = new Error(44449);
	public static final Error ENTER_VALID_DATA = new Error(44400);

	// Procurement Costing

	// public static final Error PROCUREMENT_COSTING_SAVE_SUCCESS = new
	// Error(44401);
	// public static final Error PROCUREMENT_COSTING_UPDATE_SUCCESS = new
	// Error(44402);

	public static final Error PROPER_PLAN_NOTE_DETAILS = new Error(44401);
	public static final Error SELECT_ANY_ONE_PROCUREMENT = new Error(44402);
	public static final Error PROCUREMENT_DELETED_SUCCESSFULLY = new Error(44403);
	public static final Error PROCUREMENT_NOT_ABLE_DELETED = new Error(44404);
	public static final Error SELECT_PLAN_TYPE = new Error(44405);
	public static final Error PROCUREMENT_ORDER_ONLY_CAN_EDITABLE = new Error(44406);
	public static final Error SELECT_INDENTING_REGION = new Error(44407);
	public static final Error SELECT_GOV_SCHEME_PLAN = new Error(44408);
	public static final Error SELECT_CON_EXPORT_PLAN = new Error(44409);
	public static final Error SELECT_ADD_SCHEME_PLAN = new Error(44499);

	// Gender Master
	public static final Error GENDER_MASTER_NAME_ALREADY_EXIST = new Error(34041);
	public static final Error GENDER_MASTER_CREATED_SUCCESSFULLY = new Error(34049);
	public static final Error GENDER_MASTER_UPDATED_SUCCESSFULLY = new Error(34050);
	public static final Error GENDER_MASTER_DELETED_SUCCESSFULLY = new Error(34051);
	public static final Error GENDER_MASTER_CODE_ALREADY_EXIST = new Error(7777762);
	public static final Error GENDER_MASTER_LOCALNAME_ALREADY_EXIST = new Error(7777763);

	// court Master
	public static final Error COURT_MASTER_ALREADY_EXIST = new Error(44503);
	public static final Error COURT_MASTER_CREATED_SUCCESSFULLY = new Error(44500);
	public static final Error COURT_MASTER_UPDATED_SUCCESSFULLY = new Error(44501);
	public static final Error COURT_MASTER_DELETED_SUCCESSFULLY = new Error(44502);

	// Society Registration Request
	public static final Error SOCIETY_REQUEST_INSERTED_SUCCESSFULLY = new Error(34052);
	public static final Error SOCIETY_REQUEST_UPDATE_SUCCESSFULLY = new Error(34053);
	public static final Error SOCIETY_REQUEST_RECOMMANDATION_LETTER_SIZE = new Error(34054);
	public static final Error SOCIETY_REQUEST_RECOMMANDATION_LETTER_UPLOAD_SUCCESS = new Error(34055);
	public static final Error SOCIETY_REQUEST_DELETE_SUCCESSFULLY = new Error(34056);
	public static final Error SOCIETY_REQUEST_APPROVED_SUCCESSFULLY = new Error(34057);
	public static final Error SOCIETY_REQUEST_REJECTED_SUCCESSFULLY = new Error(34062);
	public static final Error SOCIETY_REQUEST_NOT_FOUND = new Error(34063);
	public static final Error SOCIETY_REQUEST_ALREADY_EXIST = new Error(34064);
	public static final Error SOCIETY_REQUEST_LOOM_TYPE_EMPTY = new Error(34067);
	public static final Error SOCIETY_REQUEST_REG_NUMBER_EMPTY = new Error(34066);
	public static final Error SOCIETY_REQUEST_REG_NAME_EMPTY = new Error(34073);
	public static final Error SOCIETY_REQUEST_REG_LOCNAME_EMPTY = new Error(34074);
	public static final Error SOCIETY_REQUEST_REG_REGDATE_EMPTY = new Error(34076);
	public static final Error SOCIETY_REQUEST_REG_PRODUCTION_DATE_EMPTY = new Error(34077);
	public static final Error SOCIETY_REQUEST_REG_RESOLUTION_DATE_EMPTY = new Error(34078);
	public static final Error SOCIETY_REQUEST_REG_RESOLUTION__NUMBER_EMPTY = new Error(34079);
	public static final Error SOCIETY_REQUEST_REG_RECOM_FROM_EMPTY = new Error(34080);
	public static final Error SOCIETY_REQUEST_REG_ADHT_EMPTY = new Error(34081);
	public static final Error SOCIETY_REQUEST_REG_RECOM_BY_EMPTY = new Error(34082);
	public static final Error SOCIETY_REQUEST_REG_RECOM_DATE_EMPTY = new Error(34083);
	public static final Error SOCIETY_REQUEST_REG_DANDP_CODE_EMPTY = new Error(34084);
	public static final Error SOCIETY_REQUEST_REG_FORWARD_TO_EMPTY = new Error(34085);
	public static final Error SOCIETY_REQUEST_REG_NOTE_EMPTY = new Error(34086);

	// Credit Sales Request
	public static final Error CREDIT_SALES_REQ_ALREADY_EXIST = new Error(44507);
	public static final Error CREDIT_SALES_REQ_CREATED_SUCCESSFULLY = new Error(44504);
	public static final Error CREDIT_SALES_REQ_UPDATED_SUCCESSFULLY = new Error(44505);
	public static final Error CREDIT_SALES_REQ_DELETED_SUCCESSFULLY = new Error(44506);
	public static final Error CREDIT_SALES_REQ_NAME_ALREADY_EXIST = new Error(223345003);
	public static final Error CREDIT_SALES_REQ_CODE_ALREADY_EXIST = new Error(223345004);

	// TapalDeliveryType Master
	public static final Error TAPAL_CODE_EMPTY = new Error(34037);
	public static final Error TAPAL_NAME_EMPTY = new Error(34038);
	public static final Error TAPAL_NAME_MIN_MAX_ERROR = new Error(34039);
	public static final Error TAPAL_CODE_MIN_MAX_ERROR = new Error(34040);
	public static final Error TAPAL_NAME_EXIST = new Error(34042);
	public static final Error TAPAL_CODE_EXIST = new Error(34043);
	public static final Error TAPAL_INSERTED_SUCCESSFULLY = new Error(34044);
	public static final Error TAPAL_DELETE_SUCCESSFULLY = new Error(34045);

	// Tender Type
	public static final Error TENDER_TYPE_ALREADY_EXIST = new Error(44511);
	public static final Error TENDER_TYPE_CODE_ALREADY_EXIST = new Error(44599);
	public static final Error TENDER_TYPE_NAME_ALREADY_EXIST = new Error(44600);
	public static final Error TENDER_TYPE_LNAME_ALREADY_EXIST = new Error(44601);

	public static final Error TENDER_TYPE_CREATED_SUCCESSFULLY = new Error(44508);
	public static final Error TENDER_TYPE_UPDATED_SUCCESSFULLY = new Error(44509);
	public static final Error TENDER_TYPE_DELETED_SUCCESSFULLY = new Error(44510);

	// IncomingTapal
	public static final Error INCOMINGTAPAL_SAVE = new Error(34058);
	public static final Error INCOMINGTAPAL_UPDATE = new Error(34059);
	public static final Error INCOMINGTAPAL_DELETE = new Error(34060);
	public static final Error INCOMINGTAPAL_FILEUPLOAD = new Error(34072);

	// Loom Type Master
	public static final Error LOOM_TYPEMASTER_SAVED_SUCCESSFULLY = new Error(34061);
	public static final Error LOOM_TYPEMASTER_EDIT_SUCCESSFULLY = new Error(34113);
	public static final Error LOOM_TYPEMASTER_DELETE_SUCCESSFULLY = new Error(34114);
	public static final Error LOOM_TYPEMASTER_ALREADY_EXISTS = new Error(34115);

	// TemplateDetails
	public static final Error TEMPLATEDETAILS_TYPE_EMPTY = new Error(34030);
	public static final Error TEMPLATEDETAILS_SUBJECT_EMPTY = new Error(34031);
	public static final Error TEMPLATEDETAILS_CODE_EMPTY = new Error(34032);
	public static final Error TEMPLATEDETAILS_DESCRIPTION_EMPTY = new Error(34047);
	public static final Error TEMPLATEDETAILS_LDESCRIPTION_EMPTY = new Error(34048);
	public static final Error TEMPLATEDETAILS_SUBJECT_EXIST = new Error(34033);
	public static final Error TEMPLATEDETAILS_CODE_EXIST = new Error(34034);
	public static final Error TEMPLATEDETAILS_TYPE_EXIST = new Error(34035);
	public static final Error TEMPLATEDETAILS_INSERTED_SUCCESSFULLY = new Error(34036);
	// public static final Error LOOM_SAVE_SUCCESSFULLY = new Error(0000);

	// view Biometric
	public static final Error BIOMETRIC_HO_RO_NULL = new Error(63000);
	public static final Error BIOMETRIC_ENTITY_TYPE_NULL = new Error(63001);
	public static final Error BIOMETRIC_ENTITY_NULL = new Error(63002);
	public static final Error BIOMETRIC_DEPT_NULL = new Error(63003);
	public static final Error BIOMETRIC_DESIGN_NULL = new Error(63004);
	public static final Error BIOMETRIC_START_DATE_NULL = new Error(63005);
	public static final Error BIOMETRIC_END_DATE_NULL = new Error(63006);
	public static final Error BIOMETRIC_SEARCH_FIELDS_EMPTY = new Error(63007);

	public static final Error SOCIETY_ENROLLMENT_NOT_FOUND = new Error(8310);
	public static final Error SOCIETY_ENROLLMENT_FILE_UPLOAD_SUCCESS = new Error(8311);
	public static final Error SOCIETY_ENROLLMENT_FILE_SIZE_ERROR = new Error(8312);
	public static final Error SOCIETY_ENROLLMENT_SALUTATION_REQUIRED = new Error(8313);
	public static final Error SOCIETY_ENROLLMENT_CANNOT_EDIT_SUBMITTED_RECORD = new Error(8314);
	public static final Error SOCIETY_ENROLLMENT_UPDATE_SUCCESS = new Error(8315);
	public static final Error SOCIETY_ENROLLMENT_EXIST = new Error(8316);
	public static final Error SOCIETY_ENROLLMENT_SOCIETY_ADDRESS_REQUIRED = new Error(8317);
	public static final Error SOCIETY_ENROLLMENT_PRESIDENT_ADDRESS_REQUIRED = new Error(8318);

	// Outgoing Tapal
	public static final Error OUTGOINGTAPAL_SAVE = new Error(34087);
	public static final Error OUTGOINGTAPAL_UPDATE = new Error(34088);
	public static final Error OUTGOINGTAPAL_DELETE = new Error(34089);
	public static final Error OUTGOINGTAPAL_APPROVE = new Error(34090);
	public static final Error OUTGOINGTAPAL_REJECT = new Error(34091);
	public static final Error OUTGOINGTAPAL_FILEUPLOAD = new Error(34092);

	// TestingLabStockInward
	public static final Error TESTING_LAB_STOCK_INWARD_SAVE_SUCCESS = new Error(66737);
	public static final Error TESTING_LAB_STOCK_INWARD_SAVE_FAILED = new Error(66738);

	// Society Field Verification

	public static final Error SOCIETY_FIELD_INSERTED_SUCCESSFULLY = new Error(34093);
	public static final Error SOCIETY_FIELD_UPDATE_SUCCESSFULLY = new Error(34094);

	public static final Error SOCIETY_FIELD_LOOMLIST_ADD_ATLEAST_ONE = new Error(34096);
	public static final Error SOCIETY_FIELD_COMMITTEE_ADD_ATLEAST_ONE = new Error(34095);

	// Helpdesk
	public static final Error HELPDESK_TCIKET_SAVED_SUCCESSFULLY = new Error(44513);
	public static final Error HELPDESK_TICKET_UPLOAD_SUCCESS = new Error(44514);
	public static final Error HELPDESK_TICKET_SELECT_ONE = new Error(44642);

	// Sales Type Master
	public static final Error SELECT_SALESTYPE = new Error(34097);
	public static final Error SALESTYPE_CODE_EMPTY = new Error(34098);
	public static final Error SALESTYPE_NAME_EMPTY = new Error(34099);
	public static final Error SALESTYPE_LNAME_EMPTY = new Error(34100);
	public static final Error SALESTYPE_STATUS_EMPTY = new Error(34101);
	public static final Error SALESTYPE_CODE_MIN_MAX_ERROR = new Error(34102);
	public static final Error SALESTYPE_NAME_MIN_MAX_ERROR = new Error(34103);
	public static final Error SALESTYPE_LNAME_MIN_MAX_ERROR = new Error(34104);
	public static final Error SALESTYPE_SAVE_SUCCESS = new Error(34105);
	public static final Error SALESTYPE_UPDATE_SUCCESS = new Error(34106);
	public static final Error SALESTYPE_DELETE_SUCCESS = new Error(34107);
	public static final Error SALESTYPE_NAME_ALREADY_EXIST = new Error(34109);
	public static final Error SALESTYPE_LNAME_ALREADY_EXIST = new Error(34110);
	public static final Error SALESTYPE_CODE_ALREADY_EXIST = new Error(34108);
	public static final Error SALESTYPE_NOT_FOUND = new Error(34111);
	public static final Error SALESTYPE_ID_NULL = new Error(34112);

	public static final Error TRAININGTYPE_DELETE_SUCCESSFULLY = new Error(44523);

	// Society Enrollment
	public static final Error SOCIETY_ENROLLMENT_SAVE_SUCCESS = new Error(8300);
	public static final Error SOCIETY_ENROLLMENT_DELETED_SUCCESS = new Error(8301);
	public static final Error SOCIETY_ENROLLMENT_SOCIETY_NULL = new Error(8302);
	public static final Error SOCIETY_ENROLLMENT_SOCIETY_PRESIDENT_NAME__NULL = new Error(8303);
	public static final Error SOCIETY_ENROLLMENT_TOTAL_NUMBERS__NULL = new Error(8304);
	// DD details
	public static final Error SOCIETY_ENROLLMENT_DEMAND_DRAFT_NUMBER_NULL = new Error(8305);
	public static final Error SOCIETY_ENROLLMENT_DEMAND_DRAFT_DATE_NULL = new Error(8306);
	public static final Error SOCIETY_ENROLLMENT_DEMAND_DRAFT_AMOUNT = new Error(8307);
	public static final Error SOCIETY_ENROLLMENT_LOOM_TYPE_NULL = new Error(8309);

	// --Biometric

	public static final Error BIOMETRIC_DELETE_SUCCESSFULLY = new Error(53799);
	public static final Error BIOMETRIC_NOT_ABLE_DELETE = new Error(53899);
	public static final Error BIOMETRIC_NOT_EMPTY = new Error(66666);

	public static final Error BIOMETRIC_ENTER_SUPPLIER = new Error(66660);
	public static final Error BIOMETRIC_ENTER_DEVICE_ID = new Error(66661);
	public static final Error BIOMETRIC_ENTER_DEVICE_ID_LEN = new Error(66662);
	public static final Error BIOMETRIC_ENTER_ENTITY_MASTER = new Error(66663);
	public static final Error BIOMETRIC_ENTER_ENTITY_TYPE_MASTER = new Error(66664);
	public static final Error BIOMETRIC_DEVICE_ID_IS_EXISTS = new Error(66665);

	// Tender Category
	public static final Error TENDER_CATEGORY_NAME_ALREADY_EXIST = new Error(34068);
	public static final Error TENDER_CATEGORY_CREATED_SUCCESSFULLY = new Error(34069);
	public static final Error TENDER_CATEGORY_UPDATED_SUCCESSFULLY = new Error(34070);
	public static final Error TENDER_CATEGORY_DELETED_SUCCESSFULLY = new Error(34071);
	public static final Error TENDER_CATEGORY_CODE_ALREADY_EXIST = new Error(44602);
	public static final Error TENDER_CATEGORY_LNAME_ALREADY_EXIST = new Error(44603);

	// StockItemInwardPNS
	public static final Error STOCK_ITEM_INWARD_INVOICE_FORMAT = new Error(66700);
	public static final Error STOCK_ITEM_INWARD_PNS_NEW_ITEM_ADDED_SUCCESSFULLY = new Error(66701);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_ITEM_QUANTITY = new Error(66702);
	public static final Error STOCK_ITEM_INWARD_PNS_NEW_INVALID_UNIT = new Error(66703);
	public static final Error STOCK_ITEM_INWARD_PNS_NEW_INVALID_DISCOUNT = new Error(66704);
	public static final Error STOCK_ITEM_INWARD_PNS_NEW_INVALID_TAX = new Error(66705);
	public static final Error STOCK_ITEM_INWARD_PNS_NEW_ADDED_FAILED = new Error(66706);
	public static final Error STOCK_ITEM_INWARD_PNS_PURCHASE_ORDER_FAILED = new Error(66707);
	public static final Error STOCK_ITEM_INWARD_PNS_FILE_SIZE_INVALID = new Error(66708);

	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE = new Error(66709);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_DATE = new Error(66710);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_DC = new Error(66711);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_PAYMENT = new Error(66712);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_DELAY = new Error(66713);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_INTEREST = new Error(66714);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_DOC = new Error(66715);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_INVOICE_ADDED_SUCCESS = new Error(66716);

	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_STOCK_NULL = new Error(66717);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_TYPE_NOT_FOUNT = new Error(66718);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_SERVICE_NOT_VALID = new Error(66719);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_TRANS_CHARGE_NOT_VALID = new Error(66720);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_WAYBILL_NOT_VALID = new Error(66721);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_TRANSPORT_AMOUNT_NOT_VALID = new Error(66722);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_TRANSPORT_CHARGE_AVAILABLE = new Error(66723);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_TABLE_NULL = new Error(66724);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_SUPPLIER_ITEM_NULL = new Error(66724);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_ERROR = new Error(66725);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_EXCEPTION = new Error(66726);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_CREATE_SUCCESS = new Error(66727);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_UPDATE_SUCCESS = new Error(66728);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_UPDATE_ERROR = new Error(66729);
	public static final Error STOCK_ITEM_INWARD_PNS_SUBMIT_UPDATE_EXCEPTION = new Error(66730);
	public static final Error STOCK_ITEM_INWARD_PNS_DELETE_SUCCESS = new Error(66731);
	public static final Error STOCK_ITEM_INWARD_PNS_DELETE_ERROR = new Error(66731);
	public static final Error STOCK_ITEM_INWARD_PNS_INVALID_ITEM_SELECT = new Error(66732);
	public static final Error STOCK_ITEM_INWARD_PNS_WAYBILL_INVALID = new Error(66733);
	public static final Error STOCK_ITEM_INWARD_PNS_INVOICE_FORMAT_NOT_VALID = new Error(66734);

	public static final Error SALES_INVOICE_BILLING_UNIT_REQUIRED = new Error(8706);

	public static final Error CREDIT_AND_DEBIT_AMOUNT_NOT_MATCHED = new Error(44512);

	public static final Error VEHICLE_REGISTER_CREATE_SUCCESS = new Error(66735);
	public static final Error VEHICLE_REGISTER_CREATE_FAILED = new Error(66736);
	public static final Error VEHICLE_REGISTER_SELECT_ONE_RECORD = new Error(66699);
	public static final Error VEHICLE_REGISTER_UPDATE_SUCCESS = new Error(1144888);
	public static final Error VEHICLE_REGISTER_DELETE_SUCCESS = new Error(66698);
	public static final Error VEHICLE_REGISTER_DELETE_FAILED = new Error(66697);
	

	public static final Error TESTING_INWARD_INVALID_PRODUCT_TYPE = new Error(66739);

	public static final Error SELECT_REQUEST_ID = new Error(77777);
	public static final Error SELECT_ENTITY_OR_SECTION = new Error(77770);
	public static final Error ENTER_DISPATCH_QTY = new Error(77771);
	public static final Error ITEM_DISTRIBUTION_NOT_EMPTY = new Error(77772);
	public static final Error STOCK_ITEM_INSERT_SUCCUSSFULLY = new Error(77773);
	public static final Error DISPATCH_QTY_NOT_EXIST = new Error(77774);

	// Society Class Master
	public static final Error SELECT_SOCIETYCLASS = new Error(34116);
	public static final Error SOCIETYCLASS_CODE_EMPTY = new Error(34117);
	public static final Error SOCIETYCLASS_NAME_EMPTY = new Error(34118);
	public static final Error SOCIETYCLASS_STATUS_EMPTY = new Error(34119);
	public static final Error SOCIETYCLASS_CODE_MIN_MAX_ERROR = new Error(34120);
	public static final Error SOCIETYCLASS_NAME_MIN_MAX_ERROR = new Error(34121);
	public static final Error SOCIETYCLASS_SAVE_SUCCESS = new Error(34122);
	public static final Error SOCIETYCLASS_UPDATE_SUCCESS = new Error(34123);
	public static final Error SOCIETYCLASS_DELETE_SUCCESS = new Error(34124);
	public static final Error SOCIETYCLASS_NAME_ALREADY_EXIST = new Error(34125);
	public static final Error SOCIETYCLASS_CODE_ALREADY_EXIST = new Error(34126);
	public static final Error SOCIETYCLASS_NOT_FOUND = new Error(34127);
	public static final Error SOCIETYCLASS_ID_NULL = new Error(34128);

	// TestingLab StockInward
	public static final Error TESTING_INWARD_UPDATE_SUCCESS = new Error(66740);
	public static final Error TESTING_INWARD_CREATE_SUCCESS = new Error(66741);

	public static final Error TESTING_INWARD_CREATE_ERROR = new Error(66742);
	public static final Error TESTING_INWARD_CREATE_EXCEPTION = new Error(66743);
	public static final Error TESTING_INWARD_UPDATE_ERROR = new Error(66744);
	public static final Error TESTING_INWARD_UPDATE_EXCEPTION = new Error(66745);
	public static final Error TESTING_INWARD_ITEMS_NULL = new Error(66746);

	// Training Type Master
	public static final Error TRAINING_TYPE_RETRIEVED_SUCCESSFULLY = new Error(44814);
	public static final Error TRAININGTYPE_SAVED_SUCCESSFULLY = new Error(8440);
	public static final Error TRAININGTYPE_UPDATED_SUCCESSFULLY = new Error(44653);
	public static final Error SELECT_TRAININGTYPE_MASTER = new Error(44652);
	public static final Error TRAININGTYPEMASTER_CODE_ALREADY_EXISTS = new Error(44837);
	public static final Error TRAININGTYPEMASTER_NAME_ALREADY_EXISTS = new Error(44839);
	public static final Error TRAININGTYPEMASTER_L_NAME_ALREADY_EXISTS = new Error(44837);

	// KNTPlan Master
	public static final Error KNTPLAN_DELETE_SUCCESSFULLY = new Error(44710);
	public static final Error KNTPLAN_CREATED_SUCCESSFULLY = new Error(44712);
	public static final Error KNTPLAN_UPDATED_SUCCESSFULLY = new Error(44734);
	public static final Error SELECT_KNTPLAN_MASTER = new Error(44750);
	public static final Error KNTPLAN_NAME_ALREADY_EXISTS = new Error(44850);

	// Priority Master
	public static final Error PRIORITY_STATUS_EMPTY = new Error(34134);
	public static final Error PRIORITY_SAVE_SUCCESS = new Error(34135);
	public static final Error PRIORITY_UPDATE_SUCCESS = new Error(34136);
	public static final Error PRIORITY_DELETE_SUCCESS = new Error(34137);
	public static final Error SELECT_PRIORITY = new Error(34138);

	// Tapal POD
	public static final Error TAPAL_POD_SAVE = new Error(34129);
	public static final Error TAPAL_SUPPLIER_NAME = new Error(34130);
	public static final Error TAPAL_POD_NO = new Error(34131);
	public static final Error TAPAL_POD_DATE = new Error(34132);
	public static final Error TAPAL_POD_AMOUNT = new Error(34133);
	public static final Error TAPAL_POD_ALREADY_EXISTS = new Error(34139);
	public static final Error TAPAL_POD_UPDATE = new Error(34141);

	// Policy Notes
	public static final Error POLICY_NOTE_SAVE = new Error(34142);
	public static final Error POLICY_NOTE_UPDATE = new Error(34143);
	public static final Error POLICY_NOTE_DELETE = new Error(34144);
	public static final Error POLICY_NOTE_REFEENCENO = new Error(34145);
	public static final Error POLICY_NOTE_PEROID = new Error(34146);
	public static final Error POLICY_NOTE_DUEDATE = new Error(34147);
	public static final Error POLICY_NOTE_DEPARTMENT = new Error(34148);
	public static final Error POLICY_NOTE_PROCESS_SAVE = new Error(34149);
	public static final Error POLICY_NOTE_UPLOAD_FILE = new Error(34150);
	public static final Error POLICY_NOTE_DESCRIPTION = new Error(34151);
	public static final Error POLICY_NOT_ALREADY_EXISTS = new Error(34152);
	public static final Error POLICY_NOTE_UPLOAD_FILE_SIZE = new Error(34163);
	public static final Error POLICY_NOTE_PROCESS_UPLOAD = new Error(34165);

	// PrintingandStationaryDisposal
	public static final Error PRINTING_STATIONARY_SAVE_SUCCESS = new Error(34153);
	public static final Error PRINTING_STATIONARY_SAVE_FAILED = new Error(34154);
	public static final Error PRINTING_STATIONARY_SAVE_ERROR = new Error(34155);
	public static final Error PRINTING_STATIONARY_CURRENT_DISPOSAL_QTY_NOT_VALID = new Error(34156);

	// tapal for
	public static final Error SELECT_TAPAL_FOR = new Error(34164);
	public static final Error TAPAL_FOR_SAVE_SUCCESS = new Error(3416);
	public static final Error TAPAL_FOR_UPDATE_SUCCESS = new Error(3417);
	public static final Error TAPAL_FOR_DELETE_SUCCESS = new Error(3418);

	// venueMaster
	public static final Error SELECT_VENUE_MASTER = new Error(3430);
	public static final Error VENUE_MASTER_SAVE_SUCCESS = new Error(3431);
	public static final Error VENUE_MASTER_UPDATE_SUCCESS = new Error(3432);
	public static final Error VENUE_MASTER_DELETE_SUCCESS = new Error(3433);

	public static final Error VENUE_MASTER_CODE_EXIST = new Error(3434);
	public static final Error VENUE_MASTER_NAME_ALREADY_EXIST = new Error(3435);
	public static final Error VENUE_MASTER_ADDRESS_NULL = new Error(3436);

	public static final Error VENUE_MASTER_CODE_NULL = new Error(3437);
	public static final Error VENUE_MASTER_NAME_NULL = new Error(3438);
	public static final Error VENUE_MASTER_LOCALNAME_NULL = new Error(3439);
	public static final Error VENUE_MASTER_STATUS_NULL = new Error(3440);

	// HelpDeskTicketCategory

	public static final Error SELECT_HELP_DESK_TICKET_CATEGORY = new Error(3450);
	public static final Error HELP_DESK_TICKET_CATEGORY_SAVE_SUCCESS = new Error(3451);
	public static final Error HELP_DESK_TICKET_CATEGORY_UPDATE_SUCCESS = new Error(3452);
	public static final Error HELP_DESK_TICKET_CATEGORY_DELETE_SUCCESS = new Error(3453);

	// Department Approval
	public static final Error DEPARTMENT_APPROVAL_REG_NOTE_EMPTY = new Error(34157);
	public static final Error DEPARTMENT_APPROVAL_INSERTED_SUCCESSFULLY = new Error(34158);
	public static final Error DEPARTMENT_APPROVAL_APPROVED_SUCCESSFULLY = new Error(34159);
	public static final Error DEPARTMENT_APPROVAL_REJECTED_SUCCESSFULLY = new Error(34160);
	public static final Error DEPARTMENT_APPROVAL_FORWARD_TO_EMPTY = new Error(34161);

	public static final Error DEPARTMENT_APPROVAL_SOCIETY_REG_REQ_EMPTY = new Error(34162);

	public static final Error HELPDESK_TCIKET_ASSIGNED_SUCCESSFULLY = new Error(44516);
	public static final Error HELPDESK_TCIKET_CLOSED_SUCCESSFULLY = new Error(44517);
	public static final Error HELPDESK_TICKET_FILE_SIZE_ERROR = new Error(44518);
	public static final Error HELPDESK_TICKET_EMPTY_FILE = new Error(44519);

	// Board Approval
	public static final Error BOARD_APPROVAL_REG_NOTE_EMPTY = new Error(34166);
	public static final Error BOARD_APPROVAL_INSERTED_SUCCESSFULLY = new Error(34169);
	public static final Error BOARD_APPROVAL_APPROVED_SUCCESSFULLY = new Error(34170);
	public static final Error BOARD_APPROVAL_REJECTED_SUCCESSFULLY = new Error(34171);
	public static final Error BOARD_APPROVAL_FORWARD_TO_EMPTY = new Error(34167);

	public static final Error BOARD_APPROVAL_SOCIETY_REG_REQ_EMPTY = new Error(34168);

	public static final Error PRINTING_STATIONARY_LIST_EMPTY = new Error(34172);
	public static final Error PRINTING_STATIONARY_DELETE_SUCCESS = new Error(34173);
	public static final Error PRINTING_STATIONARY_DELETE_FAILED = new Error(34174);
	public static final Error PRINTING_STATIONARY_LIST_ADD_SUCCESS = new Error(34175);
	public static final Error PRINTING_STATIONARY_LIST_ADD_FAILURE = new Error(34176);

	// Discount Master
	public static final Error DISCOUNT_MASTER_CODE_EMPTY = new Error(60063);
	public static final Error DISCOUNT_MASTER_NAME_EMPTY = new Error(60064);
	public static final Error DISCOUNT_MASTER_PERCENTAGE_EMPTY = new Error(60065);
	public static final Error DISCOUNT_MASTER_REBATE_PERCENTAGE_EMPTY = new Error(60066);
	public static final Error DISCOUNT_MASTER_SHOWROOM_EMPTY = new Error(60067);
	public static final Error DISCOUNT_MASTER_PRODUCT_EMPTY = new Error(60068);
	public static final Error DISCOUNT_MASTER_EMPTY = new Error(60069);

	// TEST Lab REPORT STARTS
	public static final Error STOCK_INWARD_NUMBER_REQUIRED = new Error(60200);
	public static final Error PRODUCT_SAMPLE_NUMBER_REQUIRED = new Error(60201);
	public static final Error TEST_REPORT_CREATE_SUCCESS = new Error(60202);
	public static final Error TEST_REPORT_UPDATE_SUCCESS = new Error(60203);
	public static final Error TEST_REPORT_DELETE_SUCCESS = new Error(60204);
	public static final Error WARP_COUNT_REQUIRED = new Error(60205);
	public static final Error WARP_RESULT_REQUIRED = new Error(60206);
	public static final Error WEFT_COUNT_REQUIRED = new Error(60207);
	public static final Error WEFT_RESULT_REQUIRED = new Error(60208);
	public static final Error ENDS_PERINCH_COUNT_REQUIRED = new Error(60209);
	public static final Error ENDS_PERINCH_RESULT_REQUIRED = new Error(60210);
	public static final Error PICKS_PERINCH_COUNT_REQUIRED = new Error(60211);
	public static final Error PICKS_PERINCH_RESULT_REQUIRED = new Error(60212);
	public static final Error WARP_SHRINKAGE_PERCENT_REQUIRED = new Error(60213);
	public static final Error WARP_SHRINKAGE_RESULT_REQUIRED = new Error(60214);
	public static final Error WEFT_SHRINKAGE_PERCENT_REQUIRED = new Error(60215);
	public static final Error WEFT_SHRINKAGE_RESULT_REQUIRED = new Error(60216);
	public static final Error CHANGE_IN_COLOR_REQUIRED = new Error(60217);
	public static final Error CHANGE_IN_COLOR_RESULT_REQUIRED = new Error(60218);
	public static final Error STAINING_ON_COTTON_REQUIRED = new Error(60219);
	public static final Error STAINING_ON_COTTON_RESULT_REQUIRED = new Error(60220);
	public static final Error DRY_REQUIRED = new Error(60221);
	public static final Error DRY_RESULT_REQUIRED = new Error(60222);
	public static final Error WET_REQUIRED = new Error(60223);
	public static final Error WET_RESULT_REQUIRED = new Error(60224);
	public static final Error TEST_REPORT_NOT_FOUND = new Error(60225);
	// TEST REPORT ENDS

	// SOCIETY PRODUCT APPRAISAL STARTS
	public static final Error SOCIETY_PRODUCT_APPRAISAL_CREATE_SUCCESS = new Error(60255);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_UPDATE_SUCCESS = new Error(60256);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_DELETE_SUCCESS = new Error(60257);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_NOT_FOUND = new Error(60258);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_DESIGN_ENTER = new Error(223445279);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_SKILWEIGHT = new Error(223445280);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_ZARIWEIGHT = new Error(223445281);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_SLIKWASTAGE = new Error(223445282);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_TOTOAL_PRODUCT = new Error(223445283);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_PRODUCT_LENGTH = new Error(223445284);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_PRPDUCT_WEIGHT = new Error(223445285);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_BODY_COLOR = new Error(223445286);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_BODY_DESIGN = new Error(223445287);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_PALLUDESIGN = new Error(223445288);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_ZARITYPE = new Error(223445289);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_BORDERCOLOR = new Error(223445290);
	public static final Error SOCIETY_PRODUCT_APPRAISAL_ENTER_BORDERSIZE = new Error(223445291);
	public static final Error SOCIETY_REQUIRED = new Error(60259);
	public static final Error PRODUCT_REQUIRED = new Error(60260);
	public static final Error WEAVERS_NAME_REQUIRED = new Error(60261);
	public static final Error APPRAISAL_BY_REQUIRED = new Error(60262);
	public static final Error PRODUCT_COST_REQUIRED = new Error(60263);
	// SOCIETY PRODUCT APPRAISAL ENDS

	// CREDIT_SALES_DEMAND
	public static final Error CREDIT_SALES_PERIOD_REQUIRED = new Error(60500);
	public static final Error ORGANIZATION_REQUIRED = new Error(60501);
	public static final Error DEMAND_DETAILS_REQUIRED = new Error(60502);
	public static final Error DEMAND_NOT_FOUND = new Error(60503);
	public static final Error CREDIT_SALES_DEMAND_SAVE_SUCCESS = new Error(60504);
	public static final Error CREDIT_SALES_DEMAND_UPDATE_SUCCESS = new Error(60505);
	public static final Error CREDIT_SALES_DEMAND_DELETE_SUCCESS = new Error(60506);
	public static final Error CREDIT_SALES_DEMAND_APPROVE_SUCCESS = new Error(60507);
	public static final Error CREDIT_SALES_DEMAND_REJECT_SUCCESS = new Error(60508);
	public static final Error CREDIT_SALES_DEMAND_EXIST = new Error(60509);

	// CREDIT_SALES_RECOVERY
	public static final Error CREDIT_SALES_TYPE_REQUIRED = new Error(60550);
	public static final Error RECOVERY_OBJECT_NOT_FOUND = new Error(60551);
	public static final Error RECOVERY_CUSTOMER_REQUIRED = new Error(60552);
	public static final Error RECOVERY_SAVE_SUCCESS = new Error(60553);

	// BUDGET_REQUEST
	public static final Error BUDGET_CONFIG_REQUIRED = new Error(60350);
	public static final Error BUDGET_ENTITY_REQUIRED = new Error(60351);
	public static final Error BUDGET_SECTION_REQUIRED = new Error(60352);
	public static final Error BUDGET_NOT_FOUND = new Error(60353);
	public static final Error BUDGET_REQUEST_ID_EMPTY = new Error(60354);
	public static final Error BUDGET_REQUEST_SAVE_SUCCESS = new Error(60355);
	public static final Error BUDGET_REQUEST_APPROVE_SUCCESS = new Error(60356);
	public static final Error BUDGET_REQUEST_REJECT_SUCCESS = new Error(60357);
	public static final Error BUDGET_REQUEST_SUBMIT_SUCCESS = new Error(60358);
	public static final Error BUDGET_REQUEST_EXIST = new Error(60359);
	public static final Error SUBMITTED_RECORD_CANNOT_BE_EDIT = new Error(8314);
	// public static final Error BUDGET_REQUEST_SUBMIT_SUCCESS = new Error(60359);

	// budget Period allocation
	public static final Error BUDGET_ALLOCATION_DETAILS_REQUIRED = new Error(60450);
	public static final Error BUDGET_ALLOCATION_SAVE_SUCCESS = new Error(60451);
	public static final Error BUDGET_ALLOCATION_UPDATE_SUCCESS = new Error(60452);
	public static final Error BUDGET_ALLOCATION_DELETE_SUCCESS = new Error(60453);
	public static final Error BUDGET_ALLOCATION_ID_REQUIRED = new Error(60454);
	public static final Error BUDGET_ALLOCATION_NOT_FOUND = new Error(60455);
	public static final Error BUDGET_ALLOCATION_EXIST = new Error(60456);

	// Regular Goods To Damage Goods
	public static final Error DAMAGE_GOODS_LIST_EMPTY = new Error(88001);
	public static final Error DAMAGE_GOODS_MOVE_SUCESS = new Error(88002);
	public static final Error DAMAGE_GOODS_SELECT_EMPTY = new Error(88003);

	public static final Error TOTAL_RECOVERY_AMOUNT = new Error(60554);
	public static final Error MODE_OF_RECEIPT_REQUIRED = new Error(60555);
	public static final Error BANK_NAME_REQUIRED = new Error(60556);
	public static final Error REFERENCE_NUMBER_REQUIRED = new Error(60557);
	public static final Error REFERENCE_DATE_REQUIRED = new Error(60558);
	public static final Error REFERENCE_AMOUNT_REQUIRED = new Error(60559);
	public static final Error RECOVERY_AMOUNT_REQUIRED = new Error(60560);
	public static final Error RECOVERY_LIST_REQUIRED = new Error(60561);

	public static final Error HELPDESK_TICKET_CLAIMED_SUCCESSFULLY = new Error(44520);
	public static final Error HELPDESK_TICKET_FORWARDED_SUCCESSFULLY = new Error(44521);
	public static final Error HELPDESK_TICKET_RESOLVED_SUCCESSFULLY = new Error(44522);

	// WeaversBenefitsScheme Master
	public static final Error SELECT_WEAVERSBENEFITS = new Error(34200);
	public static final Error WEAVERSBENEFITS_CODE_EMPTY = new Error(34201);
	public static final Error WEAVERSBENEFITS_NAME_EMPTY = new Error(34202);
	public static final Error WEAVERSBENEFITS_LOC_NAME_EMPTY = new Error(34203);
	public static final Error WEAVERSBENEFITS_ELIGIBILITY_AMOUNT_EMPTY = new Error(34204);
	public static final Error WEAVERSBENEFITS_PLAN_FROM_EMPTY = new Error(34205);
	public static final Error WEAVERSBENEFITS_PLAN_TO_EMPTY = new Error(34206);
	public static final Error WEAVERSBENEFITS_STATUS_EMPTY = new Error(34207);

	public static final Error WEAVERSBENEFITS_CODE_MIN_MAX_ERROR = new Error(34208);
	public static final Error WEAVERSBENEFITS_NAME_MIN_MAX_ERROR = new Error(34209);
	public static final Error WEAVERSBENEFITS_LOC_NAME_MIN_MAX_ERROR = new Error(34210);

	public static final Error WEAVERSBENEFITS_SAVE_SUCCESS = new Error(34211);
	public static final Error WEAVERSBENEFITS_UPDATE_SUCCESS = new Error(34212);
	public static final Error WEAVERSBENEFITS_DELETE_SUCCESS = new Error(34213);

	public static final Error WEAVERSBENEFITS_NAME_ALREADY_EXIST = new Error(34214);
	public static final Error WEAVERSBENEFITS_CODE_ALREADY_EXIST = new Error(34215);
	public static final Error WEAVERSBENEFITS_LNAME_ALREADY_EXIST = new Error(34214);

	public static final Error WEAVERSBENEFITS_NOT_FOUND = new Error(34216);
	public static final Error WEAVERSBENEFITS_ID_NULL = new Error(34217);

	// productDevelopment and Design
	public static final Error PRODUCT_DESIGN_ITEM_ADD_SUCCESS = new Error(34190);
	public static final Error PRODUCT_DESIGN_ITEM_ADD_FAILURE = new Error(34191);
	public static final Error PRODUCT_DESIGN_SAVE_SUCCESS = new Error(34192);
	public static final Error PRODUCT_DESIGN_SAVE_FAILURE = new Error(34193);
	public static final Error PRODUCT_DESIGN_TABLE_EMPTY = new Error(34194);
	public static final Error PRODUCT_DESIGN_CREATE_NOTE_SUCCESS = new Error(34195);
	public static final Error PRODUCT_DESIGN_CREATE_NOTE_EMPTY = new Error(34196);
	public static final Error PRODUCT_DESIGN_TARGET_QUANTITY_REQUIRED = new Error(34197);
	public static final Error PRODUCT_DESIGN_TARGET_FINAL_APPROVE_REQUIRED = new Error(34198);
	public static final Error STOCK_ITEM_INWARD_PNS_INVOICE_FILE_SIZE = new Error(66670);
	public static final Error PRODUCT_DESIGN_USER_FORWARD_ALREADY_EXIST = new Error(66672);
	public static final Error PRODUCT_DESIGN_USER_INVALID_FINAL_APPROVE = new Error(66673);
	public static final Error PRODUCT_DESIGN_USER_INVALID_NOTE = new Error(66674);
	public static final Error PRODUCT_DESIGN_DELETE_SUCCESS = new Error(66675);
	public static final Error PRODUCT_DESIGN_DELETE_FAILED = new Error(66676);
	public static final Error PRODUCT_DESIGN_DELETE_STAGE_WARNING = new Error(66677);
	public static final Error PRODUCT_DESIGN_APPROVE_SUCCESS = new Error(66678);
	public static final Error PRODUCT_DESIGN_APPROVE_FAILED = new Error(66679);
	public static final Error PRODUCT_DESIGN_REJECTED_SUCCESS = new Error(66680);
	public static final Error PRODUCT_DESIGN_REJECTED_FAILED = new Error(66681);

	// Policy Note Process
	public static final Error POLICY_NOTE_PROCESS_COMMENTS = new Error(34177);
	public static final Error POLICY_NOTE_PROCESS_FORWARDTO = new Error(34178);
	public static final Error POLICY_NOTE_PROCESS_FORWARDFOR = new Error(34179);
	public static final Error POLICY_NOTE_PROCESS_CREATENOTE = new Error(34180);
	public static final Error POLICY_NOTE_PROCESS_APPROVE_EXISTS = new Error(34181);
	public static final Error POLICY_NOTE_PROCESS_APPROVE = new Error(34182);
	public static final Error POLICY_NOTE_PROCESS_REJECTED = new Error(34183);
	public static final Error POLICY_NOTE_PROCESS_UPLOADFILE_EMPTY = new Error(34319);

	public static final Error ADVERTISEMENT_CREATE_SUCCESS = new Error(66696);
	public static final Error ADVERTISEMENT_UPDATE_SUCCESS = new Error(66695);
	public static final Error ADVERTISEMENT_CATEGORY_REQUIRED = new Error(66694);
	public static final Error ADVERTISEMENT_TYPE_REQUIRED = new Error(66693);
	public static final Error ADVERTISEMENT_MEDIA_TYPE_REQUIRED = new Error(66692);
	public static final Error ADVERTISEMENT_MEDIA_NAME_REQUIRED = new Error(66691);
	public static final Error ADVERTISEMENT_NOTE_REQUIRED = new Error(6690);

	// Tender
	public static final Error TENDER_CREATED_SUCCESSFULLY = new Error(66671);
	public static final Error TENDER_APPLY_UPLOAD_SUCCESS = new Error(66166);
	public static final Error TENDER_UPDATED_SUCCESSFULLY = new Error(33808);
	public static final Error TENDER_DELETED_SUCCESSFULLY = new Error(33809);
	public static final Error TENDER_ALREADY_APPLIED = new Error(33810);
	public static final Error TENDER_ALREADY_EXIST = new Error(33811);

	// Code Allotment
	public static final Error CODE_ALLOTMENT_SOCIETY_REG_REQ_EMPTY = new Error(34218);
	public static final Error CODE_ALLOTMENT_SUPPLIER_ADDED_SUCCESSFULLY = new Error(34219);

	public static final Error FROM_DATE_REQUIRED = new Error(34220);
	public static final Error TO_DATE_REQUIRED = new Error(34221);
	public static final Error HEAD_OFFICE_REQUIRED = new Error(34222);

	public static final Error HELPDESK_TICKET_ID_EMPTY = new Error(44524);

	// Showroom RegionWise DNS Report
	public static final Error SHOWROOM_REGIONWISE_ENTITYMASTERLIST = new Error(44525);
	public static final Error SHOWROOM_REGIONWISE_SALESTYPELIST = new Error(44526);
	public static final Error SHOWROOM_REGIONWISE_SHOWROOMTYPELIST = new Error(44527);

	// Exhibition Master
	public static final Error EXHIBITION_NAME_MIN_MAX_ERROR = new Error(1144889);
	public static final Error EXHIBITION_CODE_MIN_MAX_ERROR = new Error(1144893);
	public static final Error EXHIBITION_ADDRESS_EMPTY = new Error(1144890);
	public static final Error EXHIBITION_NAME_EXIST = new Error(1144891);
	public static final Error EXHIBITION_CODE_EXIST = new Error(1144892);
	public static final Error EXHIBITION_INSERTED_SUCCESSFULLY = new Error(1144894);
	public static final Error EXHIBITION_DELETE_SUCCESSFULLY = new Error(1144895);
	public static final Error EXHIBITION_NOT_FOUND = new Error(1144896);
	public static final Error EXHIBITION_UPDATE_SUCCESSFULLY = new Error(1144897);

	public static final Error EXHIBITION_CONTACT_NUMBER_VALIDATION = new Error(114460);
	public static final Error EXHIBITION_LNAME_EXIST = new Error(114461);

	// AssetCategory Master
	public static final Error ASSETCATEGORY_SELECT = new Error(234898);
	public static final Error ASSETCATEGORY_SAVE_SUCCESS = new Error(234899);
	public static final Error ASSETCATEGORY_UPDATE_SUCCESS = new Error(2348100);
	public static final Error ASSETCATEGORY_CODE_EMPTY = new Error(2348101);
	public static final Error ASSETCATEGORY_NAME_EMPTY = new Error(2348102);
	public static final Error ASSETCATEGORY_LOCALNAME_EMPTY = new Error(2348103);
	public static final Error ASSETCATEGORY_ACTIVESTATUS_EMPTY = new Error(2348104);
	public static final Error ASSETCATEGORY_EMPTY = new Error(2348105);
	public static final Error ASSETCATEGORY_DELETE_SUCCESS = new Error(2348106);
	public static final Error ASSETCATEGORY_CODE_EXIST = new Error(2348107);
	public static final Error ASSETCATEGORY_NAME_EXIST = new Error(2348108);
	public static final Error ASSETCATEGORY_LOCALNAME_EXIST = new Error(2348109);

	// ProductDesignAchievement
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_SAVE_SUCCESS = new Error(66682);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_SAVE_ERROR = new Error(66683);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_COLLECTOR_SAVE_SUCCESS = new Error(66684);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_COLLECTOR_SAVE_ERROR = new Error(66685);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_INVALID_QNTY = new Error(66686);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_INVALID_DESIGN_BASED = new Error(66687);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_INVALID_DESCRIPTION = new Error(66688);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_INVALID_LIST = new Error(66689);
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_DELETE_SUCCESS = new Error(3804);// new
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_DELETE_FAILED = new Error(3805);// new
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_DELETE_ERROR = new Error(3806); // new
	public static final Error PRODUCT_DESIGN_ACHIEVEMENT_NULL_ENTITY = new Error(3807); // new

	// Library Register
	public static final Error LIBRARY_REGISTER_SAVE = new Error(34184);
	public static final Error LIBRARY_REGISTER_VISITER_TYPE = new Error(34223);
	public static final Error LIBRARY_REGISTER_EMPLOYEE = new Error(34185);
	public static final Error LIBRARY_REGISTER_DATE = new Error(34186);
	public static final Error LIBRARY_REGISTER_INTIME = new Error(34187);
	public static final Error LIBRARY_REGISTER_OUTTIME = new Error(34188);
	public static final Error LIBRARY_REGISTER_PURPOSEOFVISIT = new Error(34189);
	public static final Error LIBRARY_REGISTER_BOOKLEND = new Error(34199);
	public static final Error LIBRARY_REGISTER_DUDDATE = new Error(34224);
	public static final Error LIBRARY_REGISTER_RETURNDATE = new Error(34225);
	public static final Error LIBRARY_REGISTER_CONDUCTNO = new Error(34226);
	public static final Error LIBRARY_REGISTER_UPDATE = new Error(34227);
	public static final Error LIBRARY_REGISTER_DELETE = new Error(34228);
	public static final Error LIBRARY_REGISTER_NAME = new Error(34229);

	public static final Error COMPLAINT_TYPE_REQUIRED = new Error(5106);

	public static final Error VOUCHER_NET_AMOUNT_EMPTY = new Error(90000);
	public static final Error FORWARD_TO_USER_EMPTY = new Error(90001);
	public static final Error INVOICE_FROM_DATE_EMPTY = new Error(90002);
	public static final Error INVOICE_TO_DATE_EMPTY = new Error(90003);
	public static final Error VOUCHER_NARRATION_EMPTY = new Error(90004);
	public static final Error VOUCHER_NOTE_COMMENT_EMPTY = new Error(90005);
	public static final Error PAYMENT_MODE_EMPTY = new Error(90006);
	public static final Error FORWARD_FOR_EMPTY = new Error(90007);

	// Tender Evaluation

	public static final Error TENDER_VALUE_NOT_EMPTY = new Error(66163);
	public static final Error SUPPLIER_INFO_NOT_EMPTY = new Error(66164);
	public static final Error TENDER_TYPE_VALUE_NOT_EMPTY = new Error(66165);
	public static final Error TENDER_EVAL_INSERTED_SUCCESSFULLY = new Error(66167);

	public static final Error TENDER_NEGOTIATION_INSERTED_SUCCESSFULLY = new Error(444555);
	public static final Error TENDER_AWARDING_CREATED_SUCCESSFULLY = new Error(444556);

	// Stop Invoice and Releas invoice section
	public static final Error PURCHASE_INVOICE_EMPTY = new Error(100);

	public static final Error SOCIETY_IS_EMPTY = new Error(101);
	public static final Error NOTE_IS_EMPTY = new Error(102);
	public static final Error INVOICE_FROM_DATE = new Error(103);
	public static final Error INVOICE_TO_DATE = new Error(104);

	// Stock transfer report
	public static final Error STOCK_FROM_REQUIRED = new Error(3808);
	public static final Error STOCK_TO_REQUIRED = new Error(3809);
	public static final Error STOCK_TRANSFER_DATE_REQUIRED = new Error(3810);
	public static final Error STOCK_TRANSFER_TYPE_REQUIRED = new Error(3811);

	public static final Error HELDPESK_TICKET_FAQ_SAVE_SUCCESS = new Error(44643);
	public static final Error HELDPESK_TICKET_FAQ_DELETE_SUCCESS = new Error(44644);
	public static final Error SELECT_TICKET_FAQ = new Error(44645);
	public static final Error TICKET_FAQ_CATEGORY_EMPTY = new Error(44646);
	public static final Error TICKET_FAQ_QUESTION_EMPTY = new Error(44647);
	public static final Error TICKET_FAQ_ANSWER_EMPTY = new Error(44648);
	public static final Error TICKET_FAQ_EMPTY = new Error(44649);
	public static final Error TICKET_FAQ_CATEGORY_ID_EMPTY = new Error(44650);
	public static final Error HELDPESK_TICKET_FAQ_UPDATE_SUCCESS = new Error(44651);

	public static final Error RULE_EMPTY = new Error(44654);
	public static final Error RULENAME_EMPTY = new Error(44655);
	public static final Error RULE_ISSUE_REASON_EMPTY = new Error(44656);
	public static final Error RULE_CATEGORY_EMPTY = new Error(44657);
	public static final Error RULE_STATUS_EMPTY = new Error(44658);
	public static final Error RULE_PRIORITY_EMPTY = new Error(44659);
	public static final Error THRESHOLD_MIN_EMPTY = new Error(44660);
	public static final Error THRESHOLD_SEC_EMPTY = new Error(44661);
	public static final Error EMAIL_TEMPLATE_EMPTY = new Error(44662);
	public static final Error SMS_TEMPLATE_EMPTY = new Error(44663);
	public static final Error RULE_NAMEMAX_ERROR = new Error(44664);
	public static final Error RULE_SAVE_SUCCESS = new Error(44665);
	public static final Error RULE_UPDATE_SUCCESS = new Error(44666);
	public static final Error RULE_DELETE_SUCCESS = new Error(44667);

	// YarnPriceFixation
	public static final Error YARN_PRICE_FIXATION_INVALID_COMMITTEE_MEMBER = new Error(3900);
	public static final Error YARN_PRICE_FIXATION_INVALID_COMMITTEE_OFFICE = new Error(3901);
	public static final Error YARN_PRICE_FIXATION_INVALID_COMMITTEE_DESIGNATION = new Error(3902);
	public static final Error YARN_PRICE_FIXATION_COMMITTEE_ADD_SUCCESS = new Error(3903);
	public static final Error YARN_PRICE_FIXATION_COMMITTEE_ADD_FAILED = new Error(3904);
	public static final Error YARN_PRICE_FIXATION_COMMITTEE_TABLE_NULL = new Error(3905);

	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_CATEGORY = new Error(3906);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_TYPE = new Error(3907);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_TOTAL_REQ_QTY = new Error(3908);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_ALLOTED_QTY = new Error(3909);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_BAL_QTY = new Error(3910);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_INVALID_SUPPLIER = new Error(3911);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_ADD_SUCCESS = new Error(3912);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_ADD_FAILED = new Error(3913);
	public static final Error YARN_PRICE_FIXATION_SUPPLIER_TABLE_NULL = new Error(3914);

	public static final Error YARN_PRICE_FIXATION_PURCHASE_PRICE_TABLE_NULL = new Error(3915);

	public static final Error YARN_PRICE_FIXATION_UNIT_WISE_TABLE_NULL = new Error(3916);

	public static final Error YARN_PRICE_FIXATION_SAVE_SUCCESS = new Error(3897);
	public static final Error YARN_PRICE_FIXATION_SAVE_FAILED = new Error(3898);
	public static final Error YARN_PRICE_FIXATION_SAVE_ERROR = new Error(3899);
	public static final Error YARN_PRICE_FIXATION_PURCHASE_TABLE_PRICE_NULL = new Error(3896);
	public static final Error YARN_PRICE_FIXATION_PURCHASE_TABLE_VALIDITY_DATE_NULL = new Error(3895);

	// AppConfig
	public static final Error APP_CONFIG_SAVE_SUCCESS = new Error(3894);
	public static final Error APP_CONFIG_SAVE_FAILED = new Error(3893);
	public static final Error APP_CONFIG_SECOND_PWD_INVALID = new Error(3892);
	public static final Error APP_CONFIG_UPDATE_SUCCESS = new Error(3891);
	public static final Error APP_CONFIG_UPDATE_FAILED = new Error(3890);
	public static final Error APP_CONFIG_DELETE_SUCCESS = new Error(3889);
	public static final Error APP_CONFIG_DELETE_FAILED = new Error(3888);
	public static final Error APP_CONFIG_KEY_ALREADY_EXIST = new Error(3887);

	// Purchase sales advance
	public static final Error PURCHASE_SALES_ADVNC_INVALID_TOTAL_AMT = new Error(3886);
	public static final Error PURCHASE_SALES_ADVNC_SAVE_SUCCESS = new Error(3885);
	public static final Error PURCHASE_SALES_ADVNC_SAVE_FAILED = new Error(3884);
	public static final Error PURCHASE_SALES_ADVNC_UPDATE_FAILED = new Error(3883);
	public static final Error PURCHASE_SALES_ADVNC_UPDATE_SUCCESS = new Error(3882);
	public static final Error PURCHASE_SALES_ADVNC_DELETE_FAILED = new Error(3881);
	public static final Error PURCHASE_SALES_ADVNC_DELETE_SUCCESS = new Error(3880);
	// Advance Payment
	public static final Error ADVANCE_PAYMENT_SAVE_SUCCESS = new Error(3860);
	public static final Error ADVANCE_PAYMENT_SAVE_FAILED = new Error(3861);
	public static final Error ADVANCE_PAYMENT_UDPATE_SUCCESS = new Error(3862);
	public static final Error ADVANCE_PAYMENT_UPDATE_FAILED = new Error(3863);
	public static final Error ADVANCE_PAYMENT_VIEW_FAILED = new Error(3864);
	public static final Error ADVANCE_PAYMENT_APPROVE_SUCCESS = new Error(3865);
	public static final Error ADVANCE_PAYMENT_APPROVE_FAILED = new Error(3866);
	public static final Error ADVANCE_PAYMENT_DELETE_FAILED = new Error(3867);
	public static final Error ADVANCE_PAYMENT_DELETE_SUCCESS = new Error(3868);

	// bank cheque clearance
	public static final Error CHEQUE_CLEARANCE_INVALID_CHEQUE_TYPE = new Error(3869);
	public static final Error CHEQUE_CLEARANCE_INVALID_FROM_DATE = new Error(3870);
	public static final Error CHEQUE_CLEARANCE_INVALID_TO_DATE = new Error(3871);
	public static final Error CHEQUE_CLEARANCE_UPDATE_SUCCESS = new Error(3872);
	public static final Error CHEQUE_CLEARANCE_UPDATE_FAILED = new Error(3873);
	// Cash To Bank
	public static final Error DATE_IS_EMPTY = new Error(23021);
	public static final Error CASH_TO_BANK_IS_EMPTY = new Error(23022);
	public static final Error CASH_TO_BANK_FORWARD_TO = new Error(23023);
	public static final Error CASH_TO_BANK_NOTES = new Error(23024);
	public static final Error TOTAL_AMOUNT_TRANSFER = new Error(23025);
	public static final Error CASH_TO_BANK_CREATED_SUCCESSFULLY = new Error(23026);
	public static final Error CASH_TO_BANK_SELECT_ERROR = new Error(23027);
	public static final Error CASH_TO_BANK_UPDATED_SUCCESSFULLY = new Error(23028);
	public static final Error CASH_TO_BANK_APPROVE = new Error(23029);
	public static final Error CASH_TO_BANK_REJECT = new Error(23030);

	public static final Error PRODUCT_CATEGORYWISE_CATEGORYLIST = new Error(44668);
	public static final Error PRODUCT_CATEGORYWISE_PLANCODELIST = new Error(44669);
	public static final Error PRODUCT_CATEGORYWISE_PRODUCTVARIETYLIST = new Error(44670);
	public static final Error PRODUCT_CATEGORYWISE_REGIONLIST = new Error(44671);

	public static final Error PRODUCT_CATEGORY_CREATE_SUCCESS = new Error(1189);
	public static final Error PRODUCT_CATEGORY_UPDATE_SUCCESS = new Error(1188);

	public static final Error FILE_MOVEMENT_ADDED_SUCCESSFULLY = new Error(2348110);

	public static final Error CLAIM_STATEMENT_CATEGORYCODE_EMPTY = new Error(44680);
	public static final Error CLAIM_STATEMENT_REGIONCODE_EMPTY = new Error(44681);
	public static final Error REBATE_CLAIM_SAVE = new Error(44682);
	public static final Error REBATE_CLAIMID_EMPTY = new Error(341370);

	// SeniorityReport
	public static final Error HO_RO_REQUIRED = new Error(2000001);
	public static final Error CADRE_MASTER_REQUIRED = new Error(2000002);
	public static final Error DATE_REQUIRED = new Error(2000003);
	public static final Error Query_REQUIRED = new Error(2000004);

	public static final Error CLAIMSTATEMENTDTO_EMPTY = new Error(44675);
	public static final Error CLAIMSTATEMENT_REQUESTDTO_EMPTY = new Error(44676);
	public static final Error CLAIMSTATEMENT_FROMDATE_EMPTY = new Error(44677);
	public static final Error CLAIMSTATEMENT_TODATE_EMPTY = new Error(44678);
	public static final Error CLAIMSTATEMENT_SELECT = new Error(44679);

	// Staff monthly conveyance
	public static final Error SELECT_STAFFCONVEYANCE = new Error(44672);
	public static final Error VOUCHER_NOTE = new Error(44673);
	public static final Error VOUCHER_CREATE_SUCESS = new Error(44674);
	public static final Error VOUCHER_REJECTED_SUCESS = new Error(2790);
	public static final Error VOUCHER_UPDATE_SUCESS = new Error(2793);
	public static final Error VOUCHER_APPROVE_SUCESS = new Error(2792);

	// Cheque to Bank
	public static final Error CHEQUE_TO_BANK_SAVE = new Error(34230);
	public static final Error CHEQUE_TO_BANK_TRANSFER_BY = new Error(34231);
	public static final Error CHEQUE_TO_BANK_UPDATE = new Error(34232);
	public static final Error CHEQUE_TO_BANK_APPROVE = new Error(34233);
	public static final Error CHEQUE_TO_BANK_REJECT = new Error(34234);

	// Yarn Request Consolidation
	public static final Error FROM_MONTH_REQUIRED = new Error(1200);
	public static final Error TO_MONTH_REQUIRED = new Error(1199);
	public static final Error FROM_YEAR_REQUIRED = new Error(1198);
	public static final Error TO_YEAR_REQUIRED = new Error(1197);
	public static final Error NOTE_REQUIRED = new Error(1195);
	public static final Error YARN_REQUIREMENT_CONSOLIDATION_CREATE_SUCCESS = new Error(1193);
	public static final Error YARN_REQUIREMENT_CONSOLIDATION_ALREADY_PRESENT = new Error(1192);
	public static final Error YARN_REQUIREMENT_ALREADY_PRESENT = new Error(1191);
	public static final Error YARN_REQUIREMENT_CREATE_SUCCESS = new Error(1190);

	public static final Error CREATE_RAISE_COMPLAINT_FILE_SIZE_ERROR = new Error(200000);
	public static final Error CREATE_RAISE_COMPLAINT_FILE_UPLOAD_SUCCESS = new Error(200001);
	public static final Error DEPARTMENT_ID_EMPTY = new Error(200002);
	public static final Error COMPLAINT_TYPE_MASTER_ID_EMPTY = new Error(200003);
	public static final Error COMPLAINT_DESCRIPTION_EMPTY = new Error(200004);
	public static final Error COMPLAINT_RAISED_DATE_EMPTY = new Error(200005);

	public static final Error LOG_STAGE_EMPTY = new Error(200006);
	public static final Error LOG_REMARKS_EMPTY = new Error(200007);
	public static final Error EMP_COMPLAINT_REGISTER_NOTE_EMPTY = new Error(200008);
	public static final Error FINAL_APPROVAL_EMPTY = new Error(200009);
	public static final Error EMP_COMPLAINT_REGISTER_ID_EMPTY = new Error(200010);
	public static final Error EMP_COMPLAINT_REGISTER_NOTE_ID_EMPTY = new Error(200011);
	public static final Error EMP_COMPLAINT_REGISTER_ID_NOT_FOUND = new Error(200012);
	public static final Error EMP_COMPLAINT_REGISTER_INVALID_STATUS = new Error(200013);

	public static final Error PETITIONER_TYPE_CODE_SHOULD_NOT_BE_DUPLICATE = new Error(2348111);

	public static final Error PETITIONER_TYPE_NAME_SHOULD_NOT_BE_DUPLICATE = new Error(2348112);

	// Petition Register
	public static final Error SELECT_PETITION = new Error(7076);
	public static final Error PETITION_REGISTER_SAVE_SUCCESS = new Error(7077);
	public static final Error PETITION_REGISTER_UPDATE_SUCCESS = new Error(7078);
	public static final Error PETITION_REGISTER_DELETE_SUCCESS = new Error(7079);
	public static final Error PETITION_REGISTER_DELETE_FAILURE = new Error(7097);
	public static final Error PETITION_REGISTER_REJECTED_SUCCESS = new Error(7070);
	public static final Error PETITION_REGISTER_APPROVED_SUCCESS = new Error(7071);
	public static final Error PETITION_REGISTER_FILE_UPLOAD_SUCCESS = new Error(8072);

	// PetitionType
	public static final Error PETITIONTYPE_DELETE_SUCCESS = new Error(55555);
	public static final Error PETITIONTYPE_SAVE_SUCCESS = new Error(55556);
	public static final Error SELECT_PETITIONTYPE = new Error(55557);
	public static final Error PETITIONTYPE_UPDATE_SUCCESS = new Error(55558);

	public static final Error PETITIONTYPE_CODE_EMPTY = new Error(55559);
	public static final Error PETITIONTYPE_CODE_MIN_MAX_ERROR = new Error(55560);
	public static final Error PETITIONTYPE_NAME_EMPTY = new Error(55561);
	public static final Error PETITIONTYPE_NAME_MIN_MAX_ERROR = new Error(55562);
	public static final Error PETITIONTYPE_LOC_NAME_MIN_MAX_ERROR = new Error(55563);
	public static final Error PETITIONTYPE_LOC_NAME_EMPTY = new Error(55564);
	public static final Error PETITIONTYPE_STATUS_EMPTY = new Error(55565);
	public static final Error PETITIONTYPE_CODE_ALREADY_EXIST = new Error(55566);
	public static final Error PETITIONTYPE_NAME_ALREADY_EXIST = new Error(55567);
	public static final Error PETITIONTYPE_NOT_FOUND = new Error(55568);
	public static final Error PETITIONTYPE_LOCALNAME_ALREADY_EXIST = new Error(55569);

	// PetitionSource
	public static final Error PETITION_SOURCE_ID_SHOULD_NOT_BE_NULL = new Error(900102);
	public static final Error CANNOT_DELETE_PETITIONSOURCE_RECORD = new Error(900103);
	public static final Error PETITION_SOURCE_NAME_DOES_NOT_EXITS = new Error(900104);
	public static final Error PETITION_SOURCE_L_NAME_SHOULD_NOT_BE_DUPLICATE = new Error(900105);
	public static final Error PETITIONSOURCE_CODE_EMPTY = new Error(900106);
	public static final Error PETITIONSOURCE_NAME_EMPTY = new Error(900107);
	public static final Error PETITIONSOURCE_LNAME_EMPTY = new Error(900108);
	public static final Error PETITIONSOURCE_CODE_DUPLICATE = new Error(900109);
	public static final Error PETITIONSOURCE_FIRST_NAME_DUPLICATE = new Error(900110);
	public static final Error PETITIONSOURCE_LOCAL_NAME_DUPLICATE = new Error(900111);
	public static final Error PETITIONSOURCE_NAME_MIN_MAX_ERROR = new Error(900112);

	// File Numbering
	public static final Error SELECT_FILENUMBER = new Error(34236);
	public static final Error FILENUMBERING_FILE_NAME_EMPTY = new Error(34237);
	public static final Error FILENUMBERING_DEPARTMENT_EMPTY = new Error(34238);
	public static final Error FILENUMBERING_SECTION_EMPTY = new Error(34239);

	public static final Error FILENUMBERING_SAVE_SUCCESS = new Error(34240);
	public static final Error FILENUMBERING_UPDATE_SUCCESS = new Error(34241);
	public static final Error FILENUMBERING_DELETE_SUCCESS = new Error(34242);

	public static final Error FILENUMBERING_FILENUMBER_ALREADY_EXIST = new Error(34243);

	public static final Error FILENUMBERING_NOT_FOUND = new Error(34244);
	public static final Error FILENUMBERING_ID_NULL = new Error(34245);

	// Purchase Quotation
	public static final Error PURCHASEQUOTATION_SAVE_SUCCESS = new Error(1144898);
	public static final Error PURCHASEQUOTATION_SAVE_FAILED = new Error(1144899);
	public static final Error PURCHASEQUOTATION_UPDATE_SUCCESS = new Error(1144900);
	public static final Error PURCHASEQUOTATION_DELETE_SUCCESS = new Error(1144901);
	public static final Error PURCHASEQUOTATION_ITEM_DELETE_SUCCESS = new Error(1144902);
	public static final Error PURCHASEQUOTATION_UPDATE_FAILED = new Error(1144903);
	public static final Error PURCHASEQUOTATION_PRODUCTITEM_EMPTY = new Error(1144904);
	public static final Error PURCHASEQUOTATION_ITEMTAX_EMPTY = new Error(1144905);
	// Society Payment
	public static final Error SOCIETY_PAYMENT_INSERTED_SUCCESS = new Error(63776);
	public static final Error SOCIETY_PAYMENT_DELETED_SUCCESS = new Error(63076);
	public static final Error SOCIETY_PAYMENT_NOT_DELETED = new Error(63069);
	public static final Error SOCIETY_PAYMENT_ID_NOT_EMPTY = new Error(63369);
	public static final Error SOCIETY_PAYMENT_TOTAL_AMOUNT_NOT_EMPTY = new Error(73069);
	public static final Error SOCIETY_PAYMENT_INTEREST_PAYMENT_NOT_EMPTY = new Error(74069);

	public static final Error PETITIONERTYPE_CODE_DUPLICATE = new Error(50238);
	public static final Error PETITIONERTYPE_FIRST_NAME_DUPLICATE = new Error(50239);
	public static final Error PETITIONERTYPE_LAST_NAME_DUPLICATE = new Error(50236);

	public static final Error REBATECOLLECTIONDTO_EMPTY = new Error(44683);
	public static final Error REBATECOLLECTION_VOUCHER_EMPTY = new Error(44684);
	public static final Error REBATECOLLECTION_CLAIMAMOUNT_EMPTY = new Error(44685);
	public static final Error REBATECOLLECTION_REBATECLAIM_EMPTY = new Error(44686);

	public static final Error SALES_PAYMENT_COLLECTION_SUCCESS = new Error(34235);
	public static final Error EMPTY_SALES_PAYMENT_COLLECTION_AMOUNT = new Error(34250);
	public static final Error SALES_PAYMENT_COLLECTION_EXCEED_BAL_AMOUNT = new Error(34252);
	public static final Error SELECT_ONE_SALES_PAYMENT = new Error(34254);

	// Exhibistion Claim section
	public static final Error EXHIBITION_MASTER_EMPTY = new Error(110);
	public static final Error ENTITY_MASTER_EMPTY = new Error(111);
	public static final Error EXPENSE_DETAILS_EMPTY = new Error(112);
	public static final Error EXPENSE_TYPE_EMPTY = new Error(113);
	public static final Error EXHIBISTION_CLAIM_ID_EMPTY = new Error(114);
	public static final Error STAGE_EMPTY = new Error(115);
	public static final Error EXHIBISTION_CLAIM_EMPTY = new Error(116);
	public static final Error EXHIBISTION__ID_EMPTY = new Error(117);
	public static final Error EXHIBISTION_CLAIM_ITEMS_EMPTY = new Error(118);
	public static final Error EXHIBISTION_CLAIM_LOG_EMPTY = new Error(119);
	public static final Error EXHIBISTION_CLAIM_NOTE_EMPTY = new Error(120);

	// Investment Closing
	public static final Error INVESTMENT_CLOSING_CATEGORY = new Error(34246);
	public static final Error INVESTMENT_CLOSING_TYPE = new Error(34247);
	public static final Error INVESTMENT_CLOSING_BANK = new Error(34248);
	public static final Error INVESTMENT_CLOSING_BRANCH = new Error(34249);
	public static final Error INVESTMENT_CLOSING_INSTITUTION = new Error(34251);
	public static final Error INVESTMENT_CLOSING_INVESTMENT_NUMBER = new Error(34253);
	public static final Error INVESTMENT_CLOSING_INVESTMENT_AMOUNT = new Error(34255);
	public static final Error INVESTMENT_CLOSING_INTREST_AMOUNT = new Error(34256);
	public static final Error INVESTMENT_CLOSING_PAYMENTMODE = new Error(34257);
	public static final Error INVESTMENT_CLOSING_AMOUNT_GREATER = new Error(34258);
	public static final Error INVESTMENT_CLOSING_REFERENCENO = new Error(34259);
	public static final Error INVESTMENT_CLOSING_DOCUMENTDATE = new Error(34260);
	public static final Error INVESTMENT_CLOSING_DOCUMENTBANK = new Error(34261);
	public static final Error INVESTMENT_CLOSING_DOCUMENTAMOUNT = new Error(34262);
	public static final Error INVESTMENT_CLOSING_SAVE = new Error(34263);
	public static final Error INVESTMENT_CLOSING_NOTE = new Error(34264);
	public static final Error INVESTMENT_NUMBER_ALREADY_CLOSE = new Error(34265);

	// HELP DESKK TICKET CATEGORY

	public static final Error HELPDESKTICKETCATEGORY_NAME_ALREADY_EXIST = new Error(444455);
	public static final Error HELPDESKTICKETCATEGORY_LOCAL_NAME_ALREADY_EXIST = new Error(444456);
	public static final Error HELPDESKTICKETCATEGORY_CODE_ALREADY_EXIST = new Error(444457);

	public static final Error HELPDESKTICKETCATEGORY_NAME_MIN_MAX_ERROR = new Error(444458);
	public static final Error HELPDESKTICKETCATEGORY_LNAME_MIN_MAX_ERROR = new Error(444460);
	public static final Error HELPDESKTICKETCATEGORY_NAME_EMPTY = new Error(444459);

	public static final Error HELPDESKTICKETCATEGORY_STATUS_EMPTY = new Error(444461);
	public static final Error HELPDESK_TICKET_CATEGORY_ID_EMPTY = new Error(444462);

	public static final Error EXHIBISTION_CLAIM_DELETE_SUCCESS = new Error(151);
	public static final Error EXHIBISTION_CLAIM_DELETE_FAILURE = new Error(152);

	// Fuel Coupon
	public static final Error FUELCOUPON_BOOKNUMBER_NULL = new Error(50136);
	public static final Error FUELCOUPON__STARTNUMBER_NULL = new Error(50137);
	public static final Error FUELCOUPON__ENDNUMBER_NULL = new Error(50138);
	public static final Error FUELCOUPON_VALIDFROM_NULL = new Error(50139);
	public static final Error FUELCOUPON__VALIDTO_NULL = new Error(50140);
	public static final Error FUELCOUPON__BOOKNUMBER_ALLREADY_EXIST = new Error(50141);
	public static final Error FUELCOUPON_STARTNUMBER_ALEREDY_EXIST = new Error(50142);
	public static final Error FUELCOUPON_ENDNUMBER_ALEREDY_EXIST = new Error(50143);
	public static final Error FUELCOUPON__ENDNUMBER_VALIDATION = new Error(50138);

	public static final Error FUELCOUPON_SAVE_SUCCESS = new Error(50161);
	public static final Error FUELCOUPON_UPDATE_SUCCESS = new Error(50162);
	public static final Error FUELCOUPON_DELETE_SUCCESS = new Error(50163);

	// Expo Claim
	public static final Error EXPO_CLAIM_SAVE_SUCCESS = new Error(44689);
	public static final Error EXPO_CLAIM_STATUS_CHANGE = new Error(153);

	// New Investment
	public static final Error SELECT_NEW_INVESTMENT = new Error(50144);
	public static final Error NEW_INVESTMENT_INVESTMENT_CATEGORY_NULL = new Error(50145);
	public static final Error NEW_INVESTMENT_INVESTMENT_TYPE_NULL = new Error(50146);
	public static final Error NEW_INVESTMENT_INVESTMENT_AMOUNT_NULL = new Error(50147);
	public static final Error NEW_INVESTMENT_INVESTED_DATE_NULL = new Error(50148);
	public static final Error NEW_INVESTMENT_PAY_METHOD_NULL = new Error(50149);
	public static final Error NEW_INVESTMENT_FORWARD_FOR_NULL = new Error(50150);
	public static final Error NEW_INVESTMENT_FORWARD_TO_NULL = new Error(50151);
	public static final Error NEW_INVESTMENT_NOTE_NULL = new Error(50152);

	public static final Error NEW_INVESTMENT_CAN_NOT_EDIT = new Error(50156);

	public static final Error NEW_INVESTMENT_SAVE_SUCCESS = new Error(50153);
	public static final Error NEW_INVESTMENT_UPDATE_SUCCESS = new Error(50154);
	public static final Error NEW_INVESTMENT_DELETE_SUCCESS = new Error(50155);

	public static final Error NEW_INVESTMENT_APPROVED_SUCCESSFULLY = new Error(50157);
	public static final Error NEW_INVESTMENT_REJECTED_SUCCESSFULLY = new Error(50158);

	// KNOWLEDGE BASE
	public static final Error TOPIC_NAME_EMPTY = new Error(45000);
	public static final Error KNOWLEDGE_BASE_SAVE_SUCCESS = new Error(45001);
	public static final Error KNOWLEDGE_BASE_UPDATE_SUCCESS = new Error(45002);
	public static final Error ACTIVE_STATUS_EMPTY = new Error(45003);
	public static final Error DELETE_SUCCESS = new Error(45005);
	public static final Error HELPDESK_KNOWLEDGE_BASE_SELECT_ONE = new Error(25007);

	// AdvanceTypeMaster

	public static final Error ADVANCETYPEMASTER_CODE_EMPTY = new Error(666661);
	public static final Error ADVANCETYPEMASTER_CODE_MIN_MAX_ERROR = new Error(666662);
	public static final Error ADVANCETYPEMASTER_NAME_EMPTY = new Error(666663);
	public static final Error ADVANCETYPEMASTER_NAME_MIN_MAX_ERROR = new Error(666664);
	public static final Error ADVANCETYPEMASTER_LOC_NAME_EMPTY = new Error(666665);
	public static final Error ADVANCETYPEMASTER_LOC_NAME_MIN_MAX_ERROR = new Error(666666);
	public static final Error ADVANCETYPEMASTER_STATUS_EMPTY = new Error(666667);
	public static final Error ADVANCETYPEMASTER_CODE_ALREADY_EXIST = new Error(666668);
	public static final Error ADVANCETYPEMASTER_NAME_ALREADY_EXIST = new Error(666669);
	public static final Error ADVANCETYPEMASTER_ID_NULL = new Error(6666610);
	public static final Error ADVANCETYPEMASTER_NOT_FOUND = new Error(6666611);

	public static final Error ADVANCETYPEMASTER_SAVE_SUCCESS = new Error(6666612);
	public static final Error ADVANCETYPEMASTER_UPDATE_SUCCESS = new Error(6666613);
	public static final Error ADVANCETYPEMASTER_DELETE_SUCCESS = new Error(6666614);
	public static final Error SELECT_ADVANCETYPEMASTER = new Error(6666615);

	// Employee Training
	public static final Error EMPLOYEE_TRAINING_NAME_EMPTY = new Error(29061);
	public static final Error EMPLOYEE_TRAINING_TOPIC_EMPTY = new Error(29062);
	public static final Error EMPLOYEE_TRAINING_SCHEDULED_STARTDATE_EMPTY = new Error(29063);
	public static final Error EMPLOYEE_TRAINING_SCHEDULED_ENDDATE_EMPTY = new Error(29064);
	public static final Error EMPLOYEE_TRAINING_TYPE_EMPTY = new Error(29065);
	public static final Error EMPLOYEE_TRAINING_VENUE_NAME_EMPTY = new Error(29066);
	public static final Error EMPLOYEE_TRAINING_NO_OF_DAYS_EMPTY = new Error(29067);
	public static final Error EMPLOYEE_TRAINING_REASON_EMPTY = new Error(29068);
	public static final Error EMPLOYEE_TRAINING_FORWARD_TO_EMPTY = new Error(29069);
	public static final Error EMPLOYEE_TRAINING_FORWARD_FOR_EMPTY = new Error(29071);
	public static final Error EMPLOYEE_TRAINING_TOPIC_OF_TRAINING_EMPTY = new Error(29072);
	public static final Error EMPLOYEE_TRAINING_DEPARTMENT_EMPTY = new Error(29073);
	public static final Error EMPLOYEE_TRAINING_TRAINER_NAME_EMPTY = new Error(29074);
	public static final Error EMPLOYEE_TRAINING_REFERENCE_NUMBER_EMPTY = new Error(29075);
	public static final Error EMPLOYEE_TRAINING_REFERENCE_DATE_EMPTY = new Error(29076);
	public static final Error EMPLOYEE_TRAINING_INSTITUTION_EMPTY = new Error(29077);
	public static final Error EMPLOYEE_TRAINING_PROGRAM_FEE_EMPTY = new Error(29078);
	public static final Error EMPLOYEE_TRAINING_SAVE_SUCCESS = new Error(2906912);
	public static final Error EMPLOYEE_TRAINING_SAVE_FAILURE = new Error(2906913);
	public static final Error EMPLOYEE_TRAINING_DELETE_SUCCESS = new Error(29080);
	public static final Error EMPLOYEE_TRAINING_DELETE_FAILURE = new Error(29082);
	public static final Error EMPLOYEE_TRAINING_REPORT_SUCCESS = new Error(7777774);
	public static final Error EMPLOYEE_TRAINING_REPORT_FAILURE = new Error(7777775);
	public static final Error EMPLOYEE_TRAINING_APPROVED_SUCCESSFULLY = new Error(7777776);
	public static final Error EMPLOYEE_TRAINING_REJECTED_SUCCESSFULLY = new Error(7777777);
	public static final Error EMPLOYEE_TRAINING_FINAL_APPROVED_SUCCESSFULLY = new Error(7777778);

	// InvestmentCategory

	public static final Error INVESTMENTCATEGORYMASTER_CODE_EMPTY = new Error(777771);;
	public static final Error INVESTMENTCATEGORYMASTER_CODE_MIN_MAX_ERROR = new Error(777772);;
	public static final Error INVESTMENTCATEGORYMASTER_NAME_EMPTY = new Error(777773);;
	public static final Error INVESTMENTCATEGORYMASTER_NAME_MIN_MAX_ERROR = new Error(777774);;
	public static final Error INVESTMENTCATEGORYMASTER_LOC_NAME_EMPTY = new Error(777775);;
	public static final Error INVESTMENTCATEGORYMASTER_LOC_NAME_MIN_MAX_ERROR = new Error(777776);;
	public static final Error INVESTMENTCATEGORYMASTER_STATUS_EMPTY = new Error(777777);;
	public static final Error INVESTMENTCATEGORYMASTER_CODE_ALREADY_EXIST = new Error(777778);;
	public static final Error INVESTMENTCATEGORYMASTER_NAME_ALREADY_EXIST = new Error(777779);;
	public static final Error INVESTMENTCATEGORYMASTER_ID_NULL = new Error(7777710);;
	public static final Error INVESTMENTCATEGORYMASTER_NOT_FOUND = new Error(7777711);
	public static final Error INVESTMENTCATEGORYMASTER_LOCALNAME_ALREADY_EXIST = new Error(7777761);

	public static final Error SELECT_INVESTMENTCATEGORYMASTER = new Error(7777712);
	public static final Error INVESTMENTCATEGORYMASTER_DELETE_SUCCESS = new Error(7777713);
	public static final Error INVESTMENTCATEGORYMASTER_SAVE_SUCCESS = new Error(7777714);
	public static final Error INVESTMENTCATEGORYMASTER_UPDATE_SUCCESS = new Error(7777715);

	// InvestmentTypeMaster
	public static final Error CANNOT_DELETE_INVESTMENTTYPEMASTER_RECORD = new Error(900113);
	public static final Error INVESTMENTTYPEMASTER_ID_SHOULD_NOT_BE_NULL = new Error(900114);
	public static final Error INVESTMENTTYPEMASTER_NAME_DOES_NOT_EXITS = new Error(900115);
	public static final Error INVESTMENTTYPEMASTER_L_NAME_SHOULD_NOT_BE_NULL = new Error(900116);
	public static final Error INVESTMENTTYPEMASTER_CODE_DUPLICATE = new Error(900117);
	public static final Error INVESTMENTTYPEMASTER_NAME_DUPLICATE = new Error(900118);
	public static final Error INVESTMENTTYPEMASTER_LOCAL_NAME_DUPLICATE = new Error(900119);
	public static final Error INVESTMENTTYPEMASTER_CODE_EMPTY = new Error(900120);
	public static final Error INVESTMENTTYPEMASTER_NAME_EMPTY = new Error(900121);
	public static final Error INVESTMENTTYPEMASTER_NAME_MIN_MAX_ERROR = new Error(900122);
	public static final Error INVESTMENTTYPEMASTER_LNAME_EMPTY = new Error(900123);
	public static final Error ACTIVEINVESTMENTTYPEMASTER_CANT_DELETE = new Error(900124);

	// Bank To Bank
	public static final Error BANK_TO_BANK_APPROVE = new Error(2348113);
	public static final Error BANK_TO_BANK_REJECT = new Error(2348115);

	// BankToCashTransfer Code
	public static final Error BANK_TO_CASH_SAVE = new Error(2348120);
	public static final Error BANK_TO_CASH_UPDATE = new Error(2348121);
	public static final Error BANK_TO_CASH_APPROVE = new Error(2348122);
	public static final Error BANK_TO_CASH_REJECT = new Error(2348123);
	public static final Error BANK_TO_CASH_TRANSFER_BY = new Error(2348124);

	// Cash Credit Limit Loan
	public static final Error CASH_CREDIT_APPLIED_LIMIT_LESS_THAN_AVAIL = new Error(2348114);
	public static final Error CASH_CREDIT_APPLIED_LIMIT_SELECT_ONE = new Error(2348116);
	public static final Error CASH_CREDIT_APPLIED_LIMIT_SAVE = new Error(223445225);
	public static final Error CASH_CREDIT_APPLIED_LIMIT_DELETE = new Error(223445226);
	

	// Cash Credit Limit Interest Payment Details
	public static final Error CASH_CREDIT_LIMIT_SAVE = new Error(2348125);
	public static final Error CASH_CREDIT_LIMIT_APPROVED = new Error(2348126);
	public static final Error CASH_CREDIT_LIMIT_REJECT = new Error(2348127);

	// Staff Telephone Expense
	public static final Error STAFF_ELIGIBLE_AMOUNT_NULL = new Error(34266);
	public static final Error STAFF_TELEPHONE_EXPENSE_SAVE = new Error(34267);
	public static final Error STAFF_TELEPHONE_EXPENSE_UPDATE = new Error(34268);
	public static final Error STAFF_TELEPHONE_EXPENSE_DELETE = new Error(34269);
	public static final Error STAFF_TELEPHONE_EXPENSE_APPROVED = new Error(34270);
	public static final Error STAFF_TELEPHONE_EXPENSE_REJECTED = new Error(34271);
	public static final Error STAFF_TELEPHONE_AMOUNT_GRATER = new Error(34272);
	public static final Error STAFF_TELEPHONE_AMOUNT_PAID = new Error(34273);
	public static final Error STAFF_TELEPHONE_STAFF_CODE = new Error(34274);

	// FR Cost Payment
	public static final Error FRCOSTPAYMENTDTO_EMPTY = new Error(44687);
	public static final Error FINYEAR_EMPTY = new Error(44688);
	public static final Error STARTDATE_EMPTY = new Error(44701);
	public static final Error ENDDATE_EMPTY = new Error(44690);
	public static final Error AUDITORNAME_EMPTY = new Error(44691);
	public static final Error FRCOST_REQUESTDTO_EMPTY = new Error(44692);
	public static final Error TOTAL_PAYMENT_EMPTY = new Error(44693);
	public static final Error PAYMENT_METHOD_EMPTY = new Error(44694);
	public static final Error GLACCOUNT_CATEGORY_EMPTY = new Error(44695);
	public static final Error GLACCOUNT_GROUP_EMPTY = new Error(44696);
	public static final Error GLACCOUNT_EMPTY = new Error(44697);
	public static final Error FRNOTE_EMPTY = new Error(44698);
	public static final Error FR_FROWARD_EMPTY = new Error(44699);
	public static final Error USERMASTER_EMPTY = new Error(44700);
	public static final Error PAYMENT_HEAD_EMPTY = new Error(44703);

	public static final Error HELPDESK_TICKET_VALID_PHONE_NUMBER = new Error(29066);

	// file Movement
	public static final Error FILE_MOVEMENT_CREATED_SUCCESSFULLY = new Error(23031);
	public static final Error FILE_MOVEMENT_UPDATED_SUCCESSFULLY = new Error(23032);
	public static final Error FILE_MOVEMENT_DELETED_SUCCESSFULLY = new Error(23033);
	public static final Error FILE_MOVEMENT_SUBJECT_EMPTY = new Error(23034);
	public static final Error FILE_MOVEMENT_CONTENT_EMPTY = new Error(23035);
	public static final Error FILE_MOVEMENT_ENTITY_EMPTY = new Error(23036);
	public static final Error FILE_MOVEMENT_FILE_PATH = new Error(23037);
	public static final Error FILE_MOVEMENT_FILE_TYPE = new Error(23038);
	public static final Error FILE_MOVEMENT_FILE_SIZE = new Error(23039);
	public static final Error FILE_MOVEMENT_FILE_NAME = new Error(23040);
	public static final Error FILE_MOVEMENT_NOTE_EMPTY = new Error(23041);

	// Investment interest collection
	public static final Error INVESTMENT_INTEREST_COLLECTION_SAVE = new Error(2794);
	public static final Error INVESTMENT_INTEREST_COLLECTION_UPDATE = new Error(2795);
	public static final Error INVESTMENT_INTEREST_COLLECTION_APPROVE = new Error(2796);
	public static final Error INVESTMENT_INTEREST_COLLECTION_REJECT = new Error(2797);
	public static final Error INVESTMENT_INTEREST_COLLECTION_SELECT = new Error(2798);

	public static final Error PETTY_CASH_EXPENSE_SAVE_SUCCESS = new Error(29065);
	public static final Error PETTY_CASH_EXPENSE_UPDATE_SUCCESS = new Error(29067);
	public static final Error PETTY_CASH_EXPENSE_APPROVED = new Error(29068);
	public static final Error PETTY_CASH_EXPENSE_REJECTED = new Error(29069);

	public static final Error FRCOSTPAYMENTDTO_SELECT = new Error(44702);

	public static final Error FILE_MOVEMENT_APPROVED_SUCCESSFULLY = new Error(23042);
	public static final Error FILE_MOVEMENT_REJECTED_SUCCESSFULLY = new Error(23043);

	// Stop Invoice
	public static final Error STOP_INVOICE_CREATED_SUCCESSFULLY = new Error(38889);
	public static final Error STOP_INVOICE_DELETED_SUCCESSFULLY = new Error(38819);

	// Weaver Benefit Payment
	public static final Error WEAVER_BENEFIT_PAYMENT_APPROVED = new Error(16001);
	public static final Error WEAVER_BENEFIT_PAYMENT_REJECTED = new Error(16002);
	public static final Error WEAVER_BENEFIT_PAYMENT_SAVED = new Error(16003);
	public static final Error WEAVER_BENEFIT_PAYMENT_UPDATED = new Error(16004);

	// Rent Payment
	public static final Error RENT_PAYMENT_ACCOUNTHEAD_EMPTY = new Error(34275);
	public static final Error RENT_PAYMENT_AMOUNT_EMPTY = new Error(34276);
	public static final Error RENT_PAYMENT_DETAIL_EMPTY = new Error(34277);
	public static final Error RENT_PAYMENT_ENTITY_EMPTY = new Error(34278);
	public static final Error RENT_PAYMENT_FORWARD_TO_NULL = new Error(34279);
	public static final Error SELECT_RENT_PAYMENT = new Error(34280);
	public static final Error RENT_PAYMENT_SAVE_SUCCESS = new Error(34281);
	public static final Error RENT_PAYMENT_UPDATE_SUCCESS = new Error(34282);
	public static final Error RENT_PAYMENT_CAN_NOT_EDIT = new Error(34285);
	public static final Error RENT_PAYMENT_MONTH_EMPTY = new Error(34286);
	public static final Error RENT_PAYMENT_ACCOUNTHEAD_CHOOSE_ANOTHER = new Error(34287);
	public static final Error RENT_PAYMENT_MODE_EMPTY = new Error(34288);
	public static final Error RENT_PAYMENT_NOTE_NULL = new Error(34289);
	public static final Error RENT_PAYMENT_FINALAPPROVAL_NULL = new Error(34290);
	public static final Error RENT_PAYMENT_FORWARDTO_NULL = new Error(34291);
	public static final Error RENT_PAYMENT_DETAIL_ATLEAST_FOR_MONTH = new Error(34292);

	// Forgot Password

	public static final Error EMAIL_TEMPLATE_NOT_FOUND = new Error(2799);
	public static final Error RENT_PAYMENT_APPROVED_SUCCESSFULLY = new Error(34283);
	public static final Error RENT_PAYMENT_REJECTED_SUCCESSFULLY = new Error(34284);

	// bank payment
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_SUPPLIER_GROUP_INVALID = new Error(3874);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_SUPPLIER_NOT_VALID = new Error(3875);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_RECEIPT_TYPE = new Error(3876);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_SAVE_SUCCESS = new Error(3877);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_RECEIPT_SAVE_SUCCESS = new Error(3878);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_SAVE_FAILED = new Error(3879);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_UDPATE_SUCCESS = new Error(3843);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_RECEIPT_SAVE_FAILED = new Error(3840);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_STATUS_CONFLICT = new Error(3841);
	public static final Error FINANCE_ACCOUNTS_BANK_PAYMENT_ALREADY_PAID = new Error(3842);
	public static final Error FINANCE_ACCOUNTS_CASH_PAYMENT_SAVE_SUCCESS = new Error(3844);
	public static final Error FINANCE_ACCOUNTS_CASH_PAYMENT_UDPATE_SUCCESS = new Error(3845);
	public static final Error FINANCE_ACCOUNTS_CASH_PAYMENT_FAILED = new Error(3846);

	// Court case register section
	public static final Error COURT_CASE_REGISTER_EMPTY = new Error(121);
	public static final Error COURT_CASE_TYPE_EMPTY = new Error(122);
	public static final Error COURT_CASE_REGISTER_ID_EMPTY = new Error(123);
	public static final Error COURT_CASE_REGISTER_DELETE_SUCCESS = new Error(124);
	public static final Error COURT_CASE_REGISTER_DELETE_FAILURE = new Error(125);
	public static final Error COURT_CASE_DETAILS_EMPTY = new Error(126);
	public static final Error COURT_ID_EMPTY = new Error(127);
	public static final Error COURT_CASE_TYPE_ID_EMPTY = new Error(128);
	public static final Error COURT_EMP_COMPLAINT_REGISTER_ID_EMPTY = new Error(129);
	public static final Error COUNTER_AFFIDAVIT_EMPTY = new Error(130);
	public static final Error VAKALATH_FILED_EMPTY = new Error(131);
	public static final Error DATE_OF_FILLING_COUNTER_EMPTY = new Error(132);
	public static final Error CASE_STAGE_EMPTY = new Error(133);
	public static final Error LAST_HEARING_DATE_EMPTY = new Error(134);
	public static final Error NEXT_HEARING_DATE_EMPTY = new Error(135);

	// Staff Bonus Payment
	public static final Error STAFFBONUSDTO_EMPTY = new Error(44705);
	public static final Error STAFF_BOUNUSDTO_SELECT = new Error(44704);

	public static final Error EMP_COMPLAINT_REGISTER_EMPTY = new Error(136);
	public static final Error COURT_CASE_FILE_UPLOAD_SUCCESS = new Error(137);
	public static final Error COURT_CASE_SAVE_SUCCESS = new Error(138);

	// Journal Voucher
	public static final Error COURT_CASE_HEARING_SAVE_SUCCESS = new Error(139);

	// Journal Voucher
	public static final Error JOURNAL_VOUCHER_APPROVED = new Error(16005);
	public static final Error JOURNAL_VOUCHER_REJECTED = new Error(16006);
	public static final Error JOURNAL_VOUCHER_SAVED = new Error(16007);
	public static final Error JOURNAL_VOUCHER_UPDATED = new Error(16008);
	public static final Error JOURNAL_VOUCHER_CREDIT_DEBIT = new Error(16009);

	// Budget Consolidatoin
	public static final Error BUDGET_CONSOLIDATION_SAVE = new Error(34293);
	public static final Error BUDGET_CONSOLIDATION_EXISTS = new Error(34294);
	public static final Error BUDGET_CONSOLIDATION_UPDATE = new Error(34295);
	public static final Error BUDGET_CONSOLIDATION_DELETE = new Error(34296);
	public static final Error BUDGET_CONSOLIDATION_APPROVE = new Error(34297);
	public static final Error BUDGET_CONSOLIDATION_REJECT = new Error(34298);

	// PurchaseOrder
	public static final Error PURCHASE_ORDERS_SAVE_SUCCESS = new Error(1144906);
	public static final Error PURCHASE_ORDER_SAVE_FAILED = new Error(1144907);
	public static final Error PURCHASE_ORDER_UPDATE_SUCCESS = new Error(1144908);
	public static final Error PURCHASE_ORDER_UPDATE_FAILED = new Error(1144909);
	public static final Error PURCHASE_ORDER_ITEM_DELETE_SUCCESS = new Error(1144910);
	public static final Error PURCHASE_ORDER_ITEM_EMPTY = new Error(1144911);

	public static final Error PETITION_REGISTER_ACTION_DUE_DATE_NULL = new Error(290689);
	public static final Error PETITION_REGISTER_PETITION_DATE_NULL = new Error(290690);
	public static final Error PETITION_REGISTER_PETITIONER_NAME_NULL = new Error(290691);
	public static final Error PETITION_REGISTER_CONTACT_NUMBER_NULL = new Error(290692);
	public static final Error PETITION_REGISTER_PETITION_PRIORITY_NULL = new Error(290693);
	public static final Error PETITION_REGISTER_FORWARD_TO_NULL = new Error(290694);
	public static final Error PETITION_REGISTER_NOTE_NULL = new Error(290695);

	public static final Error PETTY_CASH_EXPENSE_PAYMENT_EMPTY_LIST = new Error(29070);

	// AssetRegister
	public static final Error ASSETREGISTER_SAVE_SUCCESS = new Error(1234555);
	public static final Error ASSETREGISTER_UPDATE_SUCCESS = new Error(1234556);
	public static final Error ASSETREGISTER_DELETE_SUCCESS = new Error(1234557);
	public static final Error SELECT_ASSETREGISTER = new Error(1234558);
	public static final Error ASSET_REGISTER_UPLOAD_FILE_SIZE = new Error(12345511);
	public static final Error ASSET_REGISTER_FILEUPLOAD = new Error(12345510);

	// Tour Program Codes
	public static final Error TOUR_PROGRAM_SAVE = new Error(2348128);
	public static final Error TOUR_PROGRAM_APPROVED = new Error(2348129);
	public static final Error TOUR_PROGRAM_REJECT = new Error(2348130);

	// Service Invoice
	public static final Error SERVICE_INVOICE_SAVE_SUCCESS = new Error(29071);
	public static final Error SERVICE_INVOICE_UPDATE_SUCCESS = new Error(29072);
	public static final Error SERVICE_INVOICE_SELECT_ONE = new Error(29073);
	public static final Error GOVT_SCHEME_TYPE_EMPTY = new Error(29074);
	public static final Error GOVT_SCHEME_PLAN_EMPTY = new Error(29075);
	public static final Error SERVICE_INVOICE_EXPENSE_TYPE_EMPTY = new Error(29076);
	public static final Error SERVICE_INVOICE_EMPTY = new Error(29077);

	// Edli payment
	public static final Error EDLI_PAYMENT_CREATED_SUCCESSFULLY = new Error(34299);
	public static final Error EDLI_PAYMENT_UPDATED_SUCCESSFULLY = new Error(34300);
	public static final Error EDLI_PAYMENT_DELETED_SUCCESSFULLY = new Error(34301);
	public static final Error EDLI_PAYMENT_FROMDATE_REQUIRED = new Error(34302);
	public static final Error EDLI_PAYMENT_TODATE_REQUIRED = new Error(34303);
	public static final Error EDLI_PAYMENT_AMOUNT_REQUIRED = new Error(34304);
	public static final Error EDLI_PAYMENT_EMPLOYEE_DETAILS_REQUIRED = new Error(34310);
	public static final Error EDLI_PAYMENT_APPROVED = new Error(34411);
	public static final Error EDLI_PAYMENT_REJECTED = new Error(34412);
	public static final Error SELECT_ERROR = new Error(34413);
	public static final Error NOTE_REQUIRED_ERROR = new Error(34414);

	// Imprest Request
	public static final Error IMPREST_REQUEST_AMOUNT_GREATER = new Error(34312);
	public static final Error IMPREST_REQUEST_SAVE = new Error(34313);
	public static final Error IMPREST_REQUEST_UPDATE = new Error(34314);
	public static final Error IMPREST_REQUEST_DELETE = new Error(34315);
	public static final Error IMPREST_REQUEST_APPROVED = new Error(34316);
	public static final Error IMPREST_REQUEST_REJECTED = new Error(34317);
	public static final Error IMPREST_REQUEST_EXISTS = new Error(34318);

	// InventoryConfg

	public static final Error SELECT_INVENTORY_CONFIG = new Error(34361);
	public static final Error INVENTORY_CONFIG_SAVE_SUCCESS = new Error(34362);
	public static final Error INVENTORY_CONFIG_DELETE_SUCCESS = new Error(34363);
	public static final Error INVENTORY_CONFIG_UPDATED_SUCCESS = new Error(34364);
	public static final Error INVENTORY_CONFIG_INVALID_MAXSTOCK = new Error(34365);
	public static final Error INVENTORY_CONFIG_INVALID_MINSTOCK = new Error(34366);
	public static final Error INVENTORY_CONFIG_INVALID_STOCKMAINTANENCETYPE = new Error(34367);
	public static final Error INVENTORY_CONFIG_INVALID_SHOWROOM = new Error(34368);
	public static final Error INVENTORY_CONFIG_INVALID_PRODUCTVARIETY = new Error(34369);
	public static final Error INVENTORY_CONFIG_INVALID_REGION = new Error(34370);
	public static final Error INVENTORY_CONFIG_INVALID_PRODUCTCATEGORY = new Error(34371);
	public static final Error INVENTORY_CONFIG_INVALID_PRODUCTGROUP = new Error(34372);
	public static final Error INVENTORY_CONFIG_ADD_SUCCESS = new Error(34373);
	public static final Error INVENTORY_CONFIG_ADD_FAILED = new Error(34374);
	public static final Error INVENTORY_CONFIG_ITEMS_NULL = new Error(34375);

	// EntitySupplierProductLink
	public static final Error SELECT_ENTITY_SUPPLIER_PRODUCT_LINK = new Error(34561);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_SAVE_SUCCESS = new Error(34562);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_DELETE_SUCCESS = new Error(34563);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_UPDATED_SUCCESS = new Error(34564);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_ITEMS_NULL = new Error(34565);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_ENTITY_TYPE_MASTER = new Error(34566);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_ENTITY_MASTER = new Error(34567);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_PRODUCT_VARIETY_MASTER = new Error(34568);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_SUPPLIER_TYPE_MASTER = new Error(34569);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_CIRCLE_MASTER = new Error(34570);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_INVALID_SUPPLIER_MASTER = new Error(34571);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_ALREADY_EXIST = new Error(34572);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_ADD_FAILED = new Error(34573);
	public static final Error ENTITY_SUPPLIER_PRODUCT_LINK_ADD_SUCCESS = new Error(34574);

	// BankMaster
	public static final Error BANK_MASTER_CODE_REQUIRED = new Error(34670);
	public static final Error BANK_MASTER_NAME_REQUIRED = new Error(34671);
	public static final Error BANK_MASTER_STATUS_REQUIRED = new Error(34672);
	public static final Error SELECT_BANK_MASTER = new Error(34673);
	public static final Error BANK_MASTER_SAVE_SUCCESS = new Error(34674);
	public static final Error BANK_MASTER_DELETE_SUCCESS = new Error(34675);
	public static final Error BANK_MASTER_UPDATED_SUCCESS = new Error(34676);

	// ProductCategoryGroup
	public static final Error PRODUCT_CATEGORY_GROUP_NAME_REQUIRED = new Error(34770);
	public static final Error PRODUCT_CATEGORY_GROUP_CODE_REQUIRED = new Error(34771);
	public static final Error PRODUCT_CATEGORY_GROUP_LNAME_REQUIRED = new Error(34772);
	public static final Error PRODUCT_CATEGORY_GROUP_SAVE_SUCCESS = new Error(34773);
	public static final Error PRODUCT_CATEGORY_GROUP_UPDATE_SUCCESS = new Error(34774);
	public static final Error PRODUCT_CATEGORY_GROUP_DELETE_SUCCESS = new Error(34775);
	public static final Error SELECT_PRODUCT_CATEGORY_GROUP = new Error(34776);

	// ChequeCancellation
	public static final Error CHEQUE_CANCELLATION_SUCCESS = new Error(1234559);
	public static final Error CHEQUE_CANCELLATION_FAILED = new Error(1234560);

	// PaymentFinanceService
	public static final Error PAYMENT_ACCOUNT_SERVICE_ACCOUNTASPECT_NOTVALID = new Error(34311);
	public static final Error API_MULTIPART_MAXFILESIZE_NOT_FOUND = new Error(7777716);

	public static final Error STAFF_PF_PAYMENT_SAVE_SUCCESS = new Error(29078);
	// Invoice
	public static final Error INVOICE_NUMBER_EMPTY = new Error(80846);
	public static final Error INVOICE_DATE_EMPTY = new Error(80847);
	public static final Error INVOICE_AMOUNT_EMPTY = new Error(80848);
	public static final Error INVOICE_DUE_DATE_EMPTY = new Error(80849);
	public static final Error INVOICE_PO_NUMBER_EMPTY = new Error(80709);
	public static final Error RATE_OF_INTEREST_EMPTY = new Error(80909);
	// GradewiseCityConfig
	public static final Error GRADEWISE_CITY_CONFIG_SAVE_SUCCESS = new Error(343112);
	public static final Error GRADEWISE_CITY_CONFIG_SAVE_FAILURE = new Error(343113);
	public static final Error GRADEWISE_CITY_CONFIG_UPDATE_SUCCESS = new Error(343114);
	public static final Error GRADEWISE_CITY_CONFIG_UPDATE_FAILURE = new Error(343115);
	public static final Error CITY_CODE_ALREADY_EXIST_DUPICATECITY = new Error(343116);
	public static final Error ALLOWANCE_GRADE_CITY_DELETE_SUCCESS = new Error(343117);

	// Cheque Book Details
	public static final Error CHEQUEBOOKDETAILS_SAVED_SUCCESSFULLY = new Error(44950);
	public static final Error CHEQUEBOOKDETAILS_UPDATED_SUCCESSFULLY = new Error(44951);
	public static final Error SELECT_CHEQUE_BOOK_DETAILS = new Error(44952);

	// TA BILL
	public static final Error TA_BILL_APPROVED = new Error(16010);
	public static final Error TA_BILL_REJECTED = new Error(16011);

	// Employee Payroll
	public static final Error USER_PASSWORD_DOES_NOT_MATCH = new Error(7300);

	// ECommerceMenuMasterService
	public static final Error ECOMMERCE_MENU_CODE_EMPTY = new Error(120392);
	public static final Error ECOMMERCE_MENU_STATUS_EMPTY = new Error(920312);
	public static final Error ECOMMERCE_MENU_NAME_EMPTY = new Error(872543);
	public static final Error ECOMMERCE_MENU_CODE_EXIST = new Error(826442);
	public static final Error ECOMMERCE_MENU_NAME_ALREADY_EXIST = new Error(172535);
	public static final Error ECOMMERCE_MENU_NOT_FOUND = new Error(387332);
	public static final Error ECOMMERCE_MENU_SAVE_SUCCESS = new Error(387333);
	public static final Error ECOMMERCE_MENU_UPDATE_SUCCESS = new Error(387334);

	public static final Error ECOMMERCE_VIEW_ORDER_TODATE_NULL = new Error(387335);
	public static final Error ECOMMERCE_VIEW_ORDER_FROMDATE_NULL = new Error(387336);

	// Staff Pf Payment
	public static final Error STAFF_PF_PAYMENT_REJECTED = new Error(29079);
	public static final Error STAFF_PF_PAYMENT_APPROVED = new Error(29080);
	public static final Error STAFF_PF_PAYMENT_YEAR_EMPTY = new Error(29081);
	public static final Error STAFF_PF_PAYMENT_NARRATION_EMPTY = new Error(29082);
	public static final Error STAFF_PF_PAYMENT_ID_EMPTY = new Error(29083);
	public static final Error STAFF_PF_PAYMENT_SELECT_ONE_RECORD = new Error(29084);

	// Reserve Creation
	public static final Error RESERVE_CREATION_CREATED_SUCCESSFULLY = new Error(29085);
	public static final Error RESERVE_CREATION_UPDATED_SUCCESSFULLY = new Error(29086);
	public static final Error RESERVE_CREATION_DELETED_SUCCESSFULLY = new Error(29087);

	// CadreWise Pay_Head config

	public static final Error CRADEWISE_PAYHEADCONFIG_TYPE_EMPTY = new Error(25000);
	public static final Error PAYSCALE_CRADEWISE_PAYHEADCONFIG_EMPTY = new Error(25001);
	public static final Error CRADEWISE_PAYHEADCONFIG_EMPTY = new Error(25002);
	public static final Error AMOUNT_PAYHEADCONFIG_EMPTY = new Error(25003);
	public static final Error CRADEWISE_PAYHEADCONFIG_SAVE_SUCCESS = new Error(25004);
	public static final Error CRADEWISE_PAYHEADCONFIG_DELETE_SUCCESS = new Error(25005);
	public static final Error CRADEWISE_PAYHEADCONFIG_DELETE_FAILURE = new Error(25006);
	public static final Error SELECT_ONE = new Error(25008);
	public static final Error FILL_THE_FIELD = new Error(25009);

	// Staff Bonus Payment

	public static final Error STAFF_BONUS_PAYMENT_APPROVED = new Error(900310);
	public static final Error STAFF_BONUS_PAYMENT_REJECTED = new Error(900311);
	public static final Error STAFF_BONUS_SAVED_SUCCESSFULLY = new Error(900336);
	public static final Error STAFF_BONUS_UPDATED_SUCCESSFULLY = new Error(900337);
	// sales target section
	public static final Error SALES_TARGET_ID_EMPTY = new Error(140);
	public static final Error CATEGORY_ID_EMPTY = new Error(141);
	public static final Error FROM_MONTH_EMPTY = new Error(142);
	public static final Error FROM_YEAR_EMPTY = new Error(143);
	public static final Error TO_MONTH_EMPTY = new Error(144);
	public static final Error TO_YEAR_EMPTY = new Error(145);
	public static final Error ENTITY_ID_EMPTY = new Error(146);
	public static final Error SALES_TARGET_DETAILS_EMPTY = new Error(147);

	// Profit Allocation
	public static final Error PROFIT_ALLOCATION_INSERTED_SUCCESSFULLY = new Error(235429);
	public static final Error PROFIT_ALLOCATION_DELETED_SUCCESSFULLY = new Error(235929);
	public static final Error PROFIT_ALLOCATION_ID_NOT_EXIST = new Error(295929);
	public static final Error FINANCAL_YEAR_REQUIRED = new Error(99411);
	public static final Error NET_AMOUNT_REQUIRED = new Error(94011);
	public static final Error PROFIT_ALLOCATION_DETAILS_EMPTY = new Error(94411);
	public static final Error ROASTER_COMMUNITY_CODE_MIN_MAX_ERROR = new Error(341358);

	// Enquiry Officer Error Messages
	public static final Error ENQUIRY_ORGANIZATION_NAME_REQUIRED = new Error(341359);
	public static final Error ENQUIRY_OFFICER_NAME_REQUIRED = new Error(341360);
	public static final Error ENQUIRY_OFFICER_EMAILID_REQUIRED = new Error(341361);
	public static final Error ENQUIRY_OFFICER_CONTACTNUMBER_REQUIRED = new Error(341362);
	public static final Error ENQUIRY_OFFICER_STATUS_REQUIRED = new Error(341363);
	public static final Error ENQUIRY_OFFICER_NOT_EMPTY = new Error(341364);
	public static final Error ENQUIRY_OFFICER_ADDED_SUCCESSFULLY = new Error(341365);
	public static final Error ENQUIRY_OFFICER_DELETED_SUCCESSFULLY = new Error(341366);
	public static final Error ENQUIRY_OFFICER_UPDATED_SUCCESSFULLY = new Error(341367);
	public static final Error ENQUIRY_OFFICER_ID_IS_EMPTY = new Error(341368);
	public static final Error INVALID_CONTACT_NUMBER = new Error(341369);

	// city Master
	public static final Error CITY_MASTER_SAVED_SUCCESSFUL = new Error(25010);
	public static final Error CITY_MASTER_DELETE_SUCCESSFUL = new Error(25011);
	public static final Error CITY_MASTER_REQUIRED = new Error(25012);
	public static final Error CITY_MASTER_CODE_REQUIRED = new Error(25013);
	public static final Error CITY_MASTER_NAME_REQUIRED = new Error(25014);
	public static final Error CITY_MASTER_DISTRICT_REQUIRED = new Error(25015);
	public static final Error CITY_MASTER_LOCALNAME_REQUIRED = new Error(25016);

	public static final Error SALES_TARGET_SAVE_FAILURE = new Error(94511);
	public static final Error SALES_TARGET_SAVE_SUCCESS = new Error(94512);

	// ASSET ALLOCATION

	public static final Error SELECT_ASSET = new Error(987651);
	public static final Error ASSETALLOCATION_DELETE_SUCCESS = new Error(987652);
	public static final Error ASSETALLOCATION_SAVE_SUCCESS = new Error(987653);
	public static final Error ASSETALLOCATION_UPDATE_SUCCESS = new Error(987654);
	public static final Error ASSET_ALLOCATION_ITEM_ADD_FAILURE = new Error(987655);
	public static final Error ASSET_ALLOCATION_NOTE_EMPTY = new Error(987658);

	public static final Error ASSETALLOCATION_APPROVAL_FORWARD_TO_EMPTY = new Error(987659);
	public static final Error ASSETALLOCATION_APPROVAL_APPROVED_SUCCESSFULLY = new Error(987660);
	public static final Error ASSETALLOCATION_REJECTED_SUCCESSFULLY = new Error(987661);

	public static final Error STAFF_GRATUITY_PAYMENT_SAVE_SUCCESS = new Error(29088);
	// Circular Register
	public static final Error CIRCULAR_REGISTER_ENTITY_IS_EMPTY = new Error(87601);

	public static final Error STOCK_ITEM_OUTWARDPNS_ITEM_TABLE_NULL = new Error(198);
	public static final Error STOCK_ITEM_OUTWARDPNS_PRODUCT_TABLE_NULL = new Error(199);

	// SanctionedStaffEligibility Error Messages
	public static final Error SANCTION_STRENGTH_REGION_REQUIRED = new Error(341371);
	public static final Error SANCTION_STRENGTH_DEPARTMENT_REQUIRED = new Error(341372);
	public static final Error SANCTION_STRENGTH_DESIGNATION_REQUIRED = new Error(341373);
	public static final Error SANCTION_STRENGTH_STRENGTH_REQUIRED = new Error(341374);
	public static final Error SANCTION_STRENGTH_STATUS_REQUIRED = new Error(341375);
	public static final Error SANCTION_STRENGTH_FINYEAR_REQUIRED = new Error(341376);
	public static final Error SANCTION_STRENGTH_NOT_EMPTY = new Error(341377);
	public static final Error SANCTION_STRENGTH_ADDED_SUCCESSFULLY = new Error(341378);
	public static final Error SANCTION_STRENGTH_DELETED_SUCCESSFULLY = new Error(341379);
	public static final Error SANCTION_STRENGTH_UPDATED_SUCCESSFULLY = new Error(341380);
	public static final Error SANCTION_STRENGTH_ID_IS_EMPTY = new Error(341381);
	public static final Error SANCTION_STRENGTH_NUMBER = new Error(341382);

	/*
	 * Fuel Type
	 */
	public static final Error SELECT_FUEL_TYPE = new Error(7777717);
	public static final Error ACTIVE_FUEL_TYPE_CANNOT_DELETE = new Error(7777718);
	public static final Error FUEL_TYPE_NAME_EMPTY = new Error(7777719);
	public static final Error FUEL_TYPE_LNAME_EMPTY = new Error(7777720);
	public static final Error FUEL_TYPE_STATUS_EMPTY = new Error(7777721);
	public static final Error FUEL_TYPE_EMPTY = new Error(7777722);
	public static final Error FUEL_TYPE_NAME_MIN_MAX_ERROR = new Error(7777723);
	public static final Error FUEL_TYPE_LNAME_MIN_MAX_ERROR = new Error(7777724);
	public static final Error FUEL_TYPE_SAVE_SUCCESS = new Error(7777725);
	public static final Error FUEL_TYPE_UPDATE_SUCCESS = new Error(7777726);
	public static final Error FUEL_TYPE_DELETE_SUCCESS = new Error(7777727);
	public static final Error FUEL_TYPE_NAME_ALREADY_EXIST = new Error(7777728);
	public static final Error FUEL_TYPE_LNAME_ALREADY_EXIST = new Error(7777729);
	public static final Error FUEL_TYPE_NOT_FOUND = new Error(7777730);
	public static final Error FUEL_TYPE_CODE_EXIST = new Error(7777731);
	public static final Error FUEL_TYPE_ID_NULL = new Error(7777732);
	public static final Error FUEL_TYPE_CODE_EMPTY = new Error(7777733);

	// TDS Payment error message
	public static final Error TDS_PAYMENT_SAVE = new Error(2348131);
	public static final Error TDS_PAYMENT_APPROVED = new Error(2348132);
	public static final Error TDS_PAYMENT_REJECT = new Error(2348133);
	public static final Error TDS_PAYMENT_NOTE_REQUIRED = new Error(2348134);

	// Asset Insurence Payment
	public static final Error ASSET_INSURANCE_PAYMENT_CREATED_SUCCESSFULLY = new Error(29090);
	public static final Error ASSET_INSURANCE_PAYMENT_UPDATED_SUCCESSFULLY = new Error(29091);
	public static final Error ASSET_INSURANCE_PAYMENT_APPROVED_SUCCESSFULLY = new Error(29092);
	public static final Error ASSET_INSURANCE_PAYMENT_REJECTED_SUCCESSFULLY = new Error(29093);
	public static final Error AMOUNT_EMPTY = new Error(29094);
	public static final Error PAYMENT_MODE_ISEMPTY = new Error(29095);
	public static final Error FORWARD_TO_EMPTY = new Error(29096);
	public static final Error FORWARD_FOR_ISEMPTY = new Error(29097);

	public static final Error GRATUITY_PAYMENT_APPROVED = new Error(29089);
	public static final Error GRATUITY_PAYMENT_REJECTED = new Error(29099);
	public static final Error STAFF_GRATUITY_PAYMENT_UPDATE_SUCCESS = new Error(29098);
	public static final Error STAFF_GRATUITY_PAYMENT_EMPLOYEE_EMPTY = new Error(29100);
	public static final Error STAFF_GRATUITY_PAYMENT_NETAMOUNT_EMPTY = new Error(29101);
	public static final Error STAFF_GRATUITY_PAYMENT_ID_EMPTY = new Error(29102);
	public static final Error STAFF_GRATUITY_PAYMENT_NETAMOUNT_ZERO = new Error(29103);
	public static final Error STAFF_GRATUITY_PAYMENT_NETAMOUNT_EXCEED = new Error(29104);

	/*
	 * EComm Filter Category
	 */
	public static final Error SELECT_ECOMM_FILTER_CATEGORY = new Error(7777734);
	public static final Error ACTIVE_ECOMM_FILTER_CATEGORY_CANNOT_DELETE = new Error(7777735);
	public static final Error ECOMM_FILTER_CATEGORY_NAME_EMPTY = new Error(7777736);
	public static final Error ECOMM_FILTER_CATEGORY_LNAME_EMPTY = new Error(7777737);
	public static final Error ECOMM_FILTER_CATEGORY_STATUS_EMPTY = new Error(7777738);
	public static final Error ECOMM_FILTER_CATEGORY_EMPTY = new Error(7777739);
	public static final Error ECOMM_FILTER_CATEGORY_NAME_MIN_MAX_ERROR = new Error(7777740);
	public static final Error ECOMM_FILTER_CATEGORY_LNAME_MIN_MAX_ERROR = new Error(7777741);
	public static final Error ECOMM_FILTER_CATEGORY_SAVE_SUCCESS = new Error(7777742);
	public static final Error ECOMM_FILTER_CATEGORY_UPDATE_SUCCESS = new Error(7777743);
	public static final Error ECOMM_FILTER_CATEGORY_DELETE_SUCCESS = new Error(7777744);
	public static final Error ECOMM_FILTER_CATEGORY_NAME_ALREADY_EXIST = new Error(7777745);
	public static final Error ECOMM_FILTER_CATEGORY_LNAME_ALREADY_EXIST = new Error(7777746);
	public static final Error ECOMM_FILTER_CATEGORY_NOT_FOUND = new Error(7777747);
	public static final Error ECOMM_FILTER_CATEGORY_CODE_EXIST = new Error(7777748);
	public static final Error ECOMM_FILTER_CATEGORY_ID_NULL = new Error(7777749);
	public static final Error ECOMM_FILTER_CATEGORY_CODE_EMPTY = new Error(7777750);

	// Tapal error Messages
	public static final Error TAPAL_FOR_NAME_EXISTS = new Error(7777751);
	public static final Error TAPAL_FOR_LNAME_EXISTS = new Error(7777752);
	public static final Error TAPAL_FOR_CODE_EXISTS = new Error(7777753);

	public static final Error TAPAL_SENDER_NAME_EXISTS = new Error(7777754);
	public static final Error TAPAL_SENDER_LNAME_EXISTS = new Error(7777755);
	public static final Error TAPAL_SENDER_CODE_EXISTS = new Error(7777756);

	public static final Error TAPAL_DELIVERY_NAME_EXISTS = new Error(7777757);
	public static final Error TAPAL_DELIVERY_LNAME_EXISTS = new Error(7777758);
	public static final Error TAPAL_DELIVERY_CODE_EXISTS = new Error(7777759);

	// Cash Closing BalanceReport
	public static final Error CASHCLOSINGBALANCEREPORT_ENTITYTYPE_NULL = new Error(210);
	public static final Error CASHCLOSINGBALANCEREPORT_ENTITYNAME_NULL = new Error(211);
	public static final Error CASHCLOSINGBALANCEREPORT_FROMCLOSINGDATE_NULL = new Error(212);
	public static final Error CASHCLOSINGBALANCEREPORT_TOCLOSINGDATE_NULL = new Error(213);

	public static final Error NUMBER_FORMAT_EXCEPTION = new Error(7777760);

	// POS Terminal
	public static final Error REGISTER_POS_TERMINAL_SAVE_SUCCESS = new Error(7777764);
	public static final Error REGISTER_POS_TERMINAL_SAVE_ERROR = new Error(7777765);
	public static final Error REGISTER_POS_TERMINAL_UPDATE_SUCCESS = new Error(7777766);
	public static final Error REGISTER_POS_TERMINAL_UPDATE_ERROR = new Error(7777767);

	// LeaveType
	public static final Error LEAVETYPE_CODE_DUPLICATE = new Error(7777768);
	public static final Error LEAVETYPE_NAME_DUPLICATE = new Error(7777769);
	public static final Error LEAVETYPE_LNAME_DUPLICATE = new Error(7777770);

	// app_feature
	public static final Error APP_FEATURE_NOT_EXISTS = new Error(12300);

	// Ecomm Product Config
	public static final Error ECOMM_PRODUCT_CONFIG_FILEUPLOAD_SUCCESS = new Error(2348135);
	public static final Error ECOMM_PRODUCT_CONFIG_FILEUPLOAD_ERROR = new Error(2348136);
	public static final Error ECOMM_PRODUCT_CONFIG_FILE_SIZE_ERROR = new Error(2348137);
	public static final Error ECOMM_PRODUCT_CONFIG_SAVE_SUCCESS = new Error(2348138);
	public static final Error ECOMM_PRODUCT_CONFIG_UPDATE_SUCCESS = new Error(2348139);
	public static final Error ECOMM_PRODUCT_CONFIG_AT_NUMBER_REQ = new Error(2348140);

	// Rent Collection
	public static final Error SELECT_RENT_COLLECTION = new Error(34400);

	public static final Error RENT_COLLECTION_ACCOUNTHEAD_EMPTY = new Error(34401);
	public static final Error RENT_COLLECTION_AMOUNT_EMPTY = new Error(34402);
	public static final Error RENT_COLLECTION_DETAIL_EMPTY = new Error(34403);
	public static final Error RENT_COLLECTION_ASSET_EMPTY = new Error(34404);
	public static final Error RENT_COLLECTION_FORWARD_TO_NULL = new Error(34405);
	public static final Error RENT_COLLECTION_SAVE_SUCCESS = new Error(34406);
	public static final Error RENT_COLLECTION_UPDATE_SUCCESS = new Error(34407);
	public static final Error RENT_COLLECTION_APPROVED_SUCCESSFULLY = new Error(34408);
	public static final Error RENT_COLLECTION_REJECTED_SUCCESSFULLY = new Error(34409);
	public static final Error RENT_COLLECTION_CAN_NOT_EDIT = new Error(34410);
	public static final Error RENT_COLLECTION_MONTH_EMPTY = new Error(34415);
	public static final Error RENT_COLLECTION_ACCOUNTHEAD_CHOOSE_ANOTHER = new Error(34416);
	public static final Error RENT_COLLECTION_MODE_EMPTY = new Error(34417);
	public static final Error RENT_COLLECTION_NOTE_NULL = new Error(34418);
	public static final Error RENT_COLLECTION_FINALAPPROVAL_NULL = new Error(34419);
	public static final Error RENT_COLLECTION_DETAIL_ATLEAST_FOR_MONTH = new Error(34421);

	// --Modernization Request--
	public static final Error MODERNIZATION_REQUEST_SAVE_SUCCESS = new Error(41410);
	public static final Error MODERNIZATION_REQUEST_DELETED_SUCCESS = new Error(8669);
	public static final Error MODERNIZATION_REQUEST_ID_EMPTY = new Error(8666);
	public static final Error MODERNIZATION_REQUEST_UPLOAD_SUCCESS = new Error(41414);
	public static final Error HO_RO_EMPTY = new Error(41415);
	public static final Error NAME_OF_BUILDING_EMPTY = new Error(41416);
	public static final Error NAME_OF_BUILDING_MAX_LENGHT = new Error(41417);

	// ADMIN_>CIRCULAR
	public static final Error CIRCULAR_DELETE_SUCCESS = new Error(202011);
	public static final Error CIRCULAR_SAVE_SUCCESS = new Error(202012);
	public static final Error CIRCULAR_UPDATE_SUCCESS = new Error(202013);
	public static final Error CIRCULAR_APPROVE_SUCCESS = new Error(202014);
	public static final Error CIRCULAR_REJECTED_SUCCESS = new Error(202015);

	public static final Error CANNOT_BE_EDITED = new Error(202016);

	// Meeting Department Request
	public static final Error MEETING_REQUEST_EXTERNAL_NAME_EMPTY = new Error(34500);
	public static final Error MEETING_REQUEST_NOTE_EMPTY = new Error(34501);
	public static final Error MEETING_REQUEST_INTERNAL_EMPLOYEE_EMPTY_LIST = new Error(34502);
	public static final Error MEETING_REQUEST_INSERTED_SUCCESSFULLY = new Error(34503);
	public static final Error MEETING_REQUEST_UPDATED_SUCCESSFULLY = new Error(34504);
	public static final Error MEETING_REQUEST_DELETED_SUCCESSFULLY = new Error(34505);
	public static final Error MEETING_REQUEST_APPROVED_SUCCESSFULLY = new Error(34506);
	public static final Error MEETING_REQUEST_REJECTED_SUCCESSFULLY = new Error(34507);

	public static final Error MEETING_REQUEST_FORWARD_TO_EMPTY = new Error(34508);
	public static final Error MEETING_REQUEST_FORWARD_FOR_EMPTY = new Error(34509);
	public static final Error MEETING_REQUEST_CAN_NOT_EDIT = new Error(34510);

	// MadeToOrder
	public static final Error MADETOORDER_CREATED_SUCCESS = new Error(41418);

	// Meeting Report Messages
	public static final Error MEETING_REPORT_DOCUMENTS_NOT_EMPTY = new Error(7777771);
	public static final Error MEETING_REPORT_DOCUMENT_SUCCESS = new Error(7777772);
	public static final Error MEETING_REPORT_INSERTED_SUCCESSFULLY = new Error(7777773);
	public static final Error MEETING_REPORTT_UPDATED_SUCCESSFULLY = new Error(7777774);
	public static final Error MEETING_REPORT_DELETED_SUCCESSFULLY = new Error(7777775);
	public static final Error MEETING_REPORT_APPROVED_SUCCESSFULLY = new Error(7777776);
	public static final Error MEETING_REPORT_REJECTED_SUCCESSFULLY = new Error(7777777);

	// Fuel Filling Register
	public static final Error FUEL_REG_VECHICLE_EMTPY = new Error(2348141);
	public static final Error FUEL_FILLING_REG_INSERTED_SICCESSFULLY = new Error(2348142);
	public static final Error FUEL_FILLING_REG_UPDATED_SICCESSFULLY = new Error(2348143);
	public static final Error FUEL_FILLING_REG_DELETED_SICCESSFULLY = new Error(2348144);
	public static final Error FUEL_FILLING_REG_APPROVED_SUCCESSFULLY = new Error(2348145);
	public static final Error FUEL_FILLING_REG_REJECTED_SUCCESSFULLY = new Error(2348146);

	public static final Error FUEL_FILLING_RECIEPT_INSERTED_SICCESSFULLY = new Error(2348147);
	public static final Error FUEL_FILLING_RECIEPT_UPDATED_SICCESSFULLY = new Error(2348148);
	public static final Error FUEL_FILLING_RECIEPT_DELETED_SICCESSFULLY = new Error(2348149);
	public static final Error FUEL_FILLING_RECIEPT_APPROVED_SUCCESSFULLY = new Error(2348150);
	public static final Error FUEL_FILLING_RECIEPT_REJECTED_SUCCESSFULLY = new Error(2348151);

	// Meeting Report Error Messages
	public static final Error TAPAL_REPORT_REQUEST_DTO_EMPTY = new Error(7777779);
	public static final Error TAPAL_REPORT_TAPALTYPE_EMPTY = new Error(7777780);
	public static final Error TAPAL_REPORT_DELIVERYTYPE_EMPTY = new Error(7777785);
	public static final Error TAPAL_REPORT_WHOM_EMPTY = new Error(7777784);
	public static final Error TAPAL_REPORT_DEPARTMENT_EMPTY = new Error(7777783);
	public static final Error TAPAL_REPORT_FROM_DATE_EMPTY = new Error(7777781);
	public static final Error TAPAL_REPORT_TO_DATE_EMPTY = new Error(7777782);

	// --OT Register--
	public static final Error OT_REGISTER_STATUS_EMPTY = new Error(89998);
	public static final Error OT_REGISTER_ID_EMPTY = new Error(89990);
	public static final Error OT_REGISTER_GREATER = new Error(89991);
	public static final Error OT_REGISTER_INSERTED_SICCESSFULLY = new Error(89999);
	public static final Error OT_REGISTER_UPDATED_SICCESSFULLY = new Error(89099);
	public static final Error OT_REGISTER_DELETED_SICCESSFULLY = new Error(80099);

	// --Distribution--
	public static final Error SELECT_TYPE_AND_CODE = new Error(112233);
	public static final Error SELECT_PRODUCTION_PLAN = new Error(114233);
	public static final Error SELECT_DISTRICT = new Error(115233);
	public static final Error SELECT_TALUK = new Error(116233);

	public static final Error SELECT_GROUP_NAME_CODE = new Error(122233);
	public static final Error SELECT_PRODUCT_NAME_CODE = new Error(134233);
	public static final Error ENTER_BUNDLE = new Error(125233);
	public static final Error ENTER_QTY = new Error(126233);

	public static final Error DISTRIBUTION_ID_EMPTY = new Error(135233);
	public static final Error DISTRIBUTION_INSERTED_SUCCUESSFULLY = new Error(145233);
	public static final Error DISTRIBUTION_DELETED_SUCCUESSFULLY = new Error(155233);

	// StaffEligibilityMaster
	public static final Error STAFFELIGIBILITYMASTER_SAVE_SUCCESS = new Error(22334455);
	public static final Error STAFFELIGIBILITYMASTER_UPDATE_SUCCESS = new Error(22334456);
	public static final Error STAFFELIGIBILITYMASTER_DELETE_SUCCESS = new Error(22334457);

	public static final Error SELECT_UOM_MASTER = new Error(22334458);
	public static final Error ACTIVE_UOM_MASTER_CANNOT_DELETE = new Error(22334459);
	public static final Error UOM_MASTER_NAME_EMPTY = new Error(22334460);
	public static final Error UOM_MASTER_LNAME_EMPTY = new Error(22334461);
	public static final Error UOM_MASTER_STATUS_EMPTY = new Error(22334462);
	public static final Error UOM_MASTER_EMPTY = new Error(22334463);
	public static final Error UOM_MASTER_NAME_MIN_MAX_ERROR = new Error(22334464);
	public static final Error UOM_MASTER_LNAME_MIN_MAX_ERROR = new Error(22334465);
	public static final Error UOM_MASTER_SAVE_SUCCESS = new Error(22334466);
	public static final Error UOM_MASTER_UPDATE_SUCCESS = new Error(22334467);
	public static final Error UOM_MASTER_DELETE_SUCCESS = new Error(22334468);
	public static final Error UOM_MASTER_NAME_ALREADY_EXIST = new Error(22334469);
	public static final Error UOM_MASTER_LNAME_ALREADY_EXIST = new Error(22334470);
	public static final Error UOM_MASTER_NOT_FOUND = new Error(22334471);
	public static final Error UOM_MASTER_CODE_EXIST = new Error(22334472);
	public static final Error UOM_MASTER_ID_NULL = new Error(22334473);
	public static final Error UOM_MASTER_CODE_EMPTY = new Error(22334474);

	/*
	 * BANK_ACCOUNT_TYPE
	 */
	public static final Error SELECT_BANK_ACCOUNT_TYPE = new Error(22334475);
	public static final Error ACTIVE_BANK_ACCOUNT_TYPE_CANNOT_DELETE = new Error(22334476);
	public static final Error BANK_ACCOUNT_TYPE_NAME_EMPTY = new Error(22334477);
	public static final Error BANK_ACCOUNT_TYPE_LNAME_EMPTY = new Error(22334478);
	public static final Error BANK_ACCOUNT_TYPE_STATUS_EMPTY = new Error(22334479);
	public static final Error BANK_ACCOUNT_TYPE_EMPTY = new Error(22334480);
	public static final Error BANK_ACCOUNT_TYPE_NAME_MIN_MAX_ERROR = new Error(22334481);
	public static final Error BANK_ACCOUNT_TYPE_LNAME_MIN_MAX_ERROR = new Error(22334482);
	public static final Error BANK_ACCOUNT_TYPE_SAVE_SUCCESS = new Error(22334483);
	public static final Error BANK_ACCOUNT_TYPE_UPDATE_SUCCESS = new Error(22334484);
	public static final Error BANK_ACCOUNT_TYPE_DELETE_SUCCESS = new Error(22334485);
	public static final Error BANK_ACCOUNT_TYPE_NAME_ALREADY_EXIST = new Error(22334486);
	public static final Error BANK_ACCOUNT_TYPE_LNAME_ALREADY_EXIST = new Error(22334487);
	public static final Error BANK_ACCOUNT_TYPE_NOT_FOUND = new Error(22334488);
	public static final Error BANK_ACCOUNT_TYPE_CODE_EXIST = new Error(22334489);
	public static final Error BANK_ACCOUNT_TYPE_ID_NULL = new Error(22334490);
	public static final Error BANK_ACCOUNT_TYPE_CODE_EMPTY = new Error(22334491);

	public static final Error ASSET_REQUEST_SAVE_SUCCESS = new Error(22334493);
	public static final Error ASSET_REQUEST_APPROVE = new Error(22334494);
	public static final Error ASSET_REQUEST_REJECT = new Error(22334495);
	public static final Error ASSET_REQUEST_UPDATE_SUCCESS = new Error(22334496);
	public static final Error ASSET_REQUEST_DELETE_SUCCESS = new Error(22334497);

	// Mdernization Estimation
	public static final Error MOD_ESTIMATION_CREATED_SUCCESSFULLY = new Error(16012);
	public static final Error MOD_ESTIMATION_UPDATED_SUCCESSFULLY = new Error(16013);
	public static final Error MOD_ESTIMATION_DELETED_SUCCESSFULLY = new Error(16024);
	public static final Error MOD_ESTIMATION_DATA_ITEM_NOT_DESCRIBED = new Error(16021);
	public static final Error MOD_ESTIMATION_DATA_ITEM_DESCRIBED = new Error(16022);
	public static final Error MOD_ESTIMATION_REQUEST_NOT_NULL = new Error(16014);
	public static final Error MOD_ESTIMATION_QUANTITY_NOT_NULL = new Error(16015);
	public static final Error MOD_ESTIMATION_RATE_NOT_NULL = new Error(16016);
	public static final Error MOD_ESTIMATION_AMOUNT_NOT_NULL = new Error(16017);
	public static final Error MOD_ESTIMATION_ITEMDESC_NOT_NULL = new Error(16018);
	public static final Error MOD_ESTIMATION_UNIT_NOT_NULL = new Error(16023);
	public static final Error MOD_ESTIMATION_APPROVED = new Error(16019);
	public static final Error MOD_ESTIMATION_REJECTED = new Error(16020);
	public static final Error MOD_ESTIMATION_NOTE_EMPTY = new Error(16025);

	// LEAVETYPEMASTER
	public static final Error LEAVETYPEMASTER_SAVE_SUCCESS = new Error(223344931);;
	public static final Error LEAVETYPEMASTER_UPDATE_SUCCESS = new Error(223344932);
	public static final Error LEAVETYPEMASTER_DELETE_SUCCESS = new Error(223344933);

	// Modernization Report
	public static final Error MODERNIZATION_REPORT_SAVE_SUCCESS = new Error(22334498);
	public static final Error MODERNIZATION_REPORT_UPDATE_SUCCESS = new Error(22334499);
	public static final Error MODERNIZATION_REPORT_DELETE_SUCCESS = new Error(22334502);
	public static final Error MODERNIZATION_REPORT_APPROVE_SUCCESS = new Error(22334500);
	public static final Error MODERNIZATION_REPORT_REJECT_SUCCESS = new Error(22334501);

	// payScale Master

	public static final Error FROM_AMOUNT_NOT_Equal_TO_AMOUNT = new Error(1216);

	// Tapal Delivery Type Master
	public static final Error TAPAL_DELIVERY_TYPE_SAVE_SUCCESS = new Error(299100);
	public static final Error TAPAL_DELIVERY_TYPE_UPDATE_SUCCESS = new Error(299101);
	public static final Error TAPAL_DELIVERY_TYPE_DELETE_SUCCESS = new Error(299102);

	/*
	 * MODE_OF_ENQUIRY
	 */
	public static final Error SELECT_MODE_OF_ENQUIRY = new Error(223344934);
	public static final Error ACTIVE_MODE_OF_ENQUIRY_CANNOT_DELETE = new Error(223344935);
	public static final Error MODE_OF_ENQUIRY_NAME_EMPTY = new Error(223344936);
	public static final Error MODE_OF_ENQUIRY_LNAME_EMPTY = new Error(223344937);
	public static final Error MODE_OF_ENQUIRY_STATUS_EMPTY = new Error(223344938);
	public static final Error MODE_OF_ENQUIRY_EMPTY = new Error(223344939);
	public static final Error MODE_OF_ENQUIRY_NAME_MIN_MAX_ERROR = new Error(223344940);
	public static final Error MODE_OF_ENQUIRY_LNAME_MIN_MAX_ERROR = new Error(223344941);
	public static final Error MODE_OF_ENQUIRY_SAVE_SUCCESS = new Error(223344942);
	public static final Error MODE_OF_ENQUIRY_UPDATE_SUCCESS = new Error(223344943);
	public static final Error MODE_OF_ENQUIRY_DELETE_SUCCESS = new Error(223344944);
	public static final Error MODE_OF_ENQUIRY_NAME_ALREADY_EXIST = new Error(223344945);
	public static final Error MODE_OF_ENQUIRY_LNAME_ALREADY_EXIST = new Error(223344946);
	public static final Error MODE_OF_ENQUIRY_NOT_FOUND = new Error(223344947);
	public static final Error MODE_OF_ENQUIRY_CODE_EXIST = new Error(223344948);
	public static final Error MODE_OF_ENQUIRY_ID_NULL = new Error(223344949);
	public static final Error MODE_OF_ENQUIRY_CODE_EMPTY = new Error(223344950);

	/*
	 * BUSINESS_TYPE
	 */
	public static final Error SELECT_BUSINESS_TYPE_MASTER = new Error(223344951);
	public static final Error ACTIVE_BUSINESS_TYPE_MASTER_CANNOT_DELETE = new Error(223344952);
	public static final Error BUSINESS_TYPE_MASTER_NAME_EMPTY = new Error(223344953);
	public static final Error BUSINESS_TYPE_MASTER_LNAME_EMPTY = new Error(223344954);
	public static final Error BUSINESS_TYPE_MASTER_STATUS_EMPTY = new Error(223344955);
	public static final Error BUSINESS_TYPE_MASTER_EMPTY = new Error(223344956);
	public static final Error BUSINESS_TYPE_MASTER_NAME_MIN_MAX_ERROR = new Error(223344957);
	public static final Error BUSINESS_TYPE_MASTER_LNAME_MIN_MAX_ERROR = new Error(223344958);
	public static final Error BUSINESS_TYPE_MASTER_SAVE_SUCCESS = new Error(223344959);
	public static final Error BUSINESS_TYPE_MASTER_UPDATE_SUCCESS = new Error(223344960);
	public static final Error BUSINESS_TYPE_MASTER_DELETE_SUCCESS = new Error(223344961);
	public static final Error BUSINESS_TYPE_MASTER_NAME_ALREADY_EXIST = new Error(223344962);
	public static final Error BUSINESS_TYPE_MASTER_LNAME_ALREADY_EXIST = new Error(223344963);
	public static final Error BUSINESS_TYPE_MASTER_NOT_FOUND = new Error(223344964);
	public static final Error BUSINESS_TYPE_MASTER_CODE_EXIST = new Error(223344965);
	public static final Error BUSINESS_TYPE_MASTER_ID_NULL = new Error(223344966);
	public static final Error BUSINESS_TYPE_MASTER_CODE_EMPTY = new Error(223344967);

	/*
	 * CUSTOMER_TYPE
	 */
	public static final Error SELECT_CUSTOMER_TYPE_MASTER = new Error(223344968);
	public static final Error ACTIVE_CUSTOMER_TYPE_MASTER_CANNOT_DELETE = new Error(223344969);
	public static final Error CUSTOMER_TYPE_MASTER_NAME_EMPTY = new Error(223344970);
	public static final Error CUSTOMER_TYPE_MASTER_LNAME_EMPTY = new Error(223344971);
	public static final Error CUSTOMER_TYPE_MASTER_STATUS_EMPTY = new Error(223344972);
	public static final Error CUSTOMER_TYPE_MASTER_EMPTY = new Error(223344973);
	public static final Error CUSTOMER_TYPE_MASTER_NAME_MIN_MAX_ERROR = new Error(223344974);
	public static final Error CUSTOMER_TYPE_MASTER_LNAME_MIN_MAX_ERROR = new Error(223344975);
	public static final Error CUSTOMER_TYPE_MASTER_SAVE_SUCCESS = new Error(223344976);
	public static final Error CUSTOMER_TYPE_MASTER_UPDATE_SUCCESS = new Error(223344977);
	public static final Error CUSTOMER_TYPE_MASTER_DELETE_SUCCESS = new Error(223344978);
	public static final Error CUSTOMER_TYPE_MASTER_NAME_ALREADY_EXIST = new Error(223344979);
	public static final Error CUSTOMER_TYPE_MASTER_LNAME_ALREADY_EXIST = new Error(223344980);
	public static final Error CUSTOMER_TYPE_MASTER_NOT_FOUND = new Error(223344981);
	public static final Error CUSTOMER_TYPE_MASTER_CODE_EXIST = new Error(223344982);
	public static final Error CUSTOMER_TYPE_MASTER_ID_NULL = new Error(223344983);
	public static final Error CUSTOMER_TYPE_MASTER_CODE_EMPTY = new Error(223344984);

	public static final Error PROCUREMENT_CAN_NOT_EDIT = new Error(223345097);
	public static final Error PROCUREMENT_SAVED_SUCCESS = new Error(223345098);

	/*
	 * SUPPLIER TYPE
	 */
	// public static final Error SELECT_SUPPLIER_TYPE_MASTER = new Error(223344985);
	// public static final Error ACTIVE_SUPPLIER_TYPE_MASTER_CANNOT_DELETE = new
	// Error(223344986);
	// public static final Error SUPPLIER_TYPE_MASTER_NAME_EMPTY = new
	// Error(223344987);
	// public static final Error SUPPLIER_TYPE_MASTER_LNAME_EMPTY = new
	// Error(223344988);
	// public static final Error SUPPLIER_TYPE_MASTER_STATUS_EMPTY = new
	// Error(223344989);
	// public static final Error SUPPLIER_TYPE_MASTER_EMPTY = new Error(223344990);
	// public static final Error SUPPLIER_TYPE_MASTER_NAME_MIN_MAX_ERROR = new
	// Error(223344991);
	// public static final Error SUPPLIER_TYPE_MASTER_LNAME_MIN_MAX_ERROR = new
	// Error(223344992);
	// public static final Error SUPPLIER_TYPE_MASTER_SAVE_SUCCESS = new
	// Error(223344993);
	// public static final Error SUPPLIER_TYPE_MASTER_UPDATE_SUCCESS = new
	// Error(223344994);
	// public static final Error SUPPLIER_TYPE_MASTER_DELETE_SUCCESS = new
	// Error(223344995);
	// public static final Error SUPPLIER_TYPE_MASTER_NAME_ALREADY_EXIST = new
	// Error(223344996);
	// public static final Error SUPPLIER_TYPE_MASTER_LNAME_ALREADY_EXIST = new
	// Error(223344997);
	// public static final Error SUPPLIER_TYPE_MASTER_NOT_FOUND = new
	// Error(223344998);
	// public static final Error SUPPLIER_TYPE_MASTER_CODE_EXIST = new
	// Error(223344999);
	// public static final Error SUPPLIER_TYPE_MASTER_ID_NULL = new
	// Error(223345000);
	// public static final Error SUPPLIER_TYPE_MASTER_CODE_EMPTY = new
	// Error(223345001);
	// public static final Error SUPPLIER_TYPE_MASTER_TYPE_EMPTY = new
	// Error(223345002);

	public static final Error getError(Integer errorCode) {
		return new Error(errorCode);
	}

}
