package org.example.restserver.domain.services;

import org.example.restserver.dao.DietaDao;
import org.example.restserver.domain.model.Dieta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietasServices {
    private final DietaDao dao;

    public DietasServices(DietaDao dao) {
        this.dao = dao;
    }
    public List<Dieta> getDietasDeCoachee(int id){
        return dao.findAllByIdCoachee(id);
    }
    public Dieta addDieta(Dieta dieta){
        return dao.save(dieta);
    }
}
