package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Plato;
import org.example.restserver.domain.services.PlatoServicios;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
@CrossOrigin("http://localhost:4200/")
public class PlatoRest {
    private final PlatoServicios servicios;

    public PlatoRest(PlatoServicios servicios) {
        this.servicios = servicios;
    }
    @PostMapping
    public Plato addPlatoDieta(@RequestBody Plato plato){
        return servicios.addPlato(plato);
    }

    @GetMapping("/getByDieta")
    public List<Plato> getAllByDieta(@RequestParam(name = "iddieta") int iddieta){
        return servicios.getAllPlatosByDieta(iddieta);
    }

}
