package org.example.restserver.domain.services;

import org.example.restserver.dao.CoacheeDao;
import org.example.restserver.dao.EntrenamientoDao;
import org.example.restserver.domain.errors.DiaRepetidoException;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenamientosServices {

    private final EntrenamientoDao dao;
    public EntrenamientosServices(EntrenamientoDao dao) {
        this.dao = dao;
    }

    public List<Entrenamiento> getEntrenamientosByCoachee(int id){
        return dao.findAllByCoachee(id);
    }
    public List<Entrenamiento> getEntrenamientosByCoacheeEmail(String email){
        return dao.findAllByCoacheeEmail(email);
    }

    public Entrenamiento addEntrenamiento(Entrenamiento entrenamiento){
        if (dao.findByDiaSemana(entrenamiento.getDiaSemana()).isPresent()){
            throw new DiaRepetidoException();
        }
        return dao.save(entrenamiento);

    }

    public Entrenamiento getEntrenamientoByDia(String dia){
        Optional<Entrenamiento> entrenamiento= dao.findByDiaSemana(dia);
        if(entrenamiento.isPresent()){
            return entrenamiento.get();
        }
        return  null;//tirar excepcion
    }

    public Entrenamiento getEntrenamiento(int id){
        //tirar una excepcion personalizada
        Optional<Entrenamiento> entrenamiento=  dao.findById(Long.valueOf(id));
        if(entrenamiento.isPresent()) {
            return entrenamiento.get();
        }
        return null;
    }
}
