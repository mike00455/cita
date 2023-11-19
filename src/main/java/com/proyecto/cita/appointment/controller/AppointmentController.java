package com.proyecto.cita.appointment.controller;

import com.proyecto.cita.appointment.dto.mapper.AppointmentMapper;
import com.proyecto.cita.appointment.dto.request.AppointmentRequestDto;
import com.proyecto.cita.appointment.dto.response.AppointmentResponse;
import com.proyecto.cita.appointment.entity.Appointment;
import com.proyecto.cita.appointment.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        List<AppointmentResponse> appointmentResponseDtos = appointments.stream()
                .map(appointmentMapper::entityToResponseDtos).toList();

        return appointmentResponseDtos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(appointmentResponseDtos);
    }

    @PostMapping("/saveAppointment")
    public ResponseEntity<AppointmentResponse> enviarCorreo(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        AppointmentResponse appointment = appointmentService.saveAppointment(appointmentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }
}
