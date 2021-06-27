package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "institutions")
@Getter @Setter @NoArgsConstructor
@ToString
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255, message = "Minimum 3 znaki")
    private String name;

    @Size(min = 3, max = 255, message = "Minimum 3 znaki")
    private String description;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private Set<Donation> donations;
}
