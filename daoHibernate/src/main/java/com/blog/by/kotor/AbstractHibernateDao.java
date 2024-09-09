package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AbstractHibernateDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> clazz;

    public AbstractHibernateDao(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T getById(final int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            return session.get(clazz, id);
        }
    }

    public List<T> getAll() {
        String hql = "from " + clazz.getName();
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery(hql, clazz);
            return query.list();
        }
    }

    public void create(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    public void update(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    public void delete(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    public void deleteById(final int id) {
        final T entity = getById(id);
        delete(entity);
    }

}
