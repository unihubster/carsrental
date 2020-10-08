package net.demo.carsrental.controller.servlet;

public class ViewConstants {
    public static final String COMMAND_SERVLET_PATH = "/command";
    public static final String ACTION_PARAM = "action";
    public static final String ACTION_PARAM_GET = "?action=";

    public static final String LANGUAGE_PARAM = "lang";
    public static final String DEFAULT_LANG = "uk";

    public static final String ROLE = "role";
    public static final String USER_NAME = "username";
    public static final String LOGGED_USERS = "loggedUsers";

    public static final String ERROR_PAGE = "error.jsp";
    public static final String DEFAULT_PAGE = "/index.jsp";
    public static final String DEFAULT_ADMIN_PAGE = "/WEB-INF/jsp/page/admin/admin-home.jsp";
    public static final String DEFAULT_MANAGER_PAGE = "/WEB-INF/jsp/page/manager/manager-home.jsp";
    public static final String DEFAULT_CUSTOMER_PAGE = "/WEB-INF/jsp/page/customer/cars-list.jsp";
    public static final String REGISTRATION_PAGE = "/registration.jsp";
    public static final String SIGN_IN_PAGE = "/login.jsp";
    public static final String ACCESS_DENIED_PAGE = "/access-error.jsp";

    private ViewConstants() {
    }
}
