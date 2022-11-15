package com.capitole.capitolTest.repositories;

import com.capitole.capitolTest.core.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GetPriceRepository extends JpaRepository<Price, Long> {
    @Query(
            value = "SELECT * FROM PRICES p WHERE ?1 >= p.start_date AND ?1 <= p.end_date AND p.brand_id = ?2 AND p.product_id = ?3",
            nativeQuery = true)
    List<Price> findAllPrices(LocalDateTime implementationDate, Integer brandId, Integer productId);
}
