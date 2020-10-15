package net.demo.carsrental.dao.exception;

import net.demo.carsrental.dto.AccountSignInDTO;

public class AccountNotFoundException extends RuntimeException {
    private final AccountSignInDTO account;

    public AccountNotFoundException(AccountSignInDTO account) {
        this.account = account;
    }

    public AccountSignInDTO getAccount() {
        return account;
    }
}
