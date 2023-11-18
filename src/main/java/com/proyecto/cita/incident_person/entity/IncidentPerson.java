package com.proyecto.cita.incident_person.entity;

import com.proyecto.cita.incident.entity.Incident;
import com.proyecto.cita.person.entity.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "incident_person", schema = "public")
public class IncidentPerson {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    @Column(name = "incident_person_id", nullable = false)
    private UUID incidentPersonId;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;


    public UUID getIncidentPersonId() {
        return incidentPersonId;
    }

    public void setIncidentPersonId(UUID incidentPersonId) {
        this.incidentPersonId = incidentPersonId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
