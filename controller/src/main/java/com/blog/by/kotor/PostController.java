package com.blog.by.kotor;

import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllPosts() {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPostById(@PathVariable Integer id){
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findPostByTitle(@RequestParam String title){
        return new ResponseEntity<>(postService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("order-by-date-published")
    public ResponseEntity<?> findPostByTitleOrderByDatePublished(@RequestParam String title){
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @GetMapping("/order-by-date-published")
    public ResponseEntity<?> finPostByContentContainsOrderByDatePublished(@RequestParam String title){
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        postService.createPost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId){
        postService.deletePostById(postId);
        return new ResponseEntity<>(postService.findPostById(postId), HttpStatus.OK);
    }

}
