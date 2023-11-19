package com.proyecto.cita.incident.controller;

import com.proyecto.cita.incident.dto.mapper.IncidentMapper;
import com.proyecto.cita.incident.dto.request.IncidentRequestDto;
import com.proyecto.cita.incident.dto.response.IncidentResponseDto;
import com.proyecto.cita.incident.entity.Incident;
import com.proyecto.cita.incident.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    private final IncidentService incidentService;
    private final IncidentMapper incidentMapper;

    public IncidentController(IncidentService incidentService, IncidentMapper incidentMapper) {
        this.incidentService = incidentService;
        this.incidentMapper = incidentMapper;
    }

    @GetMapping("/getAllIncidents")
    public ResponseEntity<List<IncidentResponseDto>> getAllIncidents(){
        List<Incident> incidents = incidentService.getAllIncidents();
        List<IncidentResponseDto> incidentResponseDtos = incidents.stream()
                .map(incidentMapper::entityToResponseDto).toList();

        return incidentResponseDtos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(incidentResponseDtos);
    }

    @PostMapping("/saveIncident")
    public ResponseEntity<IncidentResponseDto> saveIncident(@RequestBody IncidentRequestDto incidentRequestDto){
        Incident incident = incidentService.saveIncident(incidentRequestDto);
        IncidentResponseDto incidentResponseDto = incidentMapper.entityToResponseDto(incident);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidentResponseDto);
    }
}
