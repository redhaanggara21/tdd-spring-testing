package com.red21.restdemo.exception;

public class CloudVendorNotFoundException extends RuntimeException {

  public CloudVendorNotFoundException(String message) { super(message); }

  public CloudVendorNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
