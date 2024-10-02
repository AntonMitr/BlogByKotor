package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/view-posts")
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

    @GetMapping("/title/order-by-date-published")
    public ResponseEntity<?> viewPostByTitleOrderByDatePublished(@RequestParam String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @GetMapping("/content/order-by-date-published")
    public ResponseEntity<?> viewPostByContentContainsOrderByDatePublished(@RequestParam String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @PutMapping("/update-post")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        postService.updatePost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/add-post")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        postService.createPost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(postService.findPostById(postId), HttpStatus.OK);
    }

}
