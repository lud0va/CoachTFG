package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Ejercicios;
import org.example.restserver.domain.services.EjercicioServices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejercicios")
@CrossOrigin("http://localhost:4200/")
public class EjerciciosRest {
    private final EjercicioServices services;

    public EjerciciosRest(EjercicioServices services) {
        this.services = services;
    }


    @PostMapping
    Ejercicios addEjercicios(@RequestBody Ejercicios ejercicios){
     return  services.addEjercicio(ejercicios);
    }
    @GetMapping
    List<Ejercicios> getEjercicios(@RequestParam(name = "idEntrenamiento") int idEntrenamiento){
        return services.getEjerciciosEntrenamiento(idEntrenamiento);
    }

}
