package com.example.usercrud.controller;
import com.example.usercrud.dto.UserDTO;
import com.example.usercrud.entity.User;
import com.example.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * MARK: UserController
 * DESC: Controller class for user
 */
@RequestMapping("/v1")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * MARK: getHome
     * DESC: / handler
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<String> getHome(){
        return new ResponseEntity<String>("HOME", HttpStatus.OK);
    }

    /**
     * MARK: getAllProducts
     * DESC: GET /users handler for getting all users also allows pagination
     * @param page
     * @param size
     * @param sortBy
     * @param ascending
     * @return
     */
    @GetMapping("/users")
    public Page<User> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userService.getUsers(pageable);
    }

    /**
     * MARK: createUser
     * DESC: POST /users handler for creating a new user
     * @param user
     * @return
     */
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return new ResponseEntity<UserDTO>(userService.createUser(user), HttpStatus.CREATED);
    }

    /**
     * MARK: deleteUser
     * DESC: DELETE /users/{uuid} handler for deleting a user by id
     * @param uuid
     * @return
     */
    @DeleteMapping("/users/{uuid}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID uuid){
        return new ResponseEntity<String>("USER DELETED", HttpStatus.OK);
    }

    /**
     * MARK: getUserById
     * DESC: GET /users/{uuid} handler for getting a user by id
     * @param uuid
     * @return
     */
    @GetMapping("/users/{uuid}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID uuid){
        return new ResponseEntity<UserDTO>(userService.getUser(uuid), HttpStatus.OK);
    }
}
