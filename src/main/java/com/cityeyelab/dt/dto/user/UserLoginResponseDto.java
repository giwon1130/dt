package com.cityeyelab.dt.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {

    @ApiModelProperty(value="유저 ID", example = "userId", required = true)
    private String userId;
}