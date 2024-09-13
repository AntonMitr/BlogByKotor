package com.blog.by.kotor.role.service;

import com.blog.by.kotor.Role;
import com.blog.by.kotor.UserRole.UserRole;

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
