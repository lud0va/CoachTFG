package org.example.restserver.dao;

import org.example.restserver.domain.model.Users;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends ListCrudRepository<Users, Long> {
    Optional<Users> findByEmail(String email);


}
