package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.http.HttpServletRequest;

public class PageLoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ViewConstants.SIGN_IN_PAGE;
    }
}
