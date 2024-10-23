package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findRoleByName(ERole name);

}
