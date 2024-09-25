package com.blog.by.kotor.vote.service;

import com.blog.by.kotor.Vote;
import com.blog.by.kotor.VoteDAO;

import java.util.List;

public class VoteServiceImpl implements VoteService {

    private final VoteDAO voteDAO;

    public VoteServiceImpl() {
        voteDAO = VoteDAO.getVoteDAO();
    }

    @Override
    public void createVote(Vote vote) {
        voteDAO.create(vote);
    }

    @Override
    public Vote getVoteById(int id) {
        return voteDAO.getById(id);
    }

    @Override
    public List<Vote> getAllVote() {
        return voteDAO.getAll();
    }

    @Override
    public void updateVote(Vote vote) {
        voteDAO.update(vote);
    }

    @Override
    public void deleteVoteById(int id) {
        voteDAO.deleteById(id);
    }

    @Override
    public void deleteVote(Vote vote) {
        voteDAO.delete(vote);
    }

}
