package com.sandeep.github01.retrofit;

//fixme it will be different based on error model
public class APIErrorResponse {
    int code;
    String message;

    public APIErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIErrorResponse() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "APIErrorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}

