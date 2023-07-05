package com.commerce.ecommercerafa.repository;

import com.commerce.ecommercerafa.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Prices, Long> {

    @Query("SELECT p " +
            "        FROM Prices p " +
            "        JOIN p.brand b " +
            "        WHERE b.id = ?1 AND p.productId = ?2 " +
            "        AND (?3 BETWEEN p.startDate AND p.endDate) " +
            "        ORDER BY p.priority ASC ")
    List<Prices> findPricesByBrandAndDate(Long brandId, Long productId, LocalDateTime appDate);
}
