package com.proyecto.cita.incident.dto.mapper;

import com.proyecto.cita.incident.dto.request.IncidentRequestDto;
import com.proyecto.cita.incident.dto.response.IncidentResponseDto;
import com.proyecto.cita.incident.entity.Incident;
import com.proyecto.cita.utils.FormatDate;
import org.springframework.stereotype.Service;

@Service
public class IncidentMapper {

    public IncidentResponseDto entityToResponseDto(Incident incident){
        return new IncidentResponseDto(
                incident.getIncidentId(),
                incident.getIncidentDescription(),
                incident.getIncidentStatus(),
                incident.getIncidentVideo(),
                FormatDate.localDateTimeToString(incident.getIncidentDate())
        );
    }

    public Incident requestDtoToEntity(IncidentRequestDto incidentRequestDto){
        return new Incident(
                incidentRequestDto.getIncidentDescription(),
                incidentRequestDto.getIncidentStatus(),
                incidentRequestDto.getIncidentVideo(),
                incidentRequestDto.getIncidentDate()
        );
    }
}
