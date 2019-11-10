package co.orffosoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.orffosoft.entity.EmailMessage;

public interface EmailMessageRepository extends JpaRepository<EmailMessage, Long> {

	@Query("SELECT m FROM EmailMessage m WHERE m.mailSent=?1")
	List<EmailMessage> listEmailMessages(String mailSent);

//	@Transactional
//	@Modifying
//	@Query("UPDATE EmailMessage c SET c.mailSent =?1 WHERE c.id = ?2")
//	int updateMailSentStatus(String mailSent, Long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM EmailMessage c WHERE c.mailSent =?1")
	void deleteMailMessage(String mailSent);

}
