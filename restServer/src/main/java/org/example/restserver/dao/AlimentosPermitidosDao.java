package org.example.restserver.dao;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlimentosPermitidosDao extends ListCrudRepository<AlimentosPermitidos, Long> {
    List<AlimentosPermitidos> findAllByIddietasp(int id);
}
