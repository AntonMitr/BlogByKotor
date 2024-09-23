package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.model.Category;
import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.model.postCategory.PostCategory;
import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.repository.*;
import com.blog.by.kotor.service.category.CategoryService;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.postCategory.PostCategoryService;
import com.blog.by.kotor.service.postTag.PostTagService;
import com.blog.by.kotor.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;

    @Lazy
    private final TagService tagService;

    @Lazy
    private final PostTagService postTagService;

    @Lazy
    private final PostService postService;

    @Lazy
    private final CategoryService categoryService;

    @Lazy
    private final PostCategoryService postCategoryService;

    @Override
    @Transactional
    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTag> postTags;

        Filter filter = filterRepository.findByCriteria(criteria);

        Tag tag = tagService.findTagByName(filter.getName());

        postTags = postTagService.findPostTagByTagId(tag.getId());
        for (PostTag postTag : postTags) {
            posts.add(postService.findPostById(postTag.getId().getPostId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public List<Post> findByCategoryCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostCategory> postCategories;

        Filter filter = filterRepository.findByCriteria(criteria);

        Category category = categoryService.findByName(filter.getName());

        postCategories = postCategoryService.findByCategoryId(category.getId());
        for (PostCategory postCategory : postCategories) {
            posts.add(postService.findPostById(postCategory.getId().getPostId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public void createFilter(Filter filter) {
        filterRepository.save(filter);
    }

    @Override
    @Transactional(readOnly = true)
    public Filter findFilterById(Integer id) {
        return filterRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Filter> findAllFilter() {
        return filterRepository.findAll();
    }

    @Override
    @Transactional
    public void updateFilter(Filter filter) {
        filterRepository.save(filter);
    }

    @Override
    @Transactional
    public void deleteFilterById(Integer id) {
        filterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFilter(Filter filter) {
        filterRepository.delete(filter);
    }

}
