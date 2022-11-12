package com.capitole.capitolTest.core.useCases;

import com.capitole.capitolTest.core.entities.FeeDetail;

import java.time.LocalDateTime;

@FunctionalInterface
public interface GetPriceUseCase {
    FeeDetail execute(LocalDateTime implementationDate, int brandId, int productId);
}
