package com.xiwen.service.impl;

import com.xiwen.dao.BookDao;
import com.xiwen.dao.impl.BookDaoImpl;
import com.xiwen.pojo.Book;
import com.xiwen.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
