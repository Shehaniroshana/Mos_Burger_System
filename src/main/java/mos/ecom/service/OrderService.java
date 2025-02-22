package mos.ecom.service;

import mos.ecom.dto.Order;

import java.util.List;

public interface OrderService {
    void addOrder(List<Order> orders);
    void updateOrderStatus(Order order);
    void deleteOrder(Integer id);
    Order searchById(Integer id);
    List<Order> searchByCustomerName(String name);
    List<Order> searchByItemCode(String code);
    List<Object[]> getAll();
    void updateStatusByCustomerId(int customerId, String status);
    void deleteByCustomerIdAndOrderDate(int customerId, String orderDate);

}
