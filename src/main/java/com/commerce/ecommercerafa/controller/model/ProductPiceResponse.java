package com.commerce.ecommercerafa.controller.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPiceResponse {

    private Integer productId;
    private Integer brandId;
    private Integer priceId;
    private Date applyDate;
    private Double finalPrice;


}
