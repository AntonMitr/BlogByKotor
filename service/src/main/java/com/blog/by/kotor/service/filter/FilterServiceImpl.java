package com.blog.by.kotor.service.filter;

import com.blog.by.kotor.FilterDTOMapper;
import com.blog.by.kotor.dto.model.FilterDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
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

    private final FilterDTOMapper filterDTOMapper;

    @Override
    public Filter findById(Integer id) {
        return filterRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.FILTER_NOT_FOUND, id));
    }

    @Override
    public Filter findByCriteria(String criteria) {
        return filterRepository.findByCriteria(criteria)
                .orElseThrow(() -> new RuntimeException("Фильра по данной criteria не существует"));
    }

    @Override
    @Transactional
    public List<Post> findByTagCriteria(String criteria) {
        List<Post> posts = new ArrayList<>();
        List<PostTag> postTags;

        Filter filter = this.findByCriteria(criteria);

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

        Filter filter = this.findByCriteria(criteria);

        Category category = categoryService.findByName(filter.getName());

        postCategories = postCategoryService.findByCategoryId(category.getId());
        for (PostCategory postCategory : postCategories) {
            posts.add(postService.findPostById(postCategory.getId().getPostId()));
        }
        return posts;
    }

    @Override
    @Transactional
    public void createFilter(FilterDTO filterDTO) {
        Filter filter = filterDTOMapper.toFilter(filterDTO);
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
    public void updateFilter(FilterDTO filterDTO, Integer id) {
        Filter filter = this.findFilterById(id);
        filterRepository.save(filterDTOMapper.updateFilter(filterDTO, filter));
    }

    @Override
    @Transactional
    public void deleteFilterById(Integer id) {
        this.findFilterById(id);
        filterRepository.deleteById(id);
    }

}
