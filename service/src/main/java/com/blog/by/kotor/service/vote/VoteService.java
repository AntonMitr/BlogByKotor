package com.blog.by.kotor.service.vote;

import com.blog.by.kotor.model.Vote;

import java.util.List;

public interface VoteService {

    void createVote(Vote vote);

    Vote findVoteById(Integer id);

    List<Vote> findVotesByOptionId(Integer optionId);

    List<Vote> findVotesByUserId(Integer userId);

    List<Vote> findAllVote();

    void updateVote(Vote vote);

    void deleteVoteById(Integer id);

    void deleteVote(Vote vote);

}
