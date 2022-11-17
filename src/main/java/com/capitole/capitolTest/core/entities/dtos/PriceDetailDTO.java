package com.capitole.capitolTest.core.entities.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PriceDetailDTO {
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private float price;
}
