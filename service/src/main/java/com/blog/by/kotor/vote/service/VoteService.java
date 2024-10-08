package com.blog.by.kotor.vote.service;

import com.blog.by.kotor.Vote;

import java.util.List;

public interface VoteService {

    void createVote(Vote vote);

    Vote getVoteById(int id);

    List<Vote> getAllVote();

    void updateVote(Vote vote);

    void deleteVoteById(int id);

    void deleteVote(Vote vote);
    
}
