package com.cityeyelab.dt.config.auth;

import com.cityeyelab.dt.config.exception.custom.BusinessException;
import com.cityeyelab.dt.domain.user.User;
import com.cityeyelab.dt.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpServletResponse response;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(userId).orElse(null);

        if (user == null) {
            throw new NoSuchElementException("아이디 혹은 비밀번호가 올바르지 않습니다.<br>다시 입력해주세요");
        }

        if (user.getLoginAu() >= 5) {
            throw new NoSuchElementException("로그인 5회를 실패하여 계정이 잠겼습니다.<br>관리자에게 문의해주세요.");
        }

        if ("Y".equals(user.getInitLoginYn())) {
            throw new BusinessException(HttpStatus.ACCEPTED.value(), "최초 로그인");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return new org
                .springframework
                .security
                .core
                .userdetails
                .User(user.getUserId() ,user.getUserPwd(), grantedAuthorities);
    }
}
