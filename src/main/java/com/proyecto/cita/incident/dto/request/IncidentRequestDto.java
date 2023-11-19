package com.proyecto.cita.incident.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class IncidentRequestDto {

    @JsonProperty(value = "incident_description")
    private String incidentDescription;

    @JsonProperty(value = "incident_status")
    private String incidentStatus;

    @JsonProperty(value = "incident_video")
    private String incidentVideo;

    @JsonProperty(value = "incident_date")
    private LocalDateTime incidentDate;

    @JsonProperty(value = "person_ids")
    private List<UUID> personIds;

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

    public List<UUID> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(List<UUID> personIds) {
        this.personIds = personIds;
    }
}
