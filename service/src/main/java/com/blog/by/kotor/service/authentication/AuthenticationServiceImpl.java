package com.blog.by.kotor.service.authentication;

import com.blog.by.kotor.dto.JwtResponse;
import com.blog.by.kotor.dto.authentication.LoginDTO;
import com.blog.by.kotor.dto.authentication.RegistrationDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.signup.SignupException;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.model.security.JwtCore;
import com.blog.by.kotor.model.security.UserDetailsImpl;
import com.blog.by.kotor.service.role.RoleService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtCore jwtCore;

    private final UserService userService;

    private final RoleService roleService;

    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public void signup(RegistrationDTO registrationDTO) {
        if (userService.existsByUsername(registrationDTO.getUsername())) {
            log.error(String.format("The user with the name %s already exists", registrationDTO.getUsername()));
            throw new SignupException(ErrorCode.SIGNUP_USERNAME, registrationDTO.getUsername());
        }

        if (userService.existsByEmail(registrationDTO.getEmail())) {
            log.error(String.format("User with mail %s already exists", registrationDTO.getEmail()));
            throw new SignupException(ErrorCode.SIGNUP_EMAIL, registrationDTO.getEmail());
        }

        List<String> stringRoles = registrationDTO.getStringRoles();
        ArrayList<Role> roles = new ArrayList<>();

        if (stringRoles == null) {
            Role userRole = roleService
                    .findRoleByName(ERole.ROLE_USER);
            roles.add(userRole);
        } else {
            stringRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role admin = roleService
                                .findRoleByName(ERole.ROLE_ADMIN);
                        roles.add(admin);

                        break;

                    case "ROLE_MODERATOR":
                        Role modRole = roleService
                                .findRoleByName(ERole.ROLE_MODERATOR);
                        roles.add(modRole);

                        break;

                    default:
                        Role userRole = roleService
                                .findRoleByName(ERole.ROLE_USER);
                        roles.add(userRole);
                }
            });
        }

        registrationDTO.setRoles(roles);
        userService.createUser(registrationDTO);
    }

    @Override
    public JwtResponse signin(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
        );
    }

}
