package com.commerce.ecommercerafa;

import com.commerce.ecommercerafa.controller.ProductPriceController;
import com.commerce.ecommercerafa.controller.entity.ProductPriceRequest;
import com.commerce.ecommercerafa.controller.entity.ProductPriceResponse;
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
        ProductPriceRequest priceRequest = ProductPriceRequest.builder().productId(1L).brandId(1L).currentDate(LocalDateTime.now()).build();
        ProductPriceResponse expectedResponse = new ProductPriceResponse();
        Prices prices = new Prices();
        prices.setPrice(1.1);
        List<Prices> mockPrices = new ArrayList<>();
        mockPrices.add(prices);


        when(productPriceService.findPricesByBrandAndDate(anyLong(), anyLong(), any()))
                .thenReturn(mockPrices);
        when(productPriceService.findBestPrice(mockPrices))
                .thenReturn(prices);
        when(productPriceService.buildResponse(any(),any()))
                .thenReturn(expectedResponse);

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
        Prices prices = new Prices();
        prices.setPrice(1.1);
        List<Prices> mockPrices = new ArrayList<>();
        mockPrices.add(prices);


        when(productPriceService.findPricesByBrandAndDate(anyLong(), anyLong(), any()))
                .thenReturn(mockPrices);
        when(productPriceService.findBestPrice(mockPrices))
                .thenReturn(prices);
        when(productPriceService.buildResponse(any(),any()))
                .thenReturn(null);

        // Act
        ResponseEntity<ProductPriceResponse> response = productPriceController.getProductPrice(priceRequest);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}