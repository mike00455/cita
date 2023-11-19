package com.proyecto.cita.incident.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class IncidentResponseDto {

    @JsonProperty(value = "incident_id")
    private UUID incidentId;

    @JsonProperty(value = "incident_description")
    private String incidentDescription;

    @JsonProperty(value = "incident_status")
    private String incidentStatus;

    @JsonProperty(value = "incident_video")
    private String incidentVideo;

    @JsonProperty(value = "incident_date")
    private String incidentDate;

    public IncidentResponseDto() {
    }

    public IncidentResponseDto(UUID incidentId, String incidentDescription, String incidentStatus, String incidentVideo,
                               String incidentDate) {
        this.incidentId = incidentId;
        this.incidentDescription = incidentDescription;
        this.incidentStatus = incidentStatus;
        this.incidentVideo = incidentVideo;
        this.incidentDate = incidentDate;
    }

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

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }
}
