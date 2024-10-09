package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO extends AbstractHibernateDao<Role> {

    @Autowired
    public RoleDAO(SessionFactory sessionFactory) {
        super(Role.class, sessionFactory);
    }

}
