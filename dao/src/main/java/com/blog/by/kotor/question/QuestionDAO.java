package com.blog.by.kotor.question;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.Question;

import java.util.List;

public interface QuestionDAO extends DAO<Question> {

    List<Question> findByPollId(int pollId);

}
