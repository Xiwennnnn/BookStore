package com.xiwen.test;

import com.xiwen.dao.UserDao;
import com.xiwen.dao.impl.UserDaoImpl;
import com.xiwen.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUserName() {
        if(userDao.queryUserByUserName("admin123") == null){
            System.out.println("用户名可用!");
        }else{
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误！");
        } else {
            System.out.println("登录成功!");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "admin2123", "123456", "wzg168@qq.com")));
    }
}