package com.blog.by.kotor.service.role;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
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
            throw new CreateException(ErrorCode.ROLE_ID);
        }
        if (role.getName() == null) {
            throw new CreateException(ErrorCode.ROLE_NAME);
        }
        roleRepository.save(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.ROLE_NOT_FOUND, id));
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
        roleRepository.findById(role.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, role.getId()));
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(Integer id) {
        roleRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleRepository.findById(role.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, role.getId()));
        roleRepository.deleteById(role.getId());
    }

}
