package com.kelvin.mercury.advice;

import com.kelvin.mercury.dto.ExceptionResponse;
import com.kelvin.mercury.exception.ResourcesExistException;
import com.kelvin.mercury.exception.ResourcesNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Log4j2
public class ExceptionResponseHandler {
    @ExceptionHandler(ResourcesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleResourcesNotFoundException(ResourcesNotFoundException ex, WebRequest request) {
        log.info("Enter Resources Not Found Exception Handler");
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        log.info(ex.getMessage());
        return exceptionResponse;
    }

    @ExceptionHandler(ResourcesExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleResourcesExistException(ResourcesExistException ex, WebRequest request) {
        log.info("Enter Resources Exist Exception Handler");
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        log.info(ex.getMessage());
        return exceptionResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse onMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        log.info("Enter DTO Validation Exception Handler");
        StringBuilder errorString = new StringBuilder();
        ex.getBindingResult().getFieldErrors()
                .forEach(err ->{
                    String error = String.format("[%s : %s]",err.getField(),err.getDefaultMessage());
                    errorString.append(error);
                });
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(400)
                .message(errorString.toString())
                .details(request.getDescription(false))
                .build();
        log.info(ex.getMessage());
        return exceptionResponse;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception ex, WebRequest request){
        log.info("Enter Exception Handler");
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(500)
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        log.info(ex.getMessage());
        return exceptionResponse;
    }
}
