package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

    @Query("select f from Filter f where f.criteria = ?1")
    Filter findByCriteria(String criteria);

}
