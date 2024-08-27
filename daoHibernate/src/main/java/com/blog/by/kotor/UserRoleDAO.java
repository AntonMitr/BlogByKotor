package com.blog.by.kotor;

import com.blog.by.kotor.UserRole.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRoleDAO extends AbstractHibernateDao<UserRole> {

    public UserRoleDAO() {
        super(UserRole.class);
    }

    public UserRole findUserAndRoleByUserId(int userId) {
        String hql = "from UserRole where userId = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<UserRole> query = session.createQuery(hql, UserRole.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        }

    }

}
