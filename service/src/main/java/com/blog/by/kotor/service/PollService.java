package com.blog.by.kotor.service;

import com.blog.by.kotor.model.Poll;

import java.util.List;

public interface PollService {

    void createPoll(Poll poll);

    Poll getPollById(int id);

    List<Poll> getAllPoll();

    void updatePoll(Poll poll);

    void deletePollById(int id);

    void deletePoll(Poll poll);

}
