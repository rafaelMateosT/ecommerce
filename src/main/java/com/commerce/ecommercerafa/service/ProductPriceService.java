package com.commerce.ecommercerafa.service;

import com.commerce.ecommercerafa.repository.PriceRepository;
import com.commerce.ecommercerafa.repository.model.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPriceService implements ProductPriceInterface {

    @Autowired
    PriceRepository priceRepository;

     public List<Prices> getAll(){
         return priceRepository.findAll();
     }
}
