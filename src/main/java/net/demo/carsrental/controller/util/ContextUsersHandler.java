package net.demo.carsrental.controller.util;

import net.demo.carsrental.controller.servlet.ViewConstants;

import javax.servlet.ServletContext;
import java.util.concurrent.ConcurrentHashMap;

public class ContextUsersHandler {
    // Dummy value to associate with an Object in the backing Map like in HashSet
    private static final Object OBJECT = new Object();

    private ContextUsersHandler() {
    }

    public static void initLoggedUsers(ServletContext context) {
        context.setAttribute(ViewConstants.LOGGED_USERS, new ConcurrentHashMap<String, Object>());
    }

    public static void putToLoggedUsers(ServletContext context, String userName) {
        if (userName != null && !userName.isEmpty()) {
            ConcurrentHashMap<String, Object> loggedUsers = (ConcurrentHashMap<String, Object>) context.getAttribute(ViewConstants.LOGGED_USERS);
            loggedUsers.put(userName, OBJECT);
        }
    }

    public static boolean isUserLogged(ServletContext context, String userName) {
        if (userName != null && !userName.isEmpty()) {
            ConcurrentHashMap<String, Object> loggedUsers = (ConcurrentHashMap<String, Object>) context.getAttribute(ViewConstants.LOGGED_USERS);
            return loggedUsers.containsKey(userName);
        }
        return false;
    }

    public static void removeFromLoggedUsers(ServletContext context, String userName) {
        if (userName != null && !userName.isEmpty()) {
            ConcurrentHashMap<String, Object> loggedUsers = (ConcurrentHashMap<String, Object>) context.getAttribute(ViewConstants.LOGGED_USERS);
            loggedUsers.remove(userName);
        }
    }
}
