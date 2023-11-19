package com.proyecto.cita.appointment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AppointmentResponse {

    @JsonProperty("appointment_id")
    private UUID appointmentId;

    @JsonProperty("appointment_date")
    private String appointmentDate;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("person_last_name")
    private String personLastName;

    public AppointmentResponse() {
    }

    public AppointmentResponse(UUID appointmentId, String appointmentDate, String personName, String personLastName) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.personName = personName;
        this.personLastName = personLastName;
    }

    public AppointmentResponse(UUID appointmentId, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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
}
