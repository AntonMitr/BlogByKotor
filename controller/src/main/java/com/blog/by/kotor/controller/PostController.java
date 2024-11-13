package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.PostDTO;
import com.blog.by.kotor.service.post.PostService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(description = "200", useReturnTypeSchema = true))
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllPosts() {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Post не найден")
    })
    public ResponseEntity<?> viewPostById(@PathVariable @Parameter(description = "Индентификатор поста", example = "1") Integer id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewPostByTitle(@RequestParam @Parameter(description = "Заголовок поста", example = "Всё о ведении блога в 2024") String title) {
        return new ResponseEntity<>(postService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/title/date-published-order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Post не найден")
    })
    public ResponseEntity<?> viewPostByTitleOrderByDatePublished(@RequestParam @Parameter(description = "Заголовок поста", example = "Всё о ведении блога в 2024") String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @GetMapping("/content/date-published-order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Post не найден")
    })
    public ResponseEntity<?> viewPostByContentContainsOrderByDatePublished(@RequestParam @Parameter(description = "Заголовок поста", example = "Всё о ведении блога в 2024") String title) {
        return new ResponseEntity<>(postService.findByTitleOrderByDatePublished(title), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Post не найден")
    })
    public ResponseEntity<?> updatePost(@RequestBody PostDTO postDTO, @PathVariable @Parameter(description = "Индентификатор поста", example = "1") Integer id) {
        postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addPost(@RequestBody @Validated PostDTO postDTO) {
        postService.createPost(postDTO);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Post не найден")
    })
    public ResponseEntity<?> deletePost(@PathVariable @Parameter(description = "Индентификатор поста", example = "1") Integer postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(postService.findPostById(postId), HttpStatus.OK);
    }

}
