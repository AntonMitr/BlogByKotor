package com.blog.by.kotor.service.role;

import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.model.userRole.UserRole;
import com.blog.by.kotor.repository.RoleRepository;
import com.blog.by.kotor.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final UserRoleRepository userRoleRepository;

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role getRoleById(Integer id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    @Override
    @Transactional
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

}
