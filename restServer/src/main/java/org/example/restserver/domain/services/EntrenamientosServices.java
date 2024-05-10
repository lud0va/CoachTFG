package org.example.restserver.domain.services;

import org.example.restserver.dao.CoacheeDao;
import org.example.restserver.dao.EntrenamientoDao;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenamientosServices {

    private final EntrenamientoDao dao;
    private final CoacheeDao cdao;
    public EntrenamientosServices(EntrenamientoDao dao, CoacheeDao cdao) {
        this.dao = dao;
        this.cdao = cdao;
    }

    public List<Entrenamiento> getEntrenamientosByCoachee(int id){
        return dao.findAllByCoachee(id);
    }
    public Entrenamiento addEntrenamiento(Entrenamiento entrenamiento){

        return dao.save(entrenamiento);
    }

}
