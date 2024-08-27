package com.blog.by.kotor;

public class PollService {

    public void createPoll(Poll poll) {
        PollDAO pollDAO = new PollDAO();
        pollDAO.create(poll);
    }

}
