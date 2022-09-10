package com.example.springcloudproduct.core.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

/**
 * packageName  :   com.example.springcloudproduct.core.common.domain
 * fileName     :   ResponseDTO
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :   insert/update 결과에 사용할 공통 DTO
 */
@Data
@NoArgsConstructor
public class ResponseDTO {

    private String message;
    private int status;
    private Object result;
    private List<Object> resultList;

    @Builder
    public ResponseDTO(String message, int status, Object result, List<Object> resultList) {
        if(message == null) {
            message = "success";
        }
        if(Objects.isNull(status) || status == 0) {
            status = HttpStatus.OK.value();
        }
        this.message = message;
        this.status = status;
        this.result = result;
        this.resultList = resultList;
    }
}
