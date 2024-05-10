package org.example.restserver.dao;

import org.example.restserver.domain.model.Coach;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachDao extends ListCrudRepository<Coach, Long> {
    @Query("select c From Coach c join Users u On c.id=u.id where  u.name LIKE CONCAT(:userName, '%')")
    List<Coach> findAllByName(@Param("userName") String userName);
    Optional<Coach> findByCoachCode(String coachCode);


}