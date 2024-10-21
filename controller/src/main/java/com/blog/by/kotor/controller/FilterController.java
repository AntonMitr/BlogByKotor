package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.FilterDTO;
import com.blog.by.kotor.service.filter.FilterService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/filter")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllFilters() {
        return new ResponseEntity<>(filterService.findAllFilter(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Filter не найден")
    })
    public ResponseEntity<?> viewFilterById(@PathVariable @Parameter(description = "Индентификатор фильтра", example = "1") Integer id) {
        return new ResponseEntity<>(filterService.findFilterById(id), HttpStatus.OK);
    }

    @GetMapping("/tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Filter не найден")
    })
    public ResponseEntity<?> viewPostsByTag(@RequestParam String criteria) {
        return new ResponseEntity<>(filterService.findByTagCriteria(criteria), HttpStatus.OK);
    }

    @GetMapping("/category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Filter не найден")
    })
    public ResponseEntity<?> viewPostsByCategory(@RequestParam String criteria) {
        return new ResponseEntity<>(filterService.findByCategoryCriteria(criteria), HttpStatus.OK);
    }

    @PostMapping("add-filter")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addFilter(@RequestBody @Validated FilterDTO filterDTO) {
        filterService.createFilter(filterDTO);
        return new ResponseEntity<>(filterDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Filter не найден")
    })
    public ResponseEntity<?> updateFilter(@RequestBody FilterDTO filterDTO, @PathVariable @Parameter(description = "Индентификатор фильтра", example = "1") Integer id) {
        filterService.updateFilter(filterDTO, id);
        return new ResponseEntity<>(filterDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Filter не найден")
    })
    public ResponseEntity<?> deleteFilterById(@PathVariable @Parameter(description = "Индентификатор фильтра", example = "1") Integer id) {
        filterService.deleteFilterById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
