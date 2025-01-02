package com.eliehome.officeInformation.error;

import com.eliehome.officeInformation.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
@ResponseStatus

public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(OfficeNotFoundException.class)
    public ResponseEntity<ErrorMessage> officeNotFoundException(OfficeNotFoundException exception,
                                                                  WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> officeFieldValidationError(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST,
                exception.getBindingResult().getFieldError().getDefaultMessage()));
    }
}
