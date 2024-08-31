package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;
import com.blog.by.kotor.poll.PollDAO;
import com.blog.by.kotor.poll.PollDAOImpl;

public class PollService implements ImplPollService {

    private final PollDAO pollDAO;

    public PollService() {
        pollDAO = new PollDAOImpl();
    }

    @Override
    public void createPoll(Poll poll) {
        pollDAO.insert(poll);
    }

}
