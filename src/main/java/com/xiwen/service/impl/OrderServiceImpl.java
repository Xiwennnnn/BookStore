package com.xiwen.service.impl;

import com.xiwen.dao.OrderDao;
import com.xiwen.dao.OrderItemDao;
import com.xiwen.dao.impl.OrderDaoImpl;
import com.xiwen.dao.impl.OrderItemDaoImpl;
import com.xiwen.pojo.Cart;
import com.xiwen.pojo.CartItem;
import com.xiwen.pojo.Order;
import com.xiwen.pojo.OrderItem;
import com.xiwen.service.OrderService;
import com.xiwen.utils.SnowFlakeUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderID = String.valueOf(SnowFlakeUtil.getID());
        Order order = new Order(orderID, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem>entry : cart.getCartItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalprice(), orderID);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderID;
    }

    @Override
    public List<Order> showAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public void sendOrder(String orderID) {
        orderDao.changeOrderStatus(orderID, 1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderID) {
        return orderItemDao.queryOrderItemById(orderID);
    }
}
