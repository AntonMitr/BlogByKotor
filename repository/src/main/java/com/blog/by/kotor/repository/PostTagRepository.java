package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.postTag.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Integer> {

    @Query("select p from PostTag p join p.id id where id.tagId = ?1")
    List<PostTag> findPostTagByTagId(Integer tagId);

}
