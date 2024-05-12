package com.xiwen.web;

import com.xiwen.pojo.User;
import com.xiwen.service.UserService;
import com.xiwen.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userService.login(new User(null, username, password, null)) != null){
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else{

            req.setAttribute("msg", (String)"用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");

        User user = (User)WebUtils.copyParamToBean(req.getParameterMap(), new User());

//        2. 检查 要求验证码为：abcde
        if("abcde".equalsIgnoreCase(code)){
//            3. 检查 用户名是否可用
            if(!userService.exit(user.getUsername())){
                userService.register(user);
//                跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }else{
//                不可用
                req.setAttribute("msg", "用户名["+user.getUsername()+"]已存在！");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("password", user.getPassword());
                req.setAttribute("repwd", user.getPassword());
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }

        }else{
//            不正确
//            跳回注册页面
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("repwd", user.getPassword());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
