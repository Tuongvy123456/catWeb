package com.vyntt.example.catweb.dto;

import java.util.List;

import com.vyntt.example.catweb.entity.Role;
import com.vyntt.example.catweb.entity.User;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long userId, String userName, String password, String email, String phone, String address, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(user -> new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getRole()
        )).toList();
    }
}