package com.commerce.ecommercerafa;

import com.commerce.ecommercerafa.controller.ProductPriceController;
import com.commerce.ecommercerafa.controller.entity.ProductPriceRequest;
import com.commerce.ecommercerafa.controller.entity.ProductPriceResponse;
import com.commerce.ecommercerafa.entity.Brands;
import com.commerce.ecommercerafa.entity.Prices;
import com.commerce.ecommercerafa.service.ProductPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

class ProductPriceControllerTest {

    @Mock
    private ProductPriceService productPriceService;

    @InjectMocks
    private ProductPriceController productPriceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductPrice_Success() {
        ProductPriceRequest priceRequest =
                ProductPriceRequest.builder().productId(1L).brandId(1L).currentDate(LocalDateTime.now()).build();

        ProductPriceResponse expectedResponse = new ProductPriceResponse();
        expectedResponse.setProductId(1L);
        expectedResponse.setFinalPrice(1.1);
        expectedResponse.setProductId(1L);
        expectedResponse.setBrandId(1L);
        expectedResponse.setApplyDate(priceRequest.getCurrentDate());
        expectedResponse.setPriceId(1L);

        Prices prices = new Prices();
        Brands brand = new Brands();
        brand.setId(1L);
        brand.setName("PRUEBA");

        prices.setPrice(1.1);
        prices.setProductId(1L);
        prices.setPriceList(1L);
        prices.setId(1L);
        prices.setCurr("PRUEBAS");
        prices.setBrand(brand);

        when(productPriceService.findPricesByBrandAndDate(anyLong(), anyLong(), any()))
                .thenReturn(prices);

        // Act
        ResponseEntity<ProductPriceResponse> response = productPriceController.getProductPrice(priceRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetProductPrice_NotFound() {
        ProductPriceRequest priceRequest = ProductPriceRequest.builder().productId(1L).brandId(1L).currentDate(LocalDateTime.now()).build();
        ProductPriceResponse expectedResponse = new ProductPriceResponse();
        Prices prices = null;

        when(productPriceService.findPricesByBrandAndDate(anyLong(), anyLong(), any()))
                .thenReturn(prices);
        // Act
        ResponseEntity<ProductPriceResponse> response = productPriceController.getProductPrice(priceRequest);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}