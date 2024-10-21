package com.blog.by.kotor.service.comment;

import com.blog.by.kotor.CommentDTOMapper;
import com.blog.by.kotor.dto.model.CommentDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.model.Comment;
import com.blog.by.kotor.repository.CommentRepository;
import com.blog.by.kotor.service.post.PostService;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;
    private final CommentDTOMapper commentDTOMapper;

    @Override
    @Transactional
    public void createComment(CommentDTO commentDTO) {
        Comment comment = commentDTOMapper.toComment(commentDTO);
        comment.setUser(userService.findUserById(commentDTO.getUserId()));
        comment.setPost(postService.findPostById(commentDTO.getPostId()));
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentByPostId(Integer postId) {
        postService.findPostById(postId);
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment findCommentById(Integer id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.COMMENT_NOT_FOUND, id));
    }

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void updateComment(CommentDTO commentDTO, Integer id) {
        Comment comment = this.findCommentById(id);
        commentRepository.save(commentDTOMapper.updateComment(commentDTO, comment));
    }

    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        this.findCommentById(id);
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findByPostIdOrderByCreatedAt(Integer postId) {
        postService.findPostById(postId);
        return commentRepository.findByPostIdOrderByCreatedAt(postId);
    }

    @Override
    public List<Comment> findByUserIdOrderByCreatedAt(Integer userId) {
        userService.findUserById(userId);
        return commentRepository.findByUserIdOrderByCreatedAt(userId);
    }

}
