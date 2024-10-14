package documentation.fr.spring_security_jwt.Entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@Entity
@Table(name = "personne")
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String adresseMail;
    private String telephone;
    private String password;

    private String rolePersonne;
}
