package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.model.Account;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Account.Role role = (Account.Role) request.getSession().getAttribute(ViewConstants.ROLE);
        return CommandConstants.REDIRECT_COMMAND + getDefaultPageNameForRole(role);
    }

    private String getDefaultPageNameForRole(Account.Role role) {
        switch (role) {
            case ADMIN:
                return ViewConstants.DEFAULT_ADMIN_PAGE;
            case MANAGER:
                return ViewConstants.DEFAULT_MANAGER_PAGE;
            case CUSTOMER:
                return ViewConstants.DEFAULT_CUSTOMER_PAGE;
            default:
                return ViewConstants.DEFAULT_PAGE;
        }
    }
}
