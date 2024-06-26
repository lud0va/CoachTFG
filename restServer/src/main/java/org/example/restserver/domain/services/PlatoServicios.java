package org.example.restserver.domain.services;

import org.example.restserver.dao.PlatoDao;
import org.example.restserver.domain.model.Plato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServicios {
    private final PlatoDao dao;

    public PlatoServicios(PlatoDao dao) {
        this.dao = dao;
    }
    public Plato addPlato(Plato plato){
       Plato p= dao.save(plato);
        return p;
    }

    public List<Plato> getAllPlatosByDieta(int id){
        return dao.findAllByIddietas(id);
    }
}
