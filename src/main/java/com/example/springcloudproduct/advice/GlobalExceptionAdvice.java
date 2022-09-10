package com.example.springcloudproduct.advice;

import com.example.springcloudproduct.core.common.domain.ResponseDataWithStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName  :   com.example.springcloudproduct.advice
 * fileName     :   GlobalExceptionAdvice
 * author       :   sinabeuro53
 * date         :   2022-03-16
 * description  :
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseDataWithStatus exception(Exception e) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("cause",e.getCause());
        errorMap.put("class",e.getClass());
        errorMap.put("message",e.getMessage());
        errorMap.put("localizedMessage",e.getLocalizedMessage());

        return ResponseDataWithStatus.builder().body(errorMap).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
