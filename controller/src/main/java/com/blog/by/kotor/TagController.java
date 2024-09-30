package com.blog.by.kotor;

import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<?> getAllTags() {
        return new ResponseEntity<>(tagService.findAllTag(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTagById(@PathVariable Integer id) {
        return new ResponseEntity<>(tagService.findTagById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getTagByName(@RequestParam String name) {
        return new ResponseEntity<>(tagService.findTagByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTag(@RequestBody Tag tag) {
        tagService.createTag(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
