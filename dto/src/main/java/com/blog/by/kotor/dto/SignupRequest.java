package com.blog.by.kotor.dto;

import com.blog.by.kotor.model.ERole;
import lombok.Data;

import java.util.Set;


@Data
public class SignupRequest {

    private Set<ERole> roles;
    private String username;
    private String email;
    private String password;

}
