package co.orffosoft.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.orffosoft.entity.ItemPrice;

public interface ItemPriceRepository extends JpaRepository<ItemPrice, Long> {

	@Query(nativeQuery = true, value = "select case when itm.itemprice_new_price >= 0 then itm.itemprice_new_price else  itm.itemprice_old_price end as price from itemPrice itm where itm.itemprice_sku_fk =:skuId group by price order by price  desc")
	List<BigDecimal> findSellingPriceByItemId(@Param("skuId") Long skuId);

}
