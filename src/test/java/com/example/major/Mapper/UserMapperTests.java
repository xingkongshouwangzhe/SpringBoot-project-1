package com.example.major.Mapper;

import com.example.major.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest：表示当前地类是一个测试类，不会随同项目一块打包
@SpringBootTest
//@RunWith()：表示启动这个单元测试类（单元测试类是能不运行的），
// 需要传递一个参数，必须是SpringRunner.class的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    //idea有检测的功能，接口是不能直接创建Bean的（使用动态代理技术来解决）
    @Autowired
    private UserMapper userMapper;

    /**单元测试的特点
     * 1、必须被@Test注解修饰
     * 2、返回值类型必须是void
     * 3、方法的参数列表不指定任何类型
     * 4、方法的访问修饰符必须是public
     */
    @Test
    public void UserInsert(){

        User user = new User();
        user.setUsername("zhangs");
        user.setPassword("123");
        System.out.println(user);

        Integer rows= userMapper.UserInsert(user);
        System.out.println(rows);

    }

    @Test
    public void selectTest(){
        String username = "张三";
        User user1 = userMapper.FindByUsername(username);
        System.out.println(user1);
    }

}
