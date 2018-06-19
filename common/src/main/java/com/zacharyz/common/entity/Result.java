package com.zacharyz.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回对象
 */
@Data
public class Result implements Serializable {

    public String code;

    public String msg;

    public Object object;

    public Result(){}

    public Result(String code,String msg,Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }
}
