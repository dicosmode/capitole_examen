package com.capitole.capitolTest.core.entities.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
    private String message;
    private int errorCode;
}
