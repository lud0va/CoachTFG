package org.example.restserver.dao;

import org.example.restserver.domain.model.PlatoAlimentosElem;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoAlimentoDao extends ListCrudRepository<PlatoAlimentosElem, Long> {
}
