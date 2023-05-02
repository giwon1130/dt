package com.cityeyelab.dt.config.auth.dto;

import com.cityeyelab.dt.domain.user.User;
import com.cityeyelab.dt.domain.user.UserRole;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String userId;

    private UserRole userRole;

    public SessionUser(User user) {
        this.userId = user.getUserId();
        this.userRole = user.getUserRole();
    }
}
