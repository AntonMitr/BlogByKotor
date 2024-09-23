package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.postCategory.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {

    @Query("select p from PostCategory p join p.id pc where pc.categoryId = :categoryId")
    List<PostCategory> findByCategoryId(Integer categoryId);

    @Query("select p from PostCategory p join p.id pc where pc.postId = :postId")
    List<PostCategory> findByPostId(Integer postId);

}
