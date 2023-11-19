package com.proyecto.cita.appointment.dto.mapper;

import com.proyecto.cita.appointment.dto.request.AppointmentRequestDto;
import com.proyecto.cita.appointment.dto.response.AppointmentResponse;
import com.proyecto.cita.appointment.entity.Appointment;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.utils.FormatDate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentMapper {

    public AppointmentResponse entityToResponseDto(Appointment appointment, Person person) {
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                FormatDate.localDateTimeToString(appointment.getAppointmentDate()),
                person.getPersonName(),
                person.getPersonLastName()
        );
    }

    public AppointmentResponse entityToResponseDtos(Appointment appointment) {
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                FormatDate.localDateTimeToString(appointment.getAppointmentDate())
        );
    }

    public Appointment requestDtoToEntity(AppointmentRequestDto appointmentRequestDto, Person person) {
        return new Appointment(
                appointmentRequestDto.getAppointmentDate(),
                person
        );
    }
}
