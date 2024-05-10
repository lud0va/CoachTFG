package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Entrenamiento;
import org.example.restserver.domain.services.EntrenamientosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenamientos")
@CrossOrigin("http://localhost:4200/")
public class EntrenamientosRest {
    private final EntrenamientosServices serv;

    public EntrenamientosRest(EntrenamientosServices serv) {
        this.serv = serv;
    }

    @GetMapping
    public List<Entrenamiento> getEntrenamientosByCoach(@RequestParam(name = "id") int id){
        return serv.getEntrenamientosByCoachee(id);
    }

    @PostMapping
    public Entrenamiento addEntrenamiento(@RequestBody Entrenamiento entrenamiento){
       return serv.addEntrenamiento(entrenamiento);

    }

}
