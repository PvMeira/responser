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
public class ResponseJson<B, M> {
    private final List<B> data;
    private final List<Error> errors;
    private final M meta;

    public static ContentStep build(){
        return new ContentBuilder();
    }

    private ResponseJson(ContentBuilder builder){
        this.data   = builder.data;
        this.errors = builder.errors;
        //TODO is this really necessary?
        this.meta   = (builder.meta != null ?  (M) builder.meta : null);
    }

    public interface ContentStep<B> {
        Build withoutContent();
        MetaStep withBody(B body);
        MetaStep withErrors(Error... errors);

    }

    public interface MetaStep<M> {
        Build withMeta(@NotNull M meta);
        ResponseJson create();
    }

    public interface Build  {
        ResponseJson create();
    }

    private static class ContentBuilder<B, M> implements ContentStep<B>, MetaStep<M>, Build {
        private List<B> data;
        private List<Error> errors;
        private M meta;

        public Build withoutContent(){
            this.data   = null;
            this.errors = null;
            this.meta   = null;
            return  this;
        }

        public MetaStep withBody(@NotNull B body){
            data =  new ArrayList<>();
            if(body != null) {
                if(body instanceof Collections)
                    data.addAll((List) body);
                else
                    data.add(body);
            }
            return this;
        }

        public MetaStep withErrors(@NotNull Error... errors){
            data = null;
            this.errors = new ArrayList<>(Arrays.asList(errors));
            return this;
        }

        public Build withMeta(@NotNull M meta) {
            this.meta = meta;
            return this;
        }

        public ResponseJson create() {
            return new ResponseJson(this);
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