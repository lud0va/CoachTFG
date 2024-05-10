package org.example.restserver.dao;

import org.example.restserver.domain.model.Coach;
import org.example.restserver.domain.model.Coachee;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenamientoDao extends ListCrudRepository<Entrenamiento, Long> {
    @Query("select c From Entrenamiento c where c.coachee.idcoachee=:id")
    List<Entrenamiento> findAllByCoachee( int id);
}
