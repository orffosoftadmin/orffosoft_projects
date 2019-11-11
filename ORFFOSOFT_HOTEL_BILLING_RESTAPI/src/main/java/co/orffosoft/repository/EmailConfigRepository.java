package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.orffosoft.entity.EmailConfig;

public interface EmailConfigRepository extends JpaRepository<EmailConfig, Long> {

	@Query("SELECT m FROM EmailConfig m ORDER BY m.id")
	List<EmailConfig> getEmailConfigList();

	EmailConfig findByCode(String code);

	// @Query("SELECT e FROM EmailConfig e WHERE e.code=?1")
	// EmailConfig findEmailConfigDetail(String string);

}
