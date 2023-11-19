package com.proyecto.cita.incident_person.repository;

import com.proyecto.cita.incident_person.entity.IncidentPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentPersonRepository extends JpaRepository<IncidentPerson, UUID> {
}
