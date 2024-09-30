package com.blog.by.kotor;

import com.blog.by.kotor.service.postCategory.PostCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts-categories")
@RequiredArgsConstructor
public class PostCategoryController {

    private final PostCategoryService postCategoryService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllPostsCategories() {
        return new ResponseEntity<>(postCategoryService.findAllPostCategory(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> findPostCategoryByCategoryId(@PathVariable Integer id) {
        return new ResponseEntity<>(postCategoryService.findByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> findPostCategoryByPostId(@PathVariable Integer id) {
        return new ResponseEntity<>(postCategoryService.findByPostId(id), HttpStatus.OK);
    }



}
