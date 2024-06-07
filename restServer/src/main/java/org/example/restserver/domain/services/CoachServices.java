package org.example.restserver.domain.services;

import org.example.restserver.dao.CoachDao;
import org.example.restserver.domain.model.Coach;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        Optional<Coach> coach=daoCoach.findById(Long.valueOf(id));
        if(coach.isPresent()){
            return coach.get();
        }
        return null;
    }

    public Coach findCoachByCode(String code){
        Optional<Coach> coach= daoCoach.findByCoachCode(code);
        if(coach.isPresent()){
            return coach.get();
        }
         return null;
    }
}
