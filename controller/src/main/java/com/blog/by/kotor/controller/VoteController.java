package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.VoteDTO;
import com.blog.by.kotor.service.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vote")
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getVoteByUserId(@PathVariable Integer userId) {
        return new ResponseEntity<>(voteService.findVotesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/option/{optionId}")
    public ResponseEntity<?> getVoteByOptionId(@PathVariable Integer optionId) {
        return new ResponseEntity<>(voteService.findVotesByOptionId(optionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addVote(@RequestBody @Validated VoteDTO voteDTO) {
        voteService.createVote(voteDTO);
        return new ResponseEntity<>(voteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVote(@RequestBody @Validated VoteDTO voteDTO, @PathVariable Integer id) {
        voteService.updateVote(voteDTO, id);
        return new ResponseEntity<>(voteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVoteById(@PathVariable Integer id) {
        voteService.deleteVoteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
