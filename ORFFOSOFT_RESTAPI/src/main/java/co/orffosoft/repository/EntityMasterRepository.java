package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.EntityMaster;


public interface EntityMasterRepository extends JpaRepository<EntityMaster, Long> {

	@Query("SELECT sm FROM EntityMaster sm WHERE sm.gstNumber=?1")
	EntityMaster findByGstNumber(String gstNum);

	@Query("SELECT sm FROM EntityMaster sm WHERE sm.code=?1")
	EntityMaster findByCode(String code);

	@Query("SELECT sm FROM EntityMaster sm WHERE UPPER(sm.name)=UPPER(?1)")
	EntityMaster findByName(String name);

	EntityMaster findById(Long id);

	List<EntityMaster> findAllByOrderByIdDesc();

	@Query("SELECT sm FROM EntityMaster sm WHERE sm.id=?1")
	EntityMaster findId(Long id);

	@Query("FROM EntityMaster om WHERE om.id = ?1")
	List<EntityMaster> findByContactId(Long contactId);

	@Query("SELECT MAX(code) FROM EntityMaster")
	public Integer getCode();

	@Query("FROM EntityMaster om WHERE om.gstNumber = ?1")
	EntityMaster findGstNumber(String gstNumber);

	@Query(nativeQuery = true, value = "SELECT * FROM entity_master em WHERE em.entity_type_id=(SELECT id FROM entity_type_master WHERE code='D_AND_P_OFFICE') AND em.id in (SELECT dnp.entity_id FROM public.retail_plan_dandp dnp WHERE dnp.plan_id=:planId)")
	List<EntityMaster> findDANDPOffices(@Param("planId") Long planId);

	@Query("SELECT em FROM EntityMaster em WHERE em.id=?1")
	EntityMaster findByShowroomId(Long id);

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM entity_master WHERE id=?1 AND entity_type_id=(SELECT id FROM entity_type_master WHERE code='D_AND_P_OFFICE')")
	public Integer findByDANPOffice(Long id);

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM entity_master WHERE id=?1 AND entity_type_id=(SELECT id FROM entity_type_master WHERE code='REGIONAL_OFFICE')")
	public Integer findByRegionOffice(Long id);

	@Query("SELECT em FROM EntityMaster em WHERE em.id=:id")
	EntityMaster findEntityMasterById(@Param("id") Long id);

	@Query("FROM EntityMaster em ORDER BY em.id DESC ")
	List<EntityMaster> findAllEntity();

	@Query(nativeQuery = true, value = "SELECT * FROM entity_master em WHERE em.entity_type_id=:entityTypeId")
	List<EntityMaster> findEntityByEntityTypeId(@Param("entityTypeId") Long entityTypeId);
	

	@Query(nativeQuery = true, value = "SELECT * FROM entity_master em WHERE em.active_status=true ORDER BY em.name")
	List<EntityMaster> findEntityByStatus();

}
