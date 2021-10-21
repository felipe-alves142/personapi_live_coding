package one.digitalinnovation.personapi.services;

import exeption.PersonNotFoundExeption;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO createPerson(@Valid PersonDTO personDTO){
        Person savedToPerson = personMapper.toModel(personDTO);
        Person savedPerson  = personRepository.save(savedToPerson);

        MessageResponseDTO messageResponse = responseMessage("Person created with id ", savedPerson.getId());
        return messageResponse;
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople= personRepository.findAll();
              return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundExeption {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundExeption {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updatePerson(Long id,PersonDTO personDTO) {
        Person savedToPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(savedToPerson);

        MessageResponseDTO messageResponse = responseMessage("Person created with id ", savedPerson.getId());

        return messageResponse;
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExeption {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundExeption(id));

        return person;
    }



    private MessageResponseDTO responseMessage(String s , Long id2) {
        return MessageResponseDTO
                .builder()
                .message(s + id2)
                .build();
    }
}
