package com.cityeyelab.dt.domain.user;

import com.cityeyelab.dt.dto.user.UserUpdateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name="USER_SEQ_GENERATOR",
        sequenceName="USER_SEQ",
        initialValue=1,
        allocationSize=10)
@Entity
@Table(name = "USERS")
public class User {

    @Column(name = "user_no")
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR")
    private Long id;

    private String userId;

    private String userPwd;

    private String userName;

    private String initLoginYn;

    private int loginAu;

    private String useYn;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String masterId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public User(String userId, String userPwd, String userName, String initLoginYn, int loginAu, String useYn, UserRole userRole, String masterId) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.initLoginYn = initLoginYn;
        this.loginAu = loginAu;
        this.useYn = useYn;
        this.userRole = userRole;
        this.masterId = masterId;
        this.createdDate = now();
        this.modifiedDate = now();
    }

    public void addLoginAu() {
        this.loginAu = loginAu +1;
    }

    public void initLoginAu() {
        this.loginAu = 0;
    }

    public void updateUser(UserUpdateRequestDto requestDto, BCryptPasswordEncoder encoder) {

        if (StringUtils.hasText(requestDto.getUserId())) {
            this.userId = requestDto.getUserId();
        }

        if (StringUtils.hasText(requestDto.getUserName())) {
            this.userName = requestDto.getUserName();
        }

        if (StringUtils.hasText(requestDto.getUserPwd())) {
            this.userPwd = encoder.encode(requestDto.getUserPwd());
        }

        if (StringUtils.hasText(requestDto.getUseYn())) {
            this.useYn = requestDto.getUseYn();
        }

        if (StringUtils.hasText(requestDto.getInitLoginYn())) {
            this.initLoginYn = requestDto.getInitLoginYn();
        }

        this.modifiedDate = now();
    }
}
