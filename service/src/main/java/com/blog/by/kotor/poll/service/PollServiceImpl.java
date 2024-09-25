package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.Poll;
import com.blog.by.kotor.poll.PollDAOImpl;

public class PollServiceImpl implements PollService {

    public PollServiceImpl() {
    }

    @Override
    public void createPoll(Poll poll) throws DAOException, DBException {
        PollDAOImpl.getPollDAOImpl().insert(poll);
    }

}
