package com.capitole.capitolTest.core.useCases.impl;

import com.capitole.capitolTest.core.entities.FeeDetail;
import com.capitole.capitolTest.core.useCases.GetPriceUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DefaultGetPriceUseCase implements GetPriceUseCase {
    @Override
    public FeeDetail execute(LocalDateTime implementationDate, int brandId, int productId) {
        return null;
    }
}
