package com.cityeyelab.dt.config.auth.jwt;/*
package com.pcn.fiss.config.auth.jwt;

import com.pcn.fiss.domain.user.User;
import com.pcn.fiss.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        User user = userRepository.findByUserId(authentication.getPrincipal().toString()).orElse(null);

        if (user.getLoginAu() >= 5) {
            //TODO 예외 처리
            throw null;
        }

        if ("0".equals(user.getInitPwd())) {
            //TODO 예외 처리
            return null;
        }

        if (encoder.matches(authentication.getCredentials().toString(), user.getUserPwd())) {
            user.initLoginAu();
        } else {
            user.addLoginAu();
            throw new BadCredentialsException("비밀번호 오류입니다.");
        }

        AuthenticationToken token = new AuthenticationToken(user.getUserId(), user.getUserPwd(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        token.setId(user.getId());
        token.setUserId(user.getUserId());
        token.setRole(user.getUserRole().getKey());

        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(AuthenticationToken.class);
    }
}
*/
