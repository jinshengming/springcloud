package com.jsm.provider.user.controller;

import com.jsm.common.util.controller.BaseController;
import com.jsm.common.util.dto.ResultDTO;
import com.jsm.provider.user.dto.UserDTO;
import com.jsm.provider.user.service.UserService;
import com.jsm.provider.user.struct.UserStruct;
import com.jsm.provider.user.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController extends BaseController {


    @Resource
    private UserService userService;


    @GetMapping("user")
    public ResultDTO<UserVO> get(String userNo) {
        ResultDTO<UserVO> resultDTO = ResultDTO.ok();
        UserDTO dto = userService.get(userNo);
        resultDTO.setData(UserStruct.INSTANCE.toVO(dto));
        return resultDTO;
    }


}
