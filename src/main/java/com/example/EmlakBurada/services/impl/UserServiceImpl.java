package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.UserSaveRequest;
import com.example.EmlakBurada.converter.UserConverter;
import com.example.EmlakBurada.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Users getById(Long id){
        if(id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Users createUser(UserSaveRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("User request must not be null.");
        }
        Users users = UserConverter.toUsers(request);
        return userRepository.save(users);
    }

    public Users updateAdvert(UserSaveRequest request){
        if (request == null) {
            throw new IllegalArgumentException("User request must not be null.");
        }
        if (!userRepository.existsById(request.getId())) {
            throw new EntityNotFoundException("User not found with id: " + request.getId());
        }
        Users users = UserConverter.toUsers(request);
        return userRepository.save(users);
    }

    public Users getUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID must not be null.");
        }

        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Users getByLogin(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new EntityNotFoundException("Invalid login credentials."));
    }
}
