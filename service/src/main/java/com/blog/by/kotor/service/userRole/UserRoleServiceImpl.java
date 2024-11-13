package com.blog.by.kotor.service.userRole;

import com.blog.by.kotor.model.userRole.UserRole;
import com.blog.by.kotor.repository.UserRoleRepository;
import com.blog.by.kotor.service.role.RoleService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserService userService;

    private final RoleService roleService;

    @Override
    @Transactional
    public void createUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> findUserRoleByUserId(Integer id) {
        return userRoleRepository.findUserAndRoleByUserId(id);
    }

    @Override
    public List<UserRole> findAllUserRole() {
        return userRoleRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    @Transactional
    public void deleteUserRole(UserRole userRole) {
        userService.findUserById(userRole.getUserRoleId().getUserId());
        roleService.findRoleById(userRole.getUserRoleId().getRoleId());
        userRoleRepository.delete(userRole);
    }

}
