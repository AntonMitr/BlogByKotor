package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.CategoryDTO;
import com.blog.by.kotor.service.category.CategoryService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Category не найдена"),
    })
    public ResponseEntity<?> viewCategoryById(@PathVariable @Parameter(description = "Индентификатор категории", example = "1") Integer id) {
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Category не найдена"),
    })
    public ResponseEntity<?> viewCategoryByName(@RequestParam @Parameter(description = "Название категории", example = "Спорт") String name) {
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addCategory(@RequestBody @Validated CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Category не найдена")
    })
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable @Parameter(description = "Индентификатор категории", example = "1") Integer id) {
        categoryService.updateCategory(categoryDTO, id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Category не найдена")
    })
    public ResponseEntity<?> deleteCategory(@PathVariable @Parameter(description = "Индентификатор категории", example = "1") Integer id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
