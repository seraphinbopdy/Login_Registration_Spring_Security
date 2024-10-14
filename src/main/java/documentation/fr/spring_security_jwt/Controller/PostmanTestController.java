package documentation.fr.spring_security_jwt.Controller;

import documentation.fr.spring_security_jwt.Entite.Personne;
import documentation.fr.spring_security_jwt.Repository.PersonneRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor

public class PostmanTestController {

    private final PersonneRepository personneRepository;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerPersonne(@RequestBody Personne personne){
        if(personneRepository.findByAdresseMail(personne.getAdresseMail())!=null){
            ResponseEntity.badRequest().body("username are already exist");
        }
        personne.setPassword(passwordEncoder.encode(personne.getPassword()));
        return ResponseEntity.ok(personneRepository.save(personne));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPersonne(@RequestBody Personne personne ){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(personne.getAdresseMail(),
                    personne.getPassword()));

            return ResponseEntity.ok("Login succesfull");
        } catch (Exception exception){
            return    ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username Password");
        }
    }

}
