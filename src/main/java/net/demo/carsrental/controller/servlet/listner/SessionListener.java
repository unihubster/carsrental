package net.demo.carsrental.controller.servlet.listner;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.model.Account;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(ViewConstants.ROLE, Account.Role.GUEST);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent.getSession()
                                                                        .getServletContext()
                                                                        .getAttribute("loggedUsers");
        String userName = (String) httpSessionEvent.getSession()
                                                   .getAttribute(ViewConstants.USER_NAME);
        loggedUsers.remove(userName);
        httpSessionEvent.getSession().setAttribute(ViewConstants.LOGGED_USERS, loggedUsers);
    }
}
