package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.UserSaveRequest;
import com.example.EmlakBurada.converter.UserConverter;
import com.example.EmlakBurada.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Users getById(Long id){
        return userRepository.findById(id).get();
    }

    public Users createUser(UserSaveRequest users) {
        Users users1 = UserConverter.toUsers(users);
        return userRepository.save(users1);
    }

    public Users updateAdvert(UserSaveRequest users) {
        Users users1 = UserConverter.toUsers(users);
        return userRepository.save(users1);
    }

    public Users getUser(Long id) {
        return userRepository.getById(id);
    }

    public boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }

    public Users getByLogin(String email, String password) {
        Users users = userRepository.findByEmailAndPassword(email,password);
        if (users == null) {
            return null;
        } else {
            return users;
        }
    }
}
