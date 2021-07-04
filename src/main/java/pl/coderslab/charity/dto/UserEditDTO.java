package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor
@ToString
public class UserEditDTO {

    private Long id;

    @Size(min = 3, max = 255, message = "Minimum 3 znaki")
    private String firstName;

    @Size(min = 3, max = 255, message = "Minimum 3 znaki")
    private String lastName;
}
