package com.proyecto.cita.role.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class RoleResponseDto {

    @JsonProperty(value = "role_id")
    private UUID roleId;

    @JsonProperty(value = "role_name")
    private String roleName;

    @JsonProperty(value = "role_description")
    private String roleDescription;

    public RoleResponseDto() {
    }

    public RoleResponseDto(UUID roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
