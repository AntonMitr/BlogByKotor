package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.dto.model.PollDTO;
import com.blog.by.kotor.model.Poll;

import java.util.List;

public interface PollService {

    void createPoll(PollDTO pollDto);

    Poll findPollById(Integer id);

    List<Poll> findAllPoll();

    List<Poll> findPollByTitle(String title);

    List<Poll> findPollByUserId(Integer userId);

    void updatePoll(PollDTO pollDTO, Integer id);

    void deletePollById(Integer id);

}
