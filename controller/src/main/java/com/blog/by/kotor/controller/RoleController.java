package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRoles() {
        return new ResponseEntity<>(roleService.findAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id) {
        return new ResponseEntity<>(roleService.findRoleById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getRoleByName(@RequestParam String name) {
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        roleService.createRole(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
