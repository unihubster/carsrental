package net.demo.carsrental.controller.command;

import javax.servlet.http.HttpServletRequest;

public class SignOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return CommandConstants.DEFAULT_COMMAND;
    }
}
