package com.xiwen.web;

import com.xiwen.pojo.Cart;
import com.xiwen.pojo.User;
import com.xiwen.service.OrderService;
import com.xiwen.service.UserService;
import com.xiwen.service.impl.OrderServiceImpl;
import com.xiwen.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();

    protected void CreateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getSession().getAttribute("username").toString();
        Cart cart = (Cart) req.getSession().getAttribute(username + "cart");
        User user = userService.getUser(username);
        String orderID = orderService.createOrder(cart, user.getId());
        req.setAttribute("orderID", orderID);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }
}
