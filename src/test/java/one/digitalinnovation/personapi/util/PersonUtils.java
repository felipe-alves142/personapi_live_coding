package one.digitalinnovation.personapi.util;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.entity.Person;


import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "Felipe";
    private static final String SECOND_NAME= "Alves";
    private static final String CPF_NUMBER="2222";
    private static final long ID = 1l;
    private static final LocalDate Birth_Date = LocalDate.of(2021,20,10);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.
                builder()
                .firstName(FIRST_NAME)
                .secondName(SECOND_NAME)
                .cpf(CPF_NUMBER)
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .id(ID)
                .build();
    }
    public static Person createFakeEntity(){
        return Person.
                builder()
                .firstName(FIRST_NAME)
                .secondName(SECOND_NAME)
                .cpf(CPF_NUMBER)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .id(ID)
                .build();
    }

}
