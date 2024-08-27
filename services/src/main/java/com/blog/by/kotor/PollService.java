package com.blog.by.kotor;

import com.blog.by.kotor.poll.PollDAO;
import com.blog.by.kotor.poll.PollDAOImpl;

public class PollService {

    public void createPoll(Poll poll) {
        PollDAO pollDAO = new PollDAOImpl();
        pollDAO.insert(poll);
    }

}
