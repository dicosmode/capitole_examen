package com.capitole.capitolTest.core.useCases;

import com.capitole.capitolTest.core.entities.dtos.PriceDetailDTO;

import java.time.LocalDateTime;

@FunctionalInterface
public interface GetPriceUseCase {
    PriceDetailDTO execute(LocalDateTime implementationDate, int brandId, int productId);
}
