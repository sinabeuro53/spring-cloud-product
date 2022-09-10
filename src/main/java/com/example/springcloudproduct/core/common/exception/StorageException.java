package com.example.springcloudproduct.core.common.exception;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 7570387923510768095L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}