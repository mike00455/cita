package com.proyecto.cita.person.controller;

import com.proyecto.cita.person.dto.mapper.PersonMapper;
import com.proyecto.cita.person.dto.request.PersonRequestDto;
import com.proyecto.cita.person.dto.response.PersonResponseDto;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

        return personResponseDtos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(personResponseDtos);
    }

    @GetMapping("/getPersonById/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable("id") UUID id){
        Person person = personService.getPersonById(id);

        if (person != null) {
            PersonResponseDto personResponseDto = personMapper.entityToResponseDto(person);
            return ResponseEntity.status(HttpStatus.OK).body(personResponseDto);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/savePerson")
    public ResponseEntity<PersonResponseDto> savePerson(@RequestBody PersonRequestDto personRequestDto){
        Person person = personService.savePerson(personRequestDto);
        PersonResponseDto personResponseDto = personMapper.entityToResponseDto(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personResponseDto);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<PersonResponseDto> updatePerson(@RequestBody PersonRequestDto personRequestDto,
                                                          @PathVariable("id") UUID id){
        Person person = personService.updatePerson(personRequestDto, id);
        PersonResponseDto personResponseDto = personMapper.entityToResponseDto(person);
        return ResponseEntity.status(HttpStatus.OK).body(personResponseDto);
    }
}
