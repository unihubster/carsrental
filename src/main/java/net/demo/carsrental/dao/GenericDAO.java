package net.demo.carsrental.dao;

import net.demo.carsrental.dao.exception.NotUniqueException;
import net.demo.carsrental.dto.Page;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    T create(T entity) throws NotUniqueException;

    Optional<T> findById(Long id);

    List<T> findPage(Page page);

    void update(T entity);

    void delete(Long id);
}
