package com.capitole.capitolTest.core.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue
    private int brandId;
    private String brandName;

}
