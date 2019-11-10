package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.orffosoft.entity.AppFeature;


public interface FeatureRepository extends JpaRepository<AppFeature, Long>{

}
