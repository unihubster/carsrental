package net.demo.carsrental.controller.servlet.listner;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.controller.util.ContextUsersHandler;
import net.demo.carsrental.model.Account;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(ViewConstants.ROLE, Account.Role.GUEST);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String userName = (String) session.getAttribute(ViewConstants.USER_NAME);
        ContextUsersHandler.removeFromLoggedUsers(session.getServletContext(), userName);
    }
}
