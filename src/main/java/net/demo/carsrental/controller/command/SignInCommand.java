package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.controller.util.ContextUsersHandler;
import net.demo.carsrental.controller.util.UserInputValidator;
import net.demo.carsrental.dao.exception.AccountNotFoundException;
import net.demo.carsrental.dto.AccountSignInDTO;
import net.demo.carsrental.model.Account;
import net.demo.carsrental.service.AccountService;
import net.demo.carsrental.service.ServiceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class);
    private final AccountService service = (AccountService) ServiceHandler.getAccountService();

    @Override
    public String execute(HttpServletRequest request) {
        AccountSignInDTO accountSignInDTO = getAccountDataFromRequest(request);
        HttpSession session = request.getSession();

        if (!UserInputValidator.validateSignInInput(accountSignInDTO)) {
            LOGGER.info("User sign in form input is wrong {}", accountSignInDTO);
            session.setAttribute(ViewConstants.REGISTRATION_ERROR_PARAM, true);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.SIGN_IN_PAGE;
        }

        if (ContextUsersHandler.isUserLogged(session.getServletContext(), accountSignInDTO.getUsername())) {
            LOGGER.info("The user is already signed in. {}", accountSignInDTO);
            session.setAttribute(ViewConstants.REGISTRATION_ERROR_PARAM, true);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.SIGN_IN_PAGE;
        }

        try {
            Account accountKnown = service.getAccountIfKnown(accountSignInDTO);
            ContextUsersHandler.putToLoggedUsers(session.getServletContext(), accountSignInDTO.getUsername());
            session.setAttribute(ViewConstants.ROLE, accountKnown.getRole());
            session.setAttribute(ViewConstants.USER_NAME, accountSignInDTO.getUsername());
        } catch (AccountNotFoundException e) {
            LOGGER.info("User sign in form input is wrong {}", accountSignInDTO);
            session.setAttribute(ViewConstants.REGISTRATION_ERROR_PARAM, true);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.SIGN_IN_PAGE;
        }

        return ViewConstants.COMMAND_SERVLET_PATH
                + ViewConstants.ACTION_PARAM_GET
                + CommandConstants.DEFAULT_COMMAND;
    }

    private AccountSignInDTO getAccountDataFromRequest(HttpServletRequest request) {
        return AccountSignInDTO.builder()
                               .setUsername(request.getParameter(ViewConstants.REGISTRATION_USERNAME))
                               .setPassword(request.getParameter(ViewConstants.REGISTRATION_PASSWORD))
                               .build();
    }
}
