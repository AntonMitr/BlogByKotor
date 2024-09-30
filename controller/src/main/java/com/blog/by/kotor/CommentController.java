package com.blog.by.kotor;

import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllComments() {
        return new ResponseEntity<>(commentService.findAllComment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCommentById(@PathVariable Integer id) {
        return new ResponseEntity<>(commentService.findCommentById(id), HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<?> findCommentsByPostId(@RequestParam Integer postId) {
        return new ResponseEntity<>(commentService.findCommentByPostId(postId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/post/order-by-created")
    public ResponseEntity<?> findByPostIdOrderByCreatedAt(@RequestParam Integer postId) {
        return new ResponseEntity<>(commentService.findByPostIdOrderByCreatedAt(postId), HttpStatus.OK);
    }

    @GetMapping("/user/order-by-created")
    public ResponseEntity<?> findByUserIdOrderByCreatedAt(@RequestParam Integer userId) {
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
