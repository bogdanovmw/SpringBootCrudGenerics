package com.example.Test.service;

import com.example.Test.exception.ServiceException;

import java.util.List;

public interface CrudService<T> {
    T save(T entity) throws ServiceException;
    T update(T entity) throws ServiceException;
    void remove(T entity) throws ServiceException;
    T get(int id) throws ServiceException;
    List<T> getAll() throws ServiceException;
}
