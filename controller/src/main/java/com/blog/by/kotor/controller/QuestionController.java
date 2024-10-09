package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Question;
import com.blog.by.kotor.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllQuestions() {
        return new ResponseEntity<>(questionService.findAllQuestion(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewQuestionById(@PathVariable Integer id) {
        return new ResponseEntity<>(questionService.findQuestionById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getQuestionTextContaining(@RequestParam String title) {
        return new ResponseEntity<>(questionService.findByQuestionTextContaining(title), HttpStatus.OK);
    }

    @GetMapping("/poll/{pollId}")
    public ResponseEntity<?> findQuestionByPollId(@PathVariable Integer pollId) {
        return new ResponseEntity<>(questionService.findByPollId(pollId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @PutMapping("/update-question")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Integer id) {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
