package com.blog.by.kotor.controller;


import com.blog.by.kotor.dto.model.PollDTO;
import com.blog.by.kotor.service.poll.PollService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/poll")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class PollController {

    private final PollService pollService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllPolls() {
        return new ResponseEntity<>(pollService.findAllPoll(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Poll не найден")
    })
    public ResponseEntity<?> viewPollByUerId(@PathVariable @Parameter(description = "Индентификатор пользователя", example = "1") Integer userId) {
        return new ResponseEntity<>(pollService.findPollByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Poll не найден")
    })
    public ResponseEntity<?> viewPollById(@PathVariable @Parameter(description = "Индентификатор опроса", example = "1") Integer id) {
        return new ResponseEntity<>(pollService.findPollById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Poll не найден")
    })
    public ResponseEntity<?> viewPollByTitle(@RequestParam @Parameter(description = "Заголовок опроса", example = "Какой стиль выбрать сегодня?") String title) {
        return new ResponseEntity<>(pollService.findPollByTitle(title), HttpStatus.OK);
    }

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addPoll(@RequestBody @Validated PollDTO pollDTO) {
        pollService.createPoll(pollDTO);
        return new ResponseEntity<>(pollDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Poll не найден")
    })
    public ResponseEntity<?> updatePoll(@RequestBody PollDTO pollDTO, @PathVariable @Parameter(description = "Индентификатор опроса", example = "1") Integer id) {
        pollService.updatePoll(pollDTO, id);
        return new ResponseEntity<>(pollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Poll не найден")
    })
    public ResponseEntity<?> deletePollById(@PathVariable @Parameter(description = "Индентификатор опроса", example = "1") Integer id) {
        pollService.deletePollById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
