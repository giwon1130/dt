package com.cityeyelab.dt.domain;

public enum Status {

    OK("200"),
    BAD_REQUEST("400"),
    NOT_FOUND("404"),
    INTERNAL_SERER_ERROR("500");

    String code;

    Status(String code) {
        this.code = code;
    }
}