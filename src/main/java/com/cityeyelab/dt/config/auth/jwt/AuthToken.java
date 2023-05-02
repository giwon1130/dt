package com.cityeyelab.dt.config.auth.jwt;

public interface AuthToken <T> {

    String AUTHORITIES_KEY = "role";
    boolean validate();
    T getDate();
}
