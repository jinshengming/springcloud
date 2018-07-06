package net.htjs.pt4.util;

import net.htjs.pt4.dto.CommonResultDTO;

public class CommonResponse {


    public static CommonResultDTO createCommons(String resultCode, String resultMsg) {
        CommonResultDTO commonResultDTO = new CommonResultDTO();
        commonResultDTO.setResultCode(resultCode);
        commonResultDTO.setResultMsg(resultMsg);
        return commonResultDTO;
    }
}
