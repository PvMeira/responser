package com.batata.responser.model;

import com.batata.responser.exception.model.Error;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to make a http body response
 * @param <B> Body object,  it will be a 'data' element with some fields (B) or a list of errors;
 * @param <M> Meta object, it will contain a 'meta" element with some information (M);
 *
 * @see Error - com.batata.responser.exception.model.Error
 */
//TODO rename it :)
public class ResponseJson2<B, M> {
    private List<B> data;
    private List<Error> errors;
    private M meta;

    private ResponseJson2(ResponseBuilder builder){
        this.data   = builder.data;
        this.errors = builder.errors;
        //TODO is this really necessary?
        this.meta   = (builder.meta != null ?  (M) builder.meta : null);
    }

    /**
     * Builder inner class
     * @param <B> A body value
     * @param <M> A meta value (optional)
     */
    public static class ResponseBuilder<B, M> {
        private List<B> data;
        private List<Error> errors;
        private M meta;

        public ResponseBuilder withoutContent(){
            this.data   = null;
            this.errors = null;
            this.meta   = null;
            return  this;
        }

        public ResponseBuilder withBody(@NotNull B body){
            List values =  new ArrayList<>();
            if(body != null) {
                if(body instanceof Collections)
                    values.addAll((List) body);
                else
                    values.add(body);
            }
            return this;
        }

        public ResponseBuilder withErrors(@NotNull List<Error> errors){
            data = null;
            this.errors = errors;
            return this;
        }

        public ResponseBuilder withMeta(@NotNull M meta) {
            this.meta = meta;
            return this;
        }

        public ResponseJson2 create() {
            return new ResponseJson2(this);
        }
    }

    //get and setters
    public List<B> getData() {
        return data;
    }
    public List<Error> getErrors() {
        return errors;
    }
    public M getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "ResponseJson2{" +
                "data=" + data +
                ", errors=" + errors +
                ", meta=" + meta +
                '}';
    }
}