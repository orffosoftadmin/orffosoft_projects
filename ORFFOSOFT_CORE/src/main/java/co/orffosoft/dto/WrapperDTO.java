package co.orffosoft.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.orffosoft.core.util.PaginationResponseData;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.ErrorMaster;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class WrapperDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	int firstResult=0;
	int maxresult=0;
	
	int totalRecords;
	
//	RetailInputFormCategoryQtyAndValueDTO retailInputFormCategoryQtyAndValueDTO;
//	
//	EmployeeExperienceDetails empExp;
//	List<EmployeeExperienceDetails> empExpList;
//	
//	EmployeeFamilyDetails employeeFamilyDetails;
	
	PaginationResponseData paginationResponseData;
	
	Object content;

	List<?> contents;
	
	String sessionId;
	
	String payrollHead;
	
	
	List<EntityMaster> entityMasterRegionWiseList;
	
	/*List<PayScaleMaster> payScaleGroupsList;
	
	PayScaleMaster payScaleGroup;
	*/
//	StateMaster stateMaster;
//	
//	DistrictMaster districtMaster;
//	
//	TalukMaster talukMaster;
	
//	List<RetailInputFormListDTO> retailInputFormListDTO;
	
//	RetailProductionPlan retailProductionPlan;
	
//	List<RetailProductionPlanResponse> retailProductionPlanList;
	
//	List<RegionWiseSalesData> regionWiseSalesList;
//	
//	GenderMaster genderMaster;
	
//	TenderCategory tenderCategory;

//	List<EmployeeMaster> employeeList;
	
//	List<BloodGroupMaster> bloodGroupList;

//	List<MaritalStatus> maritalStatusList;
//
//	List<GenderMaster> genderList;
	
//	List<TenderCategory> tenderCategoryList;

//	List<Nationality> nationalityList;
//
//	List<Religion> religionList;

//	List<Community> communityList;

//	List<StateMaster> stateMasterList;
//
//	List<CityMaster> cityMasterList;
//
//	List<Designation> designationList;
//
//	List<OccupationMaster> occupationList;

//	List<RelationshipMaster> relationshipList;

//	List<DistrictMaster> districtMasterList;
//
//	List<TalukMaster> talukMasterList;

//	EmployeeMaster employee;

//	Collection<DepartmentDTO> departmentDto;
//
//	Collection<DesignationDTO> designationDto;

//	Collection<CommunityDTO> communityDto;

//	Collection<NationalityDTO> nationalityDto;
//
//	Collection<RelationshipDTO> relationshipDto;
//
//	Collection<ReligionDTO> religionDto;
//
//	Collection<RegionDTO> regionDTOCollections;
//
//	Collection<ProductCategoryDTO> productCategoryDTOCollections;
	
//	Collection<BankBranchMasterDTO> bankBranchDTOCollections;

//	Collection<AppointmentTypeDTO> appointmentTypeDTO;

//	Collection<MaritalStatusDTO> maritalStatusDTO;
//
//	Collection<CircleMasterDTO> circleMasterDTOList;
//
//	Collection<DiscountMasterDTO> discountMasterDTOcollections;
//
//	Collection<EntityTypeMasterDTO> entityMasterDto;
//
//	Collection<ProductMasterDTO> productMasterDTOList;
//
//	Collection<ProductGroupMasterDTO> productGroupDTOCollections;

//	Collection<SocietyMasterDTO> societyMasterDTOList;

	Collection<BigInteger> societyMasterCodeList;

//	Collection<WarehouseTypeDTO> warehouseTypeDTOList;
//
//	Collection<WarehouseMasterDTO> warehouseMasterDTOList;
//
//	Collection<DiscountDetailsDTO> discountDetailsDtoCollections;
//
//	Collection<CountryMasterDTO> countryMasterDTOCollection;
//
//	Collection<StateMasterDTO> stateMasterDTOCollection;
//
//	Collection<DistrictMasterDTO> districtMasterDTOCollection;

//	Collection<TalukMasterDTO> talukMasterDTOCollection;

//	Collection<BankMasterDTO> bankMasterDtoCollection;

//	Collection<EmployeeDTO> employeesDTOList;

	Collection<String> productionMasterPlanNumberList;

	Collection<String> productionMasterPlanNameList;

	Collection<ProductVarietyMasterDTO> productVarietyMasterDtoCollection;
//
////	Collection<YarnTypeMasterDTO> yarnTypeMasterDtoCollection;
//
//	Collection<AreaMasterDTO> areaMasterDtoList;
//
//	Collection<CityMasterDTO> cityMasterDtoList;
//
//	List<EntityCategoryDTO> entityCategoryDTOList;
//
//	List<EntityInchargeTypeDTO> entityInchargeTypeDTOList;
//
////	List<BuildingTypeDTO> buildingTypeDTOList;
//
//	List<EntityMasterDTO> entityMasterDTOList;
//
//	List<Department> departmentList;
//
//	Collection<Religion> religion;
//
//	List<ProductCategory> productCategoryList;
//
//	List<ProductGroupMaster> productGroupList;
//
//	List<ProductVarietyMaster> productVarietyList;
//
//	List<CircleMaster> circleMasterList;
//
//	List<EntityTypeMaster> entityTypetList;
//
//	List<Region> regionList;

//	List<EmployeeTypeMaster> employeeTypeList;
//
//	List<BloodGroupMaster> bloodList;
//
//	Collection<LoomTypeMaster> loomTypeMaster;

	List<EntityMaster> entityMasterList;

//	List<StatusMaster> statusMasterList;

//	List<BankMaster> bankMasterList;
//	
//	Collection<LeaveTypeMaster> leaveTypeMaster;

	List<ErrorMaster> errorMasterList;
	
//	List<RetailMonthwiseProcurement> retailMonthwiseProcurementList;
//	
//	Collection<LeaveTypeMaster> govtDtwRequirementsCollection;
	
	String regionName;
	
//	Region regionentity;
	
	List<EntityMaster> societymaster;
	
//	List<ADHTMaster> adhtcircleList;
	
	//RetailInputForm list and object
//	List<RetailProcurementOrder> retailInputFormList;
//	
//	RetailProcurementOrder retailInputForm;
//
//	RetailSocietyPlan retailSocietyPlan;
//	
//	List<RegionWiseFinalQtyAndValueDTO> regionWiseFinalQtyAndValueDTOList;
//	
//	List<RetailProductionPlan> productionPlanList;
//	
//	Collection<RetailSocietyPlan> retailSocietyPlanList;
//	
//	Collection<RetailSocietyPlanListDTO> retailSocietyPlanDTOList;
//	
////	RetailSocietyViewDTO retailSocietyViewDTO;
//	
//	RetailInputFormViewDTO retailInputFormViewDTO;
	
	List<EntityMaster> producingRegionList;
	
//	List<RetailProductionPlan> retailProductionPlanEntityList;
//	
//    List<RetailSocietyPlanListDTO> retailSocietyPlanListDTO;
//
//    TenderType tenderType;
	
	/*List<RetailSocietyWisePlanDTO> retailSocietyWisePlanDTOList;*/

}
