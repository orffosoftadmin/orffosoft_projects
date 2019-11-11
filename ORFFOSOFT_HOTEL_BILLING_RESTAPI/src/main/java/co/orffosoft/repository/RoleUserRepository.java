package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.orffosoft.entity.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser,Long> {
	
//	@Query(value="select cust from RoleUser cust where lower(cust.name) = lower(?1)")
//	RoleUser findByName(String name);
	

}
