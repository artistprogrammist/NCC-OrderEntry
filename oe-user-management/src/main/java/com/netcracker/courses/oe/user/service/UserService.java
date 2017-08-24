package com.netcracker.courses.oe.user.service;

import com.netcracker.courses.oe.user.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO get(Long id);

    void delete(Long id);
}
