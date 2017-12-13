package com.batata.responser.exception.model;

public class Error {

    private String code;
    private String detail;
    private String title;
    private Source source;

    public Error(String title) {
        this.code = "0";
        this.title = title;
    }

    public Error(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public Error(String code, String title, String detail) {
        this.code = code;
        this.detail = detail;
        this.title = title;
    }

    public Error(String code, String title, String detail, String pointer) {
        this.code = code;
        this.detail = detail;
        this.title = title;
        this.source = new Source(pointer);
    }

    public Error(String code, String title, String detail, String pointer, Object parameter) {
        this.code = code;
        this.detail = detail;
        this.title = title;
        this.source = new Source(pointer, (parameter != null ? parameter.toString() : null));
    }

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", detail='" + detail + '\'' +
                ", source=" + source +
                ", title='" + title + '\'' +
                '}';
    }
}
