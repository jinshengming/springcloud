package net.htjs.pt4.dto;

import java.io.Serializable;

/**
 * 封装响应通用类
 *
 * @author Administrator
 */
public class CommonResultDTO implements Serializable {

    private String resultCode;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
