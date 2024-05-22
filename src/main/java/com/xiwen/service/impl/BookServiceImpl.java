package com.xiwen.service.impl;

import com.xiwen.dao.BookDao;
import com.xiwen.dao.impl.BookDaoImpl;
import com.xiwen.pojo.Book;
import com.xiwen.pojo.Page;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page();
        int totalCount = bookDao.queryTotalCount();
        page.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        page.setTotalPage(totalPage);
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > totalPage){
            pageNo = totalPage;
        }
        int startNo = (pageNo - 1) * pageSize;
        List<Book> books = bookDao.queryBooksByPage(startNo, pageSize);

        page.setList(books);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return page;
    }

    @Override
    public Page<Book> getPageByPrice(int pageNo, int pageSize, int startPrice, int endPrice) {
        Page<Book> page = new Page();
        int totalCount = bookDao.queryCountByPrice(startPrice, endPrice);
        page.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil((double) totalCount / 4);
        int startNo = (pageNo - 1) * pageSize;
        List<Book> books = bookDao.queryBooksByPrice(startNo, pageSize, startPrice, endPrice);
        page.setList(books);
        page.setTotalPage(totalPage);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return page;
    }


}
