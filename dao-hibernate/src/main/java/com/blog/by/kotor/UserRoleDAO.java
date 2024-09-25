package com.blog.by.kotor;

import com.blog.by.kotor.userRole.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRoleDAO extends AbstractHibernateDao<UserRole> {

    private static UserRoleDAO userRoleDAO;

    private UserRoleDAO() {
        super(UserRole.class);
    }

    public static UserRoleDAO getUserRoleDAO() {
        if (userRoleDAO == null) {
            userRoleDAO = new UserRoleDAO();
        }
        return userRoleDAO;
    }

    public UserRole findUserAndRoleByUserId(int userId) {
        String hql = "from UserRole userRole where userRole.userRoleId.userId = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<UserRole> query = session.createQuery(hql, UserRole.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        }

    }

}
