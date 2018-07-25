package com.dzz.result;

import java.io.Serializable;
import java.util.UUID;

/**
 * Json返回结果
 * @author dangzhizheng
 */
public class JsonResult implements Serializable {

    private int code;

    private Object result;

    private String message;

    private UUID queryId;

    public JsonResult() {
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
        queryId = UUID.randomUUID();
    }

    public JsonResult(int code, Object result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
        queryId = UUID.randomUUID();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getQueryId() {
        return queryId;
    }

    public void setQueryId(UUID queryId) {
        this.queryId = queryId;
    }
}
