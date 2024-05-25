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
    public List<Entrenamiento> getEntrenamientosByCoacheeEmail(String email){
        return dao.findAllByCoacheeEmail(email);
    }

    public Entrenamiento addEntrenamiento(Entrenamiento entrenamiento){
        if (dao.findByDiaSemana(entrenamiento.getDiaSemana()).isPresent()){
            //tirar excepcion personalizada
            throw new RuntimeException();
        }
        return dao.save(entrenamiento);

    }

    public Entrenamiento getEntrenamientoByDia(String dia){
        return dao.findByDiaSemana(dia).orElseThrow(RuntimeException::new);//tirar excepcion
    }

    public Entrenamiento getEntrenamiento(int id){
        //tirar una excepcion personalizada
        return dao.findById((long)id).orElseThrow(RuntimeException::new);
    }
}
