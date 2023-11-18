package com.proyecto.cita.role.controller;

import com.proyecto.cita.role.dto.mapper.RoleMapper;
import com.proyecto.cita.role.dto.response.RoleResponseDto;
import com.proyecto.cita.role.entity.Role;
import com.proyecto.cita.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        List<RoleResponseDto> roleResponseDtos = roles.stream()
                .map(roleMapper::entityToResponseDto).toList();
        return roleResponseDtos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(roleResponseDtos);
    }
}
