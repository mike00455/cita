package com.proyecto.cita.appointment.entity;

import com.proyecto.cita.person.entity.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointment", schema = "public")
public class Appointment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    @Column(name = "appointment_id", nullable = false)
    private UUID appointmentId;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
