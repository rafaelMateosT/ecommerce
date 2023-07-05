package com.commerce.ecommercerafa.controller.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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
