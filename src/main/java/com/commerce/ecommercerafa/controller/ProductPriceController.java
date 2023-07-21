package com.commerce.ecommercerafa.controller;

import com.commerce.ecommercerafa.controller.entity.ProductPriceRequest;
import com.commerce.ecommercerafa.controller.entity.ProductPriceResponse;
import com.commerce.ecommercerafa.entity.Prices;
import com.commerce.ecommercerafa.service.ProductPriceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/product/price")
public class ProductPriceController {

    @Autowired
    ProductPriceService productPriceService;

    @PostMapping
    @ApiOperation(value = "Get product price in a date")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product price found"),
            @ApiResponse(code = 404, message = "Product price not found")})
    public ResponseEntity<ProductPriceResponse> getProductPrice(@RequestBody ProductPriceRequest priceRequest) {

        Prices dataPrices = productPriceService.findPricesByBrandAndDate(priceRequest.getBrandId(),
                priceRequest.getProductId(),
                priceRequest.getCurrentDate());

        ProductPriceResponse response =
                buildResponse(
                        dataPrices, priceRequest.getCurrentDate());

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ProductPriceResponse buildResponse(Prices price, LocalDateTime applyDate) {
        if (price != null) {
            return ProductPriceResponse.builder()
                    .brandId(price.getBrand().getId())
                    .finalPrice(price.getPrice())
                    .applyDate(applyDate)
                    .productId(price.getProductId())
                    .priceId(price.getId())
                    .build();
        } else {
            return null;
        }
    }
}
