package net.demo.carsrental.dao;

import net.demo.carsrental.model.Account;

public interface AccountDAO extends GenericDAO<Account> {
    String getPassword(String username);
}
