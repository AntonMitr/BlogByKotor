package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.model.userRole.UserRole;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    Role getRoleById(Integer id);

    List<Role> getAllRole();

    void updateRole(Role role);

    void deleteRoleById(Integer id);

    void deleteRole(Role role);

    void addUserRole(UserRole userRole);

}
