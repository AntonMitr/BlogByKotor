package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findByPollId(Integer pollId);

    List<Question> findByQuestionTextContaining(String questionText);

}
