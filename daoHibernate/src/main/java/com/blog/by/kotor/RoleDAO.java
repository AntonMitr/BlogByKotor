package com.blog.by.kotor;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO extends AbstractHibernateDao<Role> {

    public RoleDAO() {
        super(Role.class);
    }

}
