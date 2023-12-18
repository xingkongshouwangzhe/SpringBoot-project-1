package com.example.major.Mapper;

import com.example.major.Entity.User;

import java.util.List;

/**
 * 用户模块的持久层接口
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 如果找到对应的用户则返回这个用户的数据，如果没有找到则返回NULL值
     */
    /*
    @Select("select * from wx_user where username=#{username}")
    //等同于XML映射文件
     */
    User FindByUsername(String username);

    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数（增、删、改，都受影响的行数作为返回值，
     * 可以根据返回值判断是否执行成功）
     */

    /*
    @Insert("insert into wx_user (uid, username, password, phone, state, create_user, create_time) values " +
    "(#{uid}, '#{username}', '#{password}', '#{phone}', '#{state}', '#{create_user}', #{create_time})")
     */
    Integer UserInsert(User user);

    List<User> SelctUser();

}
