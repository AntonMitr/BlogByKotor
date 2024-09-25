package com.blog.by.kotor;

public class RoleDAO extends AbstractHibernateDao<Role> {

    private static RoleDAO roleDAO;

    private RoleDAO() {
        super(Role.class);
    }

    public static RoleDAO getRoleDAO() {
        if (roleDAO == null) {
            roleDAO = new RoleDAO();
        }
        return roleDAO;
    }

}
