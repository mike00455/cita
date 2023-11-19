package com.proyecto.cita.incident.service;

import com.proyecto.cita.incident.dto.mapper.IncidentMapper;
import com.proyecto.cita.incident.dto.request.IncidentRequestDto;
import com.proyecto.cita.incident.entity.Incident;
import com.proyecto.cita.incident.repository.IncidentRepository;
import com.proyecto.cita.incident_person.service.IncidentPersonService;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.person.service.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final PersonService personService;
    private final IncidentPersonService incidentPersonService;
    private final IncidentMapper incidentMapper;

    public IncidentService(IncidentRepository incidentRepository, PersonService personService,
                           IncidentPersonService incidentPersonService, IncidentMapper incidentMapper) {
        this.incidentRepository = incidentRepository;
        this.personService = personService;
        this.incidentPersonService = incidentPersonService;
        this.incidentMapper = incidentMapper;
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident getIncidentById(UUID id) {
        return incidentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Incident saveIncident(IncidentRequestDto incidentRequestDto) {
        Incident incident = incidentMapper.requestDtoToEntity(incidentRequestDto);
        Incident incidentSaved = incidentRepository.save(incident);
        List<Person> people = incidentRequestDto.getPersonIds().stream()
                .map(personService::getPersonById).toList();
        System.out.println(people.size());

        incidentPersonService.saveIncidentPerson(incidentSaved, people);

        return incidentSaved;
    }

}
