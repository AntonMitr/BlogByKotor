package com.blog.by.kotor.service.vote;

import com.blog.by.kotor.dto.model.VoteDTO;
import com.blog.by.kotor.model.Vote;

import java.util.List;

public interface VoteService {

    void createVote(VoteDTO voteDTO);

    Vote findVoteById(Integer id);

    List<Vote> findVotesByOptionId(Integer optionId);

    List<Vote> findVotesByUserId(Integer userId);

    List<Vote> findAllVote();

    void updateVote(VoteDTO voteDTO, Integer id);

    void deleteVoteById(Integer id);

}
