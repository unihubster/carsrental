package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RentalCarsListCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RentalCarsListCommand.class);
    private final CarService service;

    public RentalCarsListCommand(CarService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return ViewConstants.CARS_LIST_PAGE;
    }
}
