package com.example.Test.repository;

import com.example.Test.exception.RepositoryException;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AbstractRepository<T> implements CrudRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityType;

    @SuppressWarnings("unchecked")
    public AbstractRepository() {
        this.entityType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractRepository.class);
    }

    @Override
    public T add(T entity) throws RepositoryException {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            throw new RepositoryException("exception in DAO add", e);
        }
    }

    @Override
    public T update(T entity) throws RepositoryException {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            throw new RepositoryException("exception in DAO update", e);
        }
    }

    @Override
    public void delete(T entity) throws RepositoryException {
        try {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        } catch (Exception e) {
            throw new RepositoryException("exception in DAO delete", e);
        }
    }

    @Override
    public T get(int id) throws RepositoryException {
        try {
            return entityManager.find(entityType, id);
        } catch (Exception e) {
            throw new RepositoryException("exception in DAO get", e);
        }
    }

    @Override
    public List<T> getAll() throws RepositoryException {
        try {
            CriteriaBuilder cd = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> select = cd.createQuery(entityType);
            Root<T> root = select.from(entityType);
            return entityManager.createQuery(select.select(root)).getResultList();
        } catch (Exception e) {
            throw new RepositoryException("exception in DAO getAll", e);
        }
    }
}
