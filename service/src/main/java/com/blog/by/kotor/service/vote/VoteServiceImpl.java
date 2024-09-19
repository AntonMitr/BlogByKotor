package com.blog.by.kotor.service.vote;

import com.blog.by.kotor.model.Vote;
import com.blog.by.kotor.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Override
    @Transactional
    public void createVote(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    @Transactional
    public Vote getVoteById(Integer id) {
        return voteRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Vote> getAllVote() {
        return voteRepository.findAll();
    }

    @Override
    @Transactional
    public void updateVote(Vote vote) {
        voteRepository.saveAndFlush(vote);
    }

    @Override
    @Transactional
    public void deleteVoteById(Integer id) {
        voteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteVote(Vote vote) {
        voteRepository.delete(vote);
    }

}
