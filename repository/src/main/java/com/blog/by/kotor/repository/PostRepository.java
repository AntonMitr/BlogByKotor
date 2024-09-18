package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p join p.user u where u.id = ?1")
    List<Post> findByUserId(Integer userId);

    @Query("select p from Post p where p.title = ?1")
    List<Post> findByTitle(String title);

}
