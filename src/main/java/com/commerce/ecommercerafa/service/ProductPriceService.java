package com.commerce.ecommercerafa.service;

import com.commerce.ecommercerafa.controller.entity.ProductPriceResponse;
import com.commerce.ecommercerafa.entity.Prices;
import com.commerce.ecommercerafa.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductPriceService {

    @Autowired
    PriceRepository priceRepository;

    public List<Prices> findPricesByBrandAndDate(Long brandId, Long productId, LocalDateTime appDate) {
        return priceRepository.findPricesByBrandAndDate(brandId,productId,appDate);
    }

    public Prices findBestPrice(List<Prices> prices){
        if (!prices.isEmpty()) {
            Prices price = prices.stream()
                    .max(Comparator.comparing(p -> p.getPriority()))
                    .get();
            return price;
        }else {
            return null;
        }
    }

    public ProductPriceResponse buildResponse(Prices price, LocalDateTime applyDate){
        if(price != null){
            return ProductPriceResponse.builder()
                    .brandId(price.getBrand().getId())
                    .finalPrice(price.getPrice())
                    .applyDate(applyDate)
                    .productId(price.getProductId())
                    .priceId(price.getId())
                    .build();
        }else{
            return null;
        }
    }
}
