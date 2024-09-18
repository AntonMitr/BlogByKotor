package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;

    private final TagRepository tagRepository;

    private final PostTagRepository postTagRepository;

    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    private final PostCategoryRepository postCategoryRepository;

    @Override
    @Transactional
    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTagRepository> postTags;

        Filter filter = filterRepository.findByCriteria(criteria);

        Tag tag = tagRepository.findByName(filter.getName());

        postTags = postTagRepository.findPostTagByTagId(tag.getId());
        for (PostTag postTag : postTags) {
            posts.add(postRepository.getReferenceById(postTag.getId().getPostId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public List<Post> findByCategoryCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostCategory> postCategories;

        Filter filter = filterDAO.findByCriteria(criteria);

        Category category = categoryRepository.findByName(filter.getName());

        postCategories = postCategoryRepository.findPostsAndCategoriesByCategoryId(category.getId());
        for (PostCategory postCategory : postCategories) {
            posts.add(postDAO.getById(postCategory.getId().getCategoryId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public void createFilter(Filter filter) {
        filterDAO.create(filter);
    }

    @Override
    @Transactional
    public Filter getFilterById(Integer id) {
        return filterDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Filter> getAllFilter() {
        return filterDAO.getAll();
    }

    @Override
    @Transactional
    public void updateFilter(Filter filter) {
        filterDAO.update(filter);
    }

    @Override
    @Transactional
    public void deleteFilterById(Integer id) {
        filterDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFilter(Filter filter) {
        filterDAO.delete(filter);
    }

}
