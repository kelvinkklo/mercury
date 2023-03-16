package com.kelvin.mercury.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }
}
