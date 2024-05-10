package org.example.loginserver.dao;


import org.example.loginserver.domain.model.Users;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends ListCrudRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

}
