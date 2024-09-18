package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c join c.post p where p.id = ?1")
    List<Comment> findByPostId(Integer postId);

}
