package com.jsm.common.util.service;

import com.github.pagehelper.Page;

import java.util.Collection;

public interface BaseService {





    <E> Page<E> handlePage(Page<Object> page, Collection<E> colls);




}
