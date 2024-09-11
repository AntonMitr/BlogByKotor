package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;
import com.blog.by.kotor.PollDAO;

import java.util.List;

public class PollServiceImpl implements PollService {

    private final PollDAO pollDAO;

    public PollServiceImpl() {
        pollDAO = PollDAO.getPollDAO();
    }

    @Override
    public void createPoll(Poll poll) {
        pollDAO.create(poll);
    }

    @Override
    public Poll getPollById(int id) {
        return pollDAO.getById(id);
    }

    @Override
    public List<Poll> getAllPoll() {
        return pollDAO.getAll();
    }

    @Override
    public void updatePoll(Poll poll) {
        pollDAO.update(poll);
    }

    @Override
    public void deletePollById(int id) {
        pollDAO.deleteById(id);
    }

    @Override
    public void deletePoll(Poll poll) {
        pollDAO.delete(poll);
    }

}
