package net.demo.carsrental.dao.mapper;

import net.demo.carsrental.dao.table.AccountTable;
import net.demo.carsrental.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class AccountMapper {

    private AccountMapper() {
    }

    public static Account mapResultSetToAccount(ResultSet resultSet) throws SQLException {
        Account account = Account.builder()
                                 .setUsername(resultSet.getString(AccountTable.USERNAME))
                                 .setPassword(resultSet.getString(AccountTable.PASSWORD))
                                 .setFirstName(resultSet.getString(AccountTable.FIRST_NAME))
                                 .setLastName(resultSet.getString(AccountTable.LAST_NAME))
                                 .setEmail(resultSet.getString(AccountTable.EMAIL))
                                 .setPhone(resultSet.getString(AccountTable.PHONE))
                                 .setRole(Account.Role.getRoleById(resultSet.getInt(AccountTable.ACCOUNT_ROLE_ID)))
                                 .setStatus(Account.Status.valueOf(resultSet.getString(AccountTable.ACCOUNT_STATUS)))
                                 .build();
        account.setId(resultSet.getLong(AccountTable.ACCOUNT_ID));
        account.setCreateDate(resultSet.getTimestamp(AccountTable.CREATE_DATE)
                                       .toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
        account.setLastUpdate(resultSet.getTimestamp(AccountTable.LAST_UPDATE_DATE)
                                       .toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
        return account;
    }

    public static PreparedStatement mapAccountToPreparedStatement(PreparedStatement statement, Account account) throws SQLException {
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getPassword());
        statement.setString(3, account.getFirstName());
        statement.setString(4, account.getLastName());
        statement.setString(5, account.getEmail());
        statement.setString(6, account.getPhone());
        statement.setInt(7, account.getRole().roleId);
        statement.setString(8, account.getStatus().name());
        return statement;
    }
}
