package com.proyecto.cita.role.service;

import com.proyecto.cita.role.entity.Role;
import com.proyecto.cita.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(UUID id) {
        return roleRepository.findById(id).orElse(null);
    }

}
