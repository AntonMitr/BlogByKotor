package com.blog.by.kotor.dto;

import lombok.Data;

import java.util.Set;


@Data
public class SignupRequest {

    Set<String> roles;
    private String username;
    private String email;
    private String password;

}
