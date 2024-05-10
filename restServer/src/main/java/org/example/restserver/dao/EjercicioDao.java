package org.example.restserver.dao;

import org.example.restserver.domain.model.Ejercicios;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.data.repository.ListCrudRepository;

public interface EjercicioDao   extends ListCrudRepository<Ejercicios, Long> {
}
