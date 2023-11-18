package com.proyecto.cita.person.dto.mapper;

import com.proyecto.cita.person.dto.request.PersonRequestDto;
import com.proyecto.cita.person.dto.response.PersonResponseDto;
import com.proyecto.cita.person.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonResponseDto entityToResponseDto(Person person){
        return new PersonResponseDto(
                person.getPersonId(),
                person.getPersonName(),
                person.getPersonLastName(),
                person.getPersonDocument(),
                person.getPersonPhone(),
                person.getPersonEmail(),
                person.getRole().getRoleName()
        );
    }

    public Person requestDtoToEntity(PersonRequestDto personRequestDto){
        return new Person(
                personRequestDto.getPersonName(),
                personRequestDto.getPersonLastName(),
                personRequestDto.getPersonDocument(),
                personRequestDto.getPersonPhone(),
                personRequestDto.getPersonEmail()
        );
    }
}
