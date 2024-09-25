package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.Poll;
import com.blog.by.kotor.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    @Override
    @Transactional
    public void createPoll(Poll poll) {
        pollRepository.save(poll);
    }

    @Override
    public Poll findPollById(Integer id) {
        return pollRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.POLL_NOT_FOUND, id));

    }

    @Override
    public List<Poll> findAllPoll() {
        return pollRepository.findAll();
    }

    @Override
    public List<Poll> findPollByTitle(String title) {
        return pollRepository.findByTitle(title);
    }

    @Override
    public List<Poll> findPollByUserId(Integer userId) {
        return pollRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void updatePoll(Poll poll) {
        pollRepository.findById(poll.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.POLL_NOT_FOUND, poll.getId()));
        pollRepository.save(poll);
    }

    @Override
    @Transactional
    public void deletePollById(Integer id) {
        pollRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.POLL_NOT_FOUND, id));
        pollRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePoll(Poll poll) {
        pollRepository.findById(poll.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.POLL_NOT_FOUND, poll.getId()));
        pollRepository.delete(poll);
    }

}
