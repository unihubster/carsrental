package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.controller.util.ContextUsersHandler;
import net.demo.carsrental.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute(ViewConstants.USER_NAME);

        ContextUsersHandler.removeFromLoggedUsers(session.getServletContext(), userName);
        session.removeAttribute(ViewConstants.USER_NAME);
        session.setAttribute(ViewConstants.ROLE, Account.Role.GUEST);

        return CommandConstants.REDIRECT_COMMAND
                + ViewConstants.COMMAND_SERVLET_PATH
                + ViewConstants.ACTION_PARAM_GET
                + CommandConstants.DEFAULT_COMMAND;
    }
}
