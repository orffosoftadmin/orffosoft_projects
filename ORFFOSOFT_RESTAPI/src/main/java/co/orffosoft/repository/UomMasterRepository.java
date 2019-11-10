package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.UomMaster;

public interface UomMasterRepository extends JpaRepository<UomMaster, Long> {

	@Query("FROM UomMaster where code=:code")
	UomMaster findByCode(@Param("code") String code);

	/** returns a list of communities */
	@Query("Select c from UomMaster c order by createdDate desc")
	List<UomMaster> getAll();

	/** this method finds the community by its id. */
	UomMaster findById(long id);

	UomMaster findByNameIgnoreCase(String name);

	@Query(value = "SELECT c FROM UomMaster c WHERE LOWER(c.localName) = LOWER(?1) ")
	UomMaster findByLocalNameIgnoreCase(String lname);

	UomMaster findByCodeIgnoreCase(String code);

	UomMaster findByName(String name);

}
