package com.netcracker.courses.oe.user.service;

import com.netcracker.courses.oe.user.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO save(RoleDTO roleDTO);

    RoleDTO update(RoleDTO roleDTO);

    List<RoleDTO> getAllRoles();

    RoleDTO getRole(Long id);
}
