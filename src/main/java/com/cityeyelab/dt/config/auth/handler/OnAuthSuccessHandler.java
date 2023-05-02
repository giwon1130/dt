package com.cityeyelab.dt.config.auth.handler;

import com.cityeyelab.dt.config.auth.dto.SessionUser;
import com.cityeyelab.dt.domain.CommonResponseDto;
import com.cityeyelab.dt.domain.user.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

@RequiredArgsConstructor
@Transactional
@Component
public class OnAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String userId = request.getParameter("userId");
        User user = userRepository.findByUserId(userId).orElse(null);

        user.initLoginAu();

        ObjectMapper objectMapper = new ObjectMapper();
        CommonResponseDto commonResponseDto = new CommonResponseDto(HttpStatus.OK, "로그인에 성공했습니다.");
        httpSession.setAttribute("user", new SessionUser(user));

        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(objectMapper.writeValueAsString(commonResponseDto));
        response.getWriter().flush();
    }
}
