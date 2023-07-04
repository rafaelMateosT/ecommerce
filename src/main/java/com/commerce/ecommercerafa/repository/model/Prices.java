package com.commerce.ecommercerafa.repository.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
public class Prices {

    //ID, BRAND_ID, STAR_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="BRAND_ID")
    private Integer brandId;
    @Column(name="STAR_DATE")
    private Date startDate;
    @Column(name="END_DATE")
    private Date endDate;
    @Column(name="PRICE_LIST")
    private Integer priceList;
    @Column(name="PRODUCT_ID")
    private Integer productId;
    @Column(name="PRIORITY")
    private Integer priority;
    @Column(name="PRICE")
    private Double price;
    @Column(name="CURR")
    private String curr;

}
