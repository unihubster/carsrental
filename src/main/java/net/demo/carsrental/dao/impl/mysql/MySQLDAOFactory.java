package net.demo.carsrental.dao.impl.mysql;

import net.demo.carsrental.dao.*;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public AccountDAO getAccountDAO() {
        return new AccountDAOImpl(connectionFactory);
    }

    @Override
    public BillDAO getBillDAO() {
        return new BillDAOImpl(connectionFactory);
    }

    @Override
    public CarDAO getCarDAO() {
        return new CarDAOImpl(connectionFactory);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOImpl(connectionFactory);
    }
}
