package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.RoleDTO;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RoleDTOMapper {

    public Role toRole(RoleDTO roleDTO) {
        return Role.builder()
                .name(ERole.valueOf(roleDTO.getRoleName()))
                .build();
    }

    public Role updateRole(RoleDTO roleDTO, Role role) {
        if (roleDTO.getRoleName() != null) {
            role.setName(ERole.valueOf(roleDTO.getRoleName()));
        }
        return role;
    }

}
