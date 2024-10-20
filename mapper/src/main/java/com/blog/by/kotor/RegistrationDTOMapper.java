package com.blog.by.kotor;

import com.blog.by.kotor.dto.authentication.RegistrationDTO;
import com.blog.by.kotor.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class RegistrationDTOMapper {

    private final PasswordEncoder passwordEncoder;

    public User toUser(RegistrationDTO registrationDTO) {

        return User.builder()
                .username(registrationDTO.getUsername())
                .email(registrationDTO.getEmail())
                .password(passwordEncoder.encode(registrationDTO.getPassword()))
                .roles(registrationDTO.getRoles())
                .createdAt(LocalDate.now())
                .build();
    }

}
