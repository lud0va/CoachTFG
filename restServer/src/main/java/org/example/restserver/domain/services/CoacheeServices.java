package org.example.restserver.domain.services;

import org.example.restserver.dao.CoacheeDao;
import org.example.restserver.domain.model.Coach;
import org.example.restserver.domain.model.Coachee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoacheeServices {
    private final CoacheeDao daoCoachee;
    private final CoachServices serv;

    public CoacheeServices(CoacheeDao daoCoachee, CoachServices serv) {
        this.daoCoachee = daoCoachee;
        this.serv = serv;
    }

    public List<Coachee> getAllByName(String name) {
        return daoCoachee.findAllByName(name);

    }
    public Coachee getByEmail(String email){
        Coachee c=daoCoachee.findByCoachEmail(email).get();
        return c;
    }

    public List<Coachee> getAllByCoach(int id) {
        return daoCoachee.findAllByIdcoach(id);

    }

    public Coachee getCoachee(int id) {
        return daoCoachee.findById(Long.valueOf(id)).orElseThrow(
                //tirar excepcion
        );

    }

    public Boolean addCoacheeToCoach(int idCoachee, String code) {
        Coachee c = daoCoachee.findById(Long.valueOf(idCoachee)).get();
        c.setIdcoach(serv.findCoachByCode(code).getId());
        daoCoachee.save(c);
        return true;
    }
}
