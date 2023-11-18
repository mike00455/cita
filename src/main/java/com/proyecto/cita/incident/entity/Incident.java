package com.proyecto.cita.incident.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "incident", schema = "public")
public class Incident {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    @Column(name = "incident_id", nullable = false)
    private UUID incidentId;

    @Column(name = "incident_description", nullable = false)
    private String incidentDescription;

    @Column(name = "incident_status", nullable = false)
    private String incidentStatus;

    @Column(name = "incident_video")
    private String incidentVideo;

    @Column(name = "incident_date", nullable = false)
    private LocalDateTime incidentDate;

    public UUID getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(UUID incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentDescription() {
        return incidentDescription;
    }

    public void setIncidentDescription(String incidentDescription) {
        this.incidentDescription = incidentDescription;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public String getIncidentVideo() {
        return incidentVideo;
    }

    public void setIncidentVideo(String incidentVideo) {
        this.incidentVideo = incidentVideo;
    }

    public LocalDateTime getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDateTime incidentDate) {
        this.incidentDate = incidentDate;
    }
}
