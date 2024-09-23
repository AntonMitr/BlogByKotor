package com.blog.by.kotor.service.postTag;

import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.repository.PostTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostTagServiceImpl implements PostTagService {

    private final PostTagRepository postTagRepository;

    @Override
    @Transactional
    public void createPostTag(PostTag postTag) {
        postTagRepository.save(postTag);
    }

    @Override
    @Transactional(readOnly = true)
    public PostTag findPostTagById(Integer id) {
        return postTagRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostTag> findPostTagByTagId(Integer id) {
        return postTagRepository.findPostTagByTagId(id);
    }

    @Override
    @Transactional(readOnly = true)
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
    public void deletePostTagById(Integer id) {
        postTagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePostTag(PostTag postTag) {
        postTagRepository.delete(postTag);
    }

}
