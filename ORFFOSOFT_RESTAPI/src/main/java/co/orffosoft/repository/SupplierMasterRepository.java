package co.orffosoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.SupplierMaster;

public interface SupplierMasterRepository extends JpaRepository<SupplierMaster, Long> {

	@Query(nativeQuery = true, value = "select * from supplier_master sm where sm.supplier_type_id=(select id from supplier_type_master stm where stm.code='SOCIETY');")
	List<SupplierMaster> findBySupplyTypeId();

	@Query("SELECT sm FROM SupplierMaster sm WHERE sm.userMaster.id = :userId")
	List<SupplierMaster> findByUser(@Param("userId") Long userId);

	@Query("SELECT sm.name FROM SupplierMaster sm WHERE sm.userMaster.id = :userId")
	String findSupplierNameByUser(@Param("userId") Long userId);

	@Query("SELECT sm FROM SupplierMaster sm WHERE sm.code = :code")
	SupplierMaster findByCode(@Param("code") String code);

	@Query(nativeQuery = true, value = "select * from supplier_master where name LIKE ?1 ")
	List<SupplierMaster> findBySupplierByName(String supplierName);

	@Query(nativeQuery = true, value = "select s.* from supplier_master s,tender_application t where s.id not in (select supplier_id from tender_application where tender_id= ?2) "
			+ " and s.name LIKE ?1 ")
	List<SupplierMaster> findBySupplierByNameNoTender(String supplierName, Long tenderId);

	@Query(nativeQuery = true, value = "select * from supplier_master master join supplier_type_master typeMaster on typeMaster.id = master.supplier_type_id limit 20")
	List<SupplierMaster> getAllSupplierMaster();

	@Query(nativeQuery = true, value = "SELECT * FROM supplier_master")
	List<SupplierMaster> getSupplierList();
	
	@Query("SELECT new SupplierMaster(s.id,s.code,s.name) FROM SupplierMaster s ")
	List<SupplierMaster> getAllSupplierListNew();

	@Query(nativeQuery = true, value = "select max(cast(s.code as int)) as codedd from supplier_master s"
			+ " left join supplier_type_master st on" + " s.supplier_type_id = st.id where s.code NOT LIKE '%[a-z]%'")
	int getMaxofCode();

	@Query(nativeQuery = true, value = "select s.* from supplier_master s,tender_application t  where s.id in(select supplier_id from tender_application where tender_id= ?1) group by s.id; ")
	List<SupplierMaster> findSupplierByTenderNo(Long tenderId);

	@Query(value = "SELECT sm.id FROM SupplierMaster sm WHERE sm.userMaster.id = (?1)")
	Long findSupplierMasterIdByUserId(Long userId);

	@Query("SELECT new SupplierMaster(s.id,s.code,s.name) FROM SupplierMaster s where s.activeStatus=:activeStatus")
	List<SupplierMaster> findAllByActiveStatus(@Param("activeStatus") Boolean activeStatus);
	
	@Query("SELECT  new SupplierMaster(s.id,s.code,s.name) FROM SupplierMaster s where s.activeStatus=true and lower(s.name) like lower(concat('%', :firtName,'%')) ")
	List<SupplierMaster> findInstituteForLikeQuery(@Param("firtName") String firtName);

	@Query("SELECT new SupplierMaster(s.id,s.code,s.name) FROM SupplierMaster s ")
	List<SupplierMaster> getSupplierMasterList();
	
	SupplierMaster findOneById(@Param("userId") Long userId);

	@Query("SELECT sm FROM SupplierMaster sm WHERE sm.userMaster.id = :userId")
	SupplierMaster findSupplierByUser(@Param("userId") long userId);
	
	@Query(nativeQuery = true, value = "select sm.id from supplier_master sm where sm.user_id =:userid")
	SupplierMaster findSupplierByUserId(@Param("userid") Long userid);
	
	@Query(nativeQuery = true, value = "select sm.id from supplier_master sm where sm.code =:code")
	Long findSupplierByCode(@Param("code") String code);
	
	@Query(nativeQuery = true, value = "select * from supplier_master sm where (sm.code ilike :name or sm.name ilike :name) and sm.user_id =:userId")
	List<SupplierMaster> autoCompleteSupplier(@Param("name")  String name, @Param("userId") Long userId);
	
	@Query("SELECT sm FROM SupplierMaster sm WHERE sm.code = :code and sm.userMaster.id = :userId")
	SupplierMaster findByCodeAndUserId(@Param("code") String code , @Param("userId") Long userId);
	
	@Query("SELECT sm FROM SupplierMaster sm WHERE sm.name = :name and sm.userMaster.id = :userId")
	SupplierMaster findByNameAndUserId(@Param("name") String code , @Param("userId") Long userId);

}

