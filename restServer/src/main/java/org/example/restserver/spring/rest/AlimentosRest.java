package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Alimentos;
import org.example.restserver.domain.services.AlimentosServicios;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alimento")
@CrossOrigin("http://localhost:4200/")
public class AlimentosRest {
    private final AlimentosServicios servicios;

    public AlimentosRest(AlimentosServicios servicios) {
        this.servicios = servicios;
    }

    @PostMapping
    public Alimentos addAlimentosDieta(@RequestParam(name = "iddieta") int iddieta,@RequestParam(name = "cant")String cantidad,@RequestBody Alimentos alimentos){
      return servicios.addAlimentoDieta(iddieta,cantidad,alimentos);
    }
    @PostMapping
    public Alimentos addAlimentosPlato(@RequestParam(name = "idplato") int idplato,@RequestBody Alimentos alimentos){
        return servicios.addAlimentosPlato(idplato, alimentos);
    }

}
