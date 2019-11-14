package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.AppFeature;

public interface AppFeatureRepository extends JpaRepository<AppFeature, Long> {

	@Query("SELECT a FROM AppFeature a WHERE a.hasFileMovement=true AND a.activeStatus=true ORDER BY featureName")
	List<AppFeature> getActiveFileMovementAppFeatures();

	@Query("SELECT a FROM AppFeature a WHERE a.code=:code")
	AppFeature findByCode(@Param("code") String code);

//	@Query(nativeQuery = true, value = "SELECT af.code FROM app_feature af, role_feature rf, role_user ru, role_master rm, user_master um WHERE ru.user_id=um.id AND ru.role_id=rm.id AND rf.role_id=rm.id AND rf.feature_id=af.id AND (af.active_status IS NULL OR af.active_status=true) AND um.username=:username GROUP BY af.code")
//	List<String> getAppFeatureListByUserName(@Param("username") String userName);
	
	@Query(nativeQuery = true, value = " select af.code from user_master um , role_user ru , role_feature rf , app_feature af " + 
			                           " where um.id = ru.user_id and ru.role_id = rf.role_id and rf.feature_id = af.id and um.id =:userid " + 
									   " and um.status = true group by af.code ")
	List<String> getAppFeatureListByUserName(@Param("userid") Long userid);
	
	@Query(nativeQuery = true, value = "SELECT af.code FROM app_feature af, user_feature uf, user_master um WHERE uf.user_id=um.id AND  uf.feature_id=af.id AND (af.active_status IS NULL OR af.active_status=true) AND um.username=:username GROUP BY af.code")
	List<String> getUserFeaturesByUserName(@Param("username") String userName);

}
