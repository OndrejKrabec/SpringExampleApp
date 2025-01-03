package cz.krabec.exampleapp.service;

import cz.krabec.exampleapp.entity.UserEntity;
import cz.krabec.exampleapp.entity.repository.UserRepository;
import cz.krabec.exampleapp.model.User;
import cz.krabec.exampleapp.model.UserUpdated;
import cz.krabec.exampleapp.model.mapper.UserMapper;
import cz.krabec.exampleapp.model.mapper.UserUpdatedMapper;
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

    @Autowired
    private UserUpdatedMapper userUpdatedMapper;

    public User getDetail(Integer id) throws EntityNotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %d not found", id)));
        return userMapper.toDTO(userEntity);
    }

    @Transactional
    public UserEntity createEntity(User newUser) {
        if (newUser == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new IllegalArgumentException("User with username " + newUser.getUsername() + " already exists");
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

    @Transactional
    public User updateEntity(Integer id, UserUpdated updatedUser) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with id %d not found", id));
        }
        UserEntity userEntity= userRepository.findById(id).get();
        String password = userEntity.getPassword();
        if(!updatedUser.getUsername().equals(userEntity.getUsername()) && userRepository.existsByUsername(updatedUser.getUsername())){
            throw new IllegalArgumentException("User with username " + updatedUser.getUsername() + " already exists");
        }

        userUpdatedMapper.toEntity(updatedUser, userEntity);
        if (updatedUser.getPassword() == null) {
            userEntity.setPassword(password); // Keep the existing password
        }
        return userMapper.toDTO(userRepository.save(userEntity));
    }
}
