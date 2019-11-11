package co.orffosoft.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.AppConfig;

public interface AppConfigRepository extends JpaRepository<AppConfig, Long> {

	@Query("SELECT ac FROM AppConfig ac WHERE appKey=?1")
	AppConfig findByKey(String appKey);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " UPDATE app_config SET app_value = :appValue WHERE app_key = :appKey ")
	void updateAppConfigByAppKey(@Param("appValue") String appValue, @Param("appKey") String appKey);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM app_config WHERE app_key = :appKey ")
	void deleteAppConfigByAppKey(@Param("appKey") String appKey);

	@Query("SELECT ac FROM AppConfig ac WHERE ac.appKey=:appKey")
	AppConfig findByAppKey(@Param("appKey") String appKey);

	@Query(value = "SELECT ac.app_value FROM app_config ac WHERE ac.app_key = :appKey", nativeQuery = true)
	String findValueByKey(@Param("appKey") String appKey);
}
