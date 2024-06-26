package org.example.restserver.dao;

import org.example.restserver.domain.model.Coachee;
import org.example.restserver.domain.model.Dieta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DietaDao  extends ListCrudRepository<Dieta, Long> {

   @Query("SELECT c FROM Dieta c WHERE  c.idcoachee=:id ")
    List<Dieta> findAllByIdCoachee(int id);
    @Query("SELECT d FROM Dieta d " +
            "JOIN Users u ON d.idcoachee = u.id " +
            "WHERE u.email = :email")
    List<Dieta> findAllByIdCoacheeEmail(String email);
    List<Dieta>findAllByIdcoachee(int id);
}
