package net.demo.carsrental.service;

import net.demo.carsrental.dao.CarDAO;

public class CarService implements Service {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }
}
