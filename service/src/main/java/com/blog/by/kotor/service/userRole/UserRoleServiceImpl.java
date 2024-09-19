package com.blog.by.kotor.service.userRole;

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
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public String getUserRole(Integer userId) {
        UserRole userRole = userRoleRepository.findUserAndRoleByUserId(userId);

        Role role = roleRepository.getReferenceById(userRole.getUserRoleId().getUserId());
        return role.getName();
    }

    @Override
    @Transactional
    public void createUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    @Transactional
    public UserRole getUserRoleById(Integer id) {
        return userRoleRepository.findUserAndRoleByUserId(id);
    }

    @Override
    @Transactional
    public List<UserRole> getAllUserRole() {
        return userRoleRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    @Transactional
    public void deleteUserRoleById(Integer id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

}
