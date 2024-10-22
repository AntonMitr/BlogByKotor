package com.blog.by.kotor.service.authentication;

import com.blog.by.kotor.dto.JwtResponse;
import com.blog.by.kotor.dto.SigninRequest;
import com.blog.by.kotor.dto.SignupRequest;
import com.blog.by.kotor.model.ERole;
import com.blog.by.kotor.model.Role;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.model.security.JwtCore;
import com.blog.by.kotor.model.security.UserDetailsImpl;
import com.blog.by.kotor.service.role.RoleService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtCore jwtCore;

    private final UserService userService;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public void signup(SignupRequest signupRequest) {
        if (userService.existsByUsername(signupRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Chose different username");
        }

        if (userService.existsByEmail(signupRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Chose different email");
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        Set<ERole> enumRoles = signupRequest.getRoles();
        List<Role> roles = new ArrayList<>();

        if (enumRoles == null) {
            Role userRole = roleService
                    .findRoleByName(ERole.ROLE_USER);
            roles.add(userRole);
        } else {
            enumRoles.forEach(role -> {
                switch (role.name()) {
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
        user.setRoles(roles);
        userService.createUser(user);
    }

    @Override
    public JwtResponse signin(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        signinRequest.getUsername(),
                        signinRequest.getPassword()
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
