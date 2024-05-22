package com.xiwen.service;

import com.xiwen.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user  UserJavaBean
     */
    public void register(User user);

    /**
     * 登录
     * @param user
     * @return 返回null登陆失败，有值则成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param user
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean exit(String user);

    public User getUser(String user);

}
