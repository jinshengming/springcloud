package net.htjs.pt4.controller;

import net.htjs.pt4.dto.CommonResultDTO;
import net.htjs.pt4.model.User;
import net.htjs.pt4.service.UserService;
import net.htjs.pt4.util.CommonResponse;
import net.htjs.pt4.util.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public CommonResultDTO login(@RequestBody User user, HttpServletRequest request) {
        user = userService.login(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return CommonResponse.createCommons(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
        }
        return CommonResponse.createCommons(MessageEnum.FAILD.getCode(), MessageEnum.FAILD.getMsg());
    }

    @PostMapping("insert")
    @ResponseBody
    public CommonResultDTO insertUser(@RequestBody User user){
        int result = userService.insertUser(user);
        if(result > 0){
            return CommonResponse.createCommons(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
        }
        return CommonResponse.createCommons(MessageEnum.FAILD.getCode(), MessageEnum.FAILD.getMsg());
    }
}
