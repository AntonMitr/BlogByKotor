package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.model.user.role.UserRole;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    Role getRoleById(int id);

    List<Role> getAllRole();

    void updateRole(Role role);

    void deleteRoleById(int id);

    void deleteRole(Role role);

    void addUserRole(UserRole userRole);

}
