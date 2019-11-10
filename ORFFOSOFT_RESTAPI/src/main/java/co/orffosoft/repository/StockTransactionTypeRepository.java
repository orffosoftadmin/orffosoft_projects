package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.StockTransactionType;

public interface StockTransactionTypeRepository extends JpaRepository<StockTransactionType, Long> {
	
	@Query("select stt from StockTransactionType stt where stt.stock_tran_type_name =:grnName")
	StockTransactionType getGRNID(@Param("grnName") String grnName);

}
