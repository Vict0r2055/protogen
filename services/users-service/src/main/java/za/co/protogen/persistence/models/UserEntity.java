package za.co.protogen.persistence.models;

//  imports
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long id;
    @Column(name = "Name")
    private String firstName;
    @Column(name = "Surname")
    private String lastName;
    @Column(name = "Birthdate")
    private LocalDate dateOfBirth;
    @Column(name = "South African ID")
    private String rsaId;

}
