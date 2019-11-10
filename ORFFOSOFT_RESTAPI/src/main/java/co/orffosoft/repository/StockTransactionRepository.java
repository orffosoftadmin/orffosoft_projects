package co.orffosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.StockTransaction;


public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
	
	@Query( nativeQuery = true , value = "select * from stock_transaction st where st.stock_tran_sku_id_fk =:skuId order by stock_tran_pk desc limit 1")
	StockTransaction getSkuId(@Param("skuId") Long skuId);
	
	@Query(nativeQuery = true , value = "select stock_tran_supplier_id_fk ,st.stock_tran_sku_id_fk from stock_transaction st "
			                           + " where st.stock_tran_sku_id_fk =:itemId and st.created_by =:userId group by st.stock_tran_sku_id_fk , st.stock_tran_supplier_id_fk")
	List<Object[]> findAllSupplierIdAndItemId(@Param("itemId") Long itemId , @Param("userId") Long userId);
	
	@Query(nativeQuery = true , value = " select sum(st.stock_tran_received_qnty-st.stock_tran_issued_qnty) as closingBal "
			                           + " from stock_transaction st where st.stock_tran_sku_id_fk =:itemId ")
	Long findClosingBalanceBasedOnSupplierIdAndItem(@Param("itemId") Long itemId);
	
	@Query( nativeQuery = true , value = "select * from stock_transaction st where st.stock_tran_sku_id_fk =:skuId")
	List<StockTransaction> getTransactionDetailsBySkuId(@Param("skuId") Long skuId);
	
	
}
