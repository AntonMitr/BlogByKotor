package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.CategoryDTO;
import com.blog.by.kotor.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewCategoryById(@PathVariable Integer id) {
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> viewCategoryByName(@RequestParam String name) {
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody @Validated CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody @Validated CategoryDTO categoryDTO, @PathVariable Integer id) {
        categoryService.updateCategory(categoryDTO, id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
