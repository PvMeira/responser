package com.batata.responser.exception.factory;

import com.batata.responser.exception.GenericException;
import com.batata.responser.exception.model.Error;

public class ErrorFactory {
    /**
     * Create error object from a GenericException, all custom exceptions should pass here
     *
     * @param generic exception to be converted to list
     * @return Error object
     */
    public static Error errorFromGenericException(GenericException generic) {
        return generic.getError();
    }

    /**
     * Create error object from a Exception, all non-expected exceptions should pass here
     *
     * @param exc exception to be converted to error object
     * @return internal error
     */
    public static Error errorFromException(Exception exc) {
        return new Error("500", "Something went wrong", exc.getMessage());
    }
}
