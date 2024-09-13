package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;
import com.blog.by.kotor.PollDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollDAO pollDAO;

    @Autowired
    public PollServiceImpl(PollDAO pollDAO) {
        this.pollDAO = pollDAO;
    }

    @Override
    @Transactional
    public void createPoll(Poll poll) {
        pollDAO.create(poll);
    }

    @Override
    @Transactional
    public Poll getPollById(int id) {
        return pollDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Poll> getAllPoll() {
        return pollDAO.getAll();
    }

    @Override
    @Transactional
    public void updatePoll(Poll poll) {
        pollDAO.update(poll);
    }

    @Override
    @Transactional
    public void deletePollById(int id) {
        pollDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePoll(Poll poll) {
        pollDAO.delete(poll);
    }

}
