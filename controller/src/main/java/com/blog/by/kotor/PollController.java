package com.blog.by.kotor;


import com.blog.by.kotor.model.Poll;
import com.blog.by.kotor.service.poll.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllOPolls() {
        return new ResponseEntity<>(pollService.findAllPoll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> findPollByUerId(@RequestParam Integer userId) {
        return new ResponseEntity<>(pollService.findPollByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPollById(@PathVariable Integer id) {
        return new ResponseEntity<>(pollService.findPollById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findPollByTitle(@RequestParam String title) {
        return new ResponseEntity<>(pollService.findPollByTitle(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        pollService.createPoll(poll);
        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll) {
        pollService.updatePoll(poll);
        return new ResponseEntity<>(poll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePollById(@PathVariable Integer id) {
        pollService.deletePollById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
