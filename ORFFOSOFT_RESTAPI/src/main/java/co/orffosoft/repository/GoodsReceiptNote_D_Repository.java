package co.orffosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.GoodsReceiptNote_D;

public interface GoodsReceiptNote_D_Repository extends JpaRepository<GoodsReceiptNote_D, Long>  {
	
	@Query( nativeQuery = true , value = "select * from stock_transaction st where st.stock_tran_sku_id_fk =:skuId order by stock_tran_pk desc limit 1")
	GoodsReceiptNote_D_Repository getSkuId(@Param("skuId") Long skuId);

}
