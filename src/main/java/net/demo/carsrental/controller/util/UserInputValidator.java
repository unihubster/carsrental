package net.demo.carsrental.controller.util;

import net.demo.carsrental.dto.AccountRegistrationDTO;
import net.demo.carsrental.dto.AccountSignInDTO;

public class UserInputValidator {
    private static final String PROPERTY_REGEXP_KEY_USERNAME = "username";
    private static final String PROPERTY_REGEXP_KEY_PASSWORD = "password";
    private static final String PROPERTY_REGEXP_KEY_EMAIL = "email";
    private static final String PROPERTY_REGEXP_KEY_PHONE = "phone";

    private UserInputValidator() {
    }

    public static boolean validateRegistrationInput(AccountRegistrationDTO accountRegistrationDTO) {
        if (!isUsernameValid(accountRegistrationDTO.getUsername())) {
            return false;
        }
        if (!isPasswordValid(accountRegistrationDTO.getPassword())) {
            return false;
        }
        if (!isFirstNameValid(accountRegistrationDTO.getFirstName())) {
            return false;
        }
        if (!isLastNameValid(accountRegistrationDTO.getLastName())) {
            return false;
        }
        if (!isEmailValid(accountRegistrationDTO.getEmail())) {
            return false;
        }
        return isPhoneValid(accountRegistrationDTO.getPhone());
    }

    public static boolean validateSignInInput(AccountSignInDTO accountSignInDTO) {
        if (!isUsernameValid(accountSignInDTO.getUsername())) {
            return false;
        }
        return isPasswordValid(accountSignInDTO.getUsername());
    }

    private static boolean isUsernameValid(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return isTextValid(username, PROPERTY_REGEXP_KEY_USERNAME);
    }

    private static boolean isPasswordValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return isTextValid(password, PROPERTY_REGEXP_KEY_PASSWORD);
    }

    private static boolean isFirstNameValid(String firstName) {
        return firstName != null && !firstName.isEmpty();
    }

    private static boolean isLastNameValid(String lastName) {
        return lastName != null && !lastName.isEmpty();
    }

    private static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return isTextValid(email, PROPERTY_REGEXP_KEY_EMAIL);
    }

    private static boolean isPhoneValid(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return isTextValid(phone, PROPERTY_REGEXP_KEY_PHONE);
    }

    private static boolean isTextValid(String text, String regexPropertyKey) {
        if (text.isEmpty()) {
            return false;
        }
        return text.matches(RegExpHandler.getPropertyValue(regexPropertyKey));
    }
}
