package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.ProductVarietyMaster;


public interface ProductVarietyMasterRepository extends JpaRepository<ProductVarietyMaster, Long> {

	@Query("SELECT em FROM ProductVarietyMaster em WHERE lower(em.name) = lower(?1) and em.userId =?2")
	ProductVarietyMaster findByName(String name, Long userId);
	
	@Query("SELECT em FROM ProductVarietyMaster em WHERE lower(em.name) = lower(?1) and userId =?2")
	ProductVarietyMaster findByNameByUser(String name , Long userId);

	@Query("SELECT em FROM ProductVarietyMaster em WHERE lower(em.code) = lower(?1)")
	ProductVarietyMaster findByCode(String code);
	
	@Query("SELECT em FROM ProductVarietyMaster em WHERE lower(em.code) = lower(?1) and userId =?2")
	ProductVarietyMaster findByCodeByUser(String code, Long userId);

	@Query("Select s from ProductVarietyMaster s ORDER BY s.id desc")
	List<ProductVarietyMaster> getProductList();

	@Query("SELECT em FROM ProductVarietyMaster em WHERE lower(em.lname) = lower(?1)")
	ProductVarietyMaster findByLname(String lname);

	@Query(nativeQuery = true, value = "select * from product_variety_master  where id=?1 and active_status=true;")
	ProductVarietyMaster findByIdAndStatus(Long id);

	@Query("SELECT dm FROM ProductVarietyMaster dm WHERE dm.id IN :inclList")
	List<ProductVarietyMaster> findByVarityList(List<Long> varityList);
	
	@Query(nativeQuery = true, value = "select * from product_variety_master where id in (select product_id from retail_procurement_order_details where input_form_id in (select id from retail_procurement_order where id=?1))")
	List<ProductVarietyMaster> findByRetailProcurementOrderId(Long id);

	@Query(nativeQuery = true, value = "select * from product_variety_master where group_id in (select id from product_group_master where category_id=?1)")
	List<ProductVarietyMaster> getItemCodeName(Long id);

	@Query(nativeQuery = true, value = "select * from product_variety_master prov inner join product_group_master progro on "
			+ "  prov.group_id = progro.category_id inner join product_category proC on "
			+ "  progro.category_id = proC.category_group_id inner join product_category_group proCG on "
			+ "  proC.category_group_id = proCG.id where prov.active_status=true")
	List<ProductVarietyMaster> getProductVarietyItemInward();

	@Query(nativeQuery = true, value = "select distinct p.* from product_variety_master p,govt_scheme_plan_items s where s.product_id=p.id and p.group_id=?1 and p.active_status=true;")
	List<ProductVarietyMaster> findLoadProductByGroup(Long groupId);

	@Query(nativeQuery = true, value = "select * from product_variety_master p where p.active_status=true and p.group_id=:id")
	List<ProductVarietyMaster> getAllProductVarietyMaster(@Param("id") Long id);
	
	@Query(nativeQuery = true, value = "select * from product_variety_master p where p.active_status=true and p.group_id=:id order by p.name")
	List<ProductVarietyMaster> getAllProductVarietyMasterAlphabetically(@Param("id") Long id);

	@Query(nativeQuery = true, value = "select * from product_variety_master p where p.id=:id")
	ProductVarietyMaster getSelectedProductVarietyMaster(@Param("id") Long id);

	@Query(nativeQuery = true, value = "select * from product_variety_master where id in (select product_variety_id from inventory_items) and group_id=:grp and active_status=true")
	List<ProductVarietyMaster> findByGroupAndInventoryItems(@Param("grp") Long groupId);

	@Query(nativeQuery = true, value = "select pm.* from  product_variety_master pm join product_group_master pg on pg.id=pm.group_id \n"
			+ "	join product_category pc on pg.category_id=pc.id where pc.id=?1 and pg.id=?2")
	List<ProductVarietyMaster> getProductVarietyByCategoryAndGroup(Long productcat, Long productgroup);

	 @Query(value = "SELECT pvm.id FROM product_variety_master pvm WHERE pvm.code = :itemCode", nativeQuery = true)
	 Long getProductIdByCode(@Param("itemCode") String itemCode);

	/*
	 * select pvm.code from product_variety_master pvm, ecomm_user_cart euc,
	 * ecomm_product_config epc where pvm.id=epc.product_id and
	 * epc.id=euc.product_config_id and euc.product_config_id=62 limit 1;
	 */

	@Query(value = "SELECT pvm.code FROM product_variety_master pvm, ecomm_user_cart euc, ecomm_product_config epc WHERE pvm.id=epc.product_id AND epc.id=euc.product_config_id AND euc.product_config_id=:itemConfigId limit 1", nativeQuery = true)
	String getProductCodeByItemConfigId(@Param("itemConfigId") Long itemConfigId);
	
	@Query(value = "select * from product_variety_master where name ilike :itemName and user_id = :userId" , nativeQuery = true)
	List<ProductVarietyMaster> autoCompleteItem(@Param("itemName") String itemName, @Param("userId") Long userId);

}
