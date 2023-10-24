package ro.alex.springonetooneapi.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.alex.springonetooneapi.exceptions.UserInvalidAgeException;
import ro.alex.springonetooneapi.models.dtos.UserDTO;
import ro.alex.springonetooneapi.models.entities.User;
import ro.alex.springonetooneapi.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    private ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }



    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if(userDTO.getAge() <= 0 || userDTO.getAge() > 150){
            throw new UserInvalidAgeException("age cannot be less than 0 or greater than 150");
        }

        User userEntity = objectMapper.convertValue(userDTO, User.class);
        User userSaveEntity = userRepository.save(userEntity);

        log.info("User created with id : {} ", userSaveEntity.getId());

        return objectMapper.convertValue(userSaveEntity, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> usersInDb = userRepository.findAll();
        List<UserDTO> response = new ArrayList<>();

        for(User user : usersInDb){
            response.add(objectMapper.convertValue(user, UserDTO.class));
        }

        return response;
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        User currentUser = userRepository.findById(id).get();
        currentUser.setId(id);
        currentUser.setFirstName(userDTO.getFirstName());
        currentUser.setLastName(userDTO.getLastName());
        currentUser.setEmail(userDTO.getEmail());
        User responseEntity = userRepository.save(objectMapper.convertValue(currentUser, User.class));
        return objectMapper.convertValue(responseEntity, UserDTO.class);

    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
