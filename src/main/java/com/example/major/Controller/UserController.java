package com.example.major.Controller;

import com.example.major.Entity.User;
import com.example.major.Service.IUserService;
import com.example.major.Service.ex.InsertException;
import com.example.major.Service.ex.UsernameDulicatedException;
import com.example.major.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@Controller+@ResponseBody
@RequestMapping("/users")
public class UserController extends BaseController{

    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;


    //http://127.0.0.1:8081/users/user
    @RequestMapping("/user")
    public List<User> selectUser(){
        return userService.selecUser();
    }

    //http://127.0.0.1:8081/users/reg?username=张三&password=123456
    @RequestMapping("/reg")
    //@ResponseBody  //表示此方法的响应以Json格式进行数据的响应给前端
    public JsonResult<Void> reg(User user){

//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            userService.register(user);
//            result.setStatus(200);
//            result.setMessage("用户注册成功！");
//        }catch (UsernameDulicatedException e){
//            result.setStatus(4000);
//            result.setMessage("用户名被占用！");
//        } catch (InsertException e){
//            result.setStatus(5000);
//            result.setMessage("注册是产生未知的异常");
//        }
//        return result;

        userService.register(user);
        return new JsonResult<>(OK);
    }


    //http://127.0.0.1:8081/users/login?username=张三&password=123456
    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password){

        User data = userService.login(username,password);
        return new JsonResult<User>(OK, data);
    }

}
