package com.blog.by.kotor.service.role;

import com.blog.by.kotor.RoleDTOMapper;
import com.blog.by.kotor.dto.model.RoleDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleDTOMapper roleDTOMapper;

    @Override
    @Transactional
    public void createRole(RoleDTO roleDTO) {
        if (roleDTO.getRoleName() == null) {
            throw new CreateException(ErrorCode.ROLE_NAME);
        }
        Role role = roleDTOMapper.toRole(roleDTO);
        roleRepository.save(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.ROLE_NOT_FOUND, id));
    }

    @Override
    public Role findRoleByName(ERole name) {
        return roleRepository.findRoleByName(name)
                .orElseThrow(() -> new FindByNameException(ErrorCode.ROLE_NAME_NOT_FOUND, name.name()));
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void updateRole(RoleDTO roleDTO, Integer id) {
        Role role = this.findRoleById(id);
        roleRepository.save(roleDTOMapper.updateRole(roleDTO, role));
    }

    @Override
    @Transactional
    public void deleteRoleById(Integer id) {
        this.findRoleById(id);

        roleRepository.deleteById(id);
    }

}
