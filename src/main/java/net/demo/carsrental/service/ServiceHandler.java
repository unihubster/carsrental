package net.demo.carsrental.service;

import net.demo.carsrental.dao.DAOFactory;

import java.util.EnumMap;
import java.util.Map;

public class ServiceHandler {
    private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    private static final Map<ModelNames, Service> map = new EnumMap<>(ModelNames.class);

    static {
        init();
    }

    private ServiceHandler() {
    }

    public static Service getAccountService() {
        return map.get(ModelNames.ACCOUNT);
    }

    public static Service getCarService() {
        return map.get(ModelNames.CAR);
    }

    public static Service gerBillService() {
        return map.get(ModelNames.BILL);
    }

    public static Service getOrderService() {
        return map.get(ModelNames.ORDER);
    }

    private static void init() {
        map.put(ModelNames.ACCOUNT, new AccountService(daoFactory.getAccountDAO()));
        map.put(ModelNames.CAR, new CarService(daoFactory.getCarDAO()));
        map.put(ModelNames.BILL, new BillService(daoFactory.getBillDAO()));
        map.put(ModelNames.ORDER, new OrderService(daoFactory.getOrderDAO()));
    }

    private enum ModelNames {
        ACCOUNT, CAR, BILL, ORDER
    }
}
