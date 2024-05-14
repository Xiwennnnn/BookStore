package com.xiwen.test;

import com.xiwen.pojo.Book;
import com.xiwen.service.BookService;
import com.xiwen.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "Test", "Test", new BigDecimal("11.25"), 33, 33, null));

    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(40);
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(30));
    }

    @Test
    public void queryBooks() {
    }
}