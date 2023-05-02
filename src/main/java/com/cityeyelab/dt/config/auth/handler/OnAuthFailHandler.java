package com.cityeyelab.dt.config.auth.handler;

import com.cityeyelab.dt.domain.CommonResponseDto;
import com.cityeyelab.dt.domain.user.User;
import com.cityeyelab.dt.domain.user.UserRepository;
import com.cityeyelab.dt.dto.user.UserResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@RequiredArgsConstructor
@Transactional
@Component
public class OnAuthFailHandler implements AuthenticationFailureHandler {

    private final UserRepository userRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        String errorMsg = "";
        ObjectMapper objectMapper = new ObjectMapper();

        if (exception instanceof BadCredentialsException) {
            errorMsg = "아이디 혹은 비밀번호가 올바르지 않습니다.<br>다시 입력해주세요";
        } else if (exception instanceof RuntimeException) {
            errorMsg = exception.getMessage();
        }

        String userId = request.getParameter("userId");
        User user = userRepository.findByUserId(userId).orElse(null);

        CommonResponseDto commonResponseDto = null;

        if (user != null ) {
            if ("Y".equals(user.getInitLoginYn())) {
                commonResponseDto = new CommonResponseDto(HttpStatus.ACCEPTED, "최초 로그인", new UserResponseDto(user));
            } else {
                if (user != null && user.getLoginAu() < 5) user.addLoginAu();
                commonResponseDto = new CommonResponseDto(HttpStatus.BAD_REQUEST, errorMsg);
            }
        } else {
            commonResponseDto = new CommonResponseDto(HttpStatus.BAD_REQUEST, errorMsg);
        }


        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(objectMapper.writeValueAsString(commonResponseDto));
        response.getWriter().flush();
    }
}
