package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.PollDTO;
import com.blog.by.kotor.model.Poll;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class PollDTOMapper {

    public Poll toPoll(PollDTO pollDTO) {
        return Poll.builder()
                .description(pollDTO.getDescription())
                .title(pollDTO.getTitle())
                .createdAt(LocalDate.now())
                .build();
    }

    public Poll updatePoll(PollDTO pollDTO, Poll poll) {
        if (pollDTO.getDescription() != null) {
            poll.setDescription(pollDTO.getDescription());
        }
        if (pollDTO.getTitle() != null) {
            poll.setTitle(pollDTO.getTitle());
        }
        return poll;
    }

}
