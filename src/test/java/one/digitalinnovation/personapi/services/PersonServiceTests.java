package one.digitalinnovation.personapi.services;


import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.util.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.util.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {

    @Mock
    private PersonService personService;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonRepository personRepository;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedPersonSaved = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedPersonSaved);
        when(personRepository.save(any(Person.class))).thenReturn(expectedPersonSaved);

        MessageResponseDTO expectedSucessMessage = createExpectedMessage(expectedPersonSaved.getId());
        MessageResponseDTO sucessResponse = personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage,sucessResponse);
    }
        private MessageResponseDTO createExpectedMessage(Long savedPersonId){
            return MessageResponseDTO
                    .builder()
                    .message("Person created with id " + savedPersonId)
                    .build();
        }
}
