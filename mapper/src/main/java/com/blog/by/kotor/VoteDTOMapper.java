package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.VoteDTO;
import com.blog.by.kotor.model.Vote;
import org.springframework.stereotype.Service;

@Service
public class VoteDTOMapper {

    public Vote toVote(VoteDTO voteDTO) {
        return Vote.builder()
                .build();
    }

}
