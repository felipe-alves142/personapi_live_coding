package one.digitalinnovation.personapi.util;

import one.digitalinnovation.personapi.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneTypes;

public class PhoneUtils {
    private static String Phone_Number;
    private static PhoneTypes type = PhoneTypes.COMMERCIAL;
    private static long ID=1l;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO
                .builder()
                .number(Phone_Number)
                .type(type)
                .id(ID)
                .build();
    }
    public static Phone createFakeEntity(){
        return  Phone
                .builder()
                .number(Phone_Number)
                .type(type)
                .id(ID)
                .build();
    }
}
