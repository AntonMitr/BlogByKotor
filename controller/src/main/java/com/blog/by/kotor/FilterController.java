package com.blog.by.kotor;

import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.service.filter.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/filtes")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllFilters(){
        return new ResponseEntity<>(filterService.findAllFilter(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findFilterById(@PathVariable Integer id){
        return new ResponseEntity<>(filterService.findFilterById(id), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<?> findPostsByTag(@RequestParam String criteria){
        return new ResponseEntity<>(filterService.findByTagCriteria(criteria), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> findPostsByCategory(@RequestParam String criteria){
        return new ResponseEntity<>(filterService.findByCategoryCriteria(criteria), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createFilter(@RequestBody Filter filter){
        filterService.createFilter(filter);
        return new ResponseEntity<>(filter, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateFilter(@RequestBody Filter filter){
        filterService.updateFilter(filter);
        return new ResponseEntity<>(filter, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilterById(@PathVariable Integer id){
        filterService.deleteFilterById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
