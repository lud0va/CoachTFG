package org.example.restserver.dao;

import org.example.restserver.domain.model.Coach;
import org.example.restserver.domain.model.Coachee;
import org.example.restserver.domain.model.Entrenamiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrenamientoDao extends ListCrudRepository<Entrenamiento, Long> {
    @Query("select c From Entrenamiento c where c.coachee.idcoachee=:id")
    List<Entrenamiento> findAllByCoachee( int id);

    @Query("SELECT c FROM Entrenamiento c " +
            "JOIN c.coachee s " +
            "JOIN Users u ON s.idcoachee = u.id " +
            "WHERE u.email = :email")
    List<Entrenamiento> findAllByCoacheeEmail( String email);



    Optional<Entrenamiento> findByDiaSemana(String diaSem);
}
