package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllComments() {
        return new ResponseEntity<>(commentService.findAllComment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewCommentById(@PathVariable Integer id) {
        return new ResponseEntity<>(commentService.findCommentById(id), HttpStatus.OK);
    }

    @GetMapping("/post/{posId}")
    public ResponseEntity<?> viewCommentsByPostId(@PathVariable Integer postId) {
        return new ResponseEntity<>(commentService.findCommentByPostId(postId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}/order-by-created")
    public ResponseEntity<?> viewByPostIdOrderByCreatedAt(@RequestParam Integer postId) {
        return new ResponseEntity<>(commentService.findByPostIdOrderByCreatedAt(postId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/order-by-created")
    public ResponseEntity<?> viewByUserIdOrderByCreatedAt(@RequestParam Integer userId) {
        return new ResponseEntity<>(commentService.findByUserIdOrderByCreatedAt(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable Integer id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
