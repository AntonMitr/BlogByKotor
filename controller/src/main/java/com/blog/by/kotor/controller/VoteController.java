package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.VoteDTO;
import com.blog.by.kotor.service.vote.VoteService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vote")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllVotes() {
        return new ResponseEntity<>(voteService.findAllVote(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Vote не найден")
    })
    public ResponseEntity<?> getVoteById(@PathVariable @Parameter(description = "Индентификатор голоса", example = "1") Integer id) {
        return new ResponseEntity<>(voteService.findVoteById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Vote не найден")
    })
    public ResponseEntity<?> getVoteByUserId(@PathVariable @Parameter(description = "Индентификатор пользователя", example = "1") Integer userId) {
        return new ResponseEntity<>(voteService.findVotesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/option/{optionId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Vote не найден")
    })
    public ResponseEntity<?> getVoteByOptionId(@PathVariable @Parameter(description = "Индентификатор ответа", example = "1") Integer optionId) {
        return new ResponseEntity<>(voteService.findVotesByOptionId(optionId), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addVote(@RequestBody @Validated VoteDTO voteDTO) {
        voteService.createVote(voteDTO);
        return new ResponseEntity<>(voteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Vote не найден")
    })
    public ResponseEntity<?> updateVote(@RequestBody VoteDTO voteDTO, @PathVariable @Parameter(description = "Индентификатор голоса", example = "1") Integer id) {
        voteService.updateVote(voteDTO, id);
        return new ResponseEntity<>(voteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Vote не найден")
    })
    public ResponseEntity<?> deleteVoteById(@PathVariable @Parameter(description = "Индентификатор голоса", example = "1") Integer id) {
        voteService.deleteVoteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
