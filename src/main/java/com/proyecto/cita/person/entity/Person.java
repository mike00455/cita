package com.proyecto.cita.person.entity;

import com.proyecto.cita.role.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "person", schema = "public")
public class Person {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "person_id", nullable = false)
    private UUID personId;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "person_last_name", nullable = false)
    private String personLastName;

    @Column(name = "person_document", nullable = false)
    private String personDocument;

    @Column(name = "person_phone")
    private String personPhone;

    @Column(name = "person_email")
    private String personEmail;

    @Column(name = "person_password")
    private String personPassword;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Person() {
    }

    public Person(String personName, String personLastName, String personDocument, String personPhone,
                  String personEmail) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.personDocument = personDocument;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
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

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
