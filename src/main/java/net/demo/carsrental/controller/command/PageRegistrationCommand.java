package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.http.HttpServletRequest;

public class PageRegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ViewConstants.REGISTRATION_PAGE;
    }
}
