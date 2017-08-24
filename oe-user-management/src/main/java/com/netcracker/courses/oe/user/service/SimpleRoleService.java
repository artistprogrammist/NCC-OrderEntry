package com.netcracker.courses.oe.user.service;

import com.netcracker.courses.oe.user.dto.RoleDTO;
import com.netcracker.courses.oe.user.entity.Role;
import com.netcracker.courses.oe.user.repository.RoleRepository;
import com.netcracker.courses.oe.user.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SimpleRoleService implements RoleService {

    private final Converter converter;

    private final RoleRepository roleRepository;

    @Autowired
    public SimpleRoleService(Converter converter, RoleRepository roleRepository) {
        this.converter = converter;
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role role = converter.toRole(roleDTO);
        Role save = roleRepository.save(role);
        return converter.toRoleDTO(save);
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO) {
        return save(roleDTO);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> all = roleRepository.findAll();
        return converter.toRolesDTO(all);
    }

    @Override
    public RoleDTO getRole(Long id) {
        return converter.toRoleDTO(roleRepository.findOne(id));
    }
}
