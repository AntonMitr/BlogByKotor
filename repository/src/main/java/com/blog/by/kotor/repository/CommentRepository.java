package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId(Integer postId);

    List<Comment> findByPostIdOrderByCreatedAt(Integer postId);

    List<Comment> findByUserIdOrderByCreatedAt(Integer userId);

}
