package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO extends AbstractHibernateDao<User> {

    public UserDAO() {
        super(User.class);
    }

    @Transactional(readOnly = true)
    public boolean findByEmail(String email) {
        String hql = "from User u where u.email = :email";
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            return !query.list().isEmpty();
        }
    }

    @Transactional(readOnly = true)
    public boolean findByPassword(String password) {
        String hql = "from User u where u.password = :password";
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("password", password);
            return !query.list().isEmpty();
        }
    }

}
