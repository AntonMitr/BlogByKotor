package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.RoleDTO;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.service.role.RoleService;
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
@RequestMapping("/v1/role")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> getAllRoles() {
        return new ResponseEntity<>(roleService.findAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Role не найден")
    })
    public ResponseEntity<?> getRoleById(@PathVariable @Parameter(description = "Индентификатор роли", example = "1") Integer id) {
        return new ResponseEntity<>(roleService.findRoleById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Role не найден")
    })
    public ResponseEntity<?> getRoleByName(@RequestParam @Parameter(description = "Имя роли", example = "ROLE_USER") ERole name) {
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addRole(@RequestBody @Validated RoleDTO roleDTO) {
        roleService.createRole(roleDTO);
        return new ResponseEntity<>(roleDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Role не найден")
    })
    public ResponseEntity<?> updateRole(@RequestBody RoleDTO roleDTO, @PathVariable @Parameter(description = "Индентификатор роли", example = "1") Integer id) {
        roleService.updateRole(roleDTO, id);
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Role не найден")
    })
    public ResponseEntity<?> deleteRole(@PathVariable @Parameter(description = "Индентификатор роли", example = "1") Integer id) {
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
