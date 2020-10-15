package net.demo.carsrental.controller.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RegExpHandler {
    private static final String REGEX_PROPERTIES = "regex.properties";
    private static final Properties properties = loadProperties(REGEX_PROPERTIES);

    private RegExpHandler() {
    }

    static String getPropertyValue(String regexPropertyKey) {
        return properties.getProperty(regexPropertyKey);
    }

    private static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try (InputStream inputStream = RegExpHandler.class.getClassLoader().getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
