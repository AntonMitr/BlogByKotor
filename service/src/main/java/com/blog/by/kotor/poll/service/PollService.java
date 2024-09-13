package com.blog.by.kotor.poll.service;

import com.blog.by.kotor.Poll;

import java.util.List;

public interface PollService {

    void createPoll(Poll poll);

    Poll getPollById(int id);

    List<Poll> getAllPoll();

    void updatePoll(Poll poll);

    void deletePollById(int id);

    void deletePoll(Poll poll);

}
