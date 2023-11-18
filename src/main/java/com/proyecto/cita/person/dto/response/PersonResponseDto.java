package com.proyecto.cita.person.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PersonResponseDto {

    @JsonProperty(value = "person_id")
    private UUID personId;

    @JsonProperty(value = "person_name")
    private String personName;

    @JsonProperty(value = "person_last_name")
    private String personLastName;

    @JsonProperty(value = "person_document")
    private String personDocument;

    @JsonProperty(value = "person_phone")
    private String personPhone;

    @JsonProperty(value = "person_email")
    private String personEmail;

    @JsonProperty(value = "role_name")
    private String roleName;

    public PersonResponseDto() {
    }

    public PersonResponseDto(UUID personId, String personName, String personLastName, String personDocument,
                             String personPhone, String personEmail, String roleName) {
        this.personId = personId;
        this.personName = personName;
        this.personLastName = personLastName;
        this.personDocument = personDocument;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
        this.roleName = roleName;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
