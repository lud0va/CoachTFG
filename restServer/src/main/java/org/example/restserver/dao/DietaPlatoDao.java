package org.example.restserver.dao;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.example.restserver.domain.model.DietaPlato;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaPlatoDao extends ListCrudRepository<DietaPlato, Long> {
}
