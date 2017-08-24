package com.netcracker.courses.oe.user.service;

import com.netcracker.courses.oe.user.dto.UserDTO;
import com.netcracker.courses.oe.user.entity.Role;
import com.netcracker.courses.oe.user.entity.User;
import com.netcracker.courses.oe.user.exception.EntityNotFoundException;
import com.netcracker.courses.oe.user.repository.RoleRepository;
import com.netcracker.courses.oe.user.repository.UserRepository;
import com.netcracker.courses.oe.user.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    private final Converter converter;

    private final RoleRepository roleRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository, Converter converter, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = converter.toUser(userDTO);
        Role role = roleRepository.findOne(user.getRole().getId());
        if (role == null) {
            throw new EntityNotFoundException(String.format("Role entity with id=%s don't exists", user.getRole().getId()));
        }
        User save = userRepository.save(user);
        return converter.toUserDTO(save);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return save(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return converter.toUsersDTO(userRepository.findAll());
    }

    @Override
    public UserDTO get(Long id) {
        return converter.toUserDTO(userRepository.findOne(id));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
