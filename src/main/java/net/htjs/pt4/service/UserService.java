package net.htjs.pt4.service;

import java.util.List;

import javax.annotation.Resource;

import net.htjs.pt4.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.htjs.pt4.dao.UserMapper;
import net.htjs.pt4.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName()).andUserPwdEqualTo(user.getUserPwd());
        List<User> list = userMapper.selectByExample(userExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public int insertUser(User user){
        return userMapper.insert(user);
    }
}
