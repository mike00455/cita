package com.proyecto.cita.appointment.service;

import com.proyecto.cita.appointment.Repository.AppointmentRepository;
import com.proyecto.cita.appointment.dto.mapper.AppointmentMapper;
import com.proyecto.cita.appointment.dto.request.AppointmentRequestDto;
import com.proyecto.cita.appointment.dto.response.AppointmentResponse;
import com.proyecto.cita.appointment.entity.Appointment;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.person.service.PersonService;
import com.proyecto.cita.utils.EmailService;
import com.proyecto.cita.utils.FormatDate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PersonService personService;
    private final EmailService emailService;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, PersonService personService,
                              EmailService emailService, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.personService = personService;
        this.emailService = emailService;
        this.appointmentMapper = appointmentMapper;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentResponse saveAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        Person person = personService.getPersonById(appointmentRequestDto.getPersonId());
        Appointment appointment = appointmentMapper.requestDtoToEntity(appointmentRequestDto, person);
        Appointment appointmentSaved = appointmentRepository.save(appointment);
        emailService.sendEmail(person.getPersonEmail(), "Citacion", "Presentarse en la oficina en la fecha "
                + FormatDate.localDateTimeToString(appointmentRequestDto.getAppointmentDate()));
        return appointmentMapper.entityToResponseDto(appointmentSaved, person);
    }
}
