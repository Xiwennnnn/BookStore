package com.xiwen.test;

import com.xiwen.dao.UserDao;
import com.xiwen.dao.impl.UserDaoImpl;
import com.xiwen.pojo.User;
import com.xiwen.service.UserService;
import com.xiwen.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void register() {
        User user = new User(null, "admin1", "123456", "example@qq.com");
        userService.register(user);
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void exit() {
        System.out.println(userService.exit("admin"));
    }
}