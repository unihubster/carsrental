package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.controller.util.AccountRolesUtil;
import net.demo.carsrental.model.Account;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Account.Role role = (Account.Role) request.getSession().getAttribute(ViewConstants.ROLE);
        return CommandConstants.REDIRECT_COMMAND + AccountRolesUtil.getDefaultPageNameForRole(role);
    }
}
