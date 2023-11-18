package com.proyecto.cita.person.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequestDto {

    @JsonProperty(value = "person_name", required = true)
    private String personName;

    @JsonProperty(value = "person_last_name", required = true)
    private String PersonLastName;

    @JsonProperty(value = "person_document", required = true)
    private String PersonDocument;

    @JsonProperty(value = "person_phone")
    private String PersonPhone;

    @JsonProperty(value = "person_email")
    private String PersonEmail;

    @JsonProperty(value = "role_id", required = true)
    private String roleId;



    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastName() {
        return PersonLastName;
    }

    public void setPersonLastName(String personLastName) {
        PersonLastName = personLastName;
    }

    public String getPersonDocument() {
        return PersonDocument;
    }

    public void setPersonDocument(String personDocument) {
        PersonDocument = personDocument;
    }

    public String getPersonPhone() {
        return PersonPhone;
    }

    public void setPersonPhone(String personPhone) {
        PersonPhone = personPhone;
    }

    public String getPersonEmail() {
        return PersonEmail;
    }

    public void setPersonEmail(String personEmail) {
        PersonEmail = personEmail;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
