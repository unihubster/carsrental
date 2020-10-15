package net.demo.carsrental.service;

import net.demo.carsrental.dao.BillDAO;

public class BillService implements Service {
    private final BillDAO billDAO;

    public BillService(BillDAO billDAO) {
        this.billDAO = billDAO;
    }
}
