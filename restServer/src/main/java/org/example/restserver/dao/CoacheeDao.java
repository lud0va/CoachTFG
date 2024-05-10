package org.example.restserver.dao;

import org.example.restserver.domain.model.Coach;
import org.example.restserver.domain.model.Coachee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoacheeDao   extends ListCrudRepository<Coachee, Long> {
    @Query("select c From Coachee c join Users u On c.idcoachee=u.id where  u.name LIKE CONCAT(:userName, '%')")
    List<Coachee> findAllByName(@Param("userName") String userName);


    Optional<Coachee> findByIdcoach(int id);

    List<Coachee> findAllByIdcoach(int id);
}
