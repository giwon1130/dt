package com.cityeyelab.dt.dto.user;

import com.cityeyelab.dt.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private Long id;

    private String userId;

    private String userPwd;

    private String userName;

    private String initLoginYn;

    private int loginAu;

    private String useYn;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.userPwd = entity.getUserPwd();
        this.userName = entity.getUserName();
        this.initLoginYn = entity.getInitLoginYn();
        this.loginAu = entity.getLoginAu();
        this.useYn = entity.getUseYn();
    }
}
