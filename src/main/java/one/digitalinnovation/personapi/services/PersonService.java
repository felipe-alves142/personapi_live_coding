package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper= PersonMapper.INSTANCE;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@Valid PersonDTO personDTO){
        Person savedToPerson = personMapper.toModel(personDTO);

        Person savedPerson  = personRepository.save(savedToPerson);
        return MessageResponseDTO
                .builder()
                .message("Nova pessoa foi criada" + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople= personRepository.findAll();
              return allPeople.stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }
}
