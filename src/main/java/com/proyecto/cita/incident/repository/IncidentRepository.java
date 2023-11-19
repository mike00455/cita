package com.proyecto.cita.incident.repository;

import com.proyecto.cita.incident.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentRepository extends JpaRepository<Incident, UUID> {
}
