package com.xiwen.dao.impl;

import com.xiwen.dao.BookDao;
import com.xiwen.pojo.Book;
import com.xiwen.pojo.Page;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`, `author`, `price`," +
                " `sales`, `stock`, `img_path`) values(?,?,?,?,?,?) ";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";

        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `id`=?, `name`=?, `author`=?, `price`=?," +
                " `sales`=?, `stock`=?, `img_path`=? where id = ?";

        return update(sql, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` imgPath from t_book where id = ?";

        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`, `name`, `author`, `price`, `sales`," +
                " `stock`, `img_path` imgPath from t_book";

        return queryForList(Book.class, sql);
    }

    @Override
    public List<Book> queryBooksByPage(Integer startNo, Integer pageSize) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` imgPath from t_book limit ?, ?";
        return queryForList(Book.class, sql, startNo, pageSize);
    }

    @Override
    public Integer queryTotalCount(){
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryBooksByPrice(Integer startNo, Integer pageSize, Integer beginPrice, Integer endPrice) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` imgPath from t_book where `price` >= ? and `price` <= ? order by `price` limit ?, ?";
        return queryForList(Book.class, sql, beginPrice, endPrice, startNo, pageSize);
    }

    @Override
    public Integer queryCountByPrice(Integer beginPrice, Integer endPrice) {
        String sql = "select count(*) from t_book where `price` >= ? and `price` <= ?";
        Number count = (Number) queryForSingleValue(sql, beginPrice, endPrice);
        return count.intValue();
    }



}
