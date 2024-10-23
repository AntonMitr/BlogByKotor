package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

    Optional<Filter> findByCriteria(String criteria);

}
