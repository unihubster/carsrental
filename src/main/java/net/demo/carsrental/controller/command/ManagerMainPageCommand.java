package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.http.HttpServletRequest;

public class ManagerMainPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ViewConstants.MANAGER_MAIN_PAGE;
    }
}
