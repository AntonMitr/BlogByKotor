package com.blog.by.kotor.service.poll;

import com.blog.by.kotor.PollDTOMapper;
import com.blog.by.kotor.dto.model.PollDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
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

    private final PollDTOMapper pollDTOMapper;

    private final UserService userService;

    @Override
    @Transactional
    public void createPoll(PollDTO pollDTO) {
        if (pollDTO.getUserId() == null) {
            throw new CreateException(ErrorCode.POLL_USER_ID);
        }
        if (pollDTO.getTitle() == null) {
            throw new CreateException(ErrorCode.POLL_TITLE);
        }

        Poll poll = pollDTOMapper.toPoll(pollDTO);
        poll.setUser(userService.findUserById(pollDTO.getUserId()));
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
    public void updatePoll(PollDTO pollDTO, Integer id) {
        Poll poll = this.findPollById(id);
        pollRepository.save(pollDTOMapper.updatePoll(pollDTO, poll));
    }

    @Override
    @Transactional
    public void deletePollById(Integer id) {
        pollRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.POLL_NOT_FOUND, id));
        pollRepository.deleteById(id);
    }

}
