package com.kjb.retutnformat;

import lombok.Data;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Data
public class ReturnData<T> {
    private String code;
    private String message;
    private T data;
    private long timeStamp;

    public ReturnData() {
        timeStamp = System.currentTimeMillis();
    }

    public static <T> ReturnData<T> success(T data) {
        ReturnData<T> tReturnData = new ReturnData<>();
        tReturnData.setCode(ReturnCodeEnum.RC200.getCode());
        tReturnData.setMessage(ReturnCodeEnum.RC200.getMessage());
        tReturnData.setData(data);
        return tReturnData;
    }

    public static <T> ReturnData<T> fail(String code, String message) {
        ReturnData<T> tReturnData = new ReturnData<>();
        tReturnData.setCode(code);
        tReturnData.setMessage(message);
        tReturnData.setData(null);
        return tReturnData;
    }
}
