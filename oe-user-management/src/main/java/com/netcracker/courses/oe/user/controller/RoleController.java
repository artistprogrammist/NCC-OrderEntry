package com.netcracker.courses.oe.user.controller;

import com.netcracker.courses.oe.user.dto.RoleDTO;
import com.netcracker.courses.oe.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user-management/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO save(@RequestBody RoleDTO roleDTO) {
        return roleService.save(roleDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO update(@RequestBody RoleDTO roleDTO) {
        return roleService.update(roleDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDTO> getAll() {
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO get(@PathVariable("id") Long id) {
        return roleService.getRole(id);
    }
}
