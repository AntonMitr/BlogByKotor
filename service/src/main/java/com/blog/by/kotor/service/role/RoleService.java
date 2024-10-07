package com.blog.by.kotor.service.role;

import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    Role findRoleById(Integer id);

    Role findRoleByName(ERole roleName);

    List<Role> findAllRole();

    void updateRole(Role role);

    void deleteRoleById(Integer id);

    void deleteRole(Role role);

}
