package com.project.onlinemarketplaceservice.exception;

public class NoneExistentUserException extends RuntimeException {
  
  public NoneExistentUserException(String message) {
    super(message);
  }
}
