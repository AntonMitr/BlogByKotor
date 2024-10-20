package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.PostDTO;
import com.blog.by.kotor.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllPosts() {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewPostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewPostByTitle(@RequestParam String title) {
        return new ResponseEntity<>(postService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/title/date-published-order")
    public ResponseEntity<?> viewPostByTitleOrderByDatePublished(@RequestParam String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @GetMapping("/content/date-published-order")
    public ResponseEntity<?> viewPostByContentContainsOrderByDatePublished(@RequestParam String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestBody @Validated PostDTO postDTO, @PathVariable Integer id) {
        postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody @Validated PostDTO postDTO) {
        postService.createPost(postDTO);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(postService.findPostById(postId), HttpStatus.OK);
    }

}
