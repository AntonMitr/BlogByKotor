package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.model.Poll;

import java.util.List;

public interface PollService {

    void createPoll(Poll poll);

    Poll getPollById(Integer id);

    List<Poll> getAllPoll();

    void updatePoll(Poll poll);

    void deletePollById(Integer id);

    void deletePoll(Poll poll);

}
