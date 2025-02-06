package com.example.usercrud.controller;
import com.example.usercrud.entity.User;
import com.example.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{uuid}")
    public void deleteUser(@PathVariable UUID uuid){
        userService.deleteUser(uuid);
    }

    @PutMapping("/user/{uuid}")
    public User getUserById(@PathVariable UUID uuid){
        return userService.getUser(uuid);
    }

//    @PutMapping("/update/user/{uuid}")
//    public User updateUser(@PathVariable UUID uuid, @RequestBody User user){
//        return userService.updateUser(uuid, user);
//    }

}
