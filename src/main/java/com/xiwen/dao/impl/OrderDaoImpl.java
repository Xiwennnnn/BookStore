package com.xiwen.dao.impl;

import com.xiwen.dao.OrderDao;
import com.xiwen.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public Integer saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) values(?, ?, ?, ?, ?)";
        return update(sql, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> findAllOrder() {
        String sql = "select `order_id`, `create_time`, `price`, `status`, `user_id` from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public Integer changeOrderStatus(String orderID, Integer status) {
        String sql = "update t_order set `status` = ? where `order_id` = ?";
        return update(sql, status, orderID);
    }

    @Override
    public Order findOrderById(String orderID) {
        String sql = "select `order_id`, `create_time`, `price`, `status`, `user_id` from t_order where `order_id` = ?";
        return queryForOne(Order.class, sql, orderID);
    }
}
