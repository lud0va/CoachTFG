package org.example.restserver.spring.rest;

import org.example.restserver.domain.model.Coach;
import org.example.restserver.domain.model.Coachee;
import org.example.restserver.domain.services.CoachServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
@CrossOrigin("http://localhost:4200/")
public class CoachRest {

    private final CoachServices serv;


    public CoachRest(CoachServices serv) {
        this.serv = serv;
    }

    @GetMapping()
    public List<Coach> getAll() {
        return serv.getAll();
    }
    @GetMapping("/getAllByName")
    public List<Coach> getAllByName(@RequestParam(name = "name") String  name){
       return serv.getAllByName(name);
    }

    @GetMapping("/getCaoach")
    @PreAuthorize("hasRole('coach') OR hasRole('caochee')")
    public Coach getCoach(@RequestParam(name = "id")   int id) {
        return serv.getCoach(id);
    }






    }
