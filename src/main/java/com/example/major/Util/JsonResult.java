package com.example.major.Util;

import java.io.Serializable;

/**
 * Json格式的数据进行响应。
 */
public class JsonResult<E> implements Serializable {

    private Integer status;
    private String message;
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer status) {
        this.status = status;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(E data) {
        this.data = data;
    }

    public JsonResult(Integer status, E data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
