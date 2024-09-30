package com.blog.by.kotor;

import com.blog.by.kotor.model.User;
import com.blog.by.kotor.model.Vote;
import com.blog.by.kotor.service.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllVotes() {
        return new ResponseEntity<>(voteService.findAllVote(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVoteById(@PathVariable Integer id) {
        return new ResponseEntity<>(voteService.findVoteById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getVoteByUserId(@RequestParam Integer userId) {
        return new ResponseEntity<>(voteService.findVotesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getVoteByOptionId(@RequestParam Integer optionId) {
        return new ResponseEntity<>(voteService.findVotesByOptionId(optionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addVote(@RequestBody Vote vote) {
        voteService.createVote(vote);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateVote(@RequestBody Vote vote) {
        voteService.updateVote(vote);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVoteById(@PathVariable Integer voteId) {
        voteService.deleteVoteById(voteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
