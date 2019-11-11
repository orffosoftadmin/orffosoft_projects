package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.TemplateDetails;
import co.orffosoft.enums.TemplateCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TemplateDetailsRepository extends JpaRepository<TemplateDetails, Long> {

	TemplateDetails findByTemplateCode(TemplateCode templateCode);
	
	@Query("SELECT t FROM TemplateDetails t where t.templateCode=?1")
	String findByTemplateCodeExites(String templateCode);
	
	@Query("SELECT t FROM TemplateDetails t where t.activeStatus=true")
	List<TemplateDetails> getActiveTemplateDetails();
	
	@Query("SELECT td FROM TemplateDetails td WHERE td.templateCode = ?1")
	TemplateDetails findByCode(String code);
	
	@Query("SELECT t FROM TemplateDetails t where t.templateType=:templateType and t.templateGroup=:templateGroup and t.activeStatus=true")
	List<TemplateDetails> getAllHelpdeskTemplates(@Param("templateType") String templateType,@Param("templateGroup") String templateGroup);
	
	

}
