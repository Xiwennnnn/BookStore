package com.xiwen.dao.impl;

import com.xiwen.dao.OrderItemDao;
import com.xiwen.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public Integer saveOrderItem(OrderItem orderItem) {
        String sql = "insert t_order_item(`id`, `name`, `count`, `price`, `total_price`, `order_id`) values(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemById(String orderID) {
        String sql = "select `id`, `name`, `count`, `price`, `total_price`, `order_id` from t_order_item where `order_id` = ?";
        return queryForList(OrderItem.class, sql, orderID);
    }
}
