package com.blog.by.kotor.service.role;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
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

    @Override
    @Transactional
    public void createRole(Role role) {
        if (role.getId() == null) {
            throw CreateExceptionFactory.RoleParamNotBeNull(NotNullParam.ROLE_ID);
        }
        if (role.getName() == null) {
            throw CreateExceptionFactory.RoleParamNotBeNull(NotNullParam.ROLE_NAME);
        }
        roleRepository.save(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.ROLE_NOT_FOUND, id));
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleRepository.findById(role.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, role.getId()));
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(Integer id) {
        roleRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleRepository.findById(role.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, role.getId()));
        roleRepository.deleteById(role.getId());
    }

}
