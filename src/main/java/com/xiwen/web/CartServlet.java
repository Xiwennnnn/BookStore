package com.xiwen.web;

import com.xiwen.pojo.Book;
import com.xiwen.pojo.Cart;
import com.xiwen.pojo.CartItem;
import com.xiwen.service.BookService;
import com.xiwen.service.impl.BookServiceImpl;
import com.xiwen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getSession().getAttribute("username");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBookById(id);
        CartItem cartItem = WebUtils.parseCartItem(book);
        Cart cart = (Cart)req.getSession().getAttribute(username+"cart");
        if(cart == null){
            cart = new Cart();
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute(username + "cart", cart);
        resp.sendRedirect( req.getContextPath() + "/pages/cart/cart.jsp");

    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getSession().getAttribute("username");
        Cart cart = (Cart)req.getSession().getAttribute(username +"cart");
        cart.deleteItem(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect( req.getContextPath() + "/pages/cart/cart.jsp");
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getSession().getAttribute("username");
        Cart cart = (Cart)req.getSession().getAttribute(username + "cart");
        cart.clear();
        resp.sendRedirect( req.getContextPath() + "/pages/cart/cart.jsp");
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getSession().getAttribute("username");
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart)req.getSession().getAttribute(username + "cart");
        if(count == 0){
            cart.deleteItem(id);
        }else{
            cart.updateCount(id, count);
        }
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
    }

}
