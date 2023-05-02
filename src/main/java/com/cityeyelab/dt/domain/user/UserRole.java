package com.cityeyelab.dt.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    A00("ROLE_ADMIN"),
    A01("ROLE_USER"),
    A02("ROLE_DASHBOARD");

    private final String key;
}