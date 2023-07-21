package com.commerce.ecommercerafa.repository;

import com.commerce.ecommercerafa.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PriceRepository extends JpaRepository<Prices, Long> {

    @Query(value = "SELECT * " +
            "        FROM PRICES p " +
            "        JOIN BRANDS b " +
            "        WHERE b.id = ?1 AND p.PRODUCT_ID = ?2 " +
            "        AND (?3 BETWEEN p.STAR_DATE AND p.END_DATE) " +
            "        ORDER BY p.PRIORITY DESC " +
            "        LIMIT 1", nativeQuery = true)
    Prices findPricesByBrandAndDate(Long brandId, Long productId, LocalDateTime appDate);
}
