package com.batata.responser.exception.model;

public class Source {

    private String pointer;
    private String parameter;

    public Source(String pointer) {
        this.pointer = pointer;
    }

    public Source(String pointer, String parameter) {
        this.pointer = pointer;
        this.parameter = parameter;
    }

    public String getPointer() {
        return pointer;
    }

    public String getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return "Source{" +
                "pointer='" + pointer + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }
}
