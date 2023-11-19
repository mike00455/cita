package com.proyecto.cita.appointment.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentRequestDto {

    @JsonProperty(value = "person_id", required = true)
    private UUID personId;

    @JsonProperty(value = "appointment_date", required = true)
    private LocalDateTime appointmentDate;

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
