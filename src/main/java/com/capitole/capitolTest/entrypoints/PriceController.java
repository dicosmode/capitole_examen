package com.capitole.capitolTest.entrypoints;

import com.capitole.capitolTest.core.entities.FeeDetail;
import com.capitole.capitolTest.core.entities.dtos.FeeDetailDTO;
import com.capitole.capitolTest.core.useCases.GetPriceUseCase;
import com.capitole.capitolTest.entrypoints.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PriceController {
    private final GetPriceUseCase getPriceUseCase;

    @Autowired
    public PriceController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @GetMapping
    public FeeDetailDTO getFeeDetail(@RequestParam Optional<LocalDateTime> implementationDate,
                                     @RequestParam Optional<Integer> productId,
                                     @RequestParam Optional<Integer> brandId) {
        this.validateInputs(implementationDate, productId, brandId);

        FeeDetail feeDetail = getPriceUseCase.execute(implementationDate.get(), brandId.get(), productId.get());

        return FeeDetailDTO.builder().build();
    }

    private void validateInputs (Optional<LocalDateTime> opImplementationDate,
                                 Optional<Integer> opProductId,
                                 Optional<Integer> opBrandId) {

        opImplementationDate.orElseThrow(() -> new NotFoundException("Implementation date is empty!"));
        opProductId.orElseThrow(() -> new NotFoundException("Product Id is empty!"));
        opBrandId.orElseThrow(() -> new NotFoundException("Brand Id is empty!"));
    }
}
