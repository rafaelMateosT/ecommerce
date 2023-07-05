package com.commerce.ecommercerafa.controller.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductPriceRequest {

    private Long brandId;
    private Long productId;
    private LocalDateTime currentDate;

}
