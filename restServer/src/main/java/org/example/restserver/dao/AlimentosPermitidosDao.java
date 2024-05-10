package org.example.restserver.dao;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentosPermitidosDao extends ListCrudRepository<AlimentosPermitidos, Long> {
}
