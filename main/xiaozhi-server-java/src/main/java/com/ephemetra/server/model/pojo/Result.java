package com.ephemetra.server.model.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {

    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }
}