package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.UserMaster;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {

	/**
	 * @param username
	 * @return
	 */
	@Query("SELECT u FROM UserMaster u WHERE u.username = ?1")
	UserMaster findByUsername(String username);

	/**
	 * @return
	 */
	@Query("SELECT u FROM UserMaster u where u.entityId =:entityId  ORDER BY u.id DESC")
	List<UserMaster> findAllUserByEntity(@Param("entityId") Long entityId);

	
	/**
	 * @param id
	 * @return
	 */
	@Query(nativeQuery = true, value = "select um.id as userId , um.username as userName , em.id as entityId , em.code as entityCode, em.name as entityName from user_master um join entity_master em on um.entity_id = em.id where um.id =?1")
	List<Object> findUserNameById(Long id);
}
