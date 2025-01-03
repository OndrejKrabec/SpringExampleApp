package cz.krabec.exampleapp.api.impl;

import cz.krabec.exampleapp.api.UserApi;
import cz.krabec.exampleapp.entity.repository.UserRepository;
import cz.krabec.exampleapp.model.User;
import cz.krabec.exampleapp.model.UserUpdated;
import cz.krabec.exampleapp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserApiImpl implements UserApi {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<?> userCreatePost(User newUser) {
        try {
            return ResponseEntity.ok(userService.createEntity(newUser));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}
        }

    @Override
    public ResponseEntity<String> userIdDeleteDelete(Integer id) {
        try {
            userService.deleteEntity(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> userIdDetailGet(Integer id) {
        try {
            return ResponseEntity.ok(userService.getDetail(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> userIdUpdatePut(Integer id, UserUpdated updatedUser) {
        try {
            return ResponseEntity.ok(userService.updateEntity(id,updatedUser));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<User>> userListGet(String sortDirection, String sortField) {
        return ResponseEntity.ok(userService.getListAll());
    }
}
