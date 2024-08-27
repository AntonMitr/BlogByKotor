package com.blog.by.kotor.option;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.Option;

import java.util.List;

public interface OptionDAO extends DAO<Option> {

    List<Option> findOptionByQuestionId(int questionId);

}
