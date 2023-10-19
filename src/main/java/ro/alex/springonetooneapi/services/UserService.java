package ro.alex.springonetooneapi.services;

import ro.alex.springonetooneapi.models.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(long id, UserDTO userDTO);

    void deleteUser(long userId);




}
