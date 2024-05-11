package com.xiwen.dao;

import com.xiwen.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param userName  用户名
     * @return          如果返回null，说明没有这个用户
     */
    public User queryUserByUserName(String userName);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName 用户名
     * @param password 密码
     * @return  如果返回null说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String userName, String password);

    /**
     * 保存用户信息
     * @param user 用户名
     * @return 返回-1则表示操作失败，其其他是sql语句的影响行数
     */
    public int saveUser(User user);


}
