package com.jsm.provider.user.service.impl;

import com.jsm.common.util.service.impl.BaseServiceImpl;
import com.jsm.provider.user.dto.UserDTO;
import com.jsm.provider.user.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {


    @Override
    public UserDTO get(String userNo) {
        return new UserDTO("jsm", "金生明");
    }
}
