package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.userRole.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRoleDAO extends AbstractHibernateDao<UserRole> {

    @Autowired
    public UserRoleDAO(SessionFactory sessionFactory) {
        super(UserRole.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public UserRole findUserAndRoleByUserId(int userId) {
        String hql = "from UserRole userRole where userRole.userRoleId.userId = :userId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<UserRole> query = session.createQuery(hql, UserRole.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        }

    }

}
