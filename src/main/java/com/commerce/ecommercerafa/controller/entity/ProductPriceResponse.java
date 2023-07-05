package com.commerce.ecommercerafa.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPriceResponse {

    private Long productId;
    private Long brandId;
    private Long priceId;
    private LocalDateTime applyDate;
    private Double finalPrice;


}
