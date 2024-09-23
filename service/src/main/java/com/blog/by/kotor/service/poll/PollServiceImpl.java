package com.blog.by.kotor.service.poll;

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
    @Transactional(readOnly = true)
    public Poll findPollById(Integer id) {
        return pollRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Poll> findAllPoll() {
        return pollRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Poll> findPollByTitle(String title) {
        return pollRepository.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Poll> findPollByUserId(Integer userId) {
        return pollRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void updatePoll(Poll poll) {
        pollRepository.save(poll);
    }

    @Override
    @Transactional
    public void deletePollById(Integer id) {
        pollRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePoll(Poll poll) {
        pollRepository.delete(poll);
    }

}
