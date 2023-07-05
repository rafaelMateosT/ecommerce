package com.commerce.ecommercerafa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BRANDS")
public class Brands {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

}
