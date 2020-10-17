package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.http.HttpServletRequest;

public class CustomerMainPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return CommandConstants.REDIRECT_COMMAND
                + ViewConstants.CARS_LIST_PAGE;
    }
}
