package com.cityeyelab.dt.config.auth;

import com.cityeyelab.dt.config.auth.handler.OnAuthFailHandler;
import com.cityeyelab.dt.config.auth.handler.OnAuthSuccessHandler;
import com.cityeyelab.dt.domain.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final OnAuthSuccessHandler onAuthSuccessHandler;
    private final OnAuthFailHandler onAuthFailHandler;

    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/login", "/index.html","/api/login", "/api/logout", "/api/user/init/passwd",
                            "/swagger-ui/*", "/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**", "/assets/**",
                            "/testMap", "/favicon.ico","/js/**", "/css/**", "/static/img.map/before_img/**","/map/**","/api/facility/**, /api/mapSetting/**", "/test").permitAll()
                    .antMatchers("api/**").hasAnyRole(UserRole.A00.name())
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login")
                    .usernameParameter("userId")
                    .passwordParameter("userPwd")
                    .loginProcessingUrl("/api/login")
                    .successHandler(onAuthSuccessHandler)
                    .failureHandler(onAuthFailHandler)
                .and()
                    .logout()
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/");

        return http.build();
    }
}