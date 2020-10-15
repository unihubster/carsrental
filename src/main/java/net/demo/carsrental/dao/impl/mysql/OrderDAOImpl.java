package net.demo.carsrental.dao.impl.mysql;

import net.demo.carsrental.dao.ConnectionFactory;
import net.demo.carsrental.dao.OrderDAO;
import net.demo.carsrental.dto.Page;
import net.demo.carsrental.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class OrderDAOImpl implements OrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAOImpl.class);

    private final ConnectionFactory connectionFactory;

    public OrderDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Order create(Order order) {
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<Order> optional = Optional.empty();
        return optional;
    }

    @Override
    public List<Order> findPage(Page page) {
        return null;
    }

    @Override
    public void update(Order order) {
    }

    @Override
    public void delete(Long id) {

    }
}
