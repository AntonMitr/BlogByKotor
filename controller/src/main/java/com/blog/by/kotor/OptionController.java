package com.blog.by.kotor;

import com.blog.by.kotor.model.Option;
import com.blog.by.kotor.service.option.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllOption() {
        return new ResponseEntity<>(optionService.findAllOption(), HttpStatus.OK);
    }

    @GetMapping("/question")
    public ResponseEntity<?> findOptionByQuestionId(@RequestParam Integer questionId) {
        return new ResponseEntity<>(optionService.findByQuestionId(questionId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOptionById(@PathVariable Integer id) {
        return new ResponseEntity<>(optionService.findOptionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOption(@RequestBody Option option) {
        optionService.createOption(option);
        return new ResponseEntity<>(option, HttpStatus.CREATED);
    }

    @PutMapping
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
