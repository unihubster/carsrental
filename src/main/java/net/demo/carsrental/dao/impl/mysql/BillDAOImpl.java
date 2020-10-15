package net.demo.carsrental.dao.impl.mysql;

import net.demo.carsrental.dao.BillDAO;
import net.demo.carsrental.dao.ConnectionFactory;
import net.demo.carsrental.dto.Page;
import net.demo.carsrental.model.Bill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class BillDAOImpl implements BillDAO {
    private static final Logger LOGGER = LogManager.getLogger(BillDAOImpl.class);

    private final ConnectionFactory connectionFactory;

    public BillDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Bill create(Bill bill) {
        return bill;
    }

    @Override
    public Optional<Bill> findById(Long id) {
        Optional<Bill> optional = Optional.empty();
        return optional;
    }

    @Override
    public List<Bill> findPage(Page page) {
        return null;
    }

    @Override
    public Bill update(Bill bill) {
        return bill;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
