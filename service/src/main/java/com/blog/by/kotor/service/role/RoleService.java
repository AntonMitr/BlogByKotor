package com.blog.by.kotor.service.role;

import com.blog.by.kotor.dto.model.RoleDTO;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;

import java.util.List;

public interface RoleService {

    void createRole(RoleDTO roleDTO);

    Role findRoleById(Integer id);

    Role findRoleByName(ERole roleName);

    List<Role> findAllRole();

    void updateRole(RoleDTO roleDTO, Integer id);

    void deleteRoleById(Integer id);

}
