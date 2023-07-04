package com.commerce.ecommercerafa.repository;

import com.commerce.ecommercerafa.repository.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends JpaRepository<Prices, Long> {
}
