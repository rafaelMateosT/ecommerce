package com.commerce.ecommercerafa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brands brand;
    @Column(name="STAR_DATE")
    private LocalDateTime startDate;
    @Column(name="END_DATE")
    private LocalDateTime endDate;
    @Column(name="PRICE_LIST")
    private Long priceList;
    @Column(name="PRODUCT_ID")
    private Long productId;
    @Column(name="PRIORITY")
    private Long priority;
    @Column(name="PRICE")
    private Double price;
    @Column(name="CURR")
    private String curr;

}
