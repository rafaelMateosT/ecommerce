package com.commerce.ecommercerafa.service;

import com.commerce.ecommercerafa.entity.Prices;
import com.commerce.ecommercerafa.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductPriceService {

    @Autowired
    PriceRepository priceRepository;

    public Prices findPricesByBrandAndDate(Long brandId, Long productId, LocalDateTime appDate) {
        return priceRepository.findPricesByBrandAndDate(brandId, productId, appDate);
    }
}
