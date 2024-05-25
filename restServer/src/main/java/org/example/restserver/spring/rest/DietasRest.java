package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Dieta;
import org.example.restserver.domain.services.DietasServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dietas")
@CrossOrigin("http://localhost:4200/")
public class DietasRest {
    private final DietasServices serv;

    public DietasRest(DietasServices serv) {
        this.serv = serv;
    }
    @GetMapping
    public List<Dieta> getDietasDeCoachee(@RequestParam(name = "id") int id){
        return serv.getDietasDeCoachee(id);
    }
    @PostMapping
    public Dieta addDieta(@RequestBody Dieta dieta){
        return serv.addDieta(dieta);
    }

    @GetMapping("/byId")
    private Dieta getDieta(@RequestParam(name = "id") int id){
        return serv.getDieta(id);
    }
    @GetMapping("/byEmail")
    public List<Dieta> getDietasDeCoacheByEmail(@RequestParam(name = "email") String email){
        return serv.getDietasDeCoacheEmail(email);
    }
}
