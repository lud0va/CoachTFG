package org.example.restserver.domain.services;

import org.example.restserver.dao.AlimentosPermitidosDao;
import org.example.restserver.domain.model.AlimentosPermitidos;
import org.springframework.stereotype.Service;

@Service
public class AlimentosPermitidosServices {
    private final AlimentosPermitidosDao dao;


    public AlimentosPermitidosServices(AlimentosPermitidosDao dao) {
        this.dao = dao;
    }
    public AlimentosPermitidos addAlimentoPermitido(AlimentosPermitidos alimentosPermitidos){
        return dao.save(alimentosPermitidos);
    }
}
