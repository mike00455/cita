package com.proyecto.cita.person.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PersonRequestDto {

    @JsonProperty(value = "person_name", required = true)
    private String personName;

    @JsonProperty(value = "person_last_name", required = true)
    private String personLastName;

    @JsonProperty(value = "person_document", required = true)
    private String personDocument;

    @JsonProperty(value = "person_phone")
    private String personPhone;

    @JsonProperty(value = "person_email")
    private String personEmail;

    @JsonProperty(value = "role_id", required = true)
    private UUID roleId;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonDocument() {
        return personDocument;
    }

    public void setPersonDocument(String personDocument) {
        this.personDocument = personDocument;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }
}
