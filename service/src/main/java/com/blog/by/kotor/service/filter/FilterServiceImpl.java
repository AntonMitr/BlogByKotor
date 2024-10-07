package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
import com.blog.by.kotor.model.Category;
import com.blog.by.kotor.model.Filter;
import com.blog.by.kotor.model.Post;
import com.blog.by.kotor.model.Tag;
import com.blog.by.kotor.model.postCategory.PostCategory;
import com.blog.by.kotor.model.postTag.PostTag;
import com.blog.by.kotor.repository.FilterRepository;
import com.blog.by.kotor.service.category.CategoryService;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.postCategory.PostCategoryService;
import com.blog.by.kotor.service.postTag.PostTagService;
import com.blog.by.kotor.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;

    private final TagService tagService;

    private final PostTagService postTagService;

    private final PostService postService;

    private final CategoryService categoryService;

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
        if (filter.getId() == null) {
            throw new CreateException(ErrorCode.FILTER_ID);
        }
        if (filter.getCriteria() == null) {
            throw new CreateException(ErrorCode.FILTER_CRITERIA);
        }
        if (filter.getName() == null) {
            throw new CreateException(ErrorCode.FILTER_ID);
        }
        filterRepository.save(filter);
    }

    @Override
    public Filter findFilterById(Integer id) {
        return filterRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.FILTER_NOT_FOUND, id));
    }

    @Override
    public List<Filter> findAllFilter() {
        return filterRepository.findAll();
    }

    @Override
    @Transactional
    public void updateFilter(Filter filter) {
        filterRepository.findById(filter.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.FILTER_NOT_FOUND, filter.getId()));
        filterRepository.save(filter);
    }

    @Override
    @Transactional
    public void deleteFilterById(Integer id) {
        filterRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.FILTER_NOT_FOUND, id));
        filterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFilter(Filter filter) {
        filterRepository.findById(filter.getId())
                .orElseThrow(() -> new DeleteException(ErrorCode.FILTER_NOT_FOUND, filter.getId()));
        filterRepository.delete(filter);
    }

}
