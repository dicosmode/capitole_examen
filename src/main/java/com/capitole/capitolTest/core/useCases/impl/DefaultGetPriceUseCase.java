package com.capitole.capitolTest.core.useCases.impl;

import com.capitole.capitolTest.core.entities.Price;
import com.capitole.capitolTest.core.entities.dtos.PriceDetailDTO;
import com.capitole.capitolTest.core.useCases.GetPriceUseCase;
import com.capitole.capitolTest.core.exception.PricesNotFoundException;
import com.capitole.capitolTest.repositories.GetPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Component
public class DefaultGetPriceUseCase implements GetPriceUseCase {
    private GetPriceRepository getPriceRepository;

    @Autowired
    public DefaultGetPriceUseCase(GetPriceRepository getPriceRepository) {
        this.getPriceRepository = getPriceRepository;
    }

    @Override
    public PriceDetailDTO execute(LocalDateTime implementationDate, int brandId, int productId) {
        List<Price> prices = this.getPriceRepository.findAllPrices(implementationDate,
                                                                        Integer.valueOf(brandId),
                                                                        Integer.valueOf(productId));
        Price price = prices.stream().max(Comparator.comparing(Price::getPriority)).orElseThrow(() -> new PricesNotFoundException("No found prices"));
        return PriceDetailDTO.builder()
                .priceList(price.getPriceList())
                .price(price.getPrice())
                .productId(price.getProductId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .brandId(price.getBrandId())
                .build();

    }
}
