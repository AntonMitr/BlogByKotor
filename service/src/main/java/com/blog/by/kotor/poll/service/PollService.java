package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Poll;

public interface PollService {

    void createPoll(Poll poll) throws DAOException, DBException;

}
