package com.cityeyelab.dt.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserUpdateRequestDto {

    @ApiModelProperty(value = "유저 NO", example = "userNo", required = true)
    private Long userNo;

    @ApiModelProperty(value = "유저 ID", example = "userId", required = false)
    private String userId;

    @ApiModelProperty(value = "유저 이름", example = "운영자", required = false)
    private String userName;

    @ApiModelProperty(value = "유저 비밀번호", example = "u1234", required = false)
    private String userPwd;

    @ApiModelProperty(value = "관리자 비밀번호", example = "a1234", required = true)
    @NotNull(message = "관리자 비밀번호를 입력하세요.")
    private String adminPwd;

    @ApiModelProperty(value = "유저 사용여부", example = "Y", required = false)
    private String useYn;

    @ApiModelProperty(value = "최초로그인 여부", example = "N", required = false)
    private String initLoginYn;
}
