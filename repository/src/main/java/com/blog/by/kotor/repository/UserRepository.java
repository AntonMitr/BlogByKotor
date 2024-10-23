package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select count(u) > 0 from User u where u.email = ?1")
    boolean findByEmail(String email);

    @Query("select count(u) > 0 from User u where u.password = ?1")
    boolean findByPassword(String password);

}
