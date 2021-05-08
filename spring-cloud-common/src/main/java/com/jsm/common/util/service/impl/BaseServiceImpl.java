package com.jsm.common.util.service.impl;

import com.github.pagehelper.Page;
import com.jsm.common.util.service.BaseService;

import java.util.Collection;

public class BaseServiceImpl implements BaseService {


    @Override
    public <E> Page<E> handlePage(Page<Object> objects, Collection<E> list) {
        Page<E> page = new Page<>();
        page.addAll(list);
        if (objects != null) {
            page.setPageNum(objects.getPageNum());
            page.setPageSize(objects.getPageSize());
            page.setTotal(objects.getTotal());
            page.setPages(objects.getPages());
        }
        return page;
    }
}
