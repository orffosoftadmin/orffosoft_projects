package co.orffosoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.FileMovementConfig;


public interface FileMovementConfigRepository extends JpaRepository<FileMovementConfig, Long> {
	
	
	
	 //@Query(nativeQuery = true,value="select * from file_movement_config where feature_id = ?1 ORDER BY forward_level ASC")
	 //List<FileMovementConfig> getAllFileMovementConfigDataByAppFeatureId(Long appfeatureId);
	 
	 @Query(value="SELECT fc,fc.appFeature FROM FileMovementConfig fc where fc.appFeature.id=?1")
	 List<Object> getAllFileMovementConfigDataByAppFeatureId(Long appfeatureId);
	 
	 @Query(value="SELECT fc.forwardLevel FROM FileMovementConfig fc where fc.appFeature.id=?1")
	 List<Integer> getForwardLevelNumberListByAppFeature(Long appfeatureId);

	// @Query(value="DELETE  FROM FileMovementConfig fc where fc.appFeature.id=?1")
	 
	 @Transactional
	 @Modifying
	 @Query(nativeQuery=true,value="delete from public.file_movement_config file where file.feature_id=:id")
	 
	void deleteFileMovementConfigListBYAppFeatureIdRepositry(@Param("id") Long id);
	 
	 
	 @Transactional
	 @Modifying
	 @Query(nativeQuery=true,value="delete from public.file_movement_config file where file.feature_id=:appFeatureId  AND file.forward_level=:forwardLevel")
	void deleteFileMovementConfigListBYforwardLevelNumberRepositry(Long appFeatureId, Integer forwardLevel);
	 
	 @Query(nativeQuery=true,value="delete from public.file_movement_config file where file.id=:id")
	void deleteFileMovementConfigListBYforwardLevelNumberRepositry(Long id);

}