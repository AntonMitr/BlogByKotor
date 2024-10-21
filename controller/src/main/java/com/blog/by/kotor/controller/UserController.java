package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.UserDTO;
import com.blog.by.kotor.service.user.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> viewAllUsers() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User не найден")
    })
    public ResponseEntity<?> viewUserById(@PathVariable @Parameter(description = "Индентификатор пользователя", example = "1") Integer id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User не найден")
    })
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable @Parameter(description = "Индентификатор пользователя", example = "1") Integer id) {
        userService.updateUser(userDTO, id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User не найден")
    })
    public ResponseEntity<?> deleteUserById(@PathVariable @Parameter(description = "Индентификатор пользователя", example = "1") Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
