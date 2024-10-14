package documentation.fr.spring_security_jwt.Repository;

import documentation.fr.spring_security_jwt.Entite.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {
  Personne findByAdresseMail(String adresseMail);

}
