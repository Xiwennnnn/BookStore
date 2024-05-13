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

    /**
     * 根据id删除图书
     * @param id
     * @return 返回影响的行数
     */
    public int deleteBook(Integer id);

    /**
     * 根据book的id更新book
     * @param book
     * @return 返回影响的行数
     */
    public int updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     * @return 返回一个Book
     */
    public Book queryBookById(Integer id);

    /**
     * 查询 所有图书
     * @return 返回一个List
     */
    public List<Book> queryBooks();
}
