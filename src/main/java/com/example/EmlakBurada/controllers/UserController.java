package com.example.EmlakBurada.controllers;

import lombok.RequiredArgsConstructor;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.UserSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EmlakBurada.services.UserService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class UserController {
UserService userService;
@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}
@GetMapping("/getuser")
public Users getUser(@RequestParam("id") Long id){
    return userService.getById(id);
}
@PostMapping("/createuser")
public Users createUser(@RequestBody UserSaveRequest users){
    return userService.createUser(users);
}
@PutMapping("/updateuser")
public Users updateUser(@RequestBody UserSaveRequest users) {
    return userService.updateAdvert(users);
}
@DeleteMapping("/deleteupdate")
public boolean deleteUpdate(@RequestParam("id") Long id){
    return userService.deleteUser(id);
}
    @GetMapping("/login")
    public Users getByLogin(@RequestParam("email") String email,@RequestParam("password") String password){
    return userService.getByLogin(email,password);
    }
}
