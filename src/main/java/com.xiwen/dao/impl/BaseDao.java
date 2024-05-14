package com.xiwen.dao.impl;

import com.xiwen.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner qr = new QueryRunner();

    /**
     * update()方法用来执行：Insert\Update\Delete语句
     * @return
     */
    public int update(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return qr.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     * @param <T>   返回的类型的泛型
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return qr.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个个javaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     * @param <T>   返回的类型的泛型
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return qr.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql
     * @param args  sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();

        try {
            return qr.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
