package com.xiwen.dao;

import com.xiwen.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 增加图书
     * @param book
     * @return 返回sql影响的语句数量，-1则添加失败
     */
    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
