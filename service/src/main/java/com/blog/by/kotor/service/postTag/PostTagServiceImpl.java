package com.blog.by.kotor.service.postTag;

import com.blog.by.kotor.exception.NotNullParam;
import com.blog.by.kotor.exception.create.CreateExceptionFactory;
import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.repository.PostTagRepository;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostTagServiceImpl implements PostTagService {

    private final PostTagRepository postTagRepository;

    private final PostService postService;

    private final TagService tagService;

    @Override
    @Transactional
    public void createPostTag(PostTag postTag) {
        if(postTag.getId().getPostId() == null){
            throw new CreateException(ErrorCode.POST_TAG_POST_ID);
        }
        if(postTag.getId().getTagId() == null){
            throw new CreateException(ErrorCode.POST_TAG_TAG_ID);
        }
        postTagRepository.save(postTag);
    }

    @Override
    public List<PostTag> findPostTagByTagId(Integer id) {
        tagService.findTagById(id);
        return postTagRepository.findPostTagByTagId(id);
    }

    @Override
    public List<PostTag> findAllPostTag() {
        return postTagRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePostTag(PostTag postTag) {
        postTagRepository.save(postTag);
    }

    @Override
    @Transactional
    public void deletePostTag(PostTag postTag) {
        postService.findPostById(postTag.getId().getPostId());
        tagService.findTagById(postTag.getId().getTagId());
        postTagRepository.delete(postTag);
    }

}
