package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.QuestionDTO;
import com.blog.by.kotor.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<?> addQuestion(@RequestBody @Validated QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(questionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@RequestBody @Validated QuestionDTO questionDTO, @PathVariable Integer id) {
        questionService.updateQuestion(questionDTO, id);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Integer id) {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
