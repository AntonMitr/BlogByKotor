package com.blog.by.kotor.service.user;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.blog.by.kotor.exception.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(User user) {
        if (user.getId() == null) {
            throw new CreateException(ErrorCode.USER_ID);
        }
        if (user.getEmail() == null) {
            throw new CreateException(ErrorCode.USER_EMAIL);
        }
        if (user.getName() == null) {
            throw new CreateException(ErrorCode.USER_NAME);
        }
        if (user.getPassword() == null) {
            throw new CreateException(ErrorCode.USER_PASSWORD);
        }
        if (user.getCreatedAt() == null) {
            throw new CreateException(ErrorCode.USER_CREATED_AT);
        }
        userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(USER_NOT_FOUND, id));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.findById(user.getId())
                .orElseThrow(() -> new UpdateException(USER_NOT_FOUND, user.getId()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.findById(id)
                .orElseThrow(() -> new DeleteException((USER_NOT_FOUND), id));
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.findById(user.getId())
                .orElseThrow(() -> new DeleteException(USER_NOT_FOUND, user.getId()));
        userRepository.deleteById(user.getId());
    }

}
