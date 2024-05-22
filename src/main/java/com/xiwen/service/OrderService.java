package com.xiwen.service;

import com.xiwen.dao.OrderDao;
import com.xiwen.dao.OrderItemDao;
import com.xiwen.dao.impl.OrderDaoImpl;
import com.xiwen.dao.impl.OrderItemDaoImpl;
import com.xiwen.pojo.Cart;
import com.xiwen.pojo.Order;
import com.xiwen.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

    public List<Order> showAllOrder();

    public void sendOrder(String orderID);

    public List<OrderItem> showOrderDetail(String orderID);
}
