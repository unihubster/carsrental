package net.demo.carsrental.dao;

import net.demo.carsrental.dao.impl.mysql.MySQLDAOFactory;

public abstract class DAOFactory {
    protected final ConnectionFactory connectionFactory = new ConnectionFactory();

    /**
     * Returns concrete DAOFactory
     *
     * @return Only MySQLDAOFactory will be return for this moment but this logic can be extended
     */
    public static DAOFactory getDAOFactory() {
        return new MySQLDAOFactory();
    }

    public abstract AccountDAO getAccountDAO();

    public abstract BillDAO getBillDAO();

    public abstract CarDAO getCarDAO();

    public abstract OrderDAO getOrderDAO();
}
