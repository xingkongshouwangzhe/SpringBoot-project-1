package com.example.major.Controller;

import com.example.major.Service.ex.InsertException;
import com.example.major.Service.ex.PasswordNotMatchException;
import com.example.major.Service.ex.UserNoFoundException;
import com.example.major.Service.ex.UsernameDulicatedException;
import com.example.major.Util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.sql.rowset.serial.SerialException;

public class BaseController {

    public static final int OK = 200;
    @ExceptionHandler(SerialException.class)
    public JsonResult<Void> handException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDulicatedException){
            result.setStatus(4000);
            result.setMessage("用户名已被占用！");
        } else if (e instanceof InsertException) {
            result.setStatus(5000);
            result.setMessage("注册市产生未知异常");
        } else if (e instanceof UserNoFoundException) {
            result.setStatus(6001);
            result.setMessage("用户数据不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setStatus(6002);
            result.setMessage("用户名的密码错误");
        }
        return result;
    }

}
