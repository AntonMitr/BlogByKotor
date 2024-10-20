package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.OptionDTO;
import com.blog.by.kotor.service.option.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllOption() {
        return new ResponseEntity<>(optionService.findAllOption(), HttpStatus.OK);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> viewOptionByQuestionId(@PathVariable Integer questionId) {
        return new ResponseEntity<>(optionService.findByQuestionId(questionId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewOptionById(@PathVariable Integer id) {
        return new ResponseEntity<>(optionService.findOptionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOption(@RequestBody @Validated OptionDTO optionDTO) {
        optionService.createOption(optionDTO);
        return new ResponseEntity<>(optionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOption(@RequestBody @Validated OptionDTO optionDTO, @PathVariable Integer id) {
        optionService.updateOption(optionDTO, id);
        return new ResponseEntity<>(optionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOption(@PathVariable Integer id) {
        optionService.deleteOptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
