package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.TagDTO;
import com.blog.by.kotor.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllTags() {
        return new ResponseEntity<>(tagService.findAllTag(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewTagById(@PathVariable Integer id) {
        return new ResponseEntity<>(tagService.findTagById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewTagByName(@RequestParam String name) {
        return new ResponseEntity<>(tagService.findTagByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTag(@RequestBody @Validated TagDTO tagDTO) {
        tagService.createTag(tagDTO);
        return new ResponseEntity<>(tagDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTag(@RequestBody @Validated TagDTO tagDTO, @PathVariable Integer id) {
        tagService.updateTag(tagDTO, id);
        return new ResponseEntity<>(tagDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
