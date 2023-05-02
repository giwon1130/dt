package com.cityeyelab.dt.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserLoginRequestDto {

    @ApiModelProperty(value="유저 ID", example = "userId", required = true)
    @NotNull(message = "아이디를 입력하세요.")
    private String userId;

    @ApiModelProperty(value="유저 PWD", example = "1234", required = true)
    @NotNull(message = "비밀번호를 입력하세요.")
    private String userPwd;

}