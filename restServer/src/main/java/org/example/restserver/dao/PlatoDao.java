package org.example.restserver.dao;

import org.example.restserver.domain.model.AlimentosPermitidos;
import org.example.restserver.domain.model.Plato;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoDao extends ListCrudRepository<Plato, Long> {

    List<Plato> findAllByIddietas(int id);
}
