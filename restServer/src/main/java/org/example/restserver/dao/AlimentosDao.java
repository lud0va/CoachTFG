package org.example.restserver.dao;

import org.example.restserver.domain.model.Alimentos;
import org.example.restserver.domain.model.AlimentosPermitidos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentosDao extends ListCrudRepository<Alimentos, Long> {

}
