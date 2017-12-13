package com.batata.responser.exception;

import com.batata.responser.exception.model.Error;

public class GenericException extends RuntimeException{

    private Error error;

    public GenericException(String title) {
        this.error = new Error(title);
    }

    public GenericException(String code, String title) {
        this.error = new Error(code, title);
    }

    public GenericException(String code, String detail, String title) {
        this.error = new Error(code, detail, title);
    }

    public GenericException(String code, String detail, String title, String pointer) {
        this.error = new Error(code, detail, title, pointer);
    }

    public GenericException(String code, String detail, String title, String pointer, Object parameter) {
        this.error = new Error(code, detail, title, pointer, parameter);
    }

    public Error getError() {
        return error;
    }
}
