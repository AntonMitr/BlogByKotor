package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.CommentDTO;
import com.blog.by.kotor.service.comment.CommentService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class CommentController {

    public final CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllComments() {
        return new ResponseEntity<>(commentService.findAllComment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> viewCommentById(@PathVariable @Parameter(description = "Индентификатор комментария", example = "1") Integer id) {
        return new ResponseEntity<>(commentService.findCommentById(id), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> viewCommentsByPostId(@PathVariable @Parameter(description = "Индентификатор статьи", example = "1") Integer postId) {
        return new ResponseEntity<>(commentService.findCommentByPostId(postId), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addComment(@RequestBody @Validated CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
        return new ResponseEntity<>(commentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}/order-by-created")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> viewByPostIdOrderByCreatedAt(@PathVariable @Parameter(description = "Индентификатор поста", example = "1") Integer postId) {
        return new ResponseEntity<>(commentService.findByPostIdOrderByCreatedAt(postId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/order-by-created")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> viewByUserIdOrderByCreatedAt(@PathVariable  @Parameter(description = "Индентификатор пользователя", example = "1")Integer userId) {
        return new ResponseEntity<>(commentService.findByUserIdOrderByCreatedAt(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> updateComment(@RequestBody CommentDTO commentDTO, @PathVariable @Parameter(description = "Индентификатор комментария", example = "1") Integer id) {
        commentService.updateComment(commentDTO, id);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comment не найден")
    })
    public ResponseEntity<?> deleteCommentById(@PathVariable @Parameter(description = "Индентификатор комментария", example = "1") Integer id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
