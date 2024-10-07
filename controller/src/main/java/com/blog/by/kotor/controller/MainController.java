package com.blog.by.kotor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class MainController {

    @GetMapping("/user")
    public String userAcsess(Principal principal) {
        if (principal == null)
            return null;
        return principal.getName();
    }

}
