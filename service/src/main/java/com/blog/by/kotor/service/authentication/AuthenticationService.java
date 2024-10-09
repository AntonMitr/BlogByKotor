package com.blog.by.kotor.service.authentication;

import com.blog.by.kotor.dto.JwtResponse;
import com.blog.by.kotor.dto.SigninRequest;
import com.blog.by.kotor.dto.SignupRequest;

public interface AuthenticationService {

    void signup(SignupRequest signupRequest);

    JwtResponse signin(SigninRequest signinRequest);

}
