package com.xiwen.dao;

import com.xiwen.pojo.Order;

import java.util.List;

public interface OrderDao {

    public Integer saveOrder(Order order);

    public List<Order> findAllOrder();

    public Integer changeOrderStatus(String orderID,Integer status);

    public Order findOrderById(String orderID);
}
