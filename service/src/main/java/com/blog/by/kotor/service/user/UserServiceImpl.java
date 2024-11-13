package com.blog.by.kotor.service.user;

import com.blog.by.kotor.RegistrationDTOMapper;
import com.blog.by.kotor.UserDTOMapper;
import com.blog.by.kotor.dto.authentication.RegistrationDTO;
import com.blog.by.kotor.dto.model.UserDTO;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.model.User;
import com.blog.by.kotor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.blog.by.kotor.exception.ErrorCode.USER_NAME_NOT_FOUND;
import static com.blog.by.kotor.exception.ErrorCode.USER_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RegistrationDTOMapper registrationDTOMapper;

    private final UserRepository userRepository;

    private final UserDTOMapper userDTOMapper;

    @Override
    @Transactional
    public void createUser(RegistrationDTO registrationDTO) {
        userRepository.save(registrationDTOMapper.toUser(registrationDTO));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new FindByNameException(USER_NAME_NOT_FOUND, username));
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
    public void updateUser(UserDTO userDTO, Integer id) {
        User user = this.findUserById(id);
        userRepository.save(userDTOMapper.updateUser(userDTO, user));
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

}
