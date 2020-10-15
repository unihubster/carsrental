package net.demo.carsrental.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionFactory {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionFactory.class);
    private static final String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HIKARI_PROPERTIES = "hikari.mysql.properties";
    private final HikariDataSource hikariDataSource;

    public ConnectionFactory() {
        try {
            Class.forName(MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.fatal("Database connection driver not found", e);
            throw new RuntimeException();
        }
        hikariDataSource = initHikariDataSource(getResourcePath(HIKARI_PROPERTIES));
    }

    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }

    private HikariDataSource initHikariDataSource(String path) {
        HikariConfig config = new HikariConfig(path);
        return new HikariDataSource(config);
    }

    private String getResourcePath(String resourceName) {
        return Objects.requireNonNull(
                ConnectionFactory.class
                        .getClassLoader()
                        .getResource(resourceName))
                      .toString()
                      .replace("file:/", "");
    }
}
