package com.alibaba.xinan.common.enums;

/**
 * @author XinAnzzZ
 * @date 2018/8/14 15:11
 */
@SuppressWarnings("unused")
public enum ResponseEnum {

    /*** 账号不存在 */
    UNKNOWN_ACCOUNT(401, "账号不存在！"),

    /*** 密码错误 */
    INCORRECT_CREDENTIAL(402, "账号或密码错误！"),

    /*** 没有访问权限 */
    UNAUTHORIZED(403, "没有访问权限！"),

    /*** 未知错误 */
    UNKNOWN_ERROR(500, "未知错误!");

    private int code;

    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
