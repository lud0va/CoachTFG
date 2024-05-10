package org.example.loginserver.dao;


import org.example.loginserver.domain.model.Coach;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachDao extends ListCrudRepository<Coach, Long> {


    Optional<Coach> findByCoachCode(String coachCode);
}
