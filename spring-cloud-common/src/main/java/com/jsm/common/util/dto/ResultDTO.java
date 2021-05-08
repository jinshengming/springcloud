package com.jsm.common.util.dto;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDTO<T> implements Serializable {


    private Boolean success;
    private String code;
    private String message;
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageCount;
    private Long total;
    private T data;


    private ResultDTO(){
        this.success = true;
    }

    private ResultDTO(T data) {
        this.success = true;
        this.data = data;
    }


    public static <T> ResultDTO<T> ok() {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setCode("200");
        resultDTO.setMessage("ok");
        return resultDTO;
    }


    public static <T> ResultDTO<T> ok(T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>(data);
        resultDTO.setCode("200");
        resultDTO.setMessage("ok");
        return resultDTO;
    }



}
