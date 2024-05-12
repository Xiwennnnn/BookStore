package com.xiwen.test;

import com.xiwen.dao.BookDao;
import com.xiwen.dao.impl.BookDaoImpl;
import com.xiwen.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "Test", "Test", new BigDecimal("33.33"), 3, 3, null);
        System.out.println(bookDao.addBook(book));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookDao.deleteBook(32));

    }

    @Test
    public void updateBook() {
        Book book = bookDao.queryBookById(33);
        book.setName("XiWen");
        System.out.println(bookDao.updateBook(book));
        System.out.println(bookDao.queryBookById(33));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }
}