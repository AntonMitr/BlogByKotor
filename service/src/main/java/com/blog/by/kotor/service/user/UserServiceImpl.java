package com.blog.by.kotor.service.user;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.exception.update.UpdateException;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.model.security.UserDetailsImpl;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.blog.by.kotor.exception.ErrorCode.USER_NAME_NOT_FOUND;
import static com.blog.by.kotor.exception.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(User user) {
        if (user.getEmail() == null) {
            throw new CreateException(ErrorCode.USER_EMAIL);
        }
        if (user.getUsername() == null) {
            throw new CreateException(ErrorCode.USER_NAME);
        }
        if (user.getPassword() == null) {
            throw new CreateException(ErrorCode.USER_PASSWORD);
        }
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(new Date());
        }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {

        User user1 = userRepository.findByUsername(username).orElseThrow(() -> new FindByNameException(USER_NAME_NOT_FOUND, username));
        return user1;

    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
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
