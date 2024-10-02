package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Vote;
import com.blog.by.kotor.service.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/view-votes")
    public ResponseEntity<?> getAllVotes() {
        return new ResponseEntity<>(voteService.findAllVote(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVoteById(@PathVariable Integer id) {
        return new ResponseEntity<>(voteService.findVoteById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getVoteByUserId(@PathVariable Integer userId) {
        return new ResponseEntity<>(voteService.findVotesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/option/{optionId}")
    public ResponseEntity<?> getVoteByOptionId(@PathVariable Integer optionId) {
        return new ResponseEntity<>(voteService.findVotesByOptionId(optionId), HttpStatus.OK);
    }

    @PostMapping("/add-vote")
    public ResponseEntity<?> addVote(@RequestBody Vote vote) {
        voteService.createVote(vote);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }

    @PutMapping("/update-vote")
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
