package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import one.digitalinnovation.personapi.enums.PhoneTypes;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Enumerated(EnumType.STRING)
    @Column
    @NonNull
    private PhoneTypes type;


    @Column(unique = true)
    @NonNull
    private String number;
}
