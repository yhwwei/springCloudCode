package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yhw
 * @version 1.0
 * 用于和前端交互   封装状态码 和 具体信息
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 显示具体的 出错信息or成功
     */
    private String message;

    /**
     * 具体参数数据
     */
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
