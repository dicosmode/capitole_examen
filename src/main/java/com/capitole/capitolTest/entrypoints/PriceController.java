package com.capitole.capitolTest.entrypoints;

import com.capitole.capitolTest.core.entities.dtos.PriceDetailDTO;
import com.capitole.capitolTest.core.useCases.GetPriceUseCase;
import com.capitole.capitolTest.entrypoints.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PriceController {
    private final GetPriceUseCase getPriceUseCase;

    @Autowired
    public PriceController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @GetMapping("/price")
    public PriceDetailDTO getPriceDetail(@RequestParam
                                         @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                         Optional<LocalDateTime> implementationDate,
                                         @RequestParam Optional<Integer> productId,
                                         @RequestParam Optional<Integer> brandId) {
        this.validateInputs(implementationDate, productId, brandId);

        PriceDetailDTO priceDetailDTO = getPriceUseCase.execute(implementationDate.get(), brandId.get(), productId.get());

        return priceDetailDTO;
    }

    private void validateInputs (Optional<LocalDateTime> opImplementationDate,
                                 Optional<Integer> opProductId,
                                 Optional<Integer> opBrandId) {

        opImplementationDate.orElseThrow(() -> new NotFoundException("Implementation date is empty!"));
        opProductId.orElseThrow(() -> new NotFoundException("Product Id is empty!"));
        opBrandId.orElseThrow(() -> new NotFoundException("Brand Id is empty!"));
    }
}
