package com.commerce.ecommercerafa.controller;

import com.commerce.ecommercerafa.controller.model.ProductPiceResponse;
import com.commerce.ecommercerafa.repository.model.Prices;
import com.commerce.ecommercerafa.service.ProductPriceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/product/price")
public class ProductPriceController {

    @Autowired
    ProductPriceInterface productPriceInterface;

    @GetMapping
    public @ResponseBody ProductPiceResponse getProductPrice(@RequestParam() @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currentDate,
                                                             @RequestParam() Integer product,
                                                             @RequestParam() Integer brand) {

        List<Prices> ret = productPriceInterface.getAll();

        return ProductPiceResponse.builder()
                .brandId(1)
                .productId(1)
                .priceId(1)
                .finalPrice(23.9)
                .applyDate(new Date())
                .build();
    }
}
