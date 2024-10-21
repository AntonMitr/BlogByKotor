package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.OptionDTO;
import com.blog.by.kotor.service.option.OptionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/option")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllOption() {
        return new ResponseEntity<>(optionService.findAllOption(), HttpStatus.OK);
    }

    @GetMapping("/question/{questionId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Option не найден")
    })
    public ResponseEntity<?> viewOptionByQuestionId(@PathVariable @Parameter(description = "Индентификатор вопроса", example = "1") Integer questionId) {
        return new ResponseEntity<>(optionService.findByQuestionId(questionId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewOptionById(@PathVariable @Parameter(description = "Индентификатор ответа", example = "1") Integer id) {
        return new ResponseEntity<>(optionService.findOptionById(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addOption(@RequestBody @Validated OptionDTO optionDTO) {
        optionService.createOption(optionDTO);
        return new ResponseEntity<>(optionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Option не найден")
    })
    public ResponseEntity<?> updateOption(@RequestBody OptionDTO optionDTO, @PathVariable @Parameter(description = "Индентификатор ответа", example = "1") Integer id) {
        optionService.updateOption(optionDTO, id);
        return new ResponseEntity<>(optionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Option не найден")
    })
    public ResponseEntity<?> deleteOption(@PathVariable @Parameter(description = "Индентификатор ответа", example = "1") Integer id) {
        optionService.deleteOptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
