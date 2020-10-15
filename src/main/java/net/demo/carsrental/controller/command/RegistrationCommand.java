package net.demo.carsrental.controller.command;

import net.demo.carsrental.controller.servlet.ViewConstants;
import net.demo.carsrental.controller.util.UserInputValidator;
import net.demo.carsrental.dao.exception.NotUniqueException;
import net.demo.carsrental.dto.AccountRegistrationDTO;
import net.demo.carsrental.service.AccountService;
import net.demo.carsrental.service.ServiceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private final AccountService service = (AccountService) ServiceHandler.getAccountService();

    @Override
    public String execute(HttpServletRequest request) {
        AccountRegistrationDTO accountRegistrationDTO = getAccountDataFromRequest(request);
        HttpSession session = request.getSession();
        session.removeAttribute(ViewConstants.REGISTRATION_ERROR_PARAM);
        session.removeAttribute(ViewConstants.REGISTRATION_ERROR_PARAM_USER_EXIST);

        if (!UserInputValidator.validateRegistrationInput(accountRegistrationDTO)) {
            LOGGER.info("User registration form input is wrong. {}", accountRegistrationDTO);
            session.setAttribute(ViewConstants.REGISTRATION_ERROR_PARAM, true);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.REGISTRATION_PAGE;
        }

        try {
            service.registerNewAccount(accountRegistrationDTO);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.SIGN_IN_PAGE;
        } catch (NotUniqueException e) {
            LOGGER.info("Not unique registration input {}", accountRegistrationDTO);
            session.setAttribute(ViewConstants.REGISTRATION_ERROR_PARAM_USER_EXIST, true);
            return CommandConstants.REDIRECT_COMMAND + ViewConstants.REGISTRATION_PAGE;
        }
    }

    private AccountRegistrationDTO getAccountDataFromRequest(HttpServletRequest request) {
        return AccountRegistrationDTO.builder()
                                     .setUsername(request.getParameter(ViewConstants.REGISTRATION_USERNAME))
                                     .setPassword(request.getParameter(ViewConstants.REGISTRATION_PASSWORD))
                                     .setFirstName(request.getParameter(ViewConstants.REGISTRATION_FIRSTNAME))
                                     .setLastName(request.getParameter(ViewConstants.REGISTRATION_LASTNAME))
                                     .setEmail(request.getParameter(ViewConstants.REGISTRATION_EMAIL))
                                     .setPhone(request.getParameter(ViewConstants.REGISTRATION_PHONE))
                                     .build();
    }
}
