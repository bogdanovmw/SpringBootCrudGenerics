package com.example.Test.service;

import com.example.Test.exception.RepositoryException;
import com.example.Test.exception.ServiceException;
import com.example.Test.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AbstractService<T> implements CrudService<T> {
    protected CrudRepository<T> repository;

    @Override
    @Transactional
    public T save(T entity) throws ServiceException {
        try {
            return repository.add(entity);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public T update(T entity) throws ServiceException {
        try {
            return repository.update(entity);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void remove(T entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public T get(int id) throws ServiceException {
        try {
            return repository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public List<T> getAll() throws ServiceException {
        try {
            return repository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
