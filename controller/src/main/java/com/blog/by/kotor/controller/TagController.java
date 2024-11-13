package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.TagDTO;
import com.blog.by.kotor.service.tag.TagService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tag")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class TagController {

    private final TagService tagService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllTags() {
        return new ResponseEntity<>(tagService.findAllTag(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Tag не найден")
    })
    public ResponseEntity<?> viewTagById(@PathVariable @Parameter(description = "Индентификатор тега", example = "1") Integer id) {
        return new ResponseEntity<>(tagService.findTagById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Tag не найден")
    })
    public ResponseEntity<?> viewTagByName(@RequestParam @Parameter(description = "Название тега", example = "блог") String name) {
        return new ResponseEntity<>(tagService.findTagByName(name), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addTag(@RequestBody @Validated TagDTO tagDTO) {
        tagService.createTag(tagDTO);
        return new ResponseEntity<>(tagDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Tag не найден")
    })
    public ResponseEntity<?> updateTag(@RequestBody TagDTO tagDTO, @PathVariable @Parameter(description = "Индентификатор тега", example = "1") Integer id) {
        tagService.updateTag(tagDTO, id);
        return new ResponseEntity<>(tagDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Tag не найден")
    })
    public ResponseEntity<?> deleteTag(@PathVariable @Parameter(description = "Индентификатор тега", example = "1") Integer id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
