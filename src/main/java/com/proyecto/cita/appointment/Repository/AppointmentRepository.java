package com.proyecto.cita.appointment.Repository;

import com.proyecto.cita.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
}
