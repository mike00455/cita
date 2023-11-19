package com.proyecto.cita.incident_person.service;

import com.proyecto.cita.incident.entity.Incident;
import com.proyecto.cita.incident_person.entity.IncidentPerson;
import com.proyecto.cita.incident_person.repository.IncidentPersonRepository;
import com.proyecto.cita.person.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentPersonService {

    private final IncidentPersonRepository incidentPersonRepository;

    public IncidentPersonService(IncidentPersonRepository incidentPersonRepository) {
        this.incidentPersonRepository = incidentPersonRepository;
    }

    public void saveIncidentPerson(Incident incident, List<Person> people){
        people.forEach(person -> {
            IncidentPerson incidentPerson = new IncidentPerson(
                    person,
                    incident
            );
            incidentPersonRepository.save(incidentPerson);
        });
    }
}
