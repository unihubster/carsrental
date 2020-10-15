package net.demo.carsrental.dao.exception;

import net.demo.carsrental.model.Account;

public class AccountNotFoundException extends Exception {
    private final Account account;

    public AccountNotFoundException(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
