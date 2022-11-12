package com.capitole.capitolTest.core.entities.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class FeeDetailDTO {
    private int productId;
    private int brandId;
    private int priceId;
    private LocalDateTime implementationDate;
}
