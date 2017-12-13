package com.batata.responser.model;

import com.batata.responser.exception.model.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to mapping a object to a formatted json response
 *
 * @param <T> body class (data OR error)
 * @param <U> meta class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseJson<T, U> {
    private List<T> data;
    private List<Error> errors;
    private U meta;

    public ResponseJson(){
        data = null;
        errors = null;
        meta = null;
    }

    public ResponseJson(@NotNull T body) {
        setBody(body);
    }

    public ResponseJson(@NotNull T body, @NotNull U meta) {
        setBody(body);
    }

    private void setBody(T body) {
        List values =  new ArrayList<>();

       if(body != null) {
            if(body instanceof Collections)
                values.addAll((List) body);
             else
                values.add(body);
        }

        if(!values.isEmpty()){
            if(values.get(0) instanceof Error) {
                errors = values;
            } else {
                data = values;
            }
        } else {
            data = null;
        }
    }

    public List<?> getBody(){
        if(data != null)
            return  data;
        else
            return errors;
    }

    public U getMeta() {
        return meta;
    }
}