package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.example.restserver.domain.services.AlimentosPermitidosServices;
import org.springframework.web.bind.annotation.*;

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
}
