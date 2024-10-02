package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Option;
import com.blog.by.kotor.service.option.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/view-options")
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

    @PostMapping("/add-option")
    public ResponseEntity<?> addOption(@RequestBody Option option) {
        optionService.createOption(option);
        return new ResponseEntity<>(option, HttpStatus.CREATED);
    }

    @PutMapping("/update-option")
    public ResponseEntity<?> updateOption(@RequestBody Option option) {
        optionService.updateOption(option);
        return new ResponseEntity<>(option, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOption(@RequestBody Integer id) {
        optionService.deleteOptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
