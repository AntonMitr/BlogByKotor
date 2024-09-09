package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractHibernateDao<User> {

    public UserDAO() {
        super(User.class);
    }

    public boolean findByEmail(String email) {
        String hql = "from User u where u.email = :email";
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            return !query.list().isEmpty();
        }
    }

    public boolean findByPassword(String password) {
        String hql = "from User u where u.password = :password";
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("password", password);
            return !query.list().isEmpty();
        }
    }

}