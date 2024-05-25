package org.example.restserver.dao;

import org.example.restserver.domain.model.Ejercicios;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EjercicioDao   extends ListCrudRepository<Ejercicios, Long> {

    List<Ejercicios> findAllByIdentrenamiento(int id);

}
