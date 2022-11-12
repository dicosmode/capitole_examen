package com.capitole.capitolTest.core.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue
    private int brandId;
    private String brandName;

}
