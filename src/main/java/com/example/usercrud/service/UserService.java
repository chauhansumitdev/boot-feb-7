package com.example.usercrud.service;

import com.example.usercrud.dto.UserDTO;
import com.example.usercrud.entity.User;
import com.example.usercrud.exceptions.UserNotFound;
import com.example.usercrud.mapper.UserMapper;
import com.example.usercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;


/**
 * MARK: UserService
 * DESC: This is a user service class
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    /**
     * MARK: createUser
     * DESC: Create a new user
     * @param user
     * @return
     */
    public UserDTO createUser(UserDTO user){
        return userMapper.mapUserDAOToDTO(userRepository.save(userMapper.mapUserDTOToDAO(user)));
    }

    /**
     * MARK: getUser
     * DESC: User to get a user using is
     * @param id
     * @return
     * @throws UserNotFound
     */
    public UserDTO getUser(UUID id) throws UserNotFound{
        UserDTO userdto = userMapper.mapUserDAOToDTO(userRepository.findById(id).orElse(null));

        if(userdto == null){
            throw new UserNotFound("User Not Found");
        }else{
            return userdto;
        }
    }

    /**
     * MARK: deleteUser
     * DESC: Deletes a user that corresponds to a particular id
     * @param id
     */
    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }


    /**
     * MARK: getUsers
     * DESC: Returns  pages for users
     * @param pageable
     * @return
     */
    public Page<User> getUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
