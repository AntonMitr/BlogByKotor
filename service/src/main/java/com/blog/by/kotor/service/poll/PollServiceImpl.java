package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
import com.blog.by.kotor.model.Poll;
import com.blog.by.kotor.repository.PollRepository;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    private final UserService userService;

    @Override
    @Transactional
    public void createPoll(Poll poll) {
        if (poll.getId() == null) {
            throw CreateExceptionFactory.PollParamNotBeNull(NotNullParam.POLL_ID);
        }
        if (poll.getUser().getId() == null) {
            throw CreateExceptionFactory.PollParamNotBeNull(NotNullParam.POLL_USER_ID);
        }
        if (poll.getTitle() == null) {
            throw CreateExceptionFactory.PollParamNotBeNull(NotNullParam.POLL_TITLE);
        }
        if (poll.getCreatedAt() == null) {
            throw CreateExceptionFactory.PollParamNotBeNull(NotNullParam.POLL_CREATED_AT);
        }
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
        userService.findUserById(userId);
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
