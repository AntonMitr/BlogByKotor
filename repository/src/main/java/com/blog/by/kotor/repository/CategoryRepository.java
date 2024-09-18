package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select C from Category c where c.name = ?1")
    Category findByName(String name);

}
