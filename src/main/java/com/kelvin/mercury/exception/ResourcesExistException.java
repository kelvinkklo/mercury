package com.kelvin.mercury.exception;

public class ResourcesExistException extends ApiException {
    public ResourcesExistException(Error error) {
        super(error.getCode(), error.getMessage());
    }
}
