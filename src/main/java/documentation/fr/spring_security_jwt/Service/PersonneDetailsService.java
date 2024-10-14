package documentation.fr.spring_security_jwt.Service;

import documentation.fr.spring_security_jwt.Entite.Personne;
import documentation.fr.spring_security_jwt.Repository.PersonneRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class PersonneDetailsService implements UserDetailsService {

    private final PersonneRepository personneRepository;

    @Override
    public UserDetails loadUserByUsername(String adresseMail) throws UsernameNotFoundException {
        Personne personne = personneRepository.findByAdresseMail(adresseMail);

        if (personne == null) {
            throw new UsernameNotFoundException("User not found with email: " + adresseMail);
        }
        return new User(
                personne.getAdresseMail(),
                personne.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(personne.getRolePersonne()))
                );
    }
}

