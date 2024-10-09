package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUserId(Integer userId);

    List<Post> findByTitle(String title);

    List<Post> findByTitleOrderByDatePublished(String title);

    List<Post> findByContentContainsOrderByDatePublished(String content);

}
