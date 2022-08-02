package com.example.Test.repository;

import com.example.Test.exception.RepositoryException;

import java.util.List;

public interface CrudRepository<T> {
    T add(T entity) throws RepositoryException;
    T update(T entity) throws RepositoryException;
    void delete(T entity) throws RepositoryException;
    T get(int id) throws RepositoryException;
    List<T> getAll() throws RepositoryException;
}
