package org.example.restserver.domain.services;

import org.example.restserver.dao.AlimentosDao;
import org.example.restserver.dao.AlimentosPermitidosDao;
import org.example.restserver.dao.PlatoAlimentoDao;
import org.example.restserver.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentosServicios {
  private final   AlimentosDao dao;
  private final AlimentosPermitidosDao alimentosPermitidosDao;
  private final PlatoAlimentoDao platoAlimentoDao;

    public AlimentosServicios(AlimentosDao dao, AlimentosPermitidosDao alimentosPermitidosDao, PlatoAlimentoDao platoAlimentoDao) {
        this.dao = dao;
        this.alimentosPermitidosDao = alimentosPermitidosDao;
        this.platoAlimentoDao = platoAlimentoDao;
    }

    public Alimentos addAlimento(Alimentos alimentos){
       Alimentos alimento= dao.save(alimentos);
        return alimento;
    }
    public List<Alimentos> getAllAlimentos(){
        return dao.findAll();
    }

}
