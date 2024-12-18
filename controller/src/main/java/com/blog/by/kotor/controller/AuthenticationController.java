package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.authentication.LoginDTO;
import com.blog.by.kotor.dto.authentication.RegistrationDTO;
import com.blog.by.kotor.service.authentication.AuthenticationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@ApiResponses(@ApiResponse(responseCode = "200", useReturnTypeSchema = true))
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
            @ApiResponse(responseCode = "409", description = "Username или email пользователя уже заняты")
    })
    public ResponseEntity<?> signup(@RequestBody @Validated RegistrationDTO registrationDTO) {
        authenticationService.signup(registrationDTO);
        log.info(String.format("The user named %s has been successfully registered!", registrationDTO.getUsername()));
        return ResponseEntity.ok("User successfully registered!");
    }

    @PostMapping("/signin")

    public ResponseEntity<?> signin(@RequestBody @Validated LoginDTO loginDTO) {
        return new ResponseEntity<>(authenticationService.signin(loginDTO), HttpStatus.OK);
    }

}
