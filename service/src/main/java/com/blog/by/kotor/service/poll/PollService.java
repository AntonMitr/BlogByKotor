package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.model.Poll;

import java.util.List;

public interface PollService {

    void createPoll(Poll poll);

    Poll findPollById(Integer id);

    List<Poll> findAllPoll();

    List<Poll> findPollByTitle(String title);

    List<Poll> findPollByUserId(Integer userId);

    void updatePoll(Poll poll);

    void deletePollById(Integer id);

    void deletePoll(Poll poll);

}
