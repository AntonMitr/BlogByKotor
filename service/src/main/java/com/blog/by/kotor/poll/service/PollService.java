package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;
import com.blog.by.kotor.PollDAO;

public class PollService implements ImplPollService {

    private final PollDAO pollDAO;

    public PollService(PollDAO pollDAO) {
        this.pollDAO = pollDAO;
    }

    @Override
    public void createPoll(Poll poll) {
        pollDAO.create(poll);
    }

}
