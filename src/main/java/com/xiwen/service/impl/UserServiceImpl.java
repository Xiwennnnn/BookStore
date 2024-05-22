package com.xiwen.service.impl;

import com.xiwen.dao.UserDao;
import com.xiwen.dao.impl.UserDaoImpl;
import com.xiwen.pojo.User;
import com.xiwen.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean exit(String username) {
        return userDao.queryUserByUserName(username) != null;
    }

    @Override
    public User getUser(String user) {
        return userDao.queryUserByUserName(user);
    }
}
