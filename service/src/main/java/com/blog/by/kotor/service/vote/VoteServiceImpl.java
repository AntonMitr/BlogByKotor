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
    @Transactional(readOnly = true)
    public Vote findVoteById(Integer id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vote> findVotesByOptionId(Integer optionId) {
        return voteRepository.findVotesByOptionId(optionId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vote> findVotesByUserId(Integer userId) {
        return voteRepository.findVotesByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vote> findAllVote() {
        return voteRepository.findAll();
    }

    @Override
    @Transactional
    public void updateVote(Vote vote) {
        voteRepository.save(vote);
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
