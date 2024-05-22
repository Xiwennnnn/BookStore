package com.xiwen.dao;

import com.xiwen.pojo.OrderItem;
import java.util.List;

public interface OrderItemDao {

    public Integer saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemById(String orderID);
}
