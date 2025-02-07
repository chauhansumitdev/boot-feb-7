package com.example.usercrud.mapper;
import com.example.usercrud.dto.UserDTO;
import com.example.usercrud.entity.User;
import org.springframework.stereotype.Component;

/**
 * MARK: UserMapper
 * DESC: This is a mapper class for converting a dao to dto and dto to dao
 */
@Component
public class UserMapper {

    public UserDTO mapUserDAOToDTO(User user){
        return new UserDTO(user.getUuid(),user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPhoneNumber(), user.getCountry(),user.getPinCode());
    }

    public User mapUserDTOToDAO(UserDTO userDTO) {
        return new User(userDTO.getUuid(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),userDTO.getPassword(), userDTO.getPhoneNumber(), userDTO.getCountry(), userDTO.getPinCode());
    }
}
