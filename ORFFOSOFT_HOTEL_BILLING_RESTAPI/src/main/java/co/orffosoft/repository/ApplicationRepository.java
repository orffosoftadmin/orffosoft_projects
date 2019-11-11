package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.orffosoft.entity.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
