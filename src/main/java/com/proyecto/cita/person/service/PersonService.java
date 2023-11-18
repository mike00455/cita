package com.proyecto.cita.person.service;

import com.proyecto.cita.person.dto.mapper.PersonMapper;
import com.proyecto.cita.person.dto.request.PersonRequestDto;
import com.proyecto.cita.person.entity.Person;
import com.proyecto.cita.person.repository.PersonRepository;
import com.proyecto.cita.role.entity.Role;
import com.proyecto.cita.role.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final RoleService roleService;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper, RoleService roleService) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.roleService = roleService;
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(String id) {
        return personRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public Person savePerson(PersonRequestDto personRequestDto) {
        Person person = personMapper.requestDtoToEntity(personRequestDto);
        Role role  = roleService.getRoleById(UUID.fromString(personRequestDto.getRoleId()));
        person.setRole(role);
        return personRepository.save(person);
    }
}
