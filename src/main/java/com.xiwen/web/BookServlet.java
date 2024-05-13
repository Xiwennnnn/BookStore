package com.xiwen.web;

import com.xiwen.pojo.Book;
import com.xiwen.service.BookService;
import com.xiwen.service.impl.BookServiceImpl;
import com.xiwen.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/manager/bookServlet")
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("book_name = " + req.getParameter("name"));
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        System.out.println(book);
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 10);
        bookService.deleteBook(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 10);
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        System.out.println(book);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 10);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.setAttribute("action", "update");
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
