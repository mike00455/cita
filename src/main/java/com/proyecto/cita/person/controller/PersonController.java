package com.proyecto.cita.person.controller;

import com.proyecto.cita.person.dto.mapper.PersonMapper;
import com.proyecto.cita.person.dto.response.PersonResponseDto;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping("/getAllPeople")
    public ResponseEntity<List<PersonResponseDto>> getAllPeople(){
        List<Person> people = personService.getAllPeople();
        List<PersonResponseDto> personResponseDtos = people.stream()
                .map(personMapper::entityToResponseDto).toList();

        return personResponseDtos.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.status(HttpStatus.OK).body(personResponseDtos);
    }

    @GetMapping("/getPersonById/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable("id") String id){
        Person person = personService.getPersonById(id);

        if (person != null) {
            PersonResponseDto personResponseDto = personMapper.entityToResponseDto(person);
            return ResponseEntity.ok(personResponseDto);
        }

        return ResponseEntity.noContent().build();
    }
}
