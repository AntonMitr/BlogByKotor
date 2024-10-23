package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.userRole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query("select u from UserRole u join u.userRoleId ur where ur.userId = ?1")
    UserRole findUserAndRoleByUserId(Integer userId);

}
