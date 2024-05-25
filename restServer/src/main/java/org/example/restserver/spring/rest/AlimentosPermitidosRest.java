package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.example.restserver.domain.services.AlimentosPermitidosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentosPermitidos")
@CrossOrigin("http://localhost:4200/")
public class AlimentosPermitidosRest {
    private final AlimentosPermitidosServices services;

    public AlimentosPermitidosRest(AlimentosPermitidosServices services) {
        this.services = services;
    }

    @PostMapping
    public AlimentosPermitidos addAlimentosPermitidos(@RequestBody AlimentosPermitidos alimentosPermitidos ){
        return services.addAlimentoPermitido(alimentosPermitidos);
    }
    @GetMapping("/byDietaId")
    public List<AlimentosPermitidos> getAllByDieta(@RequestParam(name = "iddieta")int iddieta){
        return services.getAlimentosPermitiodosDieta(iddieta);
    }
}
