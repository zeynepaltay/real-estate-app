package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.UserSaveRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Users getById(Long id);

    Users createUser(UserSaveRequest users);

    Users updateAdvert(UserSaveRequest users);

    Users getUser(Long id);

    Users getByLogin(String email, String password);
}
