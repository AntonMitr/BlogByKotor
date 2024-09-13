package com.blog.by.kotor.vote.service;

import com.blog.by.kotor.Vote;
import com.blog.by.kotor.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDAO voteDAO;

    @Autowired
    public VoteServiceImpl(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    @Override
    @Transactional
    public void createVote(Vote vote) {
        voteDAO.create(vote);
    }

    @Override
    @Transactional
    public Vote getVoteById(int id) {
        return voteDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Vote> getAllVote() {
        return voteDAO.getAll();
    }

    @Override
    @Transactional
    public void updateVote(Vote vote) {
        voteDAO.update(vote);
    }

    @Override
    @Transactional
    public void deleteVoteById(int id) {
        voteDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteVote(Vote vote) {
        voteDAO.delete(vote);
    }

}
