package com.xiwen.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Integer totalCount;
    private BigDecimal totalPrice;
    private Map<Integer, CartItem> cartItems = new LinkedHashMap<Integer, CartItem>();
    private String lastname;

    public void addItem(CartItem item) {
        CartItem cartItem = cartItems.get(item.getId());
        if (cartItem == null) {
            cartItems.put(item.getId(), item);
            lastname = item.getName();
        }else{
            cartItem.setCount(cartItem.getCount() + item.getCount());
            cartItem.setTotalprice(cartItem.getTotalprice().add(item.getTotalprice()));
            lastname = cartItem.getName();
        }
    }

    public void deleteItem(Integer id) {
        cartItems.remove(id);
    }

    public void clear(){
        cartItems.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = cartItems.get(id);
        cartItem.setCount(count);
        cartItem.setTotalprice(cartItem.getPrice().multiply(new BigDecimal(count)));
    }

    public Integer getTotalCount() {
        totalCount = 0;
        for(Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getPrice().multiply(new BigDecimal(entry.getValue().getCount())));
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", cartItems=" + cartItems +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
