package com.cityeyelab.dt.dto.user;

import com.cityeyelab.dt.domain.user.User;
import com.cityeyelab.dt.domain.user.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class UserSaveRequestDto {

    @ApiModelProperty(value="유저 ID", example = "userId", required = true)
    private String userId;

    @ApiModelProperty(value="유저 이름", example = "운영자", required = true)
    private String userName;

    @ApiModelProperty(value="유저 비밀번호", example = "u1234", required = true)
    private String userPwd;

    @ApiModelProperty(value="관리자 ID", example = "admin", required = true)
    private String masterId;

    public User toEntity(BCryptPasswordEncoder encoder, String masterId) {
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(encoder.encode(userPwd))
                .userRole(UserRole.A01)
                .initLoginYn("Y")
                .useYn("Y")
                .masterId(masterId)
                .build();
    }
}
