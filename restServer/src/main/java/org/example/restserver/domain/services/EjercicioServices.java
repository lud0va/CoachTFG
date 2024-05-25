package org.example.restserver.domain.services;

import org.example.restserver.dao.EjercicioDao;
import org.example.restserver.domain.model.Ejercicios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioServices {
    private final EjercicioDao dao;

    public EjercicioServices(EjercicioDao dao) {
        this.dao = dao;
    }

   public Ejercicios addEjercicio(Ejercicios ejercicios){
        return dao.save(ejercicios);
    }
    public List<Ejercicios> getEjerciciosEntrenamiento(int idEntrenamiento){
        List<Ejercicios> s=dao.findAllByIdentrenamiento(idEntrenamiento);
        return s;
    }

}
