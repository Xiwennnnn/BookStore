package com.xiwen.web;

import com.xiwen.pojo.Book;
import com.xiwen.pojo.Page;
import com.xiwen.service.BookService;
import com.xiwen.service.impl.BookServiceImpl;
import com.xiwen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientBookServlet", urlPatterns = "/clientBookServlet")
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("JSESSIONID", req.getRequestedSessionId());
        cookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(cookie);
        int pageNo =  WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize =  WebUtils.parseInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("clientBookServlet?action=getPage");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void getPageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int startPrice = WebUtils.parseInt(req.getParameter("min"), 0);
        int endPrice = WebUtils.parseInt(req.getParameter("max"), 999);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize =  WebUtils.parseInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.getPageByPrice(pageNo, pageSize, startPrice, endPrice);
        page.setUrl("clientBookServlet?action=getPageByPrice&min=" + startPrice + "&max=" + endPrice);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
