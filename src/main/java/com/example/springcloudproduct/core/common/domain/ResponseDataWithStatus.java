package com.example.springcloudproduct.core.common.domain;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseDataWithStatus<T> extends ResponseEntity<T> {

    @Builder
    public ResponseDataWithStatus(T body, HttpStatus status) {
        super(body, status);
    }

    @Override
    public HttpStatus getStatusCode() {
        return super.getStatusCode();
    }

    @Override
    public int getStatusCodeValue() {
        return super.getStatusCodeValue();
    }
}
