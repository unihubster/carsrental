package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.model.Account;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Account.Role role = (Account.Role) request.getSession().getAttribute(ViewConstants.ROLE);
        return getDefaultPageNameForRole(role);
    }

    private String getDefaultPageNameForRole(Account.Role role) {
        switch (role) {
            case ADMIN:
                return ViewConstants.COMMAND_SERVLET_PATH
                        + ViewConstants.ACTION_PARAM_GET
                        + CommandConstants.DEFAULT_ADMIN_PAGE_COMMAND;
            case MANAGER:
                return ViewConstants.COMMAND_SERVLET_PATH
                        + ViewConstants.ACTION_PARAM_GET
                        + CommandConstants.DEFAULT_MANAGER_PAGE_COMMAND;
            case CUSTOMER:
                return ViewConstants.COMMAND_SERVLET_PATH
                        + ViewConstants.ACTION_PARAM_GET
                        + CommandConstants.DEFAULT_CUSTOMER_PAGE_COMMAND;
            default:
                return CommandConstants.REDIRECT_COMMAND + ViewConstants.DEFAULT_PAGE;
        }
    }
}
