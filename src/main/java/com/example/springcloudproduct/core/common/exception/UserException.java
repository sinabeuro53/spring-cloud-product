package com.example.springcloudproduct.core.common.exception;

/**
 * packageName  :   com.example.mission.core.common.domain.exception
 * fileName     :   UserException
 * author       :   sinabeuro53
 * date         :   2022-04-26
 * description  :
 */
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
