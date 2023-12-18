package com.example.major.Service;

import com.example.major.Entity.User;
import com.example.major.Service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest：表示当前地类是一个测试类，不会随同项目一块打包
@SpringBootTest
//@RunWith()：表示启动这个单元测试类（单元测试类是能不运行的），
// 需要传递一个参数，必须是SpringRunner.class的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {


    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService iUserService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("zhangsan");
            user.setPassword("123");
            iUserService.register(user);
            System.out.println("ok");
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void login(){
        try {
            String uname = "张三";
            String upass = "123456";
            iUserService.login(uname, upass);
            System.out.println("ok");
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }


    }

}
