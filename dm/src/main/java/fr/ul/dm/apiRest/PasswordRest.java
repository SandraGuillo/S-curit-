package fr.ul.dm.apiRest;
import fr.ul.dm.model.*;
import fr.ul.dm.service.ServicePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //pour pouvoir appeler les get et les post
public class PasswordRest {

    @Autowired //injecté automatiquement si besoin
    private ServicePassword sp ;

    @PostMapping("/password")
    public void createEntityPassword(@RequestBody PasswordDTO pdto){
        sp.savePasswordSel(pdto);
    }
    @GetMapping("/password")
    public Iterable<Password> getPassword(){
        return sp.itPass();
    }

}
