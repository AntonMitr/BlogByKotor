package com.blog.by.kotor.service.vote;

import com.blog.by.kotor.VoteDTOMapper;
import com.blog.by.kotor.dto.model.VoteDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.model.Vote;
import com.blog.by.kotor.repository.VoteRepository;
import com.blog.by.kotor.service.option.OptionService;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    private final PostService postService;

    private final OptionService optionService;

    private final UserService userService;

    private final VoteDTOMapper voteDTOMapper;

    @Override
    @Transactional
    public void createVote(VoteDTO voteDTO) {
        if (voteDTO.getOptionId() == null) {
            throw new CreateException(ErrorCode.VOTE_OPTION_ID);
        }
        if (voteDTO.getUserId() == null) {
            throw new CreateException(ErrorCode.VOTE_USER_ID);
        }

        Vote vote = voteDTOMapper.toVote(voteDTO);
        vote.setPost(postService.findPostById(voteDTO.getPostId()));
        vote.setOption(optionService.findOptionById(voteDTO.getOptionId()));
        vote.setUser(userService.findUserById(voteDTO.getUserId()));
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

    //Доработать или убрать...
    @Deprecated
    @Override
    @Transactional
    public void updateVote(VoteDTO voteDTO, Integer id) {
        this.findVoteById(id);

        Vote vote = voteDTOMapper.toVote(voteDTO);
        vote.setPost(postService.findPostById(voteDTO.getPostId()));
        vote.setOption(optionService.findOptionById(voteDTO.getOptionId()));
        vote.setUser(userService.findUserById(voteDTO.getUserId()));
        vote.setId(id);
        voteRepository.save(vote);
    }

    @Override
    @Transactional
    public void deleteVoteById(Integer id) {
        this.findVoteById(id);

        voteRepository.deleteById(id);
    }

}
