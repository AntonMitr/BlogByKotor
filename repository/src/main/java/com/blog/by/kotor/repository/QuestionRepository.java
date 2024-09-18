package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select q from Question q join q.poll p where p.id = ?1")
    Question findByPollId(Integer pollId);

}
