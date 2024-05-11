package org.example.restserver.domain.services;

import jakarta.transaction.Transactional;
import org.example.restserver.dao.AlimentosPermitidosDao;
import org.example.restserver.dao.DietaDao;
import org.example.restserver.dao.PlatoAlimentoDao;
import org.example.restserver.dao.PlatoDao;
import org.example.restserver.domain.model.AlimentosPermitidos;
import org.example.restserver.domain.model.Dieta;
import org.example.restserver.domain.model.Plato;
import org.example.restserver.domain.model.PlatoAlimentosElem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietasServices {
    private final DietaDao dao;
    private final PlatoDao daoPlato;
    private final AlimentosPermitidosDao alimentosPermitidosDao;
    private final PlatoAlimentoDao platoAlimentoDao;
    public DietasServices(DietaDao dao, PlatoDao daoPlato, AlimentosPermitidosDao alimentosPermitidosDao, PlatoAlimentoDao platoAlimentoDao) {
        this.dao = dao;
        this.daoPlato = daoPlato;
        this.alimentosPermitidosDao = alimentosPermitidosDao;
        this.platoAlimentoDao = platoAlimentoDao;
    }
    public List<Dieta> getDietasDeCoachee(int id){
        List<Dieta> d=dao.findAllByIdcoachee(id);
        return d;
    }
     @Transactional
   public Dieta addDieta(Dieta dieta){
      Dieta dieta1=dao.save(dieta);
      for (Plato plato:dieta1.getPlatoDeDieta()){
          plato.setIddietas(dieta1.getId());
          Plato p=daoPlato.save(plato);
          for (PlatoAlimentosElem platoAlimentosElem:plato.getAlimentosPlato()){

              platoAlimentosElem.setIdplatos(p.getId());
              platoAlimentoDao.save(platoAlimentosElem);

          }

      }
        if (dieta.getAlimentosPermitidos()!=null){
            for (AlimentosPermitidos alimentosPermitidos:dieta1.getAlimentosPermitidos()){
                alimentosPermitidos.setIddietasp(dieta1.getId());
                alimentosPermitidosDao.save(alimentosPermitidos);
            }
        }



        return dieta1;
    }
}
