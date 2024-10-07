package com.blog.by.kotor.dto;

import lombok.Data;

import java.util.Set;


@Data
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    Set<String> roles;

}
