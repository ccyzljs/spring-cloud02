package com.xsm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;

    private String message;

    private T      data;

    public CommonResult(int code,String message) {
        this(code,message,null);
    }
}
