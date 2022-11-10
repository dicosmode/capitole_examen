package com.capitole.capitolTest.core.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PRICES")
public class Price {
    @Id
    @GeneratedValue
    private Integer priceId;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private float price;
    private String curr;
}


/*
*                                       price_id INT NOT NULL AUTO_INCREMENT,
                                      brand_id INT NOT NULL,
                                      start_date DATETIME NOT NULL,
                                      end_date DATETIME NOT NULL,
                                      price_list INT NOT NULL,
                                      product_id INT NOT NULL,
                                      priority INT NOT NULL,
                                      price DECIMAL(20,2) NOT NULL,
                                      curr VARCHAR(4) NOT NULL,
*
* */