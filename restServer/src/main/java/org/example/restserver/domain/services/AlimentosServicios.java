package org.example.restserver.domain.services;

import org.example.restserver.dao.AlimentosDao;
import org.example.restserver.dao.AlimentosPermitidosDao;
import org.example.restserver.dao.PlatoAlimentoDao;
import org.example.restserver.domain.model.*;
import org.springframework.stereotype.Service;

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

    public Alimentos addAlimentoDieta(int iddieta,String cant,Alimentos alimentos){
       Alimentos alimento= dao.save(alimentos);
        alimentosPermitidosDao.save(new AlimentosPermitidos(new AlimentosPermitidosId(),iddieta,alimento.getId(),cant));
        return alimento;
    }
    public Alimentos addAlimentosPlato(int idplato,Alimentos alimentos){
        Alimentos alimento= dao.save(alimentos);
        platoAlimentoDao.save(new PlatoAlimentosElem(new PlatoAlimentosId(),idplato,alimento.getId()));
            return alimento;
    }
}
