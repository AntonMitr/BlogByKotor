package com.blog.by.kotor;

import com.blog.by.kotor.service.userRole.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

}
