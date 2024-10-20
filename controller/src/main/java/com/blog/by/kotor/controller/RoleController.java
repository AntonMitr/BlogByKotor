package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.RoleDTO;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> getAllRoles() {
        return new ResponseEntity<>(roleService.findAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id) {
        return new ResponseEntity<>(roleService.findRoleById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getRoleByName(@RequestParam ERole name) {
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addRole(@RequestBody @Validated RoleDTO roleDTO) {
        roleService.createRole(roleDTO);
        return new ResponseEntity<>(roleDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateRole(@RequestBody @Validated RoleDTO roleDTO, @PathVariable Integer id) {
        roleService.updateRole(roleDTO, id);
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
