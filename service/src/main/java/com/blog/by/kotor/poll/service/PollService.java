package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;
import com.blog.by.kotor.PollDAO;

public class PollService implements ImplPollService {

    private PollDAO pollDAO;

    public PollService() {
        pollDAO = new PollDAO();
    }

    @Override
    public void createPoll(Poll poll) {
        pollDAO.create(poll);
    }

}
