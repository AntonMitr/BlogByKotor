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
    @Transactional
    public Poll getPollById(Integer id) {
        return pollRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Poll> getAllPoll() {
        return pollRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePoll(Poll poll) {
        pollRepository.saveAndFlush(poll);
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
