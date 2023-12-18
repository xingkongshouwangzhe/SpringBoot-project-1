package com.example.major.Service.impl;

import com.example.major.Entity.User;
import com.example.major.Mapper.UserMapper;
import com.example.major.Service.IUserService;
import com.example.major.Service.ex.InsertException;
import com.example.major.Service.ex.PasswordNotMatchException;
import com.example.major.Service.ex.UserNoFoundException;
import com.example.major.Service.ex.UsernameDulicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //通过user的参数来获取传递过来的username
        String username = user.getUsername();
        //调用FindByUsername(username)判断用户是否被注册过
        User result = userMapper.FindByUsername(username);
        //判断结果集是否为不为NULL则抛出用户名已被占用的异常
        if (result != null){
            throw new UsernameDulicatedException("用户名已存在");
        }

        //补全日志数据
        user.setState(0);
        user.setCreateUser(user.getUsername());
        Date date = new Date();
        user.setCreateTime(date);

        //执行注册业务功能的实现（rows==1）
        Integer rows = userMapper.UserInsert(user);
        if (rows != 1){
            throw new InsertException("用户注册过程中产生了未知的异常！");
        }


    }

    @Override
    public User login(String username, String password) {

        User result = userMapper.FindByUsername(username);
        if (result == null){
            System.out.println("用户数据不存在");
            throw new UserNoFoundException("用户数据不存在！");
        }
        String pwd = result.getPassword();
        if (!password.equals(pwd)){
            throw new PasswordNotMatchException("用户密码错误！");
        }

        return result;
    }

    @Override
    public List<User> selecUser() {
        return userMapper.SelctUser();
    }
}
