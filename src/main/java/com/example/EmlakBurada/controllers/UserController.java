package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.services.UserService;
import lombok.RequiredArgsConstructor;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.UserSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")

public class UserController {

private final UserService userService;

@GetMapping("/get-user")
public ResponseEntity<Users> getUser(@RequestParam Long id){
    return ResponseEntity.ok(userService.getById(id));
}

@PostMapping("/create-user")
public ResponseEntity<Users> createUser(@RequestBody UserSaveRequest users){

    return ResponseEntity.ok(userService.createUser(users));
}

@PutMapping("/update-user")
public ResponseEntity<Users> updateUser(@RequestBody UserSaveRequest users) {
    return ResponseEntity.ok(userService.updateAdvert(users));
}

@GetMapping("/login")
public ResponseEntity<Users> getByLogin(
        @RequestParam String email,
        @RequestParam String password)
{
    return ResponseEntity.ok(userService.getByLogin(email,password));
    }
}
