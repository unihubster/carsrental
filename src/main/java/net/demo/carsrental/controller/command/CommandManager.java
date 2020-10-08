package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandManager {
    private static final Logger LOGGER = LogManager.getLogger(CommandManager.class);

    private static final CommandManager instance = new CommandManager();
    private final Map<String, Command> commandsMap = new HashMap<>();

    private final Set<String> guestCommandsNamesSet = new HashSet<>();
    private final Set<String> customerCommandsNamesSet = new HashSet<>();
    private final Set<String> managerCommandsNamesSet = new HashSet<>();
    private final Set<String> adminCommandsNamesSet = new HashSet<>();

    private CommandManager() {
        init();
    }

    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(HttpServletRequest request) {
        String commandName = request.getParameter(ViewConstants.ACTION_PARAM);
        LOGGER.debug("Request command name = {}", commandName);
        return commandsMap.getOrDefault(commandName, getDefaultCommand());
    }

    private Command getDefaultCommand() {
        return commandsMap.get(CommandConstants.DEFAULT_COMMAND);
    }

    private void init() {
        DefaultCommand defaultCommand = new DefaultCommand();
        registerCommand(Account.Role.GUEST, CommandConstants.DEFAULT_COMMAND, defaultCommand);
        registerCommand(Account.Role.CUSTOMER, CommandConstants.DEFAULT_COMMAND, defaultCommand);
        registerCommand(Account.Role.MANAGER, CommandConstants.DEFAULT_COMMAND, defaultCommand);
        registerCommand(Account.Role.ADMIN, CommandConstants.DEFAULT_COMMAND, defaultCommand);

        registerCommand(Account.Role.GUEST, CommandConstants.SIGN_IN_COMMAND, new SignInCommand());
        registerCommand(Account.Role.GUEST, CommandConstants.REGISTRATION_COMMAND, new RegistrationCommand());

        SignOutCommand signOutCommand = new SignOutCommand();
        registerCommand(Account.Role.CUSTOMER, CommandConstants.SIGN_OUT_COMMAND, signOutCommand);
        registerCommand(Account.Role.MANAGER, CommandConstants.SIGN_OUT_COMMAND, signOutCommand);
        registerCommand(Account.Role.ADMIN, CommandConstants.SIGN_OUT_COMMAND, signOutCommand);
    }

    private void registerCommand(Account.Role role, String commandName, Command command) {
        getCommandNameSet(role).add(commandName);
        commandsMap.put(commandName, command);
    }

    public Set<String> getCommandNameSet(Account.Role role) {
        switch (role) {
            case CUSTOMER:
                return customerCommandsNamesSet;
            case MANAGER:
                return managerCommandsNamesSet;
            case ADMIN:
                return adminCommandsNamesSet;
            default:
                return guestCommandsNamesSet;
        }
    }
}
