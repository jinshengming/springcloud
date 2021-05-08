package com.jsm.common.util.controller;

import com.github.pagehelper.Page;
import com.jsm.common.util.dto.ResultDTO;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * @author 金生明
 */
@CrossOrigin(exposedHeaders = {"Authorization", "authorization"})
public class BaseController {

    public <T> ResultDTO<List<T>> handlePage(Page<T> page) {
        ResultDTO<List<T>> result = ResultDTO.ok();
        List<T> data = page.getResult();
        result.setPageCount(page.getPages());
        result.setTotal(page.getTotal());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setData(data);
        return result;
    }

}
