package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster,Long>{
	
	@Query(value="select cust from CustomerMaster cust where lower(cust.name) = lower(?1)")
	CustomerMaster findByName(String name);
	
	@Query(value="select cust from CustomerMaster cust where cust.primaryContactNumber = ?1")
	CustomerMaster findByPrimaryContactNumber(String primaryContactNumber);
	
	@Query(value = "select * from customer_master cm where  lower(cm.primary_contact_number) like lower(concat('%', :mobile,'%')) ", nativeQuery = true)
	List<CustomerMaster> findMobileNumberAutoSearch(@Param("mobile") String mobile);
	
	@Query(value="select cust from CustomerMaster cust where cust.syncCode = ?1")
	CustomerMaster findCustomerBySyncCode(Long syncCode);
	
	@Query(value = "select * from customer_master where primary_contact_number ilike :mobile and entity_id = :entityId", nativeQuery = true)
	List<CustomerMaster> loadMobileNumberAutoSearch(@Param("mobile") String mobile , @Param("entityId") Long entityId);
	
	@Query(value = "select * from customer_master cm where cm.primary_contact_number = :mobno", nativeQuery = true)
	CustomerMaster findCustomerByMobilenumber(@Param("mobno") String mobno);
	
}
