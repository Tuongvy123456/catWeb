package com.vyntt.example.catweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vyntt.example.catweb.dto.UserDTO;
import com.vyntt.example.catweb.entity.User;
import com.vyntt.example.catweb.repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    // Get all users
    public List<UserDTO> getAllUsers() {
        return UserDTO.toUserDTOList(userRepo.findAll());
    }

    // Get user by ID
    public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            return new UserDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getAddress(),
                    user.getRole()
            );
        }
        return null;
    }

    // Create or update user
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setRole(userDTO.getRole());

        User savedUser = userRepo.save(user);
        return new UserDTO(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getPassword(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getAddress(),
                savedUser.getRole()
        );
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
