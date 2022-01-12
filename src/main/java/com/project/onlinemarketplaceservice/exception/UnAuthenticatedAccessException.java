package com.project.onlinemarketplaceservice.exception;

public class UnAuthenticatedAccessException extends RuntimeException {

    public UnAuthenticatedAccessException() {
    }

    public UnAuthenticatedAccessException(String message) {
        super(message);
    }
}
