package com.example.major.Service;


import com.example.major.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**  用户模块业务层接口*/
public interface IUserService {

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void register(User user);

    User login(String username, String password);

    List<User> selecUser();

}
