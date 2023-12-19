package com.way.shortlink.admin.common.convention.result;

import com.way.shortlink.admin.common.convention.errorcode.BaseErrorCode;

/**
 * 全局返回对象构造器
 */
public final class Results {

    /**
     * 构造不带数据的成功响应
     */
    public static Result<Void> success(){
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 返回带数据的成功响应
     */
    public static <T> Result<T> success(T data){
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构建服务端失败响应
     */
    public static Result<Void> failure(){
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVICE_ERROR.code())
                .setMessage(BaseErrorCode.SERVICE_ERROR.message());
    }

    /**
     * 通过errorCode, errormessage构建失败响应
     */
    public static Result<Void> failure(String errorCode, String message){
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(message);
    }
}
