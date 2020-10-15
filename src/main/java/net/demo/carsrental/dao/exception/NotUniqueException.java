package net.demo.carsrental.dao.exception;

import java.util.List;

public class NotUniqueException extends Exception {
    private final List<String> notUniqueValue;

    public NotUniqueException(List<String> notUniqueValue) {
        this.notUniqueValue = notUniqueValue;
    }

    public List<String> getNotUniqueValue() {
        return notUniqueValue;
    }
}
