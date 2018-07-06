package net.htjs.pt4.util;


/**
 * 消息枚举
 *
 * @author Administrator
 */
public enum MessageEnum {

    SUCCESS("成功", "0"),
    FAILD("失败", "-1");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private MessageEnum(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }


}
