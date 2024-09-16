package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO extends AbstractHibernateDao<User> {

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public boolean findByEmail(String email) {
        String hql = "from User u where u.email = :email";
        try (Session session = getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            return !query.list().isEmpty();
        }
    }

    @Transactional(readOnly = true)
    public boolean findByPassword(String password) {
        String hql = "from User u where u.password = :password";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("password", password);
            return !query.list().isEmpty();
        }
    }

}
