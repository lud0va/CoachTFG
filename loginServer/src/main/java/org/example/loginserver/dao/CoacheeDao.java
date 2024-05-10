package org.example.loginserver.dao;


import org.example.loginserver.domain.model.Coachee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoacheeDao  extends ListCrudRepository<Coachee, Long> {
}
