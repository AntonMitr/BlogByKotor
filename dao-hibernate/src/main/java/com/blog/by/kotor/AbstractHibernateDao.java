package com.blog.by.kotor;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public abstract class AbstractHibernateDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private final Class<T> clazz;

    protected AbstractHibernateDao(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional(readOnly = true)
    public T getById(final int id) {
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
}
