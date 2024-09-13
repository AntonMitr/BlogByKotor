package com.blog.by.kotor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAO extends AbstractHibernateDao<Role> {

    public RoleDAO() {
        super(Role.class);
    }

}
