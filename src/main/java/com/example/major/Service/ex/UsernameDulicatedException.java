package com.example.major.Service.ex;

public class UsernameDulicatedException extends ServiceException{
    //alt + insert --- override methods


    public UsernameDulicatedException() {
        super();
    }

    public UsernameDulicatedException(String message) {
        super(message);
    }

    public UsernameDulicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDulicatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDulicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
