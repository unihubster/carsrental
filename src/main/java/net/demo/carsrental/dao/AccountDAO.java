package net.demo.carsrental.dao;

import net.demo.carsrental.model.Account;

import java.util.Optional;

public interface AccountDAO extends GenericDAO<Account> {
    Optional<Account> getAccountByUsername(String username);
}
