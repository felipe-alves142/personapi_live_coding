package one.digitalinnovation.personapi.dto.request;

import lombok.Builder;
import lombok.Data;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PersonDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2,max = 100)
    private String secondName;

    private LocalDate birthDate;


    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}
