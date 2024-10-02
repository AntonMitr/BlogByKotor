package com.blog.by.kotor.service.vote;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
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
        if(vote.getId() == null){
            throw new CreateException(ErrorCode.VOTE_ID);
        }
        if(vote.getPost().getId() == null){
            throw new CreateException(ErrorCode.VOTE_POST_ID);
        }
        if(vote.getOption().getId() == null){
            throw new CreateException(ErrorCode.VOTE_OPTION_ID);
        }
        if(vote.getUser().getId() == null){
            throw new CreateException(ErrorCode.VOTE_USER_ID);
        }
        voteRepository.save(vote);
    }

    @Override
    public Vote findVoteById(Integer id) {
        return voteRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.VOTE_NOT_FOUND, id));
    }

    @Override
    public List<Vote> findVotesByOptionId(Integer optionId) {
        return voteRepository.findVotesByOptionId(optionId);
    }

    @Override
    public List<Vote> findVotesByUserId(Integer userId) {
        return voteRepository.findVotesByUserId(userId);
    }

    @Override
    public List<Vote> findAllVote() {
        return voteRepository.findAll();
    }

    @Override
    @Transactional
    public void updateVote(Vote vote) {
        voteRepository.findById(vote.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.VOTE_NOT_FOUND, vote.getId()));
        voteRepository.save(vote);
    }

    @Override
    @Transactional
    public void deleteVoteById(Integer id) {
        voteRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.VOTE_NOT_FOUND, id));
        voteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteVote(Vote vote) {
        voteRepository.findById(vote.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.VOTE_NOT_FOUND, vote.getId()));
        voteRepository.delete(vote);
    }

}
