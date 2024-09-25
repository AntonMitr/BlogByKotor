package com.blog.by.kotor.user_answer;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.UserAnswer;

import java.util.List;

public interface UserAnswerDAO extends DAO<UserAnswer> {

    List<UserAnswer> findByQuestionId(int questionId) throws DAOException, DBException;

    List<UserAnswer> findByOptionId(int optionId) throws DAOException, DBException;
}
