package com.example.usercrud.service;

import com.example.usercrud.entity.User;
import com.example.usercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


//   public User updateUser(UUID uuid, User user) {
//        User existingUser = userRepository.findById(uuid).orElse(null);
//
//
//        return userRepository.save(existingUser);
//    }
}
