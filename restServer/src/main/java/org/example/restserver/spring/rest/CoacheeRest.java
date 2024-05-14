package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Coachee;
import org.example.restserver.domain.services.CoacheeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachee")
@CrossOrigin("http://localhost:4200/")
public class CoacheeRest {
    private final CoacheeServices serv;

    public CoacheeRest(CoacheeServices serv) {
        this.serv = serv;
    }

    @GetMapping("/getAllByName")
    public List<Coachee> getAllByName(@RequestParam(name = "name") String name) {
        return serv.getAllByName(name);
    }

    @GetMapping("/getAllByCoach")
    public List<Coachee> getAllByCoach(@RequestParam(name = "idCoach") int id) {
        return serv.getAllByCoach(id);
    }

    @GetMapping("/get")
    public Coachee getCoachee(@RequestParam(name = "id") int id) {
        return serv.getCoachee(id);
    }

    @GetMapping("/insertCoacheeIntoCoach")
    public Boolean addCoacheeToCoach(@RequestParam(name = "idCoachee") int idCoachee, @RequestParam(name = "codeCoach") String code) {
        return  serv.addCoacheeToCoach(idCoachee, code);

    }


}
