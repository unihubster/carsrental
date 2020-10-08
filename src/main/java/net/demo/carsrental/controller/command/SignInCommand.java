package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return CommandConstants.REDIRECT_COMMAND + ViewConstants.COMMAND_SERVLET_PATH
                + ViewConstants.ACTION_PARAM_GET + CommandConstants.DEFAULT_COMMAND;
    }
}
