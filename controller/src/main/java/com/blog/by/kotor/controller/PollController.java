package com.blog.by.kotor.controller;


import com.blog.by.kotor.dto.model.PollDTO;
import com.blog.by.kotor.service.poll.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllPolls() {
        return new ResponseEntity<>(pollService.findAllPoll(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> viewPollByUerId(@PathVariable Integer userId) {
        return new ResponseEntity<>(pollService.findPollByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewPollById(@PathVariable Integer id) {
        return new ResponseEntity<>(pollService.findPollById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewPollByTitle(@RequestParam String title) {
        return new ResponseEntity<>(pollService.findPollByTitle(title), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addPoll(@RequestBody @Validated PollDTO pollDTO) {
        pollService.createPoll(pollDTO);
        return new ResponseEntity<>(pollDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoll(@RequestBody @Validated PollDTO pollDTO, @PathVariable Integer id) {
        pollService.updatePoll(pollDTO, id);
        return new ResponseEntity<>(pollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePollById(@PathVariable Integer id) {
        pollService.deletePollById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
