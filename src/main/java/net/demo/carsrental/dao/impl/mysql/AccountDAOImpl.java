package net.demo.carsrental.dao.impl.mysql;

import net.demo.carsrental.dao.AccountDAO;
import net.demo.carsrental.dao.ConnectionFactory;
import net.demo.carsrental.dao.exception.DAOException;
import net.demo.carsrental.dao.exception.NotUniqueException;
import net.demo.carsrental.dao.table.AccountTable;
import net.demo.carsrental.dao.table.Tables;
import net.demo.carsrental.dto.Page;
import net.demo.carsrental.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.demo.carsrental.dao.mapper.AccountMapper.mapAccountToPreparedStatement;
import static net.demo.carsrental.dao.mapper.AccountMapper.mapResultSetToAccount;

public class AccountDAOImpl implements AccountDAO {
    private static final Logger LOGGER = LogManager.getLogger(AccountDAOImpl.class);

    private static final String INSERT = "INSERT INTO " + Tables.ACCOUNT_TABLE_NAME + "("
            + AccountTable.USERNAME + ", "
            + AccountTable.PASSWORD + ", "
            + AccountTable.FIRST_NAME + ", "
            + AccountTable.LAST_NAME + ", "
            + AccountTable.EMAIL + ", "
            + AccountTable.PHONE + ", "
            + AccountTable.ACCOUNT_ROLE_ID + ", "
            + AccountTable.ACCOUNT_STATUS + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE_BY_ID = "SELECT "
            + AccountTable.ACCOUNT_ID + ", "
            + AccountTable.USERNAME + ", "
            + AccountTable.PASSWORD + ", "
            + AccountTable.FIRST_NAME + ", "
            + AccountTable.LAST_NAME + ", "
            + AccountTable.EMAIL + ", "
            + AccountTable.PHONE + ", "
            + AccountTable.ACCOUNT_ROLE_ID + ", "
            + AccountTable.ACCOUNT_STATUS + ", "
            + AccountTable.CREATE_DATE + ", "
            + AccountTable.LAST_UPDATE_DATE
            + " FROM " + Tables.ACCOUNT_TABLE_NAME + " WHERE " + AccountTable.ACCOUNT_ID + "=?";

    private static final String GET_ONE_BY_USERNAME = "SELECT "
            + AccountTable.ACCOUNT_ID + ", "
            + AccountTable.USERNAME + ", "
            + AccountTable.PASSWORD + ", "
            + AccountTable.FIRST_NAME + ", "
            + AccountTable.LAST_NAME + ", "
            + AccountTable.EMAIL + ", "
            + AccountTable.PHONE + ", "
            + AccountTable.ACCOUNT_ROLE_ID + ", "
            + AccountTable.ACCOUNT_STATUS + ", "
            + AccountTable.CREATE_DATE + ", "
            + AccountTable.LAST_UPDATE_DATE
            + " FROM " + Tables.ACCOUNT_TABLE_NAME + " WHERE " + AccountTable.USERNAME + "=?";

    private static final String GET_PAGE = "SELECT ("
            + AccountTable.ACCOUNT_ID + ", "
            + AccountTable.USERNAME + ", "
            + AccountTable.FIRST_NAME + ", "
            + AccountTable.LAST_NAME + ", "
            + AccountTable.EMAIL + ", "
            + AccountTable.PHONE + ", "
            + AccountTable.ACCOUNT_ROLE_ID + ", "
            + AccountTable.ACCOUNT_STATUS + ", "
            + AccountTable.CREATE_DATE + ", "
            + AccountTable.LAST_UPDATE_DATE
            + ") FROM " + Tables.ACCOUNT_TABLE_NAME + " WHERE id > ? ORDER BY id  ASC LIMIT ?";

    private static final String UPDATE_BY_ID = "UPDATE " + Tables.ACCOUNT_TABLE_NAME + " SET "
            + AccountTable.USERNAME + "=?, "
            + AccountTable.PASSWORD + "=?, "
            + AccountTable.FIRST_NAME + "=?, "
            + AccountTable.LAST_NAME + "=?, "
            + AccountTable.EMAIL + "=?, "
            + AccountTable.PHONE + "=?, "
            + AccountTable.ACCOUNT_ROLE_ID + "=?, "
            + AccountTable.ACCOUNT_STATUS + "=? "
            + " WHERE " + AccountTable.ACCOUNT_ID + "=?";

    private static final String UPDATE_BY_USERNAME = "UPDATE " + Tables.ACCOUNT_TABLE_NAME + " SET "
            + AccountTable.USERNAME + "=?, "
            + AccountTable.PASSWORD + "=?, "
            + AccountTable.FIRST_NAME + "=?, "
            + AccountTable.LAST_NAME + "=?, "
            + AccountTable.EMAIL + "=?, "
            + AccountTable.PHONE + "=?, "
            + AccountTable.ACCOUNT_ROLE_ID + "=?, "
            + AccountTable.ACCOUNT_STATUS + "=? "
            + " WHERE " + AccountTable.USERNAME + "=?";

    private static final String DELETE = "DELETE FROM " + Tables.ACCOUNT_TABLE_NAME + " WHERE " + AccountTable.ACCOUNT_ID + "=?";

    private final ConnectionFactory connectionFactory;

    public AccountDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Account create(Account account) throws NotUniqueException {
        try (Connection connection = connectionFactory.getConnection()) {
            account = create(account, connection);
        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.info("Account {} is not unique", account, e);
            List<String> list = new ArrayList<>(2);
            list.add(account.getUsername());
            list.add(account.getEmail());
            throw new NotUniqueException(list);
        } catch (SQLException e) {
            LOGGER.error("Account {} wasn't created", account, e);
            throw new DAOException(e);
        }
        return account;
    }

    private Account create(Account account, Connection connection) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            mapAccountToPreparedStatement(statement, account);
            statement.executeUpdate();
            connection.commit();
            account = findById(account.getId()).orElseThrow(SQLException::new);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        Optional<Account> optional = Optional.empty();
        try (PreparedStatement statement = connectionFactory.getConnection().prepareStatement(GET_ONE_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    optional = Optional.of(mapResultSetToAccount(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Account with id {} wasn't obtained", id, e);
            throw new DAOException(e);
        }
        return optional;
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        Optional<Account> optional = Optional.empty();
        try (PreparedStatement statement = connectionFactory.getConnection().prepareStatement(GET_ONE_BY_USERNAME)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    optional = Optional.of(mapResultSetToAccount(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Account with username {} wasn't obtained", username, e);
            throw new DAOException(e);
        }
        return optional;
    }

    @Override
    public List<Account> findPage(Page page) {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement statement = connectionFactory.getConnection().prepareStatement(GET_PAGE)) {
            statement.setLong(1, page.getCursor());
            statement.setInt(2, page.getPageSize());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    accounts.add(mapResultSetToAccount(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("{} wasn't gotten", page);
            throw new DAOException(e);
        }
        return accounts;
    }

    @Override
    public Account update(Account account) {
        Long accountId = account.getId();
        String accountUsername = account.getUsername();
        if (accountId != null && accountId > 0) {
            try (Connection connection = connectionFactory.getConnection()) {
                account = updateById(account, connection);
            } catch (SQLException e) {
                LOGGER.warn("{} wasn't updated", account);
                throw new DAOException(e);
            }
        } else if (accountUsername != null && !accountUsername.isEmpty()) {
            try (Connection connection = connectionFactory.getConnection()) {
                account = updateByUsername(account, connection);
            } catch (SQLException e) {
                LOGGER.warn("{} wasn't updated", account);
                throw new DAOException(e);
            }
        }
        return account;
    }

    private Account updateById(Account account, Connection connection) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            mapAccountToPreparedStatement(statement, account);
            statement.setLong(9, account.getId());
            statement.execute();
            connection.commit();
            account = findById(account.getId()).orElseThrow(SQLException::new);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
        return account;
    }

    private Account updateByUsername(Account account, Connection connection) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BY_USERNAME)) {
            mapAccountToPreparedStatement(statement, account);
            statement.setString(9, account.getUsername());
            statement.execute();
            connection.commit();
            account = findByUsername(account.getUsername()).orElseThrow(SQLException::new);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
        return account;
    }

    @Override
    public boolean delete(Long id) {
        try (PreparedStatement statement = connectionFactory.getConnection().prepareStatement(DELETE)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            LOGGER.info("Account with id {} wasn't deleted", id, e);
            throw new DAOException(e);
        }
    }
}
