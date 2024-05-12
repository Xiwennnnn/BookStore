package com.xiwen.web;


import com.xiwen.pojo.User;
import com.xiwen.service.UserService;
import com.xiwen.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        2. 检查 要求验证码为：abcde
        if("abcde".equalsIgnoreCase(code)){
//            3. 检查 用户名是否可用
            if(!userService.exit(username)){
                userService.register(new User(null, username, password, email));
//                跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }else{
//                不可用
                System.out.println("用户名["+username+"]已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            }

        }else{
//            不正确
//            跳回注册页面
            System.out.println("验证码["+ code +"]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
