package com.example.usercrud.exceptions;

/**
 * MARK: UserNotFound
 * DESC: A custom exception if the user does not exist
 */
public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){
        super(message);
    }
}
