package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
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
            throw new CreateException(ErrorCode.POLL_ID);
        }
        if (poll.getUser().getId() == null) {
            throw new CreateException(ErrorCode.POLL_USER_ID);
        }
        if (poll.getTitle() == null) {
            throw new CreateException(ErrorCode.POLL_TITLE);
        }
        if (poll.getCreatedAt() == null) {
            throw new CreateException(ErrorCode.POLL_CREATED_AT);
        }
        pollRepository.save(poll);
    }

    @Override
    public Poll findPollById(Integer id) {
        return pollRepository.findById(id).orElseThrow(() -> new FindByIdException(ErrorCode.POLL_NOT_FOUND, id));

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
        pollRepository.findById(poll.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.POLL_NOT_FOUND, poll.getId()));
        pollRepository.save(poll);
    }

    @Override
    @Transactional
    public void deletePollById(Integer id) {
        pollRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.POLL_NOT_FOUND, id));
        pollRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePoll(Poll poll) {
        pollRepository.findById(poll.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.POLL_NOT_FOUND, poll.getId()));
        pollRepository.delete(poll);
    }

}
