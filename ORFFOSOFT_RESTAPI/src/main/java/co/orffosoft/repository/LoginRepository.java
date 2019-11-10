package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.orffosoft.entity.UserMaster;

public interface LoginRepository extends JpaRepository<UserMaster, Long> {	

	@Query("SELECT u from UserMaster u WHERE u.username=?1 AND u.password=?2")
	UserMaster findByUserNameAndPassword(String username, String password);
	
	UserMaster findByUsername(String username);

	@Query("SELECT u from UserMaster u WHERE u.emailId=?1")
	UserMaster fetchEmailId(String email);

}
