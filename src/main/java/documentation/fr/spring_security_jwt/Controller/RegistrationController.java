package documentation.fr.spring_security_jwt.Controller;

//@Controller // Sert uniquement pour tester les deux pas web "Register" et "login"
public class RegistrationController {

   // @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //@GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
