package com.cityeyelab.dt.config.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponseDto {
    private int code;
    private String message;
}
