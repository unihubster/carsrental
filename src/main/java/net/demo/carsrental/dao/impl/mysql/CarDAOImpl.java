package net.demo.carsrental.dao.impl.mysql;

import net.demo.carsrental.dao.CarDAO;
import net.demo.carsrental.dao.ConnectionFactory;
import net.demo.carsrental.dto.Page;
import net.demo.carsrental.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class CarDAOImpl implements CarDAO {
    private static final Logger LOGGER = LogManager.getLogger(CarDAOImpl.class);

    private final ConnectionFactory connectionFactory;

    public CarDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Car create(Car car) {
        return car;
    }

    @Override
    public Optional<Car> findById(Long id) {
        Optional<Car> optional = Optional.empty();
        return optional;
    }

    @Override
    public List<Car> findPage(Page page) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return car;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
