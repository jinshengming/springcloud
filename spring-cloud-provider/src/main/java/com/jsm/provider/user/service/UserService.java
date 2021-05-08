package com.jsm.provider.user.service;


import com.jsm.common.util.service.BaseService;
import com.jsm.provider.user.dto.UserDTO;

public interface UserService extends BaseService {


    /**
     * 获取用户详情
     * @param userNo .
     * @author jinshengming
     * @date 2021/5/8 17:20
     * @return {com.jsm.provider.user.dto.UserDTO}
     */
    UserDTO get(String userNo);



}
