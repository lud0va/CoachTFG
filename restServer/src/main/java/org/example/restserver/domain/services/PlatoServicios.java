package org.example.restserver.domain.services;

import org.example.restserver.dao.DietaPlatoDao;
import org.example.restserver.dao.PlatoDao;
import org.example.restserver.domain.model.Dieta;
import org.example.restserver.domain.model.DietaPlato;
import org.example.restserver.domain.model.DietaPlatoId;
import org.example.restserver.domain.model.Plato;
import org.springframework.stereotype.Service;

@Service
public class PlatoServicios {
    private final PlatoDao dao;
    private final DietaPlatoDao dietaPlatoDao;

    public PlatoServicios(PlatoDao dao, DietaPlatoDao dietaPlatoDao) {
        this.dao = dao;
        this.dietaPlatoDao = dietaPlatoDao;
    }
    public Plato addPlato(int idDieta,Plato plato){
       Plato p= dao.save(plato);
        dietaPlatoDao.save(new DietaPlato(new DietaPlatoId(),idDieta,p.getId()));
        return p;
    }
}
