package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.orffosoft.entity.ErrorMaster;


public interface ErrorMasterRepository extends JpaRepository<ErrorMaster, Long> {
	
	
	@Query("SELECT NEW ErrorMaster(e.id, e.code, e.languageCode, e.description, e.version, e.messageType ) FROM ErrorMaster e")
	List<ErrorMaster> findAll();
	
	@Query("select em.description from ErrorMaster em where em.code=?1")
	String findDescByCode(Integer code);

}
