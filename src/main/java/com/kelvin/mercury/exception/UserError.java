package com.kelvin.mercury.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserError implements Error {
    USER_NOT_FOUND(1000,"User Not Found"),
    USER_EXIST(2000,"User Already Exist");

    private final int code;
    private final String message;
}
