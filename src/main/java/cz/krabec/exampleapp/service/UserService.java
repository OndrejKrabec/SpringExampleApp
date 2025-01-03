package cz.krabec.exampleapp.service;

import cz.krabec.exampleapp.entity.UserEntity;
import cz.krabec.exampleapp.entity.repository.UserRepository;
import cz.krabec.exampleapp.model.User;
import cz.krabec.exampleapp.model.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User getDetail(Integer id) throws EntityNotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found", id)));
        return userMapper.toDTO(userEntity);
    }

    @Transactional
    public UserEntity createEntity(User newUser) {
        if (newUser == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // Perform any additional business logic or validations if needed

        return userRepository.save(userMapper.toEntity(newUser)); // Save the user entity to the database
    }

    public void deleteEntity(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with id %d not found", id));
        }
        userRepository.deleteById(id);
    }

    public List<User> getListAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    public User updateEntity(Integer id,User updatedUser) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with id %d not found", id));
        }
        UserEntity userEntity= userRepository.findById(id).get();
        userMapper.toEntity(updatedUser, userEntity);
        return userMapper.toDTO(userRepository.save(userEntity));
    }
}
