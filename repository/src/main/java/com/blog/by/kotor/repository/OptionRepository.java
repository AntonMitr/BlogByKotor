package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {

    @Query("select o from Option o join o.question q where q.id = ?1")
    List<Option> findByQuestionId(Integer questionId);

}
