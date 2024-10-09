package com.blog.by.kotor.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractHibernateDao<T> {

    private final SessionFactory sessionFactory;

    private final Class<T> clazz;

    protected AbstractHibernateDao(Class<T> clazzToSet, SessionFactory sessionFactory) {
        this.clazz = clazzToSet;
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public T getById(int id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        String hql = "from " + clazz.getName();
        Query<T> query = sessionFactory.getCurrentSession().createQuery(hql, clazz);
        return query.list();
    }

    @Transactional
    public void create(final T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Transactional
    public void update(final T entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Transactional
    public void delete(final T entity) {
        sessionFactory.getCurrentSession().remove(entity);
    }

    @Transactional
    public void deleteById(final int id) {
        final T entity = getById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
