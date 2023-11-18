package com.proyecto.cita.role.dto.mapper;

import com.proyecto.cita.role.dto.response.RoleResponseDto;
import com.proyecto.cita.role.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper {

    public RoleResponseDto entityToResponseDto(Role role){
        return new RoleResponseDto(
                role.getRoleId(),
                role.getRoleName(),
                role.getRoleDescription()
        );
    }
}
