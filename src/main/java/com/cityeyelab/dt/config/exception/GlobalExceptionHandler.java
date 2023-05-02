package com.cityeyelab.dt.config.exception;

import com.cityeyelab.dt.config.exception.custom.BusinessException;
import com.cityeyelab.dt.config.exception.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDto illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponseDto noSuchExHandler(NoSuchElementException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorResponseDto loginFailureHandler(BadCredentialsException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(SQLException.class)
    public ErrorResponseDto loginFailureHandler2(SQLException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(e.getErrorCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponseDto businessHandler(BusinessException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(e.getErrCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto runtimeHandler(RuntimeException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto vaildHandler(MethodArgumentNotValidException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponseDto entityNotFoundHandler(EntityNotFoundException e) {
        log.error("[exceptionHandler] e", e);
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

}
