package com.example.springcloudproduct.core.common.domain;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseData<T> extends ResponseEntity<T> {

    @Builder
    public ResponseData(T body) {
        super(body, HttpStatus.OK);
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
