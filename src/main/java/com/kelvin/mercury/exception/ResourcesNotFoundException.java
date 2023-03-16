package com.kelvin.mercury.exception;

public class ResourcesNotFoundException extends ApiException {
    public ResourcesNotFoundException(Error error) {
        super(error.getCode(), error.getMessage());
    }
}
