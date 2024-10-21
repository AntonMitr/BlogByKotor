package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.QuestionDTO;
import com.blog.by.kotor.service.question.QuestionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/question")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllQuestions() {
        return new ResponseEntity<>(questionService.findAllQuestion(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Question не найден")
    })
    public ResponseEntity<?> viewQuestionById(@PathVariable @Parameter(description = "Индентификатор вопроса", example = "1") Integer id) {
        return new ResponseEntity<>(questionService.findQuestionById(id), HttpStatus.OK);
    }

    @GetMapping
        public ResponseEntity<?> getQuestionTextContaining(@RequestParam @Parameter(description = "Текст вопроса", example = "Сколько лет вы ведете блог?") String title) {
        return new ResponseEntity<>(questionService.findByQuestionTextContaining(title), HttpStatus.OK);
    }

    @GetMapping("/poll/{pollId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Question не найден")
    })
    public ResponseEntity<?> findQuestionByPollId(@PathVariable @Parameter(description = "Индентификатор опроса", example = "1") Integer pollId) {
        return new ResponseEntity<>(questionService.findByPollId(pollId), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addQuestion(@RequestBody @Validated QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(questionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Question не найден")
    })
    public ResponseEntity<?> updateQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable @Parameter(description = "Индентификатор вопроса", example = "1") Integer id) {
        questionService.updateQuestion(questionDTO, id);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Question не найден")
    })
    public ResponseEntity<?> deleteQuestionById(@PathVariable @Parameter(description = "Индентификатор вопроса", example = "1") Integer id) {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
