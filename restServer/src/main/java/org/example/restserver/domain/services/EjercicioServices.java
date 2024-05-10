package org.example.restserver.domain.services;

import org.example.restserver.dao.EjercicioDao;
import org.example.restserver.domain.model.Ejercicios;
import org.springframework.stereotype.Service;

@Service
public class EjercicioServices {
    private final EjercicioDao dao;

    public EjercicioServices(EjercicioDao dao) {
        this.dao = dao;
    }

   public Ejercicios addEjercicio(Ejercicios ejercicios){
        return dao.save(ejercicios);
    }
}
