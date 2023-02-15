package com.tll.wallet.web;

/**
 * 业务状态码的枚举
 *
 * @author java@fwh
 * @version 0.0.1
 */
public enum ServiceCode {

    /**
     * 成功
     */
    OK(20000),
    /**
     * 错误：尝试访问的数据不存在
     */
    ERR_NOT_FOUND(40400),
    /**
     * 错误：更新数据错误
     */
    ERR_UPDATE(50200),
    /**
     * 错误：未知错误
     */
    ERR_UNKNOWN(99999);

    private Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
