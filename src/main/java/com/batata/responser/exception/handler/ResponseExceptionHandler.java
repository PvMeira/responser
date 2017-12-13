package com.batata.responser.exception.handler;


import com.batata.responser.exception.GenericException;
import com.batata.responser.exception.factory.ErrorFactory;
import com.batata.responser.model.ResponseJson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
    //catchs all exceptions from generic without a especific handler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = GenericException.class)
    public ResponseJson handleGenericException(GenericException genEx) {
        return new ResponseJson(ErrorFactory.errorFromGenericException(genEx));
    }
    //this will cathes all exceptions un-handled
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseJson handleException(Exception ex) {
        return new ResponseJson(ErrorFactory.errorFromException(ex));
    }
}
