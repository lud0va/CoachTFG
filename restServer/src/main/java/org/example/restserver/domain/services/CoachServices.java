package org.example.restserver.domain.services;

import org.example.restserver.dao.CoachDao;
import org.example.restserver.domain.model.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServices {
    private final CoachDao daoCoach;

    public CoachServices(CoachDao daoCoach) {
        this.daoCoach = daoCoach;
    }

    public List<Coach> getAllByName(String name){
        return daoCoach.findAllByName(name);
    }
    public List<Coach> getAll(){
        return daoCoach.findAll();
    }
    public Coach getCoach(int id){
        return daoCoach.findById(Long.valueOf(id)).orElseThrow(

                //tirar excepcion
        );
    }

    public Coach findCoachByCode(String code){
        return daoCoach.findByCoachCode(code).orElseThrow(
                //tirar excepcion

        );
    }
}
