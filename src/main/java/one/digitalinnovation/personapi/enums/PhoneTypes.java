package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum PhoneTypes {
    MOBILE("Mobile"),
    COMMERCIAL("Commercial"),
    HOME("Home");

    private final String description;
}
