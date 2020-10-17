package net.demo.carsrental.controller.command;

// List of action parameters
public class CommandConstants {
    public static final String REDIRECT_COMMAND = "redirect:";

    protected static final String DEFAULT_COMMAND = "default";
    protected static final String REGISTRATION_COMMAND = "register";
    protected static final String SIGN_IN_COMMAND = "sign_in";
    protected static final String SIGN_OUT_COMMAND = "sign_out";

    protected static final String DEFAULT_ADMIN_PAGE_COMMAND = "admin-home";
    protected static final String DEFAULT_MANAGER_PAGE_COMMAND = "manager-home";
    protected static final String DEFAULT_CUSTOMER_PAGE_COMMAND = "customer-home";

    protected static final String RENTAL_CARS_LIST = "cars-list";

    private CommandConstants() {
    }
}
