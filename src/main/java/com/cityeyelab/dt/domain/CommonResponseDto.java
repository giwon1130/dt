package com.cityeyelab.dt.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponseDto {

    private int code;
    private String message;
    private Object data;
    private Object page;

    public CommonResponseDto(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }

    public CommonResponseDto(HttpStatus status, String message, Object data) {
        this.code = status.value();
        this.message = message;
        this.data = data;
    }

    public CommonResponseDto(HttpStatus status, String message, Object data, Object page) {
        this.code = status.value();
        this.message = message;
        this.data = data;
        this.page = page;
    }
}
