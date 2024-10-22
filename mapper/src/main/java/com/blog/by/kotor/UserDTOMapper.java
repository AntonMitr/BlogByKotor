package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.UserDTO;
import com.blog.by.kotor.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserDTOMapper {

    private final PasswordEncoder passwordEncoder;

    public User toUser(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .createdAt(LocalDate.now())
                .build();
    }

    public User updateUser(UserDTO userDTO, User user) {
        if (userDTO.getUsername() != null) {
            user.setUsername(userDTO.getUsername());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        if (userDTO.getRoles() != null) {
            user.setRoles(userDTO.getRoles());
        }
        return user;
    }

}
