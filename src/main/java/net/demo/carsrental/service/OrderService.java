package net.demo.carsrental.service;

import net.demo.carsrental.dao.OrderDAO;

public class OrderService implements Service {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
