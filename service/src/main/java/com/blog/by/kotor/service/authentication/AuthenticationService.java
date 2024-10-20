package com.blog.by.kotor.service.authentication;

import com.blog.by.kotor.dto.JwtResponse;
import com.blog.by.kotor.dto.authentication.LoginDTO;
import com.blog.by.kotor.dto.authentication.RegistrationDTO;

public interface AuthenticationService {

    void signup(RegistrationDTO registrationDTO);

    JwtResponse signin(LoginDTO loginDTO);

}
