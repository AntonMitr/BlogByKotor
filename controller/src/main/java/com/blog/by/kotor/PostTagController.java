package com.blog.by.kotor;

import com.blog.by.kotor.service.postTag.PostTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/posts-tags")
@RequiredArgsConstructor
public class PostTagController {

    private final PostTagService postTagService;

}
