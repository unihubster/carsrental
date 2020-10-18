package net.demo.carsrental.controller.servlet;

public class ViewConstants {
    public static final String COMMAND_SERVLET_PATH = "/gateway";
    public static final String ACTION_PARAM = "action";
    public static final String ACTION_PARAM_GET = "?action=";

    public static final String LANGUAGE_PARAM = "lang";
    public static final String DEFAULT_LANG = "uk";

    public static final String ROLE = "role";
    public static final String USER_NAME = "username";
    public static final String LOGGED_USERS = "loggedUsers";

    public static final String ERROR_PAGE = "/error.jsp";
    public static final String DEFAULT_PAGE = "/index.jsp";
    public static final String ADMIN_MAIN_PAGE = "/WEB-INF/jsp/page/admin/users.jsp";
    public static final String MANAGER_MAIN_PAGE = "/WEB-INF/jsp/page/manager/orders.jsp";
    public static final String CARS_LIST_PAGE = "/cars-list.jsp";
    public static final String REGISTRATION_PAGE = "/WEB-INF/jsp/page/guest/registration.jsp";
    public static final String SIGN_IN_PAGE = "/WEB-INF/jsp/page/guest/login.jsp";
    public static final String ACCESS_DENIED_PAGE = "/error403.jsp";

    public static final String REGISTRATION_ERROR_PARAM = "registrationError";
    public static final String REGISTRATION_ERROR_PARAM_USER_EXIST = "userExist";
    // Registration form fields
    public static final String REGISTRATION_USERNAME = "username";
    public static final String REGISTRATION_PASSWORD = "password";
    public static final String REGISTRATION_FIRSTNAME = "first_name";
    public static final String REGISTRATION_LASTNAME = "last_name";
    public static final String REGISTRATION_EMAIL = "email";
    public static final String REGISTRATION_PHONE = "phone";
    // SignIn form fields
    public static final String SIGN_IN_USERNAME = "username";
    public static final String SIGN_IN_PASSWORD = "password";

    private ViewConstants() {
    }
}
