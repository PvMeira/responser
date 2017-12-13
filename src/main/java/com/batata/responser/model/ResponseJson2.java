package com.batata.responser.model;

import com.batata.responser.exception.model.Error;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final List<B> data;
    private final List<Error> errors;
    private final M meta;

    private ResponseJson2(ContentBuilder builder){
        this.data   = builder.data;
        this.errors = builder.errors;
        //TODO is this really necessary?
        this.meta   = (builder.meta != null ?  (M) builder.meta : null);
    }

    public static interface ContentStep<B> {
        Build withoutContent();
        Build withBody(B body);
        Build withErrors(Error... errors);
    }

    public static interface Build<M>  {
        ResponseJson2 create();
        Build withMeta(@NotNull M meta);

    }

    public static class ContentBuilder<B, M> implements Build<M>, ContentStep<B> {
        private List<B> data;
        private List<Error> errors;
        private M meta;

        public ContentBuilder withoutContent(){
            this.data   = null;
            this.errors = null;
            this.meta   = null;
            return  this;
        }

        public ContentBuilder withBody(@NotNull B body){
            data =  new ArrayList<>();
            if(body != null) {
                if(body instanceof Collections)
                    data.addAll((List) body);
                else
                    data.add(body);
            }
            return this;
        }

        public ContentBuilder withErrors(@NotNull Error... errors){
            data = null;
            this.errors = new ArrayList<Error>(Arrays.asList(errors));
            return this;
        }

        public Build withMeta(@NotNull M meta) {
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