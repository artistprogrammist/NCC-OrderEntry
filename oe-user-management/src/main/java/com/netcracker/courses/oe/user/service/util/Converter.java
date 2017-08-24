package com.netcracker.courses.oe.user.service.util;

import com.netcracker.courses.oe.user.dto.RoleDTO;
import com.netcracker.courses.oe.user.dto.UserDTO;
import com.netcracker.courses.oe.user.entity.Role;
import com.netcracker.courses.oe.user.entity.User;

import java.util.List;

public interface Converter {

    UserDTO toUserDTO(User user);

    List<UserDTO> toUsersDTO(List<User> users);

    User toUser(UserDTO userDTO);

    Role toRole(RoleDTO roleDTO);

    RoleDTO toRoleDTO(Role role);

    List<RoleDTO> toRolesDTO(List<Role> roles);
}
