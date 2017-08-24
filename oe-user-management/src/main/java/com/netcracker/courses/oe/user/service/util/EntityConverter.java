package com.netcracker.courses.oe.user.service.util;

import com.netcracker.courses.oe.user.dto.RoleDTO;
import com.netcracker.courses.oe.user.dto.UserDTO;
import com.netcracker.courses.oe.user.entity.Gender;
import com.netcracker.courses.oe.user.entity.Role;
import com.netcracker.courses.oe.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityConverter implements Converter {

    private static final String NONE = "NONE";
    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";

    @Override
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        if (user != null) {
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setSurname(user.getSurname());
            userDTO.setAge(user.getAge());
            userDTO.setGender(user.getGender());
            userDTO.setIdRole(user.getRole().getId());
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> toUsersDTO(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            usersDTO.add(toUserDTO(user));
        });
        return usersDTO;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO != null) {
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setAge((byte) userDTO.getAge());
            user.setGender(userDTO.getGender());
            Role role = new Role();
            role.setId(userDTO.getIdRole());
            user.setRole(role);
        }
        return user;
    }

    @Override
    public Role toRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName().toUpperCase());
        return role;
    }

    @Override
    public RoleDTO toRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName().toUpperCase());
        return roleDTO;
    }

    @Override
    public List<RoleDTO> toRolesDTO(List<Role> roles) {
        List<RoleDTO> rolesDTO = new ArrayList<>();
        roles.forEach(role -> {
            rolesDTO.add(toRoleDTO(role));
        });
        return rolesDTO;
    }

    private String toGenderString(Gender gender) {
        String genderStr = NONE;
        switch (gender) {
            case FEMALE:
                genderStr = FEMALE;
                break;
            case MALE:
                genderStr = MALE;
                break;
            default:
                break;
        }
        return genderStr;
    }

    private Gender toGender(String genderStr) {
        Gender gender = Gender.NONE;
        switch (genderStr) {
            case FEMALE:
                gender = Gender.FEMALE;
                break;
            case MALE:
                gender = Gender.MALE;
                break;
            default:
                break;
        }
        return gender;
    }
}
