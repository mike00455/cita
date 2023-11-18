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

    public Person getPersonById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(PersonRequestDto personRequestDto) {
        Person person = personMapper.requestDtoToEntity(personRequestDto);
        Role role  = roleService.getRoleById(personRequestDto.getRoleId());
        person.setRole(role);
        return personRepository.save(person);
    }

    public Person updatePerson(PersonRequestDto personRequestDto, UUID id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setPersonName(personRequestDto.getPersonName());
            person.setPersonLastName(personRequestDto.getPersonLastName());
            person.setPersonDocument(personRequestDto.getPersonDocument());
            person.setPersonPhone(personRequestDto.getPersonPhone());
            person.setPersonEmail(personRequestDto.getPersonEmail());
            Role role  = roleService.getRoleById(personRequestDto.getRoleId());
            person.setRole(role);
            return personRepository.save(person);
        }
        return null;
    }
}
